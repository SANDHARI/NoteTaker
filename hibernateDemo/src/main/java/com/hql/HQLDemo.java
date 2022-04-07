package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernate.Student;

public class HQLDemo {
	public static void main(String[] args) {
		
		SessionFactory factory= new Configuration().configure().buildSessionFactory();
		//HQL Syntax
		
		String query= "from Student as s where s.city=:x and s.name=:n";
		
		Session s= factory.openSession();
		
		Query q = s.createQuery(query);
		q.setParameter("x", "Hyd");
		q.setParameter("n", "Shiva");
		
		List<Student> slist = q.list();
		
		for(Student s1:slist) {
			System.out.println(s1.getName()+ " " + s1.getCity());
			
			
		}
		System.out.println("-----------------------");
		
		Transaction tx= s.beginTransaction();
		
		// Delete Query
//		Query q1 = s.createQuery("delete from Student as s where s.city=:c");
//		q1.setParameter("c", "Hyd");
//		int res = q1.executeUpdate();
//		System.out.println("Deleted " + res);
		
		
		//Update Query
		
//		Query q2 = s.createQuery("update Student set city=:c where name=:n");
//		
//		q2.setParameter("c", "Hyderabad");
//		q2.setParameter("n", "Hanuman");
//		
//		int res1 = q2.executeUpdate();
//		System.out.println(res1 + " record updated");
		
		
		//Join Query
		
		Query q3 = s.createQuery("select q.question, q.questionId,a.answer from Question as q INNER JOIN q.answers as a");
		List<Object []> list3 = q3.getResultList();
		
		for(Object[] arr : list3) {
			System.out.println(Arrays.toString(arr));
			
		}
		
		
		
		
		tx.commit();
		
		
		s.close();
		
		
		
		factory.close();
		
	}

}
