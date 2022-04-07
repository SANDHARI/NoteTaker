package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class HQLPagination {

	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		Session s= factory.openSession();
		
		Query query = s.createQuery("from Student");
		//Implementing pagination using hibernate
		
		query.setFirstResult(10);
		
		query.setMaxResults(7);
		
		List<Student> list = query.list();
		
		for(Student st: list) {
			
			System.out.println(st.getName() + " " + st.getCity() + " " + st.getId());
		}
		
		
		
		factory.close();

	}

}
