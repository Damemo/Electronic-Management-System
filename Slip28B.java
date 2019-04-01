

//Q) Write a java program to display the selected employee details in JTable. (use database, combo box for employee //selection )  Employee having fields eno, ename, sal, desg.

//CODE

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Slip28B extends JFrame implements ActionListener
{
	private JLabel lblEid;
	private JComboBox empId;
	private JTable empTable;	
	private JButton btnShow;
	private JPanel inputPanel;
	Connection con=null;
	Statement stmt;

	public Slip28B() throws SQLException,ClassNotFoundException
	{
		setTitle( "Employees" );
		setSize( 500, 300 );
		setBackground( Color.gray );

		inputPanel = new JPanel(new FlowLayout());
		lblEid = new JLabel("Select Employee Id : ");
		empId = new JComboBox();
		btnShow = new JButton("Display Record");


		btnShow.addActionListener(this);
		inputPanel.add(lblEid); 
		inputPanel.add(empId); 
		inputPanel.add(btnShow);
		add(inputPanel);

		//populating combo box with EmpId	

		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");					
		con = DriverManager.getConnection("jdbc:odbc:dsn1");


		stmt = con.createStatement();
		String query  = "Select * from bookm";		
		ResultSet rs = stmt.executeQuery(query);	
	
		while(rs.next())
			empId.addItem(rs.getString(1));  // book id

		//empId.addItem(rs.getString(1) + rs.getString(2));
		//empId.addItem(rs.getString(2))   book name


		empTable = new JTable(10,4);	
		rs.close();
		stmt.close();
		con.close();
	}

	public void actionPerformed(ActionEvent ae)
	{
		int i=0;	
		try
		{	
			String id = empId.getSelectedItem().toString();	//important


			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");					
			con = DriverManager.getConnection("jdbc:odbc:dsn1");



			stmt = con.createStatement();
			String query  = "Select * from bookm where bname=" + id;		
			//String query  = "Select * from bookm";//  where bno=" + id;
			ResultSet rs = stmt.executeQuery(query);
	
			// Create a new table instance
	
			
			while(rs.next())
			{
				empTable .setValueAt(rs.getString(1),i,0);
				empTable .setValueAt(rs.getString(2),i,1);
				empTable .setValueAt(rs.getString(3),i,2);
				empTable .setValueAt(rs.getString(4),i,3);	
				i++;
			}	
	
			rs.close();
			stmt.close();
			con.close();	

		
			inputPanel.add(new JScrollPane(empTable));
			validate();
			repaint();	
		}
		catch(Exception se)
		{
			System.out.println(se);
		}
					
	}


	public static void main( String args[] ) throws SQLException,ClassNotFoundException
	{

		Slip28B obj	= new Slip28B();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setVisible( true );
	}
}


