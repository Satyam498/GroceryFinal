package com.cg.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.model.Login;
import com.cg.repository.LoginRepository;

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
@Service(value = "service")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginRepository repos;

	@Override
	public Login addCredential(Login login) {
		return repos.save(login);
	}

	@Override
	public List<Login> getAll() {
		return repos.findAll();
	}

}
