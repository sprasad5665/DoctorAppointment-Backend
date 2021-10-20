package com.doctor.BackendApp.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.doctor.BackendApp.dto.AppointmentDetailsForAdminDto;
import com.doctor.BackendApp.dto.AppointmentDto;
import com.doctor.BackendApp.model.Appointment;
import com.doctor.BackendApp.model.Doctor;
import com.doctor.BackendApp.model.Patient;
import com.doctor.BackendApp.repository.IAppointmentRepository;

@Component
public class IAppointmentImpl implements IAppointmentService {
	private static Logger LOGGER = LoggerFactory.getLogger(IAppointmentImpl.class);

	@Autowired
	private IAppointmentRepository iAppointmentRepository;

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		return iAppointmentRepository.findAll();
	}

	@Override
	public ResponseEntity<AppointmentDto> getAppointment(int appointMentid) {
		Optional<Appointment> appointmentOptional = iAppointmentRepository.findById(appointMentid);
		Appointment appointment = appointmentOptional.get();
		AppointmentDto appointmentDto = new AppointmentDto();
		try {

			appointmentDto.setDoctorId(appointment.getDoctor().getDoctorId());
			appointmentDto.setPatientId(appointment.getPatient().getPatientId());
			appointmentDto.setAppointmentId(appointment.getAppointmentId());
			appointmentDto.setTime(appointment.getAppointmentTime());
			appointmentDto.setRemarks(appointment.getRemark());
			appointmentDto.setAppointMentDate(appointment.getAppointmentDate());

			return new ResponseEntity<>(appointmentDto, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(appointmentDto, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOGGER.error("error " + e);
			return new ResponseEntity<>(appointmentDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Appointment addAppointment(AppointmentDto appointmentDto) {
		Appointment appointment = new Appointment();
		appointment.setAppointmentId(appointmentDto.getAppointmentId());
		Doctor doctor = new Doctor();
		doctor.setDoctorId(appointmentDto.getDoctorId());
		appointment.setDoctor(doctor);
		Patient patient = new Patient();
		patient.setPatientId(appointmentDto.getPatientId());
		appointment.setPatient(patient);
		LocalTime t = LocalTime.parse("17:40");

		try {

			String dateStr = "Mon Jun 18 00:00:00 IST 2012";
			DateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
			Date date = (Date) formatter.parse(appointmentDto.getAppointMentDate().toString());
			System.out.println(date);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			date = sdf.parse(sdf.format(date));
			System.out.println(date);
			appointment.setAppointmentDate(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		appointment.setAppointmentTime(appointmentDto.getTime());
		appointment.setAppointmentStatus(appointmentDto.getAppointmentStatus());
		appointment.setRemark(appointmentDto.getRemarks());
		return iAppointmentRepository.save(appointment);
	}

	@Override
	public ResponseEntity<Appointment> deleteAppointment(Integer appointMentid) {
		Optional<Appointment> appointmentOptional = iAppointmentRepository.findById(appointMentid);
		Appointment appointment = appointmentOptional.get();
		try {
			iAppointmentRepository.delete(appointment);
			;
			return new ResponseEntity<>(appointment, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(appointment, HttpStatus.BAD_REQUEST);
		} catch (Exception e) {
			LOGGER.error("error " + e);
			return new ResponseEntity<>(appointment, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public Appointment updateAppointment(AppointmentDto appointmentDto, Integer id) {

		Optional<Appointment> appointmentOptional = iAppointmentRepository.findById(id);
		Appointment appointment = appointmentOptional.get();
		if (appointmentDto.getTime() != null) {
			appointment.setAppointmentTime(appointmentDto.getTime());
		}
		if (appointmentDto.getAppointmentStatus() != null) {
			appointment.setAppointmentStatus(appointmentDto.getAppointmentStatus());
		}
		Doctor doctor = new Doctor();
		doctor.setDoctorId(appointmentDto.getDoctorId());
		appointment.setDoctor(doctor);
		Patient patient = new Patient();
		patient.setPatientId(appointmentDto.getPatientId());
		appointment.setPatient(patient);
		if (appointmentDto.getAppointMentDate() != null) {
			appointment.setAppointmentDate(appointmentDto.getAppointMentDate());
		}
		if (appointmentDto.getRemarks() != null) {
			appointment.setRemark(appointmentDto.getRemarks());
		}
		return iAppointmentRepository.save(appointment);
	}

	@Override
	public List<Appointment> getAppointmentListByDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getAppointmentListByDate(LocalDate Date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppointmentDetailsForAdminDto> getAllAppointmentsForAdmin() {
		return ((List<Appointment>) iAppointmentRepository.findAll()).stream().map(this::convertToUserLocationDTO)
				.collect(Collectors.toList());
	}

	private AppointmentDetailsForAdminDto convertToUserLocationDTO(Appointment appointment) {

		AppointmentDetailsForAdminDto appointmentDetailsForAdminDto = new AppointmentDetailsForAdminDto();
		appointmentDetailsForAdminDto.setAppointmentId(appointment.getAppointmentId());
		appointmentDetailsForAdminDto.setPatientName(appointment.getPatient().getPatientName());
		appointmentDetailsForAdminDto.setDoctorName(appointment.getDoctor().getDoctorName());
		if (appointment.getAppointmentDate() != null) {
			appointmentDetailsForAdminDto.setAppointmentDate(appointment.getAppointmentDate().toString());
		}
		appointmentDetailsForAdminDto.setAppointmentTime(appointment.getAppointmentTime());
		appointmentDetailsForAdminDto.setAppointmentStatus(appointment.getAppointmentStatus());
		appointmentDetailsForAdminDto.setReason(appointment.getRemark());
		appointmentDetailsForAdminDto.setPatientPhneNo(appointment.getPatient().getMobileNo());
		return appointmentDetailsForAdminDto;
	}
}
