package com.cg.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.student.entity.Student;
import com.cg.student.service.StudentService;

@RestController
@CrossOrigin("*")
public class studentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("student")
	public ResponseEntity<Student> addStudent(@Valid@RequestBody Student student)
	{
		Student students = studentService.addStudent(student);
		ResponseEntity<Student> re = new ResponseEntity<Student>(students,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("student")
	public ResponseEntity<List<Student>> listAllStudent()
	{
		List<Student> students = studentService.listAllStudent();
		ResponseEntity<List<Student>> re = new ResponseEntity<List<Student>>(students,HttpStatus.OK);
		return re;
	}
}
