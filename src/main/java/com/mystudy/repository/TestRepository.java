/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudy.model.Test;

/**
 * @author om
 *
 */
public interface TestRepository extends JpaRepository<Test, Long>{

}
