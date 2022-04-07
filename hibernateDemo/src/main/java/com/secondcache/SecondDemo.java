package com.secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.Student;

public class SecondDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session1 = factory.openSession();

		Student student1 = session1.get(Student.class, 1416);
		System.out.println(student1);

		session1.close();
		
		
		Session session2 = factory.openSession();
		
		Student student2 = session2.get(Student.class, 1416);
		System.out.println(student2);

		session2.close();
		
		
		factory.close();

	}

}
