package chapter06;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.Timer;

/**
 * This program demonstrates the use of inner classces.
 * @author Smalltao
 *
 */
public class InnerClassTest {
    public static void main(String[] args) {
    	TalkingClock01 clock = new TalkingClock01(1000, true);
    	clock.start();
    	
    	// keep program running util user selects "ok"
    	JOptionPane.showMessageDialog(null, "Quit program?");
    	System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock01 {
	private int interval;
	private boolean beep;
	
	public TalkingClock01(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}
	
	/**
	 * Starts the clock.
	 */
	public void start() {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}
	
	public class TimePrinter implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Date now = new Date();
			System.out.println("At the tone, the time is " + now);
			if (beep) Toolkit.getDefaultToolkit().beep();
		}
	}
}
