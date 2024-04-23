package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.Payment;
import com.service.PaymentService;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext con=new ClassPathXmlApplicationContext("Config.xml");
		PaymentService pay=con.getBean("payment",PaymentService.class);
		
//		 Payment ps=con.getBean("payment",Payment.class);
//		 ps.makePayment(2000);
		// System.out.println(ps);
		pay.makePayment(1000);

	}

}
