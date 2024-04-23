package com.pojo;

import org.springframework.beans.BeansException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTes {
	
	public static void main(String [] args) {
		try (ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("Employee.xml")) {
			System.out.println("loaded..............");
			
			Employee e=(Employee)con.getBean("employee");
			System.out.println(e);
			
			Date d=(Date)con.getBean("dateobj");
			System.out.println(d);
			con.close();
		} catch (BeansException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
