package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Emp e1=new Emp();
		Emp e2=new Emp();
		
		e1.setEid(34);
		e1.setEname("Ram");
		
		e2.setEid(35);
		e2.setEname("Shyam");
		
		
		Project p1= new Project();
		Project p2= new Project();
		
		p1.setPid(12121);
		p1.setPname("Library Managment");
		
		p2.setPid(14141);
		p2.setPname("Chatbot");
		
		List<Emp> list1= new ArrayList<Emp>();
		List<Project> list2=new ArrayList<Project>();
		
		list1.add(e1);
		list1.add(e2);
		
		list2.add(p1);
		list2.add(p2);
		
		e1.setProjects(list2);
		
		p2.setEmps(list1);
		

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		session.save(e1);
		session.save(e2);
		session.save(p1);
		session.save(p2);

		tx.commit();

		session.close();

	}

}
