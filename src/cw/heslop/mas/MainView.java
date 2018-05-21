package cw.heslop.mas;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import cw.heslop.mas.component.ApplicationMenu;
import cw.heslop.mas.component.AppointmentItem;
import cw.heslop.mas.component.AppointmentList;
import cw.heslop.mas.component.UserProfile;
import cw.heslop.mas.objects.DatabaseConnection;
import cw.heslop.mas.objects.Person;
import cw.heslop.mas.objects.TimeOfDay;
import cw.heslop.mas.objects.User;
import javax.swing.JCheckBox;


public class MainView extends JFrame {

	private static final long serialVersionUID = -3443174621881190718L;
	public boolean isSettings = false;
	private DatabaseConnection conn = new DatabaseConnection("mas");
	private JPanel contentPane;
	private User activeUser;
	private JLabel lblActiveUserEmail;
	private DefaultListModel<JPanel> model;
	private JPanel pl_sidebar;
	private JLabel lbl_sb_title;
	private PatientViewer patientViewer;
	private NewPatientView pv;
	
	public AppointmentList alist;
	public JPanel pl_main;
	public PatientListView plv;
	public JPanel pl_home_options;	
	public boolean isPatientViewer = false;
	public boolean isNewPatientViewer;
	public UserProfile us;
	

	public JPanel getPl_main() {
		return pl_main;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setTitle("MAS");
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 894, 660);
		setLocationRelativeTo(null);
		
		new ApplicationMenu(this);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		us = new UserProfile();
		us.setVisible(false);
		us.setBounds(0, 66, 809, 426);
		
		model = new DefaultListModel<JPanel>();
		
		pl_home_options = new JPanel();
		pl_home_options.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		pl_home_options.setBackground(Color.WHITE);
		pl_home_options.setBounds(0, 66, 888, 540);
		contentPane.add(pl_home_options);
		pl_home_options.setLayout(null);
		
		pl_sidebar = new JPanel();
		pl_sidebar.setBackground(Color.DARK_GRAY);
		pl_sidebar.setBounds(0, 0, 274, 541);
		pl_home_options.add(pl_sidebar);
		pl_sidebar.setLayout(null);
		
		lbl_sb_title = new JLabel("Today's Appointments");
		lbl_sb_title.setBounds(1, 0, 272, 47);
		pl_sidebar.add(lbl_sb_title);
		lbl_sb_title.setOpaque(true);
		lbl_sb_title.setHorizontalTextPosition(SwingConstants.CENTER);
		lbl_sb_title.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_sb_title.setForeground(Color.WHITE);
		lbl_sb_title.setFont(new Font("Tahoma", Font.BOLD, 18));
		lbl_sb_title.setBackground(Color.DARK_GRAY);
		
		JPanel pl_footer = new JPanel();
		pl_footer.setBounds(1, 480, 272, 61);
		pl_sidebar.add(pl_footer);
		pl_footer.setBackground(new Color(0, 20, 20));
		pl_footer.setLayout(null);
		
