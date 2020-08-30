package com.cg.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.model.Cart;
import com.cg.model.OrderBean;
import com.cg.model.Product;
import com.cg.model.User;
import com.cg.repository.CartRepository;
import com.cg.repository.OrderRepository;
import com.cg.repository.ProductRepository;
import com.cg.repository.UserRepository;

@RestController
public class OrderController {

		@Autowired
		private OrderRepository repository;
		
		@Autowired
		CartRepository cartRepository;
		
		@Autowired
		ProductRepository productRepository;
		@Autowired
		UserRepository userRepository;
		
		@PostMapping(path = "/addOrder/{userId}")
		public void addOrderByCustomer(@PathVariable int userId, @RequestBody OrderBean order) {
		//		Cart cart= cartRepository.getOne(cartId);
//			double totalBill = totalBill;
//			String productName = product.getProductName();
//			User user = userRepository.findByemail(email);
//			Cart cart = new Cart(userId, productPrice, productName,product,user);
//			OrderBean order =new OrderBean(userId,cartId,totalBill,new Date(8, 8, 2020),cart);
//				order.setCartId(cartId);
//				order.setCartBean1(cart);
//				order.setOrderDate(Date.valueOf(LocalDate.now()));
//			repository.save(order);
			
			double sum=0;
			List<Cart> or =cartRepository.findAll().stream().filter(pro -> pro.getUser().getUserId()==userId).collect(Collectors.toList());
			for(Cart c:or) {
				sum += c.getQuantity()*c.getProductPrice();
			}
//			order.setCartBean1(or);
//			order.setTotalBill(sum);
//			order.setOrderDate(Date.valueOf(LocalDate.now()));
//			
//			repository.save(order);
		}
		
		
//		@GetMapping(path="/findByCartId/{id}")
//		public List<Cart> findById(@PathVariable int id) {
//			 System.out.println("inside findById of Controller" );
//			//return repository.findAll();
//			 
//			 return orderDao.viewcartByCustomerId(id);
//		}
	
}
