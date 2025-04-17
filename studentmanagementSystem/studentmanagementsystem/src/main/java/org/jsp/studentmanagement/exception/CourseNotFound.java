package org.jsp.studentmanagement.exception;

public class CourseNotFound extends RuntimeException{
	String msg;
	public CourseNotFound(String msg) {

		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		
		return msg;
	}
	
}
