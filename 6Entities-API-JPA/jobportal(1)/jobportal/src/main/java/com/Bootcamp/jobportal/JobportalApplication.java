package com.Bootcamp.jobportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobportalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobportalApplication.class, args);
	}

}
/*
Spring Boot startup order :
1. Create DataSource
2. Initialize schema (if SQL init enabled)
3. Initialize JPA (Hibernate)
4. Create EntityManagerFactory
 */