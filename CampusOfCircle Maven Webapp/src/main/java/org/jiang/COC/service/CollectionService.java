package org.jiang.COC.service;

import java.util.List;




import org.jiang.COC.model.CollectionInfo;




/**
 * 
 * @author cherry
 *
 */
public interface CollectionService {

	public void saveCollection(CollectionInfo collectionInfo);//保存实体
	public List<CollectionInfo> findBywbIdAnduserId(long userId,long wbId);//根据评论ID查一条数据
	public void deleteCollection(long userId,long wbId);//删除实体
	public List<Long> findwbIdByuserId(long userId);

}