		JLabel lblCopyrightMasCompany = new JLabel("Copyright 2018 MAS Company Ltd. ");
		lblCopyrightMasCompany.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCopyrightMasCompany.setHorizontalAlignment(SwingConstants.CENTER);
		lblCopyrightMasCompany.setVerticalAlignment(SwingConstants.TOP);
		lblCopyrightMasCompany.setForeground(SystemColor.inactiveCaptionBorder);
		lblCopyrightMasCompany.setBounds(0, 11, 269, 13);
		lblCopyrightMasCompany.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 10));
		pl_footer.add(lblCopyrightMasCompany);
		
		JLabel lblAllRightsReserved = new JLabel("All Rights Reserved");
		lblAllRightsReserved.setForeground(Color.WHITE);
		lblAllRightsReserved.setHorizontalTextPosition(SwingConstants.CENTER);
		lblAllRightsReserved.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllRightsReserved.setBounds(0, 30, 269, 14);
		pl_footer.add(lblAllRightsReserved);
		
		pl_main = new JPanel();
		pl_main.setBounds(272, 0, 616, 541);
		pl_home_options.add(pl_main);
		
		patientListModel();
		
		this.initizeAppointmentList();
		
		us.lblBackToMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pl_home_options.setVisible(true);
			}
		});
		
		JPanel main_menu = new JPanel();
		main_menu.setBackground(new Color(255, 165, 0));
		main_menu.setForeground(new Color(255, 255, 255));
		main_menu.setBounds(0, 0, 888, 66);
		contentPane.add(main_menu);
		main_menu.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setIcon(new ImageIcon(MainView.class.getResource("/icons/icons8_Stethoscope_64px_3.png")));
		label_2.setBounds(10, 5, 69, 52);
		main_menu.add(label_2);
		
		JLabel lblMas = new JLabel("MAS");
		lblMas.setForeground(new Color(255, 255, 255));
		lblMas.setFont(new Font("Malgun Gothic", Font.BOLD, 40));
		lblMas.setBounds(68, 11, 110, 41);
		main_menu.add(lblMas);
		
		JLabel lblMedicalManagementSystem = new JLabel("Medical Management System");
		lblMedicalManagementSystem.setForeground(Color.WHITE);
		lblMedicalManagementSystem.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		lblMedicalManagementSystem.setBounds(70, 41, 235, 22);
		main_menu.add(lblMedicalManagementSystem);
		
		JPanel pl_btn_exit = new JPanel();
		pl_btn_exit.setBounds(759, 0, 129, 66);
		main_menu.add(pl_btn_exit);
		pl_btn_exit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		pl_btn_exit.setBackground(new Color(90, 10, 10));
		pl_btn_exit.setLayout(null);
		
		
		lblActiveUserEmail = new JLabel("John Doe");
		lblActiveUserEmail.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblActiveUserEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblActiveUserEmail.setBackground(new Color(50, 10, 10));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblActiveUserEmail.setBackground(new Color(90, 10, 10));
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				settings();
			}
		});
		
		lblActiveUserEmail.setForeground(new Color(255, 255, 255));
		lblActiveUserEmail.setBounds(10, 11, 88, 14);
		pl_btn_exit.add(lblActiveUserEmail);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginView().setVisible(true);
				CloseFrame();
			}
		});
		lblLogout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogout.setHorizontalTextPosition(SwingConstants.LEADING);
		lblLogout.setForeground(new Color(255, 255, 255));
		lblLogout.setIcon(new ImageIcon(MainView.class.getResource("/icons/icons8_Logout_Rounded_Up_32px.png")));
		lblLogout.setBounds(10, 31, 76, 32);
		pl_btn_exit.add(lblLogout);
		
		JCheckBox chckbxCollapseSideBar = new JCheckBox("Collapse Side bar");
		chckbxCollapseSideBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(chckbxCollapseSideBar.isSelected()) {
					pl_sidebar.setBounds(0, 0, 0, 541);
					pl_main.setBounds(272, 0, 900, 541);
				}
				else {
					pl_sidebar.setBounds(0, 0, 274, 541);
					pl_main.setBounds(272, 0, 616, 541);
				}
			}
		});
		chckbxCollapseSideBar.setBorder(null);
		chckbxCollapseSideBar.setForeground(new Color(255, 255, 255));
		chckbxCollapseSideBar.setBackground(new Color(255, 165, 0));
		chckbxCollapseSideBar.setBounds(272, 33, 136, 23);
		main_menu.add(chckbxCollapseSideBar);
		
	}
	
	public void settings() {
		
		
		if(this.isNewPatientViewer) {
			this.closeNewPatientViewer();
		}
		pl_home_options.setVisible(false);
		isSettings = true;
//		setup the information
		us.lbl_fname.setText(activeUser.getFirstname());
		us.lbl_lname.setText(activeUser.getLastname());
		us.lbl_email.setText(activeUser.getEmail());
		us.lbl_acct_type.setText(activeUser.getUserType());
		us.setUserID(activeUser.getUserID());
		us.setVisible(true);
		contentPane.add(us);
		
	}

	public void CloseFrame(){
	    super.dispose();
	}
	
	
	
	public MainView setUserSession(User user) {
//		store the logged in user
		activeUser = user;
		//
		lblActiveUserEmail.setText(user.getFullname());
		return this;
	}
	
	protected void initizeAppointmentList() {
				
		//check if coming from the patient list view with a patient ID, else show new 
				String query = "SELECT `a`.`id`, `a`.`patientID`, CONCAT(`p`.`first_name`,' ',`p`.`last_name`) as `patient_name`, `a`.`date` as `appointment_date`, `d`.`name` as `doctor_name`"+ 
				"FROM `appointment` `a`, `doctor` `d`, `person` `p` WHERE"+
		        "`a`.`date`>='"+Helper.getTodayDateTimeStamp(TimeOfDay.start)+"' AND `a`.`date`<'"+Helper.getTodayDateTimeStamp(TimeOfDay.end)+"' AND"+
		        "`a`.`patientID`=`p`.`id` AND `a`.`doctorID`=`d`.`id`"+
				"ORDER BY `a`.`date`  DESC";
				
				
				ResultSet rs = conn.executeStatementReturnResult(query);
			
				try {
					
					//get the size of the row 
					rs.last();
				    int size = rs.getRow();
				    rs.beforeFirst();
				    AppointmentItem[] aItems = new AppointmentItem[size];
					int counter = 0;
					
					while(rs.next()) {
						String name = rs.getString("patient_name");
						String doctorName = rs.getString("doctor_name");
						aItems[counter] = new AppointmentItem(null,
								Helper.dateFormatter("h:mm a", rs.getTimestamp("appointment_date")),
								name,doctorName,rs.getInt("id"),rs.getInt("patientID") ); 
						counter++;
					}
					alist = new AppointmentList(aItems);
					alist.setMainView(this);
					alist.setBounds(0, 46, 271, 435);
					this.pl_sidebar.add(alist);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
}
	
	
	private void patientListModel() {
		plv = new PatientListView();
		plv.setParent(this);
		plv.setSize(616, 541);
		plv.setLocation(0, 0);
		pl_main.setLayout(null);
		
//		plv.setBounds(0, 0, 70, 14);
		pl_main.add(plv);
		
		
	}

	public void activatePateintView(String patientID, int appointmentID) {
		// TODO Auto-generated method stub
		patientViewer = new PatientViewer();
		patientViewer.setPatientID(patientID);
		patientViewer.setAppointments(patientID, appointmentID);
		pl_main.setVisible(false);
		patientViewer.setBounds(272, 0, 616, 541);
		patientViewer.setParent(this);
		pl_home_options.add(patientViewer);
		isPatientViewer  = true;
		activatePatientListView(patientID);
	}

	

	public void closePatientViewer() {
		// TODO Auto-generated method stub
		patientViewer.setVisible(false);
		this.pl_home_options.remove(patientViewer);
		this.pl_home_options.revalidate();
	    this.pl_home_options.repaint();
		
		pl_main.setVisible(true);
		this.pl_sidebar.remove(2);
		
		lbl_sb_title.setText("Today's Appointments");
		initizeAppointmentList();
	}

	public void activatePatientListView(String patientID) {

		//change the appointment list to reflect current user appointments
		
		//check if coming from the patient list view with a patient ID, else show new 
		String query = "SELECT `a`.`id`, `a`.`patientID`, CONCAT(`p`.`first_name`,' ',`p`.`last_name`) as `patient_name`, "+
		"`a`.`date` as `appointment_date`, `d`.`name` as `doctor_name` "+
		"FROM `appointment` `a`, `doctor` `d`, `person` `p` WHERE `a`.`patientID`='"+patientID+"' AND"+ 
		"`a`.`patientID`=`p`.`id` AND `a`.`doctorID`=`d`.`id`"+  
		"ORDER BY `a`.`date`  DESC";
		
		ResultSet rs = conn.executeStatementReturnResult(query);
	
		try {
			
			//get the size of the row 
			rs.last();
		    int size = rs.getRow();
		    rs.beforeFirst();
		    AppointmentItem[] aItems = new AppointmentItem[size];
			int counter = 0;
			
			this.pl_sidebar.remove(2);
			
			while(rs.next()) {
				String name = rs.getString("patient_name");
				String doctorName = rs.getString("doctor_name");
				aItems[counter] = new AppointmentItem(Helper.dateFormatter("MMM dd, yy", rs.getTimestamp("appointment_date")),
						Helper.dateFormatter("h:mm a", rs.getTimestamp("appointment_date")),
						name,doctorName,rs.getInt("id"),rs.getInt("patientID"));  
				counter++;
			}
			this.lbl_sb_title.setText("Appointments");
			alist = new AppointmentList(aItems);
			alist.setMainView(this);
			alist.setBounds(0, 46, 271, 435);
			
			this.pl_sidebar.add(alist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void createNewPatientViewer(boolean isEdit, Person person) {
		this.isNewPatientViewer = true;
		if(isEdit) {
			pv = new NewPatientView(person);	
		}else {
			pv = new NewPatientView(null);		
		}
		
		pv.setBounds(0, 66, 888, 540);
		pl_home_options.setVisible(false);;
		pv.setParent(this);
		contentPane.add(pv);
	}

	public void closeNewPatientViewer() {
		this.contentPane.remove(pv);
		this.isNewPatientViewer = false;
		this.pl_home_options.setVisible(true);
	}
}

