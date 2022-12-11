package com.nsag.irrigationsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nsag.irrigationsystem.entity.IrrigationSensor;
import com.nsag.irrigationsystem.entity.LandPlots;

@Repository
public class IrrigationSensorDaoImp implements IrrigationSensorDao {
   private EntityManager entityManager;
   
   @Autowired
	public IrrigationSensorDaoImp(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

   
   @Override
	public IrrigationSensor checkStatusById(int theId) {

		// get sesnsor
	   IrrigationSensor thesensor = 
				entityManager.find(IrrigationSensor.class, theId);
		
		// return sensor
		return thesensor;
	}
	@Override
	public List<IrrigationSensor> lstOfSensor() {
		// create a query
				Query theQuery = 
						entityManager.createQuery("from IrrigationSensor");
				
				// execute query and get result list
				List<IrrigationSensor> lstOfSensor = theQuery.getResultList();
				
				// return the results		
				return lstOfSensor;
		
	}

	@Override
	public void  AddorUpdateSensor(IrrigationSensor theSensor) {
		// save or update the Sesnor for each plot
		IrrigationSensor iSensor = entityManager.merge(theSensor);
				
				// update with id from db ... so we can get generated id for save/insert
		       theSensor.setId(iSensor.getId());

	}

	
	
}
