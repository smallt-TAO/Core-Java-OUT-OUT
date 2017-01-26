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
	public ColorChooserPanel() {
		JButton modalButton = new JButton("Modal");
		modalButton.addActionListener(new ModalListener());
		add(modalButton);
		
		JButton modelessButton = new JButton("modeless");
		modelessButton.addActionListener(new ModelessListener());
		add(modelessButton);
		
		JButton immediateButton = new JButton("Immediate");
		immediateButton.addActionListener(new ImmediateListener());
		add(immediateButton);
	}
	
	/**
	 * This listener pops up a modal color chooser
	 */
	private class ModalListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Color defaultColor = getBackground();
			Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "Set background", defaultColor);
			if (selected != null) setBackground(selected);
		}
	}
	/**
	 * This listaner pops up a modeless color chooser. The panel color is changed
	 * when the user clicks the Ok button.
	 */
	private class ModelessListener implements ActionListener {
		private JDialog dialog;
		private JColorChooser chooser;
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


























