package com.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webflux.dto.UserDto;
import com.webflux.model.User;
import com.webflux.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MainController {

	@Autowired
	private UserService ser;

	@PostMapping("/save")
	public Mono<User> saveBook(@RequestBody UserDto b) {
		return ser.saveUser(b);
	}
	
	@GetMapping("/get")
	public Flux<User> getUser()
	{
		return ser.getUser();
	}
	
	@PutMapping("/update/{id}")
	public Mono<User> updateUser(@PathVariable(name = "id") int id , @RequestBody UserDto u)
	{
		return ser.updateUser(id,u);
	}
	
	@DeleteMapping("/delete/{id}")
	public  Mono<Void> deleteUser(@PathVariable(name = "id") int id)
	{
		return ser.deleteUserById(id);
	}

}
