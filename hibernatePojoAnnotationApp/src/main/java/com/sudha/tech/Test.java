package com.sudha.tech;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			Configuration cfg = new Configuration();
			cfg.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/commondb");
			cfg.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
			cfg.setProperty("hibernate.connection.username", "root");
			cfg.setProperty("hibernate.connection.password", "Sudha@7878");
			cfg.addAnnotatedClass(com.sudha.tech.Employee.class);

			//cfg.configure();

			sessionFactory = cfg.buildSessionFactory();

			session = sessionFactory.openSession();

			Employee emp = (Employee) session.get(Employee.class, 4142);
			if (emp == null) {
				System.out.println("Employee Not Existed");
			} else {
				System.out.println("Employee Details");
				System.out.println("==================");
				System.out.println("Employee Number :" + emp.getEno());
				System.out.println("Employee Name :" + emp.getEname());
				System.out.println("Employee Salary :" + emp.getEsal());
				System.out.println("Employee Address :" + emp.getEaddr());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
