package com.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.entity.User;
import com.springboot.demo.exception.UserNotFoundException;
import com.springboot.demo.respository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Optional<User> getUserBasedOnUserId(int userId) {
		return userRepository.findById(userId);
	}

	@Override
	public List<User> getAllUser() {
		List<User> allUser = userRepository.findAll();
		return allUser;
	}

	@Override
	public User createUser(User user) {
		User savedUser = userRepository.save(user);
		return savedUser;
	}

	@Override
	public User updateUser(User user, int userId) {
		Optional<User> userById = userRepository.findById(userId);
		if(!userById.isPresent()) {
			throw new UserNotFoundException("No User is present in database with User Id :"+userId);
		}
		user.setuId(userId);
		User updateMovie = userRepository.save(user);
		if(updateMovie == null) {
			
		}
		return updateMovie;
	}

	@Override
	public User deleteUser(int userId) {
		Optional<User> userById = userRepository.findById(userId);
		if(!userById.isPresent()) {
			throw new UserNotFoundException("No User is present in database with User Id :"+userId);
		}
		userRepository.deleteById(userId);
		return userById.get();
	}

}
