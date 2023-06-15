package com.bitc.board2.controller;


import com.bitc.board2.DTO.Board2DTO;
import com.bitc.board2.DTO.UserDTO;
import com.bitc.board2.service.Board2Service;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/board2")
public class Board2Controller {

    @Autowired
    private Board2Service board2Service;

    @GetMapping("/")
    public String index() throws Exception {

        return "index";
    }

    @RequestMapping("board2List.do")
    public ModelAndView board2List() throws Exception {
        ModelAndView mv = new ModelAndView("board2/board2List");


        List<Board2DTO> boardList = board2Service.selectBoard2List();

        mv.addObject("boardList", boardList);

        return mv;
    }


    @RequestMapping("/openBoard2Detail.do")
    public ModelAndView openBoard2Detail(@RequestParam int boardIdx, HttpServletRequest req) throws Exception {
        ModelAndView mv = new ModelAndView("board2/openBoard2Detail");

        Board2DTO board = board2Service.openBoard2Detail(boardIdx);

        // 세션에 로그인 정보가 없을 경우 디테일 페이지를 확인할 수 없도록 설정
        HttpSession session = req.getSession();

        // 가져온 정보를 사용하여 UserDTO 클래스 타입의 객체를 생성
        String userName = session.getAttribute("userName").toString();

        // 생성한 UserDTO 클래스 타입의 객체의 내용이 비었으면 View 파일을 변경
        if (userName == null || userName.equals("")) {
            mv.setViewName("login/login");
        }

        mv.addObject("board", board);

        return mv;
    }
}
