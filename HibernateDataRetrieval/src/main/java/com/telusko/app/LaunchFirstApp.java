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
            Student student = session.get(Student.class, 102); // Get the student with ID 101
            System.out.println(student); // Print the student
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