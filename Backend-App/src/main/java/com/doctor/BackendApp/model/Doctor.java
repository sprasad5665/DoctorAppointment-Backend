package com.doctor.BackendApp.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "doctor", schema = "public")
public class Doctor implements java.io.Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "doctor_id")
	private int doctorId;

	@Column(name = "doctor_name")
	private String doctorName;

	@Column(name = "speciality")
	private String speciality;

	@Column(name = "location")
	private String location;

	@Column(name = "hospital_name")
	private String hospitalName;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "charged_per_visit")
	private double chargedPerVisit;

	@JsonIgnore
	@OneToMany(mappedBy = "doctor")
	private Set<Appointment> appointment;

	 @JsonIgnore
	@OneToOne
	@PrimaryKeyJoinColumn(name = "doctor_id", referencedColumnName = "user_id")
	private User user;
	
	 @JsonIgnore
	 @OneToMany(mappedBy = "doctor")
	private Set<FeedBack> feedBack;
	
	 @JsonIgnore
	@OneToOne(mappedBy = "doctor")
	private AvailabilityDates availabilityDates;

	public Doctor() {
		super();
	}

	public Doctor(int doctorId, String doctorName, String speciality, String location, String hospitalName,
			String mobileNo, String email, String password, double chargedPerVisit, Set<Appointment> appointment, User user,
			Set<FeedBack> feedBack, AvailabilityDates availabilityDates) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.speciality = speciality;
		this.location = location;
		this.hospitalName = hospitalName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.chargedPerVisit = chargedPerVisit;
		this.appointment = appointment;
		this.user = user;
		this.feedBack = feedBack;
		this.availabilityDates = availabilityDates;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getChargedPerVisit() {
		return chargedPerVisit;
	}

	public void setChargedPerVisit(double chargedPerVisit) {
		this.chargedPerVisit = chargedPerVisit;
	}

	

	

	public Set<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(Set<Appointment> appointment) {
		this.appointment = appointment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public AvailabilityDates getAvailabilityDates() {
		return availabilityDates;
	}

	public void setAvailabilityDates(AvailabilityDates availabilityDates) {
		this.availabilityDates = availabilityDates;
	}

	public Set<FeedBack> getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(Set<FeedBack> feedBack) {
		this.feedBack = feedBack;
	}

	
	
	
}
