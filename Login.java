import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Window;

public class Login {

	public JFrame frmAmElectronics;
	private JTextField t1;
	private JPasswordField t2;
	private JButton btnLogin;

	/**
	 * Launch the application.
     * @param args
	 */
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmAmElectronics.setVisible(true);
				} catch (Exception e) {
					//e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.setTitle("AM ELECTRONICS");
		frmAmElectronics.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\LENOVO\\Desktop\\login6.jpg"));
		frmAmElectronics.getContentPane().setBackground(new Color(51, 153, 255));
		frmAmElectronics.setBounds(100, 100, 1438, 749);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("AM ELECTRONICS");
		lblNewLabel_4.setFont(new Font("Monotype Corsiva", Font.BOLD, 73));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(457, 40, 659, 95);
		frmAmElectronics.getContentPane().add(lblNewLabel_4);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBackground(new Color(255, 255, 255));
		lblLogin.setFont(new Font("Monotype Corsiva", Font.BOLD, 35));
		lblLogin.setBounds(680, 176, 103, 49);
		frmAmElectronics.getContentPane().add(lblLogin);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 35));
		lblNewLabel.setBounds(568, 275, 171, 24);
		frmAmElectronics.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Monotype Corsiva", Font.BOLD, 35));
		lblNewLabel_1.setBounds(568, 338, 150, 24);
		frmAmElectronics.getContentPane().add(lblNewLabel_1);
		
		t1 = new JTextField();
		t1.setToolTipText("Please enter valid username");
		t1.setFont(new Font("Tahoma", Font.BOLD, 15));
		t1.setBounds(824, 275, 136, 35);
		frmAmElectronics.getContentPane().add(t1);
		t1.setColumns(10);
		
		t2 = new JPasswordField();
		t2.setToolTipText("Please enter valid password");
		t2.setFont(new Font("Tahoma", Font.BOLD, 15));
		t2.setBounds(824, 347, 136, 35);
		frmAmElectronics.getContentPane().add(t2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(512, 413, 548, 2);
		frmAmElectronics.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(512, 236, 548, 14);
		frmAmElectronics.getContentPane().add(separator_1);
		
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
		btnExit.setFont(new Font("Cambria", Font.BOLD, 17));
		btnExit.setBounds(857, 464, 103, 35);
		frmAmElectronics.getContentPane().add(btnExit);
		
		btnLogin = new JButton("            Login");
		btnLogin.setIconTextGap(2);
		btnLogin.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogin.setSelectedIcon(null);
		btnLogin.setIcon(null);
		btnLogin.setFont(new Font("Cambria", Font.BOLD, 15));
		btnLogin.addActionListener(new ActionListener() {
                        @Override
			public void actionPerformed(ActionEvent e) {
				
				 //Connection con =null;
			        PreparedStatement pst;
			        ResultSet rs=null;
			        try
			        {
			        // Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			       //   con=DriverManager.getConnection("jdbc:odbc:dsn2");
			        	Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
						Connection con=DriverManager.getConnection("jdbc:ucanaccess://d:/electronics1.accdb");
				 String query="select * from login where username=? and password=?";
			        pst=con.prepareStatement(query);

				pst.setString(1,t1.getText());
				pst.setString(2,t2.getText());


			         ResultSet rs1=pst.executeQuery();
			int count=0;
			         while(rs1.next())
			         {

					count++;

			            
			         }
				if(count>0)
				{
					
					 int resp = JOptionPane.showConfirmDialog(null,"Successfully login...");
					           // JOptionPane.showConfirmDialog(null, "Are you sure you want to proceed to ?");
					 
								if(resp == 0)
								{
									frmAmElectronics.setVisible(false);
									frmAmElectronics.dispose();
									
									MDI1 mdi1 = new MDI1();
									  mdi1.frmAmEletronics.setVisible(true);;
									
								}
				}				

			         else
			         {
			             JOptionPane.showMessageDialog(null,"Invalid login..."); 
			         }
			        }catch(HeadlessException | ClassNotFoundException | SQLException e1){
			             JOptionPane.showMessageDialog(null,e);
			             
			        }
				
				
				
				
			}
		});
		btnLogin.setBounds(608, 465, 109, 35);
		frmAmElectronics.getContentPane().add(btnLogin);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\XxryJrd - Copy.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1431, 751);
		frmAmElectronics.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBackground(new Color(51, 153, 255));
		lblNewLabel_3.setForeground(new Color(51, 153, 255));
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\login6.jpg"));
		lblNewLabel_3.setBounds(-14, 0, 1445, 735);
		frmAmElectronics.getContentPane().add(lblNewLabel_3);
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}
}
