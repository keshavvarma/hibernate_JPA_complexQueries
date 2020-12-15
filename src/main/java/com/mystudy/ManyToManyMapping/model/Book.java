/**
 * 
 */
package com.mystudy.ManyToManyMapping.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.mystudy.model.TableOperation;
import com.mystudy.util.AuditListener;

/**
 * @author Keshav
 *
 */
@EntityListeners(AuditListener.class)
@Entity
@Table(name="book_master")
public class Book extends TableOperation{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="book_id")
	private long bookId;
	@NotBlank(message="Book name can't be empty")
	@Column(name="book_name")
	private String bookName;
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="book_member",
			joinColumns= {@JoinColumn(name = "book_id", referencedColumnName = "book_id")},
			inverseJoinColumns = {@JoinColumn(name="member_id", referencedColumnName = "member_id")}
			)
	private Set<LibraryMember> members;
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Set<LibraryMember> getMembers() {
		return members;
	}
	public void setMembers(Set<LibraryMember> members) {
		this.members = members;
	}
}
