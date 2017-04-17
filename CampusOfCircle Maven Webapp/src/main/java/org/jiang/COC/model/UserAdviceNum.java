package org.jiang.COC.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 用户信息通知表
 * 注册时需要填写信息
 * @author Cherry
 *
 */
@Entity
@Table(name="tb_userAdviceNum")
public class UserAdviceNum implements Serializable {
	@Transient
	private static final long serialVersionUID = 7078899014351927908L;
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private long Id;
	@Column(name = "userId", unique = true, nullable = false)
	private long userId;
	@Column(name = "userNickName",length=20)
    private String userNickName;
	/**
	 * 粉丝、关注、动态数
	 */
	@Column(name = "attentionNum",length=20)
	private	long attentionNum;
	@Column(name = "fansNum",length=20)
	private	long fansNum;
	@Column(name = "wbNum",length=20)
	private	long wbNum;
    /**
     * 未读信息数量
     */
	@Column(name = "chatNum",length=20)
	private	long chatNum;//未读聊天
	@Column(name = "praiseNum",length=20)
	private	long praiseNum;//点赞通知
	@Column(name = "commentNum",length=20)
	private	long commentNum;//评论通知
	@Column(name = "turnNum",length=20)
	private	long turnNum;//转发通知
	@Column(name = "addNum",length=20)
	private	long addNum;//新粉丝通知
	@Column(name = "sumNum",length=20)
	private	long sumNum;//总通知
	
	
	
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
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public long getAttentionNum() {
		return attentionNum;
	}
	public void setAttentionNum(long attentionNum) {
		this.attentionNum = attentionNum;
	}
	public long getFansNum() {
		return fansNum;
	}
	public void setFansNum(long fansNum) {
		this.fansNum = fansNum;
	}
	public long getWbNum() {
		return wbNum;
	}
	public void setWbNum(long wbNum) {
		this.wbNum = wbNum;
	}
	public long getChatNum() {
		return chatNum;
	}
	public void setChatNum(long chatNum) {
		this.chatNum = chatNum;
	}
	public long getPraiseNum() {
		return praiseNum;
	}
	public void setPraiseNum(long praiseNum) {
		this.praiseNum = praiseNum;
	}
	public long getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(long commentNum) {
		this.commentNum = commentNum;
	}
	public long getTurnNum() {
		return turnNum;
	}
	public void setTurnNum(long turnNum) {
		this.turnNum = turnNum;
	}
	public long getAddNum() {
		return addNum;
	}
	public void setAddNum(long addNum) {
		this.addNum = addNum;
	}
	public long getSumNum() {
		return sumNum;
	}
	public void setSumNum(long sumNum) {
		this.sumNum = sumNum;
	}
	
	public UserAdviceNum(long id, long userId, String userNickName,
			long attentionNum, long fansNum, long wbNum, long chatNum,
			long praiseNum, long commentNum, long turnNum, long addNum,
			long sumNum) {
		super();
		Id = id;
		this.userId = userId;
		this.userNickName = userNickName;
		this.attentionNum = attentionNum;
		this.fansNum = fansNum;
		this.wbNum = wbNum;
		this.chatNum = chatNum;
		this.praiseNum = praiseNum;
		this.commentNum = commentNum;
		this.turnNum = turnNum;
		this.addNum = addNum;
		this.sumNum = sumNum;
	}
	public UserAdviceNum() {
		super();
	}
	@Override
	public String toString() {
		return "UserAdviceNum [Id=" + Id + ", userId=" + userId
				+ ", userNickName=" + userNickName + ", attentionNum="
				+ attentionNum + ", fansNum=" + fansNum + ", wbNum=" + wbNum
				+ ", chatNum=" + chatNum + ", praiseNum=" + praiseNum
				+ ", commentNum=" + commentNum + ", turnNum=" + turnNum
				+ ", addNum=" + addNum + ", sumNum=" + sumNum + "]";
	}

	
    
	
	
	

}
