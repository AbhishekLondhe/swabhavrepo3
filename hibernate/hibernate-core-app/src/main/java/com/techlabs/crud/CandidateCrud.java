package com.techlabs.crud;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.techlabs.entity.Candidate;

public class CandidateCrud {
	public static void main(String args[]) {
	
		List<Candidate> candidates = retrieveCandidate();
		for (Candidate c : candidates) {
			System.out.println("id" + c.getId() + " name" + c.getName() + " cgpa:" + c.getCgpa());
		}
		updateCandidate(1);
	}

	public static List<Candidate> retrieveCandidate() {
		List<Candidate> candidateList = new ArrayList<Candidate>();
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Query query = session.createQuery("From Candidate");
		candidateList = query.list();
		return candidateList;
	}

	public static void deleteCandidate(int id) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println(factory.getClass());
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		Candidate candidate = (Candidate) session.load(Candidate.class, id);
		session.delete(candidate);
		session.getTransaction().commit();
		session.close();
	}

	public static void updateCandidate(int id) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		System.out.println(factory.getClass());
		Session session = factory.openSession();
		Transaction tr = session.beginTransaction();
		Candidate c = (Candidate) session.get(Candidate.class, id);
		c.setName("abc");
		System.out.println("Updated Successfully");
		session.getTransaction().commit();
		factory.close();
	}
}
