package Client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.datacontract.schemas._2004._07.WebService_Models.UserModel;
import org.tempuri.BasicHttpBinding_IServiceStub;
import org.tempuri.IService;
import org.tempuri.ServiceLocator;

public class LoginRegister extends JFrame implements ActionListener {

	ServiceLocator loc = new ServiceLocator();
	IService service;

	public final static String REGISTER_PRESSED = "REGISTER_PRESSED";
	public final static String LOGIN_PRESSED = "LOGIN_PRESSED";
	public static UserModel gebruiker;

	private JPanel panel1;
	private JPanel panel2;
	
	JTextField username;
	JTextField txuser;
	JPasswordField pass;

	public LoginRegister() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 458, 287);
		setTitle("Beginscherm");

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		getContentPane().add(mainPanel);

		itemTabPanel1();
		itemTabPanel2();

		JTabbedPane tabPane = new JTabbedPane();
		tabPane.addTab("Login", panel1);
		tabPane.addTab("Registreer", panel2);
		mainPanel.add(tabPane);

		try {
			service = loc.getBasicHttpBinding_IService();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void itemTabPanel1() {
		panel1 = new JPanel();
		panel1.setLayout(null);

		JLabel welcome = new JLabel("Hallo, login aub (:");
		welcome.setBounds(170, 10, 150, 60);
		panel1.add(welcome);

		txuser = new JTextField(15);
		txuser.setBounds(140, 65, 150, 20);
		panel1.add(txuser);

		pass = new JPasswordField(15);
		pass.setBounds(140, 100, 150, 20);
		panel1.add(pass);

		JButton btn1 = new JButton("Login");
		btn1.setBounds(170, 125, 89, 23);
		panel1.add(btn1);
		btn1.addActionListener(this);
		btn1.setActionCommand(LOGIN_PRESSED);
	}

	public void itemTabPanel2() {
		panel2 = new JPanel();
		panel2.setLayout(null);

		JLabel regi = new JLabel("Geef een username pls");
		regi.setBounds(150, 10, 150, 60);
		panel2.add(regi);

		username = new JTextField(15);
		username.setBounds(140, 65, 150, 20);
		panel2.add(username);

		JLabel regi2 = new JLabel("Dan krijg je wachtwoord");
		regi2.setBounds(150, 70, 150, 60);
		panel2.add(regi2);

		JButton btn2 = new JButton("Registreer");
		btn2.setBounds(160, 125, 100, 23);
		panel2.add(btn2);
		btn2.addActionListener(this);
		btn2.setActionCommand(REGISTER_PRESSED);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals(REGISTER_PRESSED)) {
			String newuser = username.getText();
			
			try {
				UserModel regigebruiker = service.registerUser(newuser);
				if (regigebruiker == null) {
					JOptionPane.showMessageDialog(null, "Deze gebruiker bestaat al!", "Failure", 1);
				} else {
					JOptionPane.showMessageDialog(null,
							"Gebruiker: " + regigebruiker.getUsername() + " gemaakt met wachtwoord: " + regigebruiker.getPassword(),
							"Success", 1);
				}
				
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
			
		} else if (e.getActionCommand().equals(LOGIN_PRESSED)) {
			
			try {
				gebruiker = service.loginUser(txuser.getText(), pass.getText());
				if (gebruiker != null) {
					Store store = new Store();
					store.NewScreen();
				} else {
					JOptionPane.showMessageDialog(null, "Gebruikersnaam of wachtwoord klopt niet", "Failure", 1);
				}
				
			} catch (RemoteException e1) {
				e1.printStackTrace();
			}
		}

	}
}