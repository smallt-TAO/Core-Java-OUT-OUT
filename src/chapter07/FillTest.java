package chapter07;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * @version 1.00
 * @author Smalltao
 *
 */
public class FillTest {
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			FillFrame frame = new FillFrame();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setVisible(true);
    		}
    	});
    }
}

/**
 * A frame that contains a component with drawings
 */
class FillFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;
	
	public FillFrame() {
	    setTitle("FillTet");
	    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
	    
	    // add component to frame
	    FillComponent component = new FillComponent();
	    add(component);
	}
}

/**
 * A component that displays filled rectangles and ellipses.
 */
class FillComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		// draw a rectangle
		double leftX = 100;
		double topY = 100;
		double width = 200;
		double height = 150;
		
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
		g2.setPaint(Color.RED);
		g2.fill(rect);
		
		// draw the enclosed ellipse
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.setPaint(new Color(0, 128, 128));
		g2.fill(ellipse);
	}
}
