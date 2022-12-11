package com.nsag.irrigationsystem.service;

import java.util.List;

import com.nsag.irrigationsystem.entity.LandPlots;

public interface LandPlotsService {

	public LandPlots checkStatusById(int theId);
	public List<LandPlots> lstOfLandPlot();
	public void AddorUpdateLandPlot(LandPlots theLandPlot);
	
	
}
