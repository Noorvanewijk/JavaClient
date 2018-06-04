package Client;

import java.awt.EventQueue;

public class Launch {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				LoginRegister frame = new LoginRegister();
				frame.setVisible(true);
			}
		});
	}
}