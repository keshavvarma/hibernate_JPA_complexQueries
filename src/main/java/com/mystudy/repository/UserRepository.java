/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudy.OneToOneUsingJoinTable.model.User;

/**
 * @author Keshav
 *
 */

public interface UserRepository extends JpaRepository<User, Long>{

}
