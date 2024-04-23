package com.test;

import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.DaoBook;
import com.pojo.Book;

public class TestBook {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("BookDatabase.xml");
		System.out.println("loaded................xml");

		DaoBook bk = ctx.getBean("bookDao", DaoBook.class);

		// show //bk.getAllBooks().forEach(b -> System.out.println(b));

		// insert record..........................
//		System.out.println("Enter id,name,author name,price of book");
//		
//		Book book=new Book();
//		 book.setId(sc.nextInt());
//		 book.setName(sc.next());
//		 book.setAuthor(sc.next());
//		 book.setPrice(sc.nextInt());
//		 bk.addNewBook(book);
//		 System.out.println("insert done..............");
//		 
		
		//update
		
//		System.out.println("Enter id of book and price ");
//
//		Book book = new Book();
//		book.setId(sc.nextInt());
//		book.setPrice(sc.nextInt());
//		bk.editBook(book);
//		System.out.println("updation  done..............");
		
		System.out.println("Enter id to delete ...........");
		bk.deleteBook(sc.nextInt());
		

	}

}
