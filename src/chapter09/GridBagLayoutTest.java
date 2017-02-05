package chapter09;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @version 1.00
 * @author Smalltao
 *
 */
public class GridBagLayoutTest {
    public static void main(String[] args) {
    	EventQueue.invokeLater(new Runnable() {
    		public void run() {
    			FontFrame0 frame = new FontFrame0();
    			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			frame.setVisible(true);
    		}
    	});
    }
}


/**
 * A frame that uses a grid layout to arrange font selection components.
 */
class FontFrame0 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	
	private JComboBox<?> face;
	private JComboBox<?> size;
	private JCheckBox bold;
	private JCheckBox italic;
	private JTextArea sample;
	
	public FontFrame0() {
		setTitle("GridBagLayoutTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		ActionListener listener = new FontAction();
		
		// construct components
		JLabel faceLabel = new JLabel("Face: ");
		face = new JComboBox<Object>(new String[] {"Serif", "Sanserif", "Monospaced", "Dialog", "DiaogInput"});
		face.addActionListener(listener);
		
		JLabel sizeLabel = new JLabel("Size: ");
		size = new JComboBox<Object>(new String[] {"8", "10", "12", "15", "18", "36"});
		size.addActionListener(listener);
		
		bold = new JCheckBox("Bold");
		bold.addActionListener(listener);
		italic = new JCheckBox("Italic");
		italic.addActionListener(listener);
		
		sample = new JTextArea();
		sample.setText("The quick brown fox jumps over the lazy dog");
		sample.setEditable(false);
		sample.setLineWrap(true);
		sample.setBorder(BorderFactory.createEtchedBorder());
		
		// add component to grid, using GBC convenience class
		add(faceLabel, new GBC(0, 0).setAnchor(GBC.EAST));
		add(face, new GBC(1, 0).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
		add(sizeLabel, new GBC(0, 1).setAnchor(GBC.EAST));
		add(size, new GBC(1, 1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
		add(bold, new GBC(0, 2, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
		add(italic, new GBC(0, 3, 2, 1).setAnchor(GBC.CENTER).setWeight(100, 100));
		add(sample, new GBC(2, 0, 1, 4).setFill(GBC.BOTH).setWeight(100, 100));
	}
	
	/**
	 * An action listener that changes the font of the sample text.
	 */
	private class FontAction implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			String fontFace = (String) face.getSelectedItem();
			int fontStyle = (bold.isSelected() ? Font.BOLD : 0) + (italic.isSelected() ? Font.ITALIC : 0);
			int fontSize = Integer.parseInt((String) size.getSelectedItem());
			Font font = new Font(fontFace, fontStyle, fontSize);
			sample.setFont(font);
			sample.repaint();
			
		}
	}
}
