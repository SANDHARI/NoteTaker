package com.hibernate;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Started!" );
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        //Creating Student
        
        Student st1= new Student();
        st1.setId(52);
        st1.setName("Henry");
        st1.setCity("New york");
        
        
        Address add= new Address();
        add.setStreet("Tattikote");
        add.setCity("Bodhan");
        add.setOpen(true);
        add.setAddedDate(new Date());
        add.setX(2.0);
        
        
        //Reading Image
        FileInputStream fis = new FileInputStream("src/main/java/Photo.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        add.setImage(data);
        
        Session session = factory.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(st1);
        session.save(add);
        
        tx.commit();
        
        
        session.close();
        
        System.out.println("Done");
        
        
        
    }
}
