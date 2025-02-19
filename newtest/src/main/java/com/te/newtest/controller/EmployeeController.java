package com.te.newtest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.newtest.dto.EmployeeRequsetDto;
import com.te.newtest.dto.EmployeeResponseDto;
import com.te.newtest.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;

	@PostMapping("/register")
	public ResponseEntity<EmployeeResponseDto> register(@RequestBody EmployeeRequsetDto dto) {
		log.info("Inside register controller");
		return new ResponseEntity<>(
				new EmployeeResponseDto(false, "Registered successfully", employeeService.register(dto)),
				HttpStatus.ACCEPTED);

	}

	@GetMapping("/getallby")
	public ResponseEntity<EmployeeResponseDto> getAllBy(@RequestParam String any) {
		log.info("Inside getallby controller");
		return new ResponseEntity<>(
				new EmployeeResponseDto(false, "Employess sorted based on your request", employeeService.getAllBy(any)),
				HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/getall/{any}")
	public ResponseEntity<EmployeeResponseDto> getAll(@PathVariable String any) {
		log.info("Inside getallby controller");
		return new ResponseEntity<>(
				new EmployeeResponseDto(false, "Employess sorted based on your request", employeeService.getAll(any)),
				HttpStatus.ACCEPTED);
	}
}
