/**
 * 
 */
package com.mystudy.ManyToManyMapping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.ManyToManyMapping.dao.LibraryMemberDao;
import com.mystudy.ManyToManyMapping.model.LibraryMember;

/**
 * @author Keshav
 *
 */
@Service
public class LibraryMemberService {
	@Autowired
	LibraryMemberDao libraryMemberDao;

	public LibraryMember save(LibraryMember libraryMember) {
		return libraryMemberDao.save(libraryMember);
	}

	public List<LibraryMember> findAll() {
		return libraryMemberDao.findAll();
	}
	
	public LibraryMember issueBook(long memberId, long bookId) {
		return libraryMemberDao.issueBook(memberId, bookId);
	}
	

	public Object find(long memberId) {
		return libraryMemberDao.find(memberId);
	}
}
