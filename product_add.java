import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class product_add {

	public JFrame frmAmElectronics;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					product_add window = new product_add();
					window.frmAmElectronics.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public product_add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.setTitle("AM ELECTRONICS");
		frmAmElectronics.setBounds(100, 100, 1384, 780);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		
		JLabel t1 = new JLabel("");
		t1.setForeground(Color.WHITE);
		t1.setBounds(717, 213, 138, 14);
		frmAmElectronics.getContentPane().add(t1);
		
		JLabel l1 = new JLabel("Product Details Form");
		l1.setBounds(589, 132, 313, 39);
		frmAmElectronics.getContentPane().add(l1);
		l1.setForeground(new Color(255, 255, 255));
		l1.setFont(new Font("Cambria", Font.BOLD, 30));
		
		JLabel l7 = new JLabel("Brand Name");
		l7.setBounds(565, 337, 116, 20);
		frmAmElectronics.getContentPane().add(l7);
		l7.setForeground(new Color(255, 255, 255));
		l7.setFont(new Font("Cambria", Font.BOLD, 17));
		
		JLabel l6 = new JLabel("Appliance Name");
		l6.setBounds(565, 294, 128, 21);
		frmAmElectronics.getContentPane().add(l6);
		l6.setForeground(new Color(255, 255, 255));
		l6.setFont(new Font("Cambria", Font.BOLD, 17));
		
		JLabel l5 = new JLabel("Product Name");
		l5.setBounds(565, 250, 116, 23);
		frmAmElectronics.getContentPane().add(l5);
		l5.setForeground(new Color(255, 255, 255));
		l5.setFont(new Font("Cambria", Font.BOLD, 17));
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, -94, 39);
		frmAmElectronics.getContentPane().add(textArea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(555, 182, 366, 2);
		frmAmElectronics.getContentPane().add(separator);
		
		JComboBox<String>c1 = new JComboBox<String>();
		c1.setBounds(717, 296, 138, 22);
		frmAmElectronics.getContentPane().add(c1);
		
		JComboBox<String> c2 = new JComboBox<String>();
		c2.setBounds(717, 339, 138, 22);
		frmAmElectronics.getContentPane().add(c2);
		
		JButton b1 = new JButton("Save");
		b1.setBounds(544, 409, 108, 39);
		frmAmElectronics.getContentPane().add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to add?");
				if(resp == 0)
				{
				try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
					String query  = "insert into Actual_product(modelname,aname,bname) values (?,?,?)";
					PreparedStatement stmt = conObject.prepareStatement(query);
					
					
					stmt.setString(2,String.valueOf(c1.getSelectedItem()));
					stmt.setString(3,String.valueOf(c2.getSelectedItem()));
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
		
			
		

		b1.setFont(new Font("Cambria", Font.BOLD, 14));
		
		JButton b2 = new JButton("View");
		b2.setBounds(681, 410, 108, 37);
		frmAmElectronics.getContentPane().add(b2);
		b2.setFont(new Font("Cambria", Font.BOLD, 14));
		
		JButton b3 = new JButton("Exit");
		b3.setBounds(813, 409, 108, 39);
		frmAmElectronics.getContentPane().add(b3);
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
		b3.setFont(new Font("Cambria", Font.BOLD, 14));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(522, 385, 399, 2);
		frmAmElectronics.getContentPane().add(separator_1);
		
		t2 = new JTextField();
		t2.setBounds(717, 250, 138, 20);
		frmAmElectronics.getContentPane().add(t2);
		t2.setColumns(10);
		
		JLabel l4 = new JLabel("Product No");
		l4.setBounds(565, 207, 99, 21);
		frmAmElectronics.getContentPane().add(l4);
		l4.setForeground(new Color(255, 255, 255));
		l4.setFont(new Font("Cambria", Font.BOLD, 17));
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\background-2426328__340.jpg"));
		label.setBounds(0, 0, 1370, 753);
		frmAmElectronics.getContentPane().add(label);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select bname from brand";
			ResultSet rs = stmt.executeQuery(query);		
			while(rs.next())
			{
				c2.addItem(rs.getString(1));
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
		String query  = "Select top 1 pid from Actual_product order by pid desc";
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
	
	
	try {
		Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
		Statement stmt = conObject.createStatement();
		String query  = "Select aname from app";
		ResultSet rs = stmt.executeQuery(query);		
		while(rs.next())
		{
			c1.addItem(rs.getString(1));
		}
		
		stmt.close();
		conObject.close();
		}
		catch(Exception e1)
		{
			JOptionPane.showMessageDialog(null, e1);
		}
	
	
	
	}
}

