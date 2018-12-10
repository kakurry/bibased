package com.example.bibased;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
@EnableCaching
@SpringBootApplication
@MapperScan(value = "com.example.bibased.dao")
public class BibasedApplication {
	public static void main(String[] args) {
		SpringApplication.run(BibasedApplication.class, args);
		System.out.println("ggjtyjtaadf");
	}
}
