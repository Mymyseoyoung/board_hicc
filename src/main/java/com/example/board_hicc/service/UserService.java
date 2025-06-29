package com.example.board_hicc.service;

import com.example.board_hicc.dto.UserRequestDto;
import com.example.board_hicc.entity.User;
import com.example.board_hicc.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser(UserRequestDto dto) {
        User user = User.builder()
                .email(dto.getEmail())
                .nickname(dto.getNickname())
                .password(dto.getPassword())
                .build();

        return userRepository.save(user);
    }
}
