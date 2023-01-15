package com.profiles.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.profiles.Entity.User;
import com.profiles.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User u = this.userService.createUser(user);
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}

	@GetMapping("user/{userId}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable("userId") Integer userId) {
		Optional<User> u = this.userService.getUserById(userId);
		return new ResponseEntity<Optional<User>>(u, HttpStatus.OK);
	}

	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser() {
		List<User> u = this.userService.getAllUsers();
		return new ResponseEntity<List<User>>(u, HttpStatus.OK);
	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId) {
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Deleted!!", true), HttpStatus.OK);
	}

}
