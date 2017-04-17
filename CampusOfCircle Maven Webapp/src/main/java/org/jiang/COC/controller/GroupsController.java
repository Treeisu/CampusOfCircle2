package org.jiang.COC.controller;


import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.jiang.COC.model.Group;
import org.jiang.COC.model.User;
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
@RequestMapping(value="/group")
public class GroupsController {
	//private static Logger logger = LoggerFactory.getLogger(SublistController.class);
	@Autowired
	private GroupServiceImpl groupServiceImpl;
	
	@RequestMapping(value="/saveGroup")
	@ResponseBody
	public List<Group> saveGroup(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		String groupName=request.getParameter("groupName");
		String userIdstring=request.getParameter("userId");
		long userId=Long.parseLong(userIdstring);
		Group group =new Group();
		group.setCreateDate(new Date());
		group.setGroupName(groupName);
		group.setUserId(userId);
		groupServiceImpl.saveGroup(group);
		List<Group> groups=groupServiceImpl.findGroupsByUserId(user.getUserId());
		return groups;		
	}
	@RequestMapping(value="/getGroup")
	@ResponseBody
	public List<Group> getGroup(HttpServletRequest request,HttpServletResponse response){
		String userIdstring=request.getParameter("userId");
		long userId=Long.parseLong(userIdstring);
		List<Group> groups=groupServiceImpl.findGroupsByUserId(userId);
		return groups;		
	}
	
	
}
