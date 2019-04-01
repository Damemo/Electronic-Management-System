import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Panel;

public class brand_add {

	public JFrame frame;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					brand_add window = new brand_add();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public brand_add() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 51, 153));
		frame.setBounds(100, 100, 623, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(255, 204, 102));
		panel.setBounds(40, 49, 485, 252);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblBrandNo = new JLabel("Brand No");
		lblBrandNo.setBounds(32, 83, 92, 25);
		panel.add(lblBrandNo);
		lblBrandNo.setForeground(new Color(255, 255, 255));
		lblBrandNo.setFont(new Font("Cambria", Font.BOLD, 21));
		
		t1 = new JTextField();
		t1.setBounds(178, 89, 86, 20);
		panel.add(t1);
		t1.setColumns(10);
		
		JLabel lblBrandName = new JLabel("Brand Name");
		lblBrandName.setBounds(32, 121, 121, 25);
		panel.add(lblBrandName);
		lblBrandName.setForeground(new Color(255, 255, 255));
		lblBrandName.setFont(new Font("Cambria", Font.BOLD, 21));
		
		t2 = new JTextField();
		t2.setBounds(178, 127, 86, 20);
		panel.add(t2);
		t2.setColumns(10);
		
		JLabel lblBrandDetailsForm = new JLabel("Brand Details Form");
		lblBrandDetailsForm.setBounds(22, 36, 206, 28);
		panel.add(lblBrandDetailsForm);
		lblBrandDetailsForm.setForeground(new Color(255, 255, 255));
		lblBrandDetailsForm.setFont(new Font("Cambria", Font.BOLD, 23));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(233, 49, 0, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(238, 49, 0, 2);
		panel.add(separator_1);
		
		JButton button = new JButton("Save");
		button.setBounds(297, 66, 71, 31);
		panel.add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to add?");
				if(resp == 0)
				{
				
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
					String query  = "insert into  brand(bname) values (?)";
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
		button.setFont(new Font("Cambria", Font.BOLD, 17));
		
		JButton button_1 = new JButton("View");
		button_1.setBounds(297, 108, 73, 31);
		panel.add(button_1);
		button_1.setFont(new Font("Cambria", Font.BOLD, 17));
		
		JButton button_2 = new JButton("Exit");
		button_2.setBounds(303, 150, 65, 31);
		panel.add(button_2);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(resp == 0)
				{
					frame.setVisible(false);
					frame.dispose();
					
					MDI frame1 = new MDI();
					frame1.frame.setVisible(true);
					
				}
			}
				
				
				
			
		});
		button_2.setFont(new Font("Cambria", Font.BOLD, 17));
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select top 1 bid from brand order by bid desc";
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
}
