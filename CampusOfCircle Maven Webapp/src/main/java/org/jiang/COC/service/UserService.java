package org.jiang.COC.service;

import java.util.List;

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
	public List<User> findUserByPhone(String phone); 
	public void updateUser(User user);
	public User getByUserId(long userId); 
	public List<User> findPushUsersByIds(List<Long> userIds);
	public List<User> findAttentionUsersByIds(List<Long> userIds,long uid);
	public List<User> findFanUsersByIds(List<Long> userIds,long uid);
}
