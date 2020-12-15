/**
 * 
 */
package com.mystudy.ManyToManyMapping.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.ManyToManyMapping.model.Book;
import com.mystudy.repository.BookRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class BookDao {
	@Autowired
	BookRepository bookRepository;
	@PersistenceContext
	EntityManager entityManager;
	
	public Book save(Book book) {
		entityManager.persist(book);
		//return bookRepository.save(book);
		return book;
	}
	
	public List<Book> findAll(){
		return bookRepository.findAll();
	}

	@Transactional
	public Book update(Book book) {
		Book book2 = entityManager.getReference(Book.class, book.getBookId());
		book2.setBookName(book.getBookName());
		return bookRepository.save(book2);
	}
	

}
