package com.esprit.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.Reservation;
import com.esprit.microservice.ReservationRepository;

@Service
public class ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;

	public Reservation addReservation(Reservation r) {
		return reservationRepository.save(r);
	}
	public Reservation updateReservation(int id, Reservation newRec) {
		if (reservationRepository.findById(id).isPresent()) {
			Reservation existingRec = reservationRepository.findById(id).get();
			existingRec.setSujet(newRec.getSujet());
			existingRec.setBloc(newRec.getBloc());
			

			return reservationRepository.save(existingRec);
		} else
			return null;
	}
	public String deleteReservation(int id) {
		if (reservationRepository.findById(id).isPresent()) {
			reservationRepository.deleteById(id);
			return "reservation supprimé";
		} else
			return "reservation non supprimé";
	}
	

}


