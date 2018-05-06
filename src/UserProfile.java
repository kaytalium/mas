import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.ComponentOrientation;

public class UserProfile extends JPanel {
	public MPasswordField pwdf_new_pwd;
	public MPasswordField pwdf_retype_pwd;
	private final JSeparator separator_1 = new JSeparator();
	public JButton btnNewButton;
	public JLabel lblBackToMenu;
	public JPanel error_msg;
	private JLabel lbl_error_text;
	public JLabel lbl_fname;
	public JLabel lbl_lname;
	public JLabel lbl_email;
	public JLabel lbl_acct_type;
	
	private int userID;
	/**
	 * Create the panel.
	 */
	public UserProfile() {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JPanel pl_change_pwd = new JPanel();
		pl_change_pwd.setVisible(false);
		pl_change_pwd.setBackground(Color.WHITE);
		pl_change_pwd.setBounds(419, 50, 416, 301);
		add(pl_change_pwd);
		pl_change_pwd.setLayout(null);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setBounds(21, 25, 193, 26);
		pl_change_pwd.add(lblNewPassword);
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		pwdf_new_pwd = new MPasswordField();
		pwdf_new_pwd.setPlaceholder("Enter new password");
		pwdf_new_pwd.setBounds(21, 50, 193, 39);
		pl_change_pwd.add(pwdf_new_pwd);
		
		JLabel lblRetypePassword = new JLabel("Retype Password");
		lblRetypePassword.setBounds(21, 100, 193, 26);
		pl_change_pwd.add(lblRetypePassword);
		lblRetypePassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		pwdf_retype_pwd = new MPasswordField();
		pwdf_retype_pwd.setPlaceholder("Retype password");
		pwdf_retype_pwd.setBounds(21, 125, 193, 39);
		pl_change_pwd.add(pwdf_retype_pwd);
		separator_1.setBounds(10, 11, 33, 290);
		pl_change_pwd.add(separator_1);
		separator_1.setOrientation(SwingConstants.VERTICAL);
		
		btnNewButton = new JButton("Change");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				char[] newPwd = pwdf_new_pwd.getPassword();
				char[] retypePwd = pwdf_retype_pwd.getPassword();
				String np = new String(newPwd);
				String rp = new String(retypePwd);
				
				
			//Handle errors 
				//check if inputs are the same
				if(!np.equals(rp) && np.length() >= 8) {
					error_msg.setBackground(new Color(255, 0, 0));
					lbl_error_text.setText("Password does not match. Please try again");
					error_msg.setVisible(true);
				}
				
				
				if(np.length() < 8) {
					error_msg.setBackground(new Color(255, 0, 0));
					lbl_error_text.setText("Password must be greater than 8 charaters long");
					error_msg.setVisible(true);
				}
				
				//handle when everything is ok
				if(np.equals(rp) && np.length() > 3) {
					error_msg.setBackground(new Color(0, 128, 0));
					lbl_error_text.setText("Everything seems ok, UPDATING NOW...");
					error_msg.setVisible(true);
					
					DatabaseConnection dc = new DatabaseConnection("mas");
					dc.CRUD("UPDATE user set password='"+np+"' WHERE id='"+userID+"'");
					//handle the changing of the password and then close the password box
				}
				
			}
		});
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBounds(21, 186, 193, 39);
		pl_change_pwd.add(btnNewButton);
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		
		error_msg = new JPanel();
		error_msg.setVisible(false);
		error_msg.setBackground(new Color(255, 0, 0));
		error_msg.setBounds(21, 248, 349, 42);
		pl_change_pwd.add(error_msg);
		error_msg.setLayout(null);
		
		lbl_error_text = new JLabel("Paswword must be atleast 8 characters long");
		lbl_error_text.setForeground(Color.WHITE);
		lbl_error_text.setFont(new Font("Tahoma", Font.BOLD, 12));
		lbl_error_text.setBounds(10, 11, 329, 20);
		error_msg.add(lbl_error_text);
		
				
		JLabel lblNewLabel = new JLabel("User Profile");
		lblNewLabel.setIcon(new ImageIcon(UserProfile.class.getResource("/icons/icons8_Human_Head_50px.png")));
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 26));
		lblNewLabel.setBounds(48, 38, 292, 41);
		add(lblNewLabel);
		
		JLabel lblJohnDoe = new JLabel("Last name:");
		lblJohnDoe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblJohnDoe.setBounds(63, 127, 106, 26);
		add(lblJohnDoe);
		
		JLabel lblFirstName = new JLabel("First name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFirstName.setBounds(63, 90, 123, 26);
		add(lblFirstName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(63, 164, 106, 26);
		add(lblEmail);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUserType.setBounds(63, 201, 106, 32);
		add(lblUserType);
		
		JLabel lblPassword = new JLabel("Click here to change password");
		lblPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				resetPasswordControl(pl_change_pwd);
			}
		});
		lblPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPassword.setBounds(63, 253, 315, 26);
		add(lblPassword);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(63, 248, 338, 14);
		add(separator);
		
		lbl_fname = new JLabel("John\r\n");
		lbl_fname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_fname.setBounds(181, 93, 228, 24);
		add(lbl_fname);
		
		lbl_lname = new JLabel("Doe");
		lbl_lname.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_lname.setBounds(181, 127, 228, 24);
		add(lbl_lname);
		
		lbl_email = new JLabel("John.doe@example.com\r\n");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_email.setBounds(181, 166, 228, 24);
		add(lbl_email);
		
		lbl_acct_type = new JLabel("Admin Staff");
		lbl_acct_type.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_acct_type.setBounds(179, 207, 228, 24);
		add(lbl_acct_type);
		
		lblBackToMenu = new JLabel("Back to Menu");
		lblBackToMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
				if(pl_change_pwd.isVisible()) {
					pwdf_retype_pwd.setText("");
					pwdf_new_pwd.setText("");
					pl_change_pwd.setVisible(false);
					error_msg.setVisible(false);
				}
				
			}
		});
		lblBackToMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblBackToMenu.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblBackToMenu.setIcon(new ImageIcon(UserProfile.class.getResource("/icons/icons8_Left_32px_1.png")));
		lblBackToMenu.setForeground(new Color(0, 0, 0));
		lblBackToMenu.setBounds(686, 11, 139, 14);
		add(lblBackToMenu);
		
	}
	
	public void setUserID(int userID){
		this.userID =userID;
	}
	
	void resetPasswordControl(JPanel pl){
		if(pl.isVisible()) {
			pl.setVisible(false);
			pwdf_new_pwd.setText("");
			pwdf_retype_pwd.setText("");
			error_msg.setVisible(false);
			
		}else {
			pl.setVisible(true);
		}
	}
	
	private void sleeper() {
		try {
			Thread.sleep(2500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
