package org.jiang.COC.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.jiang.COC.daoImpl.UserDaoImpl;
import org.jiang.COC.model.User;
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
	
	
	@Override
	@Transactional
	public void saveUser(User user) {
		// TODO Auto-generated method stub
			userDaoIpml.saveUser(user);
		
	}

	@Override
	@Transactional
	public List<User> findUserByPhone(String phone) {
		// TODO Auto-generated method stub
		List<User> list=new ArrayList<User>();
		list=userDaoIpml.findByPhone(phone);
		return list;
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDaoIpml.updateUser(user);
	}

}
