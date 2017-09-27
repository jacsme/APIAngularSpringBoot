package com.au.employee.service;

import static org.mockito.Mockito.when;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.au.employee.repository.EmployeeRepository;
import com.au.employee.exception.EmployeeException;

@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeServiceImplTest {
	
	@Mock
	private EmployeeRepository employeeREpository;
	
	@Mock
	private EmployeeService employeeService;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@Test
	public void testGetEmployeeList() throws JSONException, EmployeeException{
		
		JSONArray employeeJSONArray = new JSONArray();
		employeeJSONArray = setJSONDBResponse(new JSONArray());
		
		when(employeeService.getEmployeeList()).thenReturn(employeeJSONArray);
	}
	
	public JSONArray setJSONDBResponse(JSONArray employeeJSONArray) throws JSONException{
		
		JSONObject employeeJSONObj = new JSONObject();
		
		employeeJSONObj.put("CEO", "CEO Employee");
		employeeJSONObj.put("Manager", "Manager Employee");
		employeeJSONObj.put("Employee", "Employee");
		
		employeeJSONArray.put(employeeJSONObj);	
		return employeeJSONArray;
	}

}
