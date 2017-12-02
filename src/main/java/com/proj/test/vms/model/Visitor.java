package com.proj.test.vms.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Visitor {

	private String visitorId;
	private String firstName;
	private String lastName;
	private Date entryDate;
	
	public Visitor() {
		
	}
	public Visitor(String id, String fName, String lName, Date date) {
		this.visitorId = id;
		this.firstName = fName;
		this.lastName = lName;
		this.entryDate = date;
	}
	/**
	 * @return the id
	 */
	public String getVisitorId() {
		return visitorId;
	}
	/**
	 * @param id the id to set
	 */
	public void setVisitorId(String id) {
		this.visitorId = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the entryDate
	 */
	public Date getEntryDate() {
		return entryDate;
	}
	/**
	 * @param entryDate the entryDate to set
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
}
