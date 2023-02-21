package com.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.entity.Employee;
import com.hibernate.util.HibernateUtil;

public class EmployeeServiceImpl implements EmployeeService {

	// Configuration conf = null;
	// SessionFactory sf = null;
	// Session session = null;
	Employee emp;

	/*
	 * public EmployeeServiceImpl() { try { conf = new Configuration();
	 * conf.configure("com/hibernate/resources/hibernate.cfg.xml"); sf =
	 * conf.buildSessionFactory(); session = sf.openSession(); }catch(Exception e) {
	 * e.printStackTrace(); } }
	 */

	public Employee search(int eno) {
		try {
			// session = sf.openSession();
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			emp = (Employee) session.get(Employee.class, eno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}
}
