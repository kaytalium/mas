package cw.heslop.mas;

import javax.swing.JPanel;
import cw.heslop.mas.component.AppointmentItem;
import cw.heslop.mas.objects.AppointmentObj;
import cw.heslop.mas.objects.DatabaseConnection;
import cw.heslop.mas.objects.Person;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JSeparator;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class PatientViewer extends JPanel {

	private DatabaseConnection dc = new DatabaseConnection("mas");
	private String patientID = "0";
	private MainView parent;
	private AppointmentItem[] appointments;
	private JLabel lbl_fullname;
	private JLabel lbl_dob;
	private JLabel lbl_contact;
	private JLabel lbl_email;
	private JLabel lbl_address;
	private JLabel lbl_city;
	private JLabel lbl_country;
	private JLabel lbl_gender;
	private JLabel lbl_age_display;
	private JLabel lbl_patientID;
	private JLabel lbl_doctorName;
	private JLabel lbl_app_time;
	private JLabel lbl_app_date;
	private JTextArea txtrRemarks;
	private JLabel lbl_service;
	private JLabel lbl_app_edit;
	public AppointmentObj mostRecentAppointment = null;
	private Person person;

	
	public PatientViewer() {
//		setBounds(0, 0, 616, 541);
		setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 616, 553);
		add(panel_2);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		
		JLabel lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setForeground(Color.DARK_GRAY);
		lblPersonalInformation.setBounds(10, 11, 220, 37);
		panel_2.add(lblPersonalInformation);
		lblPersonalInformation.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel lblNewLabel = new JLabel("Name: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(20, 73, 75, 21);
		panel_2.add(lblNewLabel);
		
		lbl_fullname = new JLabel("Mr. John Doe");
		lbl_fullname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_fullname.setBounds(179, 73, 220, 21);
		panel_2.add(lbl_fullname);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 46, 389, 12);
		panel_2.add(separator);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth:");
		lblDateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDateOfBirth.setBounds(20, 94, 124, 21);
		panel_2.add(lblDateOfBirth);
		
		lbl_dob = new JLabel("September 24, 1990");
		lbl_dob.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_dob.setBounds(179, 94, 149, 21);
		panel_2.add(lbl_dob);
		
		JLabel lblMobileContact = new JLabel("Mobile Contact:");
		lblMobileContact.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMobileContact.setBounds(20, 132, 117, 21);
		panel_2.add(lblMobileContact);
		
		lbl_contact = new JLabel("1(876)978-5214");
		lbl_contact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_contact.setBounds(179, 132, 220, 21);
		panel_2.add(lbl_contact);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblEmail.setBounds(20, 153, 191, 21);
		panel_2.add(lblEmail);
		
		lbl_email = new JLabel("john.doe@example.com");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_email.setBounds(179, 153, 220, 21);
		panel_2.add(lbl_email);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 326, 389, 12);
		panel_2.add(separator_1);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddress.setBounds(10, 191, 295, 21);
		panel_2.add(lblAddress);
		
		JLabel lblStreetName = new JLabel("Street Name & Number:");
		lblStreetName.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblStreetName.setBounds(20, 205, 167, 30);
		panel_2.add(lblStreetName);
		
		lbl_address = new JLabel("1254 South Avenue Road");
		lbl_address.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_address.setBounds(208, 211, 220, 21);
		panel_2.add(lbl_address);
		
		JLabel lblCity = new JLabel("City:");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCity.setBounds(20, 230, 167, 21);
		panel_2.add(lblCity);
		
		lbl_city = new JLabel("Half Way Tree");
		lbl_city.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_city.setBounds(208, 226, 220, 30);
		panel_2.add(lbl_city);
		
		JLabel lblCountry = new JLabel("Country:");
		lblCountry.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCountry.setBounds(20, 246, 167, 27);
		panel_2.add(lblCountry);
		
		lbl_country = new JLabel("Jamaica");
		lbl_country.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_country.setBounds(208, 252, 220, 12);
		panel_2.add(lbl_country);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((MainView) getParent1()).closePatientViewer();
			}
		});
		btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOk.setBorder(null);
		btnOk.setBackground(new Color(255, 165, 0));
		btnOk.setForeground(new Color(248, 248, 255));
		btnOk.setBounds(500, 478, 89, 30);
		panel_2.add(btnOk);
		
		JLabel lblPatientID = new JLabel("Patient ID: ");
		lblPatientID.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPatientID.setBounds(20, 54, 75, 21);
		panel_2.add(lblPatientID);
		
		lbl_patientID = new JLabel("1452");
		lbl_patientID.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_patientID.setBounds(179, 54, 220, 21);
		panel_2.add(lbl_patientID);
		
		JLabel lblAppointment = new JLabel("Appointment");
		lblAppointment.setDoubleBuffered(true);
		lblAppointment.setForeground(Color.DARK_GRAY);
		lblAppointment.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAppointment.setBounds(10, 296, 156, 30);
		panel_2.add(lblAppointment);
		
		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDoctor.setBounds(10, 337, 64, 21);
		panel_2.add(lblDoctor);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTime.setBounds(10, 357, 64, 21);
		panel_2.add(lblTime);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDate.setBounds(10, 377, 64, 21);
		panel_2.add(lblDate);
		
		txtrRemarks = new JTextArea();
		txtrRemarks.setMargin(new Insets(5, 5, 5, 5));
		txtrRemarks.setEditable(false);
		txtrRemarks.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(5, 10, 5, 5)));
		txtrRemarks.setText("Remarks");
		txtrRemarks.setBounds(10, 423, 335, 85);
		panel_2.add(txtrRemarks);
		
		lbl_doctorName = new JLabel("Greg House");
		lbl_doctorName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_doctorName.setBounds(84, 337, 117, 21);
		panel_2.add(lbl_doctorName);
		
		lbl_app_time = new JLabel("11:30 pm");
		lbl_app_time.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_app_time.setBounds(84, 357, 220, 21);
		panel_2.add(lbl_app_time);
		
		lbl_app_date = new JLabel("May 30, 2018");
		lbl_app_date.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_app_date.setBounds(85, 377, 220, 21);
		panel_2.add(lbl_app_date);
		
		JLabel lblRemarks = new JLabel("Remarks:");
		lblRemarks.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRemarks.setBounds(10, 402, 124, 21);
		panel_2.add(lblRemarks);
		
		lbl_app_edit = new JLabel("Edit");
		lbl_app_edit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				editAppointment();
			}
		});
		lbl_app_edit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbl_app_edit.setIcon(new ImageIcon(PatientViewer.class.getResource("/icons/icons8_Edit_20px.png")));
		lbl_app_edit.setBounds(163, 296, 53, 31);
		panel_2.add(lbl_app_edit);
		
		JLabel lblNew = new JLabel("New");
		lblNew.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createAppointment();
				
			}
		});
		lblNew.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNew.setIcon(new ImageIcon(PatientViewer.class.getResource("/icons/icons8_Plus_Math_20px.png")));
		lblNew.setBounds(216, 296, 53, 31);
		panel_2.add(lblNew);
		
		JLabel label = new JLabel("Edit");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!getParent1().isNewPatientViewer) {
					getParent1().createNewPatientViewer(true, person); 	
				}
			}
		});
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.setIcon(new ImageIcon(PatientViewer.class.getResource("/icons/icons8_Edit_20px.png")));
		label.setBounds(243, 11, 46, 31);
		panel_2.add(label);
		
		JLabel lblService = new JLabel("Service:");
		lblService.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblService.setBounds(208, 337, 64, 21);
		panel_2.add(lblService);
		
		lbl_service = new JLabel("Visit");
		lbl_service.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl_service.setBounds(269, 337, 306, 21);
		panel_2.add(lbl_service);
		
		JLabel label_1 = new JLabel("New");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Delete the Current Appointment from the patient record
				String query = "DELETE FROM appointment WHERE id='"+mostRecentAppointment.getAppointmentID()+"'"; 
				int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this appointment? "
						,"Delete Appointment",JOptionPane.YES_NO_OPTION); //JOptionPane.showConfirmDialog(null,"\"You are about to update \"+counter+\" fields\"", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
				//0 yes
				//1 no
				if(option == 0) {
					dc.CRUD(query);
					JOptionPane.showMessageDialog(null, "Appointment deleted! Updating our records. please wait....");
					//refresh the page at this point
				}
			}
		});
		label_1.setIcon(new ImageIcon(PatientViewer.class.getResource("/icons/icons8_Trash_20px.png")));
		label_1.setBounds(279, 296, 53, 31);
		panel_2.add(label_1);
	
		
	}


	protected void createAppointment() {
		// TODO Auto-generated method stub
		AppointmentView aview = new AppointmentView();
		aview.setPatientID(Integer.parseInt(this.getPatientID()));
		aview.setCurrentAppointment(this.mostRecentAppointment);
		aview.setAppointmentViewContainer(this);
		aview.setParent(getParent1());
		aview.setVisible(true);
		
//				this.getParent1().setEnabled(false);;
	}
	
	private void editAppointment() {
		AppointmentView aview = new AppointmentView();
		aview.setPatientID(Integer.parseInt(this.getPatientID()));
		aview.setVisible(true);
		aview.setCurrentAppointment(this.mostRecentAppointment);
		aview.setAppointmentViewContainer(this);
		aview.setupForEdit();
		aview.setParent(getParent1());
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
				
				person = new Person(
						rs.getString("title"),
						rs.getString("first_name"),
						rs.getString("last_name"),
						rs.getString("contact"),
						rs.getString("email"),
						rs.getString("dob"),
						rs.getString("gender"),
						rs.getString("address"),
						rs.getString("city"),
						rs.getString("country")
						);
				person.setPersonId(rs.getInt("id"));				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error when loading data");
		}
	}
	
	public void setAppointments(String patientID, int appointmentID) {
		
		
		String query = null;
		
		if(appointmentID == 0) {
			query = "SELECT (`a`.`id`) as `appointmentID`, `a`.`patientID`,`a`.`doctorID`, `a`.`serviceID`, (`a`.`date`) as `appointment_date`, "
					+ "(`d`.`name`) as `doctor_name`, `a`.`remark`, (`s`.`name`) as `service_name`, "
					+ "CONCAT(`p`.`first_name`,' ',`p`.`last_name`) as `patient_name` "
					+ "FROM `appointment` `a`, `doctor` `d`, `person` `p`, `service` `s` "
					+ "WHERE `a`.`patientID`='"+patientID+"' AND`a`.`patientID`=`p`.`id` AND `a`.`doctorID`=`d`.`id` "
					+ "AND `a`.`serviceID`=`s`.`id` ORDER BY `a`.`date`  DESC";
		}else {
			query = "SELECT (`a`.`id`) as `appointmentID`, `a`.`patientID`,`a`.`doctorID`, `a`.`serviceID`, (`a`.`date`) as `appointment_date`, "
					+ "(`d`.`name`) as `doctor_name`, `a`.`remark`, (`s`.`name`) as `service_name`, "
					+ "CONCAT(`p`.`first_name`,' ',`p`.`last_name`) as `patient_name` "
					+ "FROM `appointment` `a`, `doctor` `d`, `person` `p`, `service` `s` "
					+ "WHERE `a`.`id`='"+appointmentID+"' AND `a`.`patientID`='"+patientID+"' AND`a`.`patientID`=`p`.`id` AND `a`.`doctorID`=`d`.`id` "
					+ "AND `a`.`serviceID`=`s`.`id` ORDER BY `a`.`date`  DESC";
			System.out.println("THis is my ");
		}
		

		ResultSet rs = dc.executeStatementReturnResult(query);
		
		int rows = Helper.dbrowCount(rs);
		int counter = 0;
		if(rows>0) {
			
			this.appointments = new AppointmentItem[rows];
			
			try {
				while(rs.next()) {
					mostRecentAppointment = new AppointmentObj(
							rs.getInt("appointmentID"),
							rs.getInt("patientID"),
							rs.getTimestamp("appointment_date"),
							rs.getString("doctor_name"),
							rs.getString("service_name"),
							rs.getString("remark"),
							rs.getInt("doctorID"),
							rs.getInt("serviceID")
							);
					break;
				}
				
				this.lbl_doctorName.setText(mostRecentAppointment.getDoctors_name());
				this.lbl_app_time.setText(Helper.dateFormatter("h:mm a", mostRecentAppointment.getAppointmentDate()));
				this.lbl_app_date.setText(Helper.dateFormatter("MMM dd, yyyy", mostRecentAppointment.getAppointmentDate()));
				this.txtrRemarks.setText(mostRecentAppointment.getRemarks());
				this.lbl_service.setText(mostRecentAppointment.getService_name());
				this.lbl_app_edit.setVisible(true);
				//set the edit button if we have an appointment to display
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else {
			this.lbl_doctorName.setText("");
			this.lbl_app_time.setText("");
			this.lbl_app_date.setText("");
			this.lbl_service.setText("");
			this.lbl_app_edit.setVisible(false);
			
		}
		
	}


	public MainView getParent1() {
		return parent;
	}


	public void setParent(MainView parent) {
		this.parent = parent;
	}
	
	
}
