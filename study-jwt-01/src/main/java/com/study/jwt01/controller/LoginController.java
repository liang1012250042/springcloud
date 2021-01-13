package com.study.jwt01.controller;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.study.jwt01.model.AdminDO;
import com.study.jwt01.service.LoginService;

import com.study.jwt01.util.JWTUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginService loginService;

    @PostMapping("/user/login")
    public Map<String,Object> login(AdminDO adminDO){
        logger.info("用户名：{}",adminDO.getAdminName());
        logger.info("密码：{}",adminDO.getAdminPassword());
        Map<String,Object> map=new HashMap<>();
        try {
            AdminDO resultAdminDO=loginService.getAdmin(adminDO);
            Map<String,String> payload=new HashMap<>();
            payload.put("id",resultAdminDO.getId().toString());
            payload.put("adminName",resultAdminDO.getAdminName());
            String token= JWTUtils.getToken(payload);
            map.put("state",true);
            map.put("msg","认证成功");
            map.put("token",token);
        }catch (Exception e){
            map.put("state",false);
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @PostMapping("/user/test")
    public String test(){
        return "淦";
    }

}
