package org.jsp.studentmanagement.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.studentmanagement.dto.Course;
import org.jsp.studentmanagement.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDao {
	@Autowired
	private CourseRepository repository;
	
	public Course saveCourse(Course course) {
		return repository.save(course);
	}

	public Optional<Course>  findById(int cid) {
		return repository.findById(cid);
	}
//	
	public List<Course> fetchall() {
		return  repository.findAll();
	}

	
}
