/**
 * 
 */
package com.star.sud.controller;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.star.sud.dto.CourseDetailsResponse;
import com.star.sud.dto.CourseStdResponse;
import com.star.sud.dto.CoursesResponse;
import com.star.sud.dto.StdCourseOptRequest;
import com.star.sud.dto.StudentCourseResponse;
import com.star.sud.dto.StudentDetailsReponse;
import com.star.sud.dto.StudentRequest;
import com.star.sud.dto.StudentResponse;
import com.star.sud.services.ICourseStdService;

/**
 * @author Sudarshan
 *
 */
@Controller
public class RestController {

	// Static Attributes
	/////////////////////
	Logger log = Logger.getLogger(RestController.class);

	// Attributes
	///////////////
	@Autowired
	private ICourseStdService service;

	// Request Mapping Methods
	////////////////////
	@RequestMapping(method = RequestMethod.GET, value = "/getCourseDetails")
	@Transactional
	public @ResponseBody CoursesResponse getAllCourseDetails() {
		log.debug("getAllCourseDetails");
		try {

			return service.getAllCourseDetails();

		} catch (Exception e) {
			log.error("getAllCourseDetails", e);
			return null;
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/getCourseById/{courseId}")
	@Transactional
	public @ResponseBody CourseDetailsResponse getCourseById(@PathVariable(value = "courseId") Long courseId) {
		log.debug("getCourseById");
		try {

			return service.getCourseById(courseId);

		} catch (Exception e) {
			log.error("getCourseById", e);
			return null;
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/registerStudent")
	@Transactional
	public @ResponseBody StudentResponse registerStudent(@RequestBody StudentRequest request) {
		log.debug("getAllCourseDetails");
		try {
			return service.registerStudent(request);
		} catch (Exception e) {
			log.error("getAllCourseDetails", e);
			return null;
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/optCourseForStudentById")
	@Transactional
	public @ResponseBody StudentCourseResponse optCourseByIdForStudent(@RequestBody StdCourseOptRequest request) {
		log.debug("getAllCourseDetails");
		try {
			return service.optCourseByIdForStudent(request);
		} catch (Exception e) {
			log.error("getAllCourseDetails", e);
			return null;
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllCourseAndStdDetails")
	@Transactional
	public @ResponseBody CourseStdResponse getAllCourseAndStdDetails() {
		log.debug("getAllCourseDetails");
		try {

			return service.getAllCourseAndStdDetails();

		} catch (Exception e) {
			log.error("getAllCourseDetails", e);
			return null;
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/getAllCourseDetailsByStdId/{stdId}")
	@Transactional
	public @ResponseBody StudentDetailsReponse getAllCourseDetailsByStdId(@PathVariable(value = "stdId") Long stdId) {
		log.debug("getAllCourseDetails");
		try {

			return service.getAllCourseDetailsByStdId(stdId);

		} catch (Exception e) {
			log.error("getAllCourseDetails", e);
			return null;
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/deleteStudentOptCourseById")
	@Transactional
	public @ResponseBody StudentResponse deleteStudentOptCourseById(@RequestBody StdCourseOptRequest request) {
		log.debug("getAllCourseDetails");
		try {

			return service.deleteStudentOptCourseById(request);

		} catch (Exception e) {
			log.error("getAllCourseDetails", e);
			return null;
		}

	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getLadingPage() {
		return "home";
	}

}
