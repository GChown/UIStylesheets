import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GraphicsEnvironment;
import java.awt.event.*;

public class Window {

	private JFrame frame;
	private JPanel mainPanel;
	
	private JPanel namePanel;
	private JTextField nameField;
	
	private JPanel formatPanel;
	private JToolBar topToolBar;
	private JToolBar bottomToolBar;
	private JComboBox<String> fontBox;
	private JComboBox<Integer> sizeBox;
	private JToggleButton boldButton;
	private JToggleButton italicButton;
	private JToggleButton underlineButton;
	private JComboBox<String> colourBox;
	private JToggleButton alignLeftButton;
	private JToggleButton alignCentreButton;
	private JToggleButton alignRightButton;
	private JButton increaseLineSpacingButton;
	private JButton decreaseLineSpacingButton;
	private JButton increaseIndentButton;
	private JButton decreaseIndentButton;
	private JButton increaseParagraphSpacingButton;
	private JButton decreaseParagraphSpacingButton;
	
	private JEditorPane editor;
	private SpringLayout springLayout;
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
		styleSheet.addRule("p {color:" + colour + "; font-family:\"" + font + "\";}");
		editor = new JEditorPane();
		editor.setEditable(true);
		editor.setEditorKit(kit);
		editor.setText(text);
		mainPanel = new JPanel(new FlowLayout());
		
		namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameField = new JTextField(43);
		
		formatPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		topToolBar = new JToolBar();
		bottomToolBar = new JToolBar();
		fontBox = new JComboBox<String>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
		Integer[] sizes = {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 22, 
				24, 26, 28, 30, 32, 36, 40, 44, 48, 52, 56, 60, 66, 72, 80, 88, 96};
		sizeBox = new JComboBox<Integer>(sizes);
		boldButton = new JToggleButton(new ImageIcon("icons/Bold.png"));
		italicButton = new JToggleButton(new ImageIcon("icons/Italic.png"));
		underlineButton = new JToggleButton(new ImageIcon("icons/Underline.png"));
		String[] colours = {"black", "red", "orange", "yellow", "green", "blue", "purple"};
		colourBox = new JComboBox<String>(colours);
		alignLeftButton = new JToggleButton(new ImageIcon("icons/Align Left.png"));
		alignCentreButton = new JToggleButton(new ImageIcon("icons/Align Center.png"));
		alignRightButton = new JToggleButton(new ImageIcon("icons/Align Right.png"));
		increaseLineSpacingButton = new JButton(new ImageIcon("icons/Increase Line.png"));
		decreaseLineSpacingButton = new JButton(new ImageIcon("icons/Decrease Line.png"));
		increaseIndentButton = new JButton(new ImageIcon("icons/Increase Indent.png"));
		decreaseIndentButton = new JButton(new ImageIcon("icons/Decrease Indent.png"));
		increaseParagraphSpacingButton = new JButton(new ImageIcon("icons/Increase Spacing.png"));
		decreaseParagraphSpacingButton = new JButton(new ImageIcon("icons/Decrease Spacing.png"));
		
		editorScrollPane = new JScrollPane(editor);
		
		//set borders
		namePanel.setBorder(new TitledBorder(new EtchedBorder(), "Style Name"));
		formatPanel.setBorder(new TitledBorder(new EtchedBorder(), "Formatting"));
		editorScrollPane.setBorder(new TitledBorder(new EtchedBorder(), "Preview"));
		
		//set sizes
		final int subPanelWidth = 500;
		final Dimension buttonDimension = new Dimension(24, 24);
		namePanel.setPreferredSize(new Dimension(subPanelWidth, 50));
		formatPanel.setPreferredSize(new Dimension(subPanelWidth, 90));
		editorScrollPane.setPreferredSize(new Dimension(subPanelWidth, 212));
		boldButton.setPreferredSize(buttonDimension);
		italicButton.setPreferredSize(buttonDimension);
		underlineButton.setPreferredSize(buttonDimension);
		alignLeftButton.setPreferredSize(buttonDimension);
		alignCentreButton.setPreferredSize(buttonDimension);
		alignRightButton.setPreferredSize(buttonDimension);
		increaseLineSpacingButton.setPreferredSize(buttonDimension);
		decreaseLineSpacingButton.setPreferredSize(buttonDimension);
		increaseIndentButton.setPreferredSize(buttonDimension);
		decreaseIndentButton.setPreferredSize(buttonDimension);
		increaseParagraphSpacingButton.setPreferredSize(buttonDimension);
		decreaseParagraphSpacingButton.setPreferredSize(buttonDimension);
		fontBox.setPreferredSize(new Dimension(240, 24));
		sizeBox.setPreferredSize(new Dimension(50, 24));
		colourBox.setPreferredSize(new Dimension(80, 24));
		
