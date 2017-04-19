package org.jiang.COC.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;








import org.jiang.COC.model.Attention;
import org.jiang.COC.model.Group;
import org.jiang.COC.model.User;
import org.jiang.COC.serviceImpl.AttentionServiceImpl;
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
			List<User> attentionUsers=userServiceImpl.findUsersByIds(uids);
			if(attentionUsers.size()>0){
				request.getSession().setAttribute("attentionUsers", attentionUsers);
				
			}else{
				 attentionUsers=null;
				 request.getSession().setAttribute("attentionUsers", attentionUsers);
			 }
		}
		return sta;
	}
	
	
	
	
}
