package org.jiang.COC.service;

import java.util.List;


import org.jiang.COC.model.PraiseInfo;





/**
 * 
 * @author cherry
 *
 */
public interface PraiseService {

	public void savePraise(PraiseInfo praiseInfo);//保存实体
	public List<PraiseInfo> findBywbIdAnduserId(long userId,long wbId);//根据评论ID查一条数据
	public void deletePraise(long userId,long wbId);//删除实体

}
