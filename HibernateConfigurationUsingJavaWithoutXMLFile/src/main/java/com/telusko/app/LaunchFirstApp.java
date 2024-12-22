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
        boolean flag = false;
        Transaction transaction = null;

        // Configure Hibernate and build the session factory
        cfg = new Configuration();
        cfg.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        cfg.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hibernate");
        cfg.setProperty("hibernate.connection.username", "postgres");
        cfg.setProperty("hibernate.connection.password", "12345678");
        cfg.setProperty("hibernate.show_sql", "true");
        cfg.setProperty("hibernate.format_sql", "true");
        cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");
        cfg.addAnnotatedClass(Student.class);

        try {
            sessionFactory = cfg.buildSessionFactory();
            session = sessionFactory.openSession();

            // Create a new student object
            Student student = new Student();
            student.setSid(108);
            student.setsName("Reddy");
            student.setsCity("Hyderabad");

            // Begin transaction
            transaction = session.beginTransaction();

            // Persist the student object
            session.save(student);
            flag = true;

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
