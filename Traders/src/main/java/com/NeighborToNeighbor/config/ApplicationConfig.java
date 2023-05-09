package com.NeighborToNeighbor.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration

@EnableJpaRepositories(basePackages = "com.NeighborToNeighbor.repo")

@EntityScan(basePackages = "com.NeighborToNeighbor.entity")
public class ApplicationConfig {
    
}
