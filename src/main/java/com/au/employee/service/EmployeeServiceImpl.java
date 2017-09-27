package com.au.employee.service;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.Response.Status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.au.employee.exception.EmployeeException;
import com.au.employee.model.Employee;
import com.au.employee.model.EmployeeCEO;
import com.au.employee.model.EmployeeManager;
import com.au.employee.model.ResponseStatus;
import com.au.employee.repository.EmployeeRepository;
import com.au.employee.util.EmployeeUtil;

@Component
public class EmployeeServiceImpl extends EmployeeUtil implements EmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ResponseStatus responseStatus;
	
	@Autowired
	private EmployeeCEO employeeCEO;
	
	@Autowired
	private EmployeeManager employeeManager;
	
	@Autowired
	private Employee employee;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * This method will handle the manipulation of the database result
	 * from Repository Object
	 * @return JSONObject
	 * @author Jack Hermoso
	 */
	@Override
	public JSONArray getEmployeeList() throws EmployeeException{
		
		logger.info("Initiated the Employee List Service");
		
		List<String> employeeDBList = null;
		
		//This is the main holder of the database result
		JSONArray resultJSONArray = new JSONArray();
		
		//Use 3 objects to handle each entity
		JSONObject ceoJSONObj = new JSONObject();
		JSONObject managerJSONObj = new JSONObject();
		JSONObject employeeJSONObj = new JSONObject();
		JSONObject statusJSONObj = new JSONObject();
		
		try {
			//Call the database access object
			employeeDBList = employeeRepository.getEmployeeListRepository();
			System.out.println("DBResult" + employeeDBList);
			String employeeManagerStr = null;
			String employeeCEOStr = null;
			
			for (Iterator it = employeeDBList.iterator(); it.hasNext();){
				Object[] resultListRecord = (Object[]) it.next();
				
				if (employeeCEOStr==null){
					employeeCEOStr = checkNullString(resultListRecord[1]);
					employeeManagerStr = checkNullString(resultListRecord[4]);
					
					employeeCEO.setCeoEmployeeName(employeeCEOStr);
					employeeManager.setManagerName(employeeManagerStr);
					employee.setEmployeeName(checkNullString(resultListRecord[6]));
					
					ceoJSONObj.put(CEO_LABEL, employeeCEO.getCeoEmployeeName());
					managerJSONObj.put(MANAGER_LABEL, employeeManager.getManagerName());
					employeeJSONObj.put(EMPLOYEE_LABEL, employee.getEmployeeName());
					
					resultJSONArray.put(ceoJSONObj);
					resultJSONArray.put(managerJSONObj);
					resultJSONArray.put(employeeJSONObj);
				
				}else if (employeeManagerStr.equalsIgnoreCase(checkNullString(resultListRecord[4]))){
					employeeJSONObj = new JSONObject();
					employee.setEmployeeName(checkNullString(resultListRecord[6]));
					employeeJSONObj.put(EMPLOYEE_LABEL, employee.getEmployeeName());
					resultJSONArray.put(employeeJSONObj);
					
				
				}else if (!employeeManagerStr.equalsIgnoreCase(checkNullString(resultListRecord[4]))){
					employeeManagerStr = checkNullString(resultListRecord[4]);
					
					//Clear these object to have fresh object
					managerJSONObj = new JSONObject();
					employeeJSONObj = new JSONObject();
					
					employeeManager.setManagerName(employeeManagerStr);
					employee.setEmployeeName(checkNullString(resultListRecord[6]));
					
					managerJSONObj.put(MANAGER_LABEL, employeeManager.getManagerName());
					employeeJSONObj.put(EMPLOYEE_LABEL, employee.getEmployeeName());
					
					resultJSONArray.put(managerJSONObj);
					resultJSONArray.put(employeeJSONObj);
				}
			}
			//Set the status
			statusJSONObj.put(SUCCESSFUL_STATUS, SUCCESSFUL_TEXT);
			responseStatus.setCode(Status.OK.getStatusCode());
			
		} catch (JSONException e) {
			responseStatus.setCode(Status.BAD_REQUEST.getStatusCode());
			statusJSONObj.put(FAILURE_STATUS, FAILURE_TEXT);
		} catch(Exception e){
			System.err.println(e.getMessage());
			throw new EmployeeException("There is problem with the results");
		}
		
		resultJSONArray.put(statusJSONObj);
		return resultJSONArray;
	}
}
