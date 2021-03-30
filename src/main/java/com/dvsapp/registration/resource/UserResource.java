package com.dvsapp.registration.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dvsapp.registration.dto.UserDTO;
import com.dvsapp.registration.service.IUserService;
import com.dvsapp.registration.util.CommonResponse;

@RestController
public class UserResource {

	@Autowired
	public IUserService iUserService;
	
	@PostMapping("/user/register")
	public ResponseEntity<CommonResponse> registerUser(@RequestBody UserDTO user){
		CommonResponse commonResponse = new CommonResponse();
		user = iUserService.saveUser(user);
		commonResponse.setSuccess(true);
		commonResponse.setResp(user);
		return new ResponseEntity<>(commonResponse,HttpStatus.OK);
	}
	
}
