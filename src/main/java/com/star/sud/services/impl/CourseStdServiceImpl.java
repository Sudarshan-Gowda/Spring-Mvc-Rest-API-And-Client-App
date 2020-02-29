/**
 * 
 */
package com.star.sud.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.star.sud.dto.Course;
import com.star.sud.dto.CourseDetailsResponse;
import com.star.sud.dto.CourseStdResponse;
import com.star.sud.dto.CoursesResponse;
import com.star.sud.dto.Message;
import com.star.sud.dto.StdCourseOptRequest;
import com.star.sud.dto.Student;
import com.star.sud.dto.StudentCourseResponse;
import com.star.sud.dto.StudentDetailsReponse;
import com.star.sud.dto.StudentRequest;
import com.star.sud.dto.StudentResponse;
import com.star.sud.model.TCourse;
import com.star.sud.model.TStudent;
import com.star.sud.model.dao.ICourseStdDao;
import com.star.sud.services.ICourseStdService;

/**
 * @author Sudarshan
 *
 */
@Service
public class CourseStdServiceImpl implements ICourseStdService {

	// Static Attributes
	//////////////////////
	private static Logger log = Logger.getLogger(CourseStdServiceImpl.class);

	// Attributes
	/////////////////
	@Autowired
	private ICourseStdDao courseDao;

