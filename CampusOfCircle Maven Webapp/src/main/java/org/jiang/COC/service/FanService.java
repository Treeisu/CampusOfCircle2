package org.jiang.COC.service;

import java.util.List;






import org.jiang.COC.model.Fan;





/**
 * 
 * @author cherry
 *
 */
public interface FanService {

	public void saveFan(Fan fan);//保存实体
	public void deleteFan(Fan fan);//删除实体
	public Fan getFanById(long Id);
	public List<Fan> findFanByUserId(long userId);
	public List<Long> findfromUserIdFanByUserId(long userId);
	public Fan findByFromUIdANDUId(long fromUserId,long userId);

}
