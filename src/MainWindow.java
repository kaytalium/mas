import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import java.awt.Cursor;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Rectangle;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.border.CompoundBorder;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3443174621881190718L;
	private JPanel contentPane;
	private JPanel pl_btn_pl;
	private User activeUser;
	JLabel lblActiveUserEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 815, 594);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBorder(new LineBorder(new Color(192, 192, 192)));
		menuBar.setPreferredSize(new Dimension(0, 25));
		menuBar.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.setBounds(new Rectangle(0, 0, 0, 150));
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 500, 10);
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setPreferredSize(new Dimension(50, 22));
		mnFile.setMargin(new Insets(0, 10, 0, 0));
		mnFile.setIconTextGap(6);
		mnFile.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnNew.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_File_32px.png")));
		mnNew.setPreferredSize(new Dimension(250, 40));
		mnFile.add(mnNew);
		
		JMenuItem mntmNewPatient = new JMenuItem("New Patient");
		mntmNewPatient.setPreferredSize(new Dimension(190, 35));
		mnNew.add(mntmNewPatient);
		
		JMenuItem mntmNewAppointment = new JMenuItem("New Appointment");
		mntmNewAppointment.setPreferredSize(new Dimension(141, 35));
		mnNew.add(mntmNewAppointment);
		
		JMenu mnOpen = new JMenu("Open");
		mnOpen.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Open_32px.png")));
		mnOpen.setPreferredSize(new Dimension(77, 40));
		mnFile.add(mnOpen);
		
		JMenuItem mntmAppointment = new JMenuItem("Appointment");
		mntmAppointment.setPreferredSize(new Dimension(190, 35));
		mnOpen.add(mntmAppointment);
		
		JMenuItem mntmPatientRecord = new JMenuItem("Patient Record");
		mntmPatientRecord.setPreferredSize(new Dimension(121, 35));
		mnOpen.add(mntmPatientRecord);
		
		JMenu mnPayment = new JMenu("Payment");
		mnPayment.setPreferredSize(new Dimension(95, 35));
		mnOpen.add(mnPayment);
		
		JMenuItem mntmMakeAPayment = new JMenuItem("Make a Payment");
		mntmMakeAPayment.setPreferredSize(new Dimension(150, 35));
		mnPayment.add(mntmMakeAPayment);
		
		JMenuItem mntmViewInvoice = new JMenuItem("View Invoice");
		mntmViewInvoice.setPreferredSize(new Dimension(109, 35));
		mnPayment.add(mntmViewInvoice);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem mntmClose = new JMenuItem("Exit");
		mntmClose.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Exit_32px.png")));
		mntmClose.setPreferredSize(new Dimension(73, 40));
		mnFile.add(mntmClose);
		
		JMenu mnProfile = new JMenu("Profile");
		mnProfile.setPreferredSize(new Dimension(56, 22));
		menuBar.add(mnProfile);
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Settings_32px.png")));
		mntmSettings.setPreferredSize(new Dimension(250, 40));
		mnProfile.add(mntmSettings);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Logout_Rounded_Up_32px.png")));
		mntmLogout.setPreferredSize(new Dimension(81, 40));
		mnProfile.add(mntmLogout);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmTeam = new JMenuItem("Team");
		mntmTeam.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_People_32px.png")));
		mntmTeam.setPreferredSize(new Dimension(250, 40));
		mnAbout.add(mntmTeam);
		
		JMenuItem mntmApplication = new JMenuItem("Application");
		mntmApplication.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Google_Code_32px.png")));
		mntmApplication.setPreferredSize(new Dimension(105, 40));
		mnAbout.add(mntmApplication);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UserProfile us = new UserProfile();
		us.setBounds(0, 66, 809, 426);
		us.setVisible(false);
	
		
		contentPane.add(us);
		
		JPanel pl_home_options = new JPanel();
		pl_home_options.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pl_home_options.setBackground(Color.WHITE);
		pl_home_options.setBounds(0, 66, 809, 440);
		contentPane.add(pl_home_options);
		pl_home_options.setLayout(null);
		
		us.lblBackToMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pl_home_options.setVisible(true);
			}
		});
		
		pl_btn_pl = new JPanel();
		pl_btn_pl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEnter(pl_btn_pl);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mouseLeave(pl_btn_pl);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					new PatientList().setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		
		pl_btn_pl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pl_btn_pl.setToolTipText("View the latest list of customers worked on");
		pl_btn_pl.setBackground(new Color(51, 51, 51));
		pl_btn_pl.setBounds(233, 49, 153, 120);
		pl_home_options.add(pl_btn_pl);
		pl_btn_pl.setLayout(null);
		
		JLabel lblPatientList = new JLabel("Patient List");
		lblPatientList.setForeground(new Color(255, 255, 255));
		lblPatientList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPatientList.setBounds(51, 73, 75, 29);
		pl_btn_pl.add(lblPatientList);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Bulleted_List_52px.png")));
		label.setBounds(51, 24, 65, 51);
		pl_btn_pl.add(label);
		
		JPanel pl_btn_np = new JPanel();
		pl_btn_np.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEnter(pl_btn_np);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mouseLeave(pl_btn_np);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new NewPatient().setVisible(true);
			}
		});
		pl_btn_np.setLayout(null);
		pl_btn_np.setToolTipText("Create New Customer");
		pl_btn_np.setBackground(new Color(51, 51, 51));
		pl_btn_np.setBounds(428, 49, 153, 120);
		pl_home_options.add(pl_btn_np);
		
		JLabel lblNewPatient_1 = new JLabel("New Patient");
		lblNewPatient_1.setForeground(Color.WHITE);
		lblNewPatient_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewPatient_1.setBounds(41, 69, 75, 29);
		pl_btn_np.add(lblNewPatient_1);
		
		JLabel label_11 = new JLabel("");
		label_11.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Document_52px.png")));
		label_11.setBounds(51, 24, 65, 51);
		pl_btn_np.add(label_11);
		
		JPanel pl_btn_ap = new JPanel();
		pl_btn_ap.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEnter(pl_btn_ap);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mouseLeave(pl_btn_ap);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new AppointmentViewer().setVisible(true);
			}
		});
		pl_btn_ap.setLayout(null);
		pl_btn_ap.setToolTipText("View the latest list of customers worked on");
		pl_btn_ap.setBackground(new Color(51, 51, 51));
		pl_btn_ap.setBounds(233, 181, 153, 120);
		pl_home_options.add(pl_btn_ap);
		
		JLabel lblAppoinment = new JLabel("Appoinments");
		lblAppoinment.setForeground(Color.WHITE);
		lblAppoinment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAppoinment.setBounds(41, 69, 75, 29);
		pl_btn_ap.add(lblAppoinment);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Timesheet_52px_1.png")));
		label_12.setBounds(51, 24, 65, 51);
		pl_btn_ap.add(label_12);
		
		JPanel pl_btn_pmt = new JPanel();
		pl_btn_pmt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mouseEnter(pl_btn_pmt);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mouseLeave(pl_btn_pmt);
			}
		});
		pl_btn_pmt.setLayout(null);
		pl_btn_pmt.setToolTipText("View the latest list of customers worked on");
		pl_btn_pmt.setBackground(new Color(51, 51, 51));
		pl_btn_pmt.setBounds(428, 181, 153, 120);
		pl_home_options.add(pl_btn_pmt);
		
		JLabel lblPayment_1 = new JLabel("Payment");
		lblPayment_1.setForeground(Color.WHITE);
		lblPayment_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPayment_1.setBounds(51, 68, 75, 29);
		pl_btn_pmt.add(lblPayment_1);
		
		JLabel label_13 = new JLabel("");
		label_13.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Card_Payment_52px.png")));
		label_13.setBounds(51, 24, 65, 51);
		pl_btn_pmt.add(label_13);
		
		JPanel pl_footer = new JPanel();
		pl_footer.setBackground(new Color(0, 20, 20));
		pl_footer.setBounds(0, 503, 815, 60);
		contentPane.add(pl_footer);
		pl_footer.setLayout(null);
		
		JLabel lblCopyrightMasCompany = new JLabel("Copyright 2018 MAS Company Ltd. All Rights Reserved");
		lblCopyrightMasCompany.setForeground(SystemColor.inactiveCaptionBorder);
		lblCopyrightMasCompany.setBounds(289, 14, 271, 13);
		lblCopyrightMasCompany.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 10));
		pl_footer.add(lblCopyrightMasCompany);
		
		JPanel main_menu = new JPanel();
		main_menu.setBackground(new Color(255, 165, 0));
		main_menu.setForeground(new Color(255, 255, 255));
		main_menu.setBounds(0, 0, 815, 66);
		contentPane.add(main_menu);
		main_menu.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Stethoscope_64px_3.png")));
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
		pl_btn_exit.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		pl_btn_exit.setBackground(new Color(90, 10, 10));
		pl_btn_exit.setBounds(625, 0, 195, 66);
		main_menu.add(pl_btn_exit);
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
				pl_home_options.setVisible(false);
