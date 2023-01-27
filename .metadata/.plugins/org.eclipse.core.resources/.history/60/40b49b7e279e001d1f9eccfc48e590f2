package com.te.manytomany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.manytomany.dto.EmployeeRegisterDto;
import com.te.manytomany.dto.EmployeeResponseDto;
import com.te.manytomany.dto.EmployeeUpdateDto;
import com.te.manytomany.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/register")
	public ResponseEntity<EmployeeResponseDto> register(@RequestBody EmployeeRegisterDto dto) {
		return new ResponseEntity<>(
				new EmployeeResponseDto(false, "Registered Successfully", employeeService.register(dto)),
				HttpStatus.ACCEPTED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<EmployeeResponseDto> get() {
		return new ResponseEntity<>(new EmployeeResponseDto(false, "Fetched all data", employeeService.get()),
				HttpStatus.ACCEPTED);
	}

	@PutMapping("/update")
	public ResponseEntity<EmployeeResponseDto> update(@RequestBody EmployeeUpdateDto dto) {
		return new ResponseEntity<>(new EmployeeResponseDto(false, "Updated Successfully", employeeService.update(dto)),
				HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<EmployeeResponseDto> delete(@RequestParam int empId) {
		return new ResponseEntity<>(new EmployeeResponseDto(false, "Deleted Successfully", employeeService.delete(empId)),
				HttpStatus.ACCEPTED);
	}

}
