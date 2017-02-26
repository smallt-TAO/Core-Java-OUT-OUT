package chapter11;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A panel with three buttons
 * @version 1.00
 * @author Smalltao
 *
 */
class ButtonPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
	public ButtonPanel() {
		// create buttons 
		JButton yellowButton = new JButton("Yellow");
		JButton blueButton = new JButton("Blue");
		JButton redButton = new JButton("Red");
		
		// add buttons to panel
		add(yellowButton);
		add(blueButton);
		add(redButton);
		
		// create button actions
		ColorAction yellowAction = new ColorAction(Color.YELLOW);
		ColorAction blueAction = new ColorAction(Color.BLUE);
		ColorAction redAction = new ColorAction(Color.RED);
		
		// associate actions with buttons
		yellowButton.addActionListener(yellowAction);
		blueButton.addActionListener(blueAction);
		redButton.addActionListener(redAction);
	}
	
	/**
	 * An action listener that sets the Panel's background color.
	 */
	private class ColorAction implements ActionListener {
		private Color backgroundColor;
		
		public ColorAction(Color c) {
			backgroundColor = c;
		}
		
		public void actionPerformed(ActionEvent event) {
			setBackground(backgroundColor);
		}
	}
}