//				setup the information
				us.lbl_fname.setText(activeUser.getFirstname());
				us.lbl_lname.setText(activeUser.getLastname());
				us.lbl_email.setText(activeUser.getEmail());
				us.lbl_acct_type.setText(activeUser.getUserType());
				us.setUserID(activeUser.getUserID());
				us.setVisible(true);
			}
		});
		
		lblActiveUserEmail.setForeground(new Color(255, 255, 255));
		lblActiveUserEmail.setBounds(10, 41, 88, 14);
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
		lblLogout.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Logout_Rounded_Up_32px.png")));
		lblLogout.setBounds(108, 32, 76, 32);
		pl_btn_exit.add(lblLogout);
		
		JLabel label_1 = new JLabel("|");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setForeground(new Color(255, 255, 255));
		label_1.setBounds(88, 41, 20, 14);
		pl_btn_exit.add(label_1);
		
	}
	
	void mouseEnter(JPanel btn){
		btn.setBackground(new Color(68,68,68));
	}
	
	void mouseLeave(JPanel btn) {
		btn.setBackground(new Color(51,51,51));
	}
	
	public void CloseFrame(){
	    super.dispose();
	}
	
	public MainWindow setUserSession(User user) {
//		store the logged in user
		activeUser = user;
		//
		lblActiveUserEmail.setText(user.getFirstname() +" "+ user.getLastname());
		return this;
	}
}
