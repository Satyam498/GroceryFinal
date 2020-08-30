
package com.cg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.model.User;
/**
 * @author ${Satyam kumar}
 *
 *
 * @Repository is a Spring annotation that indicates that the decorated class is
 *             a repository. A repository is a mechanism for encapsulating
 *             storage, retrieval, and search behavior which emulates a
 *             collection of objects
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findByUserId(int userId);
	public User findByemail(String email);
}
