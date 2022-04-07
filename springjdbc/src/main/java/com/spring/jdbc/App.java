package com.spring.jdbc;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entity.Student;

public class App 
{
    public static void main( String[] args )
    {
      
    	//ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
    	
    	ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
    	
    	StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
    	
    	//Student student = new Student();
    	
    	//insert
//    	student.setId(696);
//    	student.setName("Shiva");
//    	student.setCity("Delhi");
    	
//    	int res = studentDao.insert(student);
//    	System.out.println("Student added: " + res);
//    	
    	//update
//    	student.setId(696);
//    	student.setName("Maheswara");
//    	student.setCity("Bangalore");
//    	
//    	int res = studentDao.change(student);
//    	System.out.println("Student with " + student.getId() +  "updated: " + res);
    	
    	
    	//Delete
//    	Scanner s= new Scanner(System.in);
//    	System.out.println("Enter the id to delete");
//    	int id = s.nextInt();
//    	
//    	int res = studentDao.delete(id);
//    	System.out.println("Deleted " +  res);
//    	
//    	Student res = studentDao.getStudent(652);
//    	System.out.println(res);
    	
    	List<Student> students = studentDao.getAllStudents();
    	for(Student s:students) {
    		System.out.println(s);
    	}
    	
    }
}
