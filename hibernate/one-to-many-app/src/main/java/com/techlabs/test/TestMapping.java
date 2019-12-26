package com.techlabs.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.techlabs.entity.Department;
import com.techlabs.entity.Employee;

public class TestMapping {
	public static void main(String args[]) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			Department dept = new Department("banking", "mumbai");
			session.save(dept);
			Set<Employee> emps=new HashSet<Employee>();
			Employee e1=new Employee("abhishek");
			e1.setDept(dept);
			Employee e2=new Employee("deepak");
			e2.setDept(dept);
			emps.add(e1);
			emps.add(e2);
			dept.setEmployees(emps);
			session.save(e1);
			session.save(e2);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
		} finally {
			session.close();
		}
	}
}
