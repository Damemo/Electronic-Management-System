/*
Write a java program for implementation scrollable ResultSet. Consider Emp table (eno ename, sal) 
	- moveFirst
	- moveNext
	- movePrevious
	- moveLast   
*/

import java.io.*;
import java.sql.*;

public class Slip25B  extends JFrame implements ActionListener
{

	public Slip25B()
	{
		JLabel l1,l2,l3,l4;
		JTextField t1,t2,t3,t4;

		
		

public static void main(String[] args) throws IOException,SQLException, ClassNotFoundException
{		
	int ch;		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	ResultSet rs=null;
	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");					
	Connection conObject = DriverManager.getConnection("jdbc:odbc:dsn1");	
	Statement stmt = conObject.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	String query = "Select * from bookm";				
	rs = stmt.executeQuery(query);				
	do
	{			
		System.out.println("1.) Move to First Record.");
		System.out.println("2.) Move to Last Record.");
		System.out.println("3.) Move to Previous Record.");
		System.out.println("4.) Move to Next Record.");
		System.out.println("0.) Exit");
		System.out.println("Enter your choice : ");
		ch = Integer.parseInt(br.readLine());
		if(ch==1)
		{
			if(!rs.isFirst())
				rs.first();
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) );
		}
		else if(ch==2)
		{
			if(!rs.isLast())
				rs.last();
			System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) );
		}else if(ch==3){				
			if(rs.previous())				
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) );				
			else
				System.out.println("You r on first record!");
				
		}else if(ch==4){
			if(rs.next())		
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) );				
			else
				System.out.println("You r on last record!");							
		}else{
			System.out.println("Invalid choice!");
		}
	}while(ch!=0);
	rs.close();
	stmt.close();
	conObject.close();
}	
}
