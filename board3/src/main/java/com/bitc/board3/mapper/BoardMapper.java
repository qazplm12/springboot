package com.bitc.board3.mapper;

import com.bitc.board3.DTO.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<BoardDTO> selectBoardList() throws Exception;

    // 게시물 상세 내용 출력
    BoardDTO selectBoardDetail(int boardIdx) throws Exception;

    // 게시물 등록
    void insertBoard(BoardDTO board) throws Exception;

    // 게시물 수정
    void updateBoard(BoardDTO board) throws Exception;

    // 게시물 삭제
    void deleteBoard(int boardIdx) throws Exception;

    void updateHitCount(int boardIdx) throws Exception;
}
