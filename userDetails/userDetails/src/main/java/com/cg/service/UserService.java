
package com.cg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.model.User;

@Service
public interface UserService {
	List<User> findAll();

	User addUser(User user);

	User findByUserId(int userId);

	void deleteUser(int userId);

	void updateUser(User user);

	User findByemail(String email);

	public User updateProfile(User updateUser);
}
