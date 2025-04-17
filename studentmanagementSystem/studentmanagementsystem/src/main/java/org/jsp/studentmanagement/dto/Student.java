package org.jsp.studentmanagement.dto;



import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;

import lombok.Data;


@Entity
@Data
public class Student {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstName;
	private String lastName;
	@Column(unique = true)
	private String email;
	private String address;
	private long mobileNumber;
	@Lob
	@Column(columnDefinition = "longblob", length=999999999)
	private byte image[];
	private String password;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable
	private List<Course> course;
}
