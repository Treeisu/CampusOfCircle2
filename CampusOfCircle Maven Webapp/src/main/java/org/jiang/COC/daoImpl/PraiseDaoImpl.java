package org.jiang.COC.daoImpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.dao.PraiseDao;
import org.jiang.COC.model.PraiseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class PraiseDaoImpl implements PraiseDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	@Override
	@Transactional
	public void savePraise(PraiseInfo praiseInfo) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();		
		session.save(praiseInfo);
	}

	

	@Override
	@Transactional
	public void deletePraise(PraiseInfo praiseInfo) {
		//删除一个实体
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.delete(praiseInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PraiseInfo> findBywbIdAnduserId(long userId,long wbId) {
		
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from PraiseInfo where userId = :myUserId and wbId=:myWbId";
		Query query=session.createQuery(hql);
		query.setParameter("myUserId", userId);
		query.setParameter("myWbId", wbId);
		List<PraiseInfo> praiseInfos=query.list();
		return praiseInfos;
	}



	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<PraiseInfo> findBywbId(long wbId) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from PraiseInfo where wbId=:myWbId";
		Query query=session.createQuery(hql);
		query.setParameter("myWbId", wbId);
		List<PraiseInfo> praiseInfos=query.list();
		return praiseInfos;
	}


}
