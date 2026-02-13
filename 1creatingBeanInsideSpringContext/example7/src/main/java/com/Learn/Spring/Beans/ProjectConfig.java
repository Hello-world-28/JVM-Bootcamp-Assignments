package com.Learn.Spring.Beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@ComponentScan(basePackages = "com.Learn.Spring.Beans")
@Configuration
public class ProjectConfig {
}
