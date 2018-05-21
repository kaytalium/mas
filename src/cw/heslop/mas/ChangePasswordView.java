package cw.heslop.mas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import cw.heslop.mas.component.Arrow;
import cw.heslop.mas.component.CloseMinimize;
import cw.heslop.mas.component.MPasswordField;
import cw.heslop.mas.component.WindowDragger;
import cw.heslop.mas.objects.CloseMinimizeIcon;
import cw.heslop.mas.objects.DatabaseConnection;
import cw.heslop.mas.objects.User;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class ChangePasswordView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3362278369569666816L;
	private JPanel contentPane;
	private MPasswordField txtfield_new_password;
	private MPasswordField txtfield_retype_password;
	private DatabaseConnection dc;
	private User activeUser; 
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChangePasswordView frame = new ChangePasswordView();
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
	public ChangePasswordView() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 728, 383);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Arrow panel_2 = new Arrow();
		panel_2.setBounds(260, 1, 100, 381);
		contentPane.add(panel_2);
		panel_2.setBackground(new Color(255, 165, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_3.setBounds(1, 1, 259, 381);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("MAS");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 50));
		label_1.setBackground(Color.WHITE);
		label_1.setBounds(50, 11, 130, 53);
		panel_3.add(label_1);
		
		JLabel label_3 = new JLabel("Medical Appointment System");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_3.setBounds(81, 59, 183, 23);
		panel_3.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(ChangePasswordView.class.getResource("/icons/icons8_Stethoscope_64px.png")));
		label_4.setBounds(27, 11, 105, 103);
		panel_3.add(label_4);
		
		WindowDragger frameDragger = new WindowDragger(this);
		frameDragger.setBounds(0, 0, 653, 28);
		contentPane.add(frameDragger);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(225, 1, 501, 381);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 165, 0));
		panel_1.setBounds(177, 72, 299, 278);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewPassword.setBounds(10, 28, 134, 23);
		panel_1.add(lblNewPassword);
		lblNewPassword.setForeground(new Color(255, 255, 255));
		
		txtfield_new_password = new MPasswordField();
		txtfield_new_password.setPlaceholder("Enter new password");
		txtfield_new_password.setBorder(new CompoundBorder(null, new EmptyBorder(0, 5, 0, 5)));
		txtfield_new_password.setBounds(10, 50, 245, 31);
		panel_1.add(txtfield_new_password);
		
		JLabel lblRetypeNewPassword = new JLabel("Re-type New Password");
		lblRetypeNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRetypeNewPassword.setBounds(10, 92, 186, 23);
		panel_1.add(lblRetypeNewPassword);
		lblRetypeNewPassword.setForeground(new Color(255, 255, 255));
		
		txtfield_retype_password = new MPasswordField();
		txtfield_retype_password.setPlaceholder("Re-type your password");
		txtfield_retype_password.setBorder(new CompoundBorder(null, new EmptyBorder(0, 5, 0, 5)));
		txtfield_retype_password.setBounds(10, 116, 245, 31);
		panel_1.add(txtfield_retype_password);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmit.setBorder(null);
		btnSubmit.setBounds(10, 177, 245, 34);
		panel_1.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(isValidated()) {
					//Connecting to database
					try {
						dc = new DatabaseConnection("mas");
						String query = "UPDATE user set password='"+activeUser.getPassword()+"', status='1' Where id='"+activeUser.getUserID()+"'";
						dc.CRUD(query);
						JOptionPane.showMessageDialog(null, "Your password was successfully changed, you may log in with the new password.", "Change Password", JOptionPane.INFORMATION_MESSAGE);
						new LoginView().setVisible(true);
						CloseFrame();
					}
					catch(Exception e) {
							System.out.println("Error: " + e);
					}
					
				}
								
			} 
		});
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBackground(new Color(51, 204, 0));
		
		JLabel lblBackToLogin = new JLabel("Back to login");
		lblBackToLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBackToLogin.setBounds(10, 244, 245, 23);
		panel_1.add(lblBackToLogin);
		lblBackToLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				new LoginView().setVisible(true);
				CloseFrame();
			}
		});
		lblBackToLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackToLogin.setForeground(new Color(255, 255, 255));
		lblBackToLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		CloseMinimize minimizeBtn = new CloseMinimize(this);
		minimizeBtn.setButton(CloseMinimizeIcon.Minimize);
		minimizeBtn.setBounds(434, 0, 32, 32);
		panel.add(minimizeBtn);
		
		CloseMinimize closeBtn = new CloseMinimize(this);
		closeBtn.setButton(CloseMinimizeIcon.Close);
		closeBtn.setCloseOption(JFrame.DISPOSE_ON_CLOSE);
		closeBtn.setNavigateToView(new LoginView());
		closeBtn.setBounds(469, 0, 32, 32);
		panel.add(closeBtn);
		
		JLabel lblChangePassword = new JLabel("Change Password");
		lblChangePassword.setForeground(new Color(255, 255, 255));
		lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblChangePassword.setBounds(177, 35, 299, 39);
		panel.add(lblChangePassword);
	}
	
	protected boolean isValidated() {
		//Get the values from the user from both text fields
		String new_password = txtfield_new_password.getText();
		String retype_password = txtfield_retype_password.getText();
		
		if(new_password.equals(txtfield_new_password.getPlaceholder())) {
			JOptionPane.showMessageDialog(null, "New Password cannot be empty", "User input error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if(new_password.length() < 8 ) {
			JOptionPane.showMessageDialog(null, "Password must be at least 8 characters", "User input error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if(retype_password.equals(txtfield_retype_password.getPlaceholder())) {
			JOptionPane.showMessageDialog(null, "Re-type Password cannot be empty", "User input error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}		
		if(retype_password.length() < 8 ) {
			JOptionPane.showMessageDialog(null, "Retype Password must be at least 8 characters", "User input error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		if(new_password.length() > 0 && retype_password.length() > 0 && !new_password.equals(retype_password)) {
			JOptionPane.showMessageDialog(null, "Password does not match", "User input error", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
		
		activeUser.setPassword(new_password);
		return true;
	}

	public void CloseFrame(){
	    super.dispose();
	}

	public ChangePasswordView setUserSession(User activeUser) {
		// TODO Auto-generated method stub
		this.activeUser = activeUser;
		return this;
	}

}
