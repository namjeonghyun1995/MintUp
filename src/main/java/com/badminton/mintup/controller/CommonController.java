package com.badminton.mintup.controller;

import com.badminton.mintup.vo.CommonResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/common")
public class CommonController {


    @GetMapping(path = "mintUp")
    public CommonResponse<String> mintUp(){
        return CommonResponse.success("mintUp success");
    }
}
