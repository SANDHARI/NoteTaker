package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		Question q1=new Question();
		q1.setQuestionId(748);
		q1.setQuestion("What is Cascading");
		
		Answer a1 = new Answer(23423, "In 1 hibernate");
		Answer a2 = new Answer(23424, "In 2 hibernate");
		Answer a3 = new Answer(23425, "In 3 hibernate");
		List<Answer> list=new ArrayList();
		list.add(a1);
		list.add(a2);
		list.add(a3);
		
		q1.setAnswers(list);
		Transaction tx = session.beginTransaction();
		
		session.save(q1);
		
		tx.commit();
		session.close();
		factory.close();

	}

}
