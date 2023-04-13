package com.hospital.patient.common;

public class AccessDeniedException extends RuntimeException{
	public AccessDeniedException(String message){
        super(message);
    }

}
