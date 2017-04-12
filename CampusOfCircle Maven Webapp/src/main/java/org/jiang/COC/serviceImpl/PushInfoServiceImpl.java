package org.jiang.COC.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.jiang.COC.daoImpl.CollectionDaoImpl;
import org.jiang.COC.daoImpl.CommentDaoImpl;
import org.jiang.COC.daoImpl.PraiseDaoImpl;
import org.jiang.COC.daoImpl.PushInfoDaoImpl;
import org.jiang.COC.daoImpl.UserDaoImpl;
import org.jiang.COC.model.CollectionInfo;
import org.jiang.COC.model.Comment;
import org.jiang.COC.model.PraiseInfo;
import org.jiang.COC.model.PushInfo;
import org.jiang.COC.model.User;
import org.jiang.COC.service.PushInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 
 * @author cherry
 *
 */
@Service
public class PushInfoServiceImpl implements PushInfoService {
	@Autowired
	private PushInfoDaoImpl pushInfoDaoImpl;
	@Autowired
	private UserDaoImpl userDaoImpl;
	@Autowired
	private CommentDaoImpl commentDaoImpl;
	@Autowired
	private PraiseDaoImpl prasieDaoImpl;
	@Autowired
	private CollectionDaoImpl collectionDaoImpl;
	
	
	
	/**
	 * 查询原始微博方法
	 * @param info
	 * @return
	 */
	public PushInfo findLastWeibo(PushInfo info){
		if(info.getWbAuthorId()==0){
			return info;
		}else{
			return findLastWeibo(pushInfoDaoImpl.getPushIfoBywbId(info.getWbAuthorId())); 
		}		
	}
	
	@Override
	@Transactional
	public void savePushInfo(PushInfo pushInfo) {
		// TODO Auto-generated method stub		
		if(pushInfo.getWbAuthorId() !=0){//如果是转发的微博
			//需要做个判断，找出最原始微博以及最近一条微博
			PushInfo lastinfo=findLastWeibo(pushInfo);//最原始一条微博
			PushInfo firstinfo=pushInfoDaoImpl.getPushIfoBywbId(pushInfo.getWbAuthorId());//当前转发的微博
			System.out.println(lastinfo.getWbId());
			System.out.println(firstinfo.getWbId());
			if(lastinfo.getWbId()==firstinfo.getWbId()){
				//单次转发
				pushInfoDaoImpl.savePushInfo(pushInfo);
				firstinfo.setTurnNum(firstinfo.getTurnNum()+1);				
				pushInfoDaoImpl.updatePushInfo(firstinfo);
			}else{
				//多次转发
				pushInfo.setWbAuthorId(lastinfo.getWbId());
				pushInfoDaoImpl.savePushInfo(pushInfo);
				lastinfo.setTurnNum(lastinfo.getTurnNum()+1);
				pushInfoDaoImpl.updatePushInfo(lastinfo);//原始转发微博数量+1
				firstinfo.setTurnNum(firstinfo.getTurnNum()+1);
				pushInfoDaoImpl.updatePushInfo(firstinfo);//当前转发微博数量+1				
			}
		}
		pushInfoDaoImpl.savePushInfo(pushInfo);	
	}

	@Override
	@Transactional
	public List<PushInfo> findByuserIds(List<Long> userIds,long uid) {
		// TODO Auto-generated method stub
		List<PushInfo> list=new ArrayList<PushInfo>();
		list=pushInfoDaoImpl.findByuserIds(userIds);
		for( PushInfo blog:list){
			//设置发布者信息
			User user=userDaoImpl.getUserById(blog.getUserId());
			if(user !=null){
				blog.setUser(user);
			}
			//设置转发init微博信息
			PushInfo initPushInfo=pushInfoDaoImpl.getPushIfoBywbId(blog.getWbAuthorId());			
			if(initPushInfo !=null){
				User inituser=userDaoImpl.getUserById(initPushInfo.getUserId());
				initPushInfo.setUser(inituser);
				blog.setInitPushInfo(initPushInfo);
			}
			//设置点赞状态
			List<PraiseInfo> prasieInfos=prasieDaoImpl.findBywbIdAnduserId(uid, blog.getWbId());
			if(prasieInfos.size()!=0){
				blog.setPraiseState(1);//已赞
			}else{
				blog.setPraiseState(0);//未赞
			}
			//设置收藏状态
			List<CollectionInfo> collectionInfos=collectionDaoImpl.findBywbIdAnduserId(uid, blog.getWbId());
			if(collectionInfos.size()!=0){
				blog.setCollectionState(1);//已收藏
			}else{
				blog.setCollectionState(0);//未收藏
			}	
			
		}
		return list;
	}

