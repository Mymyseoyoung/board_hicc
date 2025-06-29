package com.example.board_hicc.repository;

import com.example.board_hicc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
