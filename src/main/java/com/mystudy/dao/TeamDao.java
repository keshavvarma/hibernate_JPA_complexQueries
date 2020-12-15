/**
 * 
 */
package com.mystudy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.model.Team;
import com.mystudy.repository.TeamRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class TeamDao{
	@Autowired
	TeamRepository teamRepository;
	
	public Team save(Team team) {
		return teamRepository.save(team);
	}
}
