package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.AuthenticationService;

@RestController
public class AuthenticationController {
	
	
	@Autowired
	AuthenticationService service;
	
	@GetMapping("/getcall")
	public List<Employee> get(){
		
		
		List<Employee> result = service.getService();
		
		return result ;
		
	}

}
