package com.bitc.board2.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;


// Interceptor를 사용하기 위해서 HandlerInterceptor 인터페이스를 상속받음
public class LoginCheck implements HandlerInterceptor {
    // preHandle() : 지정한 컨트롤러가 동작되기 이전에 먼저 수행됨
    // postHandle() : 지정한 컨트롤러가 동작 후 View가 동작되기 전에 수행됨
    // afterHandle() : 모든 동작이 완료된 후 수행됨

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        HttpSession session = req.getSession();

        // 화면 출력용
        System.out.println("======== Interceptor 동작 =========");
        // 세션에 저장된 정보 가져오기
        String userId = (String) session.getAttribute("userId");
        System.out.println(userId);

        // 세션 정보로 로그인 상태 홧인
        if (userId == null || userId.equals("")) {
            // 비 로그인 상태
            System.out.println("\n***** Interceptor *****");
            System.out.println("비 로그인 상태");
            System.out.println((String) session.getAttribute("userId"));

            // 로그인 페이지로 리다이렉트
            resp.sendRedirect("../login/login.do");
            // 인터셉터를 통과하지 못했으므로 false를 리턴
            return false;
        } else {
            // 로그인 상태
            System.out.println("\n***** Interceptor *****");
            System.out.println("로그인 상태");
            // 세션 사용 시간을 초기화
            session.setMaxInactiveInterval(60);

            return true;
        }


    }
}
