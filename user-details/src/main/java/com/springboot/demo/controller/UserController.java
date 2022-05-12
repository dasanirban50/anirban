package com.springboot.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.springboot.demo.entity.User;
import com.springboot.demo.exception.UserNotFoundException;
import com.springboot.demo.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	WebClient.Builder webClientBuilder;
	
	User user;
	List<User> users = new ArrayList<>();
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUser(){
		List<User> allUser = userService.getAllUser();
		if(allUser.size() == 0){
			throw new UserNotFoundException("No User is present in database");
		}
		for(User user : allUser) {
			List userAddress = restTemplate.getForObject("http://address-details/address/user/"+user.getuId(), List.class);
			user.setuAddress(userAddress);
			users.add(user);
		}
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserBasedOnUserId(@PathVariable int userId) {
		Optional<User> userBasedOnUserId = userService.getUserBasedOnUserId(userId);
		if(userBasedOnUserId.isPresent()){
			user = userBasedOnUserId.get();
		}
		else {
			throw new UserNotFoundException("User Id: "+userId+" is not present in database");
		}
		//Using restTemplate.getForObject()
		//List userAddress = restTemplate.getForObject("http://address-details/address/user/"+userId, List.class);
		//user.setuAddress(userAddress);
		/*
		//Using restTemplate.exchange()
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String> (headers);
		ResponseEntity<List> userAddress = restTemplate.exchange("http://address-details/address/user/"+userId, 
				HttpMethod.GET, entity,List.class);
		user.setuAddress(userAddress.getBody());
		*/
		//Using webClientBuilder
		List userAddress = webClientBuilder.build().get().uri("http://address-details/address/user/"+userId)
				.retrieve().bodyToMono(List.class).block();
		user.setuAddress(userAddress);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		if(createdUser == null) {
			throw new UserNotFoundException("Unable to create User with provided details");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable int userId) {
		User updatedUser = userService.updateUser(user,userId);
		if(updatedUser == null) {
			throw new UserNotFoundException("Unable to update User with provided details");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(updatedUser);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<User> deleteUser(@PathVariable int userId) {
		User deletedUser = userService.deleteUser(userId);
		if(deletedUser == null) {
			throw new UserNotFoundException("Unable to delete User with User Id : "+userId);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(deletedUser);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
	@LoadBalanced
	WebClient.Builder getWebClientBuilder(){
		return WebClient.builder();
	}
}
