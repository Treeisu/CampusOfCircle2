package org.jiang.COC.daoImpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.dao.PushInfoDao;
import org.jiang.COC.model.PushInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class PushInfoDaoImpl implements PushInfoDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	@Override
	@Transactional
	public void savePushInfo(PushInfo pushInfo) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.save(pushInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PushInfo> findByuserIds(List<Long> userIds) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from PushInfo where userId in(:myUserIds) order by wbPushDate desc";
		Query query=session.createQuery(hql);
		query.setParameterList("myUserIds", userIds);
		List<PushInfo> list=query.list();
		return list;
	}

	@Override
	@Transactional
	public void deletePushInfo(PushInfo pushInfo) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.delete(pushInfo);
	}

	@Override
	@Transactional
	public PushInfo getPushIfoBywbId(long wbId) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.get(PushInfo.class,wbId);
		return (PushInfo) session.get(PushInfo.class,wbId);
	}

	@Override
	@Transactional
	public void updatePushInfo(PushInfo pushInfo) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.update(pushInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PushInfo> findByuserId(long userId) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from PushInfo where userId =:myUserId order by wbPushDate desc";
		Query query=session.createQuery(hql);
		query.setParameter("myUserId", userId);
		List<PushInfo> list=query.list();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PushInfo> getPushIfoBywbIds(List<Long> list) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from PushInfo where wbId in(:mywbIds) order by wbPushDate desc";
		Query query=session.createQuery(hql);
		query.setParameterList("mywbIds", list);
		List<PushInfo> wblist=query.list();
		return wblist;
	}
	

	

}
