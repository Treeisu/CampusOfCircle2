package org.jiang.COC.dao;



import java.util.List;

import org.jiang.COC.model.Group;

/**
 * 
 * @author cherry
 *
 */
public interface GroupDao {
	
	public void saveGroup(Group group);//保存实体
	public void deleteGroup(Group group);//删除实体
	public Group getGroupByGroupId(long groupId);
	public Group getNoGroup(long groupId,long userId);
	public List<Group> findByUserId(long userId);
	
}
