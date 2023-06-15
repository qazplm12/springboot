package com.bitc.board2.service;

import com.bitc.board2.DTO.Board2DTO;
import com.bitc.board2.mapper.Board2Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


// @Service : 해당 클래스가 상속받은 interface 이름으로 동작하도록 설정하는 어노테이션
@Service
public class Board2ServiceImpl implements Board2Service {

    // Board2Mapper 인터페이스 타입의 변수 선언
    @Autowired
    private Board2Mapper boardMapper;


    // 부모인 BoardService에서 상속받은 메소드를 구현
    @Override
    public List<Board2DTO> selectBoard2List() throws Exception {

        // Board2Mapper 인터페이스에서 제공하는 메소드를 실행
        return boardMapper.selectBoard2List();
    }

    // 게시판 글 상세 보기
    // 해당 게시글에 첨부된 첨부파일 목록도 함께 불러옴
    @Override
    public Board2DTO openBoard2Detail(int boardIdx) throws Exception {
        // 1. 컨트롤러에서 전달된 게시물 번호 가져오기
        // 2. mapper를 사용하여 DB에서 지정한 게시물 정보 가져오기
        // 3. mapper를 사용하여 DB에서 지정한 게시물 정보 가져오기
        // 4. mapper를 사용하여 DB에서 지정한 게시물에 첨부된 첨부파일 목록 가져오기
        // 5. 가져온 파일 목록 Board2DTO 타입에 저장
        // 6. 저장된 정보를 컨트롤러로 리턴


        // 전달받은 게시물 번호를 사용하여 mybatis mapper의 updateHicCount() 메소드를 실행
        boardMapper.updateHitCount(boardIdx);

        // 전달받은 게시물 번호를 사용하여 mybatis mapper의 selectBoardDetail() 메소드를 실행
        // 조회된 정보를 Board2DTO 클래스 타입의 변수에 대입
        Board2DTO board = boardMapper.openBoard2Detail(boardIdx);

        // 첨부파일 목록 가져오기
        // 저장된 정보를 컨트롤러로 리턴
        return board;
    }

    @Override
    public void insertBoard2(Board2DTO board) throws Exception {

    }

    // 게시판 글 수정
    @Override
    public void updateBoard2(Board2DTO board) throws Exception {
        // 1. 컨트롤러에서 전달된 데이터 가져오기
        // 2. mapper를 사용하여 DB의 데이터 수정하기

        // 전달받은 데이터를 매개변수로 사용하여 mybatis mapper의 updateBoard() 메소드를 실행
        boardMapper.updateBoard2(board);
    }

    @Override
    public void deleteBoard2(int boardIdx) throws Exception {
        // 1. 컨트롤러에서 전달된 게시물 번호 가져오기
        // 2. mapper를 사용하여 DB의 게시물 삭제

        // 전달받은 게시물 번호를 매개변수로 사용하여 mybatis mapper의 deleteBoard() 메소드를 실행
        boardMapper.deleteBoard2(boardIdx);
    }

}
