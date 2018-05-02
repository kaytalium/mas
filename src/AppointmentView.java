import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JLabel;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JCalendar;
import com.jgoodies.common.internal.RenderingUtils;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.ImageIcon;

public class AppointmentView {

	private JFrame frmAppointmentView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentView window = new AppointmentView();
					window.frmAppointmentView.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AppointmentView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAppointmentView = new JFrame();
		frmAppointmentView.getContentPane().setBackground(Color.DARK_GRAY);
		frmAppointmentView.setBackground(Color.WHITE);
		frmAppointmentView.setResizable(false);
		frmAppointmentView.setTitle("Appointment View");
		frmAppointmentView.setBounds(100, 100, 815, 630);
		frmAppointmentView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAppointmentView.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		frmAppointmentView.getContentPane().add(panel);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 244, 603);
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("MAS");
		lblNewLabel.setBounds(10, 20, 124, 58);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
		
		JLabel lblNewLabel_1 = new JLabel("Medical Appointment System");
		lblNewLabel_1.setBounds(10, 77, 212, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(244, 102, 566, 70);
		frmAppointmentView.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPatientId = new JLabel("Patient ID: ");
		lblPatientId.setBounds(34, 10, 94, 29);
		panel_2.add(lblPatientId);
		lblPatientId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(103, 13, 80, 22);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setBounds(338, 14, 51, 20);
		panel_2.add(lblDate);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(399, 14, 88, 20);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JButton btnAdd = new JButton("  New Appointment");
		btnAdd.setIcon(new ImageIcon("C:\\Users\\Tajhna\\Dropbox\\Java - Share\\Small Green Plus Sign 1.png"));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.DARK_GRAY);
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAdd.setBounds(588, 182, 189, 41);
		frmAppointmentView.getContentPane().add(btnAdd);
		
		JLabel lblApp = new JLabel("Manage Appointments");
		lblApp.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblApp.setForeground(Color.WHITE);
		lblApp.setBounds(427, 26, 298, 41);
		frmAppointmentView.getContentPane().add(lblApp);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(285, 250, 473, 316);
		frmAppointmentView.getContentPane().add(calendar);
		
	}
}
