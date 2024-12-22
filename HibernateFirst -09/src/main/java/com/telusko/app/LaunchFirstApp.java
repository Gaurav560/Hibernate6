package com.telusko.app;


import com.telusko.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchFirstApp {
    public static void main(String[] args) {
        System.out.println("Hello World");

//        STEP-1 CONFIGURATION OBJECT
        Configuration cfg = new Configuration();

//        STEP-2 CONFIGURE hibernate.cfg.xml file into THE CONFIGURATION OBJECT
        cfg.configure("hibernate.cfg.xml");

//        STEP-3 Create SESSION FACTORY object
       SessionFactory sessionFactory= cfg.buildSessionFactory();


//       step4: Get the session object from the session factory
       Session session = sessionFactory.openSession();

//       step5: Begin the transaction with session object
     Transaction transaction= session.beginTransaction();

        Student student = new Student();
        student.setSid(101);
        student.setsName("Rahul");
        student.setsCity("Pune");

        session.persist(student);

//        step6: Commit the transaction
        transaction.commit();


//        step7: Close the session
        session.close();
        System.out.println("Data saved successfully");


    }
}
