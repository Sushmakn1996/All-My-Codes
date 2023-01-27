package com.tyss.twilio_otp_sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tyss.twilio_otp_sms.dto.VerifyRequestDto;
import com.tyss.twilio_otp_sms.service.OtpService;

@RestController
public class VerifyController {

	@Autowired
	private OtpService otpService;

	@PostMapping("/otp")
	public String verifyOTP(@RequestBody VerifyRequestDto dto) {
		System.err.println("inside verify otp");
		System.err.println("generated otp :"+dto.getOtp());
		System.err.println("otp which is stored in cache :"+otpService.getOtp(dto.getPhoneNo()));
		if (dto.getOtp().equals(otpService.getOtp(dto.getPhoneNo()))) {
			otpService.clearOTP(dto.getPhoneNo());
			return "Correct OTP";
		} else
			System.err.println("verify else statement");
		return "Incorrect OTP";

	}
}
