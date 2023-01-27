package com.te.aws.s3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.te.aws.s3.util.S3Util;

import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

@Controller
public class UpdateController {
	
	@PostMapping("/update")
	public String updateFile(String description, @RequestParam("file") MultipartFile file) {
		String bucketName = "bucket1";
		String keyName = "pdf.pdf";
		
		String fileName = file.getOriginalFilename();
		System.err.println("description :" + description);
		System.err.println("fileName :" + fileName);
		String message = "";
		S3Client client=S3Client.builder().build();
		GetObjectRequest request = GetObjectRequest.builder().bucket(bucketName).key(keyName).build();
		ResponseInputStream<GetObjectResponse> response = client.getObject(request);
		String string = response.toString();
		try {
			if(fileName.equals(string)) {
				S3Util.uploadFile(fileName, file.getInputStream());
			}
			message = "Your file is uploaded";
		} catch (Exception e) {
			message = "Error while uploading" + e.getMessage();
		}
		return message;
	}

}
