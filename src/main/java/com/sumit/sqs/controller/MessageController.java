package com.sumit.sqs.controller;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.awspring.cloud.sqs.operations.SendResult;
import io.awspring.cloud.sqs.operations.SqsTemplate;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

	@Value("${AWS_SQS_ENDPOINT}")
	private String sqsEndpoint;
	
	private final SqsTemplate sqsTemplate;

    public MessageController(SqsTemplate sqsTemplate) {
        this.sqsTemplate = sqsTemplate;
    }
    
    @PostMapping
    public String sendMessage(@RequestParam String message) throws InterruptedException, ExecutionException {
    	CompletableFuture<SendResult<String>> future = sqsTemplate.sendAsync(sqsEndpoint,message);
    	return future.get().message().toString();
    }
}
