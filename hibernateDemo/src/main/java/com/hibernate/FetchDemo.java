package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		
		
		Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        Student student=(Student)session.load(Student.class, 52);
        System.out.println(student);
        
        Address ad= (Address)session.get(Address.class, 1);
        System.out.println(ad.getStreet());
        
        tx.commit();
        session.close();
        factory.close();
		
	}

}
