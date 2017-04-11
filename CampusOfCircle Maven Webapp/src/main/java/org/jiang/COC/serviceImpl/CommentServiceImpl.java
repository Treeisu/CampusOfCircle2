package org.jiang.COC.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.jiang.COC.daoImpl.CommentDaoImpl;
import org.jiang.COC.daoImpl.UserDaoImpl;
import org.jiang.COC.model.Comment;
import org.jiang.COC.model.User;
import org.jiang.COC.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author cherry
 *
 */
@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentDaoImpl commentDaoImpl;
	@Autowired
	private UserDaoImpl userDaoImpl;
	
	@Override
	@Transactional
	public void saveComment(Comment comment) {
		// TODO Auto-generated method stub
		commentDaoImpl.saveComment(comment);
		
	}

	@Override
	@Transactional
	public List<Comment> findCommentsBywbId(long wbId){
		// TODO Auto-generated method stub
		List<Comment> list=new ArrayList<Comment>();
		list=commentDaoImpl.findBywbId(wbId);
		for( Comment comment:list){
			User user=userDaoImpl.getUserById(comment.getUserId());
			if(user !=null){
				comment.setCommentUser(user);
			}			
		}
		return list;
	}

	@Override
	@Transactional
	public void deleteComment(long commentId) {
		// TODO Auto-generated method stub
		Comment comment=commentDaoImpl.getById(commentId);
		if(comment !=null){
			commentDaoImpl.deleteComment(comment);
		}
		
	}

	@Override
	@Transactional
	public Comment getCommentBycommentId(long commentId) {
		// TODO Auto-generated method stub
		Comment comment=commentDaoImpl.getById(commentId);
		User user=userDaoImpl.getUserById(comment.getUserId());
		comment.setCommentUser(user);
		return commentDaoImpl.getById(commentId);
	}

	

}
