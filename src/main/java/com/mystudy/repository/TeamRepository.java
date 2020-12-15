/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudy.model.Team;

/**
 * @author Keshav
 *
 */

public interface TeamRepository extends JpaRepository<Team, Long>{

}
