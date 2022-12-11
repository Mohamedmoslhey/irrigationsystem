package com.nsag.irrigationsystem.service;

import java.util.List;

import com.nsag.irrigationsystem.entity.IrrigationSensor;

public interface IrrigationSensorService {

	public List<IrrigationSensor> lstOfSensor();
	public void AddorUpdateSensor(IrrigationSensor theSensor);
	public IrrigationSensor checkStatusById(int theId);
	
}
