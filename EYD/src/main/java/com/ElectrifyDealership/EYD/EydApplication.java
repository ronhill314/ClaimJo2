package com.ElectrifyDealership.EYD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = "com.Eyd")
public class EydApplication {

	public static void main(String[] args) {
		SpringApplication.run(EydApplication.class, args);
	}

}
