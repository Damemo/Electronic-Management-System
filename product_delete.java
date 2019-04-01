import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class product_delete {

	public JFrame frmAmElectronics;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					product_delete window = new product_delete();
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
	public product_delete() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmElectronics = new JFrame();
		frmAmElectronics.setTitle("AM ELECTRONICS");
		frmAmElectronics.getContentPane().setBackground(new Color(51, 51, 153));
		frmAmElectronics.setBounds(100, 100, 814, 498);
		frmAmElectronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmElectronics.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 51, 153));
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBounds(10, 11, 655, 449);
		frmAmElectronics.getContentPane().add(panel);
		
		JLabel label = new JLabel("Product No");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Cambria", Font.BOLD, 13));
		label.setBounds(63, 55, 82, 21);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Product Details Form");
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setFont(new Font("Cambria", Font.BOLD, 15));
		label_1.setBounds(189, 11, 168, 21);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Brand ID");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setFont(new Font("Cambria", Font.BOLD, 13));
		label_2.setBounds(63, 116, 82, 14);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Product Name");
		label_3.setForeground(new Color(255, 255, 255));
		label_3.setFont(new Font("Cambria", Font.BOLD, 13));
		label_3.setBounds(63, 87, 94, 14);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Quantity");
		label_4.setForeground(new Color(255, 255, 255));
		label_4.setFont(new Font("Cambria", Font.BOLD, 13));
		label_4.setBounds(63, 178, 62, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Brand Name");
		label_5.setForeground(new Color(255, 255, 255));
		label_5.setFont(new Font("Cambria", Font.BOLD, 13));
		label_5.setBounds(63, 147, 82, 14);
		panel.add(label_5);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setColumns(10);
		textField.setBounds(new Rectangle(300, 1000, 500, 0));
		textField.setAlignmentX(1.0f);
		textField.setBounds(167, 84, 135, 20);
		panel.add(textField);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(251, 112, -94, 39);
		panel.add(textArea);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setColumns(10);
		textField_1.setBounds(new Rectangle(0, 1000, 500, 0));
		textField_1.setAlignmentX(1.0f);
		textField_1.setBounds(167, 113, 135, 20);
		panel.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_2.setColumns(10);
		textField_2.setBounds(new Rectangle(0, 1000, 500, 0));
		textField_2.setAlignmentX(1.0f);
		textField_2.setBounds(164, 175, 138, 20);
		panel.add(textField_2);
		
		JButton button = new JButton("Show");
		button.setFont(new Font("Cambria", Font.BOLD, 14));
		button.setBounds(348, 54, 108, 23);
		panel.add(button);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_3.setColumns(10);
		textField_3.setBounds(new Rectangle(300, 1000, 500, 0));
		textField_3.setAlignmentX(1.0f);
		textField_3.setBounds(167, 144, 135, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(164, 206, 138, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(164, 237, 138, 20);
		panel.add(textField_5);
		
		JLabel label_6 = new JLabel("Cost Price");
		label_6.setForeground(new Color(255, 255, 255));
		label_6.setFont(new Font("Cambria", Font.BOLD, 13));
		label_6.setBounds(63, 209, 62, 14);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Selling Price");
		label_7.setForeground(new Color(255, 255, 255));
		label_7.setFont(new Font("Cambria", Font.BOLD, 13));
		label_7.setBounds(63, 240, 82, 14);
		panel.add(label_7);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setFont(new Font("Cambria", Font.BOLD, 14));
		btnDelete.setBounds(95, 312, 108, 23);
		panel.add(btnDelete);
		
		JButton button_2 = new JButton("Exit");
		button_2.addActionListener(new ActionListener() {
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
		button_2.setFont(new Font("Cambria", Font.BOLD, 14));
		button_2.setBounds(297, 312, 108, 23);
		panel.add(button_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(167, 54, 135, 22);
		panel.add(comboBox);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(63, 43, 393, 2);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(63, 299, 393, 2);
		panel.add(separator_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(167, 268, 138, 22);
		panel.add(comboBox_1);
		
		JLabel label_8 = new JLabel("Supplier No");
		label_8.setForeground(new Color(255, 255, 255));
		label_8.setFont(new Font("Cambria", Font.BOLD, 13));
		label_8.setBounds(63, 276, 82, 14);
		panel.add(label_8);
	}

}
