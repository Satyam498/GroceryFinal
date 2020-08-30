package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.model.Cart;
import com.cg.model.Product;
/**
 * @author ${Satyam kumar}
 *
 *
 * @Repository is a Spring annotation that indicates that the decorated class is
 *             a repository. A repository is a mechanism for encapsulating
 *             storage, retrieval, and search behavior which emulates a
 *             collection of objects
 */
public interface CartRepository extends JpaRepository<Cart, Integer> {

	void save(Product product);

}
