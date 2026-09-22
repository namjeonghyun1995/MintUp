package com.badminton.mintup.service;

import com.badminton.mintup.Enum.RegexType;
import com.badminton.mintup.common.RegexUtil;
import com.badminton.mintup.common.Response;
import com.badminton.mintup.common.ResponseCode;
import com.badminton.mintup.dao.UserDao;
import com.badminton.mintup.vo.AuthVo.LoginReqVo;
import com.badminton.mintup.vo.UserVo.SignUpReqVo;
import com.badminton.mintup.vo.UserVo.UpdatePasswordReqVo;
import com.badminton.mintup.vo.UserVo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RegexUtil regexUtil;

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserInfoVo getUserInfo(LoginReqVo params) {
        return userDao.userInfo(userDao.getUserId(params.getEmail()));
    }

    public Response signUp(SignUpReqVo params) throws Exception {

        // 이메일 유효성 검증
        if (!regexUtil.regex(RegexType.EMAIL, params.getEmail())) {
            return new Response(ResponseCode.APPLICATION_ERROR.getCode(), "이메일 형식이 올바르지 않습니다. 다시 확인해주세요.");
        }

        // 이메일 중복 검사
        if (userDao.getEmailExists(params.getEmail()) > 0) {
            return new Response(ResponseCode.APPLICATION_ERROR.getCode(), "중복된 이메일입니다. 다른 이메일을 입력해주세요.");
        }

        // 회원가입
        params.setPassword(passwordEncoder.encode(params.getPassword()));
        if (userDao.signUp(params) <= 0) {
            return new Response(ResponseCode.APPLICATION_ERROR.getCode(), "회원가입 중 오류가 발생했습니다. 관리자에게 문의 바랍니다.");
        }

        return new Response(userDao.userInfo(params.getUserId()));
    }

    public Response updatePassword(UpdatePasswordReqVo params) {
        params.setPassword(passwordEncoder.encode(params.getPassword()));
        if (userDao.updatePassword(params) <= 0) {
            return new Response(ResponseCode.APPLICATION_ERROR.getCode(), "비밀번호 변경 중 오류가 발생했습니다. 관리자에게 문의 바랍니다.");
        }
        return new Response();
    }
}
