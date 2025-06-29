package com.example.board_hicc.repository;

import com.example.board_hicc.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
