package org.jiang.COC.daoImpl;





import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jiang.COC.dao.UserDao;
import org.jiang.COC.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	
	/**
	 * 保存单个User对象
	 */
	@Override
	@Transactional
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		session.save(user);
		/*if(session!=null){
			session.close();
		}*/
	}
	/**
	 * 根据手机号查询User
	 */
	@SuppressWarnings("unchecked")
	@Override	
	public List<User> findByPhone(String userPhone) {
		// TODO Auto-generated method stub
		session=sessionFactory.openSession();
		String hql="from User where userPhone = :myphone";
//		String hql="from User";
		Query query=session.createQuery(hql);
		query.setParameter("myphone", userPhone);
		List<User> list=new ArrayList<User>();
		list=query.list();

		/*if(session!=null){
			session.close();
		}*/
		return list;
	}

}
