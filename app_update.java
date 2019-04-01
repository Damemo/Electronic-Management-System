 import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class app_update {

	public JFrame frmAmElectronics;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app_update window = new app_update();
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
	public app_update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.setTitle("AM ELECTRONICS");
		frmAmElectronics.getContentPane().setBackground(new Color(51, 51, 153));
		frmAmElectronics.setBounds(100, 100, 1435, 705);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(231, 142, 138, 20);
		frmAmElectronics.getContentPane().add(t1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(78, 185, 314, 2);
		frmAmElectronics.getContentPane().add(separator);
		
		JComboBox<String> c1 = new JComboBox<String>();
		c1.setBounds(231, 110, 138, 22);
		frmAmElectronics.getContentPane().add(c1);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select aid from app";
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
			String query  = "update app set aname=? where aid="+Integer.parseInt(supp);
			PreparedStatement stmt = conObject.prepareStatement(query);
			
			stmt.setString(1,t1.getText());
			
			
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
		btnUpdate.setFont(new Font("Cambria", Font.BOLD, 15));
		btnUpdate.setBounds(84, 215, 91, 23);
		frmAmElectronics.getContentPane().add(btnUpdate);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					String supp=String.valueOf(c1.getSelectedItem());
				
					String query  = "select * from app where aid="+Integer.parseInt(supp);
					PreparedStatement stmt = conObject.prepareStatement(query);
				
					ResultSet rs = stmt.executeQuery();
				
					
					if(rs.next())
					{
						t1.setText(rs.getString(2));
						
					}	
					
					}
					catch(Exception e1)
					{
						JOptionPane.showMessageDialog(null, e1);
					}
				
				
				
				
				
			}
		});
		btnShow.setFont(new Font("Cambria", Font.BOLD, 15));
		btnShow.setBounds(400, 110, 91, 23);
		frmAmElectronics.getContentPane().add(btnShow);
		
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
		button_2.setFont(new Font("Cambria", Font.BOLD, 15));
		button_2.setBounds(301, 215, 91, 23);
		frmAmElectronics.getContentPane().add(button_2);
		
		JLabel lblApplianceUpdateDetails = new JLabel("Appliance Update Details Form");
		lblApplianceUpdateDetails.setForeground(new Color(255, 255, 255));
		lblApplianceUpdateDetails.setFont(new Font("Cambria", Font.BOLD, 17));
		lblApplianceUpdateDetails.setBounds(180, 40, 257, 21);
		frmAmElectronics.getContentPane().add(lblApplianceUpdateDetails);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(84, 82, 314, 2);
		frmAmElectronics.getContentPane().add(separator_1);
		
		JLabel label_1 = new JLabel("Appliance No");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Cambria", Font.BOLD, 15));
		label_1.setBounds(78, 111, 97, 21);
		frmAmElectronics.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Appliance Name");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Cambria", Font.BOLD, 15));
		label_2.setBounds(78, 145, 118, 14);
		frmAmElectronics.getContentPane().add(label_2);
		
		
	}

}
