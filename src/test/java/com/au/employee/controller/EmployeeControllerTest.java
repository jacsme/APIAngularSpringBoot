package com.au.employee.controller;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.au.employee.service.EmployeeService;
import com.au.employee.application.EmployeeApplication;
import com.au.employee.exception.EmployeeException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = EmployeeApplication.class)
@ActiveProfiles("test")
public class EmployeeControllerTest {

	@Mock
	EmployeeService employeeService;
	
	@InjectMocks
	EmployeesController employeeController;

	@Autowired
	WebApplicationContext context;

	private MockMvc mvc;

	@Before
	public void initTests() {
		MockitoAnnotations.initMocks(this);
	    mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testEmployeeListService() throws JSONException, EmployeeException{
		JSONArray employeeJSONArray = new JSONArray();
		employeeJSONArray = setJSONDBResponse(new JSONArray());
		when(employeeService.getEmployeeList()).thenReturn(employeeJSONArray);
		
	}
	
	@Test
    public void testEmployeeListJSONArray() throws Exception {
		JSONArray employeeJSONArray = new JSONArray();
		employeeJSONArray = setJSONDBResponse(new JSONArray());

		JSONObject ceoObj = employeeJSONArray.getJSONObject(0);
		JSONObject managerObj = employeeJSONArray.getJSONObject(1);
		JSONObject employeeObj = employeeJSONArray.getJSONObject(2);
			
		String ceoValue = String.valueOf(ceoObj.getString("CEO"));
		String managerValue = String.valueOf(managerObj.getString("Manager"));
		String employeeValue = String.valueOf(employeeObj.getString("EmployeeName"));
		
        //RETRIEVE
        mvc.perform(get("/employeeList/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
                //.andExpect(jsonPath("$.CEO", is(ceoValue)))
                //.andExpect(jsonPath("$.Manager", is(managerValue)))
                //.andExpect(jsonPath("$.EmployeeName", is(employeeValue)));
    }

	@Test
    public void testEmployeeListFailed() throws Exception {

        //EmployeeLits should fail
        mvc.perform(get("/employeeList1/")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
	
	public JSONArray setJSONDBResponse(JSONArray employeeJSONArray) throws JSONException{
		JSONObject employeeJSONObj1 = new JSONObject();
		JSONObject employeeJSONObj2 = new JSONObject();
		JSONObject employeeJSONObj3 = new JSONObject();
		
		employeeJSONObj1.put("CEO", "CEO Employee");
		employeeJSONObj2.put("Manager", "Manager Employee");
		employeeJSONObj3.put("EmployeeName", "Employee");
		
		employeeJSONArray.put(employeeJSONObj1);
		employeeJSONArray.put(employeeJSONObj2);
		employeeJSONArray.put(employeeJSONObj3);
		return employeeJSONArray;
	}
	
}
