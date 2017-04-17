package org.jiang.COC.daoImpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.dao.TurnDao;
import org.jiang.COC.model.TurnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class TurnDaoImpl implements TurnDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	@Override
	@Transactional
	public void saveTurn(TurnInfo turnInfo) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();		
		session.save(turnInfo);
	}

	@Override
	@Transactional
	public void deleteTurn(TurnInfo turnInfo) {
		//删除一个实体
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.delete(turnInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<TurnInfo> findBynowWbId(long nowWbId) {
		
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from TurnInfo where nowWbId = :mynowWbId";
		Query query=session.createQuery(hql);
		query.setParameter("mynowWbId", nowWbId);
		List<TurnInfo> turnInfos=query.list();
		return turnInfos;
	}


}
