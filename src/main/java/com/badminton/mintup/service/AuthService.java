package com.badminton.mintup.service;

import com.badminton.mintup.dao.AuthDao;
import com.badminton.mintup.vo.AuthVo.LoginReqVo;
import com.badminton.mintup.vo.UserVo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthDao authDao;

}
