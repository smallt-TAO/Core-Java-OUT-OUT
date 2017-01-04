package chapter08;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @version 1.33
 * @author Smalltao
 *
 */
public class ActionTest {
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			ActionFrame frame = new ActionFrame();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setVisible(true);
    		}
    	});
    }
}

/**
 * A frame with a panel that demonstrates color change actions.
 */
class ActionFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel buttonPanel;
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	public ActionFrame() {
		setTitle("ActionTet");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		buttonPanel = new JPanel();
		
		// define actions
		Action yellowAction = new ColorAction(
				"Yellow", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
		Action blueAction = new ColorAction(
				"Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
		Action redAction = new ColorAction(
				"Red", new ImageIcon("red-ball.gif"), Color.RED);
		
		buttonPanel.add(new JButton(yellowAction));
		buttonPanel.add(new JButton(blueAction));
		buttonPanel.add(new JButton(redAction));
		
		add(buttonPanel);
		
		InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		imap.put(KeyStroke.getKeyStroke("ctrl Y"), "panel.yellow");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.blue");
		imap.put(KeyStroke.getKeyStroke("ctrl R"), "panel.red");
		
		ActionMap amap = buttonPanel.getActionMap();
		amap.put("panel.yellow", yellowAction);
		amap.put("panel.blue", blueAction);
		amap.put("panel.red",  redAction);
	}
	
	public class ColorAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		/**
		 * Constructs a color action.
		 * @param name the name to show on the button
		 * @param icon the icon to display on the button.
		 */
		public ColorAction(String name, Icon icon, Color c) {
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name.toLowerCase());
			putValue("color", c);
		}
		
		public void actionPerformed(ActionEvent event) {
			Color c = (Color) getValue("color");
			buttonPanel.setBackground(c);
		}
	}
}
