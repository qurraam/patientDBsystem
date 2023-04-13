package com.hospital.patient.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.patient.common.APIResponse;
import com.hospital.patient.pojo.LoginRequestDTO;
import com.hospital.patient.pojo.SignupRequestDTO;
import com.hospital.patient.service.UserService;
import com.hospital.patient.utils.JwtUtils;

@RestController
public class UserRestApi {
	@Autowired
	private UserService userService;
	@Autowired
	private JwtUtils jwtutils;
	
	@PostMapping("/signup")
    public ResponseEntity<APIResponse> signUp(@RequestBody SignupRequestDTO signUpRequestDTO ){

        APIResponse apiResponse = userService.signUp(signUpRequestDTO);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
	 @PostMapping("/login")
	    public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDTO loginRequestDTO ){

	        APIResponse apiResponse = userService.login(loginRequestDTO);

	        return ResponseEntity
	                .status(apiResponse.getStatus())
	                .body(apiResponse);
	    }
	 @PostMapping("/logout")
	 public ResponseEntity<APIResponse> logout(@RequestHeader("Authorization") String authHeader) {

	     APIResponse apiResponse = new APIResponse();

	     // extract JWT token from Authorization header
	     String token = authHeader.substring(7);

	     // invalidate JWT token
	     jwtutils.invalidateJwt(token);

	     apiResponse.setData("Logout successful");

	     return ResponseEntity
	             .status(apiResponse.getStatus())
	             .body(apiResponse);
	 }
	 
	 @GetMapping("/privateApi")
	   public ResponseEntity<APIResponse> privateApi(@RequestHeader(value = "authorizatio", defaultValue = "") String author) throws Exception {
		 APIResponse apiResponse = new APIResponse();
		 System.out.println(author);
		 //String authorization = "eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiIxIiwiaWF0IjoxNjgxNDI0MzQzLCJleHAiOjE2ODE0Mjc5NDMsInJvbGUiOiIxIiwidXNlcm5hbWUiOiJxdXJyYWFtIn0.YAeWZ9XgCrNutDseXIvLwlvi8dEgld1MalOGFP4RigK8pGLiFu1K0bmcSG_gG6T--Ng5Gzb4DePGGVCZTKAPkw";
		 jwtutils.verify(author);
		 apiResponse.setData("this is private api");
		 return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	 }


}
