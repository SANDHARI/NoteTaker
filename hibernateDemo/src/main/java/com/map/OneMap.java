package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OneMap {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//Creating Question
		
		Question q1= new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("What is Java ?");
		
		
		//Creating answer
		
		Answer ans= new Answer();
		ans.setAnswerId(343);
		ans.setAnswer("Programming lang");
		ans.setQuestion(q1);
		
		
		Answer ans1= new Answer();
		ans1.setAnswerId(33);
		ans1.setAnswer("Introduced functional prog");
		ans1.setQuestion(q1);
		
		Answer ans2= new Answer();
		ans2.setAnswerId(363);
		ans2.setAnswer("Contains Collections");
		ans2.setQuestion(q1);
		
		List<Answer> list = new ArrayList<Answer>();
		list.add(ans);
		list.add(ans1);
		list.add(ans2);
		
		q1.setAnswers(list);
		
		
		/*
		 * Question q2= new Question(); q2.setQuestionId(242);
		 * q2.setQuestion("What is Collection Framework?");
		 * 
		 * 
		 * //Creating answer
		 * 
		 * Answer ans1= new Answer(); ans1.setAnswerId(344);
		 * ans1.setAnswer("API to work with group objs"); q2.setAnswer(ans1);
		 * ans1.setQuestion(q2);
		 */
		

		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
//		session.save(q1);
//		session.save(ans);
//		session.save(ans1);
//		session.save(ans2);
		
		
		Question q=(Question)session.get(Question.class, 1212);
		
		System.out.println(q.getQuestion());
		
		for(Answer a: q.getAnswers()) {
			System.out.println(a.getAnswer());
		}
		
		
		
		
		
		/*
		 * session.save(q1); session.save(ans);
		 * 
		 * session.save(q2); session.save(ans1);
		 */

		tx.commit();
		
		//Question qa = (Question)session.get(Question.class, 1212);
		
		
		//System.out.println(qa.getQuestion());
		//System.out.println(qa.getAnswer().getAnswer());

		session.close();
		

	}

}
