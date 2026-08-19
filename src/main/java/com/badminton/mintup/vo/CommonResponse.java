package com.badminton.mintup.vo;

import com.badminton.mintup.common.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommonResponse<T> {

    private String code;
    private String message;
    private T data;

    public static <T> CommonResponse<T> success(T data) {
        return new CommonResponse<>(
                ResponseCode.SUCCESS.getCode(),
                ResponseCode.SUCCESS.getMessage(),
                data
        );
    }

    public static CommonResponse<Void> success() {
        return new CommonResponse<>(
                ResponseCode.SUCCESS.getCode(),
                ResponseCode.SUCCESS.getMessage(),
                null
        );
    }

    public static <T> CommonResponse<T> success(ResponseCode responseCode, T data) {
        return new CommonResponse<>(
                responseCode.getCode(),
                responseCode.getMessage(),
                data
        );
    }

    public static <T> CommonResponse<T> fail(ResponseCode responseCode) {
        return new CommonResponse<>(
                responseCode.getCode(),
                responseCode.getMessage(),
                null
        );
    }
}