package org.jiang.COC.dao;



import java.util.List;

import org.jiang.COC.model.Fans;

/**
 * 
 * @author cherry
 *
 */
public interface FansDao {
	
	public void saveFans(Fans fans);//保存实体
	public void deleteFans(Fans fans);//删除实体
	public Fans getFans(long Id);
	public List<Fans> findByUserId(long userId);
	
}
