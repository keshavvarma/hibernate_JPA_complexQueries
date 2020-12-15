/**
 * 
 */
package com.mystudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.dao.TaggingManagementDao;
import com.mystudy.model.TaggingManagement;

/**
 * @author Keshav
 *
 */
@Service
public class TaggingManagementService {
	@Autowired
	TaggingManagementDao taggingmanagementDao;
	
	public TaggingManagement tagTeam(long teamId, long userId) {
		return taggingmanagementDao.tagTeam(teamId, userId);
	}
}
