package com.example.board_hicc.controller;

import com.example.board_hicc.repository.UserRepository;

import com.example.board_hicc.dto.UserRequestDto;
import com.example.board_hicc.entity.User;
import com.example.board_hicc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    private final UserRepository userRepository;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserRequestDto dto) {
        User createdUser = userService.createUser(dto);
        return ResponseEntity.ok(createdUser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 유저 없음: id = " + id));
        return ResponseEntity.ok(user);
    }

}
