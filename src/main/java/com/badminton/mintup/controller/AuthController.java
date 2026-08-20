package com.badminton.mintup.controller;

import com.badminton.mintup.service.UserService;
import com.badminton.mintup.vo.AuthVo.LoginReqVo;
import com.badminton.mintup.vo.CommonResponse;
import com.badminton.mintup.vo.UserVo.UserInfoVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    @Autowired
    private SecurityContextRepository securityContextRepository;

    @Autowired
    private UserService userService;

    @PostMapping(path = "/login")
    public CommonResponse<UserInfoVo> login(@RequestBody LoginReqVo params, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
        /**
         * UserDetails              :사용자 정보
         * Spring Security 순서
         * UsernamePasswordAuthenticationToken : 인증 객체에 userId, password 저장 (인증 요청/인증 결과를 담는 통신 객체)
         * AuthenticationManager    : 인증 시작
         * AuthenticationProvider   : 실제 인증 처리 담당(로그인에 제출된 인증 정보가 유효한지 확인해서 인증된 Authentication을 만들어주는 역할)
         * UserDetailsService       : DB에서 사용자 정보 가져와 검증
         * PasswordEncoder          : 입력 비밀번호와 DB 비밀번호 검증(provider를 따로 작성하지 않았다면 기본적으로 실행됌)
         * Authentication           : 인증 성공 결과
         * SecurityContext          : 인증 결과를 담아두는 곳
         */
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(params.getEmail(), params.getPassword()));
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authentication);
        SecurityContextHolder.setContext(context);
        //인증 정보를 다음 요청에서도 사용할 수 있도록 저장
        securityContextRepository.saveContext(context, httpRequest, httpResponse);
        return CommonResponse.success(userService.getUserInfo(params));
    }
}
