package org.jiang.COC.serviceImpl;

import org.jiang.COC.daoImpl.UserDaoImpl;
import org.jiang.COC.model.User;
import org.jiang.COC.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		userDaoIpml.saveUser(user);
	}

	@Override
	public User findUserByPhone(String phone) {
		// TODO Auto-generated method stub
		User user=new User();
		user=userDaoIpml.findByPhone(phone);
		return user;
	}

}
