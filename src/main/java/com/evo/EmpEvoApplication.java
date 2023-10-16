package com.evo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import jakarta.persistence.Entity;

@SpringBootApplication(scanBasePackages = "com.evo")
@EnableJpaRepositories("com.evo.repositories")
@EntityScan("com.evo.entities")
public class EmpEvoApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpEvoApplication.class, args);
	}

}
