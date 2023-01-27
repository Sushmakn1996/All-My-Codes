package com.te.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.te.springboot.dto.EmployeeRequestDto;
import com.te.springboot.dto.EmployeeResponseDto;
import com.te.springboot.dto.LoginRequestDto;
import com.te.springboot.dto.LoginResponseDto;
import com.te.springboot.service.EmployeeService;

@Controller
@RequestMapping("/springboot")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/register")
	public ResponseEntity<EmployeeResponseDto> register(@RequestBody EmployeeRequestDto employeeRequestDto) {
		return new ResponseEntity<>(new EmployeeResponseDto(false, "Registered Successfully",
				employeeService.register(employeeRequestDto)), HttpStatus.ACCEPTED);

	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
		return new ResponseEntity<>(new LoginResponseDto(false, "Logged In Successfully",
				employeeService.login(loginRequestDto)), HttpStatus.ACCEPTED);

	}
	
	
	

	
	

}
