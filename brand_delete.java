
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
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

public class brand_delete {

	public JFrame frmAmElectronics;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					brand_delete window = new brand_delete();
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
	public brand_delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.setTitle("AM ELECTRONICS");
		frmAmElectronics.getContentPane().setBackground(new Color(51, 51, 153));
		frmAmElectronics.setBounds(100, 100, 628, 463);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		
		
		
		JLabel lblBrandDetailsDelete = new JLabel("Brand Details Delete Form");
		lblBrandDetailsDelete.setForeground(new Color(255, 255, 255));
		lblBrandDetailsDelete.setFont(new Font("Cambria", Font.BOLD, 22));
		lblBrandDetailsDelete.setBounds(154, 23, 285, 21);
		frmAmElectronics.getContentPane().add(lblBrandDetailsDelete);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(51, 63, 314, 2);
		frmAmElectronics.getContentPane().add(separator);
		
		JLabel label_1 = new JLabel("Brand No");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Cambria", Font.BOLD, 17));
		label_1.setBounds(61, 67, 82, 35);
		frmAmElectronics.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Brand Name");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Cambria", Font.BOLD, 17));
		label_2.setBounds(46, 120, 97, 35);
		frmAmElectronics.getContentPane().add(label_2);
		
		t1 = new JTextField();
		t1.setColumns(10);
		t1.setBounds(172, 128, 138, 20);
		frmAmElectronics.getContentPane().add(t1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(51, 164, 314, 2);
		frmAmElectronics.getContentPane().add(separator_1);
		
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(resp == 0)
				{
				 frmAmElectronics.setVisible(false);
					frmAmElectronics.dispose();
					
					
					
				}
			}
				
				
				
			
		});
		button.setFont(new Font("Cambria", Font.BOLD, 17));
		button.setBounds(422, 205, 91, 35);
		frmAmElectronics.getContentPane().add(button);
		
		JComboBox c1 = new JComboBox<String>();
		c1.setBounds(172, 76, 138, 22);
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
		
		
		
		
		
		
		JButton button_1 = new JButton("Show");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					String supp=String.valueOf(c1.getSelectedItem());
				
					String query  = "select * from brand where bid="+Integer.parseInt(supp);
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
		button_1.setFont(new Font("Cambria", Font.BOLD, 17));
		button_1.setBounds(422, 80, 91, 35);
		frmAmElectronics.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Delete");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
				if(resp == 0)
				{
				try
				{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				String supp=String.valueOf(c1.getSelectedItem());
			String query  = "delete * from  brand  where bid="+Integer.parseInt(supp);
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
		button_2.setFont(new Font("Cambria", Font.BOLD, 17));
		button_2.setBounds(422, 139, 91, 40);
		frmAmElectronics.getContentPane().add(button_2);
	}

}
