import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

public class PatientViewer extends JFrame {

	private JPanel contentPane;
	private JLabel lbl_fullname;
	public String patientID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientViewer frame = new PatientViewer("1");
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
	public PatientViewer(String PID) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 815, 532);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//connect to database and get info to populate view 
		DatabaseConnection dc = new DatabaseConnection("mas");
		
		ResultSet rs = dc.executeStatementReturnResult("Select * from person where id='"+PID+"'");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 809, 83);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 82, 799, 411);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(27, 0, 519, 400);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setBounds(10, 11, 295, 37);
		panel_2.add(lblPersonalInformation);
		lblPersonalInformation.setFont(new Font("Tahoma", Font.BOLD, 26));
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(20, 50, 75, 30);
		panel_2.add(lblNewLabel);
		
		lbl_fullname = new JLabel("Mr. John Doe");
		lbl_fullname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_fullname.setBounds(179, 52, 220, 30);
		panel_2.add(lbl_fullname);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 462, 21);
		panel_2.add(separator);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(20, 80, 124, 30);
		panel_2.add(lblDateOfBirth);
		
		JLabel lbl_dob = new JLabel("September 24, 1990");
		lbl_dob.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_dob.setBounds(179, 82, 149, 30);
		panel_2.add(lbl_dob);
		
		JLabel lblMobileContact = new JLabel("Mobile Contact:");
		lblMobileContact.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMobileContact.setBounds(20, 150, 191, 30);
		panel_2.add(lblMobileContact);
		
		JLabel lbl_contact = new JLabel("1(876)978-5214");
		lbl_contact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_contact.setBounds(179, 152, 220, 30);
		panel_2.add(lbl_contact);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(20, 180, 191, 30);
		panel_2.add(lblEmail);
		
		JLabel lbl_email = new JLabel("john.doe@example.com");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_email.setBounds(179, 182, 220, 30);
		panel_2.add(lbl_email);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 258, 462, 12);
		panel_2.add(separator_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblAddress.setBounds(10, 221, 295, 37);
		panel_2.add(lblAddress);
		
		JLabel lblStreetName = new JLabel("Street Name & Number:");
		lblStreetName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStreetName.setBounds(20, 271, 220, 30);
		panel_2.add(lblStreetName);
		
		JLabel lbl_address = new JLabel("1254 South Avenue Road");
		lbl_address.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_address.setBounds(252, 273, 220, 30);
		panel_2.add(lbl_address);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCity.setBounds(20, 304, 191, 30);
		panel_2.add(lblCity);
		
		JLabel lbl_city = new JLabel("Half Way Tree");
		lbl_city.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_city.setBounds(252, 306, 220, 30);
		panel_2.add(lbl_city);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCountry.setBounds(20, 341, 191, 30);
		panel_2.add(lblCountry);
		
		JLabel lbl_country = new JLabel("Jamaica");
		lbl_country.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_country.setBounds(252, 343, 220, 30);
		panel_2.add(lbl_country);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGender.setBounds(20, 109, 124, 30);
		panel_2.add(lblGender);
		
		JLabel lbl_gender = new JLabel("Male");
		lbl_gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_gender.setBounds(179, 111, 220, 30);
		panel_2.add(lbl_gender);
		
		JLabel lblNewLabel_1 = new JLabel("Age: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(335, 93, 46, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel lbl_age_display = new JLabel("26");
		lbl_age_display.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbl_age_display.setBounds(362, 93, 46, 14);
		panel_2.add(lbl_age_display);
		
		try {
			while(rs.next()) {
				lbl_fullname.setText(rs.getString("title")+" "+rs.getString("first_name")+" "+rs.getString("last_name"));
				lbl_dob.setText(DateConverter.dateFormatter("MMMM dd, yyyy",new Date(rs.getDate("dob").getTime())));
				//calculate the age based on dob 
				lbl_age_display.setText(DateConverter.getAge(new Date(rs.getDate("dob").getTime())).toString());
				lbl_gender.setText(rs.getString("gender"));
				lbl_contact.setText(rs.getString("contact"));
				lbl_email.setText(rs.getString("email"));
				
				//address
				lbl_address.setText(rs.getString("address"));
				lbl_city.setText(rs.getString("city"));
				lbl_country.setText(rs.getString("country"));
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
