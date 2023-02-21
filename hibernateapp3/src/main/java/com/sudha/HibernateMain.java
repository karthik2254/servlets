package com.sudha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
	public static void main(String[] args) {
		Configuration conf = null;
		SessionFactory sf = null;
		Session session = null;
		Transaction tx = null;
         try {
        	 conf = new Configuration();
        	 conf.configure();
        	 sf = conf.buildSessionFactory();
        	 session = sf.openSession();
        	 tx = session.getTransaction();
        	 tx.begin();
        	 Employee emp = new Employee();
        	 emp.setEno(2442);
        	 session.delete(emp);
        	 tx.commit();
        	 System.out.println("Employee Deleted Successfully");
         }catch(Exception e) {
        	 tx.rollback();
        	 System.out.println("Employee Deletion Failure");
        	 e.printStackTrace();
         }finally {
        	 session.clear();
        	 sf.close();
         }
	}
}
