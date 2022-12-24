package com.miniproject;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class ConnectDatabase { 
	Connection connection2=null;
	PreparedStatement ps=null;
	Connection connection3=null;
	PreparedStatement ps1=null;
 public void insertData(int student_Id , String name) throws Exception // this method for inserting details into database with help of connection and prepared statement.. 
 {
	 LoadingDriver ld=new LoadingDriver(); 
	 connection2= ld.getConnectionDetails();
	try {
	ps= connection2.prepareStatement("insert into quizdata.student_details(student_id,name) values(?,?)");//giving query for inserting details... 
	ps.setInt(1,student_Id );
	ps.setString(2, name);
	ps.executeUpdate();
	System.out.println("Your Details Submitted Sucessfully...!");
	System.out.println(".....Welcome to Java Quiz.....");
	System.out.println("==================================================");
	System.out.println("");
	System.out.println("...Warning...!");
	System.out.println("Please Give Response On UpperCase Only");
	System.out.println("");
	
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
	finally
	{
		if(ps!=null && connection2!=null)
		{
			ps.close();
			connection2.close();
		}
		
	}
	
 }
 public void insertScore(int score,String name) throws Exception //for updating score by name
 {
	 
	LoadingDriver ld=new LoadingDriver();
	connection3= ld.getConnectionDetails();
 try {
	ps1= connection3.prepareStatement("update quizdata.student_details set score=? where name=?");//for updating score giving query..
	ps1.setInt(1, score);
	ps1.setString(2,name); 
	ps1.executeUpdate();
	
	
 } catch (Exception e) {
	
	System.out.println(e);
}		
 finally
	{
		if(ps1!=null && connection3!=null)
		{
			ps1.close();
			connection3.close();
		}
		
	}
}

}
