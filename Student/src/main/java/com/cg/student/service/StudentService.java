package com.cg.student.service;

import java.util.List;

import com.cg.student.entity.Student;

public interface StudentService {

	public Student addStudent(Student student);
	public List<Student> listAllStudent();
}
