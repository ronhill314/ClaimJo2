package com.SallysBottomBarrell.Sallys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = "com.SallysBottomBarrell")
public class SallysApplication {

	public static void main(String[] args) {
		SpringApplication.run(SallysApplication.class, args);
	}

}
