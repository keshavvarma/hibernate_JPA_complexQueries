/**
 * 
 */
package com.mystudy.OneToOneUsingJoinTable.dao;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.OneToOneUsingJoinTable.model.User;
import com.mystudy.OneToOneUsingJoinTable.model.Vehicle;
import com.mystudy.repository.UserRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class UserDao{
	@Autowired
	UserRepository userRepository;
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public User save(User user) {
		Vehicle vehicle = entityManager.find(Vehicle.class, user.getVehicle().getVehicleId());
		user.setVehicle(vehicle);
		return userRepository.save(user);
	}

	public User find(long userId) {
		Optional<User> optional = userRepository.findById(userId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public User findUserAndVehicleByUserId(long userId) {
		StringBuffer sb = new StringBuffer();
		sb.append(" select u from User u left join fetch u.vehicle v")
		.append(" where u.userId = u.vehicle.user.userId")
		.append(" and u.userId = :userId");
		return entityManager.createQuery(sb.toString(), User.class).setParameter("userId", userId).getSingleResult();
	}
}
