package com.miniproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
	int score=0;
	Connection connection3=null;
	Statement st=null;
	public int  takeTest() throws Exception
	{ 
	
		Scanner sc=new Scanner(System.in);
		 LoadingDriver ld=new LoadingDriver();
		 
		 String getQuestions="select questions ,options ,answers from quizdata.qatable order by rand() limit 10";
		 try {
			  connection3= ld.getConnectionDetails();
			 st=connection3.createStatement(); 
			 ResultSet rs=st.executeQuery(getQuestions);
			 while(rs.next())
			 {
				 System.out.println(rs.getString(1));
				 System.out.println("");
				 System.out.println(rs.getString(2));
				 System.out.println("Enter the Answer");
				 String answer=sc.next();
				if (answer.equals(rs.getString(3)))
						{
					score++ ;
						}
			 }
			 System.out.println("=======================================");
			 System.out.println("");
			 System.out.println("Your Score out of 10 >> "+score);
			
	
		 } 
		 
				catch (Exception e)
				{
					System.out.println(e);
				}
		 finally {
			 if(st!=null &&connection3!=null)
		 st.close();
			connection3.close();
		 }
		 return score;
		 
	}
}