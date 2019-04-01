import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class sales_bill1 {

	public JFrame frmAmElectronics;
	private JTextField chno;
	private JTextField c1;
	private JTextField c2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	/**
	 * @wbp.nonvisual location=63,71
	 */
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int i=0;
					sales_bill1 window = new sales_bill1(i);
					window.frmAmElectronics.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
		});
	}

	/**
	 * Create the application.
	 * @param i 
	 */
	public sales_bill1(int i) 
	{
		JOptionPane.showMessageDialog(null, i);
		i=4;
		initialize(i);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int i) {
		frmAmElectronics = new JFrame();
		frmAmElectronics.setTitle("AM ELECTRONICS");
		frmAmElectronics.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\stuff\\img1.jpg"));
		frmAmElectronics.setBounds(100, 100, 849, 672);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		
		
		
		JRadioButton p1 = new JRadioButton("Cash");
		buttonGroup.add(p1);
		p1.setBounds(65, 261, 109, 23);
		frmAmElectronics.getContentPane().add(p1);
		
		JRadioButton p2 = new JRadioButton("Cheque");
		buttonGroup.add(p2);
		p2.setBounds(65, 287, 109, 23);
		frmAmElectronics.getContentPane().add(p2);
		
		chno = new JTextField();
		chno.setText("Enter cheque No");
		chno.setVisible(false);
		chno.setBounds(183, 288, 137, 20);
		frmAmElectronics.getContentPane().add(chno);
		chno.setColumns(10);
		
		JRadioButton p3 = new JRadioButton("Card Payment");
		buttonGroup.add(p3);
		p3.setBounds(65, 318, 109, 23);
		frmAmElectronics.getContentPane().add(p3);
		
		c1 = new JTextField();
		c1.setColumns(10);
		c1.setBounds(183, 319, 137, 20);
		frmAmElectronics.getContentPane().add(c1);
		
		c2 = new JTextField();
		c2.setColumns(10);
		c2.setBounds(183, 350, 137, 20);
		frmAmElectronics.getContentPane().add(c2);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(185, 7, 111, 22);
		frmAmElectronics.getContentPane().add(comboBox);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select  distinct sales_id from sales where orderstatus='new'";
			ResultSet rs = stmt.executeQuery(query);		
			
			while(rs.next())
				comboBox.addItem(String.valueOf(rs.getInt(1)));
			
			
			stmt.close();
			conObject.close();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
		
		JComboBox<String> c3 = new JComboBox<String>();
		c3.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		c3.setBounds(186, 381, 57, 22);
		frmAmElectronics.getContentPane().add(c3);
		
		JComboBox<String> c4 = new JComboBox<String>();
		c4.setModel(new DefaultComboBoxModel<String>(new String[] {"2018", "2019", "2020", "2021", "2022", "2023"}));
		c4.setBounds(253, 381, 57, 22);
		frmAmElectronics.getContentPane().add(c4);
		
	
		
		JButton btnNewButton = new JButton("Good Delivered");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				
				String query  = "Select  sales_id,invoice_no,sdate,customername,total_amt,pname,qty,price from sales where sales_id=?";
				
				PreparedStatement stmt = conObject.prepareStatement(query);
				stmt.setInt(1,i);
				ResultSet rs = stmt.executeQuery();		
				int totalamount=0;
				String sdate="";
				while(rs.next())
				{
					
					totalamount = totalamount + rs.getInt(5);
					sdate=rs.getString(2);
					
				}
				
				String query1  = "insert into sales_payment(sales_id,sales_date,amt,paymentmode,chno,cardno,cardname,validmonth,validyear) values (?,?,?,?,?,?,?,?,?)";
				PreparedStatement stmt1 = conObject.prepareStatement(query1);
				
				stmt1.setInt(1,i);
				stmt1.setString(2,sdate);		
				stmt1.setInt(3,totalamount);
		        if(p1.isSelected() == true)
		        {
		        	stmt1.setString(4,"cash");
		        	stmt1.setString(5,"");
		        	stmt1.setString(6,"");
		        	stmt1.setString(7,"");
		        	stmt1.setInt(8,0);
		        	stmt1.setInt(9,0);
		        }
		        if(p2.isSelected() == true)
		        {
		        	stmt1.setString(4,"cheque");
		        	stmt1.setString(5,chno.getText());
		        	stmt1.setString(6,"");
		        	stmt1.setString(7,"");
		        	stmt1.setInt(8,0);
		        	stmt1.setInt(9,0);
		        }
		        if(p3.isSelected() == true)
		        {
		        	stmt1.setString(4,"card");
		        	stmt1.setString(5,"");
		        	stmt1.setString(6,c1.getText());
		        	stmt1.setString(7,c1.getText());
		        	stmt1.setInt(8,(int) (c3.getSelectedItem()));
		        	stmt1.setInt(9,(int) (c4.getSelectedItem()));
		        }
							
		        int result = stmt1.executeUpdate();
				if(result == 1)
				{
					JOptionPane.showMessageDialog(null, "inserted in sales table");
					
					String str2;		
					int pqty;	
					query  = "Select  sales_id,sdate,customername,total_amt,pname,qty,price from sales where sales_id=?";
					 stmt = conObject.prepareStatement(query);
					stmt.setInt(1,i);
					rs = stmt.executeQuery();	
					while(rs.next())
					{
						str2=rs.getString(5);		pqty = rs.getInt(6);	
					
						
						String query2="select qty,cprice from actual_product where modelname=?";
						PreparedStatement stmt3 = conObject.prepareStatement(query2);				
						stmt3.setString(1, str2);	
						ResultSet rs3 = stmt3.executeQuery();	
						int qty=0;
						while(rs3.next())
						{
							
							qty = rs3.getInt(1);
							
							int final_qty= qty - pqty;							
					
							query  = "update actual_product set qty=? where modelname=?";
							stmt1 = conObject.prepareStatement(query);
					
							stmt1.setInt(1,final_qty);							
							stmt1.setString(2,str2);
							result = stmt1.executeUpdate();
							//if(result == 1)
							//	JOptionPane.showMessageDialog(null, "Items Delivered! Stock Updated.");
							
						}
						
					
					}
					query  = "update sales set orderstatus=? where sales_id=?";
					
					PreparedStatement stmt2 = conObject.prepareStatement(query);						
					stmt2.setInt(2,i);	
					stmt2.setString(1, "Completed");						
			
					int  result1 = stmt2.executeUpdate();
					if(result1 >= 1)
					{
						JOptionPane.showMessageDialog(null, "order marked completed");					
						
						comboBox.removeItem(comboBox.getSelectedItem());
						DefaultTableModel model = (DefaultTableModel) table.getModel();
						model.setRowCount(0);
					}
					
				}
					
				else
					JOptionPane.showMessageDialog(null,"Items not delivered...error!");
				stmt.close();
				conObject.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			
				
			}
		});
		btnNewButton.setBounds(77, 427, 144, 23);
		frmAmElectronics.getContentPane().add(btnNewButton);
		
		JButton btnGenerateBill = new JButton("Generate Bill");
		btnGenerateBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnGenerateBill.setBounds(307, 427, 144, 23);
		frmAmElectronics.getContentPane().add(btnGenerateBill);
		
		JLabel lblNewLabel = new JLabel("Payment Details");
		lblNewLabel.setBounds(43, 240, 86, 14);
		frmAmElectronics.getContentPane().add(lblNewLabel);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setRowHeight(40);
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBounds(80, 45, 661, 180);
		frmAmElectronics.getContentPane().add(table);
		
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
		button.setFont(new Font("Cambria", Font.BOLD, 18));
		button.setBounds(534, 418, 110, 35);
		frmAmElectronics.getContentPane().add(button);
		
		JLabel lblSalesId = new JLabel("Sales ID");
		lblSalesId.setBounds(128, 11, 46, 14);
		frmAmElectronics.getContentPane().add(lblSalesId);
		
		
		
		JButton button_1 = new JButton("Show");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(10);
				int sales_id=Integer.parseInt(comboBox.getSelectedItem().toString());
				int i=0;
				
				try {
					Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
					String query  = "Select  sales_id,invoice_no,sdate,customername,pname,qty,price,gst,total_amt,orderstatus from sales where sales_id=?";
					PreparedStatement stmt = conObject.prepareStatement(query);
					stmt.setInt(1,sales_id);
					ResultSet rs = stmt.executeQuery();		
					
					while(rs.next())
					{
						table.setValueAt(rs.getInt(1), i, 0);
						table.setValueAt(rs.getString(2), i, 1);
						table.setValueAt(rs.getString(3), i, 2);
						table.setValueAt(rs.getString(4), i, 3);
						table.setValueAt(rs.getString(5), i, 4);
						table.setValueAt(rs.getInt(6), i, 5);
						table.setValueAt(rs.getDouble(7), i, 6);
						table.setValueAt(rs.getDouble(8), i, 7);
						table.setValueAt(rs.getDouble(9), i, 8);
						i++;
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
		button_1.setBounds(327, 11, 111, 23);
		frmAmElectronics.getContentPane().add(button_1);
		
		
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			
			String query  = "Select  sales_id,invoice_no,sdate,customername,pname,qty,price,gst,total_amt from sales where sales_id=?";
			PreparedStatement stmt = conObject.prepareStatement(query);
			stmt.setInt(1,2);
			ResultSet rs = stmt.executeQuery();		
			int j=0;
			while(rs.next())
			{
				table.setValueAt(rs.getInt(1), j, 0);
				table.setValueAt(rs.getString(2), j, 1);
				table.setValueAt(rs.getString(3), j, 2);
				table.setValueAt(rs.getString(4), j, 3);
				table.setValueAt(rs.getString(5), j, 4);
				table.setValueAt(rs.getInt(6), j, 5);
				table.setValueAt(rs.getDouble(7), j, 6);
				table.setValueAt(rs.getDouble(8), j, 7);
				table.setValueAt(rs.getDouble(9), j, 8);
				j++;
			}
			//frame.getContentPane().add(new JScrollPane(table));
			
			
			stmt.close();
			conObject.close();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
		
		c1.setVisible(false);
		c2.setVisible(false);
		c3.setVisible(false);
		c4.setVisible(false);
		
		p1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c1.setVisible(false);
				c2.setVisible(false);
				c3.setVisible(false);
				c4.setVisible(false);
				chno.setVisible(false);
			}	
		});
		
		p2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chno.setVisible(true);
				c1.setVisible(false);
				c2.setVisible(false);
				c3.setVisible(false);
				c4.setVisible(false);
			}	
		});
		
		p3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				c1.setVisible(true);
				c2.setVisible(true);
				c3.setVisible(true);
				c4.setVisible(true);
				chno.setVisible(false);
			}	
		});
		
		
	}
}
