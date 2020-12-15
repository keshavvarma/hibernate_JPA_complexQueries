/**
 * 
 */
package com.mystudy.OneToOneUsingJoinTable.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mystudy.OneToOneUsingJoinTable.dao.VehicleDao;
import com.mystudy.OneToOneUsingJoinTable.model.User;
import com.mystudy.OneToOneUsingJoinTable.model.Vehicle;

/**
 * @author Keshav
 *
 */

@Service
public class VehicleService {
	@Autowired
	VehicleDao vehicleDao;
	
	public Vehicle save(Vehicle vehicle) {
		return vehicleDao.save(vehicle);
	}
	
	public Vehicle find(long vehicleId) {
		return vehicleDao.find(vehicleId);
	}
	
	public User getUserByVehicleId(long vehicleId) {
		return vehicleDao.findUserByVehicleId(vehicleId);
	}
	
}
