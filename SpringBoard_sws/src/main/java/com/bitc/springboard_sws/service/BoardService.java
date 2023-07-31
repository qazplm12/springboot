package com.bitc.springboard_sws.service;

import com.bitc.springboard_sws.DTO.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> selectBoardList() throws Exception;

    BoardDTO selectBoardDetail(int boardIdx) throws Exception;

    void writeBoard(String title, String content, String createId) throws Exception;
}
