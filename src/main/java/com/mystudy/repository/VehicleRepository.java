/**
 * 
 */
package com.mystudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mystudy.OneToOneUsingJoinTable.model.Vehicle;

/**
 * @author Keshav
 *
 */

public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

}
