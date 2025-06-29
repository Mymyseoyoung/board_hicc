package com.example.board_hicc.controller;

import com.example.board_hicc.dto.PostRequest;
import com.example.board_hicc.dto.PostResponse; // 상세 응답용 DTO
import com.example.board_hicc.entity.Post;
import com.example.board_hicc.entity.User;
import com.example.board_hicc.repository.PostRepository;
import com.example.board_hicc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.board_hicc.exception.PostNotFoundException;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    // 게시글 생성 API
    @PostMapping
    public ResponseEntity<Map<String, String>> createPost(@RequestBody PostRequest request) {
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();


        postRepository.save(post);

        Map<String, String> response = new HashMap<>();
        response.put("message", "성공적으로 등록됐습니다.");

        return ResponseEntity.ok(response);
    }
    // 전체 게시글 목록 조회 API
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllPosts() {
        var postList = postRepository.findAll();

        var postResponses = postList.stream().map(post -> {
            Map<String, Object> postMap = new HashMap<>();
            postMap.put("id", post.getId());
            postMap.put("title", post.getTitle());
            postMap.put("content", post.getContent());
            postMap.put("create_date", post.getCreateDate().toLocalDate().toString());
            return postMap;
        }).toList();

        Map<String, Object> response = new HashMap<>();
        response.put("posts", postResponses);

        return ResponseEntity.ok(response);
    }


    // 게시글 상세 조회 API

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException(id));  // 바뀐 부분!

        return ResponseEntity.ok(new PostResponse(post));
    }
}
