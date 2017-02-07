package chapter09;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

/**
 * @version 1.00
 * @author Smalltao
 *
 */
public class OptionDialogTest {

}


/**
 * A frame that contains setting for selecting various option dialogs.
 */
class OptionDialogFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	private ButtonPanel typePanel;
	private ButtonPanel messagePanel;
	private ButtonPanel messageTypePanel;
	private ButtonPanel optionTypePanel;
	private ButtonPanel optionsPanel;
	private ButtonPanel inputPanel;
	
	private String messageString = "Message";
	private Icon messageIcon = new ImageIcon("blue-bal.gif");
	private Object messageObject = new Date();
	private Component messageComponent = new SampleComponent();
	
	
}


/**
 * A component with a painted surface.
 */
class SampleComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D rect = new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1);
		g2.setPaint(Color.YELLOW);
		g2.fill(rect);
		g2.setPaint(Color.BLUE);
		g2.draw(rect);
	}
	
	public Dimension getPreferredSize() {
		return new Dimension(10, 10);
	}
}
