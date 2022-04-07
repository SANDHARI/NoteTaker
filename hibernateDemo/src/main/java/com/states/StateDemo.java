package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.Certificate;
import com.hibernate.Student;

public class StateDemo {

	public static void main(String[] args) {

		// Hibernate Object States: Transient, Persistent, Detached, Removed

		System.out.println("Started");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Student student = new Student();
		student.setId(1417);
		student.setName("Shiva");
		student.setCity("Hyd");
		student.setCerti(new Certificate("C Hibernate Couser", "4 months"));
		// Student in Transient state

		Session s = factory.openSession();
		Transaction tx = s.beginTransaction();
		s.save(student);
		// Student: persistent state-session and database

		//student.setName("Ram");

		tx.commit();

		s.close();
		//Student: Detached State
		//student.setName("Shiva");

		factory.close();

	}

}
