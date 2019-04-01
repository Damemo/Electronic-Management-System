import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;

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
import javax.swing.JComboBox;

public class Supplier_add extends JFrame {

	/**
	 * 
	 */
	public JFrame frame;
	
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
					Supplier_add frame = new Supplier_add();
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
	 */
	public Supplier_add() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 51, 153));
		frame.setBounds(100, 100, 1378, 790);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		

		JComboBox<String> c1 = new JComboBox<String>();
		c1.setBounds(611, 150, 178, 22);
		contentPane.add(c1);
		
		
		JComboBox<String> c2 = new JComboBox<String>();
		c2.setBounds(611, 150, 178, 22);
		contentPane.add(c2);
		
		
		Panel panel = new Panel();
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(540, 214, 485, 252);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1437, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton b7 = new JButton("Delete");
		b7.setBounds(383, 472, 109, 36);
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
				if(resp == 0)
				{
				try
				{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				String supp=String.valueOf(c2.getSelectedItem());
			String query  = "delete * from  supplier  where sno="+Integer.parseInt(supp);
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
		});*/
				
		contentPane.setLayout(null);
		b7.setFont(new Font("Cambria", Font.BOLD, 22));
		contentPane.add(b7);
		
		JButton b6 = new JButton("Update");
		b6.setBounds(383, 472, 133, 35);
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?");
				if(resp == 0)
				{
				try
				{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				String supp=String.valueOf(c1.getSelectedItem());
			String query  = "update supplier set sname=?,saddr=?,scon=?,email=? where sno="+Integer.parseInt(supp);
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
		b6.setFont(new Font("Cambria", Font.BOLD, 22));
		contentPane.add(b6);
		
	
		
		
		JButton b5 = new JButton("Show");
		b5.setBounds(833, 150, 99, 39);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					String supp=String.valueOf(c2.getSelectedItem());
				
					String query  = "select * from supplier where sno="+Integer.parseInt(supp);
					PreparedStatement stmt = conObject.prepareStatement(query);
				
					ResultSet rs = stmt.executeQuery();
					
					
					while(rs.next())
					{
						
						t2.setText(rs.getString(1));
						t3.setText(rs.getString(2));
						t4.setText(String.valueOf(rs.getString(3)));
						t5.setText(rs.getString(4));
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
		b5.setFont(new Font("Cambria", Font.BOLD, 22));
		contentPane.add(b5);
		

		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select sno,cname from supplier";
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
		
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select sno,cname from supplier";
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
		
		
		JButton b4 = new JButton("Show");
		b4.setBounds(833, 147, 91, 39);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
						
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					String supp=String.valueOf(c1.getSelectedItem());
				
					String query  = "select * from supplier where sno="+Integer.parseInt(supp);
					PreparedStatement stmt = conObject.prepareStatement(query);
				
					ResultSet rs = stmt.executeQuery();
				
					
					if(rs.next())
					{
						t2.setText(rs.getString(2));
						t3.setText(rs.getString(3));
						t4.setText(String.valueOf(rs.getString(4)));
						t5.setText(rs.getString(5));
					}	
					
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
					
				}
				
				
			
		});
		b4.setFont(new Font("Cambria", Font.BOLD, 22));
		contentPane.add(b4);
		
		JLabel t1 = new JLabel("");
		t1.setBounds(611, 154, 178, 21);
		contentPane.add(t1);
		
		JLabel l3 = new JLabel("Supplier  Delete Details ");
		l3.setBounds(441, 67, 340, 39);
		l3.setForeground(Color.WHITE);
		l3.setFont(new Font("Cambria", Font.BOLD, 25));
		contentPane.add(l3);
		
		JLabel l2 = new JLabel("Supplier Update  Details  ");
		l2.setBounds(441, 59, 348, 47);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Cambria", Font.BOLD, 25));
		contentPane.add(l2);
		
		JLabel l4 = new JLabel("Supplier No");
		l4.setBounds(427, 147, 126, 21);
		l4.setBackground(Color.BLACK);
		l4.setForeground(Color.WHITE);
		l4.setFont(new Font("Cambria", Font.PLAIN, 22));
		contentPane.add(l4);
		
		JLabel l1 = new JLabel("Supplier Details Form");
		l1.setBounds(441, 67, 312, 39);
		l1.setBackground(Color.BLACK);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Cambria", Font.BOLD, 29));
		contentPane.add(l1);
		
		JLabel l6 = new JLabel("Address");
		l6.setBounds(427, 260, 99, 21);
		l6.setBackground(Color.BLACK);
		l6.setForeground(Color.WHITE);
		l6.setFont(new Font("Cambria", Font.PLAIN, 22));
		contentPane.add(l6);
		
		JLabel l5 = new JLabel("Name");
		l5.setBounds(427, 199, 99, 27);
		l5.setBackground(Color.BLACK);
		l5.setForeground(Color.WHITE);
		l5.setFont(new Font("Cambria", Font.PLAIN, 22));
		contentPane.add(l5);
		
		JLabel l8 = new JLabel("E-mail");
		l8.setBounds(427, 388, 91, 20);
		l8.setBackground(Color.BLACK);
		l8.setForeground(Color.WHITE);
		l8.setFont(new Font("Cambria", Font.PLAIN, 22));
		contentPane.add(l8);
		
		JLabel l7 = new JLabel("Contact No");
		l7.setBounds(427, 341, 111, 19);
		l7.setBackground(Color.BLACK);
		l7.setForeground(Color.WHITE);
		l7.setFont(new Font("Cambria", Font.PLAIN, 22));
		contentPane.add(l7);
		
		t2 = new JTextField();
		t2.setBounds(611, 201, 178, 27);
		t2.setToolTipText("Enter the name");
		t2.setFont(new Font("Cambria", Font.PLAIN, 15));
		contentPane.add(t2);
		t2.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(251, 112, -94, 39);
		contentPane.add(textArea);
		
		t3 = new JTextArea();
		t3.setBounds(611, 250, 178, 63);
		t3.setToolTipText("Enter supplier's address");
		t3.setFont(new Font("Cambria", Font.PLAIN, 15));
		t3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, null));
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setBounds(611, 336, 177, 27);
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
		contentPane.add(t4);
		t4.setColumns(10);
			
		t5 = new JTextField();
		t5.setBounds(611, 388, 178, 23);
		t5.setToolTipText("Enter e-mail ID");
		t5.setFont(new Font("Cambria", Font.PLAIN, 15));
		contentPane.add(t5);
		t5.setColumns(10);
		
		JButton b1 = new JButton("Save");
		b1.setBounds(383, 470, 111, 39);
		b1.setFont(new Font("Cambria", Font.BOLD, 22));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to add?");
				if(resp == 0)
				{
				
				try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
					String query  = "insert into supplier(sname,saddr,scon,email) values (?,?,?,?)";
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
		contentPane.add(b1);
		
		JSeparator s1 = new JSeparator();
		s1.setBounds(362, 117, 483, 2);
		contentPane.add(s1);
		
		JSeparator s2 = new JSeparator();
		s2.setBounds(362, 438, 539, 2);
		contentPane.add(s2);
		
		JButton b2 = new JButton("View");
		b2.setBounds(585, 470, 111, 39);
		b2.setFont(new Font("Cambria", Font.BOLD, 22));
		contentPane.add(b2);
		
		JButton b3 = new JButton("Exit");
		b3.setBounds(774, 470, 99, 39);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(resp == 0)
				{
				 frame.setVisible(false);
					frame.dispose();
					
					
					
				}
			}
			
		});
		b3.setFont(new Font("Cambria", Font.BOLD, 22));
		contentPane.add(b3);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(-120, 0, 1643, 845);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\background-3089930__340.jpg"));
		contentPane.add(lblNewLabel);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select top 1 sno from supplier order by sno desc";
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
			
	}
	
});
	}
}







	
		


