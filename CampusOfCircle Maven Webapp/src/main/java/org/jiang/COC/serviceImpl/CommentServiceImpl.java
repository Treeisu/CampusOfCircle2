package org.jiang.COC.serviceImpl;


import java.util.List;

import org.jiang.COC.daoImpl.CommentDaoImpl;
import org.jiang.COC.daoImpl.PushInfoDaoImpl;
import org.jiang.COC.daoImpl.UserDaoImpl;
import org.jiang.COC.model.Comment;
import org.jiang.COC.model.Message;
import org.jiang.COC.model.PushInfo;
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
	@Autowired
	private PushInfoDaoImpl pushInfoDaoImpl;
	@Autowired
	private MessageServiceImpl messageServiceImpl;
	
	@Override
	@Transactional
	public void saveComment(Comment comment) {
		// TODO Auto-generated method stub
		commentDaoImpl.saveComment(comment);
		 Message m=new Message();
		 m.setKindOperation(4);//4表示评论种类操作
		 m.setCommentId(comment.getCommentId());
		 m.setDate(comment.getCommentDate());
		 m.setFromUserId(comment.getUserId());
		 m.setMyUserId(pushInfoDaoImpl.getPushIfoBywbId(comment.getWbId()).getUserId());
		 m.setWbId(pushInfoDaoImpl.getPushIfoBywbId(comment.getWbId()).getWbId());
		 System.out.println(m);
		 messageServiceImpl.saveMessage(m);
		//对微博表做更新
		PushInfo pushInfo=pushInfoDaoImpl.getPushIfoBywbId(comment.getWbId());
		pushInfo.setCommentNum(pushInfo.getCommentNum()+1);
		pushInfoDaoImpl.updatePushInfo(pushInfo);
	}

	@Override
	@Transactional
	public List<Comment> findCommentsBywbId(long wbId){
		// TODO Auto-generated method stub
		List<Comment> list=commentDaoImpl.findBywbId(wbId);
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
		long wbId=comment.getWbId();
		if(comment !=null){
			commentDaoImpl.deleteComment(comment);
			//操作表
			Message m=messageServiceImpl.getMessageBycommentId(comment.getCommentId());
			if(m!=null){messageServiceImpl.deleteMessage(m);}
			PushInfo pushInfo=pushInfoDaoImpl.getPushIfoBywbId(wbId);
			pushInfo.setCommentNum(pushInfo.getCommentNum()-1);
			pushInfoDaoImpl.updatePushInfo(pushInfo);
		}
		
	}

	@Override
	@Transactional
	public Comment getCommentBycommentId(long commentId) {
		// TODO Auto-generated method stub
		Comment comment=commentDaoImpl.getById(commentId);
		return comment;
	}

	

}
