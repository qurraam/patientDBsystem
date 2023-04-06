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

import com.hospital.patient.entity.Prescription;
import com.hospital.patient.service.PrescriptionService;

@RestController

public class PrescriptionRestApi {
	@Autowired
	private PrescriptionService prescriptionService;
	 @PostMapping("/addPrescription")
	 
	    public boolean savePrescription(@RequestParam("file") MultipartFile file,
	    		@RequestParam("dates") String dates,
	    		@RequestParam("patient_id") Long patient_id,
	    		@RequestParam("appointment_id") Long appointment_id)
	    		
	    
	    {
	    	prescriptionService.savePrescriptionToDB(file,dates,patient_id,appointment_id);
	    	return true;
	    }
	 @GetMapping("/prescriptions")
	    public List<Prescription> getAllPrescriptions() {
	        return prescriptionService.getAllPrescriptions();
	    }

	    @GetMapping("/prescriptions/patient/{id}")
	    public List<Prescription> getPrescriptionsByPatient(@PathVariable("id") Long patientId) {
	        return prescriptionService.getPrescriptionsByPatient(patientId);
	    }
	    @GetMapping("/prescriptions/appointment/{id}")
	    public List<Prescription> getPrescriptionsByAppointment(@PathVariable("id") Long appointmentId) {
	        return prescriptionService.getPrescriptionsByAppointment(appointmentId);
	    }
	    
	    @DeleteMapping("/prescription/{id}")
		public Boolean deletePrescription(@PathVariable("id") long id) {
			//appointmentRepository.deleteById(id);
			return this.prescriptionService.deletePrescription(id);
		}

}