package com.au.employee.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.au.employee.exception.EmployeeException;
import com.au.employee.util.EmployeeUtil;

@Repository
@Transactional
public class EmployeeRepositoryImpl extends EmployeeUtil implements EmployeeRepository{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public EmployeeRepositoryImpl(){
	}
	
	public EmployeeRepositoryImpl(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	/**
	 * This method will handle the database connection
	 * Will connect to MySQL stored procedure
	 * @return List<String>
	 * @author Jack Hermoso
	 * @throws EmployeeException 
	 */
	@Override
	public List<String> getEmployeeListRepository() throws EmployeeException {
		
		logger.info("Initiated the Employee List Repository");
		
		List<String> responseList = null;
		
		Session session = sessionFactory.openSession();
		try{
			responseList = session.createSQLQuery("CALL pGetEmployeeList()").list();
		} catch (Exception e){
			System.err.println("Exception - " + e.getMessage());
		//}finally{
		//	callClose(session);
		}
		
		return responseList;
	}

	@Override
	public SessionFactory setSessionFactory(SessionFactory sessionFactory) {
		return this.sessionFactory = sessionFactory;
	}
}
