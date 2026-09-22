package com.badminton.mintup.common;

import lombok.Data;

@Data
public class Response {

    String result;
    String message;
    Object data;

    public Response(){
        this.result = ResponseCode.SUCCESS.getCode();
        this.message = ResponseCode.SUCCESS.getMessage();
    }

    public Response(Object data){
        this.result = ResponseCode.SUCCESS.getCode();
        this.message = ResponseCode.SUCCESS.getMessage();
        this.data = data;
    }

    public Response(String result, String message, Object data){
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public Response(String result, String message){
        this.result = result;
        this.message = message;
        this.data = data;
    }
}
