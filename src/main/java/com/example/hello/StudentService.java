package com.example.hello;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class StudentService {

	@Autowired
	private StudentRepository studentrepo;

	public List<Student> getAllStudent() {
		List<Student> students = new ArrayList<Student>();
		studentrepo.findAll().forEach(student -> students.add(student));
		return students;
	}

	public Student getStudentId(int id) {
		return studentrepo.findById(id).get();
	}

	public void deleteStudentID(int id) {
		studentrepo.deleteById(id);
	}

	public void saveOrUpdate(Student student) {
		studentrepo.save(student);
	}

}
