package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.service.LoginServiceImpl;

@RestController
@RequestMapping
public class LoginController {

	@Autowired
	LoginServiceImpl loginServiceImpl;
	
	

	@PostMapping("/customer/{login}/{password}")
	public ResponseEntity<String> customerLogin(@PathVariable String login,@PathVariable String password) {
		return ResponseEntity.ok(loginServiceImpl.findByLoginAndPassword(login, password));

	}

	
	
}
