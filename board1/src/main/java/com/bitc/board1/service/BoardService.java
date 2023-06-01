package com.bitc.board1.service;

import com.bitc.board1.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> selectBoardList() throws Exception; // public이 디폴트
}
