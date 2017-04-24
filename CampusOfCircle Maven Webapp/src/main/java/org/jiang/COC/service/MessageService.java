package org.jiang.COC.service;








import java.util.List;

import org.jiang.COC.model.Message;





/**
 * 
 * @author cherry
 *
 */
public interface MessageService {

	public void saveMessage(Message message);//保存实体
	public void deleteMessage(Message message);//删除实体
	public void updateMessage(Message message);
	public Message getMessage(long Id);
	public List<Message> findByMyUserId(long myUserId);
	public Message findMessageBythree(long fromUserId,long myUserId,long kind);
	public List<Message> findNEW(long myUserId,long state);
	public Message findTurn(long fromUserId,long wbId,long kind);
	public Message getMessageByattentionId(long attentionId);
	public Message getMessageBypraiseId(long praiseId);
	public Message getMessageByturnId(long turnId);
	public Message getMessageBycommentId(long commentId);

}
