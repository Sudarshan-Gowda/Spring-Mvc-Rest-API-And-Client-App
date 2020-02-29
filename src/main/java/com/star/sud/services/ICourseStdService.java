/**
 * 
 */
package com.star.sud.services;

import com.star.sud.dto.CourseDetailsResponse;
import com.star.sud.dto.CourseStdResponse;
import com.star.sud.dto.CoursesResponse;
import com.star.sud.dto.StdCourseOptRequest;
import com.star.sud.dto.StudentCourseResponse;
import com.star.sud.dto.StudentDetailsReponse;
import com.star.sud.dto.StudentRequest;
import com.star.sud.dto.StudentResponse;

/**
 * @author Sudarshan
 *
 */
public interface ICourseStdService {

	/**
	 * @return
	 */
	CoursesResponse getAllCourseDetails();

	/**
	 * @return
	 */
	CourseDetailsResponse getCourseById(Long Id);

	/**
	 * @return
	 */
	CourseStdResponse getAllCourseAndStdDetails();

	/**
	 * @param request
	 * @return
	 */
	StudentResponse registerStudent(StudentRequest request);

	/**
	 * @param request
	 * @return
	 */
	StudentCourseResponse optCourseByIdForStudent(StdCourseOptRequest request);

	/**
	 * @param stdId
	 * @return
	 */
	StudentDetailsReponse getAllCourseDetailsByStdId(Long stdId);

	/**
	 * @param request
	 * @return
	 */
	StudentResponse deleteStudentOptCourseById(StdCourseOptRequest request);

}
