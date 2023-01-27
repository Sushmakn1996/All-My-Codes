package com.tyss.twilio_otp_sms.dto;

public class StoreOTP {
	
	public static int getOtp() {
		return otp;
	}

	public static void setOtp(int otp) {
		StoreOTP.otp = otp;
	}

	private static int otp;
	

}
