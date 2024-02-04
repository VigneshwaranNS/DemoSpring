package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Employee;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		
		DemoApplication ee=new DemoApplication();
		SpringApplication.run(DemoApplication.class, args);
		
	}	
}
