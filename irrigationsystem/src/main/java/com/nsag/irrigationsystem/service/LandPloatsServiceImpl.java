package com.nsag.irrigationsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nsag.irrigationsystem.dao.LandPlotsDao;
import com.nsag.irrigationsystem.dao.LandTimeandwateramountDao;
import com.nsag.irrigationsystem.entity.LandPlots;

@Service
public class LandPloatsServiceImpl implements LandPlotsService {

	private LandPlotsDao landPlotsDao;
	
    @Autowired
	public LandPloatsServiceImpl(LandPlotsDao thelandPlotsDao) {
		landPlotsDao = thelandPlotsDao;
	}
	
    @Override
    @Transactional
	public LandPlots checkStatusById(int theId) {
		// TODO Auto-generated method stub
		return landPlotsDao.checkStatusById(theId);
	}
    
	@Override
	@Transactional
	public List<LandPlots> lstOfLandPlot() {
		return landPlotsDao.lstOfLandPlot();
	}

	@Override
	@Transactional
	public void AddorUpdateLandPlot(LandPlots theLandPlot) {
		landPlotsDao.AddorUpdateLandPlot(theLandPlot);
		
	}

	

}






