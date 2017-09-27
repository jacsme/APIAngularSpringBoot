package com.au.employee.controller;

import java.util.Map;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.au.employee.exception.EmployeeException;
import com.au.employee.service.EmployeeService;


@Controller
public class EmployeesController {

	@Autowired
	@Qualifier("employeeService")
	private EmployeeService employeeService;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("message", "WelcomeHome");
		return "welcome";
	}
	
	/**
	 * This is the request mapping from index.jsp to employeeList.jsp using
	 * GET method
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/employee", method = RequestMethod.POST)
	public String getEmployeePage(ModelMap model) {
		logger.info("Received request to Employee Page POST");
		
		model.addAttribute("message", "Welcome");
		return "employeeList";
	}
	
	@RequestMapping(value = "/employeeList", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody String getEmployeeListPost()throws EmployeeException{
		
		logger.info("Initiated the Employee List");
		JSONArray employeeJSONArray = new JSONArray();
		
		employeeJSONArray = employeeService.getEmployeeList();
		
		return employeeJSONArray.toString();
	}
	
	@RequestMapping(value = "/employeeList", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String getEmployeeListGet()throws EmployeeException{
		
		logger.info("Initiated the Employee List");
		JSONArray employeeJSONArray = new JSONArray();
		
		employeeJSONArray = employeeService.getEmployeeList();
		
		return employeeJSONArray.toString();
	}
}
