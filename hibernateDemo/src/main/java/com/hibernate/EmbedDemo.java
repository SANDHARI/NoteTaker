package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedDemo {

	public static void main(String[] args) {
		

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Student st1 = new Student();
		st1.setId(42);
		st1.setName("Peter");
		st1.setCity("New Jersey");
		
		Certificate certi= new Certificate();
		certi.setCourse("Java");
		certi.setDuration("2 months");
		
		st1.setCerti(certi);
		
		
		Student st2 = new Student();
		st2.setId(89);
		st2.setName("Williams");
		st2.setCity("Los angeles");
		
		Certificate certi1= new Certificate();
		certi1.setCourse("Python");
		certi1.setDuration("3 months");
		
		st2.setCerti(certi1);
	

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		session.save(st1);
		session.save(st2);

		
		tx.commit();
		session.close();
		factory.close();

	}

}
