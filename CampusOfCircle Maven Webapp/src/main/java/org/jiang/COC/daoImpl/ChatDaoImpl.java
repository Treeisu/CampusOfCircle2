package org.jiang.COC.daoImpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.dao.ChatDao;
import org.jiang.COC.model.ChatInfo;
import org.jiang.COC.model.UserAdviceNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class ChatDaoImpl implements  ChatDao{
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	@Override
	@Transactional
	public void saveChat(ChatInfo chatInfo){
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();		
		session.save(chatInfo);
	}

	

	@Override
	@Transactional
	public void deleteChat(ChatInfo chatInfo){
		//删除一个实体
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.delete(chatInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ChatInfo> findByfromUserId(long fromUserId){
		
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from ChatInfo where fromUserId = :myfromId";
		Query query=session.createQuery(hql);
		query.setParameter("myfromId", fromUserId);
		List<ChatInfo> list=query.list();
		return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<ChatInfo> findBytoUserId(long toUserId){
		
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from ChatInfo where toUserId = :mytoId";
		Query query=session.createQuery(hql);
		query.setParameter("mytoId", toUserId);
		List<ChatInfo> list=query.list();
		return list;
	}

	@Override
	@Transactional
	public ChatInfo getChat(long Id){
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		ChatInfo chatInfo=(ChatInfo) session.get(UserAdviceNum.class, Id);		
		return chatInfo;	
	}



	
	
}
