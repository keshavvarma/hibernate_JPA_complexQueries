/**
 * 
 */
package com.mystudy.OneToOneUsingJoinTable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.OneToOneUsingJoinTable.dao.UserDao;
import com.mystudy.OneToOneUsingJoinTable.model.User;
import com.mystudy.OneToOneUsingJoinTable.model.Vehicle;

/**
 * @author Keshav
 *
 */

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public User save(User user) {
		return userDao.save(user);
	}
	
	public User find(long userId) {
		return userDao.find(userId);
	}

	public User findUserAndVehicleByUserId(long userId) {
		return userDao.findUserAndVehicleByUserId(userId);
	}
}
