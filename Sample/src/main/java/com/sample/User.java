package com.sample;

import java.sql.SQLException;
import java.util.Scanner;

public class User {
	String name;
	String password;
	
	User() throws SQLException{
		this.newUserMenu();
		UserDAO dao = new UserDAO();
		dao.addUser(this);
	}
	
	public void newUserMenu() throws SQLException{
		Scanner s = new Scanner(System.in);
		this.setNameMenu();
		System.out.println("Enter New User Password: ");
		this.password = s.nextLine();
	}
	
	public void setNameMenu() throws SQLException {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter New Username: ");
		String newName = s.nextLine();
		if(!this.setName(newName)) {
			System.out.println("User With Name Already Exists");
			this.setNameMenu();
		}
		
	}
	
	public Boolean setName(String name) throws SQLException {
		UserDAO dao = new UserDAO();
		if(dao.userExists(name)) {
			return false;
		}
		else {
			this.name = name;
			return true;
		}
	}
	
	public Boolean correctPassword(String pword) {
		return (pword == this.password);
	}
	
}
	

