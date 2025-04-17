package org.jsp.studentmanagement.exception;

public class IdNotFound extends RuntimeException{
	String msg;
	public IdNotFound(String msg) {

		this.msg=msg;
	}
	
	@Override
	public String getMessage() {
		
		return msg;
	}
	
}
