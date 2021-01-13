package com.study.jwt01.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;


import java.util.Calendar;
import java.util.Map;

public class JWTUtils {

    private static final String SIGN="c1012250042";

    /**
     * 生成Token header.payload.sing
     * */
    public static String getToken(Map<String,String> map){
        Calendar instance=Calendar.getInstance();
        instance.add(Calendar.HOUR,1);
        JWTCreator.Builder builder = JWT.create();
        //payload 创建 jwt builder
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        String token = builder.withExpiresAt(instance.getTime())//指定过期时间
                .sign(Algorithm.HMAC256(SIGN)); //签名;
        return token;
    }

    /**
     * 验证token
     * */
    public static DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
    }

//    /**
//     * 获取token信息
//     * */
//    public static DecodedJWT getTokenInfo(String token){
//        DecodedJWT decodedJWT=JWT.require(Algorithm.HMAC256(SIGN)).build().verify(token);
//        return decodedJWT;
//    }
}
