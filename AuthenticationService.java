package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repository.AuthenticationRepository;

@Service
public class AuthenticationService {

	
	@Autowired
	AuthenticationRepository repo;
	
	
	public List<Employee> getService(){
		
		
		List<Employee> result = repo.getString();
		
		
		return result ;
		
		
	}
	
}
