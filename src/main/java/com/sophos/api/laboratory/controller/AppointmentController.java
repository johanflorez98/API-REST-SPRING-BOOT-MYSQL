package com.sophos.api.laboratory.controller;


import java.util.List;
import java.util.Optional;

import com.sophos.api.laboratory.ServiceImp.AppointmentServiceImp;
import com.sophos.api.laboratory.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controller/Appointment")
public class AppointmentController {

	@Autowired
	private AppointmentServiceImp appointmentServiceImp;

	@GetMapping
	public ResponseEntity<List<Appointment>> getlist() {

		List<Appointment> appointment = appointmentServiceImp.getlist();

		if (appointment.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(appointment);
		}
	}
	
	@GetMapping(value = "/{appointmentID}")
	public ResponseEntity<Appointment> getbyid(@PathVariable("appointmentID") Long appointmentID) {

		Optional<Appointment> optionalAppointment = appointmentServiceImp.getbyid(appointmentID);

		if (optionalAppointment.isPresent()) {
			return ResponseEntity.ok(optionalAppointment.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<Void> post(@RequestBody Appointment appointment) {

		String appointment_r = appointmentServiceImp.post(appointment);

		if (appointment_r == "Save") {
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Appointment> put(@RequestBody Appointment appointment) {

		Optional<Appointment> appointmentOptional = appointmentServiceImp.put(appointment);

		if (appointmentOptional.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.status(HttpStatus.CREATED).body(appointmentOptional.get());
		}
	}

	@DeleteMapping(value = "/{appointmentID}")
	public ResponseEntity<Void> delete(@PathVariable("appointmentID") Long appointmentID) {

		String result = appointmentServiceImp.delete(appointmentID);

		if (result == "deleted") {
			
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
	}
	
	@RequestMapping(value = "/byAffiliate/{id_affiliate}", method = RequestMethod.GET)
	public ResponseEntity<List<Appointment>> getbyaffiliate(@PathVariable("id_affiliate") Long id_affiliate){
		
		List<Appointment> appointment = appointmentServiceImp.getbyaffiliate(id_affiliate);

		if (appointment.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(appointment);
		}
	}
	
	@RequestMapping(value = "/bydate/{date}", method = RequestMethod.GET)
	public ResponseEntity<List<Appointment>> getbydate(@PathVariable("date") String date){
		
		List<Appointment> appointment = appointmentServiceImp.getbydate(date);

		if (appointment.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.ok(appointment);
		}
	}
	
}