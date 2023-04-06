package com.hospital.patient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "events")
@Data
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String image;
	private String title;
	private String description;
	private String dates;
	
	@ManyToOne
	@JoinColumn(name = "hospital_id", referencedColumnName = "id")
	private Hospital hospital;
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", image=" + image + ", title=" 
	            + title + ", description=" + description + ", dates="
				+ dates + "]";
	}
	
       
	
        }

