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
 * 
 * @author Cherry
 *
 */
@Entity
@Table(name="tb_Message")
public class Message implements Serializable {
	@Transient
	private static final long serialVersionUID = 7078899014351927908L;
	@Transient
	private PushInfo push;
	@Transient
	private Comment comment;
	@Transient
	private User fromUser;
	@Transient
	private User myUser;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private long Id;
	@Column(name = "fromUserId", unique = true, nullable = false)
	private long fromUserId;
	@Column(name = "wbId",length=20)
	private long wbId;
	@Column(name = "commentId",length=20)
	private long commentId;
	@Column(name = "praiseId",length=20)
	private long praiseId;
	@Column(name = "turnId",length=20)
	private long turnId;
	@Column(name = "myUserId",length=20)
	private long myUserId;
	@Column(name = "kindOperation",length=20)
	private long kindOperation;//做了什么操作；新粉丝，点赞，转发，评论等四种操作；1、2、3、4
	@Column(name = "state",length=20)
	private long state;//操作状态
	@Column(name = "date")
	private Date date;//操作状态
	
	
	
	
	public User getMyUser() {
		return myUser;
	}
	public void setMyUser(User myUser) {
		this.myUser = myUser;
	}
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(long fromUserId) {
		this.fromUserId = fromUserId;
	}
	public long getMyUserId() {
		return myUserId;
	}
	public void setMyUserId(long myUserId) {
		this.myUserId = myUserId;
	}
	public long getState() {
		return state;
	}
	public void setState(long state) {
		this.state = state;
	}
	public User getFromUser() {
		return fromUser;
	}
	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
	}
	public PushInfo getPush() {
		return push;
	}
	public void setPush(PushInfo push) {
		this.push = push;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public long getWbId() {
		return wbId;
	}
	public void setWbId(long wbId) {
		this.wbId = wbId;
	}
	
	public long getKindOperation() {
		return kindOperation;
	}
	public void setKindOperation(long kindOperation) {
		this.kindOperation = kindOperation;
	}

	public Message(PushInfo push, Comment comment, User fromUser, long id,
			long fromUserId, long wbId, long myUserId, long kindOperation,
			long state) {
		super();
		this.push = push;
		this.comment = comment;
		this.fromUser = fromUser;
		Id = id;
		this.fromUserId = fromUserId;
		this.wbId = wbId;
		this.myUserId = myUserId;
		this.kindOperation = kindOperation;
		this.state = state;
	}
	public Message() {
		super();
	}
	@Override
	public String toString() {
		return "Message [push=" + push + ", comment=" + comment + ", fromUser="
				+ fromUser + ", Id=" + Id + ", fromUserId=" + fromUserId
				+ ", wbId=" + wbId + ", myUserId=" + myUserId
				+ ", kindOperation=" + kindOperation + ", state=" + state + "]";
	}

	
   
	
	
	
	

	
    
	
	
	

}
