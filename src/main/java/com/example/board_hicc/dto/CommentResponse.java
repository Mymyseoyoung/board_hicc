package com.example.board_hicc.dto;

import com.example.board_hicc.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponse {
    private Long id;
    private String content;
    private String username;
    private LocalDateTime createDate;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.username = "익명";
        this.createDate = comment.getCreateDate();
    }
}
