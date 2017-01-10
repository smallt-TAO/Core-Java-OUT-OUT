package chapter09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator {

}


/**
 * A frame with a calculator panel.
 */
class CalculatorFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CalculatorFrame() {
		setTitle("Calculator");
		CalculatorPanel panel = new CalculatorPanel();
		add(panel);
		pack();
	}
}


/**
 * A panel with calculator buttons and a result display.
 */
class CalculatorPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton display;
	private JPanel panel;
	private double result;
	private String lastCommand;
	private boolean start;
	
	public CalculatorPanel() {
		setLayout(new BorderLayout());
		
		result = 0;
		lastCommand = "=";
		start = true;
		
		// add the display
		
	}
}






















