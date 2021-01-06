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

	public void studentExist(int studentId) throws IdNotFoundException
	{
		if(studentDao.existsById(studentId)) {
			studentDao.deleteById(studentId);
		}
		else
		{
			throw new IdNotFoundException("StudentId "+studentId+" doesnot exist");
		}
		
	}
	@Override
	public void deleteStudent(List<Integer> studentId) throws IdNotFoundException {
		for(Integer id:studentId)
		{
			studentExist(id);
		}
		
	}

	@Override
	public void deleteAll() {
		studentDao.deleteAll();
		
	}

//	@Override
//	public String deleteStudent(List<Integer> studentId)  {
//		Student student=null;
//		String message="";
//		for(Integer id:studentId)
//		{
//			if(studentDao.existsById(id))
//			{
//			studentDao.deleteById(id);
//			message="Deleted Student with Id"+id;
//			}
//			else
//			{
//				message="Not Exist";
//				
//			}
//			
//			
//		}
//		return message;
//	}
//	
	

}
