package Client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.datacontract.schemas._2004._07.WebService_Models.ProductModel;
import org.datacontract.schemas._2004._07.WebService_Models.Purchase;
import org.datacontract.schemas._2004._07.WebService_Models.TransactionModel;
import org.datacontract.schemas._2004._07.WebService_Models.UserModel;
import org.tempuri.IService;
import org.tempuri.ServiceLocator;

public class Store extends JFrame implements ActionListener {

	ServiceLocator loc = new ServiceLocator();
	IService service;

	public final static String BUY_PRESSED = "BUY_PRESSED";
	public final static String REFRESH_PRESSED = "REFRESH_PRESSED";

	private JPanel panel4;
	private JPanel panel3;
	private JLabel money;
	private JList<String> leftList;
	private JList<String> rightList;

	List<Purchase> purchases = new ArrayList<Purchase>();
	List<ProductModel> products = new ArrayList<ProductModel>();
	UserModel user;

	public Store() {
		try {
			service = loc.getBasicHttpBinding_IService();
			user = service.getUserById(LoginRegister.gebruiker.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel p = new JPanel();
		setContentPane(p);
		p.setLayout(new GridLayout(1, 2));
		leftPanel();
		rightPanel();

		p.add(panel4);
		p.add(panel3);
		setSize(700, 350);
		setVisible(true);
	}

	public void leftPanel() {
		panel4 = new JPanel();
		panel4.setLayout(null);

		panel4.setSize(350, 350);

		JLabel inventory = new JLabel("Inventory:");
		inventory.setBounds(40, 10, 100, 100);
		panel4.add(inventory);

		money = new JLabel("Money:" + user.getFunds());
		money.setBounds(40, 140, 100, 100);
		panel4.add(money);

		leftList = new JList<String>(refreshInventory());

		leftList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent le) {
				try {
					if (!le.getValueIsAdjusting()) {
						int index = leftList.getSelectedIndex();
						if (purchases.get(index).getAmount() > 1) {
							purchases.get(index).setAmount(purchases.get(index).getAmount() - 1);
						} else {
							purchases.remove(index);
						}

						leftList.clearSelection();
						refreshAll();
					}
				} catch (Exception e) {
				}
			}
		});

		JScrollPane leftScroll = new JScrollPane(leftList);
		leftScroll.setBounds(40, 80, 250, 100);
		panel4.add(leftScroll);
	}

	public void rightPanel() {
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel4.setSize(350, 350);

		JLabel winkel = new JLabel("Winkel:");
		winkel.setBounds(40, 10, 100, 100);
		panel3.add(winkel);

		JButton btn3 = new JButton("Refresh");
		btn3.setBounds(210, 185, 80, 23);
		panel3.add(btn3);
		btn3.addActionListener(this);
		btn3.setActionCommand(REFRESH_PRESSED);

		JButton btn4 = new JButton("Buy");
		btn4.setBounds(120, 185, 80, 23);
		panel3.add(btn4);
		btn4.addActionListener(this);
		btn4.setActionCommand(BUY_PRESSED);

		rightList = new JList<String>(refreshProducts());

		rightList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent le) {
				try {
					if (!le.getValueIsAdjusting()) {
						int index = rightList.getSelectedIndex();
						if (purchases.stream().filter(x -> x.getProductId() == products.get(index).getId())
								.count() == 0) {
							purchases.add(new Purchase(products.get(index).getId(), products.get(index).getName(), 1));
						} else {
							Purchase p = purchases.stream().filter(x -> x.getProductId() == products.get(index).getId())
									.findFirst().get();
							p.setAmount(p.getAmount() + 1);
						}

						rightList.clearSelection();
						refreshAll();
					}
				} catch (Exception e) {
				}
			}
		});

		JScrollPane rightScroll = new JScrollPane(rightList);
		rightScroll.setBounds(40, 80, 250, 100);
		panel3.add(rightScroll);
	}

	private void refreshAll() {
		try {
			user = service.getUserById(LoginRegister.gebruiker.getId());
			rightList.setModel(refreshProducts());
			leftList.setModel(refreshInventory());
			money.setText("Money:" + user.getFunds());
		} catch (RemoteException e) {
		}
	}

	private DefaultListModel refreshInventory() {
		DefaultListModel<String> listModel = new DefaultListModel<String>();

		purchases.forEach(x -> listModel.addElement("Product: " + x.getName() + " | Aantal: " + x.getAmount()));

		return listModel;
	}

	private DefaultListModel refreshProducts() {
		try {
			products = new ArrayList<ProductModel>();
			for (ProductModel product : service.getAllProducts()) {
				products.add(product);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}

		DefaultListModel<String> listModel = new DefaultListModel<String>();

		products.forEach(x -> listModel.addElement(x.getName() + ", voorraad: "
				+ (x.getCurrentStock() - ((purchases.stream().filter(y -> y.getProductId() == x.getId()).count() == 1)
						? (purchases.stream().filter(y -> y.getProductId() == x.getId()).findFirst().get().getAmount())
						: 0))
				+ " - prijs: " + x.getPrice()));

		return listModel;
	}

	private int[] convertIntegerList(ArrayList<Integer> al) {
		int[] result = new int[al.size()];

		for (int i = 0; i < al.size(); i++) {
			result[i] = al.get(i);
		}

		return result;
	}

	private Boolean purchase() {
		if (purchases.size() == 0) {
			return false;
		}

		ArrayList<Integer> productIds = new ArrayList<Integer>();
		ArrayList<Integer> productAmounts = new ArrayList<Integer>();

		purchases.forEach(x -> {
			productIds.add(x.getProductId());
			productAmounts.add(x.getAmount());
		});

		TransactionModel success = null;
		try {
			success = service.createNewTransaction(user.getId(), convertIntegerList(productIds),
					convertIntegerList(productAmounts));
		} catch (RemoteException e) {
		}

		return success != null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(REFRESH_PRESSED)) {
			refreshAll();
		} else if (e.getActionCommand().equals(BUY_PRESSED)) {
			if (purchase()) {
				purchases = new ArrayList<Purchase>();
				refreshAll();
			}
		}

	}

	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Store window = new Store();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
