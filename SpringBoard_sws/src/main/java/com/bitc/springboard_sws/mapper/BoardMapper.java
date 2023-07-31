package com.bitc.springboard_sws.mapper;

import com.bitc.springboard_sws.DTO.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDTO> selectBoardList() throws Exception;

    BoardDTO selectBoardDetail(int boardIdx)throws Exception;

    void updateHitCount(int boardIdx)throws Exception;

    void writeBoard(String title, String content, String createId) throws Exception;
}
