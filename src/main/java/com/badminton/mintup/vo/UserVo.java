package com.badminton.mintup.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
public class UserVo {

    @Data
    @Accessors(chain = true)
    public static class UserInfoVo {
        private String userId;           // 사용자 ID
        private String email;            // 사용자 로그인 이메일
        private String nickname;         // 사용자 닉네임
        private String mphonNo;          // 사용자 휴대폰 번호
        @JsonIgnore
        private String password;         // 사용자 비밀번호
    }

    @Data
    @Accessors(chain = true)
    public static class SignUpReqVo {
        private String email;            // 사용자 로그인 이메일
        private String nickname;         // 사용자 닉네임
        private String mphonNo;          // 사용자 휴대폰 번호
        private String password;         // 사용자 비밀번호
        @JsonIgnore
        private int userId;              // 사용자 ID
    }

    @Data
    public static class UpdatePasswordReqVo {
        @JsonIgnore
        private int userId;
        private String password;         // 사용자 비밀번호
    }

    @Data
    public static class EmailExistsReqVo {
        private String email;
    }
}
