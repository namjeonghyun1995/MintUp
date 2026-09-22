package com.badminton.mintup.dao;

import com.badminton.mintup.vo.UserVo.SignUpReqVo;
import com.badminton.mintup.vo.UserVo.UpdatePasswordReqVo;
import com.badminton.mintup.vo.UserVo.UserInfoVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    public int getUserId(String email);
    // 사용자 정보 조회
    public UserInfoVo userInfo(int userId);
    // 이메일 중복 조회
    public int getEmailExists(String email);
    // 회원가입
    public int signUp(SignUpReqVo params);
    // 비밀번호 변경
    public int updatePassword(UpdatePasswordReqVo params);
}
