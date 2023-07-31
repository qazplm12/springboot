package com.bitc.springboard_sws.service;

import com.bitc.springboard_sws.DTO.BoardDTO;
import com.bitc.springboard_sws.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDTO> selectBoardList() throws Exception {

        return boardMapper.selectBoardList();
    }

    @Override
    public BoardDTO selectBoardDetail(int boardIdx) throws Exception {

        boardMapper.updateHitCount(boardIdx);
        return boardMapper.selectBoardDetail(boardIdx);
    }

    @Override
    public void writeBoard(String title, String content, String createId) throws Exception {
        boardMapper.writeBoard(title, content, createId);
    }

}
