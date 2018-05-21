package cw.heslop.mas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextArea;
import java.awt.Color;

public class About extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private MainView app;
	
	public static void main(String[] args) {
		try {
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About() {
		setTitle("MAS: About");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(192, 192, 192));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		
		addWindowListener(new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		        app.setEnabled(true);
		        dispose();
		    }
		});
		
		
		contentPanel.setLayout(null);
		{
			JLabel lblAbout = new JLabel("About");
			lblAbout.setFont(new Font("Tahoma", Font.BOLD, 26));
			lblAbout.setBounds(10, 0, 118, 47);
			contentPanel.add(lblAbout);
		}
		{
			JLabel lblVersion = new JLabel("Version: 1.0.56");
			lblVersion.setFont(new Font("Monospaced", Font.PLAIN, 11));
			lblVersion.setBounds(32, 61, 144, 14);
			contentPanel.add(lblVersion);
		}
		{
			JLabel lblBuildIdcz = new JLabel("Build id: 0124-85478-5cz");
			lblBuildIdcz.setFont(new Font("Monospaced", Font.PLAIN, 11));
			lblBuildIdcz.setBounds(32, 77, 174, 14);
			contentPanel.add(lblBuildIdcz);
		}
		
		JTextArea txtrcCopyrightEclipse = new JTextArea();
		txtrcCopyrightEclipse.setEditable(false);
		txtrcCopyrightEclipse.setBackground(new Color(192, 192, 192));
		txtrcCopyrightEclipse.setFont(new Font("Monospaced", Font.PLAIN, 14));
		txtrcCopyrightEclipse.setText("(c) Copyright Code Zero 2018.  All rights reserved. \r\nMAS is trademark of the Code Zero Inc. \r\nhttps://www.codezero/mas. The MAS software \r\ncannot be altered without Code Zero's permission. \r\nMAS is provided for under the Code Zero user \r\nguidelines, https://www.codezero/mas/guides/. ");
		txtrcCopyrightEclipse.setWrapStyleWord(true);
		txtrcCopyrightEclipse.setBounds(10, 102, 414, 148);
		contentPanel.add(txtrcCopyrightEclipse);
	}
	
	public void setApp(MainView app) {
		this.app = app;
	}
}
