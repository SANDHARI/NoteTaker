package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernate.Student;

public class SQLExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		// SQL query
		String q= "select * from student";
		
		NativeQuery nq = session.createSQLQuery(q);
		
		List<Object[]> list = nq.list();
		
		for(Object[] s:list)
		{
			System.out.println(Arrays.toString(s));
			System.out.println(s[4] + " " +s[3]);
		}	
		
		
		
		
		session.close();
		factory.close();

	}

}
