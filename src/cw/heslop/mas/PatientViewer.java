package cw.heslop.mas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cw.heslop.mas.component.WindowDragger;
import cw.heslop.mas.objects.DatabaseConnection;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;

public class PatientViewer extends JFrame {

	private JPanel contentPane;
	private DatabaseConnection dc = new DatabaseConnection("mas");
	
	private String patientID = "0";
	private JFrame parent;

	private JLabel lbl_fullname;
	private JLabel windowTitle;
	private JLabel lbl_dob;
	private JLabel lbl_contact;
	private JLabel lbl_email;
	private JLabel lbl_address;
	private JLabel lbl_city;
	private JLabel lbl_country;
	private JLabel lbl_gender;
	private JLabel lbl_age_display;
	private JLabel lbl_patientID;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientViewer frame = new PatientViewer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the frame.
	 */
	public PatientViewer() {
		setUndecorated(true);
		setResizable(false);
		setBounds(100, 100, 495, 436);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBounds(1, 1, 493, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		windowTitle = new JLabel("Personal Information");
		windowTitle.setFont(new Font("Tahoma", Font.BOLD, 12));
		windowTitle.setForeground(new Color(255, 255, 255));
		windowTitle.setBounds(5, 5, 417, 21);
		panel.add(windowTitle);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(1, 36, 493, 398);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(10, 21, 473, 354);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setForeground(Color.DARK_GRAY);
		lblPersonalInformation.setBounds(10, 11, 295, 37);
		panel_2.add(lblPersonalInformation);
		lblPersonalInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(20, 73, 75, 21);
		panel_2.add(lblNewLabel);
		
		lbl_fullname = new JLabel("Mr. John Doe");
		lbl_fullname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_fullname.setBounds(179, 73, 220, 21);
		panel_2.add(lbl_fullname);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 453, 12);
		panel_2.add(separator);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateOfBirth.setBounds(20, 94, 124, 21);
		panel_2.add(lblDateOfBirth);
		
		lbl_dob = new JLabel("September 24, 1990");
		lbl_dob.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_dob.setBounds(179, 94, 149, 21);
		panel_2.add(lbl_dob);
		
		JLabel lblMobileContact = new JLabel("Mobile Contact:");
		lblMobileContact.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMobileContact.setBounds(20, 132, 117, 21);
		panel_2.add(lblMobileContact);
		
		lbl_contact = new JLabel("1(876)978-5214");
		lbl_contact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_contact.setBounds(179, 132, 220, 21);
		panel_2.add(lbl_contact);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(20, 153, 191, 21);
		panel_2.add(lblEmail);
		
		lbl_email = new JLabel("john.doe@example.com");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_email.setBounds(179, 153, 220, 21);
		panel_2.add(lbl_email);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 216, 453, 12);
		panel_2.add(separator_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(10, 185, 295, 37);
		panel_2.add(lblAddress);
		
		JLabel lblStreetName = new JLabel("Street Name & Number:");
		lblStreetName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStreetName.setBounds(20, 219, 220, 30);
		panel_2.add(lblStreetName);
		
		lbl_address = new JLabel("1254 South Avenue Road");
		lbl_address.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_address.setBounds(208, 225, 220, 21);
		panel_2.add(lbl_address);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCity.setBounds(20, 244, 191, 21);
		panel_2.add(lblCity);
		
		lbl_city = new JLabel("Half Way Tree");
		lbl_city.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_city.setBounds(208, 240, 220, 30);
		panel_2.add(lbl_city);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCountry.setBounds(20, 260, 191, 27);
		panel_2.add(lblCountry);
		
		lbl_country = new JLabel("Jamaica");
		lbl_country.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_country.setBounds(208, 266, 220, 12);
		panel_2.add(lbl_country);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(20, 113, 124, 21);
		panel_2.add(lblGender);
		
		lbl_gender = new JLabel("Male");
		lbl_gender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_gender.setBounds(179, 113, 220, 21);
		panel_2.add(lbl_gender);
		
		JLabel lblNewLabel_1 = new JLabel("Age: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(335, 94, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		lbl_age_display = new JLabel("26");
		lbl_age_display.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_age_display.setBounds(363, 94, 46, 14);
		panel_2.add(lbl_age_display);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getParent().setEnabled(true);
				dispose();
			}
		});
		btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOk.setBorder(null);
		btnOk.setBackground(new Color(255, 165, 0));
		btnOk.setForeground(new Color(248, 248, 255));
		btnOk.setBounds(363, 302, 89, 30);
		panel_2.add(btnOk);
		
		JLabel lblPatientID = new JLabel("Patient ID: ");
		lblPatientID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPatientID.setBounds(20, 54, 75, 21);
		panel_2.add(lblPatientID);
		
		lbl_patientID = new JLabel("1452");
		lbl_patientID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_patientID.setBounds(179, 54, 220, 21);
		panel_2.add(lbl_patientID);
		
		WindowDragger windiwDragger = new WindowDragger(this);
		windiwDragger.setBounds(1, 1, 493, 35);
		contentPane.add(windiwDragger);
		
	}


	public String getPatientID() {
		return patientID;
	}


	public void setPatientID(String patientID) {
		this.patientID = patientID;
		ResultSet rs = dc.executeStatementReturnResult("Select * from person where id='"+getPatientID()+"'");
		try {
			while(rs.next()) {
				lbl_fullname.setText(rs.getString("first_name")+" "+rs.getString("last_name"));
				this.windowTitle.setText(this.windowTitle.getText()+ ": "+lbl_fullname.getText());
				lbl_dob.setText(Helper.dateFormatter("MMMM dd, yyyy",new Date(rs.getDate("dob").getTime())));
				//calculate the age based on dob 
				lbl_age_display.setText(Helper.getAge(new Date(rs.getDate("dob").getTime())).toString());
				lbl_gender.setText(rs.getString("gender"));
				lbl_contact.setText(rs.getString("contact"));
				lbl_email.setText(rs.getString("email"));
				
				//address
				lbl_address.setText(rs.getString("address"));
				lbl_city.setText(rs.getString("city"));
				lbl_country.setText(rs.getString("country"));
				lbl_patientID.setText(patientID);
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error when loading data");
		}
	}


	public JFrame getParent() {
		return parent;
	}


	public void setParent(JFrame parent) {
		this.parent = parent;
	}
}
