package org.jiang.COC.dao;



import java.util.List;

import org.jiang.COC.model.Fan;

/**
 * 
 * @author cherry
 *
 */
public interface FanDao {
	
	public void saveFans(Fan fans);//保存实体
	public void deleteFans(Fan fans);//删除实体
	public Fan getFans(long Id);
	public List<Fan> findByUserId(long userId);
	
}
