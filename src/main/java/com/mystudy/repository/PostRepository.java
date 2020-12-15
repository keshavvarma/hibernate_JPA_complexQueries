/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudy.OneToManyMapping.model.Post;

/**
 * @author Keshav
 *
 */

public interface PostRepository extends JpaRepository<Post, Long>{

}
