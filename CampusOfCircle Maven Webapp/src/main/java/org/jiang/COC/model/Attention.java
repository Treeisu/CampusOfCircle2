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
 * 用户关注表
 * @author Cherry
 *
 */
@Entity
@Table(name="tb_attention")
public class Attention implements Serializable {
	@Transient
	private static final long serialVersionUID = 8826591705909031853L;
	

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "attentionId", unique = true, nullable = false)
	private long attentionId;
	@Column(name = "groupName",length=20)
    private String groupName;
	@Column(name = "userId")
    private long userId;
	@Column(name = "toUserId")
    private long toUserId;
	@Column(name = "groupId")
    private long groupId;
    @Column(name = "createDate",length=20)
    private Date createDate;
	
    
    
    public long getAttentionId() {
		return attentionId;
	}
	public void setAttentionId(long attentionId) {
		this.attentionId = attentionId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getToUserId() {
		return toUserId;
	}
	public void setToUserId(long toUserId) {
		this.toUserId = toUserId;
	}
	public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Attention(long attentionId, String groupName, long userId,
			long toUserId, long groupId, Date createDate) {
		super();
		this.attentionId = attentionId;
		this.groupName = groupName;
		this.userId = userId;
		this.toUserId = toUserId;
		this.groupId = groupId;
		this.createDate = createDate;
	}
	public Attention() {
		super();
	}
	@Override
	public String toString() {
		return "Attention [attentionId=" + attentionId + ", groupName="
				+ groupName + ", userId=" + userId + ", toUserId=" + toUserId
				+ ", groupId=" + groupId + ", createDate=" + createDate + "]";
	}
	

	
	
	
	
    

}
