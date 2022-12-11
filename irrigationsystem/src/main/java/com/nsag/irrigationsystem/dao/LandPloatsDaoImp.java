package com.nsag.irrigationsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nsag.irrigationsystem.entity.LandPlots;

@Repository
public class LandPloatsDaoImp implements LandPlotsDao {
   private EntityManager entityManager;
   
   @Autowired
	public LandPloatsDaoImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

   @Override
	public LandPlots checkStatusById(int theId) {

		// get LandPlot
	   LandPlots theLandPlot = 
				entityManager.find(LandPlots.class, theId);
		
		// return LandPlots
		return theLandPlot;
	}
	@Override
	public List<LandPlots> lstOfLandPlot() {
		// create a query
				Query theQuery = 
						entityManager.createQuery("from LandPlots");
				
				// execute query and get result list
				List<LandPlots> lstOfLandPlots = theQuery.getResultList();
				
				// return the results		
				return lstOfLandPlots;
		
	}

	@Override
	public void AddorUpdateLandPlot(LandPlots theLandPlot) {
		// save or update the Land plot
		       LandPlots LandPlot = entityManager.merge(theLandPlot);
				
				// update with id from db ... so we can get generated id for save/insert
		       theLandPlot.setId(LandPlot.getId());

	}

}
