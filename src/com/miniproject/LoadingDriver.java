package com.miniproject;
//importing all required packages
import java.sql.Connection;
import java.sql.DriverManager;

public class LoadingDriver {
	// creating Connection between Database and JavaProgram
		 Connection connection1=null;
		 public Connection getConnectionDetails() throws Exception
		 {
			try {	 //using try-catch block for handling exception
		Class.forName("com.mysql.cj.jdbc.Driver"); //loading driver url..
		connection1=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdata", "root", "root");//connecting through JDBC...
		 }
		 catch (Exception e) {
			System.out.println(e);
		}
			
			 return connection1;
			 }
}
