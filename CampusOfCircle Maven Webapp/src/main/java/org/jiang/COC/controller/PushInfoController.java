package org.jiang.COC.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jiang.COC.common.UploadUtil;
import org.jiang.COC.model.CollectionInfo;
import org.jiang.COC.model.Comment;
import org.jiang.COC.model.PraiseInfo;
import org.jiang.COC.model.PushInfo;
import org.jiang.COC.model.User;
import org.jiang.COC.serviceImpl.AttentionServiceImpl;
import org.jiang.COC.serviceImpl.CollectionServiceImpl;
import org.jiang.COC.serviceImpl.CommentServiceImpl;
import org.jiang.COC.serviceImpl.PraiseServiceImpl;
import org.jiang.COC.serviceImpl.PushInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/blog")
//@SessionAttributes(value="blogs")//可以将model中的对象加入到session中
public class PushInfoController {
	@Autowired
	private PushInfoServiceImpl pushInfoServiceImpl;
	@Autowired
	private CommentServiceImpl commentServiceImpl;
	@Autowired
	private PraiseServiceImpl praiseServiceImpl;
	@Autowired
	private CollectionServiceImpl collectionServiceImpl;
	@Autowired
	private AttentionServiceImpl attentionServiceImpl;
		
	@RequestMapping(value="/push")
	public ModelAndView savepushInfo(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,MultipartHttpServletRequest muliRequest,
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
		 blogs=pushInfoServiceImpl.findByuserIds(userIds,user.getUserId());
	 
		 //进行跳转返回 
		ModelAndView mav=new ModelAndView("redirect:/userIndexTo");
		mav.addObject("blogs", blogs);				
		return mav;		
	}
	@RequestMapping(value="/push2")
	public ModelAndView savepushInfo2(ModelMap modelMap,HttpServletRequest request,HttpServletResponse response,
						@RequestParam("content")String content,
						@RequestParam("authorWbId")String authorWebIdstr){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		 
		 PushInfo pushInfo=new PushInfo();
		 //设值
		 pushInfo.setUserId(user.getUserId());
		 pushInfo.setUserNickName(user.getUserNickName());
		 pushInfo.setWbPushDate(new Date());
		 //页面上的信息
		 long authorWebId=Long.parseLong(authorWebIdstr);
		 pushInfo.setWbAuthorId(authorWebId);
		 pushInfo.setWbTextContent(content);
		 pushInfoServiceImpl.savePushInfo(pushInfo);
		 
		 //进行查询
		 List<Long> userIds=new ArrayList<Long>();
		 userIds.add(0, user.getUserId());
		 List<PushInfo> blogs=new ArrayList<PushInfo>();
		 blogs=pushInfoServiceImpl.findByuserIds(userIds,user.getUserId());

		 //进行跳转返回 
		ModelAndView mav=new ModelAndView("redirect:/userIndexTo");
		mav.addObject("blogs", blogs);
	
		return mav;
		
	}
	@RequestMapping(value="/getGroupBlogs")
	@ResponseBody
	public int getPushInfogGroup(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		 String groupIdstring=request.getParameter("groupId");
		 int sta=0;
		 long groupId= Long.parseLong(groupIdstring);
		 if(groupId==-1){			 
			 sta=0;
			 return sta;
		 }else{
			 if(groupId==0){
				 List<Long> toUserIds=attentionServiceImpl.findByNoGroupId(groupId, user.getUserId());
				 if(toUserIds.size()>0){
					 List<PushInfo> blogs= pushInfoServiceImpl.findByuserIds(toUserIds, user.getUserId());
					 session.setAttribute("blogs",blogs);
					 sta=1;
					 return sta;
				 }else {
					 List<PushInfo> blogs=null;
					 session.setAttribute("blogs",blogs);
					 sta=1;
					 return sta;
				}
						 				 
			 }
			 else{
				 List<Long> toUserIds=attentionServiceImpl.findAttentionsByGroupId(groupId);
				 if(toUserIds.size()>=0){
					 List<PushInfo> blogs= pushInfoServiceImpl.findByuserIds(toUserIds, user.getUserId());					 			 
					 session.setAttribute("blogs", blogs);
					 sta=1;
					 return sta;					 
				 }else{
					 List<PushInfo> blogs=null;
					 session.setAttribute("blogs",blogs);
					 sta=1;
					 return sta;
				 }
			 }
		 }	 
	}
	
	
	@RequestMapping(value="/del")
	@ResponseBody
	public int delete(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		 String uidstring=request.getParameter("wbId");
		 int sta=0;
		 long wbId = Long.parseLong(uidstring);
		 PushInfo push=pushInfoServiceImpl.getPushIfoBywbId(user.getUserId(),wbId);
		 if(push !=null){
			 if(push.getUserId()==user.getUserId()){
				 pushInfoServiceImpl.deleteBywbId(wbId);
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
	 * 发表评论2
	 */
	@RequestMapping(value="/pushComment2")
	@ResponseBody
	public Comment pushComment2(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		
		 String wbIdstring=request.getParameter("wbId");
		 long wbId=Long.parseLong(wbIdstring);
		 String fromcommentIdstring=request.getParameter("fromcommentId");
		 long fromCommentId=Long.parseLong(fromcommentIdstring);		 
		 String commentContent=request.getParameter("commentContent");
		 
		 Comment comment =new Comment();
		 comment.setCommentContent(commentContent);
		 comment.setCommentDate(new Date());
		 comment.setUserId(user.getUserId());
		 comment.setWbId(wbId);
		 comment.setFromCommentId(fromCommentId);
		 comment.setCommentUser(user);
		 commentServiceImpl.saveComment(comment);
		 return comment;		 	
	}
	
	/**
	 * 获得评论
	 */
	@RequestMapping(value="/getComments")
	@ResponseBody
	public List<Comment> getComments(HttpServletRequest request,HttpServletResponse response){
		 		 
		 List<Comment> comments=new ArrayList<Comment>();
		 String wbIdstring=request.getParameter("wbId");
		 long wbId=Long.parseLong(wbIdstring);
		 comments=commentServiceImpl.findCommentsBywbId(wbId);		 
		 return comments;		 	
	}
	/**
	 * 删除评论
	 */
	@RequestMapping(value="/delComment")
	@ResponseBody
	public int deleteComment(HttpServletRequest request,HttpServletResponse response){
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		int sta=0;
		String commentIdstring=request.getParameter("commentId");
		long commentId=Long.parseLong(commentIdstring);
		String wbIdstring=request.getParameter("wbId");
		long wbId=Long.parseLong(wbIdstring);
		Comment comment=commentServiceImpl.getCommentBycommentId(commentId);	
		if(comment !=null&&comment.getUserId()==user.getUserId()){
			commentServiceImpl.deleteComment(commentId);
			PushInfo info= pushInfoServiceImpl.getPushIfoBywbId(user.getUserId(), wbId);
			sta=(int) info.getCommentNum();
			return sta;
		}
		return sta;					
	}
	/**
	 * 点赞保存
	 */
	@RequestMapping(value="/savePraise")
	@ResponseBody
	public int savePraise(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		
		 String wbIdstring=request.getParameter("wbId");
		 long wbId=Long.parseLong(wbIdstring);
		 PraiseInfo praiseInfo=new PraiseInfo();
		 praiseInfo.setPraiseDate(new Date());
		 praiseInfo.setUserId(user.getUserId());
		 praiseInfo.setWbId(wbId);
		 praiseServiceImpl.savePraise(praiseInfo);
		 return 1;		 	
	}
	/**
	 * 点赞删除
	 */
	@RequestMapping(value="/cancelPraise")
	@ResponseBody
	public int cancelPraise(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		 String wbIdstring=request.getParameter("wbId");
		 long wbId=Long.parseLong(wbIdstring);		 
		 praiseServiceImpl.deletePraise(user.getUserId(), wbId);
		 return 1;		 	
	}
	/**
	 * 收藏保存
	 */
	@RequestMapping(value="/saveCollection")
	@ResponseBody
	public int saveCollection(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		
		 String wbIdstring=request.getParameter("wbId");
		 long wbId=Long.parseLong(wbIdstring);
		 CollectionInfo collectionInfo=new CollectionInfo();
		 collectionInfo.setCollectionDate(new Date());
		 collectionInfo.setUserId(user.getUserId());
		 collectionInfo.setWbId(wbId);
		 collectionServiceImpl.saveCollection(collectionInfo);
		 return 1;		 	
	}
	/**
	 * 收藏删除
	 */
	@RequestMapping(value="/cancelCollection")
	@ResponseBody
	public int cancelCollection(HttpServletRequest request,HttpServletResponse response){
		 HttpSession session=request.getSession();
		 User user=(User) session.getAttribute("user");
		 String wbIdstring=request.getParameter("wbId");
		 long wbId=Long.parseLong(wbIdstring);		 
		 collectionServiceImpl.deleteCollection(user.getUserId(), wbId);
		 return 1;		 	
	}
	
	
	
	
	
	
	
	
	
	
	
}
