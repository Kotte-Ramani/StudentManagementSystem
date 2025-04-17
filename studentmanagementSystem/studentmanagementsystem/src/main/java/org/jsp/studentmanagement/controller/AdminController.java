package org.jsp.studentmanagement.controller;

import org.jsp.studentmanagement.dto.Admin;
import org.jsp.studentmanagement.service.AdminService;
import org.jsp.studentmanagement.util.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AdminController {
	@Autowired
	private AdminService service;
	@PostMapping("/saveadmin")
	public ResponseEntity<ResponseStructure<Admin>> saveAdmin(@RequestBody Admin admin) {
		return service.saveAdmin(admin);
	}
	@PostMapping("/loginadmin")
	public ResponseEntity<ResponseStructure<Admin>> loginAdmin(@RequestBody Admin admin) {
		return service.loginAdmin(admin);
	}

}
