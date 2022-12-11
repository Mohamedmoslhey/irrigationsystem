package com.nsag.irrigationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nsag.irrigationsystem.dao.LandPlotsDao;
import com.nsag.irrigationsystem.dao.LandTimeandwateramountDao;
import com.nsag.irrigationsystem.entity.LandPlots;
import com.nsag.irrigationsystem.entity.LandTimeandwateramount;

@Service
public class LandTimeandwateramountServiceImpl implements LandTimeandwateramountService {

	private LandTimeandwateramountDao landTimeandwateramountDao;
	
	@Autowired
	public LandTimeandwateramountServiceImpl(LandTimeandwateramountDao theTimeandwateramountDao) {
		landTimeandwateramountDao = theTimeandwateramountDao;
	}
	
	

	@Override
	@Transactional
	public List<LandTimeandwateramount> lstOfLandTimeandwateramount() {
		return landTimeandwateramountDao.lstOfLandTimeandwateramount();
	}

	@Override
	@Transactional
	public void AddorUpdateTimeSltAndWatrAmnt(LandTimeandwateramount theTimeandwateramount) {
		landTimeandwateramountDao.AddorUpdateTimeSltAndWatrAmnt(theTimeandwateramount);
		
	}


}






