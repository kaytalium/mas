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

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3443174621881190718L;
	private JPanel contentPane;
	private JPanel pl_btn_pl;

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
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		UserProfile us = new UserProfile();
		us.setBounds(0, 142, 815, 383);
		us.setVisible(false);
	
		
		contentPane.add(us);
		
		JPanel pl_home_options = new JPanel();
		pl_home_options.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pl_home_options.setBackground(Color.WHITE);
		pl_home_options.setBounds(0, 142, 815, 383);
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
		pl_footer.setBounds(0, 525, 815, 38);
		contentPane.add(pl_footer);
		pl_footer.setLayout(null);
		
		JLabel lblCopyrightMasCompany = new JLabel("Copyright 2018 MASS Company Ltd. All Rights Reserved");
		lblCopyrightMasCompany.setForeground(SystemColor.inactiveCaptionBorder);
		lblCopyrightMasCompany.setBounds(289, 14, 271, 13);
		lblCopyrightMasCompany.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 10));
		pl_footer.add(lblCopyrightMasCompany);
		
		JPanel main_menu = new JPanel();
		main_menu.setBackground(new Color(255, 165, 0));
		main_menu.setForeground(new Color(255, 255, 255));
		main_menu.setBounds(0, 0, 815, 142);
		contentPane.add(main_menu);
		main_menu.setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(new Color(255, 255, 255));
		label_2.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Stethoscope_96px.png")));
		label_2.setBounds(26, 11, 152, 107);
		main_menu.add(label_2);
		
		JLabel lblMas = new JLabel("MASS");
		lblMas.setForeground(new Color(255, 255, 255));
		lblMas.setFont(new Font("Malgun Gothic", Font.BOLD, 40));
		lblMas.setBounds(115, 11, 123, 64);
		main_menu.add(lblMas);
		
		JLabel lblMedicalManagementSystem = new JLabel("Medical Management System");
		lblMedicalManagementSystem.setForeground(Color.WHITE);
		lblMedicalManagementSystem.setFont(new Font("Malgun Gothic", Font.PLAIN, 12));
		lblMedicalManagementSystem.setBounds(118, 54, 235, 32);
		main_menu.add(lblMedicalManagementSystem);
		
		JPanel pl_btn_exit = new JPanel();
		pl_btn_exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pl_btn_exit.setBackground(new Color(50, 10, 10));
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pl_btn_exit.setBackground(new Color(90, 10, 10));
				
			}
		});
		pl_btn_exit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		pl_btn_exit.setBackground(new Color(90, 10, 10));
		pl_btn_exit.setBounds(738, 0, 77, 142);
		main_menu.add(pl_btn_exit);
		pl_btn_exit.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(21, 46, 40, 33);
		pl_btn_exit.add(label_1);
		label_1.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Exit_40px.png")));
		
		JLabel lblExit = new JLabel("Exit");
		lblExit.setFont(new Font("Arial", Font.PLAIN, 10));
		lblExit.setForeground(new Color(255, 255, 255));
		lblExit.setBounds(31, 79, 46, 14);
		pl_btn_exit.add(lblExit);
		
		JPanel panel_5 = new JPanel();
		panel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				panel_5.setBackground(new Color(255, 140, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				panel_5.setBackground(new Color(255, 155, 0));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				pl_home_options.setVisible(false);
				us.setVisible(true);
				
			}
		});
		panel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_5.setBackground(new Color(255, 155, 0));
		panel_5.setBounds(659, 0, 82, 142);
		main_menu.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(21, 44, 40, 40);
		panel_5.add(label_3);
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Profile_40px.png")));
		
		JLabel lblMyProfile = new JLabel("My Profile");
		lblMyProfile.setForeground(new Color(255, 255, 255));
		lblMyProfile.setFont(new Font("Arial", Font.PLAIN, 10));
		lblMyProfile.setBounds(21, 78, 72, 14);
		panel_5.add(lblMyProfile);
	}
	
	void mouseEnter(JPanel btn){
		btn.setBackground(new Color(68,68,68));
	}
	
	void mouseLeave(JPanel btn) {
		btn.setBackground(new Color(51,51,51));
	}
}
