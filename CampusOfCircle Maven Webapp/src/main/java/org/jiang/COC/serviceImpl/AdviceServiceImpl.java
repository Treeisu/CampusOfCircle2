package org.jiang.COC.serviceImpl;


import java.util.List;

import org.jiang.COC.daoImpl.AdviceDaoImpl;
import org.jiang.COC.model.UserAdviceNum;
import org.jiang.COC.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author cherry
 *
 */
@Service
public class AdviceServiceImpl implements AdviceService {
	@Autowired
	private AdviceDaoImpl adviceDaoImpl ;

	@Override
	@Transactional
	public void saveAdvice(UserAdviceNum userAdviceNum){
		// TODO Auto-generated method stub
		adviceDaoImpl.saveAdvice(userAdviceNum);
	}

	@Override
	@Transactional
	public void deleteAdvice(UserAdviceNum userAdviceNum){
		// TODO Auto-generated method stub
		adviceDaoImpl.deleteAdvice(userAdviceNum);
	}

	@Override
	@Transactional
	public UserAdviceNum getAdvice(long Id){
		// TODO Auto-generated method stub
		UserAdviceNum userAdviceNum=adviceDaoImpl.getAdvice(Id);
		return userAdviceNum;				
	}

	@Override
	@Transactional
	public List<UserAdviceNum> findByUserId(long userId){
		// TODO Auto-generated method stub
		List<UserAdviceNum> list=adviceDaoImpl.findByUserId(userId);
		return list;
		
	}

	@Override
	@Transactional
	public void update(UserAdviceNum userAdviceNum) {
		// TODO Auto-generated method stub
		adviceDaoImpl.updateAdvice(userAdviceNum);
	}




	

}
