package org.jiang.COC.serviceImpl;




import java.util.List;

import org.jiang.COC.daoImpl.MessageDaoImpl;
import org.jiang.COC.model.Message;
import org.jiang.COC.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author cherry
 *
 */
@Service
public class MessageServiceImpl implements MessageService {
	@Autowired
	private MessageDaoImpl messageDaoImpl ;
	@Autowired
	private CommentServiceImpl commentServiceImpl ;
	@Autowired
	private PushInfoServiceImpl pushInfoServiceImpl ;
	@Autowired
	private UserServiceImpl userServiceImpl ;

	@Override
	@Transactional
	public void saveMessage(Message message){
		// TODO Auto-generated method stub
		messageDaoImpl.saveMessage(message);
	}

	@Override
	@Transactional
	public void deleteMessage(Message message){
		// TODO Auto-generated method stub
		messageDaoImpl.deleteMessage(message);
	}

	@Override
	@Transactional
	public Message getMessage(long Id){
		// TODO Auto-generated method stub
		Message message=messageDaoImpl.getMessage(Id);
		return message;				
	}

	@Override
	@Transactional
	public List<Message> findByMyUserId(long myUserId){
		// TODO Auto-generated method stub
		List<Message> list=messageDaoImpl.findByMyUserId(myUserId);
		//设置相关信息
		for(Message m:list){
			if(m.getCommentId()!=0){
				m.setComment(commentServiceImpl.getCommentBycommentId(m.getCommentId()));
			}
			if(m.getWbId()!=0){
				m.setPush(pushInfoServiceImpl.getPushIfoBywbId(myUserId, m.getWbId()));
			}
			if(m.getFromUserId()!=0){
				m.setFromUser(userServiceImpl.getByUserId(m.getFromUserId()));
			}
			if(m.getMyUserId()!=0){
				m.setMyUser(userServiceImpl.getByUserId(m.getMyUserId()));
			}
			m.setState(1);
			messageDaoImpl.updateMessage(m);
		}
		return list;
		
	}

	@Override
	@Transactional
	public void updateMessage(Message message){
		// TODO Auto-generated method stub
		messageDaoImpl.updateMessage(message);
	}

	@Override
	@Transactional
	public Message findMessageBythree(long fromUserId, long myUserId, long kind) {
		// TODO Auto-generated method stub
		
		return messageDaoImpl.findMessageBythree(fromUserId, myUserId, kind);
	}

	@Override
	@Transactional
	public List<Message> findNEW(long myUserId, long state) {
		// TODO Auto-generated method stub
		List<Message> list=messageDaoImpl.findNEW(myUserId, state);
		if(list.size()>0){
			return list;
		}
		return null;
	}

	@Override
	@Transactional
	public Message findTurn(long fromUserId, long wbId, long kind) {
		// TODO Auto-generated method stub
		if(messageDaoImpl.findTurn(fromUserId, wbId, kind).size()>0){
			return messageDaoImpl.findTurn(fromUserId, wbId, kind).get(0);
		}
		return null;
		
	}

	@Override
	@Transactional
	public Message getMessageByattentionId(long attentionId) {
		// TODO Auto-generated method stub
		List<Message> list=messageDaoImpl.getMessageByattentionId(attentionId);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}		
	}

	@Override
	@Transactional
	public Message getMessageBypraiseId(long praiseId) {
		// TODO Auto-generated method stub
		List<Message> list=messageDaoImpl.getMessageBypraiseId(praiseId);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}	
	}

	@Override
	@Transactional
	public Message getMessageByturnId(long turnId) {
		// TODO Auto-generated method stub
		List<Message> list=messageDaoImpl.getMessageByturnId(turnId);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}	
	}

	@Override
	@Transactional
	public Message getMessageBycommentId(long commentId) {
		// TODO Auto-generated method stub
		List<Message> list=messageDaoImpl.getMessageBycommentId(commentId);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}




	

}
