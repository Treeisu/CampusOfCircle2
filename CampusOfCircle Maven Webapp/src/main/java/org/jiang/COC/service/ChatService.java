package org.jiang.COC.service;

import java.util.List;







import org.jiang.COC.model.ChatInfo;





/**
 * 
 * @author cherry
 *
 */
public interface ChatService {

	public void saveChat(ChatInfo chatInfo);//保存实体
	public void deleteChat(ChatInfo chatInfo);//删除实体
	public ChatInfo getChat(long Id);
	public List<ChatInfo> findByUserId(long userId);

}
