package com.techlabs.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.Action;
import com.techlabs.entity.Student;
import com.techlabs.service.StudentService;

public class StudentAction implements Action{

	@Autowired
	StudentService service;
	
	@Override
	public String execute() throws Exception {
		//Student s=new Student("shekhar");
		//service.addStudent(s);
		service.readStudent();
		return this.SUCCESS;
	}
	
	
}
