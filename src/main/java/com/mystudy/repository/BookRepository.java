/**
 * 
 */
package com.mystudy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mystudy.ManyToManyMapping.model.Book;

/**
 * @author Keshav
 *
 */

public interface BookRepository extends JpaRepository<Book, Long>{

	@Override
	@Query("SELECT b FROM Book b WHERE b.deletedBy IS NULL")
	public List<Book> findAll();
}
