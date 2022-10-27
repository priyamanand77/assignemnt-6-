package com.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonConsumer {

	@KafkaListener(topics = {"empTopic"},groupId = "consumers")
	public void consumer(Employee e)
	{
		log.info(String.format("message reseived : %s ", e.toString()));
	}
}
