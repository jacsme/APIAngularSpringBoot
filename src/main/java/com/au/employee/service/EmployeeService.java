package com.au.employee.service;

import org.json.JSONArray;

import com.au.employee.exception.EmployeeException;


public interface EmployeeService {
	public JSONArray getEmployeeList() throws EmployeeException;
}
