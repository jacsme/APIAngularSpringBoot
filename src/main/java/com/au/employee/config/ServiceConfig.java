package com.au.employee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.au.employee.model.Employee;
import com.au.employee.model.EmployeeCEO;
import com.au.employee.model.EmployeeManager;
import com.au.employee.model.ResponseStatus;
import com.au.employee.repository.EmployeeRepository;
import com.au.employee.repository.EmployeeRepositoryImpl;
import com.au.employee.service.EmployeeService;
import com.au.employee.service.EmployeeServiceImpl;

@Configuration
public class ServiceConfig {
	
	@Bean
	public EmployeeService employeeService(){
		return new EmployeeServiceImpl();
	}
	
	@Bean
	public EmployeeRepository employeeRepository(){
		return new EmployeeRepositoryImpl();
	}
	
	@Bean
	public ResponseStatus responseStatus(){
		return new ResponseStatus();
	}

	@Bean
	public EmployeeCEO employeeCEO(){
		return new EmployeeCEO();
	}
	
	@Bean
	public EmployeeManager employeeManager(){
		return new EmployeeManager();
	}
	
	@Bean
	public Employee employee(){
		return new Employee();
	}
}
