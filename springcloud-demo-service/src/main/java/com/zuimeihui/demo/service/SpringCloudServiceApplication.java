package com.zuimeihui.demo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 程序入口
 * 
 * @ClassName: DemoServiceApplication
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServiceApplication.class, args);
	}

}
