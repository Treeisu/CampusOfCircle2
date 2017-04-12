package org.jiang.COC.dao;






import java.util.List;

import org.jiang.COC.model.TurnInfo;

/**
 * 
 * @author cherry
 *
 */
public interface TurnDao {
	
	public void saveTurn(TurnInfo turnInfo);//保存实体
	public List<TurnInfo> findBynowWbId(long nowWbId);
	public void deleteTurn(TurnInfo turnInfo);//删除实体
}
