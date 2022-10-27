package com.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.model.Employee;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonProducer {

	@Autowired
	private KafkaTemplate<String, Employee> template;

	public void sendMessage(Employee e) {
		Message<Employee> msg = MessageBuilder.withPayload(e).setHeader(KafkaHeaders.TOPIC, "empTopic").build();
		template.send(msg);
		log.info(String.format(" sent message : %s ", e.toString()));
	}

}
