import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class customer {

	private static final long serialVersionUID = 1L;
	public JFrame frame;
	private JTextField t1;
	private JTextField t3;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer window = new customer();
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
	public customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.setBounds(100, 100, 1378, 893);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox<String> c1 = new JComboBox<String>();
		c1.setBounds(702, 207, 122, 22);
		frame.getContentPane().add(c1);
		

		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select cno,cname from Customer_add";
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
		
	
		
		JComboBox<String> c2 = new JComboBox<String>();
		c2.setBounds(705, 207, 113, 22);
		frame.getContentPane().add(c2);
		

		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select cno,cname from Customer_add";
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
		
		
	
		
		
		JLabel l1 = new JLabel("Customer Details Form");
		l1.setBounds(587, 127, 238, 21);
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Cambria", Font.BOLD, 17));
		frame.getContentPane().add(l1);
		
		JSeparator s1 = new JSeparator();
		s1.setBounds(538, 164, 314, 2);
		s1.setBackground(Color.BLACK);
		frame.getContentPane().add(s1);
		
		JLabel l4 = new JLabel("Customer No");
		l4.setBounds(512, 206, 102, 21);
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(l4);
		
		JLabel l5 = new JLabel("Name");
		l5.setBounds(530, 286, 46, 14);
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(l5);
		
		t1 = new JTextField();
		t1.setBounds(687, 285, 138, 20);
		t1.setColumns(10);
		frame.getContentPane().add(t1);
		
		JLabel l6 = new JLabel("Address");
		l6.setBounds(532, 368, 82, 14);
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(l6);
		
		JTextArea t2 = new JTextArea();
		t2.setBounds(687, 347, 137, 63);
		t2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, null));
		frame.getContentPane().add(t2);
		
		JLabel l7 = new JLabel("Contact No");
		l7.setBounds(532, 454, 82, 14);
		l7.setForeground(Color.BLACK);
		l7.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(l7);
		
		t3 = new JTextField();
		
		t3.addKeyListener(new KeyAdapter() 
		{
	       
			private static final long serialVersionUID = 1L;

			public void keyTyped(KeyEvent e)
			{
	          char c = e.getKeyChar();
	          if (!((c >= '0') && (c <= '9') ||
	             (c == KeyEvent.VK_BACK_SPACE) ||
	             (c == KeyEvent.VK_DELETE))) {
	           //  ((Object) getToolKit()).beep();
	            t3.setToolTipText("Please enter numbers ONLY");
	            e.consume();
	          }
	        }

			
	      });
		t3.setBounds(687, 453, 137, 20);
		t3.setColumns(10);
		frame.getContentPane().add(t3);
		
		 
		
		JLabel l8 = new JLabel("E-mail");
		l8.setBounds(543, 508, 46, 14);
		l8.setForeground(Color.BLACK);
		l8.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(l8);
		
		t4 = new JTextField();
		t4.setBounds(687, 507, 138, 20);
		t4.setColumns(10);
		frame.getContentPane().add(t4);
		
		JSeparator s2 = new JSeparator();
		s2.setBounds(518, 567, 314, 2);
		frame.getContentPane().add(s2);
		
		JButton b3 = new JButton("Delete");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b3.setBounds(505, 631, 109, 46);
		b3.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(b3);
		
		JButton b4 = new JButton("Exit");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(resp == 0)
				{
					frame.setVisible(false);
					frame.dispose();
					
					
					
				}
			}
		});
		b4.setBounds(741, 609, 91, 33);
		b4.setFont(new Font("Cambria", Font.BOLD, 15));
		frame.getContentPane().add(b4);
		
		JLabel l9 = new JLabel("");
		l9.setBounds(690, 206, 91, 23);
		frame.getContentPane().add(l9);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select top 1 cno from Customer_add order by cno desc";
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
		
		JButton b1 = new JButton("Add");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to add?");
				if(resp == 0)
				{
				
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
					String query  = "insert into  Customer_add(cname,caddr,ccon,cemail) values (?,?,?,?)";
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
		b1.setBounds(512, 605, 91, 42);
		b1.setFont(new Font("Tahoma", Font.BOLD, 16));
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
				String cname=String.valueOf(c1.getSelectedItem());
				String sub1=String.valueOf(cname.substring(0, 3));
				int cno = Integer.parseInt(sub1.trim());
			String query  = "update Customer_add set cname=?,caddr=?,ccon=?,cemail=? where cno="+cno;
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
		b2.setBounds(494, 605, 115, 42);
		b2.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(b2);
		
		JButton b5 = new JButton("Show");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
						//String supp=String.valueOf(comboBox.getSelectedItem());
						String cname=String.valueOf(c1.getSelectedItem());
						String sub1=String.valueOf(cname.substring(0, 2));
						int cno = Integer.parseInt(sub1.trim());
					//	JOptionPane.showMessageDialog(null, cno);
						String query  = "select cno,cname,caddr,ccon,cemail from Customer_add where cno=?" ;
						
					
						PreparedStatement stmt = conObject.prepareStatement(query);
						stmt.setInt(1, cno);
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
		b5.setBounds(905, 200, 91, 33);
		b5.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(b5);
		
		JButton b6 = new JButton("show");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
						//String supp=String.valueOf(comboBox.getSelectedItem());
						String cname=String.valueOf(c2.getSelectedItem());
						String sub1=String.valueOf(cname.substring(0, 2));
						int cno = Integer.parseInt(sub1.trim());
					//	JOptionPane.showMessageDialog(null, cno);
						String query  = "select cno,cname,caddr,ccon,cemail from Customer_add where cno=?" ;
						
					
						PreparedStatement stmt = conObject.prepareStatement(query);
						stmt.setInt(1, cno);
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
		b6.setBounds(905, 200, 91, 33);
		b6.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(b6);
		
		JRadioButton r1 = new JRadioButton("Add");
		r1.setBounds(480, 41, 109, 33);
		r1.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("Update");
		r2.setBounds(741, 44, 109, 26);
		r2.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(r2);
		
		JRadioButton r3 = new JRadioButton("Delete");
		r3.setBounds(988, 46, 109, 23);
		r3.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(r3);
		
		JLabel l2 = new JLabel("Customer Update Form");
		l2.setBounds(587, 128, 231, 21);
		l2.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("Customer Delete Form");
		l3.setBounds(597, 128, 180, 21);
		l3.setFont(new Font("Tahoma", Font.BOLD, 15));
		frame.getContentPane().add(l3);
		
		
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\flat-2879273__340.jpg"));
		label.setBounds(10, 0, 1370, 764);
		frame.getContentPane().add(label);
		
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
				b5.setVisible(false);
				b6.setVisible(false);
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
				
				s1.setVisible(true);
				s2.setVisible(true);
				b6.setVisible(false);
				
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
				b5.setVisible(false);
				b6.setVisible(true);
				s1.setVisible(true);
				s2.setVisible(true);
				
			}	
		});

		
	}

	protected Object getToolKit() {
		// TODO Auto-generated method stub
		return null;
	}
}
