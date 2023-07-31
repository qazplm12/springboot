package com.bitc.springboard_sws.controller;


import com.bitc.springboard_sws.DTO.BoardDTO;
import com.bitc.springboard_sws.service.BoardService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/boardList")
    public ModelAndView doBoardList() throws Exception {
        ModelAndView mv = new ModelAndView("board/boardList");

        List<BoardDTO> boardList = boardService.selectBoardList();

        mv.addObject("boardList", boardList);
        return mv;
    }

    @RequestMapping("/boardDetail/{boardIdx}")
    public ModelAndView doBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
        ModelAndView mv = new ModelAndView("board/boardDetail");

        BoardDTO board = boardService.selectBoardDetail(boardIdx);

        mv.addObject("board", board);

        return mv;
    }

    @GetMapping(value = "/boardWrite")
    public String doBoardWriteView() throws Exception {

        return "board/boardWrite";
    }

    @PostMapping(value = "/boardWrite")
    public String doBoardWriteProcess(
            @Param("title") String title,
            @Param("content") String content,
            @Param("createId") String createId) throws Exception {

        boardService.writeBoard(title, content, createId);

        return "redirect:/board/boardList";
    }

    @PostMapping(value = "/boardEdit")
    public ModelAndView doBoardEditView(@Param("board")String board) throws Exception {

        ModelAndView mv = new ModelAndView("board/boardEdit");


        mv.addObject("board", board);

        return mv;
    }


}
