package com.springcloud.server;

import com.springcloud.config.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClient(name = "nacos-client", configuration = MyselfRule.class)
public class NacosServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosServerApplication.class, args);
	}

}
