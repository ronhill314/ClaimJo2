package com.ElectrifyDealer.Config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration

@EntityScan(basePackages = "com.ElectrifyDealer.Entity")

@EnableJpaRepositories(basePackages = "com.ElectrifyDealer.Repo")

public class ApplicationConfig {
    
}
