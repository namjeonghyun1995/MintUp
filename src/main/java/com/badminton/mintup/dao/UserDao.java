package com.badminton.mintup.dao;

import com.badminton.mintup.vo.UserVo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public int getUserId(String email);
    public UserInfoVo userInfo(int userId);
}
