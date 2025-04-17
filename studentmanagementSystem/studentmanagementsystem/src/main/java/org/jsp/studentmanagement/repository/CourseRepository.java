package org.jsp.studentmanagement.repository;

import java.util.Optional;

import org.jsp.studentmanagement.dto.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	Optional<Course> findById(int cid);

	
	
}
