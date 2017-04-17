package org.jiang.COC.serviceImpl;


import java.util.List;

import org.jiang.COC.daoImpl.GroupDaoImpl;
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
		groupDaoImpl.deleteGroup(group);
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
