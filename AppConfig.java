package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Employee;

@Configuration
public class AppConfig {


    @Bean
    Employee getEmployee() {
		
		return new Employee();
	}
}
