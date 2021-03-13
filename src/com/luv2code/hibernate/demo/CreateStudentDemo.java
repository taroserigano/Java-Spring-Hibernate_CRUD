package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {


		//create session factory 
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory(); 
		//create session 
		Session session = factory.getCurrentSession(); 
		
		try {
			System.out.print("Creating new student object...");
			Student tempStudent = new Student("Paul", "Wall", "paul@yahoo.com");
			
			session.beginTransaction(); 
			
			System.out.print("Saving the student...");
			session.save(tempStudent); 
			
			//commit transaction 
			System.out.print("Done!");
			
			//commit transaction 
			session.getTransaction().commit(); 

			
		}finally {
			factory.close(); 
		}

	}

}
