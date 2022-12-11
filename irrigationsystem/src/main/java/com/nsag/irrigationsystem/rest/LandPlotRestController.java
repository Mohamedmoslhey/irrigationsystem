package com.nsag.irrigationsystem.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.nsag.irrigationsystem.entity.IrrigationSensor;
import com.nsag.irrigationsystem.entity.LandPlots;
import com.nsag.irrigationsystem.entity.LandTimeandwateramount;
import com.nsag.irrigationsystem.service.IrrigationSensorService;
import com.nsag.irrigationsystem.service.LandPlotsService;
import com.nsag.irrigationsystem.service.LandTimeandwateramountService;

@RestController
@RequestMapping("/api")
public class LandPlotRestController {

	private LandPlotsService landPlotsService;
	private LandTimeandwateramountService landTimeandwateramountService;
	private IrrigationSensorService irsensorService;

	@Autowired
	public LandPlotRestController(LandPlotsService theLandPlotsService,
			LandTimeandwateramountService theTimeandWaterAmnt,IrrigationSensorService theirsensorService) {
		landPlotsService = theLandPlotsService;
		landTimeandwateramountService = theTimeandWaterAmnt;
		irsensorService = theirsensorService;
	}

	

	// expose "/landPlots" and return list of landplots and it's details
	@GetMapping("/landPlots")
	public List<LandPlots> lstOfLandPlot() {
		return landPlotsService.lstOfLandPlot();
	}
	
	// add mapping for GET /landPlots/{landplotId}
	
		@GetMapping("/landPlots/{landplotId}")
		public LandPlots checkStatusById(@PathVariable int landplotId) {
			
			LandPlots theLandPlot = landPlotsService.checkStatusById(landplotId);
			
			if (theLandPlot == null) {
				throw new RuntimeException("LandPlot id not found - " + landplotId);
			}
			if (theLandPlot.getPlotStatus().equals("Dry")) {
				System.out.println("Call sesnor for LandPlot no"+theLandPlot.getPlotNumber());
				String url = "http://localhost:8080/api/irregsesnors/{sesnsorId}";
				updateIrrStatus(url,theLandPlot.getIrrigationSensor().getId());
				
				System.out.println("Call succcess and in progress");
			}
			if (theLandPlot.getPlotStatus().equals("IrgInPrgress")) {
				System.out.println("No Action need Irg in progress Time to complete ....");
			}
			if (theLandPlot.getPlotStatus().equals("IrgComplete")) {
				System.out.println("No Action need Irg complete succusfel....");
			}
			
			return theLandPlot;
		}

	

	// add mapping for POST /landPlots - add new landPlot

	@PostMapping("/landPlots")
	public LandPlots addlandPlot(@RequestBody LandPlots theLandPlot) {

		theLandPlot.setId(0);
        CommonLoop(theLandPlot);
		landPlotsService.AddorUpdateLandPlot(theLandPlot);

		return theLandPlot;
	}

	// add mapping for PUT /landPlots - update existing landPlot

		@PutMapping("/landPlots")
		public LandPlots updatelandPlot(@RequestBody LandPlots theLandPlot) {
			 CommonLoop(theLandPlot);
			landPlotsService.AddorUpdateLandPlot(theLandPlot); 
			 
			return theLandPlot;
		}
		
		///Helper Method
		
		public List<LandTimeandwateramount> lstOfDtlofsize() {

			return landTimeandwateramountService.lstOfLandTimeandwateramount();
		}
		
		public List<IrrigationSensor> lstOfSensor() {

			return irsensorService.lstOfSensor();
		}

	private void CommonLoop(LandPlots theLandPlot) {
		//in add
		if(theLandPlot.getId()==0){
		for(LandTimeandwateramount lstsize:lstOfDtlofsize()){
        	if(theLandPlot.getSize().equals(lstsize.getSize())){
        		theLandPlot.setLandTimeandwateramount(lstsize);	
        	}
        	
        }
        for(IrrigationSensor lstsensor:lstOfSensor()){
        	if(theLandPlot.getSize().equals(lstsensor.getSize())){
        		theLandPlot.setIrrigationSensor(lstsensor);	
        	}
        	
        }
		}else{
			//in update
			for(LandTimeandwateramount lstsize:lstOfDtlofsize()){
	        	if(theLandPlot.getLandTimeandwateramount().equals(null) ||theLandPlot.getSize().equals(lstsize.getSize())){
	        		theLandPlot.setLandTimeandwateramount(lstsize);	
	        	}
	        	
	        }
			for(IrrigationSensor lstsensor:lstOfSensor()){
				if(theLandPlot.getIrrigationSensor().equals(null) ||theLandPlot.getSize().equals(lstsensor.getSize())){
					theLandPlot.setIrrigationSensor(lstsensor);	
	        	}
	        	
	        }
		}
	}

	private void updateIrrStatus(String url, int i) {
        Map < String, String > params = new HashMap < String, String > ();
        params.put("sesnsorId", i+"");
        IrrigationSensor updatedIrrstatus = new IrrigationSensor(1);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(url, updatedIrrstatus, params);
    }

}
