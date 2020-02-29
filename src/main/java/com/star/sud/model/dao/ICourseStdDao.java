/**
 * 
 */
package com.star.sud.model.dao;

import java.util.List;

import com.star.sud.model.TCourse;
import com.star.sud.model.TStudent;

/**
 * @author Sudarshan
 *
 */
public interface ICourseStdDao {

	/**
	 * @return
	 * @throws Exception
	 */
	List<TCourse> listCourses() throws Exception;

	/**
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	TCourse getCourseById(Long Id) throws Exception;

	/**
	 * @param student
	 * @throws Exception
	 */
	Long saveStudent(TStudent student) throws Exception;

	/**
	 * @param Id
	 * @return
	 * @throws Exception
	 */
	TStudent getStudentById(Long Id) throws Exception;

	/**
	 * @param student
	 * @throws Exception
	 */
	void saveOrUpdateStudent(TStudent student) throws Exception;

	/**
	 * @param course
	 * @throws Exception
	 */
	void saveOrUpdateCourse(TCourse course) throws Exception;

	/**
	 * @param email
	 * @return
	 * @throws Exception
	 */
	List<TStudent> getStudentByEmail(String email) throws Exception;

	/**
	 * @param tCourse
	 * @throws Exception
	 */
	void update(TCourse tCourse) throws Exception;

}
