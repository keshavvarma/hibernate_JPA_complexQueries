/**
 * 
 */
package com.mystudy.OneToOneUsingJoinTable.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mystudy.OneToOneUsingJoinTable.model.User;
import com.mystudy.OneToOneUsingJoinTable.model.Vehicle;
import com.mystudy.repository.VehicleRepository;

/**
 * @author Keshav
 *
 */
@Repository
public class VehicleDao{
	@Autowired
	VehicleRepository vehicleRepository;
	
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	public Vehicle find(long vehicleId) {
		Optional<Vehicle> optional = vehicleRepository.findById(vehicleId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	public User findUserByVehicleId(long vehicleId) {
		
		return null;
	}
}
