package org.jiang.COC.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import org.jiang.COC.daoImpl.AdviceDaoImpl;
import org.jiang.COC.daoImpl.AttentionDaoImpl;
import org.jiang.COC.daoImpl.UserDaoImpl;
import org.jiang.COC.model.Attention;
import org.jiang.COC.model.Fan;
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
	@Autowired
	private AttentionDaoImpl attentionDaoImpl;
	@Autowired
	private FanServiceImpl fanServiceImpl;
	
	
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
	public List<User> findAttentionUsersByIds(List<Long> userIds,long uid){
		// TODO Auto-generated method stub
		List<User> list=userDaoIpml.findUsersByIds(userIds);//得到了关注的人
		if(list.size()>0){
			for(User u:list){
				UserAdviceNum userAdviceNum=adviceDaoImpl.findByUserId(u.getUserId());
				Attention attention=attentionDaoImpl.getAttentionUser(u.getUserId(), uid);//得到单条关注记录
				Attention attention2=attentionDaoImpl.getAttentionUser(uid,u.getUserId());//查看是否也关注了本人
				u.setUserAdviceNum(userAdviceNum);
				u.setAddAttention(attention);
				if(attention2 !=null){
					u.setAddState(1);
				}else{
					u.setAddState(0);
				}
			}
		}
		return list;	
	}
	@Override
	@Transactional
	public List<User> findFanUsersByIds(List<Long> userIds,long uid){
		// TODO Auto-generated method stub
		List<User> list=userDaoIpml.findUsersByIds(userIds);//得到了粉丝
		if(list.size()>0){
			for(User u:list){
				UserAdviceNum userAdviceNum=adviceDaoImpl.findByUserId(u.getUserId());
				Fan fan=fanServiceImpl.findByFromUIdANDUId(u.getUserId(), uid);//得到单条粉丝记录
				Fan fan2=fanServiceImpl.findByFromUIdANDUId(uid,u.getUserId());//验证是否互为粉丝			
				u.setUserAdviceNum(userAdviceNum);
				u.setFan(fan);//设置自己和每个粉丝关系记录
				if(fan2 !=null){
					u.setAddState(1);//state为1表示自己关注了这个粉丝
				}else{
					u.setAddState(0);//state为0表示没有关注
				}
			}
		}
		return list;	
	}
	
	
	
	
}
