package com.example.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.hello.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	@GetMapping("/student")
	private List<Student> getAllStudent(){
		return studentservice.getAllStudent();
	}
	
	@GetMapping("/student/{id}")
	private Student getstudent(@PathVariable("id") int id) {
		return studentservice.getStudentId(id);
	}
	
	@PostMapping("/student")
	private int saveStudent(@RequestBody Student student) {
		studentservice.saveOrUpdate(student);
		return student.getId();
	}
	@DeleteMapping("/student/{id}")
	private void deleteStudent(@PathVariable("id") int id) {
		 studentservice.deleteStudentID(id);
	}
}
