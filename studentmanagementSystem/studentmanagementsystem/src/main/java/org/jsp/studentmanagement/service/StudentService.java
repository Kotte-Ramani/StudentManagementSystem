package org.jsp.studentmanagement.service;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.jsp.studentmanagement.dao.CourseDao;
import org.jsp.studentmanagement.dao.StudentDao;
import org.jsp.studentmanagement.dto.Course;
import org.jsp.studentmanagement.dto.Student;
import org.jsp.studentmanagement.exception.CourseNotFound;
import org.jsp.studentmanagement.exception.EmailNotFound;
import org.jsp.studentmanagement.exception.IdNotFound;
import org.jsp.studentmanagement.exception.PasswordInvalid;
import org.jsp.studentmanagement.util.EmailUtil;
import org.jsp.studentmanagement.util.ResponseStructure;
import org.jsp.studentmanagement.util.ResponseStructureList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentdao;
	
	@Autowired
	private EmailUtil emailutil;
	
	@Autowired
	private CourseDao coursedao;
	
	private ResponseStructure<Student> structure=new ResponseStructure<Student>();
    private ResponseStructureList<Course> structures=new ResponseStructureList<Course>();
	private ResponseStructureList<Student> structurest=new ResponseStructureList<Student>();
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student){
		structure.setData(studentdao.saveStudent(student));
		structure.setMsg("data saved");
		structure.setStatusCode(HttpStatus.CREATED.value());
		emailutil.sendEmail(student.getEmail());
		return new ResponseEntity<ResponseStructure<Student>>
		(structure , HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Student>> loginStudent(Student student) {
		Student studentdb=studentdao.loginStudent(student.getEmail());
		if (studentdb!=null) {
			if(studentdb.getPassword().equals(student.getPassword())) {
				structure.setData(studentdb);
				structure.setMsg("login successfull");
				structure.setStatusCode(HttpStatus.ACCEPTED.value());
				emailutil.sendEmailForLogin(student.getEmail());
				return new ResponseEntity<ResponseStructure<Student>>
				(structure , HttpStatus.ACCEPTED);
			}else {
				throw new PasswordInvalid("Incorrect password");
			}
		}
		else {
			throw new EmailNotFound("invalid email id");
		}
	}
	
	
	
	public ResponseEntity<ResponseStructure<Student>> findStudentById(int id) {
		Optional<Student> studentdb=studentdao.findById(id);
		if(studentdb.isPresent()) {
			Student students=studentdb.get();
			structure.setData(students);
			structure.setMsg("student id found");
			structure.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure , HttpStatus.FOUND);
		}
		else {
			throw new IdNotFound("student id not found");
		}
	}
	
	
	
	
	public ResponseEntity<ResponseStructure<Student>> addCourse(int id,int cid){
		
		
		Optional<Student> studentdb= studentdao.findById(id);
		Optional<Course> coursedb= coursedao.findById(cid);
		
		if(studentdb.isPresent()&&coursedb.isPresent()) {
			Student students=studentdb.get();
			Course courses=coursedb.get();
			List<Course> listofcourse=students.getCourse();
			if(listofcourse==null) {
				listofcourse=new ArrayList<>();
			}
			listofcourse.add(courses);
			students.setCourse(listofcourse);
			studentdao.saveStudent(students);
			structure.setData(students);
			structure.setMsg("course added");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			
			return new ResponseEntity<ResponseStructure<Student>>
			(structure , HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFound("courses not added");
		}
	
	}
	
	public ResponseEntity<ResponseStructureList<Course>> fetchCourses(int id) {
		Optional<Student> studentdb=studentdao.findById(id);
		if(studentdb.isPresent()) {
			Student st=studentdb.get();
			List<Course> listofCourses=st.getCourse();
			structures.setMsg("course details");
			structures.setData(listofCourses);
			structures.setStatusCode(HttpStatus.ACCEPTED.value());
			
			return new ResponseEntity<ResponseStructureList<Course>>(structures,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFound("student id not found") ;
		}
	}
	
	public ResponseEntity<ResponseStructure<Student>> deleteCourse(int id,int cid) {
		Optional<Student> studentdb=studentdao.findById(id);
		Optional<Course> coursedb=coursedao.findById(cid);
		if(studentdb.isPresent()&&coursedb.isPresent()) {
			Student students=studentdb.get();
			List<Course> courses=students.getCourse();
			if(courses.contains(coursedb.get())) {
				courses.remove(coursedb.get());
				students.setCourse(courses);
			}
			else {
				throw new CourseNotFound("course not found");
			}
			
			structure.setData(studentdao.saveStudent(students));
			structure.setMsg("course deleted");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFound("student id not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<Student>> uploadimage(int id,MultipartFile file) throws IOException {
		Optional<Student> studentdb=studentdao.findById(id);
		if(studentdb.isPresent()) {
			Student stb=studentdb.get();
			stb.setImage(file.getBytes());
			structure.setData(studentdao.saveStudent(stb));
			structure.setMsg("image uploaded successfull");
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.ACCEPTED);
			}
		else {
			throw new IdNotFound("student id not found");
		}
	}
	
	
	public ResponseEntity<byte[]> fetchImage(int id) {
		Optional<Student> studentdb=studentdao.findById(id);
		if(studentdb.isPresent()) {
			Student st=studentdb.get();
			byte[] img=st.getImage();
			HttpHeaders headers=new HttpHeaders();
			headers.setContentType(MediaType.IMAGE_JPEG);
			return new ResponseEntity<byte[]>(img,headers,HttpStatus.OK);
		}
		else {
			throw new IdNotFound("Student id not found");
		}
	}
	
	
	
	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student ) {
		Optional<Student> studentdb=studentdao.findById(student.getId());
		if(studentdb.isPresent()) {
			Student st=studentdb.get();
			st.setFirstName(student.getFirstName());
			st.setLastName(student.getLastName());
			st.setEmail(student.getEmail());
			st.setAddress(student.getAddress());
			st.setMobileNumber(student.getMobileNumber());
			
			structure.setMsg("student data updated");
			structure.setData(studentdao.saveStudent(st));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFound("student not found");
		}
	}
	
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int id) {
		Optional<Student> studentdb=studentdao.findById(id);
		if(studentdb.isPresent()) {
			Student st=studentdb.get();
			
			structure.setMsg("student data deleted");
			structure.setData(studentdao.deleteById(id));
			structure.setStatusCode(HttpStatus.ACCEPTED.value());
			return new ResponseEntity<ResponseStructure<Student>>(structure,HttpStatus.ACCEPTED);
		}
		else {
			throw new IdNotFound("student id not found");
		}
	}
	
	public ResponseEntity<ResponseStructureList<Course>> fetchall() {
		List<Course> coursedb=coursedao.fetchall();
		structures.setData(coursedb);
		structures.setMsg("List of courses");
		structures.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructureList<Course>>(structures,HttpStatus.ACCEPTED);
		
	}
	
	
	public ResponseEntity<ResponseStructureList<Student>> fetchallstudents() {
		List<Student> studentdb=studentdao.fetchallstudents();
		structurest.setData(studentdb);
		structurest.setMsg("List of students");
		structurest.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructureList<Student>>(structurest,HttpStatus.ACCEPTED);
	}
	//@crossorigine
}
