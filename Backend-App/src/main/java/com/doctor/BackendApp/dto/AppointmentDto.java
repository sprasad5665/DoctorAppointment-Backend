package com.doctor.BackendApp.dto;

import java.util.Date;

public class AppointmentDto {
	
	private int appointmentId;
	private int patientId;
	private int doctorId;
	private Date appointMentDate;
	private String time;
	private String appointmentStatus;
	private String remarks;
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public Date getAppointMentDate() {
		return appointMentDate;
	}
	public void setAppointMentDate(Date appointMentDate) {
		this.appointMentDate = appointMentDate;
	}
	public String getAppointmentStatus() {
		return appointmentStatus;
	}
	public void setAppointmentStatus(String appointmentStatus) {
		this.appointmentStatus = appointmentStatus;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	

}
