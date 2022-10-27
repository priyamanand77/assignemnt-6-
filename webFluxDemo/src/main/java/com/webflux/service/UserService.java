package com.webflux.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webflux.dao.UserRepo;
import com.webflux.dto.UserDto;
import com.webflux.model.User;
import com.webflux.utility.AppUtils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {
	@Autowired
	private UserRepo repo;

	public Mono<User> saveUser(UserDto u) {
		return repo.save(AppUtils.dtoToEntity(u));
	}

	public Flux<User> getUser() {
		return repo.findAll();
	}

	public Mono<User> updateUser(int id, UserDto u) {

		return repo.findById(id).doOnNext(p -> {
			p.setAge(u.getAge());
			p.setEmail(u.getEmail());
			p.setFirstname(u.getFirstname());
			p.setLastname(u.getLastname());
		}).flatMap(repo::save);

	}

	public Mono<Void> deleteUserById(int id) {


		return repo.deleteById(id);
		
	}

}
