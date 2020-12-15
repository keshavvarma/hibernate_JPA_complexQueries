/**
 * 
 */
package com.mystudy.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.OneToOneUsingJoinTable.model.User;
import com.mystudy.model.TaggingManagement;
import com.mystudy.model.Team;
import com.mystudy.repository.TaggingManagementRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class TaggingManagementDao{
	@Autowired
	TaggingManagementRepository taggingManagementRepository;
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public TaggingManagement tagTeam(long teamId, long userId) {
		Team team = entityManager.find(Team.class, teamId);
		User user = entityManager.find(User.class, userId);
		TaggingManagement taggingmanagement = new TaggingManagement();
		taggingmanagement.setTeam(team);
		taggingmanagement.setUser(user);
		return taggingManagementRepository.save(taggingmanagement);
	}
}
