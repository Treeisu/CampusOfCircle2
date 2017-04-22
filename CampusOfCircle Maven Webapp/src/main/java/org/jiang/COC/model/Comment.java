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
 * 评论表
 * 注册时需要填写信息
 * @author Cherry
 *
 */
@Entity
@Table(name="tb_comment")
public class Comment implements Serializable {
	@Transient
	private static final long serialVersionUID = 4000807929028846993L;
	
	
	@Transient
	private User commentUser;//显示user信息的字段，加上一个@Transient数据库则不会产生列
	@Transient
	private PushInfo belongBlog;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentId", unique = true, nullable = false)
	private long commentId;
	@Column(name = "wbId",length=20)
	private long wbId;//这个字段用来存储转发的原始Id
	@Column(name = "userId",length=20)
	private long userId;
	@Column(name = "fromCommentId",length=20)
	private long fromCommentId;
	@Column(name = "commentContent",length=500)
    private String commentContent;
    @Column(name = "commentDate",length=20)
    private Date commentDate;
    @Column(name = "state")
    private int state;
    
    
	
	public Comment(User commentUser, long commentId, long wbId, long userId,
			long fromCommentId, String commentContent, Date commentDate,
			int state) {
		super();
		this.commentUser = commentUser;
		this.commentId = commentId;
		this.wbId = wbId;
		this.userId = userId;
		this.fromCommentId = fromCommentId;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.state = state;
	}
	public Comment() {
		super();
	}
	public User getCommentUser() {
		return commentUser;
	}
	public void setCommentUser(User commentUser) {
		this.commentUser = commentUser;
	}
	public long getWbId() {
		return wbId;
	}
	public void setWbId(long wbId) {
		this.wbId = wbId;
	}
	public long getCommentId() {
		return commentId;
	}
	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getFromCommentId() {
		return fromCommentId;
	}
	public void setFromCommentId(long fromCommentId) {
		this.fromCommentId = fromCommentId;
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Comment [commentUser=" + commentUser + ", commentId="
				+ commentId + ", wbId=" + wbId + ", userId=" + userId
				+ ", fromCommentId=" + fromCommentId + ", commentContent="
				+ commentContent + ", commentDate=" + commentDate + ", state="
				+ state + "]";
	}
	
	
    
    
    
    
    

	
	
	
	
    

}
