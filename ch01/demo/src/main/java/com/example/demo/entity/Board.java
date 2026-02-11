package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;                // 글 번호

    @Column(nullable = false)
    private String title;           // 글 제목

    @Column(nullable = false, length = 2000)
    private String content;         // 글 내용

    @Column(nullable = false)
    private String writer;          // 글쓴이

    private LocalDateTime createAt; // 글 작성 시간

    @PrePersist
    public void prePersist() {
        this.createAt = LocalDateTime.now();
    }
}
