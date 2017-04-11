package org.jiang.COC.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.jiang.COC.serviceImpl.CommentServiceImpl;
import org.jiang.COC.serviceImpl.PushInfoServiceImpl;
import org.jiang.COC.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(value="blogs")//可以将model中的对象加入到session中
public class ToIndexController {
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private PushInfoServiceImpl pushInfoServiceImpl;
	@Autowired
	private CommentServiceImpl commentServiceImpl;
	@RequestMapping(value="/indexTo")
	public String indexTo(HttpServletRequest request,HttpServletResponse response){
		request.getSession().invalidate();
		return "../index";
	}		
}
