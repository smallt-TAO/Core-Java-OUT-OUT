package chapter07;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.00
 * @author Smalltao
 *
 */
public class NotHelloWorld {
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			NotHelloWorldFrame frame = new NotHelloWorldFrame();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setVisible(true);
    		}
    	});
    }
}

/**
 * A frame that contains amessage panel
 */
class NotHelloWorldFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 300;
	
	public NotHelloWorldFrame() {
		setTitle("NotHelloWord");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		// add panel to frame
		NotHelloWorldComponent comp = new NotHelloWorldComponent();
		add(comp);
	}
}


/**
 * A component that displays a message
 */
class NotHelloWorldComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;
	
	public void paintCompoent(Graphics g) {
		g.drawString("Not a hello, World program", MESSAGE_X, MESSAGE_Y);
	}
}
