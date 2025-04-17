package org.jsp.studentmanagement.util;

import java.time.LocalDateTime;
import java.util.List;

import org.jsp.studentmanagement.dto.Student;

import lombok.Data;
@Data
public class ResponseStructureList<T> {
	private String msg;
	private int statusCode;
	private List<T> data;
	private LocalDateTime dataTime=LocalDateTime.now();
	
	
}
