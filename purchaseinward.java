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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

public class purchaseinward {

	public JFrame frmAmElectronics;
	Double gst,ta;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					purchaseinward window = new purchaseinward();
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
	public purchaseinward() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.getContentPane().setBackground(new Color(255, 255, 255));
		frmAmElectronics.setTitle("AM  Electronics");
		frmAmElectronics.setBounds(100, 100, 975, 780);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComboBox<String> cb1 = new JComboBox<String>();
		cb1.setBounds(175, 7, 111, 22);
		frmAmElectronics.getContentPane().add(cb1);
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select  distinct pur_id from purchase where orderstatus='new'";
			ResultSet rs = stmt.executeQuery(query);		
			
			while(rs.next())
				cb1.addItem(String.valueOf(rs.getInt(1)));
			
			
			stmt.close();
			conObject.close();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
		frmAmElectronics.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setRowHeight(40);
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
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
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(0).setMaxWidth(1000);
		table.getColumnModel().getColumn(1).setPreferredWidth(204);
		table.getColumnModel().getColumn(1).setMaxWidth(1000);
		table.getColumnModel().getColumn(2).setPreferredWidth(690);
		table.getColumnModel().getColumn(2).setMaxWidth(1000);
		table.getColumnModel().getColumn(3).setPreferredWidth(267);
		table.getColumnModel().getColumn(3).setMaxWidth(1001);
		table.getColumnModel().getColumn(4).setPreferredWidth(541);
		table.getColumnModel().getColumn(4).setMaxWidth(1000);
		table.getColumnModel().getColumn(5).setPreferredWidth(200);
		table.getColumnModel().getColumn(5).setMaxWidth(1000);
		table.getColumnModel().getColumn(6).setPreferredWidth(200);
		table.getColumnModel().getColumn(6).setMaxWidth(200);
		table.getColumnModel().getColumn(7).setPreferredWidth(202);
		table.getColumnModel().getColumn(7).setMaxWidth(1000);
		table.getColumnModel().getColumn(8).setPreferredWidth(206);
		table.getColumnModel().getColumn(8).setMaxWidth(1000);
		table.getColumnModel().getColumn(9).setPreferredWidth(204);
		table.getColumnModel().getColumn(9).setMaxWidth(1000);
		table.setBounds(10, 74, 808, 279);
		frmAmElectronics.getContentPane().add(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(53, 11, 46, 14);
		frmAmElectronics.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Show");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.setRowCount(10);
				int pid=Integer.parseInt(cb1.getSelectedItem().toString());
				int i=0;
				
				try {
					Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
					String query  = "Select  pur_id,invoice_no,pdate,supp_no,pname,qty,price,gst,total_amount from purchase where pur_id=?";
					PreparedStatement stmt = conObject.prepareStatement(query);
					stmt.setInt(1,pid);
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
		btnNewButton.setBounds(304, 12, 111, 23);
		frmAmElectronics.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Goods Received");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
				int pid=Integer.parseInt(cb1.getSelectedItem().toString());
				String query  = "Select pname,qty,price,total_amount from purchase where pur_id=?";
				PreparedStatement stmt = conObject.prepareStatement(query);
				stmt.setInt(1,pid);
				ResultSet rs = stmt.executeQuery();		
				String str2;				Double pprice=0.0,ta;				int pqty;
				while(rs.next())
				{
					str2=rs.getString(1);		pprice=rs.getDouble(3);			pqty = rs.getInt(2);	ta=rs.getDouble(4);
				
					
					query="select qty,cprice from actual_product where modelname=?";
					PreparedStatement stmt1 = conObject.prepareStatement(query);				
					stmt1.setString(1, str2);	
					ResultSet rs1 = stmt1.executeQuery();		
				
					Double cp=0.0;					int qty=0;
					while(rs1.next())
					{
						cp=rs1.getDouble(2);
						qty = rs1.getInt(1);
						
						int final_qty= qty + pqty;
						Double final_cp = ((cp*qty) + ta ) / final_qty;
						Double final_sp = final_cp * 1.2;
				
						query  = "update actual_product set qty=?,cprice=?,sprice=? where modelname=?";
						stmt1 = conObject.prepareStatement(query);
				
						stmt1.setInt(1,final_qty);
						stmt1.setDouble(2,final_cp);
						stmt1.setDouble(3,final_sp);
						stmt1.setString(4,str2);
						int result = stmt1.executeUpdate();
						if(result == 1)
						{
							JOptionPane.showMessageDialog(null, "Quantity updated successfully in the stock!");
						}
					}
				
				}
				
				
				query  = "update purchase set orderstatus=? where pur_id=?";
								
								PreparedStatement stmt2 = conObject.prepareStatement(query);						
								stmt2.setInt(2,pid);	
								stmt2.setString(1, "Completed");						
						
								int  result1 = stmt2.executeUpdate();
								if(result1 >= 1)
								{
									JOptionPane.showMessageDialog(null, "order marked completed");
								
									cb1.removeItem(cb1.getSelectedItem());
									DefaultTableModel model = (DefaultTableModel) table.getModel();
									model.setRowCount(0);
								}
						
				
					
				}
				
				catch(Exception eee)
				{}
			}
			}
		);
		btnNewButton_1.setBounds(58, 381, 152, 23);
		frmAmElectronics.getContentPane().add(btnNewButton_1);
		
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
		button.setBounds(421, 381, 110, 35);
		frmAmElectronics.getContentPane().add(button);
		
		
		
		
		
		
		
	
	
	
	
	
	}
}

