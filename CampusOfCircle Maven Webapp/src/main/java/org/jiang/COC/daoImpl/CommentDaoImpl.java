package org.jiang.COC.daoImpl;


import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jiang.COC.dao.CommentDao;
import org.jiang.COC.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
@Repository
public class CommentDaoImpl implements CommentDao {
	@Autowired
	private SessionFactory sessionFactory;
	private Session session;
	@Override
	@Transactional
	public void saveComment(Comment comment) {
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();		
		session.save(comment);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Comment> findBywbId(long wbID) {
		//根据一个微博ID查询其相关评论
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		String hql="from Comment where wbId = :mywbId order by commentDate desc";
		Query query=session.createQuery(hql);
		query.setParameter("mywbId", wbID);
		List<Comment> list=new ArrayList<Comment>();
		list=query.list();
		return list;
	}

	@Override
	@Transactional
	public void deleteComment(Comment comment) {
		//删除一个实体
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.delete(comment);
	}

	@Override
	@Transactional
	public Comment getById(long commentId) {
		//根据主键去查询一条评论
		// TODO Auto-generated method stub
		session=sessionFactory.getCurrentSession();
		session.get(Comment.class,commentId);
		return (Comment) session.get(Comment.class,commentId);
	}


}
