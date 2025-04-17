package org.jsp.studentmanagement.util;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.jsp.studentmanagement.dto.Course;
import org.jsp.studentmanagement.dto.Student;

import lombok.Data;
@Data
public class ResponseStructure<T> {

	private String msg;
	private int statusCode;
	private T data;
	private LocalDateTime dataTime=LocalDateTime.now();
	
	
}
