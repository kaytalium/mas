package cw.heslop.mas;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JFormattedTextField;
import com.toedter.calendar.JDateChooser;

import cw.heslop.mas.component.ApplicationMenu;
import cw.heslop.mas.component.MTextField;
import cw.heslop.mas.objects.DatabaseConnection;
import cw.heslop.mas.objects.IDGenerator;
import cw.heslop.mas.objects.Person;

import com.toedter.calendar.JCalendar;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.text.DateFormatter;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewPatientView extends JFrame {

	private JPanel contentPane;
	private Person person; 
	
	private MTextField tf_firstname, tf_lastname ;
	private ButtonGroup genderButtonGroup = new ButtonGroup();
	private MTextField textField_4;
	private JComboBox cb_title;
	private MTextField tf_contact;
	private MTextField tf_email;
	private JDateChooser dc_dob;
	private JRadioButton rdbtnMale;
	private JRadioButton rdbtnFemale; 
	private MTextField tf_address;
	private MTextField tf_city;
	private MTextField tf_country;
	private JFrame parent;
	private ApplicationMenu menu;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPatientView frame = new NewPatientView();
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
	public NewPatientView() {
		setTitle("MAS");
		setPreferredSize(new Dimension(813, 594));
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 813, 594);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menu = new ApplicationMenu(this);
		menu.setExitOption(1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 48, 807, 481);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 68, 384, 287);
		panel_1.add(panel_2);
		panel_2.setBorder(new CompoundBorder(UIManager.getBorder("Button.border"), null));
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(20, 76, 146, 33);
		panel_2.add(lblFirstName);
		lblFirstName.setForeground(Color.WHITE);
		
		tf_firstname = new MTextField();
		tf_firstname.setCaretColor(new Color(255, 255, 255));
		tf_firstname.setBackground(Color.DARK_GRAY);
		tf_firstname.setBounds(20, 101, 162, 33);
		panel_2.add(tf_firstname);
		tf_firstname.setPlaceholder("First Name");
		tf_firstname.setColumns(10);
		tf_firstname.setTypingColor(Color.white);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(210, 77, 146, 33);
		panel_2.add(lblLastName);
		lblLastName.setForeground(Color.WHITE);
		
		tf_lastname = new MTextField();
		tf_lastname.setCaretColor(new Color(255, 255, 255));
		tf_lastname.setTypingColor(Color.WHITE);
		tf_lastname.setBackground(Color.DARK_GRAY);
		tf_lastname.setBounds(208, 102, 162, 33);
		panel_2.add(tf_lastname);
		tf_lastname.setPlaceholder("Last Name");
		tf_lastname.setColumns(10);
		
		cb_title = new JComboBox();
		cb_title.setForeground(Color.WHITE);
		cb_title.setBackground(Color.DARK_GRAY);
		cb_title.setBounds(20, 33, 162, 33);
		panel_2.add(cb_title);
		cb_title.setBorder(null);
		cb_title.setModel(new DefaultComboBoxModel(new String[] {"Select Title", "Mr", "Ms", "Miss", "Mrs", "Rev", "Honorable"}));
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(20, 8, 146, 33);
		panel_2.add(lblTitle);
		lblTitle.setForeground(Color.WHITE);
		
		tf_contact = new MTextField();
		tf_contact.setCaretColor(new Color(255, 255, 255));
		tf_contact.setTypingColor(Color.WHITE);
		tf_contact.setBackground(Color.DARK_GRAY);
		tf_contact.setBounds(20, 170, 162, 33);
		panel_2.add(tf_contact);
		tf_contact.setPlaceholder("Mobile Number");
		tf_contact.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(20, 145, 146, 33);
		panel_2.add(lblContact);
		lblContact.setForeground(Color.WHITE);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(208, 146, 146, 33);
		panel_2.add(lblEmail);
		lblEmail.setForeground(Color.WHITE);
		
		tf_email = new MTextField();
		tf_email.setCaretColor(new Color(255, 255, 255));
		tf_email.setTypingColor(Color.WHITE);
		tf_email.setBackground(Color.DARK_GRAY);
		tf_email.setBounds(208, 172, 162, 33);
		panel_2.add(tf_email);
		tf_email.setPlaceholder("Email Address");
		tf_email.setColumns(10);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(Color.WHITE);
		rdbtnMale.setBackground(Color.DARK_GRAY);
		rdbtnMale.setBounds(205, 247, 56, 33);
		panel_2.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(Color.DARK_GRAY);
		rdbtnFemale.setForeground(Color.WHITE);
		rdbtnFemale.setBounds(261, 247, 109, 33);
		panel_2.add(rdbtnFemale);
		
		genderButtonGroup.add(rdbtnMale);
		genderButtonGroup.add(rdbtnFemale);
		
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setBounds(205, 226, 146, 33);
		panel_2.add(lblGender);
		
		dc_dob = new JDateChooser();
		dc_dob.setForeground(Color.WHITE);
		dc_dob.setBackground(Color.WHITE);
		dc_dob.setBorder(null);
		dc_dob.setBounds(20, 244, 162, 33);
		panel_2.add(dc_dob);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setBounds(20, 221, 146, 33);
		panel_2.add(lblDateOfBirth);
		
		JLabel label = new JLabel("*");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setForeground(Color.RED);
		label.setBounds(47, 14, 13, 14);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(85, 85, 13, 14);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(275, 85, 13, 14);
		panel_2.add(label_2);
		
		JLabel label_6 = new JLabel("*");
		label_6.setForeground(Color.RED);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(70, 154, 13, 14);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("*");
		label_7.setForeground(Color.RED);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(93, 226, 13, 14);
		panel_2.add(label_7);
		
		JLabel label_8 = new JLabel("*");
		label_8.setForeground(Color.RED);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(248, 235, 13, 14);
		panel_2.add(label_8);
		
		JLabel lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setBounds(22, 24, 255, 43);
		panel_1.add(lblPersonalInformation);
		lblPersonalInformation.setForeground(new Color(255, 140, 0));
		lblPersonalInformation.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(22, 58, 241, 9);
		panel_1.add(separator);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(431, 68, 314, 262);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setBounds(10, 38, 146, 33);
		panel_3.add(lblAddress);
		
		tf_address = new MTextField();
		tf_address.setCaretColor(new Color(255, 255, 255));
		tf_address.setTypingColor(Color.WHITE);
		tf_address.setBackground(Color.DARK_GRAY);
		tf_address.setPlaceholder("Enter address here");
		tf_address.setColumns(10);
		tf_address.setBounds(10, 63, 282, 33);
		panel_3.add(tf_address);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.WHITE);
		lblCity.setBounds(10, 107, 146, 33);
		panel_3.add(lblCity);
		
		tf_city = new MTextField();
		tf_city.setCaretColor(new Color(255, 255, 255));
		tf_city.setTypingColor(Color.WHITE);
		tf_city.setBackground(Color.DARK_GRAY);
		tf_city.setPlaceholder("City");
		tf_city.setColumns(10);
		tf_city.setBounds(10, 132, 282, 33);
		panel_3.add(tf_city);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setForeground(Color.WHITE);
		lblCountry.setBounds(10, 187, 146, 33);
		panel_3.add(lblCountry);
		
		tf_country = new MTextField();
		tf_country.setCaretColor(new Color(255, 255, 255));
		tf_country.setTypingColor(Color.WHITE);
		tf_country.setBackground(Color.DARK_GRAY);
		tf_country.setPlaceholder("Enter country here....");
		tf_country.setColumns(10);
		tf_country.setBounds(10, 212, 282, 33);
		panel_3.add(tf_country);
		
		JLabel lblPleaseFillOut = new JLabel("Please fill out all fields");
		lblPleaseFillOut.setForeground(new Color(100, 149, 237));
		lblPleaseFillOut.setBounds(10, 11, 282, 14);
		panel_3.add(lblPleaseFillOut);
		
		JLabel label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(56, 47, 13, 14);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(34, 116, 13, 14);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("*");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(56, 196, 13, 14);
		panel_3.add(label_5);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(395, 29, 10, 326);
		panel_1.add(separator_1);
		
		JLabel lblAddressInformation = new JLabel("Address Information");
		lblAddressInformation.setForeground(new Color(255, 140, 0));
		lblAddressInformation.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAddressInformation.setBounds(431, 24, 255, 43);
		panel_1.add(lblAddressInformation);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(428, 58, 241, 9);
		panel_1.add(separator_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(383, 366, 358, 89);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				parent.setVisible(true);
				
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnNewButton.setIcon(new ImageIcon(NewPatientView.class.getResource("/icons/icons8_Cancel_22px.png")));
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.setBounds(23, 41, 144, 37);
		panel_4.add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isValidated()) {
					createAccount();
				}
			}
		});
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.setForeground(Color.WHITE);
		btnSave.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnSave.setIcon(new ImageIcon(NewPatientView.class.getResource("/icons/icons8_Save_22px.png")));
		btnSave.setBackground(new Color(34, 139, 34));
		btnSave.setBounds(193, 41, 144, 37);
		panel_4.add(btnSave);
		
		JPanel panel_5 = new JPanel();
		panel_5.setForeground(new Color(255, 255, 255));
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(new Color(255, 165, 0));
		panel_5.setBounds(0, 0, 807, 46);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		IDGenerator newID = new IDGenerator();		
		
		textField_4 = new MTextField();
		textField_4.setBorder(new CompoundBorder(new LineBorder(new Color(255, 255, 255)), new EmptyBorder(0, 5, 0, 0)));
		textField_4.setDisabledTextColor(new Color(255, 255, 255));
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setForeground(new Color(255, 255, 255));
		textField_4.setBackground(new Color(255, 165, 0));
		textField_4.setText(Integer.toString(newID.getNewID()));
		textField_4.setEnabled(false);
		textField_4.setBounds(87, 11, 73, 24);
		panel_5.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblPatientId = new JLabel("Patient ID: ");
		lblPatientId.setBounds(25, 16, 82, 14);
		panel_5.add(lblPatientId);
	}

	protected void createAccount() {
		// TODO Auto-generated method stub
		try {
			DatabaseConnection dc = new DatabaseConnection("mas");
//			dc.CRUD(person.insertQuery());
			System.out.println("peson Query: "+person.insertQuery());
//			JOptionPane.showMessageDialog(null, "Record Added", "Creating new Account", JOptionPane.INFORMATION_MESSAGE);
		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "We have a proble cannot save data :(", "Creating new Account", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
		
	}

	protected boolean isValidated() {
		// TODO Auto-generated method stub
		if(cb_title.getSelectedItem().toString() == "Select Title") {
			JOptionPane.showMessageDialog(null, "Please select a title", "Required Field Message", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(!tf_firstname.isValidated()) {
			JOptionPane.showMessageDialog(null, "First name field cannot be left blank", "Required Field Message", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(!tf_lastname.isValidated()) {
			JOptionPane.showMessageDialog(null, "Last name field cannot be left blank", "Required Field Message", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(!tf_contact.isValidated()) {
			JOptionPane.showMessageDialog(null, "Contact field cannot be left blank", "Required Field Message", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(!tf_contact.isPhone()) {
			JOptionPane.showMessageDialog(null, "Invalid phone number; Expected format: (876)-978-5216", "Required Field Message", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(tf_email.isValidated() && !tf_email.isEmail()) {
			JOptionPane.showMessageDialog(null, "Invalid Email address; Expected format: example@email.com", "Required Field Message", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		String date = ((JTextField)dc_dob.getDateEditor().getUiComponent()).getText();
		if(date.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Date of Birth cannot be left empty", "Required Field Message", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		if(!this.rdbtnMale.isSelected() && !this.rdbtnFemale.isSelected()) {
			JOptionPane.showMessageDialog(null, "A Gender must be selected", "Required Field Message", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if(!tf_address.isValidated()) {
			JOptionPane.showMessageDialog(null, "Address field cannot be left blank", "Required Field Message", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if(!tf_city.isValidated()) {
			JOptionPane.showMessageDialog(null, "City field cannot be left blank", "Required Field Message", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if(!tf_country.isValidated()) {
			JOptionPane.showMessageDialog(null, "Country field cannot be left blank", "Required Field Message", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		String gender = "Male";
		if(this.rdbtnFemale.isSelected()) {
			gender = "Female";
		}
		
		date = Helper.dateFormatter("YYYY-MM-dd", date.toString());
		DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
		try {
			Date nd = (Date) df.parse(date);
			person = new Person(
					cb_title.getSelectedItem().toString(),
					tf_firstname.getText().toString(),
					tf_lastname.getText().toString(),
					tf_contact.getText().toString(),
					tf_email.getText().toString(),
					date,
					gender,
					tf_address.getText().toString(),
					tf_city.getText().toString(),
					 tf_country.getText().toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
												
		return true;
	}
	
	public void setParent(JFrame parent) {
		parent.setVisible(false);
		this.parent = parent;
		menu.setExitWindow(parent);
		
	}
}
