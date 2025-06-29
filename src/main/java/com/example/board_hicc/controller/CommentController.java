package com.example.board_hicc.controller;

import com.example.board_hicc.dto.CommentRequest;
import com.example.board_hicc.dto.CommentResponse;
import com.example.board_hicc.entity.Comment;
import com.example.board_hicc.entity.Post;
import com.example.board_hicc.entity.User;
import com.example.board_hicc.repository.CommentRepository;
import com.example.board_hicc.repository.PostRepository;
import com.example.board_hicc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import com.example.board_hicc.exception.PostNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts/{postId}/comment")
public class CommentController {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 1. 댓글 전체 조회

    @GetMapping
    public ResponseEntity<List<CommentResponse>> getComments(@PathVariable Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId));  // 여기에 예외

        List<CommentResponse> comments = commentRepository.findByPost(post)
                .stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());

        return ResponseEntity.ok(comments);
    }


    // 2. 댓글 작성
    @PostMapping
    public ResponseEntity<Map<String, String>> createComment(
            @PathVariable Long postId,
            @RequestBody CommentRequest request) {

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new PostNotFoundException(postId)); // ← 커스텀 예외로 변경

        Comment comment = Comment.builder()
                .content(request.getContent())
                .post(post)
                .build();

        commentRepository.save(comment);

        Map<String, String> response = new HashMap<>();
        response.put("message", "성공적으로 등록됐습니다.");

        return ResponseEntity.ok(response);
    }

}
