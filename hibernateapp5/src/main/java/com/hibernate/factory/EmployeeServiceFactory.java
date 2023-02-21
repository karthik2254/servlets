package com.hibernate.factory;

import com.hibernate.service.EmployeeService;
import com.hibernate.service.EmployeeServiceImpl;

public class EmployeeServiceFactory {

	private static EmployeeService empService;

	static {
		empService = new EmployeeServiceImpl();
	}

	public static EmployeeService getEmployeeService() {
		return empService;
	}
}
