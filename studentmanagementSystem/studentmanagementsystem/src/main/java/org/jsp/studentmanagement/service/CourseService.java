package org.jsp.studentmanagement.service;


import org.jsp.studentmanagement.dao.CourseDao;
import org.jsp.studentmanagement.dto.Course;
import org.jsp.studentmanagement.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	@Autowired
	private CourseDao coursedao;
	
private ResponseStructure<Course> structure =new ResponseStructure<Course>();
	
	public ResponseEntity<ResponseStructure<Course>> saveCourse(Course course) {
		structure.setData(coursedao.saveCourse(course));
		structure.setMsg("course saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Course>>(structure,HttpStatus.CREATED);
	}
	
	
	
}
