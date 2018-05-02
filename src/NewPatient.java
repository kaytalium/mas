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
import com.toedter.calendar.JCalendar;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.border.LineBorder;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NewPatient extends JFrame {

	private JPanel contentPane;
	private MTextField tf_firstname, tf_lastname ;
	private ButtonGroup genderButtonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewPatient frame = new NewPatient();
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
	public NewPatient() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 997, 630);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 275, 616);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(273, 94, 731, 522);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 68, 384, 262);
		panel_1.add(panel_2);
		panel_2.setBorder(new CompoundBorder(UIManager.getBorder("Button.border"), null));
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setLayout(null);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(20, 64, 146, 33);
		panel_2.add(lblFirstName);
		lblFirstName.setForeground(Color.WHITE);
		
		tf_firstname = new MTextField();
		tf_firstname.setBorder(null);
		tf_firstname.setBounds(20, 89, 162, 24);
		panel_2.add(tf_firstname);
		tf_firstname.setPlaceholder("First Name");
		tf_firstname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(210, 65, 146, 33);
		panel_2.add(lblLastName);
		lblLastName.setForeground(Color.WHITE);
		
		tf_lastname = new MTextField();
		tf_lastname.setBounds(208, 90, 162, 24);
		panel_2.add(tf_lastname);
		tf_lastname.setPlaceholder("Last Name");
		tf_lastname.setColumns(10);
		
		JComboBox cb_title = new JComboBox();
		cb_title.setBackground(Color.WHITE);
		cb_title.setBounds(20, 33, 109, 24);
		panel_2.add(cb_title);
		cb_title.setBorder(null);
		cb_title.setModel(new DefaultComboBoxModel(new String[] {"Select Title", "Mr", "Ms", "Miss", "Mrs", "Rev", "Honorable"}));
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(20, 8, 146, 33);
		panel_2.add(lblTitle);
		lblTitle.setForeground(Color.WHITE);
		
		MTextField tf_contact = new MTextField();
		tf_contact.setBounds(20, 150, 162, 27);
		panel_2.add(tf_contact);
		tf_contact.setPlaceholder("Mobile Number");
		tf_contact.setColumns(10);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setBounds(20, 125, 146, 33);
		panel_2.add(lblContact);
		lblContact.setForeground(Color.WHITE);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(208, 126, 146, 33);
		panel_2.add(lblEmail);
		lblEmail.setForeground(Color.WHITE);
		
		MTextField textField = new MTextField();
		textField.setBounds(208, 152, 162, 26);
		panel_2.add(textField);
		textField.setPlaceholder("Email Address");
		textField.setColumns(10);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setForeground(Color.WHITE);
		rdbtnMale.setBackground(Color.DARK_GRAY);
		rdbtnMale.setBounds(205, 210, 56, 33);
		panel_2.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(Color.DARK_GRAY);
		rdbtnFemale.setForeground(Color.WHITE);
		rdbtnFemale.setBounds(261, 210, 109, 33);
		panel_2.add(rdbtnFemale);
		
		genderButtonGroup.add(rdbtnMale);
		genderButtonGroup.add(rdbtnFemale);
		
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(Color.WHITE);
		lblGender.setBounds(205, 189, 146, 33);
		panel_2.add(lblGender);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(Color.WHITE);
		dateChooser.setBorder(null);
		dateChooser.setBounds(20, 207, 162, 24);
		panel_2.add(dateChooser);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setForeground(Color.WHITE);
		lblDateOfBirth.setBounds(20, 184, 146, 33);
		panel_2.add(lblDateOfBirth);
		
		JLabel lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setBounds(10, 24, 255, 43);
		panel_1.add(lblPersonalInformation);
		lblPersonalInformation.setForeground(Color.WHITE);
		lblPersonalInformation.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 58, 241, 9);
		panel_1.add(separator);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(394, 68, 314, 262);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setBounds(10, 63, 146, 33);
		panel_3.add(lblAddress);
		
		MTextField textField_1 = new MTextField();
		textField_1.setPlaceholder("Enter address here");
		textField_1.setColumns(10);
		textField_1.setBounds(10, 88, 194, 24);
		panel_3.add(textField_1);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setForeground(Color.WHITE);
		lblCity.setBounds(10, 124, 146, 33);
		panel_3.add(lblCity);
		
		MTextField textField_2 = new MTextField();
		textField_2.setPlaceholder("City");
		textField_2.setColumns(10);
		textField_2.setBounds(10, 149, 194, 27);
		panel_3.add(textField_2);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setForeground(Color.WHITE);
		lblCountry.setBounds(10, 187, 146, 33);
		panel_3.add(lblCountry);
		
		MTextField textField_3 = new MTextField();
		textField_3.setPlaceholder("Enter country here....");
		textField_3.setColumns(10);
		textField_3.setBounds(10, 212, 194, 27);
		panel_3.add(textField_3);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(383, 24, 21, 326);
		panel_1.add(separator_1);
		
		JLabel lblAddressInformation = new JLabel("Address Information");
		lblAddressInformation.setForeground(Color.WHITE);
		lblAddressInformation.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblAddressInformation.setBounds(394, 24, 255, 43);
		panel_1.add(lblAddressInformation);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(394, 58, 241, 9);
		panel_1.add(separator_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(350, 389, 358, 89);
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnNewButton.setIcon(new ImageIcon(NewPatient.class.getResource("/icons/icons8_Cancel_22px.png")));
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.setBounds(23, 41, 144, 37);
		panel_4.add(btnNewButton);
		
		JButton btnSave = new JButton("Save");
		btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSave.setForeground(Color.WHITE);
		btnSave.setBorder(new LineBorder(Color.LIGHT_GRAY));
		btnSave.setIcon(new ImageIcon(NewPatient.class.getResource("/icons/icons8_Save_22px.png")));
		btnSave.setBackground(new Color(34, 139, 34));
		btnSave.setBounds(193, 41, 144, 37);
		panel_4.add(btnSave);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(273, 0, 756, 95);
		contentPane.add(panel_5);
	}
}
