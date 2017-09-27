package com.au.employee.exception;

import java.io.Serializable;

public class EmployeeException extends Exception implements Serializable{
	
	private static final long serialVersionUID = -1858430962766454921L;
	
	private String errorMessage;

	public String getErrorMessage() {
		return errorMessage;
	}

	public EmployeeException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public EmployeeException() {
		super();
	}
}
