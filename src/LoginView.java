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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

public class LoginView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 835459818027446290L;
	private JPanel contentPane;
	private JTextField txtfield_username;
	private JPasswordField txtfield_password;
	private JButton btnSubmit;
	private JLabel lblNewLabel_3;
	private boolean usernameState = false;
	private boolean passwordState  =false;
	
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
		setLocationByPlatform(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 383);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 10));
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel log_element = new JPanel();
		log_element.setBorder(null);
		log_element.setBackground(new Color(255, 255, 255));
		log_element.setBounds(0, 0, 728, 383);
		contentPane.add(log_element);
		log_element.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setBounds(77, 157, 67, 23);
		log_element.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.GRAY);
		
		txtfield_username = new JTextField();
		txtfield_username.setBounds(76, 179, 265, 28);
		log_element.add(txtfield_username);
		txtfield_username.setForeground(Color.BLACK);
		txtfield_username.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(77, 218, 68, 14);
		log_element.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.GRAY);
		
		txtfield_password = new JPasswordField();
		txtfield_password.setBounds(77, 238, 265, 28);
		log_element.add(txtfield_password);
		txtfield_password.setForeground(Color.BLACK);
		
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
				CloseFrame();
				new ChangePasswordView().setVisible(true);
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
//					JOptionPane.showMessageDialog(null, "Login was Successful");
					
					new MainWindow().setVisible(true);
					CloseFrame();
					
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
		
		JLabel lblX = new JLabel("");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.setIcon(new ImageIcon(LoginView.class.getResource("/icons/icons8_Multiply_32px.png")));
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblX.setBounds(420, 0, 32, 37);
		toRight.add(lblX);
	}
	
	public void CloseFrame(){
	    super.dispose();
	}
	
	private void activateSubmit() {
		// TODO Auto-generated method stub
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
		
		//once we are here the user have satisfied the login criteria
		
		//We can now connect to database and get the information for the data that was provided and return a 
		//boolean result
		return checkDatabaseForUser(username, password);
	}

	private Boolean checkDatabaseForUser(String username, String password) {
		// TODO Auto-generated method stub
		try {
			DatabaseConnection dc = new DatabaseConnection("mas");
			//Perform query and capture the result from the database
			ResultSet resultSet = dc.executeStatementReturnResult("SELECT * FROM user WHERE `username` =  '"+username+"'");
			
			//check to see if database return a result
			if(!resultSet.isBeforeFirst()) {
				return false;	
			}
			else 
			{
				resultSet.first();
				if(password.equals(resultSet.getString("password"))) {
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

