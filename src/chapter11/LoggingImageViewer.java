package chapter11;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.logging.*;
import javax.swing.*;

/**
 * A modification of the image viewer program that logs various events.
 * @author Smalltao
 *
 */

public class LoggingImageViewer {

}

/**
 * The frame that shows the image.
 */
class ImageViewerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private static Logger logger = Logger.getLogger("com.horstmann.corejava");
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;  
	
	public ImageViewerFrame() {
		logger.entering("ImageViewerFrame", "<init>");
		setTitle("LoggingImageViewer");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		// set up menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		
		
	}
}



/**
 * A handler for displaying log records in a window.
 */
class WindowHandler extends StreamHandler {
	private JFrame frame;
	
	public WindowHandler() {
		frame = new JFrame();
		final JTextArea output = new JTextArea();
		output.setEditable(false);
		frame.setSize(200, 200);
		frame.add(new JScrollPane(output));
		frame.setFocusableWindowState(false);
		frame.setVisible(true);
		setOutputStream(new OutputStream() {
			public void write(int b) {
				
			}
			
			public void write(byte[] b, int off, int len) {
				output.append(new String(b, off, len));
			}
		});
	}
	
	public void publish(LogRecord record) {
		if (!frame.isVisible()) return;
		super.publish(record);
		flush();
	}
}
