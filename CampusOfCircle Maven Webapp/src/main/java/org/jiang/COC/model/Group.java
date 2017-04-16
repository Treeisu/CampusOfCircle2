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
 * 用户分组表
 * @author Cherry
 *
 */
@Entity
@Table(name="tb_groups")
public class Group implements Serializable {
	@Transient
	private static final long serialVersionUID = 2995090036435093323L;
	

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "groupId", unique = true, nullable = false)
	private long groupId;
	@Column(name = "groupName",length=20)
    private String groupName;
	@Column(name = "userId")
    private long userId;
    @Column(name = "createDate",length=20)
    private Date createDate;
	
    
    
    public long getGroupId() {
		return groupId;
	}
	public void setGroupId(long groupId) {
		this.groupId = groupId;
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Group(long groupId, String groupName, long userId, Date createDate) {
		super();
		this.groupId = groupId;
		this.groupName = groupName;
		this.userId = userId;
		this.createDate = createDate;
	}
	public Group() {
		super();
	}
	@Override
	public String toString() {
		return "Groups [groupId=" + groupId + ", groupName=" + groupName
				+ ", userId=" + userId + ", createDate=" + createDate + "]";
	}

	
   

	
	
	
	
    

}
