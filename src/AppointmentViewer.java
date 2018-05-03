import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.border.LineBorder;

public class AppointmentViewer extends JFrame {

	private JPanel contentPane;
	private DatabaseConnection conn = new DatabaseConnection("mas");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentViewer frame = new AppointmentViewer();
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
	@SuppressWarnings("serial")
	public AppointmentViewer() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Appointment View");
		setBounds(100, 100, 998, 630);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setBackground(new Color(255, 165, 0));
		panel.setBounds(0, 0, 244, 603);
		panel.setLayout(null);
		panel.setForeground(Color.WHITE);
				
		JLabel lblNewLabel = new JLabel("MAS");
		lblNewLabel.setBounds(58, 11, 78, 41);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		
		JLabel lblNewLabel_1 = new JLabel("Medical Appointment System");
		lblNewLabel_1.setBounds(58, 40, 212, 20);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel lblApp = new JLabel("Manage Appointments");
		lblApp.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblApp.setBounds(10, 119, 244, 41);
		panel.add(lblApp);
		lblApp.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblApp.setForeground(Color.WHITE);
		
		
		//check if coming from the patient list view with a patient ID, else show new 
		String query = "SELECT * FROM `appointment` WHERE `appointment_date`>='"+Helper.getTodayDateTimeStamp(TimeOfDay.start)+"' AND `appointment_date`<'"+Helper.getTodayDateTimeStamp(TimeOfDay.end)+"'"; 
		ResultSet rs = conn.executeStatementReturnResult(query);
		
		class PanelRenderer implements ListCellRenderer<Object> {

		    @Override
		    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		    	AppointmentItem renderer = (AppointmentItem) value;
		        renderer.setBackground(isSelected ? Color.lightGray : list.getBackground());
		        return renderer;
		    }
		}
		
		
		
		try {
			
			//get the size of the row 
			rs.last();
		    int size = rs.getRow();
		    rs.beforeFirst();
		    
			JLabel lblOfPatients = new JLabel();
			if(size>0) {
				lblOfPatients.setText(size+" patients with appointments today");
			}
			else if(size == 0) {
				lblOfPatients.setText("No Appointment for Today");
			}
			lblOfPatients.setBounds(10, 187, 212, 14);
			panel.add(lblOfPatients);
			
			DefaultListModel<JPanel> model = new DefaultListModel<JPanel>();
			while(rs.next()) {
				JPanel aItem = new AppointmentItem(Helper.dateFormatter("MMMM dd, yyyy",new Date(rs.getDate("appointment_date").getTime()))); 
				model.addElement(aItem);
			}
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 212, 212, 266);
			final JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
			 scrollBar.addAdjustmentListener(new AdjustmentListener() {
		            @Override
		            public void adjustmentValueChanged(AdjustmentEvent e) {
		                System.out.println("JScrollBar's current value = " + scrollBar.getValue());
		            }
		        });
			panel.add(scrollPane);
			
			JList<JPanel> list = new JList<JPanel>(model);
			scrollPane.setColumnHeaderView(list);
			list.setFixedCellHeight(40);
			list.setBackground(new Color(255, 165, 0));
			list.setBorder(null);
			list.setCellRenderer(new PanelRenderer());
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(AppointmentViewer.class.getResource("/icons/icons8_Stethoscope_64px_3.png")));
			label.setBounds(20, 29, 64, 64);
			panel.add(label);
			
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(244, 23, 748, 98);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblPatientId = new JLabel("Patient Name: ");
		lblPatientId.setBounds(33, 11, 94, 29);
		panel_2.add(lblPatientId);
		lblPatientId.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2 = new JLabel("John Doe");
		lblNewLabel_2.setBounds(125, 14, 80, 22);
		panel_2.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblDate = new JLabel("Date: ");
		lblDate.setBounds(33, 38, 51, 20);
		panel_2.add(lblDate);
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_3 = new JLabel("April 30, 2018");
		lblNewLabel_3.setBounds(68, 38, 88, 20);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		//set the current time and date to the label 
		lblNewLabel_3.setText(Helper.getCurrentDate("MMM dd, yyyy"));
		
		JButton btnAdd = new JButton("  New Appointment");
		btnAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdd.setBorderPainted(false);
		btnAdd.setBorder(null);
		btnAdd.setIcon(new ImageIcon("C:\\Users\\Tajhna\\Dropbox\\Java - Share\\Small Green Plus Sign 1.png"));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color(255, 165, 0));
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAdd.setBounds(813, 132, 151, 41);
		getContentPane().add(btnAdd);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(244, 199, 748, 349);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 33, 280, 169);
		panel_1.add(calendar);
		
		JTextArea txtrHelloWorld = new JTextArea();
		txtrHelloWorld.setText("Hello world");
		txtrHelloWorld.setBounds(10, 229, 280, 92);
		panel_1.add(txtrHelloWorld);
	}
}
