import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public class Customer_add extends JFrame {

	/**
	 * 
	 */
	public JPanel frame1;
	
	private static final long serialVersionUID = 1L;
	public JPanel frame;
	private JTextField t2;
	private JTextField t4;
	private JTextField t5;
	private JTextArea t3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_add frame = new Customer_add();
				frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 * @param keyListener 
	 * @return 
	 *
	 */
	public Customer_add() {
		initialize();
	}
	
	public void initialize() {
		frame1 = new JFrame();
		
		frame1.setBounds(100, 100, 1378, 790);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		
		setTitle("AM ELECTRONICS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1381, 780);
		frame1 = new JPanel();
		frame1.setForeground(Color.WHITE);
		frame1.setBackground(new Color(51, 51, 153));
		frame1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setframe(frame1);
		frame1.setLayout(null);
		

		final JComboBox<String> c2 = new JComboBox<String>();
		c2.setBounds(716, 229, 91, 22);
		frame1.add(c2);
		
		JButton b4 = new JButton("Delete");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
				if(resp == 0)
				{
				try
				{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				String supp=String.valueOf(c2.getSelectedItem());
			String query  = "delete * from  Customer_add  where cno="+Integer.parseInt(supp);
			PreparedStatement stmt = conObject.prepareStatement(query);
			
						
			int result = stmt.executeUpdate();
			if(result == 1)
			{
				JOptionPane.showMessageDialog(null, "Record deleted successfully!");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				c2.removeItem(supp);
			}
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
		b4.setFont(new Font("Cambria", Font.BOLD, 15));
		b4.setBounds(510, 462, 91, 30);
		frame1.add(b4);
		

		
		final JButton b3 = new JButton("Show");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					String supp=String.valueOf(c2.getSelectedItem());
				
					String query  = "select * from Customer_add where cno="+Integer.parseInt(supp);
					PreparedStatement stmt = conObject.prepareStatement(query);
				
					ResultSet rs = stmt.executeQuery();
					
					
					while(rs.next())
					{
						
						t2.setText(rs.getString(2));
						t3.setText(rs.getString(3));
						t4.setText(String.valueOf(rs.getString(4)));
						t5.setText(rs.getString(5));
					}	
					stmt.close();
					conObject.close();
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
					
				}
				
			
		});
		b3.setFont(new Font("Cambria", Font.BOLD, 15));
		b3.setBounds(879, 227, 91, 23);
		frame1.add(b3);
		
		
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
		
		
		final JComboBox<String> c1 = new JComboBox<String>();
		c1.setBounds(716, 229, 91, 22);
		frame1.add(c1);
		
		
		final JButton b1 = new JButton("Show");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
						//String supp=String.valueOf(comboBox.getSelectedItem());
						String cname=String.valueOf(c1.getSelectedItem());
						String sub1=String.valueOf(cname.substring(0, 3));
						int cno = Integer.parseInt(sub1.trim());
					//	JOptionPane.showMessageDialog(null, cno);
						String query  = "select cno,cname,caddr,ccon,cemail from Customer_add where cno=?" ;
						
					
						PreparedStatement stmt = conObject.prepareStatement(query);
						stmt.setInt(1, cno);
						ResultSet rs = stmt.executeQuery();								
					
				
					
				
					
					if(rs.next())
					{
						t2.setText(rs.getString(2));
						t3.setText(rs.getString(3));
						t4.setText(String.valueOf(rs.getInt(4)));
						t5.setText(rs.getString(5));
					}	
					
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
					
				
				
				
				
			}
			
			
		});
		
		
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
			
			stmt.setString(1,t2.getText());
			stmt.setString(2,t3.getText());
			stmt.setInt(3,Integer.parseInt(t4.getText()));
			stmt.setString(4,t5.getText());
			
			
					
			
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
		b2.setFont(new Font("Cambria", Font.BOLD, 15));
		b2.setBounds(510, 465, 91, 23);
		frame1.add(b2);
		
		
		
		
		b1.setFont(new Font("Cambria", Font.BOLD, 15));
		b1.setBounds(879, 229, 91, 23);
		frame1.add(b1);
		
		
		
		JLabel t1 = new JLabel("");
		t1.setBounds(706, 231, 138, 14);
		frame1.add(t1);
		
		
		JLabel l2 = new JLabel("Customer Delete Form");
		l2.setForeground(Color.BLACK);
		l2.setFont(new Font("Cambria", Font.BOLD, 25));
		l2.setBounds(575, 162, 279, 30);
		frame1.add(l2);
		
		JLabel l1 = new JLabel("Customer Update Form");
		l1.setForeground(Color.BLACK);
		l1.setFont(new Font("Cambria", Font.BOLD, 25));
		l1.setBounds(575, 159, 266, 37);
		frame1.add(l1);
		
		JRadioButton r3 = new JRadioButton("Delete");
		r3.setFont(new Font("Cambria", Font.BOLD, 20));
		r3.setBounds(839, 103, 109, 23);
		frame1.add(r3);
		
		JRadioButton r2 = new JRadioButton("Update");
		r2.setFont(new Font("Cambria", Font.BOLD, 20));
		r2.setBounds(660, 103, 109, 23);
		frame1.add(r2);
		
		JRadioButton r1 = new JRadioButton("Add");
		r1.setFont(new Font("Cambria", Font.BOLD, 20));
		r1.setBounds(487, 103, 109, 23);
		frame1.add(r1);
		
		JLabel l4 = new JLabel("Customer No");
		l4.setBackground(Color.BLACK);
		l4.setForeground(Color.BLACK);
		l4.setFont(new Font("Cambria", Font.BOLD, 17));
		l4.setBounds(553, 225, 116, 21);
		frame1.add(l4);
		
		JLabel l3 = new JLabel("Customer Details Form");
		l3.setBackground(Color.BLACK);
		l3.setForeground(Color.BLACK);
		l3.setFont(new Font("Cambria", Font.BOLD, 25));
		l3.setBounds(575, 160, 305, 35);
		frame1.add(l3);
		
		JLabel l6 = new JLabel("Address");
		l6.setBackground(Color.BLACK);
		l6.setForeground(Color.BLACK);
		l6.setFont(new Font("Cambria", Font.BOLD, 17));
		l6.setBounds(553, 292, 97, 21);
		frame1.add(l6);
		
		JLabel l5 = new JLabel("Name");
		l5.setBackground(Color.BLACK);
		l5.setForeground(Color.BLACK);
		l5.setFont(new Font("Cambria", Font.BOLD, 17));
		l5.setBounds(553, 257, 61, 14);
		frame1.add(l5);
		
		JLabel l8 = new JLabel("E-mail ID");
		l8.setBackground(Color.BLACK);
		l8.setForeground(Color.BLACK);
		l8.setFont(new Font("Cambria", Font.BOLD, 17));
		l8.setBounds(553, 395, 97, 19);
		frame1.add(l8);
		
		JLabel l7 = new JLabel("Contact No");
		l7.setBackground(Color.BLACK);
		l7.setForeground(Color.BLACK);
		l7.setFont(new Font("Cambria", Font.BOLD, 17));
		l7.setBounds(553, 364, 97, 14);
		frame1.add(l7);
		
		t2 = new JTextField();
		t2.setBounds(706, 258, 138, 20);
		frame1.add(t2);
		t2.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(251, 112, -94, 39);
		frame1.add(textArea);
		
		t3 = new JTextArea();
		t3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, null));
		t3.setBounds(707, 289, 137, 63);
		frame1.add(t3);
		
		t4 = new JTextField();
		//t4.addKeyListener(keyListener);
		t4.addKeyListener(new KeyAdapter() 
		{
	       
			private static final long serialVersionUID = 1L;

			public void keyTyped(KeyEvent e)
			{
	          char c = e.getKeyChar();
	          if (!((c >= '0') && (c <= '9') ||
	             (c == KeyEvent.VK_BACK_SPACE) ||
	             (c == KeyEvent.VK_DELETE))) {
	            getToolkit().beep();
	            t4.setToolTipText("Please enter numbers ONLY");
	            e.consume();
	          }
	        }
	      });
		 
		 
		    
		t4.setBounds(707, 363, 137, 20);
		frame1.add(t4);
		t4.setColumns(10);
			
		t5 = new JTextField();
		t5.setBounds(706, 394, 138, 20);
		frame1.add(t5);
		t5.setColumns(10);
		
		JButton b7 = new JButton("Save");
		b7.setFont(new Font("Cambria", Font.BOLD, 15));
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to add?");
				if(resp == 0)
				{
				
				try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
					String query  = "insert into Customer_add(cname,caddr,ccon,cemail) values (?,?,?,?)";
					PreparedStatement stmt = conObject.prepareStatement(query);
					
					stmt.setString(1,t2.getText());
			
		
					
					stmt.setString(2,t3.getText());
					stmt.setInt(3,Integer.parseInt(t4.getText()));
					stmt.setString(4,t5.getText());
					
					
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
		b7.setBounds(510, 465, 91, 23);
		frame1.add(b7);
		
		JSeparator s1 = new JSeparator();
		s1.setBounds(529, 208, 410, 2);
		frame1.add(s1);
		
		JSeparator s2 = new JSeparator();
		s2.setBounds(487, 442, 452, 2);
		frame1.add(s2);
		
		JButton b5 = new JButton("View");
		b5.setFont(new Font("Cambria", Font.BOLD, 15));
		b5.setBounds(660, 465, 91, 23);
		frame1.add(b5);
		
		JButton b6 = new JButton("Exit");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(resp == 0)
				{
					frame1.setVisible(false);
						//frame1.dispose();
					
					//System.exit(1);
					//MDI1 frame1 = new MDI1();
					//frame1.frmAmEletronics.setVisible(true);
					
				}
			}
			
		});
		b6.setFont(new Font("Cambria", Font.BOLD, 15));
		b6.setBounds(810, 465, 91, 23);
		frame1.add(b6);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(706, 231, 91, 22);
		frame1.add(comboBox);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\flat-2879273__340.jpg"));
		label.setBounds(0, 0, 1370, 753);
		frame1.add(label);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select top 1 cno from Customer_add order by cno desc";
			ResultSet rs = stmt.executeQuery(query);		
			if(!rs.next())
				t1.setText(String.valueOf(1));
			else
				t1.setText(String.valueOf(rs.getInt(1)+1));
			
			stmt.close();
			conObject.close();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
		
			}
		
		l1.setVisible(false);
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);
		l5.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		t3.setVisible(false);
		t4.setVisible(false);
		t5.setVisible(false);
		b1.setVisible(false);
		b2.setVisible(false);
		b3.setVisible(false);
		b4.setVisible(false);
		b5.setVisible(false);
		c1.setVisible(false);
		b7.setVisible(false);
		c2.setVisible(false);
		
		b6.setVisible(false);
		s1.setVisible(false);
		s2.setVisible(false);
		l6.setVisible(false);
		l7.setVisible(false);
		l8.setVisible(false);
		
		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				l1.setVisible(false);
				l2.setVisible(false);
				l3.setVisible(true);
				l4.setVisible(true);
				l5.setVisible(true);
				l6.setVisible(true);
				l7.setVisible(true);
				l8.setVisible(true);
				t1.setVisible(true);
				t2.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				t5.setVisible(true);
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(false);
				b4.setVisible(false);
				b5.setVisible(true);
				b6.setVisible(true);
				b7.setVisible(true);
				s1.setVisible(true);
				s2.setVisible(true);
				
			}	
		});
		
		r2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				l1.setVisible(true);
				l2.setVisible(false);
				l3.setVisible(false);
				l4.setVisible(true);
				l5.setVisible(true);
				l6.setVisible(true);
				l7.setVisible(true);
				l8.setVisible(true);
				c1.setVisible(true);
				t1.setVisible(false);
				t2.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				t5.setVisible(true);
				b1.setVisible(false);
				b2.setVisible(true);
				b3.setVisible(false);
				b4.setVisible(true);
				b5.setVisible(true);
				c2.setVisible(false);
				s1.setVisible(true);
				s2.setVisible(true);
				b6.setVisible(true);
				
			}	
		});
		

		r3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				l1.setVisible(false);
				l2.setVisible(true);
				l3.setVisible(false);
				l4.setVisible(true);
				l5.setVisible(true);
				l6.setVisible(true);
				l7.setVisible(true);
				l8.setVisible(true);
				c1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				t5.setVisible(true);
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(false);
				b4.setVisible(true);
				b5.setVisible(true);
				c2.setVisible(true);
				s1.setVisible(true);
				s2.setVisible(true);
				b6.setVisible(true);
			}	
		});
		
		}
	}
	
		


