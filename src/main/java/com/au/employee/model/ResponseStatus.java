package com.au.employee.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This class is use for response information
 * 	CODE - Restful Status Code
 * 	TEXT - Readable Message 
 * 	STATUS - Success/Fail
 * @author Jack Hermoso
 *
 */
public class ResponseStatus implements Serializable{
	
	private static final long serialVersionUID = -392061266412361514L;
	
	private int code;
	private String text;
	private String status;
	
	public int getCode() {
		return code;
	}
	
	public void setCode(int icode) {
		this.code = icode;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
