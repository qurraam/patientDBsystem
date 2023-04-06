package com.hospital.patient.service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hospital.patient.entity.Appointment;
import com.hospital.patient.entity.Patient;
import com.hospital.patient.entity.Prescription;
import com.hospital.patient.repository.AppointmentRepository;
import com.hospital.patient.repository.PatientRepository;
import com.hospital.patient.repository.PrescriptionRepository;

@Service
@Transactional
public class PrescriptionService {
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	@Autowired
	private  PatientRepository patientRepository;
	@Autowired
	private  AppointmentRepository appointmentRepository;
	
	public void  savePrescriptionToDB(MultipartFile file
			,String dates ,Long patient_id ,Long appointment_id)
	{
		Prescription p = new Prescription();
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
		p.setDates(dates);
		Patient patient = this.patientRepository.findById(patient_id).orElse(null);
        p.setPatient(patient);
        Appointment appointment = this.appointmentRepository.findById(appointment_id).orElse(null);
        p.setAppointment(appointment);

		

        
        prescriptionRepository.save(p);
	}
	public List<Prescription> getAllPrescriptions() {
        return prescriptionRepository.findAll();
    }

    public List<Prescription> getPrescriptionsByPatient(Long patientId) {
        return prescriptionRepository.findByPatientId(patientId);
    }
    public List<Prescription> getPrescriptionsByAppointment(Long appointmentId) {
        return prescriptionRepository.findByAppointmentId(appointmentId);
    }
    
    public Prescription getPrescriptionById(Long id) {
        Optional<Prescription> prescription = prescriptionRepository.findById(id);
        return prescription.orElse(null);
    }

    public Boolean deletePrescription(long id) {
		prescriptionRepository.deleteById(id);
		return true;
    }
    
	}
