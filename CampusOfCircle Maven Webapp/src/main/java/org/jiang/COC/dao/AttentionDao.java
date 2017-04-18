package org.jiang.COC.dao;



import java.util.List;

import org.jiang.COC.model.Attention;

/**
 * 
 * @author cherry
 *
 */
public interface AttentionDao {
	
	public void saveAttention(Attention attention);//保存实体
	public void deleteAttention(Attention attention);//删除实体
	public void update(Attention attention);//删除实体
	public Attention getAttention(long Id);
	public List<Attention> findByUserId(long userId);
	public List<Long> findByGroupId(long groupId);
	public List<Attention> findAttentionByGroupId(long groupId);
	public List<Long> findToUsersByuserId(long userId);
	public List<Long> findByNoGroupId(long groupId,long userId);	
}
