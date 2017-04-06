package org.jiang.COC.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jiang.COC.model.User;
import org.jiang.COC.serviceImpl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	public String regist(ModelMap model,HttpServletRequest request,HttpServletResponse response,
						@RequestParam("userNickName")String userNickName,
						@RequestParam("password")String userPassword,
						@RequestParam("password2")String userPassword2,
						@RequestParam("userPhone")String userPhone){
		User user=new User();
		user.setUserNickName(userNickName);
		user.setUserPassword(userPassword2);
		user.setUserPhone(userPhone);
		Date date=new Date();
		user.setUserRegisterDate(date);
		List<User> list=userserviceImpl.findUserByPhone(user.getUserPhone());
		if(list.size()==0){
			userserviceImpl.saveUser(user);
			model.addAttribute("user",user);//相当于request.setAttribute();
			return "login";
		}else{
			String msg="该号码已经注册";
			return msg;
		}	
	}
	@RequestMapping(value="/log")
	public String login(ModelMap model,HttpServletRequest request,HttpServletResponse response,
						@RequestParam("logpassworld")String userPassword,
						@RequestParam("loguserPhone")String userPhone){
		User u=new User();
		List<User> list=userserviceImpl.findUserByPhone(userPhone);
		if(list.size()==0){
			String msg="该账号未注册，请先注册后登录！";
			model.addAttribute("msg",msg);
			return "login";
		}else{
			u=list.get(0);
			if(u.getUserPassword().equals(userPassword)){
				model.addAttribute("user",u);//相当于request.setAttribute();				
				return "userIndex";	
			}
			else{
				String msg="密码输入错误,请核对密码";
				model.addAttribute("msg",msg);
				return "login";
			}
		}
		
		
	}
	
	/**
	 * 前台ajax传过来的数据，根据phone查找用户是否存在
	 * @param model
	 * @param userPassword
	 * @param userPhone
	 */
	@RequestMapping(value="/phone")//指定返回数据的编码
	@ResponseBody()
	public List<User> Phones(HttpServletRequest request,HttpServletResponse response ){
		String userPhone=request.getParameter("userPhone");
		List<User> userList=new ArrayList<User>();	
		userList=userserviceImpl.findUserByPhone(userPhone);
		
		return userList;	
	}
	
}
