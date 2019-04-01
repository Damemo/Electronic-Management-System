import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class brand_update {

	public JFrame frmAmElectronics;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					brand_update window = new brand_update();
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
	public brand_update() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("rawtypes")
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.setTitle("AM ELECTRONICS");
		frmAmElectronics.getContentPane().setBackground(new Color(51, 51, 153));
		frmAmElectronics.setBounds(100, 100, 818, 492);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		
		JLabel lblBrandDetailsUpdate = new JLabel("Brand Details Update Form");
		lblBrandDetailsUpdate.setForeground(new Color(255, 255, 255));
		lblBrandDetailsUpdate.setFont(new Font("Cambria", Font.BOLD, 22));
		lblBrandDetailsUpdate.setBounds(176, 27, 294, 35);
		frmAmElectronics.getContentPane().add(lblBrandDetailsUpdate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(77, 83, 314, 2);
		frmAmElectronics.getContentPane().add(separator);
		
		JLabel label_1 = new JLabel("Brand No");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Cambria", Font.BOLD, 20));
		label_1.setBounds(93, 111, 120, 21);
		frmAmElectronics.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Brand Name");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Cambria", Font.BOLD, 20));
		label_2.setBounds(93, 154, 120, 14);
		frmAmElectronics.getContentPane().add(label_2);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(223, 154, 138, 20);
		frmAmElectronics.getContentPane().add(t1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(77, 197, 314, 2);
		frmAmElectronics.getContentPane().add(separator_1);
		
		
		
		
		JComboBox c1 = new JComboBox<String>();
		c1.setBounds(223, 113, 138, 22);
		frmAmElectronics.getContentPane().add(c1);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select bid from brand";
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
			String query  = "update brand set bname=? where bid="+Integer.parseInt(supp);
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
		btnUpdate.setFont(new Font("Cambria", Font.BOLD, 18));
		btnUpdate.setBounds(452, 164, 110, 35);
		frmAmElectronics.getContentPane().add(btnUpdate);
		
		JButton button_2 = new JButton("Exit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(resp == 0)
				{
					frmAmElectronics.setVisible(false);
					frmAmElectronics.dispose();
					
				
					
				}
			}
				
				
				
			
		});
		button_2.setFont(new Font("Cambria", Font.BOLD, 18));
		button_2.setBounds(452, 220, 110, 35);
		frmAmElectronics.getContentPane().add(button_2);
		
		
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					String supp=String.valueOf(c1.getSelectedItem());
				
					String query  = "select * from brand where bid="+Integer.parseInt(supp);
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
		btnShow.setFont(new Font("Cambria", Font.BOLD, 18));
		btnShow.setBounds(452, 110, 110, 35);
		frmAmElectronics.getContentPane().add(btnShow);
	}
}
