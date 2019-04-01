import java.awt.EventQueue;

import javax.swing.JFrame;
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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.Component;

public class app_add3 //extends javax.swing.JFrame
{

	public JFrame frmAmElectronics;
	
	private JTable table;
	private JTextField t2;
	private JTextField t3;
	private JLabel l2;

	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					app_add3 window = new app_add3();
					window.frmAmElectronics.setVisible(true);
				} catch (Exception e) {
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public app_add3() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.setTitle("AM ELECTRONICS");
		frmAmElectronics.getContentPane().setBackground(new Color(51, 153, 255));
		frmAmElectronics.setBounds(100, 100, 1378, 887);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		table = new JTable();
		table.setBounds(438, 728, 497, -88);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		frmAmElectronics.getContentPane().setLayout(null);
		
		JLabel l1 = new JLabel("update");
		l1.setBounds(107, 499, 46, 14);
		frmAmElectronics.getContentPane().add(l1);
		frmAmElectronics.getContentPane().add(table);
		
		JLabel lblNewLabel_9 = new JLabel("AM ELECTRONICS");
		lblNewLabel_9.setBounds(677, 174, 693, 59);
		lblNewLabel_9.setBackground(new Color(153, 51, 204));
		lblNewLabel_9.setFont(new Font("Monotype Corsiva", Font.BOLD, 72));
		frmAmElectronics.getContentPane().add(lblNewLabel_9);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-22, -7, 1392, 176);
		frmAmElectronics.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(0, 0, 371, 169);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\download 8.jpg"));
		frmAmElectronics.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setBounds(368, 0, 264, 169);
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\avani (2).jpg"));
		frmAmElectronics.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(630, 0, 269, 169);
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\download (1).jpg"));
		frmAmElectronics.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setBounds(891, 0, 295, 169);
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\images.jpg"));
		frmAmElectronics.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(1183, 0, 187, 169);
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\download5.jpg"));
		frmAmElectronics.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(1096, 311, 264, 176);
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\download0.jpg"));
		frmAmElectronics.getContentPane().add(lblNewLabel_10);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(560, 580, -12, 2);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		frmAmElectronics.getContentPane().add(separator_3);
		
		JLabel t1 = new JLabel("");
		t1.setBounds(244, 510, 91, 23);
		t1.setBackground(Color.WHITE);
		t1.setForeground(Color.WHITE);
		t1.setToolTipText("Auto app no");
		t1.setFont(new Font("Cambria", Font.PLAIN, 15));
		frmAmElectronics.getContentPane().add(t1);
		
		JRadioButton r1 = new JRadioButton("New radio button");
		r1.setBounds(79, 279, 109, 23);
		frmAmElectronics.getContentPane().add(r1);
		
		l2 = new JLabel("New label");
		l2.setVisible(false);
		l2.setAlignmentX(Component.CENTER_ALIGNMENT);
		l2.setBounds(90, 363, 46, 14);
		frmAmElectronics.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("New label");
		l3.setBounds(90, 418, 46, 14);
		frmAmElectronics.getContentPane().add(l3);
		
		t2 = new JTextField();
		t2.setBounds(186, 360, 86, 20);
		frmAmElectronics.getContentPane().add(t2);
		t2.setColumns(10);
		
		t3 = new JTextField();
		t3.setBounds(186, 415, 86, 20);
		frmAmElectronics.getContentPane().add(t3);
		t3.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				
				Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				
				String query1  = "insert into app(aid,aname) values (?,?)";
				PreparedStatement stmt1 = conObject.prepareStatement(query1);
				
				 if(r1.isSelected() == true)
			        {
			        	stmt1.setString(1,"update");
			        	stmt1.setString(2,"");
			        	
			        }
				
				
				}catch(Exception e1)
				{
				}
				}
			
		});
		btnNewButton.setBounds(90, 499, 91, 23);
		frmAmElectronics.getContentPane().add(btnNewButton);
		JLabel lblNewLabel_3 = new JLabel("");
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select top 1 aid from app order by aid desc";
			ResultSet rs = stmt.executeQuery(query);		
			if(!rs.next())
				t2.setText(String.valueOf(1));
			else
				t2.setText(String.valueOf(rs.getInt(1)+1));
			
			stmt.close();
			conObject.close();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
		
		
		
	}
	protected boolean getFrmAmElectronicsContentPaneVisible() {
		return frmAmElectronics.getContentPane().isVisible();
	}
	protected void setFrmAmElectronicsContentPaneVisible(boolean visible) {
		frmAmElectronics.getContentPane().setVisible(visible);
	}
	public boolean getL2Visible() {
		return l2.isVisible();
	}
	public void setL2Visible(boolean visible_1) {
		l2.setVisible(visible_1);
	}
}