	@Override
	@Transactional
	public void deleteBywbId(long wbId) {
		// TODO Auto-generated method stub
		PushInfo pushInfo=pushInfoDaoImpl.getPushIfoBywbId(wbId);
		if(pushInfo !=null){
			pushInfoDaoImpl.deletePushInfo(pushInfo);
			//删除相关评论
			List<Comment> comments=commentDaoImpl.findBywbId(wbId);			
			for(Comment comment:comments){
				commentDaoImpl.deleteComment(comment);
			}
			//删除相关点赞
			List<PraiseInfo> praiseInfos=prasieDaoImpl.findBywbId(wbId);
			for(PraiseInfo praiseInfo:praiseInfos){
				prasieDaoImpl.deletePraise(praiseInfo);
			}
			//删除相关收藏
			List<CollectionInfo> collectionInfos=collectionDaoImpl.findBywbId(wbId);
			for(CollectionInfo collectionInfo:collectionInfos){
				collectionDaoImpl.deleteCollection(collectionInfo);
			}
			//转发微博删除
			long authorId=pushInfo.getWbAuthorId();
			if(authorId !=0){
				PushInfo authorPushInfo=pushInfoDaoImpl.getPushIfoBywbId(authorId);
				if(authorPushInfo !=null){
					authorPushInfo.setTurnNum(authorPushInfo.getTurnNum()-1);
					pushInfoDaoImpl.updatePushInfo(authorPushInfo);
				}				
			}
			
		}		
	}

	@Override
	@Transactional
	public PushInfo getPushIfoBywbId(long uid,long wbId) {
		// TODO Auto-generated method stub
		PushInfo blog=pushInfoDaoImpl.getPushIfoBywbId(wbId);
		//设置发布者信息
		User user=userDaoImpl.getUserById(blog.getUserId());
		if(user !=null){
			blog.setUser(user);
		}
		//设置转发init微博信息
		PushInfo initPushInfo=pushInfoDaoImpl.getPushIfoBywbId(blog.getWbAuthorId());
		if(initPushInfo !=null){
			blog.setInitPushInfo(initPushInfo);
		}
		//设置点赞状态
		List<PraiseInfo> prasieInfos=prasieDaoImpl.findBywbIdAnduserId(uid, blog.getWbId());
		if(prasieInfos !=null){
			blog.setPraiseState(1);
		}else{
			blog.setPraiseState(0);
		}
		//设置收藏状态
		List<CollectionInfo> collectionInfos=collectionDaoImpl.findBywbIdAnduserId(uid, blog.getWbId());
		if(collectionInfos !=null){
			blog.setCollectionState(1);
		}else{
			blog.setCollectionState(0);
		}
		return blog;
	}

	@Override
	public void updatePushInfo(PushInfo pushInfo) {
		// TODO Auto-generated method stub
		pushInfoDaoImpl.updatePushInfo(pushInfo);
	}

	@Override
	public List<PushInfo> findByuserId(long userId) {
		// TODO Auto-generated method stub
		List<PushInfo> list=new ArrayList<PushInfo>();
		list=pushInfoDaoImpl.findByuserId(userId);
		for( PushInfo blog:list){
			//设置发布者信息
			User user=userDaoImpl.getUserById(blog.getUserId());
			if(user !=null){
				blog.setUser(user);
			}
			//设置转发init微博信息
			PushInfo initPushInfo=pushInfoDaoImpl.getPushIfoBywbId(blog.getWbAuthorId());
			if(initPushInfo !=null){
				blog.setInitPushInfo(initPushInfo);
			}
			//设置点赞状态
			List<PraiseInfo> prasieInfos=prasieDaoImpl.findBywbIdAnduserId(userId, blog.getWbId());
			if(prasieInfos !=null){
				blog.setPraiseState(1);
			}else{
				blog.setPraiseState(0);
			}
			//设置收藏状态
			List<CollectionInfo> collectionInfos=collectionDaoImpl.findBywbIdAnduserId(userId, blog.getWbId());
			if(collectionInfos !=null){
				blog.setCollectionState(1);
			}else{
				blog.setCollectionState(0);
			}	
			
		}
		return list;
	}

	

}
