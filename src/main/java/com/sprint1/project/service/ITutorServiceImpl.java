package com.sprint1.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sprint1.project.entity.Tutor;
import com.sprint1.project.exception.TutorNotFoundException;
import com.sprint1.project.repository.ITutorRepository;


@Service
public class ITutorServiceImpl implements ITutorService {

	@Autowired
	private ITutorRepository itutorrepository;
	
	
	@Override
	public Tutor insertTutor(Tutor tutorr) {
		
		Tutor tutor = new Tutor();
		tutor.setTutorId(tutorr.getTutorId());
		tutor.setName(tutorr.getName());
		tutor.setMobile(tutorr.getMobile());
		tutor.setEmail(tutorr.getEmail());
		tutor.setSchoolName(tutorr.getSchoolName());
		tutor.setQualification(tutorr.getQualification());
		tutor.setSubject(tutorr.getSubject());
		tutor.setCity(tutorr.getCity());
		
		/*List<Tutor> tutor = itutorrepository.findAll();
		 * for(Tutor t : tutor) {
		 * if(t.getName().equals(tutorr.getName())) {
		 * throw new DuplicateTutorNameException("Name Already Exists");
		 * }
		 * }		*/
		
		return itutorrepository.save(tutor);
	}

	@Override
	public Tutor updateTutor(Tutor tutorr) {
		
		Tutor tutor = new Tutor();
		tutor.setTutorId(tutorr.getTutorId());
		tutor.setName(tutorr.getName());
		tutor.setMobile(tutorr.getMobile());
		tutor.setEmail(tutorr.getEmail());
		tutor.setSchoolName(tutorr.getSchoolName());
		tutor.setQualification(tutorr.getQualification());
		tutor.setSubject(tutorr.getSubject());
		tutor.setCity(tutorr.getCity());
		
		return itutorrepository.save(tutor);
	}

	@Override
	public Tutor deleteTutor(Tutor tutor) throws TutorNotFoundException {
		
		itutorrepository.delete(tutor);
		
		if(tutor == null)
			throw new TutorNotFoundException("Tutor Not Found Exception");
		return tutor;
	}

	@Override
	public List<Tutor> viewTutorOfSubject(String subject) throws TutorNotFoundException {
		
		List<Tutor> tutor = itutorrepository.findAll();
		
		
		return tutor.stream().filter((d) -> d.getSubject().equalsIgnoreCase(subject)).collect(Collectors.toList());
	}
	
	@Override
	public List<Tutor> viewTutorOfCity(String city) throws TutorNotFoundException {
		
		List<Tutor> tutor = itutorrepository.findAll();
		
		
		return tutor.stream().filter((d) -> d.getCity().equalsIgnoreCase(city)).collect(Collectors.toList());
	}

	@Override
	public int countTutorOfSubject(String subject) throws TutorNotFoundException {
		
		List<Tutor> cab = itutorrepository.findAll();
		List<Tutor> c = cab.stream().filter((d) -> d.getSubject().equalsIgnoreCase(subject)).collect(Collectors.toList());
		int n = c.size();

		return n;
		
	}
	
	@Override
	public List<Tutor> viewAllTutors() throws TutorNotFoundException {
	
		return itutorrepository.findAll();
	}

}
