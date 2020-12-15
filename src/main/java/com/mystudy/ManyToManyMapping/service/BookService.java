/**
 * 
 */
package com.mystudy.ManyToManyMapping.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.ManyToManyMapping.dao.BookDao;
import com.mystudy.ManyToManyMapping.model.Book;

/**
 * @author Keshav
 *
 */
@Service
@Transactional
public class BookService {
	@Autowired
	BookDao bookDao;

	public Book save(Book book) {
		return bookDao.save(book);
	}

	public List<Book> findAll() {
		return bookDao.findAll();
	}

	public Object find(long bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Book update(Book book) {
		return bookDao.update(book);
	}
}
