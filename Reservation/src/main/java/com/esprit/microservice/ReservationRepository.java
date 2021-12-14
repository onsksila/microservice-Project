package com.esprit.microservice;


import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.microservice.Reservation;






public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
	
	
	

	   
}