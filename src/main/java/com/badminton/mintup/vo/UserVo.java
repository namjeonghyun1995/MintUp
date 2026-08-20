package com.badminton.mintup.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
public class UserVo {

    @Data
    @Accessors(chain = true)
    public static class UserInfoVo {
        private String userId;           // 사용자 ID
        private String email;            // 사용자 로그인 ID
        private String nickname;         // 사용자 닉네임
        private String mphonNo;          // 사용자 휴대폰 번호
        @JsonIgnore
        private String password;         // 사용자 비밀번호
    }
}
