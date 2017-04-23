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
	/**
     * 未读信息数量
     */
	@Transient
	private	long sumNum;
	@Transient
	private	long chatNum;
	
	
	
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
	
	
	public long getSumNum() {
		return sumNum;
	}
	public void setSumNum(long sumNum) {
		this.sumNum = sumNum;
	}
	public long getChatNum() {
		return chatNum;
	}
	public void setChatNum(long chatNum) {
		this.chatNum = chatNum;
	}
	
	public UserAdviceNum(long sumNum, long chatNum, long id, long userId,
			String userNickName, long attentionNum, long fansNum, long wbNum) {
		super();
		this.sumNum = sumNum;
		this.chatNum = chatNum;
		Id = id;
		this.userId = userId;
		this.userNickName = userNickName;
		this.attentionNum = attentionNum;
		this.fansNum = fansNum;
		this.wbNum = wbNum;
	}
	public UserAdviceNum() {
		super();
	}
	@Override
	public String toString() {
		return "UserAdviceNum [sumNum=" + sumNum + ", chatNum=" + chatNum
				+ ", Id=" + Id + ", userId=" + userId + ", userNickName="
				+ userNickName + ", attentionNum=" + attentionNum
				+ ", fansNum=" + fansNum + ", wbNum=" + wbNum + "]";
	}


	
    
	
	
	

}
