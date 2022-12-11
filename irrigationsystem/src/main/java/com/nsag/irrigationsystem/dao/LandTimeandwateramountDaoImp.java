package com.nsag.irrigationsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.nsag.irrigationsystem.entity.LandTimeandwateramount;

@Repository
public class LandTimeandwateramountDaoImp implements LandTimeandwateramountDao {
   private EntityManager entityManager;
   
   @Autowired
	public LandTimeandwateramountDaoImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<LandTimeandwateramount> lstOfLandTimeandwateramount() {
		// create a query
		Query theQuery = 
				entityManager.createQuery("from LandTimeandwateramount");
		
		// execute query and get result list
		List<LandTimeandwateramount> lstOfTimeandwateramount = theQuery.getResultList();
		
		// return the results		
		return lstOfTimeandwateramount;
	}

	@Override
	public void AddorUpdateTimeSltAndWatrAmnt(LandTimeandwateramount theTimeAndWaterAmnt) {
		// save or update Time and amount of water
		LandTimeandwateramount TimeAndWaterAmnt = entityManager.merge(theTimeAndWaterAmnt);
			
			// update with id from db ... so we can get generated id for save/insert
		theTimeAndWaterAmnt.setId(TimeAndWaterAmnt.getId());

		
	}

}
