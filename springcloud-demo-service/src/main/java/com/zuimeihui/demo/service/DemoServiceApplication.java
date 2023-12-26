package com.zuimeihui.demo.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 程序入口
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-18 10:37:30
 */
@SpringBootApplication
@EnableDiscoveryClient
public class DemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceApplication.class, args);
	}
	
}
