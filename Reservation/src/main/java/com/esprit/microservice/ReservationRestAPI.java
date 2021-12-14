package com.esprit.microservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.Reservation;
import com.esprit.microservice.ReservationService;




@RestController
@RequestMapping(value = "/api/reservation")
public class ReservationRestAPI {

	
	private String title = "Hello, I'm the Reservation Microservice";
	@Autowired
	private ReservationService reservationservice;
	@RequestMapping("/hello")
	public String sayHello() {
		System.out.println(title);
		return title;
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Reservation> createCandidat(@RequestBody Reservation rec) {
		return new ResponseEntity<>(reservationservice.addReservation(rec), HttpStatus.OK);
	}
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Reservation> updateCandidat(@PathVariable(value = "id") int id,
    										@RequestBody Reservation rec){
		return new ResponseEntity<>(reservationservice.updateReservation(id, rec), HttpStatus.OK);
	}
	@DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id){
		return new ResponseEntity<>(reservationservice.deleteReservation(id), HttpStatus.OK);
	}
	
	
	
	
	
}
