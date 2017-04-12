package org.jiang.COC.controller;

import java.util.ArrayList;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.jiang.COC.model.PushInfo;
import org.jiang.COC.model.User;
import org.jiang.COC.serviceImpl.CommentServiceImpl;
import org.jiang.COC.serviceImpl.PushInfoServiceImpl;
import org.jiang.COC.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(value="blogs")//可以将model中的对象加入到session中
public class ToUserIndexController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private PushInfoServiceImpl pushInfoServiceImpl;
	@Autowired
	private CommentServiceImpl commentServiceImpl;
	@RequestMapping(value="/userIndexTo")
	public ModelAndView indexTo(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user"); 
		List<Long> userIds=new ArrayList<Long>();
		 userIds.add(0, user.getUserId());
		 List<PushInfo> blogs=new ArrayList<PushInfo>();
		 blogs=pushInfoServiceImpl.findByuserIds(userIds,user.getUserId());
		 session.setAttribute("blogs", blogs);
		 ModelAndView mav=new ModelAndView("userIndex");
		 mav.addObject("blogs", blogs);
		 return mav;
	}		
}
