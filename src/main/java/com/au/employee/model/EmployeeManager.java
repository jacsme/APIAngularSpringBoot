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
 * The child of this will the employee table/entity
 * 
 * Change it to this if persistence required. 
 * @Table(name = "EMPLOYEEMANAGER")
 * 
 * @author Jack Hermoso
 * 
 */
@Entity
@Table
public class EmployeeManager implements Serializable{

	private static final long serialVersionUID = 6105174833487792659L;
	
	@Id
	@Column(name = "MANAGER_ID")
	private String managerId;
	
	@Column(name = "MANAGER_NAME")
	private String managerName;
	
	@Column(name = "MANAGER_REPORTING_ID")
	private String managerReportingId;

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getManagerReportingId() {
		return managerReportingId;
	}

	public void setManagerReportingId(String managerReportingId) {
		this.managerReportingId = managerReportingId;
	}
}
