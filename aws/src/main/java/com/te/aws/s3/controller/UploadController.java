package com.te.aws.s3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.te.aws.s3.util.S3Util;

@Controller
public class UploadController {

//	@GetMapping("/")
//	public String showHomePage() {
//		return "upload";
//	}

	@PostMapping("/upload")
	public String uploadFile(String description, @RequestParam("file") MultipartFile file) {
		String filename = file.getOriginalFilename();
		System.err.println("description :" + description);
		System.err.println("filename :" + filename);
		String message = "";
		try {
			S3Util.uploadFile(filename, file.getInputStream());
			message = "Your file is uploaded";
		} catch (Exception e) {
			message = "Error uploading file" + e.getMessage();
		}
		return message;
	}
}
