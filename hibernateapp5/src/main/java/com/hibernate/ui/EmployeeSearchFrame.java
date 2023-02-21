package com.hibernate.ui;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.hibernate.entity.Employee;
import com.hibernate.factory.EmployeeServiceFactory;
import com.hibernate.service.EmployeeService;

public class EmployeeSearchFrame extends Frame implements ActionListener {

	Label l;
	TextField tf;
	Button b;
	Employee emp;
	// EmployeeServiceImpl employeeService;

	public EmployeeSearchFrame() {
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("Employee Search Frame");
		this.setLayout(new FlowLayout());
		this.setBackground(Color.green);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		l = new Label("Employee Number");
		tf = new TextField(20);
		b = new Button("Search");
		b.addActionListener(this);

		Font font = new Font("consolas", Font.BOLD, 20);
		l.setFont(font);
		tf.setFont(font);
		b.setFont(font);

		this.add(l);
		this.add(tf);
		this.add(b);

		// EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
	}

	public void actionPerformed(ActionEvent ae) {
		try {
			int eno = Integer.valueOf(tf.getText());
			// employeeService = new EmployeeServiceImpl();
			EmployeeService employeeService = EmployeeServiceFactory.getEmployeeService();
			emp = employeeService.search(eno);
			repaint();
		} catch (Exception e) {

		}
	}

	@Override
	public void paint(Graphics g) {
		Font font = new Font("consolas", Font.BOLD, 25);
		g.setFont(font);
		if (emp == null) {
			g.drawString("Employee Not Existed", 50, 250);
		} else {
			g.drawString("Employee Number :" + emp.getEno(), 50, 200);
			g.drawString("Employee Name :" + emp.getEname(), 50, 250);
			g.drawString("Employee Salary :" + emp.getEsal(), 50, 300);
			g.drawString("Employee Address :" + emp.getEaddr(), 50, 350);
		}
	}

}
