package org.jiang.COC.dao;



import java.util.List;



import org.jiang.COC.model.ChatInfo;

/**
 * 
 * @author cherry
 *
 */
public interface ChatDao {
	
	public void saveChat(ChatInfo chatInfo);//保存实体
	public void deleteChat(ChatInfo chatInfo);//删除实体
	public ChatInfo getChat(long Id);
	public List<ChatInfo> findByfromUserId(long userId);
	public List<ChatInfo> findBytoUserId(long userId);
	
}
