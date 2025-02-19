package com.te.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.te.dto.EmpDto;
import com.te.dto.LoginDto;
import com.te.dto.ResponseDto;
import com.te.entity.Authority;
import com.te.service.EmpService;
import com.te.util.JwtUtil;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.extern.slf4j.Slf4j;

@RequestMapping("/start")
@RestController
@Slf4j
public class EmpController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private EmpService empServiceImpl;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private UserDetailsService detailsService;

	// create----------
	@PostMapping("/register")
	public ResponseEntity<?> registerEntity(/*@Valid*/ @RequestBody EmpDto empDto) {
		log.info("excute1");
		try {
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(true, "successfully registered",empServiceImpl.register(empDto) ), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(false, "registration failed", null),
					HttpStatus.BAD_REQUEST);
		}
	}

	// retrieve--------------
	@PostMapping("/login")
	public ResponseEntity<?> loginEntity(@Valid @RequestBody LoginDto loginDto) {
		try {
			empServiceImpl.login(loginDto);
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(true, "successfully login", empServiceImpl.login(loginDto)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(false, "login failed", null),
					HttpStatus.BAD_REQUEST);
		}
	}

	// update-------------------
	@PutMapping("/update")
	public ResponseEntity<?> updateEntity(@Valid @RequestBody EmpDto empDto) {
		try {
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(true, "successfully updated", empServiceImpl.update(empDto)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(false, "updation failed", null),
					HttpStatus.BAD_REQUEST);
		}
	}

	// delete------------------
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<?> deleteEntity(@Valid @PathVariable String empId) {
		try {
			return new ResponseEntity<ResponseDto>(
					new ResponseDto(true, "successfully deleted", empServiceImpl.delete(empId)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<ResponseDto>(new ResponseDto(false, "deletion failed", null),
					HttpStatus.BAD_REQUEST);
		}
	}
	
//	@PreAuthorize("admin")
	@PostMapping("/authenticate")
	public ResponseEntity<?> creatAuthToken(@RequestBody Authority dto){
		log.info("inside authenticate");
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getName(), dto.getPwd()));
		
		UserDetails loadUserByUsername = detailsService.loadUserByUsername(dto.getName());
		if (dto.getPwd().equals(loadUserByUsername.getPassword())) {
			String generateToken = jwtUtil.generateToken(loadUserByUsername);
			
			return new ResponseEntity<ResponseDto>(new ResponseDto(true,"token generated",generateToken),HttpStatus.OK);
		} else {
			return new ResponseEntity<ResponseDto>(new ResponseDto(true,"token genereration failed","password is wrong"),HttpStatus.OK);
		}
	}

}
