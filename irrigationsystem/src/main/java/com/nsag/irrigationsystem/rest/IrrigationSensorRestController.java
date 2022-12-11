package com.nsag.irrigationsystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsag.irrigationsystem.entity.IrrigationSensor;
import com.nsag.irrigationsystem.entity.LandPlots;
import com.nsag.irrigationsystem.entity.LandTimeandwateramount;
import com.nsag.irrigationsystem.service.IrrigationSensorService;
import com.nsag.irrigationsystem.service.LandPlotsService;
import com.nsag.irrigationsystem.service.LandTimeandwateramountService;

@RestController
@RequestMapping("/api")
public class IrrigationSensorRestController {

	private IrrigationSensorService irsensorService;
	

	@Autowired
	public IrrigationSensorRestController(IrrigationSensorService theirsensorService) {
		irsensorService = theirsensorService;
		
	}

	

	// expose "/irregsesnors" and return list of landplots and it's details
	@GetMapping("/irregsesnors")
	public List<IrrigationSensor> lstOfSensor() {
		return irsensorService.lstOfSensor();
	}

	// add mapping for GET /irregsesnors/{sesnsorId}
	
			@PutMapping("/irregsesnors/{sesnsorId}")
			public IrrigationSensor checkStatusById(@PathVariable int sesnsorId) {
				
				IrrigationSensor thesensor = irsensorService.checkStatusById(sesnsorId);
				
				
				
				return thesensor;
			}
	// add mapping for POST /irregsesnors - add new sesnor

	@PostMapping("/irregsesnors")
	public IrrigationSensor addSensor(@RequestBody IrrigationSensor theSensor) {

		theSensor.setId(0);
        
        irsensorService.AddorUpdateSensor(theSensor);

		return theSensor;
	}

	// add mapping for PUT /irregsesnors - update existing status of sensor

	@PutMapping("/irregsesnors")
	public IrrigationSensor updateSensor(@RequestBody IrrigationSensor theSensor) {
		
	
		irsensorService.AddorUpdateSensor(theSensor); 
		 
		return theSensor;
	}

}
