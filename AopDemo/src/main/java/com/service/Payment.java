package com.service;

public class Payment implements PaymentService {

	@Override
	public void makePayment(int amount) {
	
		System.out.println(amount+"amount debited to  account");
		
		System.out.println(amount+"amount credited from  account");
	}

}
