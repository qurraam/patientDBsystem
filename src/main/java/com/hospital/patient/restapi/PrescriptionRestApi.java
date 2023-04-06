package com.hospital.patient.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hospital.patient.service.PrescriptionService;

@RestController

public class PrescriptionRestApi {
	@Autowired
	private PrescriptionService prescriptionService;
	 @PostMapping("/addPrescription")
	 
	    public boolean savePrescription(@RequestParam("file") MultipartFile file,
	    		@RequestParam("dates") String dates)
	    		
	    
	    {
	    	prescriptionService.savePrescriptionToDB(file,dates);
	    	return true;
	    }

}