/**
 * 
 */
package com.star.sud.client.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.star.sud.dto.Course;
import com.star.sud.dto.CourseDetailsResponse;
import com.star.sud.dto.CoursesResponse;
import com.star.sud.dto.StdCourseOptRequest;
import com.star.sud.dto.Student;
import com.star.sud.dto.StudentCourseResponse;
import com.star.sud.dto.StudentDetailsReponse;
import com.star.sud.dto.StudentRequest;
import com.star.sud.dto.StudentResponse;

/**
 * @author Sudarshan
 *
 */
public class RestClientApp {

	public static final String BASE_URL = "http://localhost:8090/Spring-Mvc-Rest-API-And-Client-App/";

	public static void main(String[] args) {

		getCourseApi();
		getCouseById();
		registerStudent();
		optCourseForStudentById();
		getAllCourseDetailsByStdId();
		deleteStudentOptCourseById();

	}

	// API -1
	public static void getCourseApi() {
		RestTemplate restTemplate = new RestTemplate();

		String url = BASE_URL + "getCourseDetails";
		CoursesResponse response = restTemplate.getForObject(url, CoursesResponse.class);

		for (Course course : response.getCourses()) {
			System.out.println("****** Course -- " + course.getCourseId() + "******");
			System.out.println("CORSE NAME - " + course.getCourseName());
			System.out.println("COURSE DESCRIPTION - " + course.getCourseDescription());
			System.out.println("COURSE INSTRUCTORS - " + course.getCourseInstructor());
			System.out.println("************");
		}
	}

	// API -2
	public static void getCouseById() {
		String url = BASE_URL + "getCourseById/{id}";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", 1);

		CourseDetailsResponse response = new RestTemplate().getForObject(url, CourseDetailsResponse.class, params);
		if (response != null && response.getMessage() != null && response.getMessage().getIsSuccess()) {
			Course course = response.getCourse();
			System.out.println("****** Course -- " + course.getCourseId() + "******");
			System.out.println("CORSE NAME - " + course.getCourseName());
			System.out.println("COURSE DESCRIPTION - " + course.getCourseDescription());
			System.out.println("COURSE INSTRUCTORS - " + course.getCourseInstructor());
			System.out.println("************");
		} else
			System.out.println("Error in response");

	}

	// API -3
	public static void registerStudent() {
		String url = BASE_URL + "registerStudent";

		StudentRequest request = new StudentRequest();
		request.setStudent(new Student(null, "Virat", "K", "virat.k@gmail.com"));

		StudentResponse response = new RestTemplate().postForObject(url, request, StudentResponse.class);

		if (response != null && response.getMessage() != null && response.getMessage().getIsSuccess())
			System.out.println("Registered Successfully & Student Id is :" + response.getStudent().getStdId());
		else
			System.out.println("Failed to process: " + response.getMessage().getErrorDetails());

	}

	// API -4
	public static void optCourseForStudentById() {
		String url = BASE_URL + "optCourseForStudentById";

		StdCourseOptRequest request = new StdCourseOptRequest();
		request.setCourseId(2L);
		request.setStdId(8L);
		StudentCourseResponse response = new RestTemplate().postForObject(url, request, StudentCourseResponse.class);

		if (response != null && response.getMessage() != null && response.getMessage().getIsSuccess()) {

			System.out.println("Successfully Opted for the course:");
			System.out.println("Student Id: " + response.getStdId());

			Course course = response.getCourse();
			System.out.println("****** Course -- " + course.getCourseId() + "******");
			System.out.println("CORSE NAME - " + course.getCourseName());
			System.out.println("COURSE DESCRIPTION - " + course.getCourseDescription());
			System.out.println("COURSE INSTRUCTORS - " + course.getCourseInstructor());
			System.out.println("************");
		}

	}

	// API - 5
	public static void getAllCourseDetailsByStdId() {
		String url = BASE_URL + "getAllCourseDetailsByStdId/{id}";

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", 2);

		StudentDetailsReponse response = new RestTemplate().getForObject(url, StudentDetailsReponse.class, params);

		if (response != null && response.getMessage() != null && response.getMessage().getIsSuccess()) {

			System.out.println("**** Student Details:  ****");
			Student student = response.getStudent();
			System.out.println("STUDENT ID - " + student.getStdId() + "******");
			System.out.println("STUDENT NAME - " + student.getStdFirstName() + " " + student.getStdLastName());
			System.out.println("STUDENT EMAIL - " + student.getStdEmail());

			for (Course course : response.getCourse()) {

				System.out.println("****** Course -- " + course.getCourseId() + "******");
				System.out.println("CORSE NAME - " + course.getCourseName());
				System.out.println("COURSE DESCRIPTION - " + course.getCourseDescription());
				System.out.println("COURSE INSTRUCTORS - " + course.getCourseInstructor());
				System.out.println("************");
			}

		}
	}

	public static void deleteStudentOptCourseById() {
		String url = BASE_URL + "deleteStudentOptCourseById";

		StdCourseOptRequest request = new StdCourseOptRequest();
		request.setCourseId(2L);
		request.setStdId(8L);
		StudentResponse response = new RestTemplate().postForObject(url, request, StudentResponse.class);

		if (response != null && response.getMessage() != null && response.getMessage().getIsSuccess()) {

			System.out.println("Successfully Un-opted from the course");
			System.out.println("**** Student Details:  ****");
			Student student = response.getStudent();
			System.out.println("STUDENT ID - " + student.getStdId() + "******");

		}

	}

}
