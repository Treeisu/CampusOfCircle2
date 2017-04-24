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
 * 转发记录表
 * @author Cherry
 *
 */
@Entity
@Table(name="tb_turn")
public class TurnInfo implements Serializable {	
	private static final long serialVersionUID = 6549557007968066616L;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "turnInfoId", unique = true, nullable = false)
	private long turnInfoId;
	@Column(name = "nowWbId",length=20)
	private long nowWbId;//这个字段用来存储点赞的微博Id
	@Column(name = "firstWbId",length=20)
	private long firstWbId;//这个字段用来存储点赞的微博Id
	@Column(name = "lastWbId",length=20)
	private long lastWbId;//这个字段用来存储点赞的微博Id	
    @Column(name = "turnDate",length=20)
    private Date turnDate;
    @Column(name = "messageId")
    private long messageId;
	
    
    
    public TurnInfo() {
		super();
	}
	public TurnInfo(long turnInfoId, long nowWbId, long firstWbId,
			long lastWbId, Date turnDate, long messageId) {
		super();
		this.turnInfoId = turnInfoId;
		this.nowWbId = nowWbId;
		this.firstWbId = firstWbId;
		this.lastWbId = lastWbId;
		this.turnDate = turnDate;
		this.messageId = messageId;
	}
	public long getTurnInfoId() {
		return turnInfoId;
	}
	public void setTurnInfoId(long turnInfoId) {
		this.turnInfoId = turnInfoId;
	}
	public long getNowWbId() {
		return nowWbId;
	}
	public void setNowWbId(long nowWbId) {
		this.nowWbId = nowWbId;
	}
	public long getFirstWbId() {
		return firstWbId;
	}
	public void setFirstWbId(long firstWbId) {
		this.firstWbId = firstWbId;
	}
	public long getLastWbId() {
		return lastWbId;
	}
	public void setLastWbId(long lastWbId) {
		this.lastWbId = lastWbId;
	}
	public Date getTurnDate() {
		return turnDate;
	}
	public void setTurnDate(Date turnDate) {
		this.turnDate = turnDate;
	}
	public long getMessageId() {
		return messageId;
	}
	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}
	@Override
	public String toString() {
		return "TurnInfo [turnInfoId=" + turnInfoId + ", nowWbId=" + nowWbId
				+ ", firstWbId=" + firstWbId + ", lastWbId=" + lastWbId
				+ ", turnDate=" + turnDate + ", messageId=" + messageId + "]";
	}
	
	





	
	
    

}
