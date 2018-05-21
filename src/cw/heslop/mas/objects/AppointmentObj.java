package cw.heslop.mas.objects;

import java.sql.Timestamp;

public class AppointmentObj {

	private int appointmentID;
	private int patientID;
	private Timestamp appointmentDate;
	private String doctors_name;
	private String service_name;
	private String Remarks;
	private int doctorID;
	private int serviceID;
	
	public AppointmentObj() {
		// TODO Auto-generated constructor stub	
	}

	public AppointmentObj(int appointmentID, int patientID, Timestamp appointmentDate, String doctors_name,
			String service_name, String remarks) {
		this.appointmentID = appointmentID;
		this.patientID = patientID;
		this.appointmentDate = appointmentDate;
		this.doctors_name = doctors_name;
		this.service_name = service_name;
		Remarks = remarks;
	}
	
	

	public AppointmentObj(int appointmentID, int patientID, Timestamp appointmentDate, String doctors_name,
			String service_name, String remarks, int doctorID, int serviceID) {
		this.appointmentID = appointmentID;
		this.patientID = patientID;
		this.appointmentDate = appointmentDate;
		this.doctors_name = doctors_name;
		this.service_name = service_name;
		Remarks = remarks;
		this.doctorID = doctorID;
		this.serviceID = serviceID;
	}

	public int getAppointmentID() {
		return appointmentID;
	}

	public void setAppointmentID(int appointmentID) {
		this.appointmentID = appointmentID;
	}

	public int getPatientID() {
		return patientID;
	}

	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}

	public Timestamp getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Timestamp appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getDoctors_name() {
		return doctors_name;
	}

	public void setDoctors_name(String doctors_name) {
		this.doctors_name = doctors_name;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public int getServiceID() {
		return serviceID;
	}

	public void setServiceID(int serviceID) {
		this.serviceID = serviceID;
	}
	
	

}
