package com.au.employee.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class EmployeeUtil {
	public final static String SUCCESSFUL_TEXT = "Record(s) Found";
	public final static String SUCCESSFUL_STATUS = "Success";
	public final static String FAILURE_TEXT = "System Error";
	public final static String FAILURE_STATUS = "Failure";
	
	public final static String CEO_LABEL = "CEO";
	public final static String MANAGER_LABEL = "Manager";
	public final static String EMPLOYEE_LABEL = "Employee";
	
	
	public static Session session;
	public static Transaction tx;
	
	public static String checkNullString(Object objvalue){
		String strnewValue = "";
		if (objvalue != null){
			strnewValue = objvalue.toString();
		}
		return strnewValue;		
	}
	 
	public static Session callSession(SessionFactory sessionFactory){
		session = sessionFactory.openSession();
		return session;
	}
	
	public static void callCommit(Session session){
		session.flush();
		session.clear();
	}
	
	public static void callClose(Session session){
		session.flush();
		session.clear();
		session.close();
	}
}
