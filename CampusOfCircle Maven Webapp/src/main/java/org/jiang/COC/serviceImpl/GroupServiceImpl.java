package org.jiang.COC.serviceImpl;


import java.util.List;

import org.jiang.COC.daoImpl.GroupDaoImpl;
import org.jiang.COC.model.Attention;
import org.jiang.COC.model.Group;
import org.jiang.COC.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author cherry
 *
 */
@Service
public class GroupServiceImpl implements GroupService {
	@Autowired
	private GroupDaoImpl groupDaoImpl;
	@Autowired
	private AttentionServiceImpl attentionServiceImpl;

	@Override
	@Transactional
	public void saveGroup(Group group) {
		// TODO Auto-generated method stub
		groupDaoImpl.saveGroup(group);
	}

	@Override
	@Transactional
	public void deleteGroup(Group group) {
		// TODO Auto-generated method stub
		long groupId=group.getGroupId();
		groupDaoImpl.deleteGroup(group);
		//需要更新关注表中此分组里面的人的组号		
		List<Attention> list=attentionServiceImpl.findAttentionByGroupId(groupId);
		for(Attention a:list){
			a.setGroupId(0);
			a.setGroupName("");
			attentionServiceImpl.update(a);
		}
	}

	@Override
	@Transactional
	public Group getGroupByGroupId(long groupId) {
		// TODO Auto-generated method stub
		Group group=groupDaoImpl.getGroup(groupId);
		return group;
	}

	@Override
	@Transactional
	public List<Group> findGroupsByUserId(long userId) {
		// TODO Auto-generated method stub
		
		List<Group> list=groupDaoImpl.findByUserId(userId);
		return list;
	}
	
	
	

	

}
