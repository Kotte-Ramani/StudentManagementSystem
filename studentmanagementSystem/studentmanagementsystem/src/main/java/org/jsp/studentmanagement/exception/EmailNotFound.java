package org.jsp.studentmanagement.exception;

public class EmailNotFound extends RuntimeException{
String msg;
	
	public EmailNotFound (String msg) {

		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		
		return msg;
	}
}
