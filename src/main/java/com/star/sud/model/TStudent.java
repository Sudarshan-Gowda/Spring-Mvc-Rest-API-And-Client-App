/**
 * 
 */
package com.star.sud.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Sudarshan
 *
 */
@Entity
@Table(name = "T_STUDENT", uniqueConstraints = { @UniqueConstraint(columnNames = "STD_ID"),
		@UniqueConstraint(columnNames = "STD_EMAIL") })
public class TStudent implements Serializable {

	private static final long serialVersionUID = -4638831495488937065L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STD_ID")
	private Long stdId;

	@Column(name = "STD_FIRST_NAME", unique = false, nullable = false, length = 100)
	private String stdFirstName;

	@Column(name = "STD_LAST_NAME", unique = false, nullable = false, length = 100)
	private String stdLastName;

	@Column(name = "STD_EMAIL", unique = false, nullable = false, length = 100)
	private String stdEmail;

	@ManyToMany(mappedBy = "students")
	private Set<TCourse> courses;

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
	 * @return the courses
	 */
	public Set<TCourse> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(Set<TCourse> courses) {
		this.courses = courses;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

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

}
