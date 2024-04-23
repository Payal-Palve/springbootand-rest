package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.Account;
import com.util.Hbutil;

public class DaoClass implements DaoAccount {
	
	private Connection con=null;

	public DaoClass() {
		
		try {
			con=Hbutil.getConnection();
			System.out.println("connection done util");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Account validateUser(String  user, String password) {
		
		String sql="select * from accountdb where username=? and password=?;";
		try {
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,user);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			
			if(rs.next()) {
				Account obj=new Account(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
				System.out.println(obj);
				System.out.println("dao validation done");
				return obj;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public int insertData(Account obj) {
		String insert="insert into accountdb values(?,?,?,?,?);";
		try {
			PreparedStatement pst=con.prepareStatement(insert);
			pst.setInt(1, obj.getAc_id());
			pst.setString(2, obj.getAcc_name());
			pst.setInt(3, obj.getBalance());
			pst.setString(4,obj.getUsername());
			pst.setString(5,obj.getPassword());
			int i=pst.executeUpdate();
			System.out.println(i +" row inserted...........dao");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}

	@Override
	public int depositAmount(int id, int amount) {
	    String dep = "UPDATE accountdb SET balance = balance + ? WHERE acc_id = ?";
	    try {
	        PreparedStatement pst = con.prepareStatement(dep);
	        pst.setInt(1, amount); // Set the amount to be added to the balance
	        pst.setInt(2, id);     // Set the account ID
	        int i = pst.executeUpdate();
	        System.out.println(i + " amount deposited: " + amount);
	        return i; // Return the number of rows affected by the update
	    } catch (SQLException e) {
	        // Handle SQL exception
	        e.printStackTrace();
	        return -1; // Return a negative value to indicate an error
	    }
	}


	@Override
	public int withdrawAmount(int id, int amount) {
		// TODO Auto-generated method stub
		String with = "UPDATE accountdb SET balance = balance - ? WHERE acc_id = ?";
	    try {
	        PreparedStatement pst = con.prepareStatement(with);
	        pst.setInt(1, amount); // Set the amount to be added to the balance
	        pst.setInt(2, id);     // Set the account ID
	        int i = pst.executeUpdate();
	        System.out.println(i + " amount withdraw: " + amount);
	        return i; // Return the number of rows affected by the update
	    } catch (SQLException e) {
	        // Handle SQL exception
	        e.printStackTrace();
	        return -1; // Return a negative value to indicate an error
	    }
	}

}
