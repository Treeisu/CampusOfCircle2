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
public class Fans implements Serializable {
	@Transient
	private static final long serialVersionUID = -2740711715719117065L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	private long Id;
	@Column(name = "userId")
    private long userId;
	@Column(name = "fromUserId")
    private long fromUserId;
    @Column(name = "createDate",length=20)
    private Date createDate;
	
    
    
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
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Fans(long id, long userId, long fromUserId, Date createDate) {
		super();
		Id = id;
		this.userId = userId;
		this.fromUserId = fromUserId;
		this.createDate = createDate;
	}
	public Fans() {
		super();
	}
	@Override
	public String toString() {
		return "Fans [Id=" + Id + ", userId=" + userId + ", fromUserId="
				+ fromUserId + ", createDate=" + createDate + "]";
	}
	

	

	
	
    

}
