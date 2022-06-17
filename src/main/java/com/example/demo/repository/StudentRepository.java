package com.example.demo.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {


//	List<Student> findAll();
	
	@Query("SELECT student FROM Student student WHERE student.hoten LIKE %:hoten%")
	List<Student> findStudentByName(@Param("hoten") String hoten);
	
	@Query("SELECT student FROM Student student WHERE student.ma LIKE %:ma%")
	List<Student> findStudentById(@Param("ma") String ma);
}
