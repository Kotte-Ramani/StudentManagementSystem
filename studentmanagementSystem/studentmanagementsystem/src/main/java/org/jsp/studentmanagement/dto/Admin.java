package org.jsp.studentmanagement.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String 	firstName;
	private String lastName;
	private long mobileNumber;
	private String address;
	@Column(unique = true)
	private String email;
	private String password;
	
	

}
