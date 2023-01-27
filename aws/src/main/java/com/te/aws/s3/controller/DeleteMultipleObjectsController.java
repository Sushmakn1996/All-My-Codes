package com.te.aws.s3.controller;

import java.util.ArrayList;
import java.util.List;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.Delete;
import software.amazon.awssdk.services.s3.model.DeleteObjectsRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectsResponse;
import software.amazon.awssdk.services.s3.model.ObjectIdentifier;

public class DeleteMultipleObjectsController {

	public void deleteMany() {
		String bucketName = "bucket1";
		String key1 = "pdf.pdf";
		String key2 = "upload.pdf";
		String key3 = "message.pdf";

		S3Client client = S3Client.builder().build();
		List<ObjectIdentifier> listObjects = new ArrayList<>();
		listObjects.add(ObjectIdentifier.builder().key(key1).build());
		listObjects.add(ObjectIdentifier.builder().key(key2).build());
		listObjects.add(ObjectIdentifier.builder().key(key3).build());

		DeleteObjectsRequest request = DeleteObjectsRequest.builder().bucket(bucketName)
				.delete(Delete.builder().objects(listObjects).build()).build();
		
		DeleteObjectsResponse response = client.deleteObjects(request);
		System.out.println("Deleted: "+response.hasDeleted());
	}
}
