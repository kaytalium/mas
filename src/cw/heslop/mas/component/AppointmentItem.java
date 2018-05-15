package cw.heslop.mas.component;
import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.swing.border.LineBorder;

import cw.heslop.mas.Helper;
import javax.swing.SwingConstants;

public class AppointmentItem extends JPanel {

	/**
	 * Create the panel.
	 */
	public JLabel dateLabel;  
	public AppointmentItem(String date, String name, String doctorName) {
		setBorder(new LineBorder(new Color(192, 192, 192)));
		setBackground(new Color(240, 248, 255));
		setLayout(null);
		
		dateLabel = new JLabel();
		dateLabel.setText("January 30 2018");
		
		if(date == null) {
			dateLabel.setText(Helper.getCurrentDate("MMM dd, yyyy"));
		}else {
			dateLabel.setText(date);
		}
		
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		dateLabel.setBounds(64, 42, 112, 14);
		add(dateLabel);
		
		JLabel lblOvelHeslop = new JLabel((name == null?"John Doe":name));
		lblOvelHeslop.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOvelHeslop.setBounds(64, 11, 112, 14);
		add(lblOvelHeslop);
		
		JLabel lblDrGreen = new JLabel("Dr. "+(doctorName == null?"Doctor":doctorName));
		lblDrGreen.setBounds(64, 27, 141, 14);
		add(lblDrGreen);
		
		JLabel initials = new JLabel(initals((name == null?"John Doe":name)));
		initials.setBorder(new LineBorder(new Color(0, 0, 0)));
		initials.setFont(new Font("Tahoma", Font.PLAIN, 20));
		initials.setHorizontalTextPosition(SwingConstants.CENTER);
		initials.setHorizontalAlignment(SwingConstants.CENTER);
		initials.setBounds(8, 12, 46, 44);
		add(initials);

	}

	private String initals(String name) {
		String[] s = name.split(" ");
		String ini = s[0].substring(0, 1) + s[1].substring(0, 1);
		return ini.trim();
		
	}
}
