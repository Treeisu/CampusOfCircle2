package org.jiang.COC.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jiang.COC.common.UploadUtil;
import org.jiang.COC.model.Comment;
import org.jiang.COC.model.PushInfo;
import org.jiang.COC.model.User;
import org.jiang.COC.serviceImpl.CommentServiceImpl;
import org.jiang.COC.serviceImpl.PushInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/blog")
@SessionAttributes(value="blogs")//可以将model中的对象加入到session中
public class PushInfoController {
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
		 blogs=pushInfoServiceImpl.findByuserIds(userIds);
		 session.setAttribute("blogs", blogs);
		 ModelAndView mav=new ModelAndView("userIndex");
		 mav.addObject("blogs", blogs);
		 return mav;
	}
	
	@RequestMapping(value="/push")
	public ModelAndView regist(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,MultipartHttpServletRequest muliRequest,
						@RequestParam("content")String content){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		 //获得上传图片信息字段
		 Iterator<String> iterator = muliRequest.getFileNames();
		 String fileName = iterator.next();
		 MultipartFile file = muliRequest.getFile(fileName);
		 String Imgpath = UploadUtil.uploadFile(file,"/Upload-CoC/img/PushImg");
		 
		 PushInfo pushInfo=new PushInfo();
		 pushInfo.setUserId(user.getUserId());
		 pushInfo.setUserNickName(user.getUserNickName());
		 pushInfo.setWbPushDate(new Date());
		 pushInfo.setWbImage(Imgpath);
		 pushInfo.setWbTextContent(content);	
		 pushInfoServiceImpl.savePushInfo(pushInfo);
		 
		 //进行查询
		 List<Long> userIds=new ArrayList<Long>();
		 userIds.add(0, user.getUserId());
		 List<PushInfo> blogs=new ArrayList<PushInfo>();
		 blogs=pushInfoServiceImpl.findByuserIds(userIds);
		 
		 
		 //进行跳转返回 
		ModelAndView mav=new ModelAndView("redirect:/blog/userIndexTo");
		mav.addObject("blogs", blogs);
		
		
		return mav;
		
	}
	@RequestMapping(value="/del")
	@ResponseBody
	public int delete(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		 String uidstring=request.getParameter("wbId");
		 int sta=0;
		 long uid = Long.parseLong(uidstring);
		 PushInfo push=pushInfoServiceImpl.getPushIfoBywbId(uid);
		 if(push !=null){
			 if(push.getUserId()==user.getUserId()){
				 pushInfoServiceImpl.deleteBywbId(uid);
				 sta=1;
			 }			 
		 }
		 return sta;	
	}
	
	/**
	 * 发表评论
	 */
	@RequestMapping(value="/pushComment")
	@ResponseBody
	public List<Comment> pushComment(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		
		 String wbIdstring=request.getParameter("wbId");
		 long wbId=Long.parseLong(wbIdstring);
		 String commentContent=request.getParameter("commentContent");
		 String byTurn=request.getParameter("byTurn");
		 if(byTurn.equals("true")){
			 //此时要做转发操作；
			 System.out.println("1111111");
		 }
		 Comment comment =new Comment();
		 comment.setCommentContent(commentContent);
		 comment.setCommentDate(new Date());
		 comment.setUserId(user.getUserId());
		 comment.setWbId(wbId);
		 comment.setCommentUser(user);
		 commentServiceImpl.saveComment(comment);
		 
		 List<Comment> comments=new ArrayList<Comment>();
		 comments=commentServiceImpl.findCommentsBywbId(wbId);
		 return comments;		 	
	}
	/**
	 * 获得评论
	 */
	@RequestMapping(value="/getComments")
	@ResponseBody
	public ModelAndView getComments(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		
		 
		 return null;
		 	
	}
	
	
	
	
}