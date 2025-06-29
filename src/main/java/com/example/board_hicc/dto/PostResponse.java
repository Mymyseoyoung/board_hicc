package com.example.board_hicc.dto;

import com.example.board_hicc.entity.Post;
import lombok.Getter;

@Getter
public class PostResponse {

    private final Long id;
    private final String title;
    private final String content;
    private final String create_date;

    public PostResponse(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.create_date = post.getCreateDate().toLocalDate().toString();
    }
}
