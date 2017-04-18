package org.jiang.COC.daoImpl;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.dao.AdviceDao;
import org.jiang.COC.model.UserAdviceNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class AdviceDaoImpl implements  AdviceDao{
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	@Override
	@Transactional
	public void saveAdvice(UserAdviceNum adviceNum){
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();		
		session.save(adviceNum);
	}

	

	@Override
	@Transactional
	public void deleteAdvice(UserAdviceNum userAdviceNum){
		//删除一个实体
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.delete(userAdviceNum);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<UserAdviceNum> findByUserId(long userId){
		
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from UserAdviceNum where userId = :myUserId";
		Query query=session.createQuery(hql);
		query.setParameter("myUserId", userId);
		List<UserAdviceNum> list=query.list();
		return list;
	}

	@Override
	@Transactional
	public UserAdviceNum getAdvice(long Id) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		UserAdviceNum userAdviceNum=(UserAdviceNum) session.get(UserAdviceNum.class, Id);		
		return userAdviceNum;	
	}



	@Override
	@Transactional
	public void updateAdvice(UserAdviceNum userAdviceNum) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.update(userAdviceNum);
	}





	
	
}
