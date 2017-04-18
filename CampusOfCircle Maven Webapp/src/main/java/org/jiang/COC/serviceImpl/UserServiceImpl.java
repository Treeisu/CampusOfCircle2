package org.jiang.COC.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.jiang.COC.dao.AdviceDao;
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
	private AdviceDao adviceDao;
	
	
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
			adviceDao.saveAdvice(userAdviceNum);
	}

	@Override
	@Transactional
	public List<User> findUserByPhone(String phone) {
		// TODO Auto-generated method stub
		List<User> list=userDaoIpml.findByPhone(phone);
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
		return user;
	}

	@Override
	@Transactional
	public List<User> findPushUsersByIds(List<Long> userIds) {
		// TODO Auto-generated method stub
		List<User> list=userDaoIpml.findPushUsersByIds(userIds);
		//取三个值
		if(list.size()>=3){		
			List<User> users=new ArrayList<User>();
			users=list.subList(0, 3);
			return users;			
		}else{
			return list;
		}
	}
	
	
	
}
