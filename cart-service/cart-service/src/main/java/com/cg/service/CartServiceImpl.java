package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.model.Cart;
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
public class CartServiceImpl implements CartService {

	@Override
	public List<Cart> retriveAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(String email, int quantity, int productId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cart> delete(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Cart> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cart> findByUserId(int userId) {
		// TODO Auto-generated method stub
		
		
		return null;
	}

}
