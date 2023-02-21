package com.sudha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		SessionFactory oracle_SessionFactory = null;
		SessionFactory mysql_SessionFactory = null;
		Session oracle_Session = null;
		Session mysql_Session = null;
		try {
			Configuration oracle_cfg = new Configuration();
			Configuration mysql_cfg = new Configuration();

			oracle_cfg.configure("hibernate_oracle.cfg.xml");
			mysql_cfg.configure("hibernate_mysql.cfg.xml");

			oracle_SessionFactory = oracle_cfg.buildSessionFactory();
			mysql_SessionFactory = mysql_cfg.buildSessionFactory();

			oracle_Session = oracle_SessionFactory.openSession();
			mysql_Session = mysql_SessionFactory.openSession();

			Employee emp = oracle_Session.get(Employee.class, 3773);
			System.out.println("Employee retrieved from Oracle DB");

			Transaction mysql_Tx = mysql_Session.beginTransaction();
			mysql_Session.save(emp);
			mysql_Tx.commit();
			System.out.println("Employee Inserted in MySQL DB");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			oracle_Session.close();
			mysql_Session.close();

			oracle_SessionFactory.close();
			mysql_SessionFactory.close();
		}
	}
}
