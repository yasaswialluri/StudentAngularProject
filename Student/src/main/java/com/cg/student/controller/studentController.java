package com.cg.student.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.student.entity.Student;
import com.cg.student.exceptions.IdNotFoundException;
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
	
	@PutMapping("student/update/{studentId}")
	public ResponseEntity<Student> updateStudent(@PathVariable("studentId") int studentId,@Valid @RequestBody Student student){
		ResponseEntity<Student> re;
		try {
			Student students = studentService.updateStudent(student, studentId);
			re=new ResponseEntity<Student>(students,HttpStatus.OK);
		}
		catch(IdNotFoundException e)
		{
			re=new ResponseEntity("StudentId "+studentId+" doesnot exist",HttpStatus.BAD_REQUEST);
		}
		return re;
		
	}
	
	@GetMapping("student/{studentId}")
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") int studentId){
		ResponseEntity<Student> re;
		try {
			Student students = studentService.getStudentById(studentId);
			re=new ResponseEntity<Student>(students,HttpStatus.OK);
		}
		catch(IdNotFoundException e)
		{
			re=new ResponseEntity("StudentId "+studentId+" doesnot exist",HttpStatus.BAD_REQUEST);
		}
		return re;
		
	}
	

	
//	@DeleteMapping("student/delete/{studentId}")
//	public String deletStudentById(@PathVariable("studentId") List<Integer> studentId){
//		String message="";
//		
//			 message= studentService.deleteStudent(studentId);
//		
//		return message;
//		
//	}
	
 	@DeleteMapping("student/delete/{studentId}")
	public void delteStudents(@PathVariable("studentId")List<Integer> studentId) throws IdNotFoundException
	{
		String message="";
		try {
		studentService.deleteStudent(studentId);
		message="Deleted Successfully";
		}
		catch(IdNotFoundException e)
		{
			message= e.getMessage();
		}
//		return message;
	}
 	@DeleteMapping("student/deleteAll")
 	public void deleteAllRecords()
 	{
 		studentService.deleteAll();
 	}
}
