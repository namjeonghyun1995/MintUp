package com.badminton.mintup.service;

import com.badminton.mintup.dao.UserDao;
import com.badminton.mintup.vo.AuthVo.LoginReqVo;
import com.badminton.mintup.vo.UserVo.UserInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserInfoVo getUserInfo(LoginReqVo params){
        return userDao.userInfo(userDao.getUserId(params.getEmail()));
    }
}
