package com.jsp.hibernate.Hibernate_OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       Employee emp=new Employee();
       emp.setPersonId(101);
       emp.setPersonName("Sharan");
       
       Aadhar aadhar=new Aadhar();
       aadhar.setAadharId(1);
       aadhar.setAadharNumber(449424804);
       aadhar.setEmployee(emp);
       
       emp.setAadhar(aadhar);
       Configuration cfg=new Configuration();
       cfg.configure();
       cfg.addAnnotatedClass(Employee.class);
       cfg.addAnnotatedClass(Aadhar.class);
       SessionFactory sf=cfg.buildSessionFactory();
       Session session=sf.openSession();
       Transaction tran=session.beginTransaction();
//       Aadhar a=session.get(Aadhar.class, 1);
//       System.out.println(a.getEmployee());
       
       session.save(emp);
       session.save(aadhar);
       
       
       tran.commit();
       session.close();
       sf.close();
    }
}
