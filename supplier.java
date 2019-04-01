import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class supplier {

	private JFrame frame;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					supplier window = new supplier();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public supplier() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1292, 780);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("Supplier Details Form");
		l1.setBounds(516, 65, 166, 14);
		frame.getContentPane().add(l1);
		
		JLabel l2 = new JLabel("Supplier Update Form");
		l2.setBounds(516, 102, 46, 14);
		frame.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("Supplier Delete form");
		l3.setBounds(516, 146, 46, 14);
		frame.getContentPane().add(l3);
		
		JSeparator s1 = new JSeparator();
		s1.setBounds(354, 171, 395, 2);
		frame.getContentPane().add(s1);
		

		JComboBox c1 = new JComboBox();
		c1.setBounds(658, 206, 134, 22);
		frame.getContentPane().add(c1);
		

		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select sno,sname from supplier";
			ResultSet rs = stmt.executeQuery(query);		
			while(rs.next())
			{
				c1.addItem(String.valueOf(rs.getInt(1)) + "   " + rs.getString(2));
			}
			
			stmt.close();
			conObject.close();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
		
		JComboBox c2 = new JComboBox();
		c2.setBounds(658, 210, 134, 22);
		frame.getContentPane().add(c2);
		

		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select sno,sname from supplier";
			ResultSet rs = stmt.executeQuery(query);		
			while(rs.next())
			{
				c2.addItem(String.valueOf(rs.getInt(1)) + "   " + rs.getString(2));
			}
			
			stmt.close();
			conObject.close();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
		
		
		JLabel l4 = new JLabel("Supplier No:");
		l4.setBounds(354, 210, 46, 14);
		frame.getContentPane().add(l4);
		
		JLabel l9 = new JLabel("");
		l9.setBounds(542, 210, 77, 14);
		frame.getContentPane().add(l9);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select top 1 sno from staff order by sno desc";
			ResultSet rs = stmt.executeQuery(query);		
			if(!rs.next())
				l9.setText(String.valueOf(1));
			else
				l9.setText(String.valueOf(rs.getInt(1)+1));
			
			stmt.close();
			conObject.close();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
		
		
		JLabel l5 = new JLabel("Supplier name");
		l5.setBounds(354, 266, 46, 14);
		frame.getContentPane().add(l5);
		
		JLabel l6 = new JLabel("Supplier address");
		l6.setBounds(354, 331, 46, 14);
		frame.getContentPane().add(l6);
		
		JLabel l7 = new JLabel("Supplier contact ");
		l7.setBounds(354, 391, 46, 14);
		frame.getContentPane().add(l7);
		
		JLabel l8 = new JLabel("Supplier email id");
		l8.setBounds(354, 451, 46, 14);
		frame.getContentPane().add(l8);
		
		JSeparator s2 = new JSeparator();
		s2.setBounds(354, 499, 395, 2);
		frame.getContentPane().add(s2);
		
		JButton b1 = new JButton("Save");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to add?");
				if(resp == 0)
				{
				
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
					String query  = "insert into  supplier(sname,saddr,scon,email) values (?,?,?,?)";
					PreparedStatement stmt = conObject.prepareStatement(query);
					
					stmt.setString(1,t1.getText());
					stmt.setString(2,t2.getText());
					stmt.setString(3,t3.getText());
					stmt.setString(4,t4.getText());
					
					int result = stmt.executeUpdate();
					if(result == 1)
						JOptionPane.showMessageDialog(null, "Record Inserted successfully!");
					else
						JOptionPane.showMessageDialog(null,"Insert Error!");
					stmt.close();
					conObject.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
					
				}
				
				
				
			}
		});
		b1.setBounds(354, 530, 91, 23);
		frame.getContentPane().add(b1);
		
		JButton b2 = new JButton("Update");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?");
				if(resp == 0)
				{
				try
				{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				//String supp=String.valueOf(comboBox.getSelectedItem());
				String sname=String.valueOf(c1.getSelectedItem());
				String sub1=String.valueOf(sname.substring(0, 3));
				int sno = Integer.parseInt(sub1.trim());
			String query  = "update supplier set sname=?,saddr=?,scon=?,email=? where sno="+sno;
			PreparedStatement stmt = conObject.prepareStatement(query);
			
			stmt.setString(1,t1.getText());
			stmt.setString(2,t2.getText());
			stmt.setInt(3,Integer.parseInt(t3.getText()));
			stmt.setString(4,t4.getText());
			
			
			
					
			
			int result = stmt.executeUpdate();
			if(result == 1)
				JOptionPane.showMessageDialog(null, "Record updated successfully!");
			else
				JOptionPane.showMessageDialog(null,"Insert Error!");
			stmt.close();
			conObject.close();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
				
				}
			
				
				
			}
		});
		b2.setBounds(354, 571, 91, 23);
		frame.getContentPane().add(b2);
		
		JButton b3 = new JButton("Delete");
		b3.setBounds(354, 606, 91, 23);
		frame.getContentPane().add(b3);
		
		JButton b4 = new JButton("View");
		b4.setBounds(516, 530, 91, 23);
		frame.getContentPane().add(b4);
		
		
		JButton b5 = new JButton("Exit");
		b5.setBounds(658, 530, 91, 23);
		frame.getContentPane().add(b5);
		
		
		JButton b6 = new JButton("Show");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
						//String supp=String.valueOf(comboBox.getSelectedItem());
						String sname=String.valueOf(c1.getSelectedItem());
						String sub1=String.valueOf(sname.substring(0, 2));
						int sno = Integer.parseInt(sub1.trim());
					//	JOptionPane.showMessageDialog(null, cno);
						String query  = "select sno,sname,saddr,scon,email from supplier where sno=?" ;
						
					
						PreparedStatement stmt = conObject.prepareStatement(query);
						stmt.setInt(1, sno);
						ResultSet rs = stmt.executeQuery();								
					
				
					
				
					
					if(rs.next())
					{
						t1.setText(rs.getString(2));
						t2.setText(rs.getString(3));
						t3.setText(rs.getString(4));
						t4.setText(rs.getString(5));
						
					}	
					
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
				
			}
		});
		b6.setBounds(847, 206, 91, 23);
		frame.getContentPane().add(b6);
		
		JButton b7 = new JButton("Show");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
						//String supp=String.valueOf(comboBox.getSelectedItem());
						String sname=String.valueOf(c2.getSelectedItem());
						String sub1=String.valueOf(sname.substring(0, 2));
						int sno = Integer.parseInt(sub1.trim());
					//	JOptionPane.showMessageDialog(null, cno);
						String query  = "select sno,sname,saddr,scon,email from supplier where sno=?" ;
						
					
						PreparedStatement stmt = conObject.prepareStatement(query);
						stmt.setInt(1, sno);
						ResultSet rs = stmt.executeQuery();								
					
				
					
				
					
					if(rs.next())
					{
						t1.setText(rs.getString(2));
						t2.setText(rs.getString(3));
						t3.setText(rs.getString(4));
						t4.setText(rs.getString(5));
						
					}	
					
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
				
				
			}
		});
		b7.setBounds(857, 225, 91, 23);
		frame.getContentPane().add(b7);
		
		t1 = new JTextField();
		t1.setBounds(559, 263, 123, 20);
		frame.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setBounds(559, 328, 123, 20);
		frame.getContentPane().add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(559, 388, 123, 20);
		frame.getContentPane().add(t3);
		t3.setColumns(10);
		
		t4 = new JTextField();
		t4.setBounds(559, 448, 123, 20);
		frame.getContentPane().add(t4);
		t4.setColumns(10);
		
		JRadioButton r1 = new JRadioButton("Add");
		r1.setBounds(74, 98, 109, 23);
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Update");
		r2.setBounds(74, 262, 109, 23);
		frame.getContentPane().add(r2);
		
		JRadioButton r3 = new JRadioButton("Delete");
		r3.setBounds(74, 442, 109, 23);
		frame.getContentPane().add(r3);
		

		l1.setVisible(false);
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);
		l5.setVisible(false);
		l6.setVisible(false);
		l7.setVisible(false);
		l8.setVisible(false);
		l9.setVisible(false);
		
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		t4.setVisible(false);
		
		b1.setVisible(false);
		b2.setVisible(false);
		b3.setVisible(false);
		b4.setVisible(false);
		b5.setVisible(false);
		b6.setVisible(false);
		b7.setVisible(false);
		
		c1.setVisible(false);
		c2.setVisible(false);
		
		
		s1.setVisible(false);
		s2.setVisible(false);
		
		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				l1.setVisible(true);
				l2.setVisible(false);
				l3.setVisible(false);
				l4.setVisible(true);
				l5.setVisible(true);
				l6.setVisible(true);
				l7.setVisible(true);
				l8.setVisible(true);
				l9.setVisible(true);
				
				t1.setVisible(true);
				t2.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				
				b1.setVisible(true);
				b2.setVisible(false);
				b3.setVisible(false);
				b4.setVisible(true);
				b5.setVisible(true);
				b6.setVisible(false);
				b7.setVisible(false);
				
				s1.setVisible(true);
				s2.setVisible(true);
				
				c1.setVisible(false);
				c2.setVisible(false);
			}	
		});
		
		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				l1.setVisible(false);
				l2.setVisible(true);
				l3.setVisible(false);
				l4.setVisible(true);
				l5.setVisible(true);
				l6.setVisible(true);
				l7.setVisible(true);
				l8.setVisible(true);
				l9.setVisible(false);
				
				c1.setVisible(true);
				c2.setVisible(false);
				
				t1.setVisible(true);
				t2.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				
				b1.setVisible(false);
				b2.setVisible(true);
				b3.setVisible(false);
				b4.setVisible(true);
				b5.setVisible(true);
				b6.setVisible(true);
				b7.setVisible(false);
				
				s1.setVisible(true);
				s2.setVisible(true);
				
				
			}	
		});
		
		r3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				l1.setVisible(false);
				l2.setVisible(false);
				l3.setVisible(true);
				l4.setVisible(true);
				l5.setVisible(true);
				l6.setVisible(true);
				l7.setVisible(true);
				l8.setVisible(true);
				l9.setVisible(false);
				
				c1.setVisible(false);
				c2.setVisible(true);
				
				t1.setVisible(true);
				t2.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(true);
				b4.setVisible(true);
				b5.setVisible(true);
				b6.setVisible(false);
				b7.setVisible(true);
				
				s1.setVisible(true);
				s2.setVisible(true);
				
			}	
		});

		
	}
}
