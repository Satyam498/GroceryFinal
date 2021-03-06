package com.cg.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cg.model.Cart;
import com.cg.model.Product;
import com.cg.model.User;
import com.cg.repository.CartRepository;
import com.cg.repository.ProductRepository;
import com.cg.repository.UserRepository;

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
public class CartController {
	@Autowired
	CartRepository repository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	UserRepository userRepository;
	 
	
	
	@GetMapping(path = "/getCart")
	public List<Cart> retriveAllProducts() {
		System.out.println("Inside retriveAllProducts() of Controller");
		return repository.findAll();
	}
	
	@PostMapping(path = "/add")
	public void add(@RequestParam("email") String email,@RequestParam("quantity") int quantity, @RequestParam("productId") int productId) {
		System.out.println("Inside add() of Controller");
	
		Product product = productRepository.getOne(productId);
		double productPrice = product.getProductPrice();
		String productName = product.getProductName();
		User user = userRepository.findByemail(email);
		Cart cart = new Cart(quantity, productPrice, productName,product,user);
		repository.save(cart);
		
		
	}
	
	

	@DeleteMapping(path = "/delete/{id}")
	public List<Cart> delete(@PathVariable int id) {
		System.out.println("Inside delete() of Controller");
		repository.deleteById(id);
		return repository.findAll();
	}
	
	@GetMapping(path="/findById/{id}")
	public List<Cart> findById(@PathVariable int id) {
		 System.out.println("inside findById of Controller" );
		 return repository.findAll().stream().filter(pro -> pro.getUser().getUserId()==id).collect(Collectors.toList());
	}
	
	

}
