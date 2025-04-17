package org.jsp.studentmanagement.controller;

import java.io.IOException;

import org.jsp.studentmanagement.dto.Course;
import org.jsp.studentmanagement.dto.Student;
import org.jsp.studentmanagement.service.StudentService;
import org.jsp.studentmanagement.util.ResponseStructure;
import org.jsp.studentmanagement.util.ResponseStructureList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/savestudentdetails")
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@PutMapping("/addcourses/{id}/{cid}")
	public ResponseEntity<ResponseStructure<Student>> addCourse(@PathVariable int id,@PathVariable int cid){
		return service.addCourse(id, cid);
	}
	
	@GetMapping("/findstudentbyid/{id}")
	public ResponseEntity<ResponseStructure<Student>> findStudentById(@PathVariable int id) {
		return service.findStudentById(id);
	}
	
	@GetMapping("/fetchcourse/{id}")
	public ResponseEntity<ResponseStructureList<Course>> fetchCourse(@PathVariable int id){
		return service.fetchCourses(id);
	}
	
	@DeleteMapping("/deletecourse/{id}/{cid}")
	public ResponseEntity<ResponseStructure<Student>> deletecourse(@PathVariable int id,@PathVariable int cid){
		return service.deleteCourse(id, cid);
	}
	
	
	@PutMapping("/uploadimages/{id}")
	public ResponseEntity<ResponseStructure<Student>> uploadImage(@PathVariable int id,@RequestBody MultipartFile file) throws IOException {
		return service.uploadimage(id, file);
	}
	
	@GetMapping("/fetchimages/{id}")
	public ResponseEntity<byte[]> fetchImage(@PathVariable int id) {
		return service.fetchImage(id);
	}
	
	@PostMapping("/loginstudent")
	public ResponseEntity<ResponseStructure<Student>> loginStudent(@RequestBody Student student) {
		return service.loginStudent(student);
	}
	
	@PutMapping("/updatestudent")
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student){
		return service.updateStudent(student);
	}
	
	@DeleteMapping("/deletestudent/{id}")
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@PathVariable int id){
		return service.deleteStudent(id);
	}
	
	@GetMapping("/fetchallcourses")
	public ResponseEntity<ResponseStructureList<Course>> fetchall() {
		return service.fetchall();
	}
	
	@GetMapping("/fetchallstudentdetails")
	public ResponseEntity<ResponseStructureList<Student>> fetchallstudents() {
		return service.fetchallstudents();
	}
}
