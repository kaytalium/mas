import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WindowDragger extends JLabel implements MouseListener, MouseMotionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3407403738699155972L;
	private int xMouse;
	private int yMouse;
	private JFrame frame;
	
	public WindowDragger(JFrame frame) {
		super();
		this.frame = frame;
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
	}

	public WindowDragger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WindowDragger(Icon image, int horizontalAlignment) {
		super(image, horizontalAlignment);
		// TODO Auto-generated constructor stub
		
	}

	public WindowDragger(Icon image) {
		super(image);
		// TODO Auto-generated constructor stub
	}

	public WindowDragger(String text, Icon icon, int horizontalAlignment) {
		super(text, icon, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public WindowDragger(String text, int horizontalAlignment) {
		super(text, horizontalAlignment);
		// TODO Auto-generated constructor stub
	}

	public WindowDragger(String text) {
		super(text);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		
		setCurrentLocation(x - xMouse,y - yMouse);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		xMouse = e.getX();
		yMouse = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	protected void setCurrentLocation(int x, int y) {
		// TODO Auto-generated method stub
		frame.setLocation(x, y);
	}

	
	
}
