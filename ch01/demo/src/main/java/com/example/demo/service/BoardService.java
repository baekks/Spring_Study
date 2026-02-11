package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor    // 반드시 생성자로 주입
public class BoardService {

    private final BoardRepository boardRepository;

    // 게시판 목록
    public List<Board> findAll() {
        return boardRepository.findAll();
    }

    // 게시글 상세보기
    public Board findById(Long id) {
        return boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));
    }

    // 글 쓰기
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    // 글 삭제
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }

    // 게시글 갯수
    public long count() {
        return boardRepository.count();
    }

}
