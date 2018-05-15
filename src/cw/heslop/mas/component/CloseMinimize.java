package cw.heslop.mas.component;
import javax.swing.JPanel;

import cw.heslop.mas.objects.CloseMinimizeIcon;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CloseMinimize extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5949207506619887642L;
	private JLabel label;
	private JFrame frame;
	private int button;
	private int closeOption;
	private JFrame navigateToView;
	/**
	 * Create the panel.
	 */
	public CloseMinimize(JFrame frame) {
		setAutoscrolls(true);
		setBounds(0, 0, 31, 32);
		this.setOpaque(false);
		setLayout(null);
		this.frame = frame; 
		label = new JLabel("");
		label.setBackground(new Color(255, 0, 0));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(button == CloseMinimizeIcon.Close) {
					closeBackground();	
				}
				
				if(button == CloseMinimizeIcon.Minimize) {
					minimizeBackground();
				}
								
			}
			@Override
			public void mouseExited(MouseEvent e) {
				removeBackground();
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if(button == CloseMinimizeIcon.Close) {
					switch(closeOption) {
					case JFrame.DISPOSE_ON_CLOSE:
						frame.dispose();
						navigateToView.setVisible(true);
					break;
					case JFrame.EXIT_ON_CLOSE:
						System.exit(0);
					}
				}
				
				if(button == CloseMinimizeIcon.Minimize) {
					frame.setState(Frame.ICONIFIED);
				}
				
			}
		});
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setBounds(0, 0, 33, 26);
		add(label);
		
		

	}
	
	private void closeBackground() {
		this.setOpaque(true);
		this.setBackground(new Color(255,51,51));
	}
	
	private void minimizeBackground() {
		this.setOpaque(true);
		this.setBackground(new Color(204,230,255));
	}
	
	private void removeBackground() {
		this.setOpaque(false);
		this.setBackground(null);
	}
	

	public void setButton(int button) {
		// TODO Auto-generated method stub
		this.button = button;
		if(button==CloseMinimizeIcon.Close) {
			label.setIcon(new ImageIcon(CloseMinimize.class.getResource("/icons/icons8_Multiply_32px.png")));
		}
		
		if(button==CloseMinimizeIcon.Minimize) {
			label.setIcon(new ImageIcon(CloseMinimize.class.getResource("/icons/icons8_Subtract_32px.png")));
		}
	}

	public int getCloseOption() {
		return closeOption;
	}

	public void setCloseOption(int closeOption) {
		this.closeOption = closeOption;
	}

	public JFrame getNavigateToView() {
		return navigateToView;
	}

	public void setNavigateToView(JFrame navigateToView) {
		this.navigateToView = navigateToView;
	}

}
