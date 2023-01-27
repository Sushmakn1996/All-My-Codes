package com.tyss.twilio_otp_sms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import com.tyss.twilio_otp_sms.config.TwilioConfig;
import com.tyss.twilio_otp_sms.dto.RequestDto;

import lombok.Data;

@Service
@Data
public class TwilioService {

//	ResponseDto responseDto;
//	Map<String, String> otpMap = new HashMap<>();

	String otp;

	private TwilioConfig twilioConfig;

	@Autowired
	public TwilioService(TwilioConfig twilioConfig) {
		this.twilioConfig = twilioConfig;
	}

	@Autowired
	private OtpService otpService;

	public String sendOTP(@RequestBody RequestDto requestDto) {

		PhoneNumber to = new PhoneNumber(requestDto.getPhoneNumber());
		PhoneNumber from = new PhoneNumber(twilioConfig.getTrialNumber());
		otp = otpService.generateOTP(requestDto.getPhoneNumber());
		System.err.println(otp);
		String otpMessage = "Your OTP is :-" + otp + " use this otp for verification";
		Message sms = Message.creator(to, from, otpMessage).create();
		return sms.getStatus().toString();
	}

//			otpMap.put(requestDto.getUserName(), otp);

//			 responseDto = new ResponseDto(OtpStatus.DELIVERED, otpMessage);

//		} catch (Exception e) {
//			responseDto = new ResponseDto(OtpStatus.FAILED, e.getMessage());
//		}
//		return Mono.just(responseDto);

	// 6 digit OTP
//	private String generateOTP() {
//		return new DecimalFormat("000000").format(new Random().nextInt(999999));
//	}

//	// VALIDATE OTP
//	public Mono<String> validatOTP(String userInputOtp, String userName) {
//		if (userInputOtp.equals(otpMap.get(userName))) {
//
//			otpMap.remove(userName, userInputOtp);
//
//			return Mono.just("Valid OTP, please proceed");
//
//		} else {
//			return Mono.error(new IllegalArgumentException("Invalid OTP, please retry"));
//		}
//
//	}

}
