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
 * 用户粉丝表
 * @author Cherry
 *
 */
@Entity
@Table(name="tb_fans")
public class Fan implements Serializable {
	@Transient
	private static final long serialVersionUID = -2740711715719117065L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fanInfoId", unique = true, nullable = false)
	private long fanInfoId;
	@Column(name = "userId")
    private long userId;
	@Column(name = "fromUserId")
    private long fromUserId;
    @Column(name = "createDate",length=20)
    private Date createDate;
    @Column(name = "messageId")
    private long messageId;
    
    
   
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	public long getId() {
		return fanInfoId;
	}
	public void setId(long id) {
		fanInfoId = id;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	public Fan(long id, long userId, long fromUserId, Date createDate,
			long messageId) {
		super();
		fanInfoId = id;
		this.userId = userId;
		this.fromUserId = fromUserId;
		this.createDate = createDate;
		this.messageId = messageId;
	}
	public Fan() {
		super();
	}
	@Override
	public String toString() {
		return "Fan [Id=" + fanInfoId + ", userId=" + userId + ", fromUserId="
				+ fromUserId + ", createDate=" + createDate + ", messageId="
				+ messageId + "]";
	}
	
	
	

	

	
	
    

}
