package com.test;

import com.pojo.Student;

public class Simpletest {

	public static void main(String[] args) {
		Student st=new Student();//default
		System.out.println(st);

		Student st2=new Student(12,"ramandan",90);//parameterized
		
		System.out.println(st2);
		
		Student st3=new Student();
		st3.setStid(12);
		st3.setName("payal");
		st3.setMarks(89);
		
		System.out.println(st3);
	}

}
