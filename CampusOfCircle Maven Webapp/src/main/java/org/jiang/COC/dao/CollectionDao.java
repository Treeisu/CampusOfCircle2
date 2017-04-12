package org.jiang.COC.dao;



import java.util.List;

import org.jiang.COC.model.CollectionInfo;

/**
 * 
 * @author cherry
 *
 */
public interface CollectionDao {
	
	public void saveCollection(CollectionInfo collectionInfo);//保存实体
	public List<CollectionInfo> findBywbIdAnduserId(long userId,long wbId);//根据评论ID查一条数据
	public List<CollectionInfo> findBywbId(long wbId);
	public void deleteCollection(CollectionInfo collectionInfo);//删除实体
}
