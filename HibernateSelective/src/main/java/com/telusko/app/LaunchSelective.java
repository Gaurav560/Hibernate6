package com.telusko.app;


import com.telusko.model.Employee1;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LaunchSelective {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().addAnnotatedClass(Employee1.class).buildSessionFactory();
        Session session = null;
        Transaction transaction = null;
        boolean flag = false;

        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Employee1 employee1 = new Employee1();
            employee1.setEage(25);
            employee1.setEcity("Pune");
            employee1.setEname("Rahul");
            employee1.setEid(1);
            session.persist(employee1);
            flag = true;
        } catch (HibernateException hibernateException) {
            hibernateException.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (flag) {
                transaction.commit();
                System.out.println("Record inserted successfully");
            } else {
                transaction.rollback();
                System.out.println("Record insertion failed");
            }
            session.close();
            factory.close();

        }
    }
}

