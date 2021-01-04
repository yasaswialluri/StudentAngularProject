package com.cg.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.student.dao.StudentDao;
import com.cg.student.entity.Student;
import com.cg.student.exceptions.IdNotFoundException;
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

	@Override
	public Student updateStudent(Student student, int studentId) throws IdNotFoundException{
		
		boolean isPresent = studentDao.existsById(studentId);
		if(isPresent)
		{
			studentDao.saveAndFlush(student);
		}
		else 
		{
			throw new IdNotFoundException("StudentId "+studentId+" Doesnot Exist");
		}
		return student;
	}

	@Override
	public Student getStudentById(int studentId) throws IdNotFoundException {
		boolean isPresent = studentDao.existsById(studentId);
		Student student;
		if(isPresent)
		{
			student = studentDao.findById(studentId).get();
		}
		else 
		{
			throw new IdNotFoundException("StudentId "+studentId+" Doesnot Exist");
		}
		return student;
		
	}
	
	

}
