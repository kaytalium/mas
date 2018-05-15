package cw.heslop.mas;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import cw.heslop.mas.component.CloseMinimize;
import cw.heslop.mas.component.MPasswordField;
import cw.heslop.mas.component.MTextField;
import cw.heslop.mas.component.TopRightPanel;
import cw.heslop.mas.component.WindowDragger;
import cw.heslop.mas.objects.CloseMinimizeIcon;
import cw.heslop.mas.objects.DatabaseConnection;
import cw.heslop.mas.objects.User;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.event.MouseMotionAdapter;
import javax.swing.border.CompoundBorder;
import java.awt.Insets;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 835459818027446290L;
	private JPanel contentPane;
	private MTextField txtfield_username;
	private MPasswordField txtfield_password;
	private JButton btnSubmit;
	private JLabel lblNewLabel_3;
	private boolean usernameState = false;
	private boolean passwordState  =false;
	private User activeUser = new User();
	private DatabaseConnection dc = new DatabaseConnection("mas");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setUndecorated(true);
		setBackground(new Color(255, 255, 255));
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 383);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255)));
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel log_element = new JPanel();
		log_element.setBorder(null);
		log_element.setBackground(new Color(255, 255, 255));
		log_element.setBounds(1, 1, 725, 380);
		contentPane.add(log_element);
		log_element.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(77, 157, 67, 23);
		log_element.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.GRAY);
		
		txtfield_username = new MTextField();
		txtfield_username.setPlaceholder("Email: example@email.com");
		txtfield_username.setBounds(76, 179, 265, 28);
		log_element.add(txtfield_username);
		txtfield_username.setForeground(Color.BLACK);
		txtfield_username.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(77, 218, 68, 14);
		log_element.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.GRAY);
		
		txtfield_password = new MPasswordField();
		txtfield_password.setPlaceholder("Password");
		txtfield_password.setBounds(77, 238, 265, 28);
		log_element.add(txtfield_password);
		
		
		JLabel lblNewLabel_4 = new JLabel("Don't have an account? ");
		lblNewLabel_4.setBounds(66, 125, 146, 21);
		log_element.add(lblNewLabel_4);
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				contentPane.setVisible(false);
				new SignUpView().setVisible(true);
			}
		});
		
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		JLabel lblHi = new JLabel("MAS");
		lblHi.setBounds(43, 27, 189, 53);
		log_element.add(lblHi);
		lblHi.setForeground(new Color(0, 0, 0));
		lblHi.setFont(new Font("Tahoma", Font.BOLD, 60));
		lblHi.setHorizontalAlignment(SwingConstants.CENTER);
		lblHi.setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("Medical Appointment System");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(92, 77, 183, 23);
		log_element.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(LoginView.class.getResource("/icons/icons8_Stethoscope_96px_1.png")));
		label.setBounds(10, 35, 105, 103);
		log_element.add(label);
		
		lblNewLabel_3 = new JLabel("Forget Password?");
		lblNewLabel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_3.setBounds(160, 333, 118, 23);
		log_element.add(lblNewLabel_3);
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int result = JOptionPane.showConfirmDialog(null, "Are you sure of this request?", "Change Password Request", JOptionPane.YES_NO_OPTION ,JOptionPane.QUESTION_MESSAGE);
				
				if(result == 0) {//yes
					String email = JOptionPane.showInputDialog(null, "Please enter email address");
										
					if(email== null) {
						JOptionPane.showMessageDialog(null, "No email was given, please try again", "Password Change Request", JOptionPane.WARNING_MESSAGE);
						
					}else {
						if(Helper.isEmail(email)) {
							try {
								ResultSet rs = dc.executeStatementReturnResult("SELECT `id` FROM user WHERE email='"+email+"'");
																						
								if(rs.isBeforeFirst()) {
									rs.first();
									int userId = rs.getInt("id");
									String query= "UPDATE user set status = '2' WHERE email='"+email+"'";
									dc.CRUD(query);
									JOptionPane.showMessageDialog(null, "Your request was approved, continue to change password", "Password Change Request", JOptionPane.INFORMATION_MESSAGE);
									activeUser.setUserID(userId);
									new ChangePasswordView().setUserSession(activeUser).setVisible(true);
									CloseFrame();
								}else {
									JOptionPane.showMessageDialog(null, "This email is not registered with us", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
								}
															
							}catch(Exception e) {
								e.printStackTrace();
							}
						}else {
							JOptionPane.showMessageDialog(null, "This is an invalid email address", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
						}
					}
					
				}
			}
		});
		lblNewLabel_3.setForeground(Color.DARK_GRAY);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnSubmit = new JButton("Login");
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmit.setBounds(77, 277, 264, 45);
		log_element.add(btnSubmit);
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(isUserAuthenticated()) {		
					if(activeUser.getStatus() == 0) {
						//At this user is login but password is inactive
						JOptionPane.showMessageDialog(null, "This account is inactive, please contact your Administrator");
					}
					if(activeUser.getStatus() == 1) {
						//At this point creditentail ok and account is set to view
						new MainView().setUserSession(activeUser).setVisible(true);
						CloseFrame();	
					}
					if(activeUser.getStatus() == 2) {
						//At this point password request is made.
						JOptionPane.showMessageDialog(null,"A change password was requested for this account","Password Change",JOptionPane.INFORMATION_MESSAGE);
						new ChangePasswordView().setUserSession(activeUser).setVisible(true);
						CloseFrame();
					}
					
									
				}else {
					JOptionPane.showMessageDialog(null, "Unable to Login");
				}
			} 
			
		});
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(new Color(255, 165, 0));
		
		JLabel lblCreateYourAccount = new JLabel("Create your account");
		lblCreateYourAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CloseFrame();
				new SignUpView().setVisible(true);
			}
		});
		lblCreateYourAccount.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCreateYourAccount.setForeground(new Color(0, 0, 128));
		lblCreateYourAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCreateYourAccount.setBounds(209, 129, 132, 14);
		log_element.add(lblCreateYourAccount);
		
		
		JPanel toRight = new TopRightPanel();
		toRight.setBorder(null);
		toRight.setBounds(271, 0, 469, 383);
		log_element.add(toRight);
		toRight.setBackground(new Color(255, 255, 255));
		toRight.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Welcome");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 41));
		lblNewLabel_5.setBounds(256, 39, 198, 41);
		toRight.add(lblNewLabel_5);
		
		JLabel lblBack = new JLabel("Back.");
		lblBack.setForeground(Color.WHITE);
		lblBack.setFont(new Font("Tahoma", Font.BOLD, 41));
		lblBack.setBounds(336, 75, 118, 41);
		toRight.add(lblBack);
		
		JLabel lblDevelopedByCode = new JLabel("Developed by Code Zero Limited");
		lblDevelopedByCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDevelopedByCode.setForeground(new Color(255, 255, 255));
		lblDevelopedByCode.setBounds(248, 160, 211, 14);
		toRight.add(lblDevelopedByCode);
		
		JLabel lblOvelHeslop = new JLabel("Ovel Heslop .");
		lblOvelHeslop.setForeground(new Color(255, 255, 255));
		lblOvelHeslop.setBounds(272, 179, 73, 14);
		toRight.add(lblOvelHeslop);
		
		JLabel lblTajhnaMccourtie = new JLabel("Tajhna McCourtie");
		lblTajhnaMccourtie.setForeground(Color.WHITE);
		lblTajhnaMccourtie.setBounds(348, 179, 111, 14);
		toRight.add(lblTajhnaMccourtie);
		
		JLabel lblRuelAndrews = new JLabel("Ruel Andrews .");
		lblRuelAndrews.setForeground(Color.WHITE);
		lblRuelAndrews.setBounds(292, 195, 111, 14);
		toRight.add(lblRuelAndrews);
		
		JLabel lblCordelReid = new JLabel("Cordel Reid");
		lblCordelReid.setForeground(Color.WHITE);
		lblCordelReid.setBounds(381, 195, 73, 14);
		toRight.add(lblCordelReid);
		
		CloseMinimize minimizeBar = new CloseMinimize(this);
		minimizeBar.setButton(CloseMinimizeIcon.Minimize);
		minimizeBar.setBounds(387, 0, 32, 32);
		toRight.add(minimizeBar);
		
		CloseMinimize closeBar = new CloseMinimize(this);
		closeBar.setButton(CloseMinimizeIcon.Close);
		closeBar.setCloseOption(JFrame.EXIT_ON_CLOSE);
		closeBar.setBounds(422, 0, 32, 32);
		toRight.add(closeBar);
		
				
		WindowDragger frameDrag = new WindowDragger(this);
		frameDrag.setBounds(0, 0, 728, 36);
		log_element.add(frameDrag);
	}

	public void CloseFrame(){
	    super.dispose();
	}
	
	private void activateSubmit() {
			if(usernameState && passwordState) {
			btnSubmit.setEnabled(true);
		}else{
			btnSubmit.setEnabled(false);
		}
	}
	
	private Boolean isUserAuthenticated() {
		//setup the variables and get the information from the inputs 
		String username = this.txtfield_username.getText();
		String password =  this.txtfield_password.getText(); 
		
		//check if email is email
		if(!Helper.isEmail(username)) {
			JOptionPane.showMessageDialog(null, "Invalid Email Address", "Invaid Email" , JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return checkDatabaseForUser(username, password);
	}

	private Boolean checkDatabaseForUser(String username, String password) {
		try {
			
			//Perform query and capture the result from the database
			ResultSet resultSet = dc.executeStatementReturnResult("SELECT * FROM user WHERE `email` =  '"+username+"'");
			
			//check to see if database return a result
			if(!resultSet.isBeforeFirst()) {
				return false;	
			}
			else 
			{
				resultSet.first();
				if(password.equals(resultSet.getString("password"))) {
					//setup information user to use throughout the life of the program
					activeUser = new User(
							resultSet.getInt("id"),
							resultSet.getString("first_name"),
							resultSet.getString("last_name"),
							resultSet.getString("email"),
							null,
							resultSet.getString("usertype"),
							resultSet.getInt("status")
							);
					return true;
				}
				else
				{
					return false;
				}
								
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}

