package com.study.jwt01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.study.jwt01.dao")
public class StudyJwt01Application {

	public static void main(String[] args) {
		SpringApplication.run(StudyJwt01Application.class, args);
	}

}
