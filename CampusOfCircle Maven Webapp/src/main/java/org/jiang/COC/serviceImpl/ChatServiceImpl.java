package org.jiang.COC.serviceImpl;


import java.util.List;


import org.jiang.COC.daoImpl.ChatDaoImpl;
import org.jiang.COC.model.ChatInfo;
import org.jiang.COC.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author cherry
 *
 */
@Service
public class ChatServiceImpl implements ChatService {
	@Autowired
	private ChatDaoImpl chatDaoImpl ;

	@Override
	@Transactional
	public void saveChat(ChatInfo chatInfo){
		// TODO Auto-generated method stub
		chatDaoImpl.saveChat(chatInfo);
	}

	@Override
	@Transactional
	public void deleteChat(ChatInfo chatInfo){
		// TODO Auto-generated method stub
		chatDaoImpl.deleteChat(chatInfo);
	}

	@Override
	@Transactional
	public ChatInfo getChat(long Id){
		// TODO Auto-generated method stub
		ChatInfo chatInfo=chatDaoImpl.getChat(Id);
		return chatInfo;				
	}

	@Override
	@Transactional
	public List<ChatInfo> findByUserId(long fromUserId){
		// TODO Auto-generated method stub
		List<ChatInfo> list=chatDaoImpl.findByfromUserId(fromUserId);
		return list;
		
	}



	

}
