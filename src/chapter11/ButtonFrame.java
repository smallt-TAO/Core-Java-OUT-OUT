package chapter11;

import javax.swing.*;

/**
 * A frame with a button panel.
 * @version 1.00
 * @author Smalltao
 *
 */
class ButtonFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
    public ButtonFrame() {
    	setTitle("ButtonTest");
    	setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    	
    	// add panel to frame
    	ButtonPanel panel = new ButtonPanel();
    	add(panel);
    }
}
