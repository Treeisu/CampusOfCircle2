package org.jiang.COC.service;

import org.jiang.COC.model.User;




/**
 * User类的service层
 * @author cherry
 *
 */
public interface UserService {
	/**
	 * 保存单个user
	 * @param user
	 */
	public void saveUser(User user);
	/**
	 * 根据手机号码查询user
	 * @param phone
	 * @return
	 */
	public User findUserByPhone(String phone); 
}
