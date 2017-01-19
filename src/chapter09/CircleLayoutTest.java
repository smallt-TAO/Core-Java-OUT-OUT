package chapter09;

import java.awt.*;
import javax.swing.*;

/**
 * @version 1.32 2000
 * @author Smalltao
 *
 */
public class CircleLayoutTest {

}



/**
 * A layout manager that lays out components along a circle
 */
class CircleLayout implements LayoutManager {
	private int minWidth = 0;
	private int minHeight = 0;
	private int preferredWidth = 0;
	private int preferredHeight = 0;
	private boolean sizesSet = false;
	private int maxComponentWidth = 0;
	private int maxComponentHeight = 0;
	
	public void addLayoutComponent(String name, Component comp) {}
	
	public void removeLayoutComponent(Component comp) {}
	
	public void setSizes(Container parent) {
		if (sizesSet) return;
		int n = parent.getComponentCount();
		
		preferredWidth = 0;
		preferredHeight = 0;
		minWidth = 0;
		minHeight = 0;
		maxComponentWidth = 0;
		maxComponentHeight = 0;
		
		// compute the maximum component widths and heights 
		// and set the preferred size to the sum of the component sizes.
		for (int i = 0; i < n; i++) {
			Component c = parent.getComponent(i);
			if (c.isVisible()) {
				Dimension d = c.getPreferredSize();
				maxComponentWidth = Math.max(maxComponentHeight, d.width);
				maxComponentHeight = Math.max(maxComponentHeight,  d.height);
				preferredWidth += d.width;
				preferredHeight += d.height;
				
			}
		}
		minWidth = preferredWidth / 2;
		minHeight = preferredHeight / 2;
		sizesSet = true;
	}
	
	public Dimension preferredLayoutSize(Container parent) {
		setSizes(parent);
		Insets insets = parent.getInsets();
		int width = preferredWidth + insets.left + insets.right;
		int height = preferredHeight + insets.top + insets.bottom;
		return new Dimension(width, height);
	}
}





























