/**
 * 
 */
package com.star.sud.dto;

import java.util.Set;

/**
 * @author Sudarshan
 *
 */
public class StudentDetailsReponse {

	private Student student;

	private Set<Course> course;

	private Message message;

	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}

	/**
	 * @return the course
	 */
	public Set<Course> getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Set<Course> course) {
		this.course = course;
	}

	/**
	 * @return the message
	 */
	public Message getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(Message message) {
		this.message = message;
	}

}
