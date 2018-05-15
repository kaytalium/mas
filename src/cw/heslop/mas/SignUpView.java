package cw.heslop.mas;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.LineBorder;

import cw.heslop.mas.component.CloseMinimize;
import cw.heslop.mas.component.MPasswordField;
import cw.heslop.mas.component.MTextField;
import cw.heslop.mas.component.WindowDragger;
import cw.heslop.mas.objects.CloseMinimizeIcon;
import cw.heslop.mas.objects.DatabaseConnection;

import java.awt.Component;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class SignUpView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 893523976981987064L;

	private JPanel contentPane;

	private MTextField txtfield_fname;
	private MTextField txtfield_lname;
	private MTextField txtfield_email;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblSignUp;
	private MPasswordField txtfield_password;
	private MPasswordField txtfield_rtype_password;
	private JPanel panel_3;
	private JLabel lblNewLabel_6;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JComboBox<?> option_userType;
	
	private String[] userData = new String[5];
	private JLabel frameDragger;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView frame = new SignUpView();
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
	public SignUpView() {
		setUndecorated(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 728, 383);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 165, 0));
		panel_1.setBounds(1, 1, 726, 32);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		CloseMinimize minimizeBtn = new CloseMinimize(this);
		minimizeBtn.setButton(CloseMinimizeIcon.Minimize);
		minimizeBtn.setBounds(660, 0, 32, 32);
		panel_1.add(minimizeBtn);
		
		CloseMinimize closeBtn = new CloseMinimize(this);
		closeBtn.setButton(CloseMinimizeIcon.Close);
		closeBtn.setCloseOption(JFrame.DISPOSE_ON_CLOSE);
		closeBtn.setNavigateToView(new LoginView());
		closeBtn.setBounds(693, 0, 32, 32);
		panel_1.add(closeBtn);
		
		
		
		frameDragger = new WindowDragger(this);
		frameDragger.setBounds(1, 1, 727, 32);
		panel_1.add(frameDragger);
		
		panel = new JPanel();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		panel.setBackground(Color.WHITE);
		panel.setBounds(1, 29, 403, 352);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtfield_fname = new MTextField();
		txtfield_fname.setPlaceholder("First Name");
		txtfield_fname.setBounds(21, 157, 176, 35);
		panel.add(txtfield_fname);
		txtfield_fname.setColumns(10);
		
		txtfield_lname = new MTextField();
		txtfield_lname.setPlaceholder("Last Name");
		txtfield_lname.setBounds(217, 157, 176, 35);
		panel.add(txtfield_lname);
		txtfield_lname.setColumns(10);
		
		txtfield_email = new MTextField();
		txtfield_email.setMargin(new Insets(5, 10, 5, 5));
		txtfield_email.setPlaceholder("example@example.com");
		txtfield_email.setBounds(22, 92, 176, 35);
		panel.add(txtfield_email);
		txtfield_email.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(isValidate()) {
					//store the information to the database
					System.out.println("Email: "+userData[0]);
					String query = "INSERT INTO user(`email`,`first_name`,`last_name`,`password`,`usertype`) VALUES('"+userData[0]+"','"+userData[1]+"','"+userData[2]+"','"+userData[3]+"','"+userData[4]+"')";
					DatabaseConnection dc = new DatabaseConnection("mas");
					dc.CRUD(query);
					JOptionPane.showMessageDialog(null, "You're account was created sucessfully");
					new LoginView().setVisible(true);
					CloseFrame();
				}
			}
		});
		btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignUp.setBounds(21, 280, 176, 50);
		panel.add(btnSignUp);
		btnSignUp.setForeground(Color.WHITE);
		btnSignUp.setBackground(new Color(51, 204, 0));
		
		lblNewLabel = new JLabel("First Name");
		lblNewLabel.setBounds(21, 137, 68, 14);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.GRAY);
		
		lblNewLabel_1 = new JLabel("Last Name ");
		lblNewLabel_1.setBounds(217, 137, 75, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.GRAY);
		
		lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBounds(21, 72, 46, 14);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.GRAY);
		
		lblNewLabel_3 = new JLabel("User Type\r\n");
		lblNewLabel_3.setBounds(217, 72, 75, 14);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.GRAY);
		
		lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(21, 203, 68, 14);
		panel.add(lblNewLabel_4);
		lblNewLabel_4.setForeground(Color.GRAY);
		
		lblNewLabel_5 = new JLabel("Re-type Password");
		lblNewLabel_5.setBounds(217, 203, 110, 14);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setForeground(Color.GRAY);
		
		option_userType = new JComboBox();
		option_userType.setOpaque(false);
		option_userType.setBackground(new Color(255, 255, 255));
		option_userType.setBorder(new CompoundBorder(new LineBorder(new Color(128, 128, 128)), new EmptyBorder(0, 5, 0, 0)));
		option_userType.setBounds(217, 92, 176, 35);
		panel.add(option_userType);
		option_userType.setModel(new DefaultComboBoxModel(new String[] {"-- Select UserType --", "Admin Assistant", "Medical Staff"}));
		option_userType.setEditable(true);
		
		lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblSignUp.setBounds(21, 11, 176, 50);
		panel.add(lblSignUp);
		
		txtfield_password = new MPasswordField();
		txtfield_password.setPlaceholder("Password");
		txtfield_password.setColumns(10);
		txtfield_password.setBounds(21, 222, 176, 35);
		panel.add(txtfield_password);
		
		txtfield_rtype_password = new MPasswordField();
		txtfield_rtype_password.setPlaceholder("Re-type Password");
		txtfield_rtype_password.setColumns(10);
		txtfield_rtype_password.setBounds(217, 222, 176, 35);
		panel.add(txtfield_rtype_password);
		
		JLabel lblAlreadyHaveAn = new JLabel("I'm already a member");
		lblAlreadyHaveAn.setBounds(243, 283, 150, 40);
		panel.add(lblAlreadyHaveAn);
		lblAlreadyHaveAn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAlreadyHaveAn.setBackground(Color.DARK_GRAY);
		lblAlreadyHaveAn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new LoginView().setVisible(true);
				CloseFrame();
			}
		});
		lblAlreadyHaveAn.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlreadyHaveAn.setForeground(Color.DARK_GRAY);
		lblAlreadyHaveAn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		label = new JLabel("*");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setForeground(Color.RED);
		label.setBounds(82, 136, 15, 14);
		panel.add(label);
		
		label_1 = new JLabel("*");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(278, 136, 15, 14);
		panel.add(label_1);
		
		label_2 = new JLabel("*");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(79, 203, 15, 14);
		panel.add(label_2);
		
		label_3 = new JLabel("*");
		label_3.setForeground(Color.RED);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(55, 72, 15, 14);
		panel.add(label_3);
		
		label_4 = new JLabel("*");
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(275, 72, 15, 14);
		panel.add(label_4);
		
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_3.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		panel_3.setBounds(403, 29, 323, 352);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		

		try {
			BufferedImage myPicture = ImageIO.read(new File("image/music_signup.jpg"));
			lblNewLabel_6 = new JLabel(new ImageIcon(myPicture));
			lblNewLabel_6.setBounds(0, 0, 325, 348);
			panel_3.add(lblNewLabel_6);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	protected boolean isValidate() {
		// TODO Auto-generated method stub
		//Get all the textbox from the view
		//Email, userType, Firstname, Lastname, password, retype password
		if(!Helper.isEmail(txtfield_email.getText())){
			JOptionPane.showMessageDialog(null,"Invalid Email Address");
			return false;
		}
		if(txtfield_email.getText().equals(txtfield_email.getPlaceholder())) {
			JOptionPane.showMessageDialog(null,"Email address cannot be left empty");
			return false;
		}
		if(option_userType.getSelectedItem().toString().equals("-- Select UserType --")) {
			JOptionPane.showMessageDialog(null,"Please select a User Type");
			return false;
		}
		if(txtfield_fname.getText().equals(txtfield_fname.getPlaceholder())) {
			JOptionPane.showMessageDialog(null,"First Name cannot be left empty");
			return false;
		}
		if(txtfield_lname.getText().equals(txtfield_lname.getPlaceholder())) {
			JOptionPane.showMessageDialog(null,"Last Name cannot be left empty");
			return false;
		}
		if(txtfield_password.getText().equals(txtfield_password.getPlaceholder())) {
			JOptionPane.showMessageDialog(null,"Password cannot be left empty");
			return false;
		}
		if(txtfield_password.getText().length() > 0 && txtfield_rtype_password.getText().equals(txtfield_rtype_password.getPlaceholder())) {
			JOptionPane.showMessageDialog(null,"Please Enter password again");
			return false;
		}
		if(txtfield_password.getText().length() > 0 && !txtfield_rtype_password.getText().equals(txtfield_rtype_password.getPlaceholder()) && !txtfield_password.getText().equals(txtfield_rtype_password.getText())) {
			JOptionPane.showMessageDialog(null,"Password does not match");
			return false;
		}
		//once the program get to this point then all fields are validated and have the correct data 
		// therefore we can store the values from the user in a global var for further use.
		userData[0] = txtfield_email.getText();
		userData[1] = txtfield_fname.getText();
		userData[2] = txtfield_lname.getText();
		userData[3] = txtfield_password.getText();
		userData[4] = option_userType.getSelectedItem().toString();		
		return true;
	}

	public void CloseFrame(){
	    super.dispose();
	}
}
