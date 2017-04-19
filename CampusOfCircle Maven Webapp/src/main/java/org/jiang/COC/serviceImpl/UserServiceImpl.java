package org.jiang.COC.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.jiang.COC.daoImpl.AdviceDaoImpl;
import org.jiang.COC.daoImpl.UserDaoImpl;
import org.jiang.COC.model.User;
import org.jiang.COC.model.UserAdviceNum;
import org.jiang.COC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author cherry
 *
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDaoImpl userDaoIpml;
	@Autowired
	private AdviceDaoImpl adviceDaoImpl;
	
	
	@Override
	@Transactional
	public void saveUser(User user) {
		// TODO Auto-generated method stub
			userDaoIpml.saveUser(user);
			/**
			 * 创建一个通知信息对象
			 */
			UserAdviceNum userAdviceNum=new UserAdviceNum();
			userAdviceNum.setUserId(user.getUserId());
			userAdviceNum.setUserNickName(user.getUserNickName());
			adviceDaoImpl.saveAdvice(userAdviceNum);
	}

	@Override
	@Transactional
	public List<User> findUserByPhone(String phone) {
		// TODO Auto-generated method stub
		List<User> list=userDaoIpml.findByPhone(phone);
		for(User u:list){
			UserAdviceNum userAdviceNum=adviceDaoImpl.findByUserId(u.getUserId());
			u.setUserAdviceNum(userAdviceNum);
		}		
		return list;
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDaoIpml.updateUser(user);
	}

	@Override
	@Transactional
	public User getByUserId(long userId) {
		// TODO Auto-generated method stub
		User user= userDaoIpml.getUserById(userId);
		UserAdviceNum userAdviceNum=adviceDaoImpl.findByUserId(user.getUserId());
		user.setUserAdviceNum(userAdviceNum);
		return user;
	}

	@Override
	@Transactional
	public List<User> findPushUsersByIds(List<Long> userIds) {
		// TODO Auto-generated method stub
		List<User> list=userDaoIpml.findPushUsersByIds(userIds);
		for(User u:list){
			UserAdviceNum userAdviceNum=adviceDaoImpl.findByUserId(u.getUserId());
			u.setUserAdviceNum(userAdviceNum);
		}
		//取三个值
		if(list.size()>=3){		
			List<User> users=new ArrayList<User>();
			users=list.subList(0, 3);
			return users;			
		}else{
			return list;
		}
	}
	@Override
	@Transactional
	public List<User> findUsersByIds(List<Long> userIds){
		// TODO Auto-generated method stub
		List<User> list=userDaoIpml.findUsersByIds(userIds);
		if(list.size()>0){
			for(User u:list){
				UserAdviceNum userAdviceNum=adviceDaoImpl.findByUserId(u.getUserId());
				u.setUserAdviceNum(userAdviceNum);
			}
		}
		return list;	
	}
	
}
