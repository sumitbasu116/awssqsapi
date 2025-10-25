package com.sumit.sqs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;

@Configuration
public class AwsSqsConfig {

	private static final String AWS_REGION = "ap-south-1";

	@Value("${AWS_SQS_ACCESS_KEY_ID}")
	private String sqsAccessKey;

	@Value("${AWS_SQS_SECRET_ACCESS_KEY}")
	private String sqsAccessKeyValue;

	@Bean
	public SqsAsyncClient sqsAsyncClient() {
		return SqsAsyncClient.builder().region(Region.of(AWS_REGION))
				.credentialsProvider(
						StaticCredentialsProvider.create(AwsBasicCredentials.create(sqsAccessKey, sqsAccessKeyValue)))
				.build();
	}

	@Bean
	public SqsTemplate sqsTemplate(SqsAsyncClient sqsAsyncClient) {
		return SqsTemplate.newTemplate(sqsAsyncClient);
	}
}
