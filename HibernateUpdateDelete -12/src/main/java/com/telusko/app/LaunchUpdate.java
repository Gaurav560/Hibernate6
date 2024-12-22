package com.telusko.app;

import com.telusko.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchUpdate {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        cfg.addAnnotatedClass(Student.class);
        SessionFactory factory = cfg.buildSessionFactory();
        boolean flag = false;
        Session session = null;
        Transaction transaction = null;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Student student = new Student();
            student.setSid(101);
            student.setsName("GauravSh");
            student.setsCity("Mumba Devi");

//            session.persist(student);
            //session.delete(student);- deprecated

            session.remove(student);

            flag = true;

        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                transaction.commit();
                session.close();
            } else {
                transaction.rollback();
            }

            session.close();
            factory.close();
        }

    }

}

