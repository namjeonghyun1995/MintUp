package com.badminton.mintup.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ResponseCode {

    SUCCESS("C000", HttpStatus.OK, "정상적으로 처리되었습니다."),
    INVALID_PARAMETER("C001", HttpStatus.BAD_REQUEST, "잘못된 요청입니다."),
    UNAUTHORIZED("C002", HttpStatus.UNAUTHORIZED, "인증이 필요합니다."),
    FORBIDDEN("C003", HttpStatus.FORBIDDEN, "접근 권한이 없습니다."),
    NOT_FOUND("C004", HttpStatus.NOT_FOUND, "요청한 리소스를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR("C999", HttpStatus.INTERNAL_SERVER_ERROR, "서버 오류가 발생했습니다.");

    private final String code;
    private final HttpStatus status;
    private final String message;
}
