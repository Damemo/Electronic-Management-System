import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;

public class product_update {

	public JFrame frmAmElectronics;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					product_update window = new product_update();
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
	public product_update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.setTitle("AM ELECTRONICS");
		frmAmElectronics.getContentPane().setBackground(new Color(51, 51, 153));
		frmAmElectronics.setBounds(100, 100, 846, 487);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 153));
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 11, 655, 438);
		frmAmElectronics.getContentPane().add(panel);
		
		JLabel label = new JLabel("Product No");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Cambria", Font.BOLD, 13));
		label.setBounds(63, 55, 82, 21);
		panel.add(label);
		
		JLabel lblProductUpdateForm = new JLabel("Product Update Form");
		lblProductUpdateForm.setForeground(new Color(255, 255, 255));
		lblProductUpdateForm.setFont(new Font("Cambria", Font.BOLD, 15));
		lblProductUpdateForm.setBounds(189, 11, 168, 21);
		panel.add(lblProductUpdateForm);
		
		JComboBox<String> c1 = new JComboBox<String>();
		c1.setBounds(211, 55, 116, 22);
		panel.add(c1);
		
		JComboBox<String> c2 = new JComboBox<String>();
		c2.setBounds(211, 84, 116, 22);
		panel.add(c2);
		
		JComboBox<String> c3 = new JComboBox<String>();
		c3.setBounds(211, 157, 116, 22);
		panel.add(c3);
		
		JComboBox<String> c4 = new JComboBox<String>();
		c4.setBounds(211, 192, 116, 22);
		panel.add(c4);
		
		JLabel lblApplianceName = new JLabel("Appliance Name");
		lblApplianceName.setForeground(new Color(255, 255, 255));
		lblApplianceName.setFont(new Font("Cambria", Font.BOLD, 13));
		lblApplianceName.setBounds(63, 160, 116, 14);
		panel.add(lblApplianceName);
		
		
		JLabel label_5 = new JLabel("Brand Name");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setFont(new Font("Cambria", Font.BOLD, 13));
		label_5.setBounds(63, 195, 82, 14);
		panel.add(label_5);

		
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(251, 112, -94, 39);
		panel.add(textArea);
		

		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select pid from Actual_product";
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
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
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
			ResultSet rs = stmt.executeQuery(query);	
			
			c2.addItem(rs.getString(1));
			c3.addItem(rs.getString(2));
			c4.addItem(rs.getString(3));
			
			
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
		btnUpdate.setFont(new Font("Cambria", Font.BOLD, 14));
		btnUpdate.setBounds(63, 282, 108, 23);
		panel.add(btnUpdate);
		
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select aname from app";
			ResultSet rs = stmt.executeQuery(query);		
			while(rs.next())
			{
				c3.addItem(rs.getString(1));
			}
			
			stmt.close();
			conObject.close();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
		
		JButton button_2 = new JButton("Exit");
		button_2.addActionListener(new ActionListener() {
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
		button_2.setFont(new Font("Cambria", Font.BOLD, 14));
		button_2.setBounds(291, 282, 108, 23);
		panel.add(button_2);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select modelname from Actual_product";
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
		
		JSeparator separator = new JSeparator();
		separator.setBounds(63, 42, 393, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(63, 250, 405, 2);
		panel.add(separator_1);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setForeground(new Color(255, 255, 255));
		lblProductName.setFont(new Font("Cambria", Font.BOLD, 13));
		lblProductName.setBounds(63, 87, 116, 14);
		panel.add(lblProductName);
		
		
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					String supp=String.valueOf(c1.getSelectedItem());
				
					String query  = "select * from Actual_product where pid="+Integer.parseInt(supp);
					PreparedStatement stmt = conObject.prepareStatement(query);
				
					ResultSet rs = stmt.executeQuery();
				
					
					if(rs.next())
					{
						c2.addItem(rs.getString(1));
						c3.addItem(rs.getString(1));
						c4.addItem(rs.getString(1));
						
					}	
					
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
					
					
				}
				
				
				
				
				
				
				
				
			
		});
		btnShow.setFont(new Font("Cambria", Font.BOLD, 14));
		btnShow.setBounds(360, 55, 108, 23);
		panel.add(btnShow);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select bname from brand";
			ResultSet rs = stmt.executeQuery(query);		
			while(rs.next())
			{
				c4.addItem(rs.getString(1));
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
