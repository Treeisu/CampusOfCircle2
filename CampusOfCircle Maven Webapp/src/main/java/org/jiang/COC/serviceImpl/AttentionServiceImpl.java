package org.jiang.COC.serviceImpl;


import java.util.List;

import org.jiang.COC.daoImpl.AttentionDaoImpl;
import org.jiang.COC.model.Attention;
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

	@Override
	@Transactional
	public void saveAttention(Attention attention) {
		// TODO Auto-generated method stub
		attentionDaoImpl.saveAttention(attention);
	}

	@Override
	@Transactional
	public void deleteAttention(Attention attention) {
		// TODO Auto-generated method stub
		
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
	public List<Attention> findAttentionsByGroupId(long groupId) {
		// TODO Auto-generated method stub
		List<Attention> list=attentionDaoImpl.findByUserId(groupId);
		return list;
	}

	
	
	
	

	

}
