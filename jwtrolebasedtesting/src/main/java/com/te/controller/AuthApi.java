package com.te.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.dto.AuthRequest;
import com.te.dto.AuthResponse;
import com.te.jwt.JwtTokenUtil;
import com.te.users.User;

@RestController
public class AuthApi {

	@Autowired
	AuthenticationManager authManager;
	
	@Autowired
	JwtTokenUtil jwtUtil;
	
	@Autowired
	private JavaMailSender javaMailSender;

	@PostMapping("/auth/login")
	public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) {
		try {
			Authentication authentication = authManager
					.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
			User user = (User) authentication.getPrincipal();
			String accessToken = jwtUtil.generateAccessToken(user);
			AuthResponse response = new AuthResponse(user.getEmail(), accessToken);
			
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("sushmanayaka66@gmail.com");
			message.setTo(user.getUsername());
			message.setText(
					"Your registered Username :" + user.getUsername() + "\n" + " and Password :" + user.getPassword());
			message.setSubject("Welcome To Techno Elevate");
			javaMailSender.send(message);
			System.out.println("Mail Sent Succesfully");
			
			return ResponseEntity.ok(response);

		} catch (BadCredentialsException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

}
