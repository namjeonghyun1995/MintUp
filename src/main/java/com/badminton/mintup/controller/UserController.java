package com.badminton.mintup.controller;

import com.badminton.mintup.common.Response;
import com.badminton.mintup.service.UserService;
import com.badminton.mintup.vo.UserVo.EmailExistsReqVo;
import com.badminton.mintup.vo.UserVo.SignUpReqVo;
import com.badminton.mintup.vo.UserVo.UpdatePasswordReqVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    // 회원가입
    @PostMapping(path = "/signUp")
    @ResponseBody
    public Response signUp(@RequestBody SignUpReqVo params) throws Exception {
        return userService.signUp(params);
    }

    // 이메일 중복 검사
    @PostMapping(path = "/emailExists")
    @ResponseBody
    public Response emailExists(@RequestBody EmailExistsReqVo params) throws Exception {
        return userService.emailExists(params);
    }

    // 인증번호 검증
    @PostMapping(path = "/otp")
    @ResponseBody
    public Response otp() throws Exception {
        return new Response();
    }

    // 비밀번호 변경
    @PostMapping(path = "/updatePassword")
    @ResponseBody
    public Response updatePassword(HttpServletRequest httpRequest, @RequestHeader(value = "userId") int userId, @RequestBody UpdatePasswordReqVo params) {
        params.setUserId(userId);
        return userService.updatePassword(params);
    }
}
