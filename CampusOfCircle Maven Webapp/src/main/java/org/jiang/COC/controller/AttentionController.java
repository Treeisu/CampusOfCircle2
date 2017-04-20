package org.jiang.COC.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;










import org.jiang.COC.model.Attention;
import org.jiang.COC.model.Fan;
import org.jiang.COC.model.Group;
import org.jiang.COC.model.User;
import org.jiang.COC.serviceImpl.AttentionServiceImpl;
import org.jiang.COC.serviceImpl.FanServiceImpl;
import org.jiang.COC.serviceImpl.GroupServiceImpl;
import org.jiang.COC.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户请求有关的表
 * @author cherry
 *
 */
@Controller
@RequestMapping(value="/attention")
public class AttentionController {
	//private static Logger logger = LoggerFactory.getLogger(SublistController.class);
	@Autowired
	private GroupServiceImpl groupServiceImpl;
	@Autowired
	private AttentionServiceImpl attentionServiceImpl;
	@Autowired
	private FanServiceImpl fanServiceImpl;
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@RequestMapping(value="/saveAttention")
	@ResponseBody
	public int saveAttention(HttpServletRequest request,HttpServletResponse response){		
		String userIdstring=request.getParameter("userId");
		long userId=Long.parseLong(userIdstring);
		String toUserIdstring=request.getParameter("toUserId");
		long toUserId=Long.parseLong(toUserIdstring);
		String groupIdstring=request.getParameter("groupId");
		long groupId=Long.parseLong(groupIdstring);
		int sta=0;
		Attention attention=new Attention();
		attention.setCreateDate(new Date());
		attention.setGroupId(groupId);
		attention.setToUserId(toUserId);
		attention.setUserId(userId);
		Group group=groupServiceImpl.getGroupByGroupId(groupId);
		if(group!=null){
			attention.setGroupName(group.getGroupName());
			attentionServiceImpl.saveAttention(attention);
			sta=1;
			return sta;
		}else{
			attention.setGroupName("默认分组");
			attentionServiceImpl.saveAttention(attention);
			sta=1;
			return sta;
		}		
	}
	@RequestMapping(value="/getAttentions")
	@ResponseBody
	public int getAttentionUsers(HttpServletRequest request,HttpServletResponse response){		
		String userIdstring=request.getParameter("userId");
		long userId=Long.parseLong(userIdstring);
		int sta=0;
		List<Long> uids=attentionServiceImpl.findToUserIdsByUserId(userId);
		if(uids.size()>0){
			List<User> attentionUsers=userServiceImpl.findAttentionUsersByIds(uids,userId);
			if(attentionUsers.size()>0){
				request.getSession().setAttribute("attentionUsers", attentionUsers);
				
			}else{
				 attentionUsers=null;
				 request.getSession().setAttribute("attentionUsers", attentionUsers);
			 }
		}
		return sta;
	}
	@RequestMapping(value="/getFans")
	@ResponseBody
	public int getFanUsers(HttpServletRequest request,HttpServletResponse response){		
		String userIdstring=request.getParameter("userId");
		long userId=Long.parseLong(userIdstring);
		int sta=0;
		List<Long> uids=fanServiceImpl.findfromUserIdFanByUserId(userId);
		if(uids.size()>0){
			List<User> fanUsers=userServiceImpl.findFanUsersByIds(uids,userId);
			if(fanUsers.size()>0){
				request.getSession().setAttribute("fanUsers", fanUsers);				
			}else{
				fanUsers=null;
				 request.getSession().setAttribute("fanUsers", fanUsers);
			 }
		}
		return sta;
	}
	@RequestMapping(value="/changeAttention")
	@ResponseBody
	public int changeAttention(HttpServletRequest request,HttpServletResponse response){		
		String attentionIdstring=request.getParameter("attentionId");
		long attentionId=Long.parseLong(attentionIdstring);
		String groupIdstring=request.getParameter("groupId");
		long groupId=Long.parseLong(groupIdstring);
		int sta=0;
		Attention attention=attentionServiceImpl.getAttentionById(attentionId);
		if(attention !=null){
			attention.setGroupId(groupId);
			attention.setGroupName(groupServiceImpl.getGroupByGroupId(groupId).getGroupName());
			attentionServiceImpl.update(attention);	
			sta=1;
		}			
		return sta;
			
	}
	@RequestMapping(value="/changeAttention2")
	@ResponseBody
	public int changeAttention2(HttpServletRequest request,HttpServletResponse response){		
		String fanIdstring=request.getParameter("fanId");
		long fanId=Long.parseLong(fanIdstring);
		String groupIdstring=request.getParameter("groupId");
		long groupId=Long.parseLong(groupIdstring);
		int sta=0;
		Fan fan=fanServiceImpl.getFanById(fanId);
		Attention attention=attentionServiceImpl.getAttentionUser( fan.getFromUserId(),fan.getUserId());
		System.out.println(attention.getAttentionId());
		if(attention !=null){
			attention.setGroupId(groupId);
			attention.setGroupName(groupServiceImpl.getGroupByGroupId(groupId).getGroupName());
			attentionServiceImpl.update(attention);	
			sta=1;
		}			
		return sta;
			
	}
	@RequestMapping(value="/delAttention")
	@ResponseBody
	public int deleteAttention(HttpServletRequest request,HttpServletResponse response){		
		String attentionIdstring=request.getParameter("attentionId");
		long attentionId=Long.parseLong(attentionIdstring);//关注记录
		int sta=0;
		Attention attention=attentionServiceImpl.getAttentionById(attentionId);
		if(attention !=null){
			attentionServiceImpl.deleteAttention(attention);
			sta=1;
		}
		return sta;
			
	}
	@RequestMapping(value="/delAttention2")
	@ResponseBody
	public int deleteAttention2(HttpServletRequest request,HttpServletResponse response){		
		String fanIdstring=request.getParameter("fanId");
		long fanId=Long.parseLong(fanIdstring);//粉丝记录
		//得到关注记录
		Attention attention=attentionServiceImpl.getAttentionUser(fanServiceImpl.getFanById(fanId).getFromUserId(),fanServiceImpl.getFanById(fanId).getUserId());
		int sta=0;
		if(attention !=null){
			attentionServiceImpl.deleteAttention(attention);
			sta=1;
		}
		return sta;
			
	}
	@RequestMapping(value="/delFan")
	@ResponseBody
	public int deleteFans(HttpServletRequest request,HttpServletResponse response){		
		User user=(User) request.getSession().getAttribute("user");
		String attentionUserIdstring=request.getParameter("attentionUserId");
		long attentionUserId=Long.parseLong(attentionUserIdstring);//粉丝或关注的人的id
		int sta=0;
		Fan fan=fanServiceImpl.findByFromUIdANDUId(attentionUserId, user.getUserId());
		if(fan !=null){
			fanServiceImpl.deleteFan(fan);
			sta=1;
		}
		return sta;
			
	}
	@RequestMapping(value="/delFan2")
	@ResponseBody
	public int deleteFans2(HttpServletRequest request,HttpServletResponse response){
		String fanIdstring=request.getParameter("fanId");
		long fanId=Long.parseLong(fanIdstring);//粉丝或关注的人的id
		int sta=0;
		Fan fan=fanServiceImpl.getFanById(fanId);
		if(fan !=null){
			fanServiceImpl.deleteFan(fan);
			sta=1;
		}
		return sta;		
	}
	
	
	
}
