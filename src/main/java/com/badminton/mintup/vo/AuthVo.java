package com.badminton.mintup.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class AuthVo {

    @Data
    @Accessors(chain = true)
    public static class LoginReqVo {
        private String email;           // 사용자 로그인 ID
        private String password;         // 사용자 비밀번호
    }
}
