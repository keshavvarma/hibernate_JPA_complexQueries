/**
 * 
 */
package com.mystudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mystudy.OneToManyMapping.model.Comment;

/**
 * @author Keshav
 *
 */

public interface CommentRepository extends JpaRepository<Comment, Long>{
	
}
