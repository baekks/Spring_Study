package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

// 엔티티 클래스명, 기본키의 타입
public interface BoardRepository extends JpaRepository<Board, Long> {
}
