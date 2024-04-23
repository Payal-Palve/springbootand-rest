package com.dao;

import com.pojo.Account;

public interface DaoAccount {
	
	Account validateUser(String user,String password);
	
	public int insertData(Account obj);
	
	public int depositAmount(int id,int amount);
	
	public int withdrawAmount(int id,int amount);

}
