package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		//create session factory 
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory(); 
				//create session 
				Session session = factory.getCurrentSession(); 
				
				try {
					// create 3 objects
					System.out.print("Creating three  student object...");
					Student tempStudent = new Student("John", "Wall", "paul2745@yahoo.com");
					Student tempStudent2 = new Student("Taro", "Serigano", "paul2@yahoo.com");
					Student tempStudent3= new Student("Bonito", "BRown", "pau643l@yahoo.com");

					session.beginTransaction(); 
					
					System.out.print("Saving the student...");
					session.save(tempStudent); 
					session.save(tempStudent2); 
					session.save(tempStudent3); 

					//commit transaction 
					System.out.print("Done!");
					
					//commit transaction 
					session.getTransaction().commit(); 

					
				}finally {
					factory.close(); 
				}

			}


	}


