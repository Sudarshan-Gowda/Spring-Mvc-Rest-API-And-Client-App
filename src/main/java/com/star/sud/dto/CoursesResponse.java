/**
 * 
 */
package com.star.sud.dto;

import java.util.List;

/**
 * @author Sudarshan
 *
 */
public class CoursesResponse {

	private List<Course> courses;

	private Message message;

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

	/**
	 * @return the courses
	 */
	public List<Course> getCourses() {
		return courses;
	}

	/**
	 * @param courses the courses to set
	 */
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

}
