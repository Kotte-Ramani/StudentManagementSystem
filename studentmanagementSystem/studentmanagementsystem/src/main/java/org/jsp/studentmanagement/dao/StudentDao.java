package org.jsp.studentmanagement.dao;

import java.util.List;
import java.util.Optional;


import org.jsp.studentmanagement.dto.Student;
import org.jsp.studentmanagement.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {
	@Autowired
	private StudentRepository repository;
	
	public Student saveStudent(Student student) {
		return repository.save(student);
	}
	
	public Optional<Student> findById(int id) {
		return repository.findById(id);
	}
	
	public Student loginStudent(String email) {
		return repository.loginStudent(email);
	}

	public Student deleteById(int id) {
		return repository.deleteById(id);
	}
	
//	public Student updateStudent(Student student) {
//		Optional<Student> studentdb=findById(student.getId());
//		if(studentdb.isPresent()) {
//			return repository.save(studentdb);
//		}
//		else {
//			return null;
//		}
//	}
	
	public List<Student> fetchallstudents() {
		return repository.findAll();
	}
}
