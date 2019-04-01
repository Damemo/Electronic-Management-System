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

public class app_add2 //extends javax.swing.JFrame
{

	public JFrame frmAmElectronics;
	
	private JTable table;
	private JTextField t2;

	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
			public void run() {
				try {
					app_add2 window = new app_add2();
					window.frmAmElectronics.setVisible(true);
				} catch (Exception e) {
					
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public app_add2() {
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
		frmAmElectronics.getContentPane().setLayout(null);
		
		table = new JTable();
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
		
		JLabel lblNewLabel_11 = new JLabel("              delete");
		lblNewLabel_11.setBounds(48, 665, 268, 40);
		frmAmElectronics.getContentPane().add(lblNewLabel_11);
		
		JLabel lblNewLabel_1 = new JLabel("          Update");
		lblNewLabel_1.setBounds(67, 665, 268, 40);
		frmAmElectronics.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Save");
		lblNewLabel.setBounds(67, 665, 268, 40);
		frmAmElectronics.getContentPane().add(lblNewLabel);
		table.setBounds(438, 728, 497, -88);
		frmAmElectronics.getContentPane().add(table);
		
		JLabel lblNewLabel_9 = new JLabel("AM ELECTRONICS");
		lblNewLabel_9.setBackground(new Color(153, 51, 204));
		lblNewLabel_9.setFont(new Font("Monotype Corsiva", Font.BOLD, 72));
		lblNewLabel_9.setBounds(677, 174, 693, 59);
		frmAmElectronics.getContentPane().add(lblNewLabel_9);
		
		JLabel l1 = new JLabel("Appliance Add Details");
		l1.setFont(new Font("Tahoma", Font.BOLD, 30));
		l1.setBounds(88, 311, 355, 31);
		frmAmElectronics.getContentPane().add(l1);
		
		JLabel l4 = new JLabel("Appliance no");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l4.setBounds(48, 510, 155, 32);
		frmAmElectronics.getContentPane().add(l4);
		
		JLabel l5 = new JLabel("Appliance name");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l5.setBounds(48, 575, 155, 23);
		frmAmElectronics.getContentPane().add(l5);
		
	
		JButton b1 = new JButton("");
		b1.setToolTipText("save");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to add?");
				if(resp == 0)
				{
				
try {
					
					
					Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
					
					String query  = "insert into  app(aname) values (?)";
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
		b1.setBounds(67, 665, 268, 40);
		frmAmElectronics.getContentPane().add(b1);
		
		JButton b2 = new JButton("View");
		b2.setToolTipText("view data");
		b2.setBounds(705, 651, 91, 23);
		frmAmElectronics.getContentPane().add(b2);
		
		JButton b3 = new JButton("Exit");
		b3.setToolTipText("go to MDI");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
				if(resp == 0)
				{
					frmAmElectronics.setVisible(false);
					frmAmElectronics.dispose();
					
					MDI1 frame1 = new MDI1();
					frame1.frmAmEletronics.setVisible(true);
					
				}
			}
		
		});
		b3.setBounds(778, 704, 91, 23);
		frmAmElectronics.getContentPane().add(b3);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(-22, -7, 1392, 176);
		frmAmElectronics.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\download 8.jpg"));
		lblNewLabel_4.setBounds(0, 0, 371, 169);
		frmAmElectronics.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\avani (2).jpg"));
		lblNewLabel_5.setBounds(368, 0, 264, 169);
		frmAmElectronics.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\download (1).jpg"));
		lblNewLabel_6.setBounds(630, 0, 269, 169);
		frmAmElectronics.getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\images.jpg"));
		lblNewLabel_7.setBounds(891, 0, 295, 169);
		frmAmElectronics.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\download5.jpg"));
		lblNewLabel_8.setBounds(1183, 0, 187, 169);
		frmAmElectronics.getContentPane().add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\download0.jpg"));
		lblNewLabel_10.setBounds(1096, 311, 264, 176);
		frmAmElectronics.getContentPane().add(lblNewLabel_10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(24, 480, 540, 2);
		frmAmElectronics.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 633, 555, 7);
		frmAmElectronics.getContentPane().add(separator_1);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(560, 580, -12, 2);
		frmAmElectronics.getContentPane().add(separator_3);
		
		JLabel t1 = new JLabel("");
		t1.setBackground(Color.WHITE);
		t1.setForeground(Color.WHITE);
		t1.setToolTipText("Auto app no");
		t1.setFont(new Font("Cambria", Font.PLAIN, 15));
		t1.setBounds(244, 510, 91, 23);
		frmAmElectronics.getContentPane().add(t1);
		
		t2 = new JTextField();
		t2.setBounds(249, 580, 86, 20);
		frmAmElectronics.getContentPane().add(t2);
		t2.setColumns(10);
		
		JButton b4 = new JButton("update");
		b4.setBounds(525, 704, 91, 23);
		frmAmElectronics.getContentPane().add(b4);
		
		JButton b5 = new JButton("delete");
		b5.setBounds(643, 694, 91, 23);
		frmAmElectronics.getContentPane().add(b5);
		
		JRadioButton r1 = new JRadioButton("Add");
		r1.setBounds(24, 255, 109, 23);
		frmAmElectronics.getContentPane().add(r1);
		
		JRadioButton r2 = new JRadioButton("update");
		r2.setBounds(178, 255, 109, 23);
		frmAmElectronics.getContentPane().add(r2);
		
		JRadioButton r3 = new JRadioButton("New radio button");
		r3.setBounds(350, 255, 109, 23);
		frmAmElectronics.getContentPane().add(r3);
		
		JButton b6 = new JButton("show");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
			}
		});
		b6.setBounds(541, 255, 91, 23);
		frmAmElectronics.getContentPane().add(b6);
		
		JLabel l2 = new JLabel("Update");
		l2.setBounds(88, 353, 46, 14);
		frmAmElectronics.getContentPane().add(l2);
		
		JLabel l3 = new JLabel("delete");
		l3.setBounds(88, 392, 46, 14);
		frmAmElectronics.getContentPane().add(l3);
		JLabel lblNewLabel_3 = new JLabel("");
		
		try {
			Connection conObject=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
			Statement stmt = conObject.createStatement();
			String query  = "Select top 1 aid from app order by aid desc";
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
