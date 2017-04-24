package org.jiang.COC.serviceImpl;


import java.util.Date;
import java.util.List;

import org.jiang.COC.daoImpl.AttentionDaoImpl;
import org.jiang.COC.model.Attention;
import org.jiang.COC.model.Fan;
import org.jiang.COC.model.Message;
import org.jiang.COC.model.UserAdviceNum;
import org.jiang.COC.service.AttentionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author cherry
 *
 */
@Service
public class AttentionServiceImpl implements AttentionService {
	@Autowired
	private AttentionDaoImpl attentionDaoImpl ;
	@Autowired
	private AdviceServiceImpl adviceServiceImpl ;
	@Autowired
	private FanServiceImpl fanServiceImpl ;
	@Autowired
	private MessageServiceImpl messageServiceImpl ;
	@Override
	@Transactional
	public void saveAttention(Attention attention) {
		// TODO Auto-generated method stub
		attentionDaoImpl.saveAttention(attention);
		//添加一条mesasge记录
		Message message=new Message();
		message.setKindOperation(1);//1表示新粉丝种类操作
		message.setAttentionId(attention.getAttentionId());
		message.setMyUserId(attention.getToUserId());
		message.setFromUserId(attention.getUserId());
		message.setDate(attention.getCreateDate());			
		messageServiceImpl.saveMessage(message);
		//需要更新关注数量
		UserAdviceNum userAdviceNum=adviceServiceImpl.findByUserId(attention.getUserId());
		userAdviceNum.setAttentionNum(userAdviceNum.getAttentionNum()+1);
		adviceServiceImpl.update(userAdviceNum);
		//更新对方粉丝数量
		UserAdviceNum userAdviceNum2=adviceServiceImpl.findByUserId(attention.getToUserId());
		userAdviceNum2.setFansNum(userAdviceNum2.getFansNum()+1);
		adviceServiceImpl.update(userAdviceNum2);
		//更新对方粉丝表
		Fan f=new Fan();
		f.setCreateDate(new Date());
		f.setFromUserId(attention.getUserId());
		f.setUserId(attention.getToUserId());
		fanServiceImpl.saveFan(f);
	}

	@Override
	@Transactional
	public void deleteAttention(Attention attention) {
		// TODO Auto-generated method stub
		attentionDaoImpl.deleteAttention(attention);
		Message m= messageServiceImpl.getMessageByattentionId(attention.getAttentionId());
		if(m!=null){messageServiceImpl.deleteMessage(m);}
		//更新对方粉丝表，顺便删除粉丝时fanservice会更新数量
		Fan fan=fanServiceImpl.findByFromUIdANDUId(attention.getUserId(), attention.getToUserId());
		if(fan !=null){
			fanServiceImpl.deleteFan(fan);
		}
	}

	@Override
	@Transactional
	public Attention getAttentionById(long Id) {
		// TODO Auto-generated method stub
		Attention attention=attentionDaoImpl.getAttention(Id);
		return attention;				
	}

	@Override
	@Transactional
	public List<Attention> findAttentionsByUserId(long userId) {
		// TODO Auto-generated method stub
		List<Attention> list=attentionDaoImpl.findByUserId(userId);
		return list;
		
	}

	@Override
	@Transactional
	public List<Long> findAttentionsByGroupId(long groupId) {
		// TODO Auto-generated method stub
		List<Long> list=attentionDaoImpl.findByGroupId(groupId);
		return list;
	}

	@Override
	@Transactional
	public List<Long> findToUserIdsByUserId(long userId) {
		// TODO Auto-generated method stub
		List<Long>list=attentionDaoImpl.findToUsersByuserId(userId);		
		return list;
	}

	@Override
	@Transactional
	public List<Long> findByNoGroupId(long groupId, long userId) {
		// TODO Auto-generated method stub		
		return attentionDaoImpl.findByNoGroupId(groupId, userId);
	}

	@Override
	@Transactional
	public List<Attention> findAttentionByGroupId(long groupId) {
		// TODO Auto-generated method stub
		return attentionDaoImpl.findAttentionByGroupId(groupId);
	}

	@Override
	@Transactional
	public void update(Attention attention) {
		// TODO Auto-generated method stub
		attentionDaoImpl.update(attention);
	}

	@Override
	@Transactional
	public Attention getAttentionUser(long toUserId, long userId) {
		// TODO Auto-generated method stub
		return attentionDaoImpl.getAttentionUser(toUserId, userId);
	}
	

}
