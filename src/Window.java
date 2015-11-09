import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPasswordField;
import javax.swing.JTable;


public class Window {

	private JFrame frame;

	/**
	 * Don't worry about this stuff
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Don't worry about this either
	 */
	public Window() {
		initialize();
	}

	/**
	 * Put your code in here!
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//We're using SpringLayout - edit from the Design tab
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
	}
}
