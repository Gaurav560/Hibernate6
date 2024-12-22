package com.telusko.app;

import com.telusko.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class LaunchFirstApp {
    public static void main(String[] args) {
        // Declare all required Hibernate objects as null initially
        Configuration cfg = null;
        SessionFactory sessionFactory = null;
        Session session = null;

        sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        try {
            session = sessionFactory.openSession(); // Open a session
//           used to get one object from the database

//            deprecated
//            this will give null when object with particular given id is not found
//           Student student = session.get(Student.class, 102); // Get the student with ID 101

//           deprecated
//            Student student = session.load(Student.class, 102); // Get the student with ID 101

//             for hibernate 6 getReference is used instead of load and get
//            when object with particular given id is not found, it will give ObjectNotFoundException
            Student student = session.getReference(Student.class, 105); // Get the student with ID 101






            if (student != null) {
                System.out.println("id is " + student.getSid());
                System.out.println("name is " + student.getsName());
                System.out.println("city is " + student.getsCity());
            } else {
                System.out.println("there is no student with id " + student.getSid());
            }

        } catch (HibernateException he) {
            // Handle Hibernate specific exceptions
            he.printStackTrace();
        } catch (Exception e) {
            // Handle any other exceptions
            e.printStackTrace();
        } finally {
            // Step 7: Clean up resources
            session.close();        // Close the session
            sessionFactory.close(); // Close the session factory

        }
    }
}