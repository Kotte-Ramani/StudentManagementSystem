package org.jsp.studentmanagement.service;

import org.jsp.studentmanagement.dao.AdminDao;
import org.jsp.studentmanagement.dto.Admin;
import org.jsp.studentmanagement.dto.Course;
import org.jsp.studentmanagement.exception.EmailNotFound;
import org.jsp.studentmanagement.exception.PasswordInvalid;
import org.jsp.studentmanagement.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
	@Autowired
	private AdminDao dao;
	
	public ResponseStructure<Admin> structure =new ResponseStructure<Admin>();
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(Admin admin) {
		 
		 structure.setData(dao.saveAdmin(admin));
		 structure.setMsg("admin details saved successfully");
		 structure.setStatusCode(HttpStatus.ACCEPTED.value());
		 return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.ACCEPTED);
	}
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(Admin admin) {
		Admin admindb=dao.loginAdmin(admin.getEmail());
		if(admindb!=null) {
			if(admindb.getPassword().equals(admin.getPassword())) {
				structure.setData(admindb);
				structure.setMsg("login successfull");
				structure.setStatusCode(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
			}
			else {
				throw new  PasswordInvalid("password incorrect");
			}
		}
		else {
			throw new EmailNotFound("email incorrect");
		}
	}

}
