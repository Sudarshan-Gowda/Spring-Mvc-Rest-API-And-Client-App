/**
 * 
 */
package com.star.sud.dto;

/**
 * @author Sudarshan
 *
 */
public class StudentCourseResponse {

	private Long stdId;
	private Course course;
	private Message message;

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
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}

	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
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
