package com.Electrify.Electrify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.Electrify")
public class ElectrifyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectrifyApplication.class, args);
	}

}
