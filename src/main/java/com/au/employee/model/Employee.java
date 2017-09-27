package com.au.employee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This can be persisted in the database, don't implement it at the moment
 * so that stored procedure can be utilised. Other option to implement is to use 
 * lazy loading with one to many relationship this can be implement for Update and Insert Functions
 * The parent of this will the employeemanager table/entity
 * 
 * 
 * Change it to this if persistence required. 
 * @Table(name = "EMPLOYEE")
 * 
 * @author Jack Hermoso
 * 
 */
@Entity
@Table
public class Employee implements Serializable{

	private static final long serialVersionUID = 974781877560048413L;
	
	@Id
	@Column(name = "EMPLOYEE_ID")
	private String employeeId;
	
	@Column(name = "EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name = "EMPLOYEE_REPORTING_ID")
	private String employeeReportingId;

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeReportingId() {
		return employeeReportingId;
	}

	public void setEmployeeReportingId(String employeeReportingId) {
		this.employeeReportingId = employeeReportingId;
	}
}
