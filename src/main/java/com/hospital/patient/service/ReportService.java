

package com.hospital.patient.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hospital.patient.entity.Report;
import com.hospital.patient.repository.ReportRepository;

@Service
public class ReportService {
	@Autowired
	private ReportRepository reportRepository;
	
	public void  saveReportToDB(MultipartFile file
			,String dates)
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
		

        
        reportRepository.save(r);
	}
	
    
	}
