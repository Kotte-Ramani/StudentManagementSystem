package org.jsp.studentmanagement.exception;

public class PasswordInvalid extends RuntimeException{
String msg;
	
	public PasswordInvalid (String msg) {

		this.msg=msg;
	}
	
	
	@Override
	public String getMessage() {
	
		return msg;
	}
}
