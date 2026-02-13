package com.Learn.Spring.Beans;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

@Component
@Import({Mybean.class})
public class ProjectConfig {
}
