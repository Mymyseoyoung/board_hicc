package com.example.board_hicc.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    //@ManyToOne
   // @JoinColumn(name = "user_id")  // DB에 저장될 외래키 이름
   // private User user;
    private LocalDateTime createDate;
    @PrePersist
    public void onCreate() {
        this.createDate = LocalDateTime.now();
    }
}
