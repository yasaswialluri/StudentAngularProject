package com.cg.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.student.entity.Student;
@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

}
