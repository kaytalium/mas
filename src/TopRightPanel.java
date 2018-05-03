import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

public class TopRightPanel extends JPanel {

	TriangleShape triangleShape;
	Polygon poly;
	/**
	 * Create the panel.354 327
	 */
	public TopRightPanel() {
		 triangleShape = new TriangleShape(new Point2D.Double(459, 383),
			        new Point2D.Double(0, 0), new Point2D.Double(459,0));
	}
	
	@Override
	  public Dimension getPreferredSize() {
	    return new Dimension(400, 400);
	  }
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g.create();

	    g2d.setColor(new Color(255, 165, 0));
	    g2d.translate(0,0);
	    g2d.fill(triangleShape);
	    g2d.dispose();
	}

}

class TriangleShape extends Path2D.Double {
	  public TriangleShape(Point2D... points) {
	    moveTo(points[0].getX(), points[0].getY());
	    lineTo(points[1].getX(), points[1].getY());
	    lineTo(points[2].getX(), points[2].getY());
	    closePath();
	  }
	}
