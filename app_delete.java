import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class app_delete {

	public JFrame frmAmElectronics;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					app_delete window = new app_delete();
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
	public app_delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.setTitle("AM ELECTRONICS");
		frmAmElectronics.getContentPane().setBackground(new Color(51, 51, 153));
		frmAmElectronics.setBounds(100, 100, 1378, 894);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		
		JLabel lblApplianceDeleteDetails = new JLabel("Appliance Delete Details Form");
		lblApplianceDeleteDetails.setForeground(new Color(255, 255, 255));
		lblApplianceDeleteDetails.setFont(new Font("Cambria", Font.BOLD, 20));
		lblApplianceDeleteDetails.setBounds(87, 252, 308, 21);
		frmAmElectronics.getContentPane().add(lblApplianceDeleteDetails);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(171, 299, 314, 2);
		frmAmElectronics.getContentPane().add(separator);
		
		
		JLabel label_1 = new JLabel("Appliance No");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Cambria", Font.BOLD, 18));
		label_1.setBounds(54, 312, 147, 21);
		frmAmElectronics.getContentPane().add(label_1);
		

		JComboBox<String> c1 = new JComboBox<String>();
		c1.setBounds(280, 313, 138, 22);
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
		
		
		
		
		
		JButton button = new JButton("Show");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					String supp=String.valueOf(c1.getSelectedItem());
				
					String query  = "select * from app where aid="+Integer.parseInt(supp);
					PreparedStatement stmt = conObject.prepareStatement(query);
				
					ResultSet rs = stmt.executeQuery();
					
					
					while(rs.next())
					{
						
						t1.setText(rs.getString(2));
						
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
		button.setFont(new Font("Cambria", Font.BOLD, 18));
		button.setBounds(204, 418, 91, 37);
		frmAmElectronics.getContentPane().add(button);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(280, 345, 138, 20);
		frmAmElectronics.getContentPane().add(t1);
		
		JLabel label = new JLabel("Appliance Name");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Cambria", Font.BOLD, 18));
		label.setBounds(54, 349, 157, 29);
		frmAmElectronics.getContentPane().add(label);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(204, 376, 314, 2);
		frmAmElectronics.getContentPane().add(separator_1);
		

	
		
		
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
				if(resp == 0)
				{
				
			
				try
				{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				String supp=String.valueOf(c1.getSelectedItem());
			String query  = "delete * from  app  where aid="+Integer.parseInt(supp);
			PreparedStatement stmt = conObject.prepareStatement(query);
			
						
			int result = stmt.executeUpdate();
			if(result == 1)
			{
				JOptionPane.showMessageDialog(null, "Record deleted successfully!");
				t1.setText("");
				
				c1.removeItem(supp);
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
		btnDelete.setFont(new Font("Cambria", Font.BOLD, 18));
		btnDelete.setBounds(327, 389, 91, 37);
		frmAmElectronics.getContentPane().add(btnDelete);
		
		JButton button_2 = new JButton("Exit");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(resp == 0)
				{
					frmAmElectronics.setVisible(false);
					frmAmElectronics.dispose();
					
					MDI1 frame1 = new MDI1();
					frame1.frmAmEletronics.setVisible(true);
					
				}
				
				
			}
		});
		button_2.setFont(new Font("Cambria", Font.BOLD, 18));
		button_2.setBounds(515, 389, 91, 37);
		frmAmElectronics.getContentPane().add(button_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(51, 153, 255));
		lblNewLabel.setBackground(new Color(51, 153, 255));
		lblNewLabel.setBounds(0, 0, 1370, 753);
		frmAmElectronics.getContentPane().add(lblNewLabel);
	}

}
