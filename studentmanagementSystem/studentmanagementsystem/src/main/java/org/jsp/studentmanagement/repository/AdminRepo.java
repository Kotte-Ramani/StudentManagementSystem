package org.jsp.studentmanagement.repository;

import org.jsp.studentmanagement.dto.Admin;
import org.jsp.studentmanagement.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin, Integer> {
	@Query("select a from Admin a where a.email=?1")
	public Admin loginAdmin(String email);
}
