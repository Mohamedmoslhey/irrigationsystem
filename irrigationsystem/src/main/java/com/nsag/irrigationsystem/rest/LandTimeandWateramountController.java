package com.nsag.irrigationsystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.nsag.irrigationsystem.entity.LandTimeandwateramount;

import com.nsag.irrigationsystem.service.LandTimeandwateramountService;

@RestController
@RequestMapping("/api")
public class LandTimeandWateramountController {

	private LandTimeandwateramountService landTimeandwateramountService;
	
	@Autowired
	public LandTimeandWateramountController(LandTimeandwateramountService theTimeandWaterAmnt) {
		landTimeandwateramountService = theTimeandWaterAmnt;
	}
	
	// expose "/timewateramnt" and return list of theTimeandWaterAmnt for each size
	@GetMapping("/timewateramnt")
	public List<LandTimeandwateramount> lstOfLandTimeandwateramount() {
		return landTimeandwateramountService.lstOfLandTimeandwateramount();
	}

	
	
	// add mapping for POST /timewateramnt - add new theTimeandWaterAmnt with size as ref
	
	@PostMapping("/timewateramnt")
	public LandTimeandwateramount addlandPlot(@RequestBody LandTimeandwateramount theTimeandWaterAmnt) {
		
		
		theTimeandWaterAmnt.setId(0);
		
		landTimeandwateramountService.AddorUpdateTimeSltAndWatrAmnt(theTimeandWaterAmnt);
		
		return theTimeandWaterAmnt;
	}
	
	// add mapping for PUT /timewateramnt - update existing theTimeandWaterAmnt for size
	
	@PutMapping("/timewateramnt")
	public LandTimeandwateramount updatelandPlot(@RequestBody LandTimeandwateramount theTimeandWaterAmnt) {
		
		landTimeandwateramountService.AddorUpdateTimeSltAndWatrAmnt(theTimeandWaterAmnt);
		
		return theTimeandWaterAmnt;
	}
	
	
	
}










