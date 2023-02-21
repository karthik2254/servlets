package com.hibernate.factory;

import com.hibernate.service.UserService;
import com.hibernate.service.UserServiceImpl;

public class UserServiceFactory {

	private static UserService userService;

	static {
		userService = new UserServiceImpl();
	}

	public static UserService getUserService() {
		return userService;
	}
}
