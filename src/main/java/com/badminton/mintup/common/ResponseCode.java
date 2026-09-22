package com.badminton.mintup.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {

    SUCCESS("C000", HttpStatus.OK, "정상적으로 처리되었습니다."),
    INTERNAL_SERVER_ERROR("C002", HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류가 발생했습니다."),
    APPLICATION_ERROR("C003", HttpStatus.INTERNAL_SERVER_ERROR, "사용자 정의 에러");

    private final String code;
    private final HttpStatus status;
    private final String message;
}
