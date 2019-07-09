package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.service.UserServiceImpl;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@PostMapping("/customer/registration")
	public ResponseEntity<User> customerRegistration(@RequestBody User user) {
		return ResponseEntity.ok(userServiceImpl.customerRegistration(user));

	}
	
	@DeleteMapping("/deleteCustomerAccount/{userId}")
	public ResponseEntity<String> deleteCustomerById(@PathVariable Long userId) {
		 userServiceImpl.deleteCustomerAccount(userId);
		 return ResponseEntity.ok("Customer Removed Sucessfully");
	}
	
	@PutMapping("/customerProfileUpdate/{userId}")
	public ResponseEntity<User> updateCustomerProfile(@PathVariable Long userId,@RequestBody User user) throws UserNotFoundException
	{
		
		return ResponseEntity.ok(userServiceImpl.updateCustomerProfile(userId, user));
	}
	
	@GetMapping("/users/{userType}")
	public List<User> findUsers(@PathVariable String userType)
	{
		return userServiceImpl.findUsers(userType);
	}
	

	@PostMapping("/users/{login}/{password}")
	public String loginUser(@RequestHeader(value ="login") String login,@RequestHeader(value ="password") String password) {
		return userServiceImpl.findUsernameAndPassword(login, password);
	}
	
//	@GetMapping("/userType/{userType}")
//	public  List<User> findUsers(@PathVariable String userType)
//	{
//		
//		return userServiceImpl.findUsers(userType);
//		
//		
//	}
}
