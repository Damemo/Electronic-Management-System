import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;

public class app_add //extends javax.swing.JFrame
{

	public JFrame frmAmElectronics;
	
	private JTable table;
	private JTextField t2;
	//private JTable table_1;

	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					app_add window = new app_add();
					window.frmAmElectronics.setVisible(true);
				} catch (Exception e) {
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public app_add() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.setTitle("AM ELECTRONICS");
		frmAmElectronics.getContentPane().setBackground(new Color(51, 153, 255));
		frmAmElectronics.setBounds(100, 100, 1378, 887);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		
		
		
		
	
		JLabel lblNewLabel_9 = new JLabel("AM ELECTRONICS");
		lblNewLabel_9.setBackground(new Color(153, 51, 204));
		lblNewLabel_9.setFont(new Font("Monotype Corsiva", Font.BOLD, 72));
		lblNewLabel_9.setBounds(677, 174, 693, 59);
		frmAmElectronics.getContentPane().add(lblNewLabel_9);
		
		JLabel l1 = new JLabel("Appliance Add Details");
		l1.setFont(new Font("Tahoma", Font.BOLD, 30));
		l1.setBounds(79, 311, 355, 31);
		frmAmElectronics.getContentPane().add(l1);
		
		JLabel l4 = new JLabel("Appliance no");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l4.setBounds(48, 432, 155, 32);
		frmAmElectronics.getContentPane().add(l4);
		
		JLabel l5 = new JLabel("Appliance name");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l5.setBounds(48, 510, 155, 23);
		frmAmElectronics.getContentPane().add(l5);
		
		JLabel t1 = new JLabel("");
		t1.setBackground(Color.WHITE);
		t1.setForeground(Color.WHITE);
		t1.setToolTipText("Auto app no");
		t1.setFont(new Font("Cambria", Font.PLAIN, 15));
		t1.setBounds(249, 441, 91, 23);
		frmAmElectronics.getContentPane().add(t1);
		
		
		JRadioButton r1 = new JRadioButton("Add");
		r1.setToolTipText("Add Info");
		r1.setFont(new Font("Cambria", Font.BOLD, 23));
		r1.setBounds(24, 255, 109, 23);
		frmAmElectronics.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("update");
		r2.setToolTipText("Update Info");
		r2.setFont(new Font("Cambria", Font.BOLD, 23));
		r2.setBounds(177, 251, 109, 31);
		frmAmElectronics.getContentPane().add(r2);
		
		JRadioButton r3 = new JRadioButton("Delete");
		r3.setToolTipText("Delete Info");
		r3.setFont(new Font("Cambria", Font.BOLD, 23));
		r3.setBounds(350, 255, 109, 23);
		frmAmElectronics.getContentPane().add(r3);
	
		JButton b1 = new JButton("Save");
		b1.setFont(new Font("Tahoma", Font.BOLD, 17));
		b1.setToolTipText("save");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					String query1  = "insert into app(aid,aname) values (?,?)";
					PreparedStatement stmt1 = conObject.prepareStatement(query1);
					
					if(r1.isSelected() == true)
			        {
			        	stmt1.setString(1,"Add");
			        	stmt1.setString(2,t1.getText());
			        	stmt1.setString(3,t2.getText());
			        	
			        }
				


			
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to add?");
				if(resp == 0)
				{
				
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
					String query  = "insert into  app(aname) values (?)";
					PreparedStatement stmt = conObject.prepareStatement(query);
					
					stmt.setString(1,t2.getText());
					
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
		b1.setBounds(59, 594, 91, 23);
		frmAmElectronics.getContentPane().add(b1);
		
		JButton b2 = new JButton("View");
		b2.setFont(new Font("Tahoma", Font.BOLD, 17));
		b2.setToolTipText("view data");
		b2.setBounds(226, 594, 91, 23);
		frmAmElectronics.getContentPane().add(b2);
		
		JButton b3 = new JButton("Exit");
		b3.setFont(new Font("Tahoma", Font.BOLD, 17));
		b3.setToolTipText("go to MDI");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(resp == 0)
				{
					frmAmElectronics.setVisible(false);
					frmAmElectronics.dispose();
					
					
					
				}
			}
		
		});
		b3.setBounds(382, 594, 91, 23);
		frmAmElectronics.getContentPane().add(b3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-22, -7, 1392, 176);
		frmAmElectronics.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\download 8.jpg"));
		lblNewLabel_4.setBounds(0, 0, 371, 169);
		frmAmElectronics.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\avani (2).jpg"));
		lblNewLabel_5.setBounds(368, 0, 264, 169);
		frmAmElectronics.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\download (1).jpg"));
		lblNewLabel_6.setBounds(630, 0, 269, 169);
		frmAmElectronics.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\images.jpg"));
		lblNewLabel_7.setBounds(891, 0, 295, 169);
		frmAmElectronics.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\download5.jpg"));
		lblNewLabel_8.setBounds(1183, 0, 187, 169);
		frmAmElectronics.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\download0.jpg"));
		lblNewLabel_10.setBounds(1096, 311, 264, 176);
		frmAmElectronics.getContentPane().add(lblNewLabel_10);
		
		JSeparator s1 = new JSeparator();
		s1.setBounds(30, 386, 540, 2);
		frmAmElectronics.getContentPane().add(s1);
		
		JSeparator s2 = new JSeparator();
		s2.setBounds(24, 562, 555, 7);
		frmAmElectronics.getContentPane().add(s2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(560, 580, -12, 2);
		frmAmElectronics.getContentPane().add(separator_3);
		
		
		
		t2 = new JTextField();
		t2.setBounds(249, 515, 86, 20);
		frmAmElectronics.getContentPane().add(t2);
		t2.setColumns(10);
		
		JComboBox<String> c1 = new JComboBox<String>();
		c1.setToolTipText("select app no and name");
		c1.setBounds(249, 441, 86, 22);
		frmAmElectronics.getContentPane().add(c1);
		
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select aid,aname from app";
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
		c2.setToolTipText("select app no and name");
		c2.setBounds(249, 441, 86, 22);
		frmAmElectronics.getContentPane().add(c2);
		

		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select aid,aname from app";
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

	
		
		
		JButton b4 = new JButton("update");
		b4.setFont(new Font("Tahoma", Font.BOLD, 17));
		b4.setToolTipText("Update");
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
				String aname=String.valueOf(c1.getSelectedItem());
				String sub1=String.valueOf(aname.substring(0, 3));
				int aid = Integer.parseInt(sub1.trim());
			String query  = "update app set aname=? where aid="+aid;
			PreparedStatement stmt = conObject.prepareStatement(query);
			
			stmt.setString(1,t2.getText());
			
			
			
					
			
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
		b4.setBounds(48, 594, 109, 23);
		frmAmElectronics.getContentPane().add(b4);
		
		JButton b5 = new JButton("delete");
		b5.setFont(new Font("Tahoma", Font.BOLD, 17));
		b5.setToolTipText("delete");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
				if(resp == 0)
				{
				
			
				try
				{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				String supp=String.valueOf(c2.getSelectedItem());
			String query  = "delete * from  app  where aid="+Integer.parseInt(supp);
			PreparedStatement stmt = conObject.prepareStatement(query);
			
						
			int result = stmt.executeUpdate();
			if(result == 1)
			{
				JOptionPane.showMessageDialog(null, "Record deleted successfully!");
				t2.setText("");
				
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
		b5.setBounds(59, 594, 91, 23);
		frmAmElectronics.getContentPane().add(b5);
	
		
		
		
		
		
		JLabel l2 = new JLabel("Appliance Update Details");
		l2.setFont(new Font("Tahoma", Font.BOLD, 30));
		l2.setBounds(80, 308, 386, 37);
		frmAmElectronics.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("Appliace Delete Details");
		l3.setFont(new Font("Tahoma", Font.BOLD, 30));
		l3.setBounds(79, 311, 371, 31);
		frmAmElectronics.getContentPane().add(l3);
		
		
		
		JButton b7 = new JButton("Show");
		b7.setToolTipText("show the details");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
						//String supp=String.valueOf(comboBox.getSelectedItem());
						String aname=String.valueOf(c2.getSelectedItem());
						String sub1=String.valueOf(aname.substring(0, 2));
						int aid = Integer.parseInt(sub1.trim());
					//	JOptionPane.showMessageDialog(null, cno);
						String query  = "select aid,aname from app where aid=?" ;
						
					
						PreparedStatement stmt = conObject.prepareStatement(query);
						stmt.setInt(1, aid);
						ResultSet rs = stmt.executeQuery();								
					
				
					
				
					
					if(rs.next())
					{
						t2.setText(rs.getString(2));
						
					}	
					
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
				}
			
					
				
			
				
			
		});
		b7.setBounds(422, 441, 91, 23);
		frmAmElectronics.getContentPane().add(b7);
		JLabel lblNewLabel_3 = new JLabel("");
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select top 1 aid from app order by aid desc";
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
		
		JButton b6 = new JButton("show");
		b6.setToolTipText("show the details");
		b6.setBounds(422, 440, 91, 23);
		frmAmElectronics.getContentPane().add(b6);
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
						//String supp=String.valueOf(comboBox.getSelectedItem());
						String aname=String.valueOf(c1.getSelectedItem());
						String sub1=String.valueOf(aname.substring(0, 2));
						int aid = Integer.parseInt(sub1.trim());
					//	JOptionPane.showMessageDialog(null, cno);
						String query  = "select aid,aname from app where aid=?" ;
						
					
						PreparedStatement stmt = conObject.prepareStatement(query);
						stmt.setInt(1, aid);
						ResultSet rs = stmt.executeQuery();								
					
				
					
				
					
					if(rs.next())
					{
						t2.setText(rs.getString(2));
						
					}	
					
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
				}
				
				
				});
		
		l1.setVisible(false);
		l2.setVisible(false);
		l3.setVisible(false);
		l4.setVisible(false);
		l5.setVisible(false);
		t1.setVisible(false);
		t2.setVisible(false);
		b1.setVisible(false);
		b2.setVisible(false);
		b3.setVisible(false);
		b4.setVisible(false);
		b5.setVisible(false);
		c1.setVisible(false);
		b7.setVisible(false);
		c2.setVisible(false);
		b5.setVisible(false);
		b6.setVisible(false);
		s1.setVisible(false);
		s2.setVisible(false);
		
		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				l1.setVisible(true);
				l2.setVisible(false);
				l3.setVisible(false);
				l4.setVisible(true);
				l5.setVisible(true);
				t1.setVisible(true);
				t2.setVisible(true);
				b1.setVisible(true);
				b2.setVisible(false);
				b3.setVisible(true);
				b4.setVisible(false);
				b5.setVisible(false);
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
				c1.setVisible(true);
				t1.setVisible(false);
				t2.setVisible(true);
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(true);
				b4.setVisible(true);
				b5.setVisible(false);
				c2.setVisible(false);
				s1.setVisible(true);
				s2.setVisible(true);
				b6.setVisible(true);
				
			}	
		});
		
		r3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				l1.setVisible(false);
				l2.setVisible(false);
				l3.setVisible(true);
				l4.setVisible(true);
				l5.setVisible(true);
				c1.setVisible(false);
				t1.setVisible(false);
				t2.setVisible(true);
				b1.setVisible(false);
				b2.setVisible(false);
				b3.setVisible(true);
				b4.setVisible(false);
				b5.setVisible(true);
				c2.setVisible(true);
				s1.setVisible(true);
				s2.setVisible(true);
				b7.setVisible(true);
			}	
		});

	
	}
}