	// HTTP Methods
	////////////////////
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.star.sud.services.ICourseStdService#getAllCourseDetails()
	 */
	@Override
	public CoursesResponse getAllCourseDetails() {
		log.debug("getAllCourseDetails");
		CoursesResponse response = new CoursesResponse();
		try {

			List<TCourse> tCourses = courseDao.listCourses();
			List<Course> courses = new ArrayList<>();
			for (TCourse tCourse : tCourses) {
				courses.add(setCouseDetails(tCourse));
			}
			response.setCourses(courses);
			response.setMessage(new Message("Success", Boolean.TRUE));
		} catch (Exception e) {
			log.error("getAllCourseDetails");
			response.setMessage(new Message("Failed", Boolean.FALSE, "ERROR_100", e.getMessage()));
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.star.sud.services.ICourseStdService#getCourseById()
	 */
	@Override
	public CourseDetailsResponse getCourseById(Long courseId) {
		log.debug("getCourseById");
		CourseDetailsResponse response = new CourseDetailsResponse();
		try {
			TCourse tCourse = courseDao.getCourseById(courseId);
			if (null == tCourse)
				throw new Exception("No Record Found for the courseId: " + courseId);
			response.setCourse(setCouseDetails(tCourse));
			response.setMessage(new Message("Success", Boolean.TRUE));

		} catch (Exception e) {
			log.error("getCourseById", e);
			response.setMessage(new Message("Failed", Boolean.FALSE, "ERROR_100", e.getMessage()));
		}
		return response;
	}

	@Override
	public StudentResponse registerStudent(StudentRequest request) {
		log.debug("registerStudent");
		StudentResponse response = new StudentResponse();
		try {

			if (null == request)
				throw new Exception("request param is null or empty");

			if (null == request.getStudent())
				throw new Exception("student param is null or empty");

			if (null == request.getStudent().getStdFirstName())
				throw new Exception("student first name is null or empty");

			if (null == request.getStudent().getStdLastName())
				throw new Exception("student last name is null or empty");

			if (null == request.getStudent().getStdEmail())
				throw new Exception("student email is null or empty");

			// Validate for email id exists or not
			List<TStudent> tstudent = courseDao.getStudentByEmail(request.getStudent().getStdEmail());
			if (tstudent != null && tstudent.size() > 0)
				throw new Exception("Email Id entered is already registerd with the system");

			TStudent student = new TStudent();
			student.setStdFirstName(request.getStudent().getStdFirstName());
			student.setStdLastName(request.getStudent().getStdLastName());
			student.setStdEmail(request.getStudent().getStdEmail());
			Long recordId = courseDao.saveStudent(student);
			request.getStudent().setStdId(recordId);

			response.setStudent(request.getStudent());
			response.setMessage(new Message("Registration Successfull!!", Boolean.TRUE));
		} catch (Exception e) {
			log.error("registerStudent", e);
			response.setMessage(new Message("Failed", Boolean.FALSE, "ERROR_100", e.getMessage()));
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.star.sud.services.ICourseStdService#getAllCourseAndStdDetails()
	 */
	@Override
	public CourseStdResponse getAllCourseAndStdDetails() {
		log.debug("getAllCourseAndStdDetails");
		CourseStdResponse response = new CourseStdResponse();
		try {

			List<TCourse> tCourses = courseDao.listCourses();

			if (null == tCourses)
				throw new Exception("No records found");

			List<Course> courses = new ArrayList<Course>();

			for (TCourse tCourse : tCourses)
				courses.add(setCouseStdDetails(tCourse));

			response.setCourses(courses);
			response.setMessage(new Message("Success", Boolean.TRUE));
		} catch (Exception e) {
			log.error("getAllCourseAndStdDetails", e);
			response.setMessage(new Message("Failed", Boolean.FALSE, "ERROR_100", e.getMessage()));
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.star.sud.services.ICourseStdService#optCourseByIdForStudent(com.star.sud.
	 * dto.StdCourseOptRequest)
	 */
	@Override
	public StudentCourseResponse optCourseByIdForStudent(StdCourseOptRequest request) {
		log.debug("optCourseByIdForStudent");
		StudentCourseResponse response = new StudentCourseResponse();
		try {

			if (null == request)
				throw new Exception("request param is null or empty");

			if (null == request.getStdId())
				throw new Exception("stdId param is null or empty");

			if (null == request.getCourseId())
				throw new Exception("courseId param is null or empty");

			TStudent tStudent = courseDao.getStudentById(request.getStdId());
			if (null == tStudent)
				throw new Exception("No Student Record found for the Id: " + request.getStdId());

			TCourse tCourse = courseDao.getCourseById(request.getCourseId());
			if (null == tCourse)
				throw new Exception("No Course Record found for the Id: " + request.getCourseId());

			Set<TStudent> tStudents = tCourse.getStudents();
			tStudents.add(tStudent);
			tCourse.setStudents(tStudents);

			courseDao.saveOrUpdateCourse(tCourse);

			response.setStdId(request.getStdId());
			response.setCourse(setCouseDetails(tCourse));

			response.setMessage(new Message("Success", Boolean.TRUE));

		} catch (Exception e) {
			log.error("optCourseByIdForStudent", e);
			response.setMessage(new Message("Failed", Boolean.FALSE, "ERROR_100", e.getMessage()));
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.star.sud.services.ICourseStdService#getAllCourseDetailsByStdId(java.lang.
	 * Long)
	 */
	@Override
	public StudentDetailsReponse getAllCourseDetailsByStdId(Long stdId) {
		StudentDetailsReponse response = new StudentDetailsReponse();
		try {

			if (null == stdId)
				throw new Exception("std param is null or empty");

			TStudent tStudent = courseDao.getStudentById(stdId);
			if (null == tStudent)
				throw new Exception("No Student Record found for the Id: " + stdId);

			Student student = new Student();
			BeanUtils.copyProperties(tStudent, student);
			response.setStudent(student);

			Set<Course> courses = new HashSet<>();
			for (TCourse tCourse : tStudent.getCourses())
				courses.add(setCouseDetails(tCourse));

			response.setCourse(courses);
			response.setMessage(new Message("Success", Boolean.TRUE));
		} catch (Exception e) {
			response.setMessage(new Message("Failed", Boolean.FALSE, "ERROR_100", e.getMessage()));
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.star.sud.services.ICourseStdService#deleteStudentOptCourseById(com.star.
	 * sud.dto.StdCourseOptRequest)
	 */
	@Override
	public StudentResponse deleteStudentOptCourseById(StdCourseOptRequest request) {
		StudentResponse response = new StudentResponse();
		try {

			if (null == request)
				throw new Exception("std param is null or empty");

			if (null == request.getStdId())
				throw new Exception("stdId param is null or empty");

			if (null == request.getCourseId())
				throw new Exception("courseId param is null or empty");

			TStudent tStudent = courseDao.getStudentById(request.getStdId());
			if (null == tStudent)
				throw new Exception("No Student Record found for the Id: " + request.getStdId());

			TCourse tCourse = courseDao.getCourseById(request.getCourseId());
			if (null == tCourse)
				throw new Exception("No Course Record found for the Id: " + request.getCourseId());

			Set<TStudent> tStudents = tCourse.getStudents();
			tStudents.remove(tStudent);
			tCourse.setStudents(tStudents);

			courseDao.update(tCourse);

			response.setMessage(new Message("SUCCESS", Boolean.TRUE));
			response.setStudent(new Student(request.getStdId()));

			return response;

		} catch (Exception e) {
			response.setMessage(new Message("Failed", Boolean.FALSE, "ERROR_100", e.getMessage()));
		}

		return response;
	}

	// Helper Methods
	///////////////////////
	private Course setCouseStdDetails(TCourse tCourse) {
		try {
			Course course = setCouseDetails(tCourse);
			Set<Student> students = new HashSet<Student>();
			for (TStudent tStudent : tCourse.getStudents()) {
				Student student = new Student();
				BeanUtils.copyProperties(tStudent, student);
				students.add(student);
			}
			course.setStudents(students);
			return course;

		} catch (Exception e) {
			throw e;
		}
	}

	private Course setCouseDetails(TCourse tCourse) {
		try {
			Course course = new Course();
			course.setCourseId(tCourse.getCourseId());
			course.setCourseName(tCourse.getCourseName());
			course.setCourseDescription(tCourse.getCourseDescription());
			course.setCourseInstructor(tCourse.getCourseInstructor());
			return course;
		} catch (Exception e) {
			throw e;
		}
	}

}
