package com.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.demo.entity.User;

@Service
public interface UserService {

	public Optional<User> getUserBasedOnUserId(int userId);
	public List<User> getAllUser();
	public User createUser(User user);
	public User updateUser(User user, int userId);
	public User deleteUser(int userId);

}
