package com.te.aws.s3.controller;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;

public class DeleteSingleObjectController {

	public void deleteOne() {
		String bucketName = "bucket1";
		String key = "pdf.pdf";

		S3Client client = S3Client.builder().build();

		DeleteObjectRequest request = DeleteObjectRequest.builder().bucket(bucketName).key(key).build();
		client.deleteObject(request);

	}

}
