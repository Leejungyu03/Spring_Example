package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@MapperScan(basePackages = "com.example.*") // mapper scan 추가!!!
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) DB 없을 때
@SpringBootApplication
@ComponentScan(basePackages = "com.example")
public class SpringExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExampleApplication.class, args);
	}


}