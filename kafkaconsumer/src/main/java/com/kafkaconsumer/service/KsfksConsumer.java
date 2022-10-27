package com.kafkaconsumer.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KsfksConsumer {

	@KafkaListener(topics = {"empTopic"} , groupId = "consumers")
	public void consumer(Employee msg)
	{
		log.info(String.format("reseived message is %s ", msg.toString()));
		
	}
}
