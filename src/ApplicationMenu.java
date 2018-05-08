import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ApplicationMenu extends JMenuBar{

	private JFrame jframe;
	/**
	 * 
	 */
	private static final long serialVersionUID = 7710791988288866966L;

	public ApplicationMenu(JFrame jframe) {
		super();
		setBorderPainted(false);
		setBorder(new LineBorder(new Color(192, 192, 192)));
		setPreferredSize(new Dimension(0, 25));
		setFont(new Font("Segoe UI", Font.PLAIN, 20));
		setBounds(new Rectangle(0, 0, 0, 150));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 500, 10);
		
		this.jframe = jframe;
		jframe.setJMenuBar(this);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setPreferredSize(new Dimension(50, 22));
		mnFile.setMargin(new Insets(0, 10, 0, 0));
		mnFile.setIconTextGap(6);
		mnFile.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnNew.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_File_32px.png")));
		mnNew.setPreferredSize(new Dimension(250, 40));
		mnFile.add(mnNew);
		
		JMenuItem mntmNewPatient = new JMenuItem("New Patient");
		mntmNewPatient.setPreferredSize(new Dimension(190, 35));
		mntmNewPatient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new NewPatient().setVisible(true);
				jframe.dispose();
			}
			
			
		});
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
		this.add(mnProfile);
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Settings_32px.png")));
		mntmSettings.setPreferredSize(new Dimension(250, 40));
		mnProfile.add(mntmSettings);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Logout_Rounded_Up_32px.png")));
		mntmLogout.setPreferredSize(new Dimension(81, 40));
		mnProfile.add(mntmLogout);
		
		JMenu mnAbout = new JMenu("About");
		this.add(mnAbout);
		
		JMenuItem mntmTeam = new JMenuItem("Team");
		mntmTeam.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_People_32px.png")));
		mntmTeam.setPreferredSize(new Dimension(250, 40));
		mnAbout.add(mntmTeam);
		
		JMenuItem mntmApplication = new JMenuItem("Application");
		mntmApplication.setIcon(new ImageIcon(MainWindow.class.getResource("/icons/icons8_Google_Code_32px.png")));
		mntmApplication.setPreferredSize(new Dimension(105, 40));
		mnAbout.add(mntmApplication);
	}

}
