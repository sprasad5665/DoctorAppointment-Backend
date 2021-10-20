package com.doctor.BackendApp.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.doctor.BackendApp.dto.AppointmentDetailsForAdminDto;
import com.doctor.BackendApp.dto.AppointmentDto;
import com.doctor.BackendApp.model.Appointment;
import com.doctor.BackendApp.model.Doctor;

public interface IAppointmentService {
	
	List<Appointment> getAllAppointments();

	ResponseEntity<AppointmentDto> getAppointment(int appointMentid);

	Appointment addAppointment(AppointmentDto appointmentDto);

	ResponseEntity<Appointment> deleteAppointment(Integer appointMentid);

	Appointment updateAppointment(AppointmentDto appointmentDto, Integer id);

	List<Appointment> getAppointmentListByDoctor(Doctor doctor);

	List<Appointment> getAppointmentListByDate(LocalDate Date);
	
	List<AppointmentDetailsForAdminDto> getAllAppointmentsForAdmin();

}
