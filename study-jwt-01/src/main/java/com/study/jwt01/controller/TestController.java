package com.study.jwt01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class TestController {

    @GetMapping("/test/test")
    public String test(String userName, HttpServletRequest request){
        //认证成功 放入session
        request.getSession().setAttribute("userName",userName);
        return "login ok";
    }
}
