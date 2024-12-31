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
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;

        try {
            // Load configuration from application.properties and build session factory
            Configuration cfg = new Configuration();
            cfg.addAnnotatedClass(Student.class);
            sessionFactory = cfg.buildSessionFactory();

            // Open a session
            session = sessionFactory.openSession();

            // Create a new student object
            Student student = new Student();
            student.setSid(109);
            student.setsName("harsh");
            student.setsCity("Sirohi");

            // Begin transaction
            transaction = session.beginTransaction();

            // Persist the student object
            session.save(student);

            // Commit the transaction
            transaction.commit();
            System.out.println("Student successfully saved: " + student);

        } catch (HibernateException he) {
            // Handle Hibernate specific exceptions
            he.printStackTrace();
            if (transaction != null) transaction.rollback();
        } catch (Exception e) {
            // Handle any other exceptions
            e.printStackTrace();
            if (transaction != null) transaction.rollback();
        } finally {
            // Clean up resources
            if (session != null) session.close();
            if (sessionFactory != null) sessionFactory.close();
        }
    }
}
