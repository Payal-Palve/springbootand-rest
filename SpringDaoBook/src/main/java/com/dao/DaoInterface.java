package com.dao;

import java.util.List;

import com.pojo.Book;

public interface DaoInterface {
	
	List<Book>getAllBooks();//show all data
	
	
	int addNewBook(Book obj); //add new record
	
	int editBook(Book obj);  //update
	
    int deleteBook(int id);
}
