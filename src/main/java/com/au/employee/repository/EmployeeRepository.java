package com.au.employee.repository;

import java.util.List;

import org.hibernate.SessionFactory;

import com.au.employee.exception.EmployeeException;

public interface EmployeeRepository {
	public List<String> getEmployeeListRepository() throws EmployeeException;
	public SessionFactory setSessionFactory(SessionFactory mockedSessionFactory);

}
