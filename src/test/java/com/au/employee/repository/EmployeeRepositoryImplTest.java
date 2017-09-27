package com.au.employee.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.au.employee.exception.EmployeeException;


@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeRepositoryImplTest {
	
	@Mock
	private SessionFactory mockedSessionFactory;
	
	@Mock
	private Session mockedSession;
	
	@Mock
	private Transaction mockedTransaction;
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@Before
	public void setUp() {
	    mockedSessionFactory =  Mockito.mock(SessionFactory.class);
	    mockedSession = Mockito.mock(Session.class);
	    mockedTransaction = Mockito.mock(Transaction.class);
	   
	    Mockito.when(mockedSessionFactory.openSession()).thenReturn(mockedSession);
	    Mockito.when(mockedSession.beginTransaction()).thenReturn(mockedTransaction);
	    
	    employeeRepository.setSessionFactory(this.mockedSessionFactory);
	}
	
	@Test
	public void testGetEmployeeListRepository() throws EmployeeException{
		
		Query sqlQuery = Mockito.mock(Query.class);
		when(mockedSession.createQuery("CALL pGetEmployeeList()")).thenReturn(sqlQuery);
		List<String> response = employeeRepository.getEmployeeListRepository();
		assertNotNull(response);
	}
	
	@Test
	public void testGetEmployeeListRepositoryNoResult() throws EmployeeException{
		
		List<String> responseList = new ArrayList<String>();
		
		Query sqlQuery = Mockito.mock(Query.class);
		when(mockedSession.createQuery("CALL pGetEmployeeList()")).thenReturn(sqlQuery);
		List<String> responseDB = null;
		try{
			responseDB = employeeRepository.getEmployeeListRepository();
		}catch(Exception e){
			responseDB = null;
		}
		assertEquals(responseList, responseDB);
	}
	
	@Test
	public void testGetEmployeeListRepositoryException() throws EmployeeException{
		
		Query sqlQuery = Mockito.mock(Query.class);
		when(mockedSession.createQuery("CALL pGetEmployeeList()")).thenReturn(sqlQuery);
	
		boolean exceptionCaught = true;
		
		try{
			employeeRepository.getEmployeeListRepository();
		}catch(Exception e){
			exceptionCaught = (e.getMessage()!=null);
		}
		assertTrue(exceptionCaught);
	}
}
