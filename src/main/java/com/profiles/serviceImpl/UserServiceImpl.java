package com.profiles.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.profiles.Entity.User;
import com.profiles.repository.UserRepo;
import com.profiles.service.UserService;

@Service
@Profile(value= {"local","dev","prod"})
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Override
	public User createUser(User user) {
		User u = this.userRepo.save(user);
		return u;
	}

	@Override
	public Optional<User> getUserById(Integer userId) {
		Optional<User> u = this.userRepo.findById(userId);
		return u;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> u = this.userRepo.findAll();
		return u;
	}

	@Override
	public void deleteUser(Integer user_id) {
		this.userRepo.deleteById(user_id);
	}

}
