package cw.heslop.mas.component;
import java.awt.Color;
import java.awt.Desktop.Action;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Window;
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

import cw.heslop.mas.About;
import cw.heslop.mas.LoginView;
import cw.heslop.mas.MainView;
import cw.heslop.mas.NewPatientView;
import cw.heslop.mas.Team;



public class ApplicationMenu extends JMenuBar{

	private MainView mainParent;
	private JMenuItem mntmClose;

	private static final long serialVersionUID = 7710791988288866966L;

	public ApplicationMenu(MainView parent) {
		super();
		setBorderPainted(false);
		setBorder(new LineBorder(new Color(192, 192, 192)));
		setPreferredSize(new Dimension(0, 25));
		setFont(new Font("Segoe UI", Font.PLAIN, 20));
		setBounds(new Rectangle(0, 0, 0, 150));
		setBackground(new Color(255, 255, 255));
		setBounds(0, 0, 500, 10);
		
		this.mainParent = parent;
		parent.setJMenuBar(this);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setPreferredSize(new Dimension(50, 22));
		mnFile.setMargin(new Insets(0, 10, 0, 0));
		mnFile.setIconTextGap(6);
		mnFile.setHorizontalAlignment(SwingConstants.CENTER);
		this.add(mnFile);
		
		JMenu mnNew = new JMenu("New");
		mnNew.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/icons/icons8_File_32px.png")));
		mnNew.setPreferredSize(new Dimension(250, 40));
		mnFile.add(mnNew);
		
		JMenuItem mntmNewPatient = new JMenuItem("New Patient");
		mntmNewPatient.setPreferredSize(new Dimension(190, 35));
		mntmNewPatient.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(!mainParent.isNewPatientViewer && mainParent.isSettings) {
					//close settings and then open new
					mainParent.us.setVisible(false);
					mainParent.isSettings= false;
					mainParent.createNewPatientViewer(false, null);	
				}
				
				if(!mainParent.isNewPatientViewer && !mainParent.isSettings) {
					//close settings and then open new
					
					mainParent.createNewPatientViewer(false, null);	
				}
				
				
			}
			
			
		});
		mnNew.add(mntmNewPatient);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		mntmClose = new JMenuItem("Exit");
		mntmClose.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/icons/icons8_Exit_32px.png")));
		mntmClose.setPreferredSize(new Dimension(73, 40));
		mntmClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			
		});
		mnFile.add(mntmClose);
		
		JMenu mnProfile = new JMenu("Profile");
		mnProfile.setPreferredSize(new Dimension(56, 22));
		this.add(mnProfile);
		
		JMenuItem mntmSettings = new JMenuItem("Settings");
		mntmSettings.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/icons/icons8_Settings_32px.png")));
		mntmSettings.setPreferredSize(new Dimension(250, 40));
		mntmSettings.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainParent.settings();
			}
			
			
		});
		mnProfile.add(mntmSettings);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/icons/icons8_Logout_Rounded_Up_32px.png")));
		mntmLogout.setPreferredSize(new Dimension(81, 40));
		mntmLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LoginView().setVisible(true);
				mainParent.dispose();				
			}
			
			
		});
		mnProfile.add(mntmLogout);
		
		JMenu mnAbout = new JMenu("About");
		this.add(mnAbout);
		
		JMenuItem mntmTeam = new JMenuItem("Team");
		mntmTeam.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/icons/icons8_People_32px.png")));
		mntmTeam.setPreferredSize(new Dimension(250, 40));
		mntmTeam.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Team team = new Team();
				team.setVisible(true);
				team.setApp(mainParent);				
				mainParent.setEnabled(false);
			}
			
		});
		mnAbout.add(mntmTeam);
		
		JMenuItem mntmApplication = new JMenuItem("Application");
		mntmApplication.setIcon(new ImageIcon(ApplicationMenu.class.getResource("/icons/icons8_Google_Code_32px.png")));
		mntmApplication.setPreferredSize(new Dimension(105, 40));
		mntmApplication.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				About about = new About();
				about.setVisible(true);
				about.setApp(mainParent);				
				mainParent.setEnabled(false);
			}
			
		});
		mnAbout.add(mntmApplication);
	}




	

}
