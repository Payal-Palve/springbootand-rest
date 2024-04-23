package com.pojo;

public class Employee {
	
	private int empid;
	
	private String name;
	
	private int salary;
	
	private Date date;

	public Employee() {
		super();
	}

	public Employee(int empid, String name, int salary, Date date) {
		super();
		this.empid = empid;
		this.name = name;
		this.salary = salary;
		this.date = date;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + ", date=" + date + "]";
	}
	
	

}
