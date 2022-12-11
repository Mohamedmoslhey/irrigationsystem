package com.nsag.irrigationsystem.dao;

import java.util.List;

import com.nsag.irrigationsystem.entity.IrrigationSensor;





public interface IrrigationSensorDao {
	
    public List<IrrigationSensor> lstOfSensor();
    public IrrigationSensor checkStatusById(int theId);
	public void AddorUpdateSensor(IrrigationSensor theSensor);
	
	
}
