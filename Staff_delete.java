import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import javax.swing.JFormattedTextField;

public class Staff_delete extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t2;
	private JTextField t5;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Staff_delete frame = new Staff_delete();
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
	public Staff_delete() {
		setTitle("AM ELECTRONICS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1378, 870);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSupplierNo = new JLabel("Staff No");
		lblSupplierNo.setForeground(new Color(255, 255, 255));
		lblSupplierNo.setFont(new Font("Cambria", Font.BOLD, 15));
		lblSupplierNo.setBounds(63, 55, 82, 21);
		contentPane.add(lblSupplierNo);
		
		JLabel lblSupplierDetailsForm = new JLabel("Staff Details Delete Form");
		lblSupplierDetailsForm.setForeground(new Color(255, 255, 255));
		lblSupplierDetailsForm.setFont(new Font("Cambria", Font.BOLD, 17));
		lblSupplierDetailsForm.setBounds(97, 11, 238, 21);
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
		t2.setBounds(154, 84, 138, 20);
		contentPane.add(t2);
		t2.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(251, 112, -94, 39);
		contentPane.add(textArea);
		
		JTextArea t3 = new JTextArea();
		t3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, Color.BLACK, null));
		t3.setBounds(155, 120, 137, 63);
		contentPane.add(t3);
		
		t4 = new JTextField();
		//{
		//public void processKeyEvent(KeyEvent ev) 
		//{
		//	char c = ev.getKeyChar();
			//if(c>=48 && c<=57) 
			//{
			//	super.processKeyEvent(ev);
		//	}
		
		//}
		
		t4.setBounds(155, 195, 137, 20);
		contentPane.add(t4);
		t4.setColumns(10);
		
	//};
	
			
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
		
		JButton btnUpdate = new JButton("Delete");
		btnUpdate.setIcon(null);
		btnUpdate.setFont(new Font("Cambria", Font.BOLD, 15));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?");
				if(resp == 0)
				{
				try
				{
				Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				String supp=String.valueOf(comboBox.getSelectedItem());
			String query  = "delete * from  staff  where sno="+Integer.parseInt(supp);
			PreparedStatement stmt = conObject.prepareStatement(query);
			
						
			int result = stmt.executeUpdate();
			if(result == 1)
			{
				JOptionPane.showMessageDialog(null, "Record deleted successfully!");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				comboBox.removeItem(supp);
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
		btnUpdate.setBounds(97, 278, 109, 46);
		contentPane.add(btnUpdate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(63, 43, 314, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\BIG.jpg"));
		lblNewLabel.setBounds(0, 3, 1370, 750);
		contentPane.add(lblNewLabel);
		
		
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					
						
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					String supp=String.valueOf(comboBox.getSelectedItem());
				
					String query  = "select * from staff where sno="+Integer.parseInt(supp);
					PreparedStatement stmt = conObject.prepareStatement(query);
				
					ResultSet rs = stmt.executeQuery();
					
					
					while(rs.next())
					{
						
						t2.setText(rs.getString(1));
						t3.setText(rs.getString(2));
						t4.setText(String.valueOf(rs.getString(3)));
						t5.setText(rs.getString(4));
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
		
		}
}

