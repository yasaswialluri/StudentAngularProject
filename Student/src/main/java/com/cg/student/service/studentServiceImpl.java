package com.cg.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.student.dao.StudentDao;
import com.cg.student.entity.Student;
@Service
public class studentServiceImpl implements StudentService{

	@Autowired
	StudentDao studentDao;
	
	
	@Override
	public Student addStudent(Student student) {
		Student students = studentDao.saveAndFlush(student);
		return student;
	}

	@Override
	public List<Student> listAllStudent() {
		List<Student> listStudent = studentDao.findAll();
		return listStudent;
	}

}
