package com.nsag.irrigationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nsag.irrigationsystem.dao.IrrigationSensorDao;
import com.nsag.irrigationsystem.entity.IrrigationSensor;
import com.nsag.irrigationsystem.entity.LandPlots;

@Service
public class IrrigationSensorServiceImpl implements IrrigationSensorService {

	private IrrigationSensorDao irrigationSensorDao;
    @Autowired
	public IrrigationSensorServiceImpl(IrrigationSensorDao theIrrigationSesnorDao) {
    	irrigationSensorDao = theIrrigationSesnorDao;
	}
	
    @Override
    @Transactional
	public IrrigationSensor checkStatusById(int theId) {
		// TODO Auto-generated method stub
		return irrigationSensorDao.checkStatusById(theId);
	}
	@Override
	@Transactional
	public List<IrrigationSensor> lstOfSensor() {
		return irrigationSensorDao.lstOfSensor();
	}

	@Override
	@Transactional
	public void AddorUpdateSensor(IrrigationSensor theIrrigationSensor) {
		irrigationSensorDao.AddorUpdateSensor(theIrrigationSensor);
		
	}

	

	

}






