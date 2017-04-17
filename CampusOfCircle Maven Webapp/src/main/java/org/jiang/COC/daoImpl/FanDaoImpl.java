package org.jiang.COC.daoImpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.dao.FanDao;
import org.jiang.COC.model.Fan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class FanDaoImpl implements FanDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	@Override
	@Transactional
	public void saveFans(Fan fan){
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();		
		session.save(fan);
	}

	

	@Override
	@Transactional
	public void deleteFans(Fan fan){
		//删除一个实体
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.delete(fan);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Fan> findByUserId(long userId){
		
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Fans where userId = :myUserId";
		Query query=session.createQuery(hql);
		query.setParameter("myUserId", userId);
		List<Fan> list=query.list();
		return list;
	}

	@Override
	@Transactional
	public Fan getFans(long Id) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		Fan fan=(Fan) session.get(Fan.class, Id);		
		return fan;	
	}



	

	
	
}
