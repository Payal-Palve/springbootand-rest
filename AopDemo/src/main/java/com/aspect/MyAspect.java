package com.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
    
    @Before("execution(* com.service.Payment.makePayment(..))")
    public void printBefore() {
        System.out.println("Before is called");
    }
    
    @After("execution(* com.service.Payment.makePayment(..))")
    public void printAfter() {
        System.out.println("After is called");
    }
}

