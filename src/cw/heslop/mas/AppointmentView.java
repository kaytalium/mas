package cw.heslop.mas;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import cw.heslop.mas.objects.AppointmentObj;
import cw.heslop.mas.objects.DatabaseConnection;
import com.toedter.calendar.JCalendar;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;

public class AppointmentView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4938760156551727580L;
	private JPanel contentPane;
	private DatabaseConnection conn = new DatabaseConnection("mas");
	private JComboBox cb_doctor;
	private JComboBox cb_service;
	private JLabel lbl_patientID;
	private JTextArea txt_remarks;
	private JComboBox cb_time;
	private JCalendar calendar;
	private JLabel lbl_mode;
	private AppointmentObj currentAppointment = null;
	private JButton btnCancel;
	private boolean isNew = true;
	
	private int patientID;
	private MainView parent;
	private PatientViewer appointmentViewContainer;
	

	public PatientViewer getAppointmentViewContainer() {
		return appointmentViewContainer;
	}

	public void setAppointmentViewContainer(PatientViewer appointmentViewContainer) {
		this.appointmentViewContainer = appointmentViewContainer;
	}

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

	public MainView getParent() {
		return parent;
	}

	public void setParent(MainView parent) {
		this.parent = parent;
	}

	/**
	 * Create the application.
	 */
	public AppointmentView() {
		setUndecorated(true);
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
		setBounds(100, 100, 468, 460);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 128)));
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBounds(0, 0, 244, 603);
		contentPane.setLayout(null);
		contentPane.setForeground(Color.WHITE);
		setContentPane(contentPane);
		
		
		
		
		JPanel pnl_workspace = new JPanel();
		pnl_workspace.setBackground(new Color(192, 192, 192));
		pnl_workspace.setBounds(1, 78, 465, 330);
		contentPane.add(pnl_workspace);
		pnl_workspace.setLayout(null);
		
		calendar = new JCalendar();
		calendar.setBounds(10, 11, 233, 156);
		pnl_workspace.add(calendar);
		
		txt_remarks = new JTextArea();
		txt_remarks.setWrapStyleWord(true);
		txt_remarks.setBorder(new CompoundBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), new EmptyBorder(5, 5, 5, 5)));
		txt_remarks.setBounds(10, 189, 446, 130);
		pnl_workspace.add(txt_remarks);
		
		cb_doctor = new JComboBox();
		cb_doctor.setBounds(253, 135, 203, 32);
		setListOfDoctors();
		pnl_workspace.add(cb_doctor);
		
		cb_service = new JComboBox();
		cb_service.setBounds(253, 82, 203, 32);
		this.setListOfService();
		pnl_workspace.add(cb_service);
		
		JLabel lblService = new JLabel("Service:");
		lblService.setBounds(253, 67, 46, 14);
		pnl_workspace.add(lblService);
		
		JLabel lblDoctor = new JLabel("Doctor: ");
		lblDoctor.setBounds(253, 121, 46, 14);
		pnl_workspace.add(lblDoctor);
		
		JLabel lblRemark = new JLabel("Remark: ");
		lblRemark.setBounds(10, 175, 83, 14);
		pnl_workspace.add(lblRemark);
		
		cb_time = new JComboBox();
		cb_time.setModel(new DefaultComboBoxModel(new String[] {"6:00:00", "6:15:00", "6:30:00", "7:00:00", "7:15:00", "7:30:00", "8:00:00", "8:15:00", "8:30:00", "9:00:00", "9:15:00", "9:30:00", "10:00:00", "10:15:00", "10:30:00", "11:00:00", "11:15:00", "11:30:00", "12:00:00 PM", "12:15:00 PM", "12:30:00 PM", "1:00:00 PM", "1:15:00 PM", "1:30:00 PM", "2:00:00 PM", "2:15:00", "2:30:00", "3:00:00", "3:15:00", "3:30:00", "4:00:00", "4:15:00", "4:30:00", "5:00:00", "5:15:00", "5:30:00", "6:00:00", "6:15:00", "6:30:00", "7:00:00", "7:15:00", "7:30:00", "8:00:00"}));
		cb_time.setBounds(253, 30, 203, 32);
		pnl_workspace.add(cb_time);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setBounds(253, 12, 46, 14);
		pnl_workspace.add(lblTime);
		
		
					
					JPanel panel_1 = new JPanel();
					panel_1.setBounds(1, 1, 465, 76);
					contentPane.add(panel_1);
					panel_1.setBackground(new Color(255, 255, 255));
					panel_1.setLayout(null);
					
					JLabel lblPatientId = new JLabel("Patient ID: ");
					lblPatientId.setForeground(new Color(0, 0, 0));
					lblPatientId.setBounds(5, 43, 63, 22);
					panel_1.add(lblPatientId);
					lblPatientId.setFont(new Font("Tahoma", Font.BOLD, 11));
					
					lbl_patientID = new JLabel("501");
					lbl_patientID.setForeground(new Color(0, 0, 0));
					lbl_patientID.setBounds(71, 43, 80, 22);
					panel_1.add(lbl_patientID);
					lbl_patientID.setFont(new Font("Tahoma", Font.PLAIN, 11));
					
					JLabel lblAppointmentManager = new JLabel("Appointment Manager");
					lblAppointmentManager.setBounds(5, 5, 233, 14);
					panel_1.add(lblAppointmentManager);
					
					lbl_mode = new JLabel("Adding Mode");
					lbl_mode.setBounds(375, 5, 80, 14);
					panel_1.add(lbl_mode);
					
					JButton btnSave = new JButton("Save");
					btnSave.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if(isNew) {
								createNewAppointment();
							}else {
								updateAppointment();	
								
							}
							
						}
					});
					btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnSave.setForeground(new Color(255, 255, 255));
					btnSave.setBackground(new Color(0, 128, 0));
					btnSave.setBounds(268, 419, 89, 30);
					contentPane.add(btnSave);
					
					btnCancel = new JButton("Cancel");
					btnCancel.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							closeFrame();
						}
					});
					btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					btnCancel.setBackground(new Color(255, 165, 0));
					btnCancel.setBounds(367, 419, 89, 30);
					contentPane.add(btnCancel);
					
					JSeparator separator = new JSeparator();
					separator.setBackground(new Color(255, 255, 255));
					separator.setBounds(0, 408, 540, 10);
					contentPane.add(separator);
		
	}

	protected void createNewAppointment() {
		// TODO Auto-generated method stub
		//get the input from the users
		String[] doctor = ((String) this.cb_doctor.getSelectedItem()).split(" - ");
		String[] service = ((String) this.cb_service.getSelectedItem()).split(" - ");
		String remark = this.txt_remarks.getText();
		Date date = Helper.createDateTime(new Date(this.calendar.getDate().getTime()), (String) this.cb_time.getSelectedItem());
		
		
		String query = "INSERT INTO appointment (patientID, date, doctorID, serviceID, remark) Values('"+this.getPatientID()+"',"
				+ " '"+Helper.dateFormatter("yyyy-MM-dd HH:mm:00", date)+"',"
						+ " '"+doctor[0]+"',"
								+ "'"+service[0]+"',"
										+ "'"+remark+"')";
		conn.CRUD(query);
		JOptionPane.showMessageDialog(null, "Appointment Created", "New Account", JOptionPane.INFORMATION_MESSAGE);
		btnCancel.setText("Ok");
		refreshApplication();
	}

	private void refreshApplication() {
		// TODO Auto-generated method stub
		this.getParent().activatePatientListView(Integer.toString(this.getPatientID()));
		this.appointmentViewContainer.setAppointments(Integer.toString(this.getPatientID()),0);
	}

	protected void updateAppointment() {
		// TODO Auto-generated method stub
//		get all the element from the display and update the database with only the value was changes
//		this is achieved by comparing the information from the values that came over to the value from the form.
		String[] doctor = ((String) this.cb_doctor.getSelectedItem()).split(" - ");
		String[] service = ((String) this.cb_service.getSelectedItem()).split(" - ");
		String remark = this.txt_remarks.getText();
		
		Date date = Helper.createDateTime(new Date(this.calendar.getDate().getTime()), (String) this.cb_time.getSelectedItem());
		
		//at this point we can now compare the appointment object to what was given to be saved
		
		Boolean updateFlag = false;
		int counter = 0;
		String query  = "UPDATE appointment set ";
		String queryBody = "";
		String queryTail = " WHERE id='"+this.currentAppointment.getAppointmentID()+"'";
		//Build the query based on the changes only and set update flag
		
		//Remark
		if(!this.currentAppointment.getRemarks().equals(remark)) {
			
			queryBody = "remark='"+remark+"'";
			updateFlag = true;
			counter++;
		}
		
		//Doctor
		if(this.currentAppointment.getDoctorID() != Integer.parseInt(doctor[0])) {
			
			if(updateFlag) {
				queryBody += ", doctorID='"+Integer.parseInt(doctor[0])+"'";
			}else {
				queryBody += "doctorID='"+Integer.parseInt(doctor[0])+"'";
			}
			
			updateFlag = true;
			counter++;
		}
		
		
		//Service
		if(this.currentAppointment.getServiceID() != Integer.parseInt(service[0])) {
			
			if(updateFlag) {
				queryBody += ", serviceID='"+Integer.parseInt(service[0])+"'";
			}else {
				queryBody += "serviceID='"+Integer.parseInt(service[0])+"'";
			}
			
			updateFlag = true;
			counter++;
		}
		
		//date and time
		if(this.currentAppointment.getAppointmentDate().compareTo(date)!=0) {
			if(updateFlag) {
				queryBody += ", date='"+Helper.dateFormatter("yyyy-MM-dd hh:mm:ss", date)+"'";
			}else {
				queryBody += "date='"+Helper.dateFormatter("yyyy-MM-dd hh:mm:ss", date)+"'";
			}
			
			updateFlag = true;
			counter++;
		}
		
		// UPDATE appointment SET remark='newRemark', 
		
		if(updateFlag) {
			query += queryBody + queryTail; 
			int option = JOptionPane.showConfirmDialog(null, "You are about to update "+counter+" "+(counter==1?"field":"fields")+" continue?","Updating Record",JOptionPane.YES_NO_OPTION); //JOptionPane.showConfirmDialog(null,"\"You are about to update \"+counter+\" fields\"", JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION);
			//0 yes
			//1 no
			if(option == 0) {
				conn.CRUD(query);
				this.btnCancel.setText("Ok");
				refreshApplication();
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Nothing to update", "Appointment Manager", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}

	protected void closeFrame() {
		// TODO Auto-generated method stub
		this.dispose();
	}
	
	private void setListOfDoctors() {
		String query = "SELECT * FROM `doctor`";
		ResultSet rs = conn.executeStatementReturnResult(query);
		try {
			
			int size = Helper.dbrowCount(rs);
			String[] list = new String[size]; 
			int counter = 0;
			
			while(rs.next()) {
				list[counter] = rs.getInt("id")+" - "+rs.getString("name");
				counter++;
			}
			this.cb_doctor.setModel(new DefaultComboBoxModel(list));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void setListOfService() {
		String query = "SELECT * FROM `service`";
		ResultSet rs = conn.executeStatementReturnResult(query);
		try {
			
			int size = Helper.dbrowCount(rs);
			String[] list = new String[size]; 
			int counter = 0;
			
			while(rs.next()) {
				list[counter] = rs.getInt("id")+" - "+rs.getString("name");
				counter++;
			}
			this.cb_service.setModel(new DefaultComboBoxModel(list));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
		this.lbl_patientID.setText(Integer.toString(patientID));
	}

	public void setCurrentAppointment(AppointmentObj currentAppointment) {
		this.currentAppointment = currentAppointment;
	}
	
	public void setupForEdit() {
		// TODO Auto-generated method stub
		//setting time and date next
		this.lbl_mode.setText("Edit Mode");
		this.isNew = false;
		this.calendar.setDate(this.currentAppointment.getAppointmentDate());
		this.cb_time.setSelectedItem(Helper.dateFormatter("h:mm:00",this.currentAppointment.getAppointmentDate()));
		this.cb_service.setSelectedItem(this.currentAppointment.getServiceID()+" - "+this.currentAppointment.getService_name());
		this.cb_doctor.setSelectedItem(this.currentAppointment.getDoctorID()+" - "+this.currentAppointment.getDoctors_name());		
		this.txt_remarks.setText(this.currentAppointment.getRemarks());
		
		
		
	}
}
