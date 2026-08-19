package com.badminton.mintup.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/common")
public class CommonController {


    @GetMapping(path = "mintUp")
    public String mintUp(){
        return "success mintUp";
    }
}
