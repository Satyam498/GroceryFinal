package com.cg.controllers;

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

import com.cg.models.Product;
import com.cg.service.ProductServiceImpl;

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
@RequestMapping("/Product")
@Api(value = "ProductGrocery")
public class ProductController {

	@Autowired
	ProductServiceImpl service;

	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

	@GetMapping(path = "/getProducts")
	@ApiOperation(value = "retriveAllProducts", nickname = "retriveAllProducts")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Product.class),
			@ApiResponse(code = 500, message = "Failure", response = Product.class) })
	public List<Product> retriveAllProducts() {
		System.out.println("Inside retriveAllProducts() of Controller");
		return service.retriveAllProducts();
	}

	@PostMapping(path = "/add")
	@ApiOperation(value = "addProducts", nickname = "addProducts")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Product.class),
			@ApiResponse(code = 500, message = "Failure", response = Product.class) })
	public Product add(@Valid @RequestBody Product product) {
		System.out.println("Inside add() of Controller");
		return service.add(product);
	}

	@DeleteMapping(path = "/delete/{id}")
	@ApiOperation(value = "deleteProducts", nickname = "deleteProducts")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Product.class),
			@ApiResponse(code = 500, message = "Failure", response = Product.class) })
	public List<Product> delete(@PathVariable int id) {
		System.out.println("Inside delete() of Controller");
		service.delete(id);
		return service.retriveAllProducts();

	}

	@PutMapping(path = "/update/{productId}")
	@ApiOperation(value = "editProduct", nickname = "editProduct")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = Product.class),
			@ApiResponse(code = 500, message = "Failure", response = Product.class) })
	public Product editProduct(@Valid @PathVariable int productId, @RequestBody Product product) {

		return service.editProduct(product);

	}
}
