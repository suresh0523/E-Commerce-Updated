package com.hcl.ecommerce.serviceImpl;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.exception.UserNotFoundException;
import com.hcl.ecommerce.repository.IUserRepo;
import com.hcl.ecommerce.service.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Mock
	IUserRepo userRepo;

	/**
	 * Positive test case for create user
	 */

	@Test
	public void testadduser() throws UserNotFoundException {

		User user = getUser();
		Mockito.when(userRepo.save(user)).thenReturn(user);
		User actualValue = userServiceImpl.customerRegistration(user);
		assertEquals(user, actualValue);
	}

	@Test
	public void testdeleteUser() throws UserNotFoundException {
		Long id = 23L;
		User user = new User();
		user.setUserId(12L);
		user.setLogin("suresh");
		user.setPassword("575482bhbkj");
		user.setUserName("mahesh");
		user.setUserType("Buyer");
		String str = "value";
		Mockito.when(userRepo.findById(user.getUserId())).thenReturn(Optional.of(user));
		userRepo.deleteById(user.getUserId());
		userServiceImpl.deleteCustomerAccount(user.getUserId());
		// assertEquals("User Deleted Sucessfully !", actualValue);
	}

	@Test(expected = UserNotFoundException.class)
	public void testEmployeeNotFoundException() throws UserNotFoundException {
		userServiceImpl.deleteCustomerAccount(2L);
	}

	@Test
	public void testUserUpdate() throws UserNotFoundException {
		Long userId = 12L;
		User user = new User();
		user.setUserId(12L);
		user.setLogin("suresh");
		user.setPassword("575482bhbkj");
		user.setUserName("mahesh");
		user.setUserType("Buyer");

		Mockito.when(userRepo.findById(user.getUserId())).thenReturn(Optional.of(user));
		Mockito.when(userRepo.save(user)).thenReturn(user);
		User actual = userServiceImpl.updateCustomerProfile(userId, user);
		assertEquals(user, actual);
	}

	public User getUser() {
		User user = new User();
		user.setUserId(12L);
		user.setLogin("suresh");
		user.setPassword("575482bhbkj");
		user.setUserName("mahesh");
		user.setUserType("Buyer");
		return user;
	}
	
	

}
