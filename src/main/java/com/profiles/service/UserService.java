package com.profiles.service;

import java.util.List;
import java.util.Optional;

import com.profiles.Entity.User;

public interface UserService {

	User createUser(User user);

	Optional<User> getUserById(Integer userId);

	List<User> getAllUsers();

	void deleteUser(Integer user_id);

}
