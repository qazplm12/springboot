package com.bitc.board2.service;

import com.bitc.board2.DTO.Board2DTO;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface Board2Service {
    // 게시판 글 목록 보기
    List<Board2DTO> selectBoard2List() throws Exception; // public이 디폴트

    // 게시판 글 상세 보기
    Board2DTO openBoard2Detail(int boardIdx) throws Exception;

    // 게시판 글 등록
    void insertBoard2(Board2DTO board) throws Exception;

    // 게시판 글 수정
    void updateBoard2(Board2DTO board) throws Exception;

    // 게시판 글 삭제
    void deleteBoard2(int boardIdx) throws Exception;

}
