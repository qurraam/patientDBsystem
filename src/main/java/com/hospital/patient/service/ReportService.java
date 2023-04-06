

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

import com.hospital.patient.entity.Patient;
import com.hospital.patient.entity.Report;
import com.hospital.patient.repository.PatientRepository;
import com.hospital.patient.repository.ReportRepository;

@Service
@Transactional

public class ReportService {
	@Autowired
	private ReportRepository reportRepository;
	@Autowired
	private  PatientRepository patientRepository;
	
	public void  saveReportToDB(MultipartFile file
			,String dates,Long patient_id)
	{
		Report r = new Report();
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		if(fileName.contains(".."))
		{
			System.out.println("not a a valid file");
		}
		try {
			r.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		r.setDates(dates);
		Patient patient = this.patientRepository.findById(patient_id).orElse(null);
        r.setPatient(patient);
		

        
        reportRepository.save(r);
	}
	public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public List<Report> getReportsByPatient(Long patientId) {
        return reportRepository.findByPatientId(patientId);
    }
    
    public Report getReportById(Long id) {
        Optional<Report> report = reportRepository.findById(id);
        return report.orElse(null);
    }

    public Boolean deleteReport(long id) {
		reportRepository.deleteById(id);
		return true;
    }
	
    
	}
