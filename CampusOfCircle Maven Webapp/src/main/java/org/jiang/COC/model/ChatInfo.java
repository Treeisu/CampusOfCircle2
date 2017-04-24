package org.jiang.COC.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 聊天表
 * @author Cherry
 *
 */
@Entity
@Table(name="tb_chatInfo")
public class ChatInfo implements Serializable {
	@Transient
	private static final long serialVersionUID = 5840504156249572787L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private long Id;
	@Column(name = "userId")
    private long userId;
	@Column(name = "fromUserId")
    private long fromUserId;
	@Column(name = "toUserId")
    private long toUserId;
	@Column(name = "chatContent",length=500)
    private String chatContent;
    @Column(name = "createDate",length=20)
    private Date createDate;
    @Column(name = "messageId")
    private long messageId;
	
    
    
    
    public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(long fromUserId) {
		this.fromUserId = fromUserId;
	}
	public long getToUserId() {
		return toUserId;
	}
	public void setToUserId(long toUserId) {
		this.toUserId = toUserId;
	}
	public String getChatContent() {
		return chatContent;
	}
	public void setChatContent(String chatContent) {
		this.chatContent = chatContent;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	
	public ChatInfo(long id, long userId, long fromUserId, long toUserId,
			String chatContent, Date createDate, long messageId) {
		super();
		Id = id;
		this.userId = userId;
		this.fromUserId = fromUserId;
		this.toUserId = toUserId;
		this.chatContent = chatContent;
		this.createDate = createDate;
		this.messageId = messageId;
	}
	public ChatInfo() {
		super();
	}
	@Override
	public String toString() {
		return "ChatInfo [Id=" + Id + ", userId=" + userId + ", fromUserId="
				+ fromUserId + ", toUserId=" + toUserId + ", chatContent="
				+ chatContent + ", createDate=" + createDate + ", messageId="
				+ messageId + "]";
	}
	
	
    
    
   
	

	

	
	
    

}
