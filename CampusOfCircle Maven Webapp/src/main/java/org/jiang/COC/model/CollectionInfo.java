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
 * 收藏表
 * @author Cherry
 *
 */
@Entity
@Table(name="tb_collection")
public class CollectionInfo implements Serializable {
	private static final long serialVersionUID = -5872855637290168567L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "collectionInfoId", unique = true, nullable = false)
	private long collectionInfoId;
	@Column(name = "wbId",length=20)
	private long wbId;//这个字段用来存储收藏的微博Id
	@Column(name = "userId",length=20)
	private long userId;
    @Column(name = "collectionDate",length=20)
    private Date collectionDate;
	
	
	public CollectionInfo(long collectionInfoId, long wbId, long userId,
			Date collectionDate) {
		super();
		this.collectionInfoId = collectionInfoId;
		this.wbId = wbId;
		this.userId = userId;
		this.collectionDate = collectionDate;
	}


	public CollectionInfo() {
		super();
	}
	
	
	
	public long getCollectionInfoId() {
		return collectionInfoId;
	}


	public void setCollectionInfoId(long collectionInfoId) {
		this.collectionInfoId = collectionInfoId;
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


	public Date getCollectionDate() {
		return collectionDate;
	}


	public void setCollectionDate(Date collectionDate) {
		this.collectionDate = collectionDate;
	}


	@Override
	public String toString() {
		return "CollectionInfo [collectionInfoId=" + collectionInfoId
				+ ", wbId=" + wbId + ", userId=" + userId + ", collectionDate="
				+ collectionDate + "]";
	}


	
	
	
    
    
    
    
    

	
	
	
	
    

}
