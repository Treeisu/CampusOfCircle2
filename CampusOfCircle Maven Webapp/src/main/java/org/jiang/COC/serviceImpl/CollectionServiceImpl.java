package org.jiang.COC.serviceImpl;


import java.util.List;

import org.jiang.COC.daoImpl.CollectionDaoImpl;
import org.jiang.COC.daoImpl.PushInfoDaoImpl;
import org.jiang.COC.model.CollectionInfo;
import org.jiang.COC.model.PushInfo;
import org.jiang.COC.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author cherry
 *
 */
@Service
public class CollectionServiceImpl implements CollectionService {
	@Autowired
	private CollectionDaoImpl collectionDaoImpl;
	@Autowired
	private PushInfoDaoImpl pushInfoDaoImpl;
	
	@Override
	@Transactional
	public void saveCollection(CollectionInfo collectionInfo){
		// TODO Auto-generated method stub
		long wbId=collectionInfo.getWbId();
		collectionDaoImpl.saveCollection(collectionInfo);		
		//数量+1
		PushInfo pushInfo=pushInfoDaoImpl.getPushIfoBywbId(wbId);
		pushInfo.setCollectionNum(pushInfo.getCollectionNum()+1);
		pushInfoDaoImpl.updatePushInfo(pushInfo);
	}

	@Override
	@Transactional
	public List<CollectionInfo> findBywbIdAnduserId(long userId,long wbId){
		// TODO Auto-generated method stub
		List<CollectionInfo> list=collectionDaoImpl.findBywbIdAnduserId(userId, wbId);		
		return list;
	}


	@Override
	@Transactional
	public void deleteCollection(long userId,long wbId){
		// TODO Auto-generated method stub
		List<CollectionInfo> list=collectionDaoImpl.findBywbIdAnduserId(userId, wbId);
		for(CollectionInfo collectionInfo:list){
			collectionDaoImpl.deleteCollection(collectionInfo);
			//数量-1
			PushInfo pushInfo=pushInfoDaoImpl.getPushIfoBywbId(wbId);
			pushInfo.setCollectionNum(pushInfo.getCollectionNum()-1);
			pushInfoDaoImpl.updatePushInfo(pushInfo);
		}
	}

	@Override
	@Transactional
	public List<Long> findwbIdByuserId(long userId) {
		// TODO Auto-generated method stub
		return collectionDaoImpl.findByuserId(userId);
	}

	

}
