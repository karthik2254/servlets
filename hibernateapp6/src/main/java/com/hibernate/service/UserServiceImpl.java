package com.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.pojo.User;
import com.hibernate.util.HibernateUtil;

public class UserServiceImpl implements UserService {

	@Override
	public String checkLogin(String uname, String upwd) {
		String status = "";
		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			System.out.println(sessionFactory);
			Session session = sessionFactory.openSession();
			System.out.println(session);
			User user = (User) session.get(User.class, uname);
			System.out.println(user);
			if (user == null) {
				status = "failure";
			} else {
				if (user.getUpwd().equals(upwd)) {
					status = "success";
				} else {
					status = "failure";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
