package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.pojo.Book;


public class DaoBook implements DaoInterface {

	private DataSource dsobj;
	
	
	
	public DaoBook() {
		System.out.println("dao created.................................");
		
	}
	

	public DataSource getDsobj() {
		return dsobj;
	}


	public void setDsobj(DataSource dsobj) {
		this.dsobj = dsobj;
	}


	@Override
	public List<Book> getAllBooks() {
		String sql="select * from book;";
		try {
			Connection con=dsobj.getConnection();
			System.out.println("connection done in dao...........");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			List<Book>lis=new ArrayList<Book>();
			while(rs.next()) {
				lis.add(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4)));
			}
			return lis;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

	@Override
	public int addNewBook(Book obj) {
		
		try {
			String insert="insert into book values(?,?,?,?)";
			Connection con=dsobj.getConnection();
			PreparedStatement pst=con.prepareStatement(insert);
			pst.setInt(1,obj.getId());
			pst.setString(2,obj.getName());
			pst.setString(3,obj.getAuthor());
			pst.setInt(4,obj.getPrice());
			
			int i=pst.executeUpdate();
			System.out.println(i+"record inserted............");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}


	@Override
	public int editBook(Book obj) {
		
		try {
			String update = "UPDATE book SET price = ? WHERE id = ?";
	        Connection con = dsobj.getConnection();
	        PreparedStatement pst = con.prepareStatement(update);
	        pst.setInt(1, obj.getPrice()); // Set the price
	        pst.setInt(2, obj.getId()); // Set the ID

	        int i = pst.executeUpdate();
	        System.out.println(i + " record updated............");
	        return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}


	@Override
	public int deleteBook(int id) {
		try {
		String update = "delete from book  WHERE id = ?";
        Connection con = dsobj.getConnection();
        PreparedStatement pst = con.prepareStatement(update);
       
			pst.setInt(1, id);
			int i = pst.executeUpdate();
			System.out.println(i + " record deleted............");
			return i;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // Set the ID

		return 0;
	}
	
	

}
