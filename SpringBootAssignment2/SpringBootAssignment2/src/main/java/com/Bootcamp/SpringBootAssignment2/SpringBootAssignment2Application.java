package com.Bootcamp.SpringBootAssignment2;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Bootcamp.SpringBootAssignment2.entity.Employee;
import com.Bootcamp.SpringBootAssignment2.repository.EmployeeRepository;

@SpringBootApplication
public class SpringBootAssignment2Application {

	@Value("${app.name}")
	private String appName;

	@Value("${app.version}")
	private String appVersion;

	@Value("${app.owner}")
	private String appOwner;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAssignment2Application.class, args);
	}

	@Bean
	CommandLineRunner loadData(EmployeeRepository repository) {
		return args -> {
			repository.save(new Employee("Saurabh", "Developer"));
			repository.save(new Employee("Ankit", "Tester"));
			repository.save(new Employee("Riya", "Manager"));
		};
	}

	@PostConstruct
	public void printValues() {
		System.out.println("App Name: " + appName);
		System.out.println("Version: " + appVersion);
		System.out.println("Owner: " + appOwner);
	}
}
