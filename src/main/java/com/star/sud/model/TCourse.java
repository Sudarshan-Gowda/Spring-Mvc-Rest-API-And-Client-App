/**
 * 
 */
package com.star.sud.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @author Sudarshan
 *
 */
@Entity
@Table(name = "T_COURSE", uniqueConstraints = { @UniqueConstraint(columnNames = "COURSE_ID") })
public class TCourse implements Serializable {

	private static final long serialVersionUID = -1786805420219065580L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COURSE_ID")
	private Long courseId;

	@Column(name = "COURSE_NAME", unique = false, nullable = false, length = 100)
	private String courseName;

	@Column(name = "COURSE_DESCRIPTION", unique = false, nullable = false, length = 100)
	private String courseDescription;

	@Column(name = "COURSE_INSTRUCTOR", unique = false, nullable = false, length = 100)
	private String courseInstructor;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "T_COURSE_STUDENTS", joinColumns = { @JoinColumn(name = "COURSE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "STD_ID") })
	private Set<TStudent> students;

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the courseDescription
	 */
	public String getCourseDescription() {
		return courseDescription;
	}

	/**
	 * @param courseDescription the courseDescription to set
	 */
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	/**
	 * @return the courseInstructor
	 */
	public String getCourseInstructor() {
		return courseInstructor;
	}

	/**
	 * @param courseInstructor the courseInstructor to set
	 */
	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}

	/**
	 * @return the students
	 */
	public Set<TStudent> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(Set<TStudent> students) {
		this.students = students;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the courseId
	 */
	public Long getCourseId() {
		return courseId;
	}

}
