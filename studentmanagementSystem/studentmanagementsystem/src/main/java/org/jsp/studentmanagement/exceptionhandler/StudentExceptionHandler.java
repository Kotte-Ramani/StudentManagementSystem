package org.jsp.studentmanagement.exceptionhandler;



import org.jsp.studentmanagement.exception.CourseNotFound;
import org.jsp.studentmanagement.exception.EmailNotFound;
import org.jsp.studentmanagement.exception.IdNotFound;
import org.jsp.studentmanagement.exception.PasswordInvalid;
import org.jsp.studentmanagement.util.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFound  idNotFound){
//		ResponseEntity<String> entity=new ResponseEntity<String>(userException.getMessage(),HttpStatus.NOT_FOUND);
//		return entity;
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(idNotFound.getMessage());
		structure.setMsg("not found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(CourseNotFound.class)
	public ResponseEntity<ResponseStructure<String>> courseNotFound(CourseNotFound courseNotFound){
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(courseNotFound.getMessage());
		structure.setMsg("course not found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmailNotFound.class)
	public ResponseEntity<ResponseStructure<String>> emailNotfound(EmailNotFound emailNotFound) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(emailNotFound.getMessage());
		structure.setMsg("login failed");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(PasswordInvalid.class)
	public ResponseEntity<ResponseStructure<String>> passwordInvalid(PasswordInvalid passwordInvalid) {
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData(passwordInvalid.getMessage());
		structure.setMsg("login failed");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
	
	
}
