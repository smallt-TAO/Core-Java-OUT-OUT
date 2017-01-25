package chapter09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @version 1.00
 * @author Smalltao
 *
 */
public class ColorChooserTest {

}

/**
 * A frame with a color chooser panel.
 */
class ColorChooserFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	public ColorChooserFrame() {
		setTitle("ColorChooserTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		// add color chooser panel to frame
		ColorChooserPanel panel = new ColorChooserPanel();
		add(panel);
	}
}


/**
 * A panel with buttons to pop up three types of color choosers.
 */
class ColorChooserPanel extends JPanel {
	private JDialog dialog;
	private JColorChooser chooser;
	
	/**
	 * This listaner pops up a modeless color chooser. The panel color is changed
	 * when the user clicks the Ok button.
	 */
	private class ModelessListener implements ActionListener {
		public ModelessListener() {
			chooser = new JColorChooser();
			dialog = JColorChooser.createDialog(ColorChooserPanel.this, 
					"Background Color", false, 
					chooser, new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					setBackground(chooser.getColor());
				}
			}, null);
			
		}
	
	    public void actionPerformed(ActionEvent event) {
		    chooser.setColor(getBackground());
		    dialog.setVisible(true);
	    }
	}
}


























