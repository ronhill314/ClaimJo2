package com.NeighborToNeighbor.Traders;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

@ComponentScan(basePackages = "com.NeighborToNeighbor")
public class TradersApplication {

	public static void main(String[] args) {
		SpringApplication.run(TradersApplication.class, args);
	}

}
