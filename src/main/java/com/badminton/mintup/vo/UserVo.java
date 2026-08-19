package com.badminton.mintup.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
public class UserVo {

    @Data
    @Accessors(chain = true)
    public static class UserInfoVo {
        private Long id;                 // 사용자 고유 ID
        private String userId;           // 사용자 로그인 ID
        private String password;         // 사용자 비밀번호
        private String nickname;         // 사용자 닉네임
        private String email;            // 사용자 이메일 주소
        private String phoneNo;          // 사용자 휴대폰 번호
        private Date regDt;              // 등록 일시
        private Date corrDt;             // 수정 일시
        private Long regrId;             // 등록자 ID
        private Long amdId;              // 수정자 ID
    }
}
