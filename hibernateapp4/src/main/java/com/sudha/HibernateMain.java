package com.sudha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
	public static void main(String[] args) {
		Configuration conf = null;
		SessionFactory sf = null;
		Session session = null;
		try {
			conf = new Configuration();
			conf.configure("hibernate.cfg.xml");
			sf = conf.buildSessionFactory();
			session = sf.openSession();

			Employee emp = (Employee) session.get(Employee.class, 4144);
			if (emp == null) {
				System.out.println("Employee does not existed");
			} else {
				System.out.println("Employee Details");
				System.out.println("------------------");
				System.out.println("Employee Number :" + emp.getEno());
				System.out.println("Employee Name :" + emp.getEname());
				System.out.println("Employee Salary :" + emp.getEsal());
				System.out.println("Employee Address :" + emp.getEaddr());
			}

			System.out.println("Before Calling load()");
			Employee emp1 = (Employee) session.load(Employee.class, 4142);
			System.out.println(emp1.getEno());
			System.out.println("After Calling load()");
			System.out.println(emp1.getEname());

			System.out.println("Employee Details");
			System.out.println("------------------");
			System.out.println("Employee Number :" + emp1.getEno());
			System.out.println("Employee Name :" + emp1.getEname());
			System.out.println("Employee Salary :" + emp1.getEsal());
			System.out.println("Employee Address :" + emp1.getEaddr());

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.clear();
			sf.close();
		}
	}

}
