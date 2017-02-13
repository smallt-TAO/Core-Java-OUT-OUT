package chapter11;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;

/**
 * @version 1.00
 * @author Smalltao
 *
 */
public class RobotTest {

}


/**
 * A frame to display a captured image
 */
class ImageFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
	
	/**
	 * @param image the image to diaplay.
	 */
	public ImageFrame(Image image) {
		setTitle("Capture");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		JLabel label = new JLabel(new ImageIcon(image));
		add(label);
	}
}