		//add tool tips
		fontBox.setToolTipText("Font");
		sizeBox.setToolTipText("Font size");
		boldButton.setToolTipText("Bold");
		italicButton.setToolTipText("Italic");
		underlineButton.setToolTipText("Underline");
		colourBox.setToolTipText("Colour");
		alignLeftButton.setToolTipText("Align left");
		alignCentreButton.setToolTipText("Align centre");
		alignRightButton.setToolTipText("Align right");
		increaseLineSpacingButton.setToolTipText("Increase spacing between lines");
		decreaseLineSpacingButton.setToolTipText("Decrease spacing between lines");
		increaseIndentButton.setToolTipText("Increase indent");
		decreaseIndentButton.setToolTipText("Decrease indent");
		increaseParagraphSpacingButton.setToolTipText("Increase spacing between paragraphs");
		decreaseParagraphSpacingButton.setToolTipText("Decrease spacing between paragraphs");
		
		//add items to panels
		namePanel.add(nameField);
		
		topToolBar.add(fontBox);
		topToolBar.add(sizeBox);
		topToolBar.addSeparator();
		topToolBar.add(boldButton);
		topToolBar.add(italicButton);
		topToolBar.add(underlineButton);
		topToolBar.addSeparator();
		topToolBar.add(colourBox);
		bottomToolBar.add(alignLeftButton);
		bottomToolBar.add(alignCentreButton);
		bottomToolBar.add(alignRightButton);
		bottomToolBar.addSeparator();
		bottomToolBar.add(increaseLineSpacingButton);
		bottomToolBar.add(decreaseLineSpacingButton);
		bottomToolBar.addSeparator();
		bottomToolBar.add(increaseIndentButton);
		bottomToolBar.add(decreaseIndentButton);
		bottomToolBar.addSeparator();
		bottomToolBar.add(increaseParagraphSpacingButton);
		bottomToolBar.add(decreaseParagraphSpacingButton);
		formatPanel.add(topToolBar);
		formatPanel.add(bottomToolBar);
		
		mainPanel.add(namePanel);
		mainPanel.add(formatPanel);
		mainPanel.add(editorScrollPane);
		
		//add panel to frame in absolute layout to avoid resize issues
		frame.add(mainPanel);
		mainPanel.setBounds(0, 0, subPanelWidth + 10, 400);
		
		//set initial component properties
		ButtonGroup alignGroup = new ButtonGroup();
		alignGroup.add(alignLeftButton);
		alignGroup.add(alignCentreButton);
		alignGroup.add(alignRightButton);
		
		fontBox.setSelectedIndex(5);
		sizeBox.setSelectedIndex(6);
		alignLeftButton.setSelected(true);
		
		topToolBar.setFloatable(false);
		topToolBar.setOpaque(false);
		bottomToolBar.setFloatable(false);
		bottomToolBar.setOpaque(false);

		editor.setContentType("text/html");
		editor.setEditable(true);
		
		frame.setBounds(100, 100, subPanelWidth + 10, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		fontBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				String css = "<style> p { color: " + colourBox.getSelectedItem() 
						+ "; font-family: \"" + fontBox.getSelectedItem() + "\";}</style>";
			}});
		fontBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				font = (String) fontBox.getSelectedItem();
				styleSheet.addRule("p {color:" + colour + "; font-family:\"" + font + "\";}");
				updateCSS(styleSheet.toString(), editor.getText());
			}
		});
//		layout();
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
//	private void layout() {
//		frame.getContentPane().setLayout(springLayout);
//		frame.getContentPane().add(editorScrollPane);
//		editorScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        editorScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//		frame.getContentPane().add(fontSelector);
//		springLayout.putConstraint(SpringLayout.NORTH, editorScrollPane, 5, SpringLayout.SOUTH, fontSelector);
//	}
}
