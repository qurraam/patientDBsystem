package com.hospital.patient.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hospital.patient.entity.Event;
import com.hospital.patient.entity.Hospital;
import com.hospital.patient.repository.EventRepository;
import com.hospital.patient.repository.HospitalRepository;

@Service
@Transactional
public class EventService {
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private  HospitalRepository hospitalRepository;

    /*@Autowired
    public EventService(HospitalRepository hospitalRepository) {
        EventService.hospitalRepository = hospitalRepository;
    }*/
	
	
	public void  saveProductToDB(MultipartFile file,String title,String description
			,String dates ,Long hospital_id)
	{
		Event p = new Event();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			p.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		p.setTitle(title);
		
        p.setDescription(description);
        p.setDates(dates);
        Hospital hospital = this.hospitalRepository.findById(hospital_id).orElse(null);
        p.setHospital(hospital);
        
        eventRepository.save(p);
	}
	 public List<Event> getAllEvents() {
	        return eventRepository.findAll();
	    }

	    public List<Event> getEventsByHospital(Long hospitalId) {
	        return eventRepository.findByHospitalId(hospitalId);
	    }
	    
	    public Event getEventById(Long id) {
	        Optional<Event> event = eventRepository.findById(id);
	        return event.orElse(null);
	    }

	    public Boolean deleteEvent(long id) {
			eventRepository.deleteById(id);
			return true;
	    }

	
    
	}

 
   

