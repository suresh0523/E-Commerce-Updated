package com.hcl.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.repository.IUserRepo;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	IUserRepo userRepo;

	public User customerRegistration(User user) {
		return userRepo.save(user);

	}

	@Override
	public void deleteCustomerAccount(Long userId) throws UserNotFoundException {
		Optional<User> user = userRepo.findById(userId);
		if (!user.isPresent()) {
			throw new UserNotFoundException("Customer Details Not Found !");
		}
		userRepo.deleteById(userId);
	}

	@Override
	public User updateCustomerProfile(Long userId, User user) throws UserNotFoundException {
		Optional<User> userData = userRepo.findById(userId);
		if (!userData.isPresent()) {
			throw new UserNotFoundException("User Details Not Exist !");

		}

		userData.get().setLogin(user.getLogin());
		userData.get().setPassword(user.getPassword());
		userData.get().setUserName(user.getUserName());
		userData.get().setUserType(user.getUserType());
		
		
		return userRepo.save(userData.get());
	}

	@Override
	public String findUsernameAndPassword(String login, String password) {

		User user = userRepo.findByLogin(login);
		if (user != null) {
			return "User Logged in Sucessfully";
		}

		return "User Logged in Sucessfully";
	}

	@Override
	public List<User> findUsers(String userType) {
		List<User> li = userRepo.findByUserType(userType);
		return li;
	}

}
