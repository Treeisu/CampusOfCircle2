package org.jiang.COC.serviceImpl;


import java.util.List;

import org.jiang.COC.daoImpl.FanDaoImpl;
import org.jiang.COC.model.Fan;
import org.jiang.COC.service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author cherry
 *
 */
@Service
public class FanServiceImpl implements FanService {
	@Autowired
	private FanDaoImpl fanDaoImpl;

	@Override
	@Transactional
	public void saveFan(Fan fan) {
		// TODO Auto-generated method stub
		fanDaoImpl.saveFans(fan);
	}

	@Override
	@Transactional
	public void deleteFan(Fan fan) {
		// TODO Auto-generated method stub
		fanDaoImpl.deleteFans(fan);
	}

	@Override
	@Transactional
	public Fan getFanById(long Id) {
		// TODO Auto-generated method stub
		Fan fan=fanDaoImpl.getFans(Id);
		return fan;
	}

	@Override
	@Transactional
	public List<Fan> findFanByUserId(long userId) {
		// TODO Auto-generated method stub
		List<Fan> list=fanDaoImpl.findByUserId(userId);
		return list;
	}

	

	
	
	

	

}
