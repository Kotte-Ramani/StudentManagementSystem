package org.jsp.studentmanagement.repository;

import java.util.Optional;


import org.jsp.studentmanagement.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Optional<Student> findById(int id);
	Student deleteById(int id);

	@Query("select s from Student s where s.email=?1")
	public Student loginStudent(String email);
	
}
