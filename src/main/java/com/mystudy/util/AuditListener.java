/**
 * 
 */
package com.mystudy.util;

import javax.persistence.EntityListeners;
import javax.persistence.PostPersist;

import com.mystudy.ManyToManyMapping.model.Book;

/**
 * @author Keshav
 *
 */
public class AuditListener {
	/**
	 * Entity listener must have 
	 * 1. either no constructor or public no-argument constructor
	 * 2. Single object parameter: the entity instance involved in the state change
	 * 3. Intercepting: for callback entity listener class must be enabled for that entity
	 * 		with @EntityListeners annotation on entity
	 * 		@EntityListeners(AuditListener.class)
	 * 
	 * 
	 * We can also add callback methods in the entity itself
	 */
	/**
	 * 
	 * With Audit listener it is easy to perform some activity depend on it
	 */
	@PostPersist
	public void postPersist(Object object) {
		if(object instanceof Book) {
			System.out.println("new book added");
		}
	}
}
