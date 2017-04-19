package org.jiang.COC.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;







import org.jiang.COC.model.Group;
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
public class ToUserAttentionController {
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


	
	
	@RequestMapping(value="/userAttentionTo")
	public ModelAndView indexTo(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		//user对象可能更新过信息，需要重新查询一遍，并且放到session中
		user=userServiceImpl.getByUserId(user.getUserId());		
		 /**
		  * 获得分组信息
		  */
		 List<Group> groups=groupServiceImpl.findGroupsByUserId(user.getUserId());
		 /**
		  * 获得关注的用户
		  */
		 List<Long> toUserIds=attentionServiceImpl.findToUserIdsByUserId(user.getUserId());		
		 if(toUserIds.size()>0){
			 List<User> attentionUsers=userServiceImpl.findUsersByIds(toUserIds);
			 session.setAttribute("attentionUsers", attentionUsers);
		 }
		 else{
			 List<User> attentionUsers=null;
			 session.setAttribute("attentionUsers", attentionUsers);
		 }
		 session.setAttribute("user", user);
		 session.setAttribute("groups", groups);
		 ModelAndView mav=new ModelAndView("AttentionANDFans");
		 return mav;
	}

}
