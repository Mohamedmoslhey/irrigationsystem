package com.nsag.irrigationsystem.service;

import java.util.List;

import com.nsag.irrigationsystem.entity.LandTimeandwateramount;

public interface LandTimeandwateramountService {

	public List<LandTimeandwateramount> lstOfLandTimeandwateramount();
	public void AddorUpdateTimeSltAndWatrAmnt(LandTimeandwateramount theLandPlot);
	
	
}
