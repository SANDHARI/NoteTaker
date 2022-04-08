package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Hello World!");

		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

//        Student student = new Student(7452,"Bharath","Nizamabad");
//        
//        int r = studentDao.insert(student);
//        System.out.println(r);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean go=true;
		
		while (go) {
			System.out.println("Press 1 to add a new Student: ");
			System.out.println("Press 2 to display all Students: ");
			System.out.println("Press 3 to display single Student: ");
			System.out.println("Press 4 to delete a new Student: ");
			System.out.println("Press 5 to update a new Student: ");
			System.out.println("Press 6 to exit: ");

			try {

				int input = Integer.parseInt(br.readLine());

				switch (input) {
				//Add a new student
				case 1:
					
					System.out.println("Enter Student Id: ");
					int sId = Integer.parseInt(br.readLine());
					
					System.out.println("Enter Student Name: ");
					String sName = br.readLine();
					
					System.out.println("Enter Student City: ");
					String sCity = br.readLine();
					
					//Insertion using Constructor
					//Student student= new Student(sId,sName,sCity);
					
					//Insertion using Setters
					Student student= new Student();
					student.setStudentId(sId);
					student.setStudentName(sName);
					student.setStudentCity(sCity);
					
					int r = studentDao.insert(student);
					System.out.println(r + " Student Added Successfully");
					System.out.println("______________________");
					System.out.println();
				
					break;
				//To display all students	
				case 2:
					
					List<Student> slist = studentDao.getAllStudents();
					for(Student st:slist) {
						//Displaying using toString()
						//System.out.println(st);
						//Displaying using getters
						
						System.out.println("Id : " + st.getStudentId());
						System.out.println("Name : " + st.getStudentName());
						System.out.println("City : " + st.getStudentCity());
						System.out.println("_____________________________");
					
					}
					System.out.println("*********************************");

					break;
				//To display single Student
				case 3:
					
					System.out.println("Please enter a Student Id to display: ");
					int studentId = Integer.parseInt(br.readLine());
					Student st = studentDao.getStudent(studentId);
					System.out.println("Id : " + st.getStudentId());
					System.out.println("Name : " + st.getStudentName());
					System.out.println("City : " + st.getStudentCity());
					System.out.println("_____________________________");

					break;
				//To delete a new Student
				case 4:
					System.out.println("Please enter a Student Id to delete: ");
					int sid = Integer.parseInt(br.readLine());
					studentDao.deleteStudent(sid);
					System.out.println(sid + " Deleted successfully");

					break;
				//To update a new Student
				case 5:
					System.out.println("Enter Student Id: ");
					int usId = Integer.parseInt(br.readLine());
					
					System.out.println("Enter Student Name: ");
					String usName = br.readLine();
					
					System.out.println("Enter Student City: ");
					String usCity = br.readLine();
					Student uStudent= new Student(usId,usName,usCity);
					studentDao.updateStudent(uStudent);
					
					

					break;
				//To exit
				case 6:
					go=false;
					break;

				}

			} catch (Exception e) {
				System.out.println("Invalid Input. Please enter a valid input");
				System.out.println(e.getMessage());
			}

		}
		System.out.println("Thank you! Have a great day!!");
	}
}
