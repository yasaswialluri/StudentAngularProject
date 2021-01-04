package com.cg.student.service;

import java.util.List;

import com.cg.student.entity.Student;
import com.cg.student.exceptions.IdNotFoundException;

public interface StudentService {

	public Student addStudent(Student student);
	public List<Student> listAllStudent();
	public Student updateStudent(Student student,int studentId) throws IdNotFoundException;
	public Student getStudentById(int studentId) throws IdNotFoundException;
}
