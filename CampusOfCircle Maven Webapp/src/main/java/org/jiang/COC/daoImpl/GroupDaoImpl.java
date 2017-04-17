package org.jiang.COC.daoImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.dao.GroupDao;
import org.jiang.COC.model.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class GroupDaoImpl implements GroupDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	@Override
	@Transactional
	public void saveGroup(Group group){
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();		
		session.save(group);
	}

	

	@Override
	@Transactional
	public void deleteGroup(Group group){
		//删除一个实体
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.delete(group);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Group> findByUserId(long userId){
		
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Group where userId = :myUserId";
		Query query=session.createQuery(hql);
		query.setParameter("myUserId", userId);
		List<Group> list=new ArrayList<Group>();
		list=query.list();
		return list;
	}

	@Override
	@Transactional
	public Group getGroup(long groupId) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		Group group=(Group) session.get(Group.class, groupId);		
		return group;	
	}

	
	
}
