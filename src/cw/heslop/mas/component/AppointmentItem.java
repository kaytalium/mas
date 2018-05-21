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
import javax.swing.border.MatteBorder;
import java.awt.Cursor;

public class AppointmentItem extends JPanel {

	private int appointmentID;
	private int patientID; 
	public JLabel dateLabel;
	
	
	public AppointmentItem(String date, String time, String name, String doctorName, int appointmentID, int patientID) {
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		setBackground(Color.BLACK);
		setLayout(null);
		
		this.appointmentID = appointmentID;
		this.patientID = patientID;
		
		dateLabel = new JLabel();
		dateLabel.setForeground(Color.WHITE);
		dateLabel.setText("Jan 30, 18");
		
		if(date == null) {
			dateLabel.setText("");
		}else {
			dateLabel.setText(date);
		}
		
		dateLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		dateLabel.setBounds(215, 35, 56, 14);
		add(dateLabel);
		
		JLabel lblOvelHeslop = new JLabel((name == null?"John Doe":name));
		lblOvelHeslop.setForeground(Color.WHITE);
		lblOvelHeslop.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblOvelHeslop.setBounds(64, 20, 141, 14);
		add(lblOvelHeslop);
		
		JLabel lblDrGreen = new JLabel("Dr. "+(doctorName == null?"Doctor":doctorName));
		lblDrGreen.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDrGreen.setForeground(Color.WHITE);
		lblDrGreen.setBounds(64, 35, 141, 14);
		add(lblDrGreen);
		
		JLabel initials = new JLabel(initals((name == null?"John Doe":name)));
		initials.setBackground(new Color(255, 165, 0));
		initials.setForeground(Color.WHITE);
		initials.setBorder(new LineBorder(new Color(255, 165, 0)));
		initials.setFont(new Font("Tahoma", Font.PLAIN, 20));
		initials.setHorizontalTextPosition(SwingConstants.CENTER);
		initials.setHorizontalAlignment(SwingConstants.CENTER);
		initials.setBounds(8, 11, 46, 42);
		add(initials);
		
		JLabel lblTime = new JLabel((time == null?"":time));
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTime.setForeground(Color.WHITE);
		lblTime.setBounds(215, 20, 46, 14);
		add(lblTime);
		
		

	}

	public int getAppointmentID() {
		return appointmentID;
	}

	public int getPatientID() {
		return patientID;
	}

	private String initals(String name) {
		String[] s = name.split(" ");
		String ini = s[0].substring(0, 1) + s[1].substring(0, 1);
		return ini.trim();
		
	}
	
	
}
