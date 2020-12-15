/**
 * 
 */
package com.mystudy.ManyToManyMapping.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Keshav
 *
 */
@Entity
@Table(name="library_member")
public class LibraryMember {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="member_id")
	private long memberId;
	@Column(name="member_name")
	private String memberName;
	@ManyToMany(mappedBy = "members", fetch=FetchType.LAZY)
	private Set<Book> books;
	
	public long getMemberId() {
		return memberId;
	}
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
}
