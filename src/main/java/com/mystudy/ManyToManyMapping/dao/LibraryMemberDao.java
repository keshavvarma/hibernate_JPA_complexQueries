/**
 * 
 */
package com.mystudy.ManyToManyMapping.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.ManyToManyMapping.model.Book;
import com.mystudy.ManyToManyMapping.model.LibraryMember;
import com.mystudy.repository.LibraryMemberRespository;

/**
 * @author Keshav
 *
 */
@Repository
public class LibraryMemberDao {
	@Autowired
	LibraryMemberRespository libraryMemberRepository;
	@PersistenceContext
	EntityManager entityManager;
	
	public LibraryMember save(LibraryMember member){
		return libraryMemberRepository.save(member);
	}
	
	public List<LibraryMember> findAll(){
		return libraryMemberRepository.findAll();
	}
	
	@Transactional
	public LibraryMember issueBook(long memberId, long bookId){
		Book book = entityManager.getReference(Book.class, bookId);
		LibraryMember member = entityManager.getReference(LibraryMember.class, memberId);
		List<Book> books = new ArrayList<Book>();
		books.add(book);
		//member.setBooks(Arrays.asList(book));
		//member.setBooks(books);
		book.getMembers().add(member);
		member.getBooks().add(book);
		//book.setMembers(Arrays.asList(member));
		return entityManager.merge(member);
		//return LibraryMemberRepository.save(member);
	}

	@Transactional
	public Object find(long memberId) {
		Optional<LibraryMember> optional = libraryMemberRepository.findById(memberId);
		if(optional.isPresent()) {
			optional.get().getBooks().size();
			return optional.get();
		}
		return null;
	}
}
