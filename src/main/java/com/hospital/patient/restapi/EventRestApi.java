package com.hospital.patient.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hospital.patient.entity.Event;
import com.hospital.patient.service.EventService;

@RestController

public class EventRestApi {
	@Autowired
	private EventService eventService;
	 @PostMapping("/addP")
	 
	    public boolean saveProduct(@RequestParam("file") MultipartFile file,
	    		@RequestParam("title") String title,
	    		@RequestParam("description") String description,
	    		@RequestParam("dates") String dates,
	    		@RequestParam("hospital_id") Long hospital_id)
	    
	    {
	    	eventService.saveProductToDB(file, title, description, dates,hospital_id);
	    	return true;
	    }
	 @GetMapping("/events")
	    public List<Event> getAllEvents() {
	        return eventService.getAllEvents();
	    }

	    @GetMapping("/events/hospital/{id}")
	    public List<Event> getEventsByHospital(@PathVariable("id") Long hospitalId) {
	        return eventService.getEventsByHospital(hospitalId);
	    }
	    
	    @DeleteMapping("/event/{id}")
		public Boolean deleteEvent(@PathVariable("id") long id) {
			//appointmentRepository.deleteById(id);
			return this.eventService.deleteEvent(id);
		}


    
   	
}
