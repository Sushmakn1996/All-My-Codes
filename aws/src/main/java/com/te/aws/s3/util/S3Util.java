package com.te.aws.s3.util;

import java.io.IOException;
import java.io.InputStream;

import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.waiters.WaiterResponse;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.waiters.S3Waiter;

public class S3Util {

	private static final String BUCKET = "bucket1";

	public static void uploadFile(String fileName, InputStream inputStream) throws S3Exception, AwsServiceException, SdkClientException, IOException {
		S3Client client = S3Client.builder().build();
		System.err.println(client);
		PutObjectRequest request = PutObjectRequest.builder().bucket(BUCKET).key(fileName).acl("public-read").build();
		System.err.println(request);
		client.putObject(request, RequestBody.fromInputStream(inputStream, inputStream.available()));

		S3Waiter waiter = client.waiter();
		System.err.println(waiter);
		HeadObjectRequest waitRequest = HeadObjectRequest.builder().bucket(BUCKET).key(fileName).build();
		System.err.println(waitRequest);
		WaiterResponse<HeadObjectResponse> waitResponse = waiter.waitUntilObjectExists(waitRequest);
		System.err.println(waitResponse);
		waitResponse.matched().response().ifPresent(x -> {
			System.out.println("The file " + fileName + " is added.");
		});
	}

}
