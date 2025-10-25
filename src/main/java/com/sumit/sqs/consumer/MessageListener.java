//package com.sumit.sqs.consumer;
//
//import org.springframework.stereotype.Component;
//
//import io.awspring.cloud.sqs.annotation.SqsListener;
//import lombok.extern.slf4j.Slf4j;
//
//@Component
//@Slf4j
//public class MessageListener {
//	
//	@SqsListener("devops-queue")
//    public void receiveMessage(String message) {
//        log.info("📬 Received message from SQS: " + message);
//    }
//}
