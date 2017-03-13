package org.jiang.COC.dao;

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
	public User findByPhone(String userPhone);
}
