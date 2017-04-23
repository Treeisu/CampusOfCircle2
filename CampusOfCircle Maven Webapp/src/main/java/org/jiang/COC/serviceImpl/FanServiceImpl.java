package org.jiang.COC.serviceImpl;


import java.util.List;

import org.jiang.COC.daoImpl.FanDaoImpl;
import org.jiang.COC.model.Attention;
import org.jiang.COC.model.Fan;
import org.jiang.COC.model.Message;
import org.jiang.COC.model.UserAdviceNum;
import org.jiang.COC.service.FanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author cherry
 *
 */
@Service
public class FanServiceImpl implements FanService {
	@Autowired
	private FanDaoImpl fanDaoImpl;
	@Autowired
	private AdviceServiceImpl adviceServiceImpl;
	@Autowired
	private AttentionServiceImpl attentionServiceImpl;
	@Autowired
	private MessageServiceImpl messageServiceImpl;

	@Override
	@Transactional
	public void saveFan(Fan fan) {
		// TODO Auto-generated method stub
		fanDaoImpl.saveFans(fan);
	}

	@Override
	@Transactional
	public void deleteFan(Fan fan) {
		// TODO Auto-generated method stub
		fanDaoImpl.deleteFans(fan);
		//更新自己的粉丝数
		UserAdviceNum userAdviceNum=adviceServiceImpl.findByUserId(fan.getUserId());
		userAdviceNum.setFansNum(userAdviceNum.getFansNum()-1);
		adviceServiceImpl.update(userAdviceNum);
		//删除对方关注人的记录
		Attention attention= attentionServiceImpl.getAttentionUser(fan.getUserId(), fan.getFromUserId());
		if(attention!=null){
			attentionServiceImpl.deleteAttention(attention);
			Message m= messageServiceImpl.findMessageBythree(attention.getUserId(), attention.getToUserId(), 1);
			if(m!=null){messageServiceImpl.deleteMessage(m);}
		}
		//更新对方关注数量
		UserAdviceNum userAdviceNum2=adviceServiceImpl.findByUserId(fan.getFromUserId());
		userAdviceNum2.setAttentionNum(userAdviceNum2.getAttentionNum()-1);
		adviceServiceImpl.update(userAdviceNum2);
	}

	@Override
	@Transactional
	public Fan getFanById(long Id) {
		// TODO Auto-generated method stub
		Fan fan=fanDaoImpl.getFans(Id);
		return fan;
	}

	@Override
	@Transactional
	public List<Fan> findFanByUserId(long userId) {
		// TODO Auto-generated method stub
		List<Fan> list=fanDaoImpl.findByUserId(userId);
		return list;
	}

	@Override
	@Transactional
	public Fan findByFromUIdANDUId(long fromUserId, long userId) {
		// TODO Auto-generated method stub
		List<Fan> list=fanDaoImpl.findByFromUIdANDUId(fromUserId, userId);
		if(list.size()>0){
			return list.get(0);
		}else{
			return null;
		}
	}

	@Override
	@Transactional
	public List<Long> findfromUserIdFanByUserId(long userId) {
		// TODO Auto-generated method stub
		return fanDaoImpl.findfromUserIdByUserId(userId);
	}

	

	
	
	

	

}
