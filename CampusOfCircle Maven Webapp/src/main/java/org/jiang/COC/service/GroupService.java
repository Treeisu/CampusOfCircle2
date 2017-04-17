package org.jiang.COC.service;

import java.util.List;



import org.jiang.COC.model.Group;





/**
 * 
 * @author cherry
 *
 */
public interface GroupService {

	public void saveGroup(Group group);//保存实体
	public void deleteGroup(Group group);//删除实体
	public Group getGroupByGroupId(long groupId);
	public List<Group> findGroupsByUserId(long userId);

}
