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
		return messageDaoImpl.findNEW(myUserId, state);
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




	

}
