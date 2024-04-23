package com.pojo;

public class Account {
	
	private int ac_id;
	private String acc_name;
	private int balance;
	private String username;
	private String password;
	public Account() {
		super();
	}
	public Account(int ac_id, String acc_name, int balance, String username, String password) {
		super();
		this.ac_id = ac_id;
		this.acc_name = acc_name;
		this.balance = balance;
		this.username = username;
		this.password = password;
	}
	
	public Account(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public int getAc_id() {
		return ac_id;
	}
	public void setAc_id(int ac_id) {
		this.ac_id = ac_id;
	}
	public String getAcc_name() {
		return acc_name;
	}
	public void setAcc_name(String acc_name) {
		this.acc_name = acc_name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Account [ac_id=" + ac_id + ", acc_name=" + acc_name + ", balance=" + balance + ", username=" + username
				+ ", password=" + password + "]";
	}
	

}
