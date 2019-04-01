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

import org.omg.CORBA.INITIALIZE;

import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class staff_add extends JFrame {
	public staff_add() {
	}

	/**
	 * 
	 */
	public JFrame frame1;
	
	private static final long serialVersionUID = 1L;
	public JPanel contentPane;
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
					staff_add frame1 = new staff_add();
					frame1.setVisible(true);
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
	 */
	public void staff_add() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1436, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton r3 = new JRadioButton("Delete");
		r3.setBounds(68, 459, 109, 35);
		contentPane.add(r3);
		
		JRadioButton r2 = new JRadioButton("Update");
		r2.setBounds(68, 285, 126, 35);
		contentPane.add(r2);
		
		JRadioButton r1 = new JRadioButton("Add");
		r1.setBounds(68, 128, 126, 35);
		contentPane.add(r1);
		
		
		
		
		JComboBox<String> c2 = new JComboBox<String>();
		c2.setBounds(611, 146, 178, 22);
		contentPane.add(c2);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select sno,sname from staff";
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
		
		JComboBox<String> c1 = new JComboBox<String>();
		c1.setBounds(621, 146, 178, 22);
		contentPane.add(c1);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select sno,sname from staff";
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
		
		
		JButton b2 = new JButton("Show");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
						//String supp=String.valueOf(comboBox.getSelectedItem());
						String sname=String.valueOf(c2.getSelectedItem());
						String sub1=String.valueOf(sname.substring(0, 2));
						int sno = Integer.parseInt(sub1.trim());
					//	JOptionPane.showMessageDialog(null, cno);
						String query  = "select sno,sname,saddr,scon,semail from staff where sno=?" ;
						
					
						PreparedStatement stmt = conObject.prepareStatement(query);
						stmt.setInt(1, sno);
						ResultSet rs = stmt.executeQuery();								
					
				
					
				
					
					if(rs.next())
					{
						t2.setText(rs.getString(2));
						t3.setText(rs.getString(3));
						t4.setText(rs.getString(4));
						t5.setText(rs.getString(5));
						
					}	
					
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
				
				
				
			}
		});
		b2.setBounds(852, 144, 91, 35);
		contentPane.add(b2);
		
		
		
		JButton b1 = new JButton("Show");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
						//String supp=String.valueOf(comboBox.getSelectedItem());
						String sname=String.valueOf(c1.getSelectedItem());
						String sub1=String.valueOf(sname.substring(0, 2));
						int sno = Integer.parseInt(sub1.trim());
					//	JOptionPane.showMessageDialog(null, cno);
						String query  = "select sno,sname,saddr,scon,semail from staff where sno=?" ;
						
					
						PreparedStatement stmt = conObject.prepareStatement(query);
						stmt.setInt(1, sno);
						ResultSet rs = stmt.executeQuery();								
					
				
					
				
					
					if(rs.next())
					{
						t2.setText(rs.getString(2));
						t3.setText(rs.getString(3));
						t4.setText(rs.getString(4));
						t5.setText(rs.getString(5));
						
					}	
					
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
				
			}
		});
		b1.setBounds(842, 140, 91, 35);
		contentPane.add(b1);
		
		try {
			
			
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			
				//String supp=String.valueOf(comboBox.getSelectedItem());
				String sname=String.valueOf(c2.getSelectedItem());
				String sub1=String.valueOf(sname.substring(0, 2));
				int sno = Integer.parseInt(sub1.trim());
			//	JOptionPane.showMessageDialog(null, cno);
				String query  = "select sno,sname,saddr,scon,semail from staff where sno=?" ;
				
			
				PreparedStatement stmt = conObject.prepareStatement(query);
				stmt.setInt(1, sno);
				ResultSet rs = stmt.executeQuery();								
			
		
			
		
			
			if(rs.next())
			{
				t2.setText(rs.getString(2));
				t3.setText(rs.getString(3));
				t4.setText(rs.getString(4));
				t5.setText(rs.getString(5));
				
			}	
			
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
			
		
		

		JButton b5 = new JButton("Delete");
		b5.setBounds(393, 476, 91, 35);
		contentPane.add(b5);
		
		JButton b4 = new JButton("Update");
		b4.addActionListener(new ActionListener() {
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
			String query  = "update staff set sname=?,saddr=?,scon=?,semail=? where sno="+sno;
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
		b4.setBounds(383, 479, 91, 30);
		contentPane.add(b4);
		
		
		
		JLabel t1 = new JLabel("");
		t1.setForeground(Color.WHITE);
		t1.setBounds(611, 147, 178, 21);
		contentPane.add(t1);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select top 1 sno from staff order by sno desc";
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
		
		JLabel l3 = new JLabel("Staff Delete Details  ");
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Cambria", Font.BOLD, 29));
		l3.setBounds(441, 76, 268, 21);
		contentPane.add(l3);
		
		JLabel l2 = new JLabel("Staff  Update Details ");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Cambria", Font.BOLD, 29));
		l2.setBounds(441, 69, 331, 35);
		contentPane.add(l2);
		
		JLabel l4 = new JLabel("Staff No");
		l4.setBackground(Color.BLACK);
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Cambria", Font.PLAIN, 22));
		l4.setBounds(427, 147, 126, 21);
		contentPane.add(l4);
		
		JLabel l1 = new JLabel("Staff Details Form");
		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Cambria", Font.BOLD, 29));
		l1.setBounds(441, 67, 312, 39);
		contentPane.add(l1);
		
		JLabel l6 = new JLabel("Address");
		l6.setBackground(Color.BLACK);
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("Cambria", Font.PLAIN, 22));
		l6.setBounds(427, 260, 99, 21);
		contentPane.add(l6);
		
		JLabel l5 = new JLabel("Name");
		l5.setBackground(Color.BLACK);
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Cambria", Font.PLAIN, 22));
		l5.setBounds(427, 199, 99, 27);
		contentPane.add(l5);
		
		JLabel l8 = new JLabel("E-mail");
		l8.setBackground(Color.BLACK);
		l8.setForeground(Color.WHITE);
		l8.setFont(new Font("Cambria", Font.PLAIN, 22));
		l8.setBounds(427, 388, 91, 20);
		contentPane.add(l8);
		
		JLabel l7 = new JLabel("Contact No");
		l7.setBackground(Color.BLACK);
		l7.setForeground(Color.WHITE);
		l7.setFont(new Font("Cambria", Font.PLAIN, 22));
		l7.setBounds(427, 341, 111, 19);
		contentPane.add(l7);
		
		t2 = new JTextField();
		t2.setToolTipText("Enter the name");
		t2.setFont(new Font("Cambria", Font.PLAIN, 15));
		t2.setBounds(611, 201, 178, 27);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(251, 112, -94, 39);
		contentPane.add(textArea);
		
		t3 = new JTextArea();
		t3.setToolTipText("Enter supplier's address");
		t3.setFont(new Font("Cambria", Font.PLAIN, 15));
		t3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, null));
		t3.setBounds(611, 250, 178, 63);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setToolTipText("Enter contact number");
		t4.setFont(new Font("Cambria", Font.PLAIN, 15));
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
		 
		 
		    /*private static final long serialVersionUID = 1L;

		    @Override
		    public void processKeyEvent(KeyEvent ev) {
		       if (Character.isDigit(ev.getKeyChar())) {
		            super.processKeyEvent(ev);
		       }
		       ev.consume();
		        return;
		    }

		    /**
		     * As the user is not even able to enter a dot ("."), only integers (whole numbers) may be entered.
		     */
		 /*   public Long getNumber() {
		        Long result = null;
		        String text = getText();
		        if (text != null && !"".equals(text)) {
		            result = Long.valueOf(text);
		        }
		        return result;
		    }
		} */
		t4.setBounds(611, 336, 177, 27);
		contentPane.add(t4);
		t4.setColumns(10);
			
		t5 = new JTextField();
		t5.setToolTipText("Enter e-mail ID");
		t5.setFont(new Font("Cambria", Font.PLAIN, 15));
		t5.setBounds(611, 388, 178, 23);
		contentPane.add(t5);
		t5.setColumns(10);
		
		JButton b3 = new JButton("Save");
		b3.setFont(new Font("Cambria", Font.BOLD, 22));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to add?");
				if(resp == 0)
				{
				
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
					String query  = "insert into  staff(sname,saddr,scon,semail) values (?,?,?,?)";
					PreparedStatement stmt = conObject.prepareStatement(query);
					
					stmt.setString(1,t2.getText());
					stmt.setString(2,t3.getText());
					stmt.setString(3,t4.getText());
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
		b3.setBounds(383, 470, 111, 39);
		contentPane.add(b3);
		
		JSeparator s1 = new JSeparator();
		s1.setBounds(362, 117, 483, 2);
		contentPane.add(s1);
		
		JSeparator s2 = new JSeparator();
		s2.setBounds(362, 438, 539, 2);
		contentPane.add(s2);
		
		JButton b6 = new JButton("View");
		b6.setFont(new Font("Cambria", Font.BOLD, 22));
		b6.setBounds(585, 470, 111, 39);
		contentPane.add(b6);
		
		JButton b7 = new JButton("Exit");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(resp == 0)
				{
					System.exit(1);
					MDI1 frame1 = new MDI1();
					frame1.frmAmEletronics.setVisible(true);
					
				}
			}
			
		});
		b7.setFont(new Font("Cambria", Font.BOLD, 22));
		b7.setBounds(774, 470, 99, 39);
		contentPane.add(b7);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\BIG.jpg"));
		lblNewLabel.setBounds(-28, 0, 1411, 753);
		contentPane.add(lblNewLabel);
		
		
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select top 1 sno from staff order by sno desc";
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
		l6.setVisible(false);
		l7.setVisible(false);
		l8.setVisible(false);
		
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
				
				t1.setVisible(true);
				t2.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				t5.setVisible(true);
				
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(true);
				b4.setVisible(false);
				b5.setVisible(false);
				b6.setVisible(true);
				b7.setVisible(true);
				
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
			
				
				c1.setVisible(true);
				c2.setVisible(false);
				
				t1.setVisible(false);
				t2.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				t5.setVisible(true);
				
				b1.setVisible(true);
				b2.setVisible(false);
				b3.setVisible(false);
				b4.setVisible(true);
				b5.setVisible(false);
				b6.setVisible(true);
				b7.setVisible(true);
				
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
				
				c1.setVisible(false);
				c2.setVisible(true);
				
				t1.setVisible(false);
				t2.setVisible(true);
				t3.setVisible(true);
				t4.setVisible(true);
				t5.setVisible(true);
				
				b1.setVisible(false);
				b2.setVisible(true);
				b3.setVisible(false);
				b4.setVisible(false);
				b5.setVisible(true);
				b6.setVisible(true);
				b7.setVisible(true);
				
				s1.setVisible(true);
				s2.setVisible(true);
				
			}	
		});
		
		}
	}
	
		


