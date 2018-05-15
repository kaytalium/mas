package cw.heslop.mas.component;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class Arrow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1881412387101197272L;
	TriangleShape triangleShape;
	
	public Arrow() {
		 triangleShape = new TriangleShape(new Point2D.Double(0, 381),
			        new Point2D.Double(0, 0), new Point2D.Double(40,190));
	}
	
	@Override
	  public Dimension getPreferredSize() {
	    return new Dimension(180, 381);
	  }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g.create();

	    g2d.setColor(new Color(255, 255, 255));
	    g2d.translate(0,0);
	    g2d.fill(triangleShape);
	    g2d.dispose();
	}

}
