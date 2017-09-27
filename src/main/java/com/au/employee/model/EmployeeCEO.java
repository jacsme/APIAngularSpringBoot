package com.au.employee.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This can be persisted in the database, don't implement it at the moment
 * so that stored procedure can be utilised. Other option to implement is to use 
 * lazy loading with one to many relationship
 * 
 * Change it to this if persistence required. 
 * @Table(name = "EMPLOYEECEO")
 * 
 * @author Jack Hermoso
 * 
 */
@Entity
@Table
public class EmployeeCEO implements Serializable{

	private static final long serialVersionUID = 974781877560048413L;
	
	@Id
	@Column(name = "CEO_ID")
	private String ceoId;
	
	@Column(name = "CEO_EMPLOYEE_NAME")
	private String ceoEmployeeName;

	public String getCeoId() {
		return ceoId;
	}

	public void setCeoId(String ceoId) {
		this.ceoId = ceoId;
	}

	public String getCeoEmployeeName() {
		return ceoEmployeeName;
	}

	public void setCeoEmployeeName(String ceoEmployeeName) {
		this.ceoEmployeeName = ceoEmployeeName;
	}
}
