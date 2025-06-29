package com.example.board_hicc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handlePostNotFound(PostNotFoundException ex) {
        Map<String, Object> error = new HashMap<>();
        error.put("status_code", 404);
        error.put("error", "POST_NOT_FOUND");
        error.put("message", "존재하지 않는 게시글입니다.");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
