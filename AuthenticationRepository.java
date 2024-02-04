package com.example.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

@Repository
public class AuthenticationRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	public List<Employee> getString () {
		
		String sql = "select * from employee";
		
		List<Employee> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Employee.class));
		
		
		return result;
		
	}

}
