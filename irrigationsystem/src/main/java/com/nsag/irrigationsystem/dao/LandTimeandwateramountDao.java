package com.nsag.irrigationsystem.dao;

import java.util.List;

import com.nsag.irrigationsystem.entity.LandTimeandwateramount;



public interface LandTimeandwateramountDao {
	
    public List<LandTimeandwateramount> lstOfLandTimeandwateramount();

	public void AddorUpdateTimeSltAndWatrAmnt(LandTimeandwateramount theTimeAndWaterAmnt);
	
}
