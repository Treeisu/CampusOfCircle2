package org.jiang.COC.dao;

import java.util.List;

import org.jiang.COC.model.User;

/**
 * 
 * @author cherry
 *
 */
public interface UserDao {
	/***
	 * 用户注册，储存用户
	 * @param user
	 */
	public void saveUser(User user);
	public List<User> findByPhone(String userPhone);
	public void updateUser(User user);
}
