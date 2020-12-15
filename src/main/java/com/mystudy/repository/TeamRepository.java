/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudy.model.Team;

/**
 * @author om
 *
 */
public interface TeamRepository extends JpaRepository<Team, Long>{

}
