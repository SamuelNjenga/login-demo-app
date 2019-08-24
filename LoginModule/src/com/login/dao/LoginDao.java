package com.login.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;

public class LoginDao {

	String sql = "select * from login where uname=? and pass=?";
	String url = "jdbc:mysql://localhost:3306/sam";
	String uname= "root";
	String pass = "";
	public boolean check(String username,String password){
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection connection = DriverManager.getConnection(url,uname,pass);
		 PreparedStatement statement = connection.prepareStatement(sql);
		 statement.setString(1, username);
		 statement.setString(2, password);
		 ResultSet rSet= statement.executeQuery();
		 if(rSet.next()) {
			 return true;
		 }
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return false;
	}
}
