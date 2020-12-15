/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudy.ManyToManyMapping.model.LibraryMember;

/**
 * @author Keshav
 *
 */

public interface LibraryMemberRespository extends JpaRepository<LibraryMember, Long>{

}
