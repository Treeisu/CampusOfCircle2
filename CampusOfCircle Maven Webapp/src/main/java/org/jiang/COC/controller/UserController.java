package org.jiang.COC.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jiang.COC.common.UploadUtil;
import org.jiang.COC.model.User;
import org.jiang.COC.serviceImpl.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * 用户请求有关的表
 * @author cherry
 *
 */
@Controller
@RequestMapping(value="/user")
//@SessionAttributes(value="user")//可以将model中的对象加入到session中
public class UserController {
	//private static Logger logger = LoggerFactory.getLogger(SublistController.class);
	@Autowired
	private UserServiceImpl userserviceImpl;
	
	@RequestMapping(value="/reg")
	public String regist(HttpServletRequest request,HttpServletResponse response,
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
			
			HttpSession session=request.getSession();
			session.setAttribute("user", user);
			request.setAttribute("user",user);//相当于request.setAttribute();
			return "redirect:/userIndexTo";
		}else{
			return "login";
		}	
	}
	@RequestMapping(value="/log")
	public String login(HttpServletRequest request,HttpServletResponse response,
						@RequestParam("logpassworld")String userPassword,
						@RequestParam("loguserPhone")String userPhone){
		User u=new User();
		List<User> list=userserviceImpl.findUserByPhone(userPhone);
		if(list.size()==0){
			String msg="该账号未注册，请先注册后登录！";
			request.setAttribute("msg",msg);
			return "login";
		}else{
			u=list.get(0);
			if(u.getUserPassword().equals(userPassword)){
				request.setAttribute("user",u);//相当于request.setAttribute();				
				HttpSession session=request.getSession();
				session.setAttribute("user", u);								
				return "redirect:/userIndexTo";	//让他重新去做一个请求
			}
			else{
				String msg="密码输入错误,请核对密码";
				request.setAttribute("msg",msg);
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
	@RequestMapping(value="/basicChange")
	public String basicChange(HttpServletRequest request,HttpServletResponse response,
						@RequestParam("nickname")String userNickName,
						@RequestParam("email")String userEmail,
						@RequestParam("province")String province,
						@RequestParam("city")String city,
						@RequestParam("sex")int userSex,
						@RequestParam("school")String userSchool,
						@RequestParam("major")String userMajor,
						@RequestParam("uclass")String userClass,
						@RequestParam("intro")String userDescription){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");		 
		String userAddress=province+" "+city;
		user.setUserNickName(userNickName);
		user.setUserEmail(userEmail);
		user.setUserAddress(userAddress);
		user.setUserSchool(userSchool);
		user.setUserMajor(userMajor);
		user.setUserClass(userClass);
		user.setUserDescription(userDescription);
		user.setUserSex(userSex);
		userserviceImpl.updateUser(user);		
		
		
		session.setAttribute("user", user);
		return "redirect:/userIndexTo";		
	}
	@RequestMapping(value="/faceChange")
	public String faceChange(HttpServletRequest request,HttpServletResponse response,MultipartHttpServletRequest muliRequest){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		 
		 Iterator<String> iterator = muliRequest.getFileNames();
		 String fileName = iterator.next();
		 MultipartFile file = muliRequest.getFile(fileName);
		 String Imgpath = UploadUtil.uploadFile(file,"/Upload-CoC/img/HeadImg");
		 
		 
		 user.setUserImage(Imgpath);		 
		 userserviceImpl.updateUser(user);		
		
		session.setAttribute("user", user);
		return "redirect:/userIndexTo";		
	}
	
	@RequestMapping(value="/pwdChange")
	@ResponseBody()
	public int pwdChange(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		 String pwd1=request.getParameter("pwd1");
		 String pwd3=request.getParameter("pwd3");
		 System.out.println(pwd1+","+pwd3);
		 if(!pwd1.equals(user.getUserPassword())){ 
			 return 0;
		 }else{
			 user.setUserPassword(pwd3);
			 userserviceImpl.updateUser(user);
			 
			 session.setAttribute("user", user);
			 return 1;	
		 }

	}
	@RequestMapping(value="/exit")
	public String exitUser(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		 if(user !=null){
			 session.removeAttribute("user");
			 request.removeAttribute("user");
		 }
		 return "redirect:/indexTo";
	}
	
	
	
}
