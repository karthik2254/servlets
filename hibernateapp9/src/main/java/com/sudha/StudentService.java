package com.sudha;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentService {

	String status = "";

	public String registration(String sid, String sname, String saddr) {
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();
			Student std = (Student) session.get(Student.class, sid);
			if (std == null) {
				std = new Student();
				std.setSid(sid);
				std.setSname(sname);
				std.setSaddr(saddr);
				Transaction tx = session.beginTransaction();
				session.save(std);
				tx.commit();
				status = "success";
			} else {
				status = "existed";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
}
