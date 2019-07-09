package com.hcl.ecommerce.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.repository.ILoginRepo;

@Service
public class LoginServiceImpl implements ILoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	ILoginRepo loginRepo;

	@Override
	public String findByLoginAndPassword(String login, String password) throws UserNotFoundException {

		Optional<User> user = loginRepo.findByLoginAndPassword(login, password);
		if (!user.isPresent()) {
			throw new UserNotFoundException("Customer Details Not Exist");
		}
		LOGGER.info("checking the customer login status condition");
		return "Customer Logged in Sucessfully";
	}

}
