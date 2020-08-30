package com.cg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.service.LoginServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import com.cg.model.Login;
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
@RequestMapping("/Login")
@Api(value = "LoginGrocery")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private LoginServiceImpl service;

	@PostMapping(path = "/AddLogin")
	@ApiOperation(value = "addCredential", nickname = "addCredential")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Login.class),
			@ApiResponse(code = 500, message = "Failure", response = Login.class) })
	Login addCredential(@RequestBody Login login) {
		logger.info("add Credentials ");
		return service.addCredential(login);
	}

	@GetMapping("/getall")
	@ApiOperation(value = "displayallLoginCredential", nickname = "displayallLoginCredential")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Login.class),
			@ApiResponse(code = 500, message = "Failure", response = Login.class) })
	public List<Login> getAll() {
		logger.info("display Credentials");
		return service.getAll();
	}
}
