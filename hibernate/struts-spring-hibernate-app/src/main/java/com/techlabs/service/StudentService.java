package com.techlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techlabs.entity.Student;
import com.techlabs.repository.StudentRepo;

@Service
public class StudentService {

	@Autowired
	StudentRepo repo;
	
	public StudentService() {
		System.out.println("service");
	}
	
	public void addStudent(Student student) {
		repo.add(student);
	}
	public void readStudent() {
		repo.readStudent();
	}
}
