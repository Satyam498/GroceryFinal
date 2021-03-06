
package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.model.User;
import com.cg.repository.UserRepository;
/**
 * @author ${Satyam kumar}
 *
 *
 *
 *@Service
 *Service Components are the class file which contains @Service annotation.
 * These class files are used to write business logic in a different layer, separated from @RestController class file
 *
 *@Autowired 
 * If we declare the autowire annotation on top of the method or property, 
 * the IOC container always searches whether a dependency property name and 
 * the bean id in XML are matched or not,
 * if those are matched the automatic dependency injection will happen.
 *
 * @ override
 * The @Override annotation informs the compiler that the element is meant to override an element declared in a superclass.
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	public UserRepository repos;

	public List<User> findAll() {
		System.out.println("inside findAll method of UserService");
		return repos.findAll();
	}

	public User addUser(@RequestBody User user) {
		System.out.println("inside addUser method of UserService");
		if (user != null) {
			repos.save(user);
			return user;
		} else
			return null;
	}

	public User findByUserId(int userId) {
		System.out.println("inside findByUserId method of UserService");
		return repos.findByUserId(userId);

	}

	public void deleteUser(int accNumber) {
		System.out.println("inside deleteUser method of UserService");
		repos.deleteById(accNumber);

	}

	@Override
	public void updateUser(User user) {
		//repos.deleteById(user.getUserId());
		repos.save(user);

	}

	public User findByemail(String email) {
		System.out.println("inside findByemail method of UserService");
		return repos.findByemail(email);

	}

	@Override
	public User updateProfile(User updateUser) {
		User user = repos.findById(updateUser.getUserId()).get();

		if (user == null) {
			return null;
		} else {
			user.setFname(updateUser.getFname());
			user.setLname(updateUser.getLname());
			user.setMobile(updateUser.getMobile());
			user.setAddress(updateUser.getAddress());

			repos.save(user);
			return user;
		}
	}

}
