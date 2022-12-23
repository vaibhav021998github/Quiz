package com.miniproject;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class MainQuiz { 
	 
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		LoadingDriver ld=new LoadingDriver();
		ld.getConnectionDetails();
		System.out.println("Enter Your Student_Id >>");
		int student_Id=sc.nextInt();
		System.out.println("Enter Your Name >>");
		String name=sc.next();
		ConnectDatabase cd=new ConnectDatabase();
		cd.insertData(student_Id, name);
		Test test=new Test();
		int score=test.takeTest();
		cd.insertScore(score, name);
		if (score>=8)
		{
			System.out.println("Class A");
		}
		else if(score>=6)
		{
			System.out.println("Class B");
		}
		else if(score==5)
		{
			System.out.println("Class C");
		}
		else
		{
			System.out.println("Sorry Your Fail...Try Next Time ....");
		}
		System.out.println("");
		System.out.println("Do u Want to See the Score List ?");
		System.out.println("y /n");
		 String input =sc.next();
		String response1="y";
		DisplayData data=new DisplayData();
		if(input.equals(response1))
		{
			data.getData1();
		}
		else
		{
			System.out.println("Do You Want to See Your Details ");
			System.out.println("Enter the Studen_Id");
			int getResult=sc.nextInt();
			data.getData2(getResult);
		}
	}

}
