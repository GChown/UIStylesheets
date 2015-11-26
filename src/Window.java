import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class Window {

	private JFrame frame;
	private JEditorPane editor;
	private SpringLayout springLayout;
	private JComboBox fontSelector;
	private JScrollPane editorScrollPane;
	private String text;
	private String font;
	private String colour;
	private HTMLEditorKit kit;
	private StyleSheet styleSheet;

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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Stylesheet editor");
		frame.setLocationRelativeTo(null);
		frame.setBounds(100, 100, 450, 300);
		// We're using SpringLayout - only add elements here, making it look
		// good happens in layout().
		springLayout = new SpringLayout();
		colour = "blue";
		kit = new HTMLEditorKit();
		styleSheet = kit.getStyleSheet();
		//TODO: fix scrolling, make everything not go off the side of the screen!
		text = "<p>Hello there I'm going to try to make this as long as possible so it goes off the edge"
				+ "of the wrong thing! hashasoifuhqwieufhjiqwuehjfiquhj</p>";
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		fontSelector = new JComboBox(fonts);
		fontSelector.setSelectedIndex(5); font = (String) fontSelector.getSelectedItem();
		styleSheet.addRule("p {color:" + colour + "; font-family:\"" + font + "\";}");
		System.out.println("p {color:" + colour + "; font-family:\"" + font + "\";}");
		editor = new JEditorPane();
		editor.setEditable(true);
		editor.setEditorKit(kit);
		editor.setText(text);

		editorScrollPane = new JScrollPane(editor);
		fontSelector.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				font = (String) fontSelector.getSelectedItem();
				styleSheet.addRule("p {color:" + colour + "; font-family:\"" + font + "\";}");
				updateCSS(styleSheet.toString(), editor.getText());
			}
		});
		layout();
	}

	/**
	 * Updates CSS with values.
	 * 
	 * @param css
	 * @param text
	 */
	private void updateCSS(String css, String text) {
		styleSheet.addRule(css);
		editor.setText(text);
	}

	/**
	 * Makes things look good in the layout- anything not related to functionality.
	 */
	private void layout() {
		frame.getContentPane().setLayout(springLayout);
		frame.getContentPane().add(editorScrollPane);
		editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		frame.getContentPane().add(fontSelector);
		springLayout.putConstraint(SpringLayout.NORTH, editorScrollPane, 5, SpringLayout.SOUTH, fontSelector);
	}
}
