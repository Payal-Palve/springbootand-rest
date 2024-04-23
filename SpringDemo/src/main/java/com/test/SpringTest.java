package com.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pojo.Student;

public class SpringTest {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext con=new ClassPathXmlApplicationContext("StudentBean.xml");
		System.out.println("loaded..............");
		
		Student std=(Student)con.getBean("default");
		System.out.println(std);
		
		Student std1=(Student)con.getBean("stdbean1");
		System.out.println(std1);
		
		Student std2=(Student)con.getBean("stdbean2");
		System.out.println(std2);

	}

}
