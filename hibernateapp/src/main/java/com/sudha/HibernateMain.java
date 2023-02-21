package com.sudha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		Employee employee = new Employee();
		employee.setEno(585);
		employee.setEname("Krish");
		employee.setEsal(24000);
		employee.setEaddr("IND");
		//int eno = (Integer) session.save(employee);
		session.persist(employee);
		tx.commit();
		System.out.println("Employee Inserted Successfully");
		/*
		 * if (eno == 4141) { System.out.println("Employee Inserted Successfully"); }
		 * else { System.out.println("Employee Insertion Failure"); }
		 */
		session.close();
		sf.close();
	}
}
