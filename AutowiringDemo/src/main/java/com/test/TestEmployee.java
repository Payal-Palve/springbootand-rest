package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.Employee;

public class TestEmployee {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext con = new ClassPathXmlApplicationContext("AutoWire.xml");
		
		Employee emp=(Employee)con.getBean("emp");  //byname
		System.out.println(emp);

		Employee emp2=(Employee)con.getBean("emp2"); //bytype
		System.out.println(emp2);
		
		Employee emp3=(Employee)con.getBean("emp3"); //bytype
		System.out.println(emp3);
		
	}

}
