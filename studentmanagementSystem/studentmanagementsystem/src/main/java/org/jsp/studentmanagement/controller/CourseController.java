package org.jsp.studentmanagement.controller;


import org.jsp.studentmanagement.dto.Course;
import org.jsp.studentmanagement.service.CourseService;
import org.jsp.studentmanagement.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
	@Autowired
	private CourseService service;
	
	@PostMapping("/savecourses")
	public  ResponseEntity<ResponseStructure<Course>> saveCourse(@RequestBody Course course) {
		return service.saveCourse(course);
	}
}
