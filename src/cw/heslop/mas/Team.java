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
import java.awt.Color;

public class Team extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private MainView app;
	
	public static void main(String[] args) {
		try {
			Team dialog = new Team();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Team() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
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
			JLabel label = new JLabel("Team");
			label.setForeground(Color.BLACK);
			label.setFont(new Font("Dialog", Font.BOLD, 20));
			label.setEnabled(true);
			label.setBounds(10, 11, 67, 46);
			contentPanel.add(label);
		}
		
		JLabel label = new JLabel("Ovel Heslop");
		label.setBounds(100, 66, 105, 14);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("Tajhna McCourtie");
		label_1.setBounds(100, 91, 105, 14);
		contentPanel.add(label_1);
		
		JLabel label_2 = new JLabel("Ruel Andrews");
		label_2.setBounds(100, 113, 105, 14);
		contentPanel.add(label_2);
		
		JLabel label_3 = new JLabel("Cordel Reid");
		label_3.setBounds(100, 138, 105, 14);
		contentPanel.add(label_3);
		
		JLabel label_4 = new JLabel("Technical Director");
		label_4.setBounds(214, 66, 155, 14);
		contentPanel.add(label_4);
		
		JLabel label_5 = new JLabel("Commucation Director");
		label_5.setBounds(214, 91, 155, 14);
		contentPanel.add(label_5);
		
		JLabel label_6 = new JLabel("Finance Director");
		label_6.setBounds(215, 113, 105, 14);
		contentPanel.add(label_6);
		
		JLabel label_7 = new JLabel("Human Resource Director");
		label_7.setBounds(214, 138, 155, 14);
		contentPanel.add(label_7);
		
		JLabel label_8 = new JLabel("www.codezero/mas");
		label_8.setForeground(Color.BLUE);
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_8.setBounds(10, 236, 138, 14);
		contentPanel.add(label_8);
		
		JLabel label_9 = new JLabel("copyright @ Code Zero 2018");
		label_9.setForeground(Color.BLUE);
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label_9.setBounds(272, 236, 152, 14);
		contentPanel.add(label_9);
	}
	
	public void setApp(MainView app) {
		this.app = app;
	}

}
