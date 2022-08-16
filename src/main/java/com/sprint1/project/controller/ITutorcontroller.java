package com.sprint1.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sprint1.project.entity.Tutor;
import com.sprint1.project.exception.TutorNotFoundException;
import com.sprint1.project.service.ITutorService;



@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/tutor")

public class ITutorcontroller {
	
	@Autowired
	ITutorService iTutorService;
	
	
	@PostMapping("/insertTutor")
	public ResponseEntity<Tutor> insertTutor(@RequestBody Tutor tutor) {
		Tutor tutorr = iTutorService.insertTutor(tutor);
		return new ResponseEntity(tutorr, HttpStatus.OK);
		
	}
	
	@PutMapping("/updateTutor")
	public ResponseEntity<Tutor> updateTutor(@RequestBody Tutor tutor) {
		Tutor tutorr = iTutorService.updateTutor(tutor);
		return new ResponseEntity(tutorr, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTutor")
	public ResponseEntity<Tutor> deleteTutor(@RequestBody Tutor tutor) throws TutorNotFoundException {
		iTutorService.deleteTutor(tutor);
		return new ResponseEntity(tutor, HttpStatus.OK);
	}
	
	@GetMapping("/viewTutorOfSubject/{tsub}")
	public ResponseEntity<List<Tutor>> viewTutorOfId(@PathVariable String tsub) throws TutorNotFoundException {
		List<Tutor> tutor = iTutorService.viewTutorOfSubject(tsub);
		return new ResponseEntity(tutor, HttpStatus.OK);
	}
	
	@GetMapping("/viewTutorOfCity/{tcity}")
	public ResponseEntity<List<Tutor>> viewTutorOfCity(@PathVariable String tcity) throws TutorNotFoundException {
		List<Tutor> tutor = iTutorService.viewTutorOfCity(tcity);
		return new ResponseEntity(tutor, HttpStatus.OK);
	}
	
	@GetMapping("/countTutorsOfSubject/{tsub}")
	public ResponseEntity<Integer> countTutorsOfSubject(@PathVariable String tsub) throws TutorNotFoundException {
		int tutor = iTutorService.countTutorOfSubject(tsub);
		return new ResponseEntity(tutor, HttpStatus.OK);
	}
	
	@GetMapping("/viewAllTutors")
	public ResponseEntity<Tutor> viewAllTutors() throws TutorNotFoundException{
		List<Tutor> tutor = iTutorService.viewAllTutors();
		return new ResponseEntity(tutor ,HttpStatus.OK);
	}
	
}
