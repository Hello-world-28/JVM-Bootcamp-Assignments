package com.Learn.Spring.Beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages={"com.Learn.Spring.Beans"})
public class ProjectConfig {
}
