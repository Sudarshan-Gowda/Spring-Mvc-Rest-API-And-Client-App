/**
 * 
 */
package com.star.sud.dto;

import java.io.Serializable;
import java.util.Set;

/**
 * @author Sudarshan
 *
 */
public class Course implements Serializable {

	// Static Attributes
	///////////////////////
	private static final long serialVersionUID = -3197766203450952063L;

	// Properties
	/////////////////
	private Long courseId;

	private String courseName;

	private String courseDescription;

	private String courseInstructor;

	private Set<Student> students;

	// Constructors
	/////////////////
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param courseId
	 * @param courseName
	 * @param courseDescription
	 * @param courseInstructor
	 * @param students
	 */
	public Course(Long courseId, String courseName, String courseDescription, String courseInstructor) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseInstructor = courseInstructor;
		// this.students = students;
	}

	// Properties
	//////////////////
	/**
	 * @return the courseId
	 */
	public Long getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

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
	public Set<Student> getStudents() {
		return students;
	}

	/**
	 * @param students the students to set
	 */
	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
