package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {
	public void addUser(User u) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String uname = "root";
		String password = "B!gB@d$exyW0lf";
				
		Connection con = DriverManager.getConnection(url, uname, password);
		Statement st = con.createStatement();
		
		st.executeUpdate("insert into user values ('" + u.name + "','" + u.password + "')");
		
		st.close();
		con.close();
	}
	
	public boolean userExists(String username) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String uname = "root";
		String password = "B!gB@d$exyW0lf";
		boolean userExists;
				
		Connection con = DriverManager.getConnection(url, uname, password);
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select * from user where CharacterName = '" + username +"'");
		userExists = rs.next();
		st.close();
		con.close();
		
		return userExists;
	}
	
	
	public String getPassword(String username) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String uname = "root";
		String password = "B!gB@d$exyW0lf";
				
		Connection con = DriverManager.getConnection(url, uname, password);
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("select Password from user where CharacterName = '" + username +"'");
		rs.next();
		String pword = rs.getString("Password");

		st.close();
		con.close();
		
		return pword;
	}
}
