package org.jiang.COC.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




import org.jiang.COC.model.Group;
import org.jiang.COC.model.PushInfo;
import org.jiang.COC.model.User;
import org.jiang.COC.serviceImpl.AdviceServiceImpl;
import org.jiang.COC.serviceImpl.AttentionServiceImpl;
import org.jiang.COC.serviceImpl.CommentServiceImpl;
import org.jiang.COC.serviceImpl.GroupServiceImpl;
import org.jiang.COC.serviceImpl.PushInfoServiceImpl;
import org.jiang.COC.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ToUserIndexController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private PushInfoServiceImpl pushInfoServiceImpl;
	@Autowired
	private CommentServiceImpl commentServiceImpl;
	@Autowired
	private GroupServiceImpl groupServiceImpl;
	@Autowired
	private AdviceServiceImpl adviceServiceImpl;
	@Autowired
	private AttentionServiceImpl attentionServiceImpl;


	
	
	@RequestMapping(value="/userIndexTo")
	public ModelAndView indexTo(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		//user对象可能更新过信息，需要重新查询一遍，并且放到session中
		user=userServiceImpl.getByUserId(user.getUserId());
		
		 /**
		  * 设置Ids，查询关注的人和自己的动态
		  */
		 List<Long> userIds=attentionServiceImpl.findToUserIdsByUserId(user.getUserId());//得到关注的人的ID
		 userIds.add(userIds.size(), user.getUserId());//加上自己的ID
		 List<PushInfo> blogs=pushInfoServiceImpl.findByuserIds(userIds,user.getUserId());//根据userIds去找所有动态		  
		 /**
		  * 获得分组信息
		  */
		 List<Group> groups=groupServiceImpl.findGroupsByUserId(user.getUserId());
		 /**
		  * 设置推送关注信息
		  */
		 List<User> pushUsers=userServiceImpl.findPushUsersByIds(userIds);
		 
		 session.setAttribute("user", user);
		 session.setAttribute("blogs", blogs);
		 session.setAttribute("groups", groups);
		 session.setAttribute("pushUsers", pushUsers);
		 ModelAndView mav=new ModelAndView("userIndex");
		 return mav;
	}
	@RequestMapping(value="/userIndexTo2")
	public ModelAndView indexTo2(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		@SuppressWarnings("unchecked")
		List<PushInfo> blogs=(List<PushInfo>) session.getAttribute("blogs");
		//user对象可能更新过信息，需要重新查询一遍，并且放到session中
		user=userServiceImpl.getByUserId(user.getUserId());		
		 /**
		  * 设置Ids，查询关注的人和自己的动态
		  */
		 List<Long> userIds=attentionServiceImpl.findToUserIdsByUserId(user.getUserId());//得到关注的人的ID
		 userIds.add(userIds.size(), user.getUserId());//加上自己的ID		 		  
		 /**
		  * 获得分组信息
		  */
		 List<Group> groups=groupServiceImpl.findGroupsByUserId(user.getUserId());
		 /**
		  * 设置推送关注信息
		  */
		 List<User> pushUsers=userServiceImpl.findPushUsersByIds(userIds);
		 
		 session.setAttribute("user", user);
		 session.setAttribute("groups", groups);
		 session.setAttribute("pushUsers", pushUsers);
		 session.setAttribute("blogs", blogs);
		 ModelAndView mav=new ModelAndView("userIndex");
		 return mav;
	}
		
			
	
	
}
