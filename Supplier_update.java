import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.border.BevelBorder;

import org.eclipse.birt.report.designer.ui.dialogs.SelectParameterDefaultValueDialog;

import java.awt.Color;
import javax.swing.ImageIcon;

public class Supplier_update  {

	/**
	 * 
	 */
	public JFrame frmAmElectronics;
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
					Supplier_update frame = new Supplier_update();
					frame.frmAmElectronics.setVisible(true);;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Supplier_update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 858);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 153));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Cambria", Font.PLAIN, 22));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\background-3089930__340.jpg"));
		lblNewLabel.setBounds(0, -11, 1380, 764);
		contentPane.add(lblNewLabel);
		
		JLabel lblSupplierNo = new JLabel("Supplier No");
		lblSupplierNo.setForeground(Color.WHITE);
		lblSupplierNo.setFont(new Font("Cambria", Font.PLAIN, 22));
		lblSupplierNo.setBounds(544, 216, 129, 39);
		contentPane.add(lblSupplierNo);
		
		JLabel lblSupplierDetailsForm = new JLabel("Supplier Details Update Form");
		lblSupplierDetailsForm.setForeground(Color.WHITE);
		lblSupplierDetailsForm.setFont(new Font("Cambria", Font.BOLD, 25));
		lblSupplierDetailsForm.setBounds(534, 149, 348, 47);
		contentPane.add(lblSupplierDetailsForm);
		
		JLabel lblSupplierAddress = new JLabel("Address");
		lblSupplierAddress.setForeground(Color.WHITE);
		lblSupplierAddress.setFont(new Font("Cambria", Font.PLAIN, 22));
		lblSupplierAddress.setBounds(544, 308, 82, 31);
		contentPane.add(lblSupplierAddress);
		
		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Cambria", Font.PLAIN, 22));
		lblName.setBounds(544, 266, 91, 31);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Cambria", Font.PLAIN, 22));
		lblEmail.setBounds(544, 430, 82, 31);
		contentPane.add(lblEmail);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setForeground(Color.WHITE);
		lblContactNo.setFont(new Font("Cambria", Font.PLAIN, 22));
		lblContactNo.setBounds(544, 389, 107, 20);
		contentPane.add(lblContactNo);
		
		t2 = new JTextField();
		t2.setBounds(674, 266, 138, 29);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(251, 112, -94, 39);
		contentPane.add(textArea);
		
		JTextArea t3 = new JTextArea();
		t3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, new Color(0, 0, 0), null));
		t3.setBounds(674, 306, 137, 63);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4 = new JTextField();
		//t4.addKeyListener(keyListener);
		t4.addKeyListener(new KeyAdapter() 
		{
	       
			private static final long serialVersionUID = 1L;

			/*public void keyTyped(KeyEvent e)
			{
	          char c = e.getKeyChar();
	          if (!((c >= '0') && (c <= '9') ||
	             (c == KeyEvent.VK_BACK_SPACE) ||
	             (c == KeyEvent.VK_DELETE))) {
	            getToolkit().beep();
	            t4.setToolTipText("Please enter numbers ONLY");
	            e.consume();
	          }
	        }*/

		
	      });
		t4.setBounds(674, 389, 137, 24);
		contentPane.add(t4);
		t4.setColumns(10);
			
		t5 = new JTextField();
		t5.setBounds(674, 429, 138, 20);
		contentPane.add(t5);
		t5.setColumns(10);
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(544, 494, 314, 2);
		contentPane.add(separator_1);
		
		
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(resp == 0)
				{
					frmAmElectronics.setVisible(false);
						frmAmElectronics.dispose();
					
				}
			
			}
		});
		btnExit.setFont(new Font("Cambria", Font.BOLD, 22));
		btnExit.setBounds(734, 514, 91, 34);
		contentPane.add(btnExit);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(674, 228, 91, 22);
		contentPane.add(comboBox);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select sno from supplier";
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
		btnView.setFont(new Font("Cambria", Font.BOLD, 22));
		btnView.setBounds(822, 216, 91, 39);
		contentPane.add(btnView);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Cambria", Font.BOLD, 22));
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
		btnUpdate.setBounds(560, 514, 113, 34);
		contentPane.add(btnUpdate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(534, 207, 314, 2);
		contentPane.add(separator);
		
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
						
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					String supp=String.valueOf(comboBox.getSelectedItem());
				
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
		
		}

	private void setContentPane(JPanel contentPane2) {
		// TODO Auto-generated method stub
		
	}

	private void setBounds(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

	
		
	}


