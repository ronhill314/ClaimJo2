package com.ElectrifyDealer.Electro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan (basePackages = "com.ElectrifyDealer")
public class ElectroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectroApplication.class, args);
	}

}
