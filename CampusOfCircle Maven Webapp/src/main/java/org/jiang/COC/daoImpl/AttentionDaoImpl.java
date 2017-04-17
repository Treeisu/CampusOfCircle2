package org.jiang.COC.daoImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.dao.AttentionDao;
import org.jiang.COC.model.Attention;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AttentionDaoImpl implements AttentionDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	@Override
	@Transactional
	public void saveAttention(Attention attention){
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();		
		session.save(attention);
	}

	

	@Override
	@Transactional
	public void deleteAttention(Attention attention){
		//删除一个实体
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.delete(attention);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Attention> findByUserId(long userId){
		
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Attention where userId = :myUserId";
		Query query=session.createQuery(hql);
		query.setParameter("myUserId", userId);
		List<Attention> list=new ArrayList<Attention>();
		list=query.list();
		return list;
	}

	@Override
	@Transactional
	public Attention getAttention(long Id) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		Attention attention=(Attention) session.get(Attention.class, Id);		
		return attention;	
	}



	@SuppressWarnings("unchecked")
	@Override
	public List<Attention> findByGroupId(long groupId) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Attention where groupId = :myGroupId";
		Query query=session.createQuery(hql);
		query.setParameter("myGroupId", groupId);
		List<Attention> list=new ArrayList<Attention>();
		list=query.list();
		return list;
	}

	
	
}
