package com.bitc.testboard.configuration;

import com.bitc.testboard.service.MemberDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfiguration {

    private final MemberDetailService memberDetailService;

    // 스프링 시큐리티에서는 무조건 암호화된 비밀번호를 사용해야 함
    // 비밀번호 인코더 사용 설정
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // 스프링 시큐리티 설정 무시 항목 추가
    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring()
                .requestMatchers("/static/**");
    }

    // 스프링 시큐리티 필터 설정
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // authorizeRequest() : 인증 목록 설정
        // requestMatchers(url) : 사용자 요청 주소 매핑
        // permitAll() : 모든 권한 허용
        // anyRequest() : 모든 요청, 마지막에 있어야함
        // authenticated() : 권한 인증 필요

        // and() : 추가 옵션 설정 시 사용
        // formLogin() : 로그인 폼 화면 사용
        // loginPage(url) : 사용자 지정 로그인 화면 url 설정
        // defaultSuccessUrl(url) : 로그인 성공 시 출력할 화면 url 설정
        // logout(url) : 로그아웃 사용 여부
        // logoutSuccessUrl(url) : 로그아웃 성공 시 출력할 화면 url 설정
        // invalidateHttpSession() : 모든 세션정보 삭제
        // csrf().disable() : 사용자 권한 탈취 공격 방어 사용 안함
        // cors().disable() :
        return http
                .authorizeRequests()
                .requestMatchers("/home", "/signup", "/member").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/home")
                .defaultSuccessUrl("/home")
                .and()
                .logout()
                .logoutSuccessUrl("/home")
                .invalidateHttpSession(true)
                .and().csrf().disable()
//                .cors().disable()
                .build();

    }
    // 사용자 권한 인증 관리자 설정
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder, MemberDetailService memberDetailService) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                // 스프링 시큐리티에서 제공하는 UserDetailsService 인터페이스를 구현한 UserDetailService 클래스의 객체를 매개변수로 사용
                // 데이터베이스에 있는 사용자 정보를 가져와서 사용 권한 인증 관리자에 넘겨줌
                .userDetailsService(memberDetailService)
                .passwordEncoder(bCryptPasswordEncoder)
                .and()
                .build();
    }


}
