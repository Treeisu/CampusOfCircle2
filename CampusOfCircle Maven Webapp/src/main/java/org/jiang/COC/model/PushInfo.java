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
 * 用户注信息表
 * 注册时需要填写信息
 * @author Cherry
 *
 */
@Entity
@Table(name="tb_pushInfo")
public class PushInfo implements Serializable {
	@Transient
	private static final long serialVersionUID = -708207912208929312L;
	

	@Transient
	private PushInfo initPushInfo;//用来给业务层处理转发的原信息，加上一个@Transient数据库则不会产生列
	@Transient
	private User user;//显示user信息的字段，加上一个@Transient数据库则不会产生列
	
	/**
	 * 状态字段（查询pushinfo表的时候，返回实体，然后根据登录的用户信息进行设置）
	 */
	@Transient
	private int praiseState;
	@Transient
	private int collectionState;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "wbId", unique = true, nullable = false)
	private long wbId;
	@Column(name = "wbAuthorId",length=20)
	private long wbAuthorId;//这个字段用来存储转发的原始Id
	@Column(name = "userId",length=20)
	private long userId;
	@Column(name = "userNickName",length=20)
    private String userNickName;
	@Column(name = "wbImage",length=300)
    private String wbImage;
	@Column(name = "wbTextContent",length=500)
    private String wbTextContent;
    @Column(name = "wbPushDate",length=20)
    private Date wbPushDate;
    @Column(name = "praiseNum",length=20)
	private	long praiseNum;
    @Column(name = "commentNum",length=20)
	private	long commentNum;
    @Column(name = "turnNum",length=20)
	private	long turnNum;
    @Column(name = "collectionNum",length=20)
	private	long collectionNum;
    
    
    
    public int getPraiseState() {
		return praiseState;
	}
	public void setPraiseState(int praiseState) {
		this.praiseState = praiseState;
	}
	public int getCollectionState() {
		return collectionState;
	}
	public void setCollectionState(int collectionState) {
		this.collectionState = collectionState;
	}
	public Long getCollectionNum() {
		return collectionNum;
	}
	public void setCollectionNum(long collectionNum) {
		this.collectionNum = collectionNum;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public PushInfo getInitPushInfo() {
		return initPushInfo;
	}
	public void setInitPushInfo(PushInfo initPushInfo) {
		this.initPushInfo = initPushInfo;
	}
	public long getWbId() {
		return wbId;
	}
	public void setWbId(long wbId) {
		this.wbId = wbId;
	}
	public long getWbAuthorId() {
		return wbAuthorId;
	}
	public void setWbAuthorId(long wbAuthorId) {
		this.wbAuthorId = wbAuthorId;
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
	public String getWbImage() {
		return wbImage;
	}
	public void setWbImage(String wbImage) {
		this.wbImage = wbImage;
	}
	public String getWbTextContent() {
		return wbTextContent;
	}
	public void setWbTextContent(String wbTextContent) {
		this.wbTextContent = wbTextContent;
	}
	public Date getWbPushDate() {
		return wbPushDate;
	}
	public void setWbPushDate(Date wbPushDate) {
		this.wbPushDate = wbPushDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	public PushInfo(PushInfo initPushInfo, User user, int praiseState,
			int collectionState, long wbId, long wbAuthorId, long userId,
			String userNickName, String wbImage, String wbTextContent,
			Date wbPushDate, long praiseNum, long commentNum, long turnNum,
			long collectionNum) {
		super();
		this.initPushInfo = initPushInfo;
		this.user = user;
		this.praiseState = praiseState;
		this.collectionState = collectionState;
		this.wbId = wbId;
		this.wbAuthorId = wbAuthorId;
		this.userId = userId;
		this.userNickName = userNickName;
		this.wbImage = wbImage;
		this.wbTextContent = wbTextContent;
		this.wbPushDate = wbPushDate;
		this.praiseNum = praiseNum;
		this.commentNum = commentNum;
		this.turnNum = turnNum;
		this.collectionNum = collectionNum;
	}
	public PushInfo() {
		super();
	}
	@Override
	public String toString() {
		return "PushInfo [initPushInfo=" + initPushInfo + ", user=" + user
				+ ", praiseState=" + praiseState + ", collectionState="
				+ collectionState + ", wbId=" + wbId + ", wbAuthorId="
				+ wbAuthorId + ", userId=" + userId + ", userNickName="
				+ userNickName + ", wbImage=" + wbImage + ", wbTextContent="
				+ wbTextContent + ", wbPushDate=" + wbPushDate + ", praiseNum="
				+ praiseNum + ", commentNum=" + commentNum + ", turnNum="
				+ turnNum + ", collectionNum=" + collectionNum + "]";
	}
	
	
   
	
   

	
	
	
	
    

}
