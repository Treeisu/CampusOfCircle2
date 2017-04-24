package org.jiang.COC.daoImpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.dao.MessageDao;
import org.jiang.COC.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class MessageDaoImpl implements  MessageDao{
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	
	@Override
	@Transactional
	public void saveMessage(Message message){
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();		
		session.save(message);
	}

	

	@Override
	@Transactional
	public void deleteMessage(Message message){
		//删除一个实体
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.delete(message);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Message> findByMyUserId(long myUserId){
		
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Message where myUserId = :myUserId order by date desc";
		Query query=session.createQuery(hql);
		query.setParameter("myUserId", myUserId);
		List<Message> list=query.list();
		return list;
	}

	@Override
	@Transactional
	public Message getMessage(long Id){
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		Message message=(Message) session.get(Message.class, Id);		
		return message;	
	}



	@Override
	@Transactional
	public void updateMessage(Message message){
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.update(message);
	}



	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Message findMessageBythree(long fromUserId, long myUserId, long kind) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Message where myUserId = :myUserId and fromUserId=:fromUserId and kindOperation=:kindOperation";
		Query query=session.createQuery(hql);
		query.setParameter("myUserId", myUserId);
		query.setParameter("fromUserId", fromUserId);
		query.setParameter("kindOperation", kind);
		List<Message> list=query.list();
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
		
	}



	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Message> findNEW(long myUserId, long state) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Message where myUserId = :myUserId and state=:state";
		Query query=session.createQuery(hql);
		query.setParameter("myUserId", myUserId);
		query.setParameter("state", state);
		List<Message> list=query.list();
		return list;
	}



	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Message> findTurn(long fromUserId,  long wbId,long kind) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Message where kindOperation = :kindOperation and wbId=:wbId and fromUserId=:fromUserId";
		Query query=session.createQuery(hql);
		query.setParameter("kindOperation", kind);
		query.setParameter("wbId", wbId);
		query.setParameter("fromUserId", fromUserId);
		List<Message> list=query.list();
		return list;
	}



	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Message> getMessageByattentionId(long attentionId) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Message where attentionId = :myattentionId";
		Query query=session.createQuery(hql);
		query.setParameter("myattentionId", attentionId);	
		List<Message> list=query.list();
		return list;
	}



	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Message> getMessageBypraiseId(long praiseId) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Message where praiseId = :mypraiseId";
		Query query=session.createQuery(hql);
		query.setParameter("mypraiseId", praiseId);	
		List<Message> list=query.list();
		return list;
	}



	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Message> getMessageByturnId(long turnId) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Message where turnId = :myturnId";
		Query query=session.createQuery(hql);
		query.setParameter("myturnId", turnId);	
		List<Message> list=query.list();
		return list;
	}



	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Message> getMessageBycommentId(long commentId) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Message where commentId = :mycommentId";
		Query query=session.createQuery(hql);
		query.setParameter("mycommentId", commentId);	
		List<Message> list=query.list();
		return list;
	}



	





	
	
}
