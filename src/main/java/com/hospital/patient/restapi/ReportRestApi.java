package com.hospital.patient.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hospital.patient.service.ReportService;

@RestController

public class ReportRestApi {
	@Autowired
	private ReportService reportService;
	 @PostMapping("/addReport")
	 
	    public boolean saveReport(@RequestParam("file") MultipartFile file,
	    		@RequestParam("dates") String dates)
	    		
	    		
	    
	    {
	    	reportService.saveReportToDB(file, dates);
	    	return true;
	    }
}

    