package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.model.Employee;
import com.kafka.service.JsonProducer;

@RestController
public class ProducerJsonController {

	@Autowired
	private JsonProducer producer;
	
	
	@PostMapping("/send")
	public String sendMsg(@RequestBody Employee e)
	{
		producer.sendMessage(e);
		return "Message Sent \n"+e.toString();
	}
}
