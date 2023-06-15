package com.bitc.board2.DTO;

import lombok.Data;


// 데이터베이스의 user 테이블의 데이터를 주고 받기 위한 DTO 클래스

@Data
public class UserDTO {
    private String userId;
    private String userPw;
    private String userName;
    private String userEmail;
}
