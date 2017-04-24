package org.jiang.COC.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jiang.COC.model.Message;
import org.jiang.COC.serviceImpl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author cherry
 *
 */
@Controller
@RequestMapping(value="/message")
public class MessageController {
	//private static Logger logger = LoggerFactory.getLogger(SublistController.class);
	
	@Autowired
	private MessageServiceImpl messageServiceImpl;
	
	@RequestMapping(value="/getMessage")
	@ResponseBody
	public int saveAttention(HttpServletRequest request,HttpServletResponse response){		
		String userIdstring=request.getParameter("userId");
		long userId=Long.parseLong(userIdstring);
		List<Message> messages=messageServiceImpl.findByMyUserId(userId);
		if(messages.size()>0){
			request.getSession().setAttribute("messages", messages);
			return 1;
		}else{
			messages=null;
			return 1;
		}
					
	}
	
	
	
	
}
