package com.sample;
import java.io.InputStream;
import java.sql.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
				
		loginMenu();
		
	}
	
	public static void loginMenu() throws SQLException {
		checkPassWord(checkUserName());
		
		
		
		}
		
	
	
	public static String checkUserName() throws SQLException {
		String uname = "";
		Boolean validUname = false;
		Scanner s = new Scanner(System.in);
		UserDAO dao = new UserDAO();
		
		while(!validUname){
			System.out.println("Enter Username");
			uname = s.nextLine();
			if(!dao.userExists(uname)) {
				System.out.println("User Not Found");
			}
			else {
				validUname = true;
			}
		}
		return uname;
	}
	
	public static void checkPassWord(String uname) throws SQLException {
		String pword;
		Boolean validPword = false;
		Scanner s = new Scanner(System.in);
		UserDAO dao = new UserDAO();
		
		while(!validPword) {
			System.out.println("Enter Password");
			pword = s.nextLine();
			if(pword != dao.getPassword(uname)) {
				System.out.println("Incorrect Password");
			}
			else {
				validPword = true;
			}
		}
	}

}
