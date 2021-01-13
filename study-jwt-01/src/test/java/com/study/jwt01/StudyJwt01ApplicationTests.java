package com.study.jwt01;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.HashMap;

@SpringBootTest
class StudyJwt01ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test01(){
		//HashMap<String,Object> map=new HashMap<>();

		Calendar instance=Calendar.getInstance();
		instance.add(Calendar.HOUR,1);

		String token = JWT.create()
		//		.withHeader(map) //header
				.withClaim("userId",21) //payload
				.withClaim("userName","良")
				.withExpiresAt(instance.getTime()) //指定令牌过期时间
				.sign(Algorithm.HMAC256("！@#￥%……")); //签名

		System.out.println(token);
	}

	@Test
	public void test02(){
		/**
		 * SignatureVerificationException	签名不一致异常
		 * TokenExpiredException	令牌过期异常
		 * AlgorithmMismatchException	算法不匹配异常
		 * InvalidClaimException	失效的payload异常
		 * */
		//创建解码对象
		JWTVerifier jwtVerifier=JWT.require(Algorithm.HMAC256("！@#￥%……")).build();
		DecodedJWT decodedJWT=jwtVerifier.verify("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyTmFtZSI6IuiJryIsImV4cCI6MTYxMDUyMDQ4OSwidXNlcklkIjoyMX0.PDj4tCFn4X4ZxoPxH6Tr8jtL1Yx2GD2mi0MYEebzC4E");
		System.out.println(decodedJWT.getClaim("userId").asLong());
		System.out.println(decodedJWT.getClaim("userName").asString());
		System.out.println("过期时间："+decodedJWT.getExpiresAt());
	}

}
