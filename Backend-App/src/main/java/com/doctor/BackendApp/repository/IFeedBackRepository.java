package com.doctor.BackendApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doctor.BackendApp.model.Appointment;
import com.doctor.BackendApp.model.FeedBack;

@Repository
public interface IFeedBackRepository extends JpaRepository<FeedBack, Integer>  {
	


}
