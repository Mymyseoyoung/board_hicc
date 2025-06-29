package com.example.board_hicc.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import jakarta.persistence.PrePersist;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String content;

   // @ManyToOne
   // @JoinColumn(name = "user_id")
   // private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    private LocalDateTime createDate;

    @PrePersist
    public void onCreate() {
        this.createDate = LocalDateTime.now();
    }
}
