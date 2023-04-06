package com.hospital.patient.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hospital.patient.entity.Prescription;
import com.hospital.patient.repository.PrescriptionRepository;

@Service
public class PrescriptionService {
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	public void  savePrescriptionToDB(MultipartFile file
			,String dates)
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
		

        
        prescriptionRepository.save(p);
	}
	
    
	}
