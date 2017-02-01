package chapter07;

import java.awt.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

/**
 * @version 1.00
 * @author Smalltao
 *
 */
public class ImageTest {
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			ImageFrame frame = new ImageFrame();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setVisible(true);
    		}
    	});
    }
}

/**
 * A frame with an image component
 */
class ImageFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;
	
	public ImageFrame() {
		setTitle("ImageTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		ImageComponent component = new ImageComponent();
		add(component);
	}
}

/**
 * A component that display a tiled timage
 */
class ImageComponent extends JComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image image;
	
	public ImageComponent() {
		// acquire the image
		try {
			image = ImageIO.read(new File("blue-ball.gif"));
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintCompoent(Graphics g) {
		if (image == null) return;
		
		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);
		
		// draw the image in the upper-left corner
		g.drawImage(image, 0, 0, null);
		
		// tile the image across the component
		for (int i = 0; i * imageWidth <= getWidth(); i++) {
			for (int j = 0; j * imageHeight <= getHeight(); j++) {
				if (i + j > 0) 
					g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);;
			}
		}
	}
}
