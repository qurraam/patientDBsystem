package com.hospital.patient.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospital.patient.common.APIResponse;
import com.hospital.patient.entity.Employee;
import com.hospital.patient.entity.User;
import com.hospital.patient.pojo.LoginRequestDTO;
import com.hospital.patient.pojo.SignupRequestDTO;
import com.hospital.patient.repository.UserRepository;
import com.hospital.patient.utils.JwtUtils;

@Service
public class UserService{
	 @Autowired
	    private UserRepository userRepository;
	    @Autowired
	    private JwtUtils jwtUtils;
	    
	    public APIResponse signUp(SignupRequestDTO signUpRequestDTO) {
	        APIResponse apiResponse = new APIResponse();

	        // validation

	        // dto to entity
	        User userEntity = new User();
	        userEntity.setUsername(signUpRequestDTO.getUsername());
	        userEntity.setPass(signUpRequestDTO.getPass());
	        userEntity.setRole(signUpRequestDTO.getRole());
	        
			Employee employee = new Employee();
			employee.setId(signUpRequestDTO.getEmployee().getId());
			userEntity.setEmployee(employee);

	        // store entity
	        userEntity = userRepository.save(userEntity);

	        // generate jwt
	        String token = jwtUtils.generateJwt(userEntity);

	        Map<String , Object> data = new HashMap<>();
	        data.put("accessToken", token);

	        apiResponse.setData(data);

	        // return
	        return apiResponse;
	    }
	    
	    public APIResponse login(LoginRequestDTO loginRequestDTO) {

	        APIResponse apiResponse = new APIResponse();

	        // validation

	        // verify user exist with given email and password
	        User user = userRepository.findOneByUsernameIgnoreCaseAndPass(loginRequestDTO.getUsername(), loginRequestDTO.getPass());

	        // response
	        if(user == null){
	            apiResponse.setData("User login failed");
	            return apiResponse;
	        }

	        // generate jwt
	        String token = jwtUtils.generateJwt(user);

	        Map<String , Object> data = new HashMap<>();
	        data.put("accessToken", token);

	        apiResponse.setData(data);

	        return apiResponse;
	    }

}
