package org.jiang.COC.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jiang.COC.model.User;
import org.jiang.COC.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * 用户请求有关的表
 * @author cherry
 *
 */
@Controller
@RequestMapping(value="/user")
@SessionAttributes(value="user")//可以将model中的对象加入到session中
public class UserController {
	//private static Logger logger = LoggerFactory.getLogger(SublistController.class);
	@Autowired
	private UserServiceImpl userserviceImpl;
	@Resource
	private HttpServletRequest httpServletRequest;

	@RequestMapping(value="/reg")

	public String regist(ModelMap model,
						@RequestParam("userNickName")String userNickName,
						@RequestParam("password2")String userPassword2,
						@RequestParam("userPhone")String userPhone){
		User user=new User();
		user.setUserNickName(userNickName);
		user.setUserPassword(userPassword2);
		user.setUserPhone(userPhone);
		userserviceImpl.saveUser(user);
		
		model.addAttribute("user",user);//相当于request.setAttribute();
		return "login";
	}
	@RequestMapping(value="/log")
	public String login(ModelMap model,
						@RequestParam("logpassworld")String userPassword,
						@RequestParam("loguserPhone")String userPhone){
		User user=new User();
		user=userserviceImpl.findUserByPhone(userPhone);
		
		
		model.addAttribute("user",user);//相当于request.setAttribute();
		return "index";
		
	}
	
}
