package org.jiang.COC.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 点赞表
 * @author Cherry
 *
 */
@Entity
@Table(name="tb_praise")
public class PraiseInfo implements Serializable {	
	private static final long serialVersionUID = 6387439454553464462L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "praiseInfoId", unique = true, nullable = false)
	private long praiseInfoId;
	@Column(name = "wbId",length=20)
	private long wbId;//这个字段用来存储点赞的微博Id
	@Column(name = "userId",length=20)
	private long userId;
    @Column(name = "praiseDate",length=20)
    private Date praiseDate;
    @Column(name = "state")
    private int state;
    
    
	
	public PraiseInfo(long praiseInfoId, long wbId, long userId,
			Date praiseDate, int state) {
		super();
		this.praiseInfoId = praiseInfoId;
		this.wbId = wbId;
		this.userId = userId;
		this.praiseDate = praiseDate;
		this.state = state;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public PraiseInfo() {
		super();
	}
	
	
	public long getPraiseInfoId() {
		return praiseInfoId;
	}
	public void setPraiseInfoId(long praiseInfoId) {
		this.praiseInfoId = praiseInfoId;
	}
	public long getWbId() {
		return wbId;
	}
	public void setWbId(long wbId) {
		this.wbId = wbId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getPraiseDate() {
		return praiseDate;
	}
	public void setPraiseDate(Date praiseDate) {
		this.praiseDate = praiseDate;
	}


	@Override
	public String toString() {
		return "PraiseInfo [praiseInfoId=" + praiseInfoId + ", wbId=" + wbId
				+ ", userId=" + userId + ", praiseDate=" + praiseDate
				+ ", state=" + state + "]";
	}
	
	
	
    
    
    
    
    

	
	
	
	
    

}
