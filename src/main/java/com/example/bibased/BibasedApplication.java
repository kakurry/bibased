package com.example.bibased;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = "com.example.bibased.dao")
public class BibasedApplication {
	public static void main(String[] args) {
		SpringApplication.run(BibasedApplication.class, args);
		System.out.println("ggjtyjtaadf");
	}
}
