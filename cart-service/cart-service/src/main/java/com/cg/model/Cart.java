package com.cg.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * @author ${Satyam kumar}
 *
 *
 *
 *@Entity
 *this annotation marks this class as an entity. @Table annotation specifies the table name where data of this entity is to be persisted. 
 * 
 * @Id annotation specifies the primary key of an entity 
 * 
 * 
 * @ override
 * The @Override annotation informs the compiler that the element is meant to override an element declared in a superclass.
 *
 */

/*
 *The Serializable interface is just a marker. It means that objects can be serialized, i.e. they can be represented as a bit string and restored from that bit string. 
 **/

@Entity(name = "carttable")
public class Cart implements Serializable{

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;

	@Column
	private int quantity;

	@Column
	private double productPrice;

	@Column
	private String productName;

	@ManyToOne
	private Product product;
	
	/*The meaning of CascadeType.ALL is that the persistence will propagate (cascade) all EntityManager operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the relating entities
		FetchType.LAZY = This does not load the relationships unless you invoke it via the getter method.
		LAZY on the other hand means that the contents of the List are fetched only when you try to access them.
		EAGER loading of collections means that they are fetched fully at the time their parent is fetched.
*/
	@OneToMany(mappedBy = "cartBean1", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<OrderBean> orderBeanList;

	
	/*
	 @JsonBackReference -> Manages the reverse part of the reference and the fields/collections marked with this annotation are not serialised.
	 */
	@JsonBackReference(value="abc")
	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Cart(int quantity, double productPrice, String productName,Product product,User user) {
		super();
		
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.productName = productName;
		this.product = product;
		this.user=user;
	}

	public Cart(Integer cartId, int quantity, double productPrice, String productName, Product product, User user) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
		this.productPrice = productPrice;
		this.productName = productName;
		this.product = product;
		this.user = user;
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", quantity=" + quantity + ", productPrice=" + productPrice + ", productName="
				+ productName + ", product=" + product + ", user=" + user + "]";
	}

}
