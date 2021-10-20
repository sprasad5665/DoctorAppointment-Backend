package com.doctor.BackendApp.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.doctor.BackendApp.dto.FeedbackDto;
import com.doctor.BackendApp.model.Appointment;
import com.doctor.BackendApp.model.Doctor;
import com.doctor.BackendApp.model.FeedBack;
import com.doctor.BackendApp.model.Patient;
import com.doctor.BackendApp.repository.IFeedBackRepository;
import com.doctor.BackendApp.service.IFeedBackService;

@Component
public class IFeedBackImpl implements IFeedBackService {
	private static Logger LOGGER = LoggerFactory.getLogger(IFeedBackImpl.class);

	@Autowired
	private IFeedBackRepository iFeedBackRepository;

	@Override
	public FeedBack addFeedBack(FeedbackDto feedbackDto) {
		System.out.println("feedback "+feedbackDto.getFeedBackId());
		FeedBack feedBack = new FeedBack();
		feedBack.setFeedbackId(feedbackDto.getFeedBackId());
		Doctor doctor = new Doctor();
		doctor.setDoctorId(feedbackDto.getDoctorId());
		feedBack.setDoctor(doctor);
		Patient patient = new Patient();
		patient.setPatientId(feedbackDto.getPatientId());
		feedBack.setPatient(patient);
		feedBack.setRating(feedbackDto.getRating());
		feedBack.setFeedbackComment(feedbackDto.getFeedbackComment());
		return iFeedBackRepository.save(feedBack);
	}

	@Override
	public ResponseEntity<FeedBack> getFeedBack(FeedBack feedBack) {
		Optional<FeedBack> feedBackOptional = iFeedBackRepository.findById(feedBack.getFeedbackId());;
		FeedBack feedBackData = null;
		if(feedBackOptional.isPresent()) {
			 feedBackData = feedBackOptional.get();
			return new ResponseEntity<>(feedBackData,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(feedBackData,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public List<FeedBack> getAllFeedBack() {
		return iFeedBackRepository.findAll();
	}

}
