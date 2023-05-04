package com.OnePercenterTravel.Config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Enable your project to use config annotations to help configure stuff
@Configuration
//You must give the base packages of your entity folder, then spring
// will be able to scan and male beans of them.
@EntityScan (basePackages = "com.OnePercenterTravel.Entity")
//This Enables your spring project to scan your repo
// you give the base packages of where all your repo lives
//it will alllow spring to make beans of them
@EnableJpaRepositories (basePackages = "com.OnePercenterTravel.Repo")
public class ApplicationConfig {
    
}
