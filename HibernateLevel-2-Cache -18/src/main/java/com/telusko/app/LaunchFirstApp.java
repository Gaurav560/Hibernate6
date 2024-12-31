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
        Session session1 = null;
        Session session2 = null;

        sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        try {
            session1 = sessionFactory.openSession(); // Open a session
            session2 = sessionFactory.openSession(); // Open a session


//
            Student student1 = session1.get(Student.class, 102);
            System.out.println(student1);
            // Get the student with ID 101
            Student student2 = session1.get(Student.class, 102);
            System.out.println(student2);

            Student student3 = session2.get(Student.class, 102);
            System.out.println(student3);

        } catch (HibernateException he) {
            // Handle Hibernate specific exceptions
            he.printStackTrace();
        } catch (Exception e) {
            // Handle any other exceptions
            e.printStackTrace();
        } finally {
            // Step 7: Clean up resources
            session1.close();        // Close the session
            session2.close();        // Close the session
            sessionFactory.close(); // Close the session factory

        }
    }
}