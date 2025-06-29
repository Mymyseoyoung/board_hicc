package com.example.board_hicc.repository;

import com.example.board_hicc.entity.Comment;
import com.example.board_hicc.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
