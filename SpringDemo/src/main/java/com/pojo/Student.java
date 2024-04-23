package com.pojo;

public class Student {
	
	private int stid;
	private String name;
	private int marks;
	public Student() {
		super();
	}
	public Student(int stid, String name, int marks) {
		super();
		this.stid = stid;
		this.name = name;
		this.marks = marks;
	}
	public int getStid() {
		return stid;
	}
	public void setStid(int stid) {
		this.stid = stid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [stid=" + stid + ", name=" + name + ", marks=" + marks + "]";
	}
	
	

}
