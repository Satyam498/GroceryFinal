
package com.cg.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cg.model.User;

import com.cg.repository.UserRepository;
import com.cg.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author ${Satyam Kumar}
 *
 * @RestController 
 * is a convenience annotation for creating Restful controllers. 
 * It is a specialization of @Component and is autodetected through classpath scanning. It adds the @Controller and @ResponseBody annotations. 
 * It converts the response to JSON or XML.
 * 
 * @CrossOrigin annotation
 *  to handle Cross-Origin-Resource-Sharing (CORS).
 *  This annotation is used at class level as well as method level in RESTful Web service controller.
 *   @CrossOrigin annotation is used at method level with @RequestMapping annotation.
 * 
 * RequestMapping annotation is used to map web requests onto specific handler classes and/or handler methods.
 * 
 * 
 * @PostMapping annotation maps HTTP POST requests onto specific handler methods. 
 * It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod)
 * 
 * 
 * Logger
 * ALL	All levels including custom levels.
DEBUG	Designates fine-grained informational events that are most useful to debug an application.
INFO	Designates informational messages that highlight the progress of the application at coarse-grained level.
WARN	Designates potentially harmful situations.
 *
 * 
 * 
 * 
 * 
 */


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/User")
@Api(value = "UserGrocery")
public class UserController {
	@Autowired
	public UserService service;
	@Autowired
	public UserRepository repo;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@GetMapping(path = "/")
	@ApiOperation(value = "retrieveAllUsers", nickname = "retrieveAllUsers")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	public List<User> retrieveAllUsers() {
		System.out.println("Inside retrieveAllUsers method of UserController");
		return service.findAll();
	}

	@PostMapping(path = "/add")
	@ApiOperation(value = "addUser", nickname = "addUser")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	User addUser(@RequestBody User user) {
		System.out.println("inside addUser");
		return service.addUser(user);
	}

	@GetMapping(path = "/{userId}")
	@ApiOperation(value = "retrieveByUserId", nickname = "retrieveByUserId")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	User retrieveByUserId(@PathVariable("userId") int userId) {
		return service.findByUserId(userId);
	}

	@DeleteMapping(path = "/delete/{userId}")
	@ApiOperation(value = "deleteUser", nickname = "deleteUser")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	void deleteUser(@PathVariable int userId) {
		service.deleteUser(userId);
	}

	@PutMapping(path = "/update/{userId}")
	@ApiOperation(value = "updateUser", nickname = "updateUser")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	public void updateUser(@Valid @PathVariable int userId, @RequestBody User user) {
		service.updateUser(user);

	}

	@GetMapping(path = "/findbyemail/{email}")
	@ApiOperation(value = "retrieveByemail", nickname = "retrieveByemail")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	User retrieveByemail(@PathVariable("email") String email) {
		return service.findByemail(email);
	}

	@PostMapping(path = "/update")
	@ApiOperation(value = "updateProfile", nickname = "updateProfile")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = User.class),
			@ApiResponse(code = 500, message = "Failure", response = User.class) })
	public User updateProfile(@RequestBody User updateUser) {

		User user = service.updateProfile(updateUser);
		if (user == null) {
			return null;
		} else {
			return user;

		}

	}
}