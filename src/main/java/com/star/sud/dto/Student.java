/**
 * 
 */
package com.star.sud.dto;

import java.io.Serializable;

/**
 * @author Sudarshan
 *
 */
public class Student implements Serializable {

	// Static Attributes
	/////////////////////
	private static final long serialVersionUID = 3222239592554386153L;

	// Attributes
	////////////////
	// @JsonIgnore
	private Long stdId;

	private String stdFirstName;

	private String stdLastName;

	private String stdEmail;

	// Constructors
	//////////////////
	/**
	 * 
	 */
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(Long stdId) {
		super();
		this.stdId = stdId;
	}

	/**
	 * @param stdId
	 * @param stdFirstName
	 * @param stdLastName
	 * @param stdEmail
	 * @param courses
	 */
	public Student(Long stdId, String stdFirstName, String stdLastName, String stdEmail) {
		super();
		this.stdId = stdId;
		this.stdFirstName = stdFirstName;
		this.stdLastName = stdLastName;
		this.stdEmail = stdEmail;
	}

	// Override Methods
	///////////////////////
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdFirstName=" + stdFirstName + ", stdLastName=" + stdLastName
				+ ", stdEmail=" + stdEmail + "]";
	}

	// Properties
	/////////////////
	/**
	 * @return the stdId
	 */
	public Long getStdId() {
		return stdId;
	}

	/**
	 * @param stdId the stdId to set
	 */
	public void setStdId(Long stdId) {
		this.stdId = stdId;
	}

	/**
	 * @return the stdFirstName
	 */
	public String getStdFirstName() {
		return stdFirstName;
	}

	/**
	 * @param stdFirstName the stdFirstName to set
	 */
	public void setStdFirstName(String stdFirstName) {
		this.stdFirstName = stdFirstName;
	}

	/**
	 * @return the stdLastName
	 */
	public String getStdLastName() {
		return stdLastName;
	}

	/**
	 * @param stdLastName the stdLastName to set
	 */
	public void setStdLastName(String stdLastName) {
		this.stdLastName = stdLastName;
	}

	/**
	 * @return the stdEmail
	 */
	public String getStdEmail() {
		return stdEmail;
	}

	/**
	 * @param stdEmail the stdEmail to set
	 */
	public void setStdEmail(String stdEmail) {
		this.stdEmail = stdEmail;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
