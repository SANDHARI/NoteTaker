package com.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.Student;
import com.mapping.xml.Person;

public class CriteriaExample {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Session s = new Configuration().configure().buildSessionFactory().openSession();
		
		Criteria c = s.createCriteria(Student.class);
		
		//c.add(Restrictions.eq("city", "Hyderabad"));
		c.add(Restrictions.eq("certi.course", "Java Hibernate couser"));
		
		List<Student> slist = c.list();
		for(Student st: slist) {
			System.out.println(st);
		}

		
		
		s.close();
		
	}
	

}
