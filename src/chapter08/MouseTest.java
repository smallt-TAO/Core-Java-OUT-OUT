package chapter08;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 * @version 1.00
 * @author Smalltao
 *
 */

public class MouseTest {

}


/**
 * A component with mouse operations for adding and removing squares.
 */
class MouseComponent extends JComponent {
	private static final int SIDELENGTH = 10;
	private ArrayList<Rectangle2D> squares;
	private Rectangle2D current;
	
	public MouseComponent() {
		squares = new ArrayList<Rectangle2D>();
		current = null;
		
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
		
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		
		// draw all sequares
		for (Rectangle2D r : squares)
			g2.draw(r);
	}
	
	/**
	 * Finds the first square containing a point.
	 * @param p a point
	 * @return the first square that contains p.
	 */
	public Rectangle2D find(Point2D p) {
		for (Rectangle2D r : squares) {
			if (r.contains(p)) return r;
		}
		return null;
	}
	
	public void add(Point2D p) {
		double x = p.getX();
		double y = p.getY();
		
		current = new Rectangle2D.Double(x - SIDELENGTH / 2, y - SIDELENGTH / 2, SIDELENGTH, SIDELENGTH);
		squares.add(current);
		repaint();
	}
	
	public void remove(Rectangle2D s) {
		if (s == null) return;
		if (s == current) current = null;
		squares.remove(s);
		repaint();
	}
	
	private class MouseHandler extends MouseAdapter {
		public void mousePressed(MouseEvent event) {
			// add a new squares if the cursor isn't inside a square.
			current = find(event.getPoint());
			if (current == null) add(event.getPoint());
		}
		
		public void mouseClicked(MouseEvent event) {
			// remove the current square if double clicked
			current = find(event.getPoint());
			if (current != null && event.getClickCount() >= 2)
				remove(current);
		}
	}
}
























