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
@Table(name = "patient", schema = "public")
public class Patient implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "patient_id")
	private int patientId;

	@Column(name = "patient_name")
	private String patientName;

	@Column(name = "mobile_no")
	private String mobileNo;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@Column(name = "blood_group")
	private String bloodGroup;

	@Column(name = "gender")
	private String gender;

	@Column(name = "age")
	private int age;

	@Column(name = "address")
	private String address;

	@JsonIgnore
	@OneToMany(mappedBy = "patient")
	private Set<Appointment> appointment;

	@JsonIgnore
	@OneToOne
	@PrimaryKeyJoinColumn(name = "patient_id", referencedColumnName = "user_id")
	private User user;

	@JsonIgnore
	@OneToMany(mappedBy = "patient")
	private Set<FeedBack> feedback;

	public Patient() {
		super();
	}

	public Patient(int patientId, String patientName, String mobileNo, String email, String password, String bloodGroup,
			String gender, int age, String address, Set<Appointment> appointment, User user, Set<FeedBack> feedback) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.password = password;
		this.bloodGroup = bloodGroup;
		this.gender = gender;
		this.age = age;
		this.address = address;
		this.appointment = appointment;
		this.user = user;
		this.feedback = feedback;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
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

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Set<FeedBack> getFeedback() {
		return feedback;
	}

	public void setFeedback(Set<FeedBack> feedback) {
		this.feedback = feedback;
	}

	

}
