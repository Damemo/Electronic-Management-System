import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ImageIcon;

public class staff_update extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t2;
	private JTextField t4;
	private JTextField t5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staff_update frame = new staff_update();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public staff_update() {
		setTitle("AM ELECTRONICS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1437, 780);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 153));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSupplierNo = new JLabel("Staff No");
		lblSupplierNo.setForeground(new Color(255, 255, 255));
		lblSupplierNo.setFont(new Font("Cambria", Font.BOLD, 15));
		lblSupplierNo.setBounds(63, 55, 82, 21);
		contentPane.add(lblSupplierNo);
		
		JLabel lblSupplierDetailsForm = new JLabel("Staff Details Update Form");
		lblSupplierDetailsForm.setForeground(new Color(255, 255, 255));
		lblSupplierDetailsForm.setFont(new Font("Cambria", Font.BOLD, 17));
		lblSupplierDetailsForm.setBounds(189, 11, 238, 21);
		contentPane.add(lblSupplierDetailsForm);
		
		JLabel lblSupplierAddress = new JLabel("Address");
		lblSupplierAddress.setForeground(new Color(255, 255, 255));
		lblSupplierAddress.setFont(new Font("Cambria", Font.BOLD, 15));
		lblSupplierAddress.setBounds(63, 124, 82, 14);
		contentPane.add(lblSupplierAddress);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(255, 255, 255));
		lblName.setFont(new Font("Cambria", Font.BOLD, 15));
		lblName.setBounds(63, 87, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Cambria", Font.BOLD, 15));
		lblEmail.setBounds(63, 227, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setForeground(new Color(255, 255, 255));
		lblContactNo.setFont(new Font("Cambria", Font.BOLD, 15));
		lblContactNo.setBounds(63, 196, 82, 14);
		contentPane.add(lblContactNo);
		
		t2 = new JTextField();
		t2.setBounds(155, 84, 138, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(251, 112, -94, 39);
		contentPane.add(textArea);
		
		JTextArea t3 = new JTextArea();
		t3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		t3.setBounds(155, 120, 137, 63);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setBounds(155, 193, 137, 20);
		contentPane.add(t4);
		t4.setColumns(10);
			
		t5 = new JTextField();
		t5.setBounds(154, 224, 138, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(63, 255, 314, 2);
		contentPane.add(separator_1);
		
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
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
		btnExit.setFont(new Font("Cambria", Font.BOLD, 15));
		btnExit.setBounds(336, 278, 91, 23);
		contentPane.add(btnExit);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(155, 54, 91, 22);
		contentPane.add(comboBox);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select sno from staff";
			ResultSet rs = stmt.executeQuery(query);		
			while(rs.next())
			{
				comboBox.addItem(rs.getString(1));
			}
			
			stmt.close();
			conObject.close();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
		
		JButton btnView = new JButton("Show");
		btnView.setFont(new Font("Cambria", Font.BOLD, 15));
		btnView.setBounds(272, 54, 91, 23);
		contentPane.add(btnView);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Cambria", Font.BOLD, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to update?");
				if(resp == 0)
				{
				try
				{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				String supp=String.valueOf(comboBox.getSelectedItem());
			String query  = "update staff set sname=?,saddr=?,scon=?,semail=? where sno="+Integer.parseInt(supp);
			PreparedStatement stmt = conObject.prepareStatement(query);
			
			stmt.setString(2,t2.getText());
			stmt.setString(3,t3.getText());
			stmt.setInt(4,Integer.parseInt(t4.getText()));
			stmt.setString(5,t5.getText());
			
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
		btnUpdate.setBounds(97, 278, 91, 23);
		contentPane.add(btnUpdate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(75, 42, 314, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\BIG.jpg"));
		lblNewLabel.setBounds(0, 0, 1412, 753);
		contentPane.add(lblNewLabel);
		
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
						//String supp=String.valueOf(comboBox.getSelectedItem());
						String sname=String.valueOf(comboBox.getSelectedItem());
						String sub1=String.valueOf(sname.substring(0, 3));
						int sno = Integer.parseInt(sub1.trim());
					//	JOptionPane.showMessageDialog(null, cno);
						String query  = "select sno,sname from staff where sno=?" ;
						
					
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
		
		}
}

