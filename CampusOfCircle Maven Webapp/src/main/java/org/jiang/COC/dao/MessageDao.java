package org.jiang.COC.dao;








import java.util.List;

import org.jiang.COC.model.Message;

/**
 * 
 * @author cherry
 *
 */
public interface MessageDao {
	
	public void saveMessage(Message message);//保存实体
	public void deleteMessage(Message message);//删除实体
	public void updateMessage(Message message);//删除实体
	public Message getMessage(long Id);
	public Message findMessageBythree(long fromUserId,long myUserId,long kind);
	public List<Message> findByMyUserId(long myUserId);
	public List<Message> findNEW(long myUserId,long state);
	public List<Message> findTurn(long fromUserId,long kind,long wbId);
	public List<Message> getMessageByattentionId(long attentionId);
	public List<Message> getMessageBypraiseId(long praiseId);
	public List<Message> getMessageByturnId(long turnId);
	public List<Message> getMessageBycommentId(long commentId);
	
}
