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
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class purchase2 {

	public JFrame frmAmElectronics;
	private JTextField t2;
	private JTextField t1;
	private JTextField t3;
	private JTextField t4;
	private JTextField t6;
	private JTextField t5;
	Double gst,ta;
	int qty1,qty2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					purchase2 window = new purchase2();
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
	public purchase2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.getContentPane().setBackground(new Color(51, 51, 153));
		frmAmElectronics.setTitle("AM  Electronics");
		frmAmElectronics.setBounds(100, 100, 1327, 895);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Finish");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(915, 465, 91, 23);
		frmAmElectronics.getContentPane().add(btnNewButton);
		
		JLabel lblPurchaseId = new JLabel("Sales Id");
		lblPurchaseId.setBackground(Color.WHITE);
		lblPurchaseId.setBounds(466, 155, 345, 21);
		frmAmElectronics.getContentPane().add(lblPurchaseId);
		lblPurchaseId.setForeground(Color.BLACK);
		lblPurchaseId.setFont(new Font("Cambria", Font.PLAIN, 17));
		
		JLabel lblBrandId = new JLabel("Quantity");
		lblBrandId.setBackground(Color.WHITE);
		lblBrandId.setBounds(466, 314, 125, 20);
		frmAmElectronics.getContentPane().add(lblBrandId);
		lblBrandId.setForeground(Color.BLACK);
		lblBrandId.setFont(new Font("Cambria", Font.PLAIN, 17));
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBackground(Color.WHITE);
		lblPrice.setBounds(466, 345, 115, 14);
		frmAmElectronics.getContentPane().add(lblPrice);
		lblPrice.setForeground(Color.BLACK);
		lblPrice.setFont(new Font("Cambria", Font.PLAIN, 17));
		
		JLabel lblGst = new JLabel("GST (15%)");
		lblGst.setBackground(Color.WHITE);
		lblGst.setBounds(466, 376, 125, 26);
		frmAmElectronics.getContentPane().add(lblGst);
		lblGst.setForeground(Color.BLACK);
		lblGst.setFont(new Font("Cambria", Font.PLAIN, 17));
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setBackground(Color.WHITE);
		lblTotalAmount.setBounds(466, 413, 125, 14);
		frmAmElectronics.getContentPane().add(lblTotalAmount);
		lblTotalAmount.setForeground(Color.BLACK);
		lblTotalAmount.setFont(new Font("Cambria", Font.PLAIN, 17));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(483, 150, 314, 2);
		frmAmElectronics.getContentPane().add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(497, 438, 270, 2);
		frmAmElectronics.getContentPane().add(separator_2);
		
		t1 = new JTextField();
		t1.setBounds(612, 156, 138, 20);
		frmAmElectronics.getContentPane().add(t1);
		t1.setColumns(10);
		
		
		
		t2 = new JTextField();
		t2.setBounds(612, 182, 138, 20);
		frmAmElectronics.getContentPane().add(t2);
		t2.setColumns(10);
		
		JDateChooser d1 = new JDateChooser();
		d1.setBounds(612, 213, 138, 20);
		frmAmElectronics.getContentPane().add(d1);
		d1.setDateFormatString("dd-MMM-yyyy");
		
		JComboBox<String> c1 = new JComboBox<String>();
		c1.setBounds(612, 241, 138, 22);
		frmAmElectronics.getContentPane().add(c1);
		
		JComboBox<String> c2 = new JComboBox<String>();
		c2.setBounds(612, 284, 138, 22);
		frmAmElectronics.getContentPane().add(c2);
		
		try {
			
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");	
			String query="select qty,sprice from Actual_product where modelname=?";
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
		
		t3 = new JTextField();
		t3.setBounds(612, 318, 138, 20);
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
		t4.setEditable(false);
		t4.setEnabled(false);
		t4.setBounds(612, 349, 138, 20);
		frmAmElectronics.getContentPane().add(t4);
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
		
		t5 = new JTextField();
		t5.setBounds(612, 380, 138, 20);
		frmAmElectronics.getContentPane().add(t5);
		t5.setColumns(10);
		
		t6 = new JTextField();
		t6.setEditable(false);
		t6.setBounds(612, 411, 138, 20);
		frmAmElectronics.getContentPane().add(t6);
		t6.setEnabled(false);
		t6.setColumns(10);
		
JButton b2 = new JButton("Next Product");
JButton b1 = new JButton("Save");
b1.setBounds(443, 464, 108, 23);
frmAmElectronics.getContentPane().add(b1);
		
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			
			{
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				//c2.setText("");
				b2.setEnabled(false);
				b1.setEnabled(true);
				
			}
		});
		b2.setBounds(582, 464, 147, 23);
		frmAmElectronics.getContentPane().add(b2);
		b2.setFont(new Font("Cambria", Font.BOLD, 14));
		b2.setEnabled(false);
		
		
		frmAmElectronics.getContentPane().add(b1);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				try {
					
					 qty1=Integer.parseInt(t3.getText());
					if(qty2<qty1)
							JOptionPane.showMessageDialog(null, "Quantity not available");
					else
					{
						
						
						 ta=  (Double.parseDouble(t4.getText()) + gst ) * Integer.parseInt(t3.getText());
						  t6.setText(String.valueOf(ta));
						  
									Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
										Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
									
									String query  = "insert into sales(sales_id,invoice_no,sdate,customername,pname,qty,price,gst,total_amount,orderstatus) values (?,?,?,?,?,?,?,?,?,?)";
									PreparedStatement stmt = conObject.prepareStatement(query);
									
									stmt.setInt(1,Integer.parseInt(t1.getText()));
								stmt.setString(2,t2.getText());					
							    
									
																	
							    	stmt.setString(3,"20/4/2017");		
									
									
									//stmt.setString(4,c2.getText());
									
									
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
										JOptionPane.showMessageDialog(null, "sales order recorded successfully!Click On next Product or Finish");
										b1.setEnabled(false);
										b2.setEnabled(true);
									}
										
									else
										JOptionPane.showMessageDialog(null,"Insert Error!");
									stmt.close();
									conObject.close();
									
									}
				}
									catch(Exception e1)
									{
										JOptionPane.showMessageDialog(null, e1);
									}
									
					
				}
				
		});
		
			
		

		b1.setFont(new Font("Cambria", Font.BOLD, 14));
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, -94, 39);
		frmAmElectronics.getContentPane().add(textArea);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(490, 274, 314, 2);
		frmAmElectronics.getContentPane().add(separator);
		
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
		btnExit.setBounds(768, 464, 108, 23);
		frmAmElectronics.getContentPane().add(btnExit);
		btnExit.setFont(new Font("Cambria", Font.BOLD, 14));
		
		JLabel lblProdcutDetailsForm = new JLabel("Sales");
		lblProdcutDetailsForm.setBackground(Color.WHITE);
		lblProdcutDetailsForm.setBounds(529, 118, 200, 21);
		frmAmElectronics.getContentPane().add(lblProdcutDetailsForm);
		lblProdcutDetailsForm.setForeground(Color.BLACK);
		lblProdcutDetailsForm.setFont(new Font("Cambria", Font.BOLD, 22));
		
		JLabel lblProductNo = new JLabel("Invoice No");
		lblProductNo.setBackground(Color.WHITE);
		lblProductNo.setBounds(466, 181, 125, 21);
		frmAmElectronics.getContentPane().add(lblProductNo);
		lblProductNo.setForeground(Color.BLACK);
		lblProductNo.setFont(new Font("Cambria", Font.PLAIN, 17));
		
		JLabel lblProductName = new JLabel("Date");
		lblProductName.setBackground(Color.WHITE);
		lblProductName.setBounds(466, 213, 115, 14);
		frmAmElectronics.getContentPane().add(lblProductName);
		lblProductName.setForeground(Color.BLACK);
		lblProductName.setFont(new Font("Cambria", Font.PLAIN, 17));
		
		JLabel lblSupplierName = new JLabel("Supplier Name");
		lblSupplierName.setBackground(Color.WHITE);
		lblSupplierName.setBounds(466, 241, 125, 22);
		frmAmElectronics.getContentPane().add(lblSupplierName);
		lblSupplierName.setForeground(Color.BLACK);
		lblSupplierName.setFont(new Font("Cambria", Font.PLAIN, 17));
		
		JLabel lblBrandNsme = new JLabel("Product Name");
		lblBrandNsme.setBackground(Color.WHITE);
		lblBrandNsme.setBounds(466, 281, 129, 22);
		frmAmElectronics.getContentPane().add(lblBrandNsme);
		lblBrandNsme.setForeground(Color.BLACK);
		lblBrandNsme.setFont(new Font("Cambria", Font.PLAIN, 17));
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Cambria", Font.PLAIN, 17));
		label.setForeground(Color.BLACK);
		label.setBackground(Color.WHITE);
		label.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\business-2991747__340.jpg"));
		label.setBounds(0, 0, 1399, 753);
		frmAmElectronics.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(915, 466, 43, 21);
		frmAmElectronics.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select  top 1  sales_id from sales order by sales_id desc";
			ResultSet rs = stmt.executeQuery(query);		
			
			if(!rs.next())
				t1.setText(String.valueOf(1));
			else
			{
				t1.setText(String.valueOf(rs.getInt(1)+1));
				//JOptionPane.showMessageDialog(null, String.valueOf(rs.getInt(1)));
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

