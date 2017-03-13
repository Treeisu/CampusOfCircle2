package org.jiang.COC.daoImpl;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.dao.UserDao;
import org.jiang.COC.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	/**
	 * 保存单个User对象
	 */
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		session.save(user);
		session.close();
	}
	/**
	 * 根据手机号查询User
	 */
	@Override
	public User findByPhone(String userPhone) {
		// TODO Auto-generated method stub
		String queryString="from User and userPhone=:myphone";
		Query query=session.createQuery(queryString);
		query.setParameter("myphone", userPhone);
		User result=new User();
		result=(User) query.uniqueResult();
		session.close();
		return result;
	}

}
