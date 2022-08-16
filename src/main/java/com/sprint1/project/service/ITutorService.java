package com.sprint1.project.service;

import java.util.List;


import com.sprint1.project.entity.Tutor;
import com.sprint1.project.exception.TutorNotFoundException;


public interface ITutorService {
	
	public Tutor insertTutor(Tutor tutor);

	public Tutor updateTutor(Tutor tutor);

	public Tutor deleteTutor(Tutor tutor) throws TutorNotFoundException;

	public List<Tutor> viewTutorOfSubject(String subject) throws TutorNotFoundException;
	
	public List<Tutor> viewTutorOfCity(String city) throws TutorNotFoundException;

	public int countTutorOfSubject(String subject) throws TutorNotFoundException;
	
	public List<Tutor> viewAllTutors() throws TutorNotFoundException;

}
