import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class MDI1 {

	public JFrame frmAmEletronics;
	protected Object frmAmElectronics;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MDI1 window = new MDI1();
					window.frmAmEletronics.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MDI1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAmEletronics = new JFrame();
		frmAmEletronics.setTitle("AM ELECTRONICS");
		frmAmEletronics.setBounds(100, 100, 1434, 780);
		frmAmEletronics.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAmEletronics.getContentPane().setLayout(null);
		
		JLabel lblNewLabl = new JLabel("");
		lblNewLabl.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\project images\\computer-2563737__340.jpg"));
		lblNewLabl.setBounds(0, 0, 1377, 744);
		frmAmEletronics.getContentPane().add(lblNewLabl);
		
		JMenuBar menuBar = new JMenuBar();
		frmAmEletronics.setJMenuBar(menuBar);
		
		JMenu mnMasterMaintenance = new JMenu("Master Maintenance ");
		mnMasterMaintenance.setFont(new Font("Cambria", Font.BOLD, 15));
		menuBar.add(mnMasterMaintenance);
		
		JMenu mnSupplierDetails = new JMenu("Supplier Details");
		mnSupplierDetails.setFont(new Font("Cambria", Font.BOLD, 15));
		mnMasterMaintenance.add(mnSupplierDetails);
		
		JMenuItem mntmAdd = new JMenuItem("Add");
		mntmAdd.setFont(new Font("Cambria", Font.BOLD, 15));
		mnSupplierDetails.add(mntmAdd);
		mntmAdd.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
				
			
				Supplier_add frame = new Supplier_add();
			frame.setVisible(true);
			}
		
		});
		
		JMenuItem mntmUpdate = new JMenuItem("Update");
		mntmUpdate.setFont(new Font("Cambria", Font.BOLD, 15));
		mnSupplierDetails.add(mntmUpdate);
		mntmUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Supplier_update frame = new Supplier_update();
				frame.frmAmElectronics.setVisible(true);
			}
		});
		
		
		JMenuItem mntmDelete = new JMenuItem("Delete");
		mntmDelete.setFont(new Font("Cambria", Font.BOLD, 15));
		mnSupplierDetails.add(mntmDelete);
		mntmDelete.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
				
				Supplier_delete frame = new Supplier_delete();
				frame.setVisible(true);
			}
		});
		
		
		JMenu mnBrandDetails = new JMenu("Brand Details");
		mnBrandDetails.setFont(new Font("Cambria", Font.BOLD, 15));
		mnMasterMaintenance.add(mnBrandDetails);
		
		
		
		JMenuItem mntmAdd_1 = new JMenuItem("Add");
		mntmAdd_1.setFont(new Font("Cambria", Font.BOLD, 15));
		mnBrandDetails.add(mntmAdd_1);
		mntmAdd_1.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
				
				brand_add frame1 = new brand_add();
				frame1.frame.setVisible(true);
			}
		
		});
		
		JMenuItem mntmUpdate_1 = new JMenuItem("Update");
		mntmUpdate_1.setFont(new Font("Cambria", Font.BOLD, 15));
		mnBrandDetails.add(mntmUpdate_1);
		mntmUpdate_1.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
				
				brand_update frame1 = new brand_update();
				 frame1.frmAmElectronics.setVisible(true);
			}
		
		});
		
		
		JMenuItem mntmDelete_1 = new JMenuItem("Delete");
		mntmDelete_1.setFont(new Font("Cambria", Font.BOLD, 15));
		mnBrandDetails.add(mntmDelete_1);
		mntmDelete.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
				
				brand_delete frame1 = new brand_delete();
				frame1.frmAmElectronics.setVisible(true);
			}
		
		});
		
		JMenu mnApplianceType = new JMenu("Appliance Type");
		mnApplianceType.setFont(new Font("Cambria", Font.BOLD, 15));
		mnMasterMaintenance.add(mnApplianceType);
		
		JMenuItem mntmAdd_2 = new JMenuItem("Add");
		mntmAdd_2.setFont(new Font("Cambria", Font.BOLD, 15));
		mnApplianceType.add(mntmAdd_2);
		mntmAdd_2.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
				
				app_add frame1 = new app_add();
				frame1.frmAmElectronics.setVisible(true);
			}
		
		});
		
		
		JMenuItem mntmUpdate_2 = new JMenuItem("Update");
		mntmUpdate_2.setFont(new Font("Cambria", Font.BOLD, 15));
		mnApplianceType.add(mntmUpdate_2);
		mntmUpdate_2.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
				
				app_update frame1 = new app_update();
				frame1.frmAmElectronics.setVisible(true);
			}
		
		});
		
		JMenuItem mntmDelete_2 = new JMenuItem("Delete");
		mntmDelete_2.setFont(new Font("Cambria", Font.BOLD, 15));
		mnApplianceType.add(mntmDelete_2);
		mntmDelete_2.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
				
				app_delete frame1 = new app_delete();
				frame1.frmAmElectronics.setVisible(true);
			}
		
		});
		
		
		
		JMenu mnActualProduct = new JMenu("Actual Product ");
		mnActualProduct.setFont(new Font("Cambria", Font.BOLD, 15));
		mnMasterMaintenance.add(mnActualProduct);
		
		JMenuItem mntmAdd_3 = new JMenuItem("Add");
		mntmAdd_3.setFont(new Font("Cambria", Font.BOLD, 15));
		mnActualProduct.add(mntmAdd_3);
		mntmAdd_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							
							product_add frame1 = new product_add();
							frame1.frmAmElectronics.setVisible(true);
						}
					
					});
					
		
		
		
		JMenuItem mntmUpdate_3 = new JMenuItem("Update");
		mntmUpdate_3.setFont(new Font("Cambria", Font.BOLD, 15));
		mnActualProduct.add(mntmUpdate_3);
		mntmUpdate_3.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {

			}
		
		});
		
		
		JMenuItem mntmDelete_3 = new JMenuItem("Delete");
		mntmDelete_3.setFont(new Font("Cambria", Font.BOLD, 15));
		mnActualProduct.add(mntmDelete_3);
		mntmDelete_3.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
	
			}
		
		});
		
		
		JMenuItem mntmCustomer = new JMenuItem("Customer");
		mntmCustomer.setFont(new Font("Cambria", Font.BOLD, 16));
		mnMasterMaintenance.add(mntmCustomer);
		mntmCustomer.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				
					
					customer frame1=new customer();
					frame1.frame.setVisible(true);
				
			}

		});
		
		JMenuItem mntmStaff = new JMenuItem("Staff");
		mntmStaff.setFont(new Font("Cambria", Font.BOLD, 16));
		mnMasterMaintenance.add(mntmStaff);
		mntmStaff.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {

				staff_add1 frame1 = new staff_add1();
				frame1.frame1.setVisible(true);
			}

		});
		
		
		JMenu mnPurchases = new JMenu("Purchases");
		mnPurchases.setFont(new Font("Cambria", Font.BOLD, 15));
		menuBar.add(mnPurchases);
		
		JMenuItem mntmOrder = new JMenuItem("Order");
		mntmOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
		mnPurchases.add(mntmOrder);
		mntmOrder.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
				
				purchase frame1 = new purchase();
				frame1.frmAmElectronics.setVisible(true);
			}
		
		});
		
		
		JMenuItem mntmInward = new JMenuItem("Inward");
		mntmInward.setFont(new Font("Tahoma", Font.BOLD, 14));
		mnPurchases.add(mntmInward);
		mntmInward.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
				
				purchaseinward frame1 = new purchaseinward();
				frame1.frmAmElectronics.setVisible(true);
			}
		
		});
		
		
		
		JMenu mnSales = new JMenu("Sales");
		mnSales.setFont(new Font("Cambria", Font.BOLD, 15));
		menuBar.add(mnSales);
	
		
		
		
		
		
		
		JMenuItem mntmOrder_1 = new JMenuItem("Order");
		mntmOrder_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		mnSales.add(mntmOrder_1);
		mntmOrder_1.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
				
				sales frame1 = new sales();
				frame1.frmAmElectronics.setVisible(true);
			}
		
		});
		
		
		JMenuItem mntmOutward = new JMenuItem("Outward");
		mntmOutward.setFont(new Font("Tahoma", Font.BOLD, 14));
		mnSales.add(mntmOutward);
		mntmOutward.addActionListener(new ActionListener()
		{
public void actionPerformed(ActionEvent e) {
				
				sales_bill1 frame1 = new sales_bill1(0);
				frame1.frmAmElectronics.setVisible(true);
			}
		
		});
		
		
		
		
		JMenu mnReport = new JMenu("Reports");
		mnReport.setFont(new Font("Cambria", Font.BOLD, 15));
		menuBar.add(mnReport);
		
		JMenuItem mntmStockReport = new JMenuItem("Stock Report");
		mntmStockReport.setFont(new Font("Cambria", Font.BOLD, 15));
		mnReport.add(mntmStockReport);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Purchase Report");
		mntmNewMenuItem.setFont(new Font("Cambria", Font.BOLD, 15));
		mnReport.add(mntmNewMenuItem);
		
		JMenu mnSalesReport = new JMenu("Sales Report");
		mnSalesReport.setFont(new Font("Cambria", Font.BOLD, 15));
		mnReport.add(mnSalesReport);
		
		JMenuItem mntmBrandWiseSales = new JMenuItem("Brand Wise Sales");
		mntmBrandWiseSales.setFont(new Font("Cambria", Font.BOLD, 15));
		mnSalesReport.add(mntmBrandWiseSales);
		
		JMenuItem mntmDailySales = new JMenuItem("Daily Sales");
		mntmDailySales.setFont(new Font("Cambria", Font.BOLD, 15));
		mnSalesReport.add(mntmDailySales);
		
		JMenuItem mntmMonthlySales = new JMenuItem("Monthly Sales");
		mntmMonthlySales.setFont(new Font("Cambria", Font.BOLD, 15));
		mnSalesReport.add(mntmMonthlySales);
		
		JMenuItem mntmYearlySales = new JMenuItem("Yearly Sales");
		mntmYearlySales.setFont(new Font("Cambria", Font.BOLD, 15));
		mnSalesReport.add(mntmYearlySales);
		
		JMenu mnExit = new JMenu("Exit");
                JMenuItem ex1 = new JMenuItem("Exit & Close");
		mnExit.setFont(new Font("Cambria", Font.BOLD, 15));
		menuBar.add(mnExit);
                mnExit.add(ex1);
		ex1.addActionListener(new ActionListener() {
                                @Override
				public void actionPerformed(ActionEvent e) {
			
			int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?");
			if(resp == 0)
			//{
				frmAmEletronics.setVisible(false);
				frmAmEletronics.dispose();
				
				Login frame1 = new Login();
				frame1.frmAmElectronics.setVisible(true); 
				//System.exit(0);
				
			//}
			
		}
		});

	}
}

	
	
