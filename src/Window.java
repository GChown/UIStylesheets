import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;

public class Window {

	private JFrame frame;
	private JEditorPane editor;
	private SpringLayout springLayout;
	private JComboBox fontSelector;
	private	JScrollPane editorScrollPane;
	private String font;
	private int size;
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
        String color = "purple";
	String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	fontSelector = new JComboBox(fonts);
	fontSelector.setSelectedIndex(5);
	font = (String)fontSelector.getSelectedItem();
        String css = "<style> p { color: " + color + "; font-family: \"" + font + "\";}</style>";
	System.out.println("CSS: " + css);
	String text = "Hello, this is a test";
	frame = new JFrame();
        editor = new JEditorPane("text/html", css + "<p>" + text + "</p>");
	editor.setEditable(true);
        editorScrollPane = new JScrollPane(editor);
	frame.setBounds(100, 100, 450, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Stylesheet editor");
	//We're using SpringLayout - edit from the Design tab
	 springLayout = new SpringLayout();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	fontSelector.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			String css = "<style> p { color: " + color + "; font-family: \"" + fontSelector.getSelectedItem() + "\";}</style>";
			System.out.println("CSS is " + css);
					     }});
	layout();
	}

	private void updateCSS(String css, String text){

	}
	/**
	 * Updates the layout
	 * */
	private void layout(){
	frame.getContentPane().setLayout(springLayout);
        frame.getContentPane().add(editor);
	frame.getContentPane().add(fontSelector);
	springLayout.putConstraint(SpringLayout.NORTH, editor, 5, SpringLayout.SOUTH, fontSelector);
	}
}
