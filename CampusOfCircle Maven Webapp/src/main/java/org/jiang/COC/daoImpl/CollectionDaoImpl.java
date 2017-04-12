package org.jiang.COC.daoImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.dao.CollectionDao;
import org.jiang.COC.model.CollectionInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class CollectionDaoImpl implements CollectionDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	@Override
	@Transactional
	public void saveCollection(CollectionInfo collectionInfo){
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();		
		session.save(collectionInfo);
	}

	

	@Override
	@Transactional
	public void deleteCollection(CollectionInfo collectionInfo){
		//删除一个实体
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.delete(collectionInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CollectionInfo> findBywbIdAnduserId(long userId,long wbId){
		
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from CollectionInfo where userId = :myUserId and wbId=:myWbId";
		Query query=session.createQuery(hql);
		query.setParameter("myUserId", userId);
		query.setParameter("myWbId", wbId);
		List<CollectionInfo> collectionInfos=new ArrayList<CollectionInfo>();
		collectionInfos=query.list();
		return collectionInfos;
	}



	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<CollectionInfo> findBywbId(long wbId) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from CollectionInfo where wbId=:myWbId";
		Query query=session.createQuery(hql);
		query.setParameter("myWbId", wbId);
		List<CollectionInfo> collectionInfos=new ArrayList<CollectionInfo>();
		collectionInfos=query.list();
		return collectionInfos;
	}


}
