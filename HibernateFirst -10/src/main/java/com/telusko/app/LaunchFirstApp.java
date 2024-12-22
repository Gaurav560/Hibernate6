package com.telusko.app;

import com.telusko.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchFirstApp {
    public static void main(String[] args) {
        // Declare all required Hibernate objects as null initially
        Configuration cfg = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        // Flag to track if the transaction was successful
        boolean flag = false;

        // Step 1: Create Configuration object and load hibernate.cfg.xml
        cfg = new Configuration();
        cfg.configure(); // Loads the default hibernate.cfg.xml file

        // Step 2: Build SessionFactory - heavy object, should be created once per application
        sessionFactory = cfg.buildSessionFactory();

        // Step 3: Open a new Session - lightweight object, created per operation
        session = sessionFactory.openSession();

        // Create Student object and set its properties
        Student student = new Student();
        student.setSid(103);
        student.setsName("Raj");
        student.setsCity("Pune");

        try {
            // Step 4: Begin transaction
            transaction = session.beginTransaction();

            // Step 5: Persist the student object to database
            session.persist(student);

            // Set flag to true if operation successful
            flag = true;

        } catch (HibernateException he) {
            // Handle Hibernate specific exceptions
            he.printStackTrace();
        } catch (Exception e) {
            // Handle any other exceptions
            e.printStackTrace();
        } finally {
            // Step 6: Commit or rollback transaction based on success flag
            if (flag) {
                transaction.commit(); // Commit if successful
            } else {
                transaction.rollback(); // Rollback if any exception occurred
            }

            // Step 7: Clean up resources
            session.close();        // Close the session
            sessionFactory.close(); // Close the session factory
        }
    }
}