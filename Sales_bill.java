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

public class Sales_bill {

	public JFrame frmAmElectronics;
	private JTextField chno;
	private JTextField c1;
	private JTextField c2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * @wbp.nonvisual location=134,101
	 */
	private final JTable table = new JTable();
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
					Sales_bill window = new Sales_bill(i);
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
	public Sales_bill(int i) 
	{
		JOptionPane.showMessageDialog(null, i);
		initialize(i);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int i) {
		table.setRowHeight(40);
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		frmAmElectronics = new JFrame();
		frmAmElectronics.setTitle("AM ELECTRONICS");
		frmAmElectronics.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\stuff\\img1.jpg"));
		frmAmElectronics.setBounds(100, 100, 642, 463);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		
		frmAmElectronics.setContentPane(new JLabel(new ImageIcon("D:\\xyz.jpg")));
		
		JRadioButton p1 = new JRadioButton("Cash");
		buttonGroup.add(p1);
		p1.setBounds(65, 219, 109, 23);
		frmAmElectronics.getContentPane().add(p1);
		
		JRadioButton p2 = new JRadioButton("Cheque");
		buttonGroup.add(p2);
		p2.setBounds(65, 245, 109, 23);
		frmAmElectronics.getContentPane().add(p2);
		
		chno = new JTextField();
		chno.setBounds(242, 246, 137, 20);
		frmAmElectronics.getContentPane().add(chno);
		chno.setColumns(10);
		
		JRadioButton p3 = new JRadioButton("Card Payment");
		buttonGroup.add(p3);
		p3.setBounds(68, 271, 109, 23);
		frmAmElectronics.getContentPane().add(p3);
		
		c1 = new JTextField();
		c1.setColumns(10);
		c1.setBounds(164, 301, 137, 20);
		frmAmElectronics.getContentPane().add(c1);
		
		c2 = new JTextField();
		c2.setColumns(10);
		c2.setBounds(164, 326, 137, 20);
		frmAmElectronics.getContentPane().add(c2);
		
		JComboBox<String> c3 = new JComboBox<String>();
		c3.setModel(new DefaultComboBoxModel<String>(new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"}));
		c3.setBounds(164, 351, 57, 22);
		frmAmElectronics.getContentPane().add(c3);
		
		JComboBox<String> c4 = new JComboBox<String>();
		c4.setModel(new DefaultComboBoxModel<String>(new String[] {"2018", "2019", "2020", "2021", "2022", "2023"}));
		c4.setBounds(230, 351, 57, 22);
		frmAmElectronics.getContentPane().add(c4);
		
	
		
		JButton btnNewButton = new JButton("Good Delivered");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				
				String query  = "Select  sales_id,sdate,customername,total_amount,pname,qty,price from sales where sales_id=?";
				
				PreparedStatement stmt = conObject.prepareStatement(query);
				stmt.setInt(1,i);
				ResultSet rs = stmt.executeQuery();		
				int totalamount=0;
				String sdate="";
				while(rs.next())
				{
					totalamount = totalamount + rs.getInt(4);
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
					query  = "Select  sales_id,sdate,customername,total_amount,pname,qty,price from sales where sales_id=?";
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
							if(result == 1)
								JOptionPane.showMessageDialog(null, "Items Delivered! Stock Updated.");
							
						}
						
					
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
		btnNewButton.setBounds(67, 402, 144, 23);
		frmAmElectronics.getContentPane().add(btnNewButton);
		
		JButton btnGenerateBill = new JButton("Generate Bill");
		btnGenerateBill.setBounds(270, 402, 144, 23);
		frmAmElectronics.getContentPane().add(btnGenerateBill);
		
		JLabel lblNewLabel = new JLabel("Payment Details");
		lblNewLabel.setBounds(42, 198, 46, 14);
		frmAmElectronics.getContentPane().add(lblNewLabel);
		
		
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			
			String query  = "Select  sales_id,invoice_no,sdate,customername,pname,qty,price,gst,total_amount from sales where sales_id=?";
			PreparedStatement stmt = conObject.prepareStatement(query);
			stmt.setInt(1,i);
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
			
			frmAmElectronics.getContentPane().add(new JScrollPane());
			frmAmElectronics.getContentPane().validate();
			frmAmElectronics.getContentPane().repaint();
			
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
		chno.setVisible(false);
		
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
