package com.miniproject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class DisplayData {
	
	public void getData1() throws Exception
	{
		Scanner sc=new Scanner(System.in);
		 LoadingDriver ld=new LoadingDriver();
		 Connection connection4= ld.getConnectionDetails();
		 String getDetails="select * from quizdata.student_details order by score desc";//for sorting by score query given
		 try {
			Statement st=connection4.createStatement(); 
			 ResultSet rs=st.executeQuery(getDetails); //retrieving data from database...
			 while(rs.next())
			 	{
				 System.out.println(rs.getInt(1)+" \t"+rs.getString(2)+" \t"+rs.getInt(3));
			 	}
			 System.out.println(" Do You Want View Your Details..? ");
			 System.out.println("y/n");
				String input2=sc.next();
				String response2="y";
	
				if(input2.equals(response2))
				{
					System.out.println("Enter the Studen_Id");
					int getResult=sc.nextInt();
					getData2(getResult);
				}
				else
				{
					System.out.println("  Good Bye...! ");	
				}
				
				
		 	}
			 catch (Exception e)
			 {
				 System.out.println(e); 
			 }
		 
		}

	public void getData2(int getResult) 
	{
		 LoadingDriver ld=new LoadingDriver();
	
		 String getDetails="select * from quizdata.student_details where student_id="+getResult;
		 try {
			 Connection connection5= ld.getConnectionDetails();
			Statement st=connection5.createStatement(); 
			 ResultSet rs=st.executeQuery(getDetails);
			 while(rs.next())
			 {
				if (rs.getInt(1)==getResult)
				{
				 System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3));
				}
		 	}
			 System.out.println("");
			System.out.println("=================================================================="); 
		 }
		  catch(Exception e)
		 {
		 System.out.println(e);
		 }
		
	}

}
