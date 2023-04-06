package com.hospital.patient.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.hospital.patient.entity.Report;
import com.hospital.patient.service.ReportService;

@RestController

public class ReportRestApi {
	@Autowired
	private ReportService reportService;
	 @PostMapping("/addReport")
	 
	    public boolean saveReport(@RequestParam("file") MultipartFile file,
	    		@RequestParam("dates") String dates,
	    		@RequestParam("patient_id") Long patient_id)
	    		
	    		
	    
	    {
	    	reportService.saveReportToDB(file, dates,patient_id);
	    	return true;
	    }
	 @GetMapping("/reports")
	    public List<Report> getAllReports() {
	        return reportService.getAllReports();
	    }

	    @GetMapping("/reports/patient/{id}")
	    public List<Report> getReportsByPatient(@PathVariable("id") Long patientId) {
	        return reportService.getReportsByPatient(patientId);
	    }
	    
	    @DeleteMapping("/report/{id}")
		public Boolean deleteReport(@PathVariable("id") long id) {
			//appointmentRepository.deleteById(id);
			return this.reportService.deleteReport(id);
		}
}

    