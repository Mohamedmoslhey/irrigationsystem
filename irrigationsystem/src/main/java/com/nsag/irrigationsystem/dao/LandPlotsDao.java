package com.nsag.irrigationsystem.dao;

import java.util.List;


import com.nsag.irrigationsystem.entity.LandPlots;



public interface LandPlotsDao {
	
    public List<LandPlots> lstOfLandPlot();
    public LandPlots checkStatusById(int theId);
	public void AddorUpdateLandPlot(LandPlots theLandPlot);
	
	
}
