package com.te.aws.s3.controller;

import java.io.File;
import java.io.IOException;
import software.amazon.awssdk.core.ResponseInputStream;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;

public class DownloadFile {

	public void downloadFile() throws IOException {
		String bucketName = "bucket1";
		String keyName = "pdf.pdf";

		S3Client client = S3Client.builder().build();

		GetObjectRequest request = GetObjectRequest.builder().bucket(bucketName).key(keyName).build();
		ResponseInputStream<GetObjectResponse> input = client.getObject(request);
		String fileName = new File(keyName).getName();
		System.err.println(fileName);
		input.close();
	}

}














//		BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(keyName));
//
//		byte[] buffer = new byte[4096];
//		int bytesRead = -1;
//		while ((bytesRead = inputStream.read(buffer)) != -1) {
//			outputStream.write(buffer, 0, bytesRead);
//		}
//		inputStream.close();
//		outputStream.close();