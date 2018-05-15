package cw.heslop.mas;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import com.toedter.calendar.JMonthChooser;
import javax.swing.JLabel;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JYearChooser;

import cw.heslop.mas.component.AppointmentItem;
import cw.heslop.mas.objects.DatabaseConnection;
import cw.heslop.mas.objects.TimeOfDay;

import com.toedter.calendar.JCalendar;
import com.jgoodies.common.internal.RenderingUtils;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Rectangle;

public class AppointmentView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4938760156551727580L;
	private JPanel contentPane;
	private DatabaseConnection conn = new DatabaseConnection("mas");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AppointmentView window = new AppointmentView();
					window.setVisible(true);
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
		setBackground(Color.DARK_GRAY);
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("Appointment Manager");
		setBounds(100, 100, 815, 448);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBounds(0, 0, 244, 603);
		contentPane.setLayout(null);
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		
		JButton btnAdd = new JButton("");
		btnAdd.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdd.setBorder(new LineBorder(new Color(255, 165, 0), 1, true));
		btnAdd.setIcon(new ImageIcon(AppointmentView.class.getResource("/icons/icons8_Plus_Math_32px.png")));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(Color.DARK_GRAY);
		btnAdd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAdd.setBounds(758, 367, 41, 41);
		contentPane.add(btnAdd);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 275, 566);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 165, 0));
		panel_3.setBounds(0, 44, 275, 375);
		panel.add(panel_3);
		
		
		
		
		JPanel pnl_workspace = new JPanel();
		pnl_workspace.setBackground(Color.DARK_GRAY);
		pnl_workspace.setBounds(285, 153, 514, 287);
		contentPane.add(pnl_workspace);
		pnl_workspace.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(10, 11, 275, 238);
		pnl_workspace.add(calendar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(301, 129, 203, 117);
		pnl_workspace.add(textArea);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(301, 72, 203, 47);
		pnl_workspace.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(301, 11, 203, 47);
		pnl_workspace.add(comboBox_1);
		
				
		//check if coming from the patient list view with a patient ID, else show new 
				String query = "SELECT * FROM `appointment` `a`, `person` `p` WHERE `appointment_date`>='"+Helper.getTodayDateTimeStamp(TimeOfDay.start)+"' "
						+ "AND `appointment_date`<'"+Helper.getTodayDateTimeStamp(TimeOfDay.end)+"' AND `appointment_date`<'2018-05-16T00:00' "
								+ "AND `a`.`person_id`=`p`.`id`"; 
				ResultSet rs = conn.executeStatementReturnResult(query);
				System.out.println(query);
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
					
					
					DefaultListModel<JPanel> model = new DefaultListModel<JPanel>();
					while(rs.next()) {
						String name = rs.getString("first_name")+" "+rs.getString("last_name");
						String doctorName = rs.getString("doctor_name");
						JPanel aItem = new AppointmentItem(Helper.dateFormatter("MMMM dd, yyyy",new Date(rs.getDate("appointment_date").getTime())),name,doctorName); 
						model.addElement(aItem);
					}
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(0, 0, 275, 364);
//					scrollPane.setBounds(0, 212, 212, 266);
					final JScrollBar scrollBar = scrollPane.getVerticalScrollBar();
					 scrollBar.addAdjustmentListener(new AdjustmentListener() {
				            @Override
				            public void adjustmentValueChanged(AdjustmentEvent e) {
				                System.out.println("JScrollBar's current value = " + scrollBar.getValue());
				            }
				        });
					panel_3.setLayout(null);
					panel_3.add(scrollPane);
					
					JList<JPanel> list1 = new JList<JPanel>(model);
					scrollPane.setColumnHeaderView(list1);
					list1.setFixedCellHeight(65);
					list1.setBounds(0, 0, 275, 400);
					list1.setBackground(new Color(255, 165, 0));
					list1.setBorder(null);
					list1.setCellRenderer(new PanelRenderer());
					
					JLabel lblAppointment = new JLabel("Appointment");
					lblAppointment.setOpaque(true);
					lblAppointment.setHorizontalTextPosition(SwingConstants.CENTER);
					lblAppointment.setHorizontalAlignment(SwingConstants.CENTER);
					lblAppointment.setBackground(new Color(255, 165, 0));
					lblAppointment.setBounds(0, 0, 275, 47);
					panel.add(lblAppointment);
					lblAppointment.setForeground(new Color(255, 255, 255));
					lblAppointment.setFont(new Font("Tahoma", Font.BOLD, 18));
					
					JPanel panel_1 = new JPanel();
					panel_1.setBounds(285, 11, 514, 143);
					contentPane.add(panel_1);
					panel_1.setBackground(new Color(255, 165, 0));
					panel_1.setLayout(null);
					
					JLabel lbl_appointmentDate = new JLabel("May 15, 2018");
					lbl_appointmentDate.setHorizontalAlignment(SwingConstants.CENTER);
					lbl_appointmentDate.setForeground(SystemColor.inactiveCaptionBorder);
					lbl_appointmentDate.setFont(new Font("Tahoma", Font.BOLD, 12));
					lbl_appointmentDate.setBounds(0, 159, 275, 25);
					panel_1.add(lbl_appointmentDate);
					
					JLabel lblPatientId = new JLabel("Patient ID: ");
					lblPatientId.setForeground(new Color(0, 0, 0));
					lblPatientId.setBounds(10, 53, 94, 29);
					panel_1.add(lblPatientId);
					lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 11));
					
					JLabel lblNewLabel_2 = new JLabel("501");
					lblNewLabel_2.setForeground(new Color(0, 0, 0));
					lblNewLabel_2.setBounds(79, 56, 80, 22);
					panel_1.add(lblNewLabel_2);
					lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
					
					JLabel lblName = new JLabel("Name: ");
					lblName.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblName.setForeground(new Color(0, 0, 0));
					lblName.setBounds(10, 87, 46, 14);
					panel_1.add(lblName);
					
					JLabel lblOvelHeslop = new JLabel("Ovel Heslop");
					lblOvelHeslop.setForeground(new Color(0, 0, 0));
					lblOvelHeslop.setBounds(79, 89, 117, 14);
					panel_1.add(lblOvelHeslop);
					
					JLabel lblContact = new JLabel("Contact: ");
					lblContact.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblContact.setForeground(new Color(0, 0, 0));
					lblContact.setBounds(10, 112, 59, 14);
					panel_1.add(lblContact);
					
					JLabel label = new JLabel("(187)-879-8547");
					label.setForeground(new Color(0, 0, 0));
					label.setBounds(79, 114, 160, 14);
					panel_1.add(label);
					
					JLabel lblEmail = new JLabel("Email: ");
					lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
					lblEmail.setForeground(new Color(0, 0, 0));
					lblEmail.setBounds(10, 134, 46, 14);
					panel_1.add(lblEmail);
					
					JLabel lblKayheslopgmailcom = new JLabel("kayheslop@gmail.com");
					lblKayheslopgmailcom.setForeground(new Color(0, 0, 0));
					lblKayheslopgmailcom.setBounds(79, 134, 186, 14);
					panel_1.add(lblKayheslopgmailcom);

					
					
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
		
	}
	
	
}
