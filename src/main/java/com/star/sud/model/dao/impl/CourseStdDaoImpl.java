/**
 * 
 */
package com.star.sud.model.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.star.sud.model.TCourse;
import com.star.sud.model.TStudent;
import com.star.sud.model.dao.ICourseStdDao;

/**
 * @author Sudarshan
 *
 */
@Repository
public class CourseStdDaoImpl implements ICourseStdDao {

	// private static final Logger log = Logger.getLogger(CourseDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TCourse> listCourses() throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<TCourse> tCourses = session.createCriteria(TCourse.class).list();
		return tCourses;
	}

	@Override
	@Transactional
	public TCourse getCourseById(Long Id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		TCourse tCourse = (TCourse) session.get(TCourse.class, Id);
		return tCourse;
	}

	@Override
	@Transactional
	public Long saveStudent(TStudent student) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		return (Long) session.save(student);
	}

	@Override
	@Transactional
	public void saveOrUpdateStudent(TStudent student) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(student);
	}

	@Override
	@Transactional
	public void saveOrUpdateCourse(TCourse course) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(course);
	}

	@Override
	@Transactional
	public TStudent getStudentById(Long Id) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		TStudent tStudent = (TStudent) session.get(TStudent.class, Id);
		return tStudent;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TStudent> getStudentByEmail(String email) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		List<TStudent> tStudent = session.createQuery("from TStudent t where t.stdEmail= '" + email + "'").list();
		return tStudent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.star.sud.model.dao.ICourseStdDao#update(com.star.sud.model.TCourse)
	 */
	@Override
	@Transactional
	public void update(TCourse tCourse) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		session.update(tCourse);

	}

}
