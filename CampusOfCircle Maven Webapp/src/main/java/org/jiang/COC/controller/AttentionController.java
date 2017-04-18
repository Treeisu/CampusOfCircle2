package org.jiang.COC.controller;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.jiang.COC.model.Attention;
import org.jiang.COC.serviceImpl.AttentionServiceImpl;
import org.jiang.COC.serviceImpl.GroupServiceImpl;
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
	
	@RequestMapping(value="/saveAttention")
	@ResponseBody
	public int saveAttention(HttpServletRequest request,HttpServletResponse response){		
		String userIdstring=request.getParameter("userId");
		long userId=Long.parseLong(userIdstring);
		String toUserIdstring=request.getParameter("toUserId");
		long toUserId=Long.parseLong(toUserIdstring);
		String groupIdstring=request.getParameter("groupId");
		long groupId=Long.parseLong(groupIdstring);
		Attention attention=new Attention();
		attention.setCreateDate(new Date());
		attention.setGroupId(groupId);
		attention.setToUserId(toUserId);
		attention.setUserId(userId);
		attention.setGroupName(groupServiceImpl.getGroupByGroupId(groupId).getGroupName());
		attentionServiceImpl.saveAttention(attention);
		return 1;				
	}
	
	
	
}
