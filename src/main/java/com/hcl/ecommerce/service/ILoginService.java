package com.hcl.ecommerce.service;

import org.springframework.stereotype.Service;

@Service
public interface ILoginService {
	
	public String findByLoginAndPassword(String login,String password);
}
