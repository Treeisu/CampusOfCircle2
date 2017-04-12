package org.jiang.COC.dao;



import java.util.List;

import org.jiang.COC.model.PraiseInfo;

/**
 * 
 * @author cherry
 *
 */
public interface PraiseDao {
	
	public void savePraise(PraiseInfo praiseInfo);//保存实体
	public List<PraiseInfo> findBywbIdAnduserId(long userId,long wbId);//根据评论ID查一条数据
	public List<PraiseInfo> findBywbId(long wbId);
	public void deletePraise(PraiseInfo praiseInfo);//删除实体
}
