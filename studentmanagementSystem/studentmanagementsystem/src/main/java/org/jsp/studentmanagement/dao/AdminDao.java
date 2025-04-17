package org.jsp.studentmanagement.dao;

import org.jsp.studentmanagement.dto.Admin;
import org.jsp.studentmanagement.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDao {
	@Autowired
	private AdminRepo repo;
	
	public Admin saveAdmin(Admin admin) {
		return repo.save(admin);
	}
	public Admin loginAdmin(String email) {
		return repo.loginAdmin(email);
	}
}
