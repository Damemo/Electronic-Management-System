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
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.ImageIcon;

public class sales {

	public JFrame frmAmElectronics;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;
	private JTextField t6;
	private JTextField t5;
	Double gst=(double) 0.00d, ta=(double) 0.00d;
	int qty1,qty2;
	private JTextField t1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sales window = new sales();
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
	public sales() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.getContentPane().setBackground(new Color(51, 51, 153));
		frmAmElectronics.setTitle("AM  Electronics");
		frmAmElectronics.setBounds(100, 100, 1217, 780);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		JButton b2 = new JButton("Next Product");
		
		
		
		
		JButton btnExit = new JButton("Finish");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to proceed to payment?");
				if(resp == 0)
				{
					frmAmElectronics.setVisible(false);
					frmAmElectronics.dispose();
					
					sales_bill1 frame1 = new sales_bill1(Integer.parseInt(t1.getText()));
					frame1.frmAmElectronics.setVisible(true);
					
				}
			}
				
				
			
		});
		
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
		
		JComboBox<String> c1 = new JComboBox<String>();
		c1.setBounds(568, 177, 140, 22);
		frmAmElectronics.getContentPane().add(c1);
		
		t1 = new JTextField();
		t1.setBounds(568, 84, 86, 20);
		frmAmElectronics.getContentPane().add(t1);
		t1.setColumns(10);
		button.setFont(new Font("Cambria", Font.BOLD, 18));
		button.setBounds(762, 382, 110, 31);
		frmAmElectronics.getContentPane().add(button);
		btnExit.setBounds(600, 382, 108, 31);
		frmAmElectronics.getContentPane().add(btnExit);
		btnExit.setFont(new Font("Cambria", Font.BOLD, 14));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(424, 69, 314, 2);
		frmAmElectronics.getContentPane().add(separator_1);
		b2.setBounds(421, 382, 147, 31);
		frmAmElectronics.getContentPane().add(b2);
		b2.setFont(new Font("Cambria", Font.BOLD, 14));
		
		JLabel lblProdcutDetailsForm = new JLabel("Sales");
		lblProdcutDetailsForm.setBounds(570, 37, 116, 21);
		frmAmElectronics.getContentPane().add(lblProdcutDetailsForm);
		lblProdcutDetailsForm.setForeground(Color.BLACK);
		lblProdcutDetailsForm.setFont(new Font("Cambria", Font.BOLD, 15));
		
		JComboBox<String> c2 = new JComboBox<String>();
		c2.setBounds(570, 217, 138, 22);
		frmAmElectronics.getContentPane().add(c2);
		
		c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try {
					
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");	
				String query="select qty,sprice from actual_product where modelname=?";
				PreparedStatement stmt1 = conObject.prepareStatement(query);
				String pname=String.valueOf(c2.getSelectedItem());
				JOptionPane.showMessageDialog(null, pname);
				stmt1.setString(1, pname);	
				ResultSet rs1 = stmt1.executeQuery();		
				
				
				while(rs1.next())
				{
					 qty2=rs1.getInt(1);
					
					
						t4.setText(String.valueOf(Math.round(rs1.getDouble(2))));		
						 gst=  (Double.parseDouble(t4.getText())* 0.15);
							t5.setText(String.valueOf(Math.round(gst)));
						  
							
					
				
				
			}}
				catch(Exception eee) {}
				}
});
		
		
		
		JButton b1 = new JButton("Save");
		b1.setBounds(280, 382, 108, 31);
		frmAmElectronics.getContentPane().add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
					String query  = "insert into sales(sales_id,invoice_no,sdate,customername,pname,qty,price,gst,total_amt,orderstatus) values (?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement stmt = conObject.prepareStatement(query);
					
					stmt.setInt(1,Integer.parseInt(t1.getText()));
				stmt.setString(2,t2.getText());					
			    
					
													
			    	stmt.setString(3,"20/4/2017");		
					
					String str1=String.valueOf(c1.getSelectedItem());
					stmt.setString(4,str1);
					
					
					String str2=String.valueOf(c2.getSelectedItem());
					stmt.setString(5,str2);
					
					stmt.setInt(6,Integer.parseInt(t3.getText()));
					stmt.setDouble(7,Double.parseDouble(t4.getText()));
					stmt.setDouble(8,gst);
					stmt.setDouble(9,ta);
				   stmt.setString(10, "New");
										
					int result = stmt.executeUpdate();
					if(result == 1)
					{
						JOptionPane.showMessageDialog(null, "sales order recorded successfully!");
						b1.setEnabled(false);
						b2.setEnabled(true);
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
				
		});
			
		

		b1.setFont(new Font("Cambria", Font.BOLD, 14));
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			
			{t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			b2.setEnabled(false);
			b1.setEnabled(true);
			c2.removeItem(c2.getSelectedItem());
				
			}
		});
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(433, 268, 82, 14);
		frmAmElectronics.getContentPane().add(lblPrice);
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Cambria", Font.BOLD, 15));
		
		JLabel lblGst = new JLabel("GST (15%)");
		lblGst.setBounds(433, 300, 82, 14);
		frmAmElectronics.getContentPane().add(lblGst);
		lblGst.setForeground(Color.BLACK);
		lblGst.setFont(new Font("Cambria", Font.BOLD, 15));
		
		JLabel lblBrandId = new JLabel("Quantity");
		lblBrandId.setBounds(433, 243, 82, 14);
		frmAmElectronics.getContentPane().add(lblBrandId);
		lblBrandId.setForeground(Color.BLACK);
		lblBrandId.setFont(new Font("Cambria", Font.BOLD, 15));
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setBounds(433, 329, 100, 14);
		frmAmElectronics.getContentPane().add(lblTotalAmount);
		lblTotalAmount.setForeground(Color.BLACK);
		lblTotalAmount.setFont(new Font("Cambria", Font.BOLD, 15));
		
		JLabel lblBrandNsme = new JLabel("Product Name");
		lblBrandNsme.setBounds(433, 217, 116, 14);
		frmAmElectronics.getContentPane().add(lblBrandNsme);
		lblBrandNsme.setForeground(Color.BLACK);
		lblBrandNsme.setFont(new Font("Cambria", Font.BOLD, 15));
		
		
		t5 = new JTextField();
		t5.setBounds(570, 299, 138, 20);
		frmAmElectronics.getContentPane().add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setBounds(570, 330, 138, 20);
		frmAmElectronics.getContentPane().add(t6);
		t6.setEnabled(false);
		t6.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(570, 244, 138, 20);
		frmAmElectronics.getContentPane().add(t3);
		t3.setColumns(10);
		
		t3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				gst= (Double.parseDouble(t4.getText())* 0.15);
				t5.setText(String.valueOf(gst));
			  
				 ta= (Double.parseDouble(t4.getText()) + gst ) * Integer.parseInt(t3.getText());
				  t6.setText(String.valueOf(ta));
			}
});
		
		t4 = new JTextField();
		t4.setBounds(570, 267, 138, 20);
		frmAmElectronics.getContentPane().add(t4);
		t4.setEnabled(false);
		t4.setColumns(10);
		
		t4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				 gst=  (Double.parseDouble(t4.getText())* 0.15);
				t5.setText(String.valueOf(gst));
			  
				 ta=  (Double.parseDouble(t4.getText()) + gst ) * Integer.parseInt(t3.getText());
				  t6.setText(String.valueOf(ta));
			}
});
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(433, 205, 294, 2);
		frmAmElectronics.getContentPane().add(separator_2);
		
		
		JLabel lblSupplierName = new JLabel("Customer Name");
		lblSupplierName.setBounds(433, 178, 116, 16);
		frmAmElectronics.getContentPane().add(lblSupplierName);
		lblSupplierName.setForeground(Color.BLACK);
		lblSupplierName.setFont(new Font("Cambria", Font.BOLD, 15));
		
		JLabel lblProductName = new JLabel("Date");
		lblProductName.setBounds(433, 146, 100, 14);
		frmAmElectronics.getContentPane().add(lblProductName);
		lblProductName.setForeground(Color.BLACK);
		lblProductName.setFont(new Font("Cambria", Font.BOLD, 15));
		
		JLabel lblProductNo = new JLabel("Invoice No");
		lblProductNo.setBounds(433, 114, 82, 21);
		frmAmElectronics.getContentPane().add(lblProductNo);
		lblProductNo.setForeground(Color.BLACK);
		lblProductNo.setFont(new Font("Cambria", Font.BOLD, 15));
		
		JDateChooser d1 = new JDateChooser();
		d1.setBounds(570, 146, 138, 20);
		frmAmElectronics.getContentPane().add(d1);
		d1.setDateFormatString("dd-MMM-yyyy");
		
		JLabel lblPurchaseId = new JLabel("Sales Id");
		lblPurchaseId.setBounds(433, 82, 82, 21);
		frmAmElectronics.getContentPane().add(lblPurchaseId);
		lblPurchaseId.setForeground(Color.BLACK);
		lblPurchaseId.setFont(new Font("Cambria", Font.BOLD, 15));
		
		
		
		t2 = new JTextField();
		t2.setBounds(570, 115, 138, 20);
		frmAmElectronics.getContentPane().add(t2);
		t2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\dairy-1986532__340.jpg"));
		lblNewLabel.setBounds(0, 11, 1175, 757);
		frmAmElectronics.getContentPane().add(lblNewLabel);
		
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select  top 1  sales_id from sales order by sales_id desc";
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
			String query  = "Select cno,cname from Customer_add";
			ResultSet rs = stmt.executeQuery(query);		
			while(rs.next())
			{
				c1.addItem(rs.getString(2));
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
		String query  = "Select modelname from actual_product";
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
	
	
	}
}

