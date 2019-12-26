package com.techlabs.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.techlabs.entity.Student;


@Repository("studentRepo")
public class StudentRepo {

	@Autowired
	SessionFactory sessionFactory;
	Session session;
	Transaction tr;
	
	public StudentRepo() {
		System.out.println("repo");
	}
	
	public void add(Student student) {
		session=sessionFactory.openSession();
		tr=session.beginTransaction();
		session.save(student);
		tr.commit();
	}
	public void readStudent(){
		session=sessionFactory.openSession();
		tr=session.beginTransaction();
		Query query=session.createQuery("from Student");
		List<Student> students=query.list();
		for(Student s:students) {
			System.out.println("id"+s.getId());
			System.out.println("name:"+s.getName());
		}
	}
}
