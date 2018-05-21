package cw.heslop.mas.component;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;

import cw.heslop.mas.LoginView;


public class Loader extends JFrame {

	private static final long serialVersionUID = 8613095265390200821L;
	private JPanel contentPane;
	private int x = 0;
	private JProgressBar progressBar;
	private JLabel lblLoading;
	private JLabel lbl_info;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loader frame = new Loader();
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
	public Loader() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLUE));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		Timer t = new Timer(100, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(x==100) {
					dispose();
					LoginView lv = new LoginView();
					lv.setVisible(true);
				}
				x++;
				progressBar.setValue(x);
				lblLoading.setText(""+x+"%");
				if(x>0 && x<8) {
					lbl_info.setText("Loading Authentication Module");
				}
				if(x>8 && x<16) {
					lbl_info.setText("Loading Authentication Module - Sign in.");
				}
				if(x>16 && x<24) {
					lbl_info.setText("Loading Authentication Module - Registration.");
				}
				if(x>24 && x<33) {
					lbl_info.setText("Loading Authentication Module - Login.");
				}
				if(x>33 && x<41) {
					lbl_info.setText("Loading Appointment Module");
				}
				if(x>41 && x<50) {
					lbl_info.setText("Loading Appointment Module - Create New Design.");
				}
				if(x>50 && x<58) {
					lbl_info.setText("Loading Appointment Module - Create Edit Design.");
				}
				if(x>58 && x<66) {
					lbl_info.setText("Loading Main Module.");
				}
				if(x>66 && x<74) {
					lbl_info.setText("Loading Appointment Module - Add View Patient Viewer.");
				}
				if(x>74 && x<82) {
					lbl_info.setText("Loading Appointment Module - Creating Appointment List.");
				}
				if(x>82 && x<90) {
					lbl_info.setText("Loading Appointment Module - Create New Appointment.");
				}
				if(x>90 && x<95) {
					lbl_info.setText("Almost done.");
				}
				if(x>95 && x<100) {
					lbl_info.setText("Get ready for Awesome");
				}			
			}
		});
		
		
		lblLoading = new JLabel("0%");
		lblLoading.setForeground(Color.WHITE);
		lblLoading.setBounds(10, 245, 29, 14);
		contentPane.add(lblLoading);
		
		progressBar = new JProgressBar(0,100);
		progressBar.setBorderPainted(false);
		progressBar.setBackground(Color.DARK_GRAY);
		progressBar.setForeground(Color.ORANGE);
		progressBar.setBorder(null);
		progressBar.setBounds(38, 245, 481, 14);
		contentPane.add(progressBar);
		
		JLabel lblCreatedBy = new JLabel("Created By:");
		lblCreatedBy.setForeground(Color.WHITE);
		lblCreatedBy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCreatedBy.setBounds(239, 101, 77, 14);
		contentPane.add(lblCreatedBy);
		
		JLabel lblOvelHeslop = new JLabel("Ovel Heslop");
		lblOvelHeslop.setForeground(Color.WHITE);
		lblOvelHeslop.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOvelHeslop.setBounds(246, 115, 70, 14);
		contentPane.add(lblOvelHeslop);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(230, 47, 8, 150);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("Management Appointment System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(239, 47, 280, 43);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Loader.class.getResource("/icons/icons8_Stethoscope_96px_1.png")));
		label.setBounds(124, 55, 96, 113);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Tajhna McCourtie");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(246, 129, 108, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ruel Andrews");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(246, 142, 108, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblCordelReid = new JLabel("Cordel Reid");
		lblCordelReid.setForeground(Color.WHITE);
		lblCordelReid.setBounds(246, 157, 66, 14);
		contentPane.add(lblCordelReid);
		
		JLabel lblCodeZeroProduction = new JLabel("Code Zero Production");
		lblCodeZeroProduction.setForeground(Color.LIGHT_GRAY);
		lblCodeZeroProduction.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCodeZeroProduction.setBounds(10, 275, 149, 14);
		contentPane.add(lblCodeZeroProduction);
		
		JLabel lblWwwmascom = new JLabel("www.mas.com");
		lblWwwmascom.setForeground(Color.WHITE);
		lblWwwmascom.setBounds(239, 79, 115, 14);
		contentPane.add(lblWwwmascom);
		
		lbl_info = new JLabel("");
		lbl_info.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lbl_info.setForeground(Color.WHITE);
		lbl_info.setBounds(239, 226, 280, 14);
		contentPane.add(lbl_info);
		t.start();
	}
}
