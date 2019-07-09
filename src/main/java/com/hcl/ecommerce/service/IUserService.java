package com.hcl.ecommerce.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.ecommerce.entity.User;

@Service
public interface IUserService {
	public User customerRegistration(User user);
	
	 void deleteCustomerAccount(Long userId);

	public User updateCustomerProfile(Long userId,User user);
	

	public String findUsernameAndPassword(String login,String password );
	
	public List<User> findUsers(String userType);
	


}
