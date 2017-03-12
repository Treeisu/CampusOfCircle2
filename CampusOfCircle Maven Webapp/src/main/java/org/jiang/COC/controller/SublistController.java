package org.jiang.COC.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.jiang.COC.common.Constant;
import org.jiang.COC.common.Page;
import org.jiang.COC.common.StringUtil;
import org.jiang.COC.model.Student;
import org.jiang.COC.serviceImpl.SublistStudentServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/sublist")
public class SublistController{
	private static Logger logger = LoggerFactory.getLogger(SublistController.class);
	@Autowired
	private SublistStudentServiceImpl studentService;
	@Resource
	private HttpServletRequest request;
//	@RequestMapping(value="/SublistServlet",method=RequestMethod.GET)
//	public void findList2(@RequestParam("stuName")String stuName,
//							@RequestParam("gender")String genderStr,
//							@RequestParam("pageNum")String pageNumStr) throws ServletException, IOException{
//		this.findList(stuName, genderStr, pageNumStr);
//	}
	@RequestMapping(value="/SublistServlet",method={RequestMethod.POST,RequestMethod.GET})
	public String findList(){

		String stuName=request.getParameter("stu_Name");
		String genderStr=request.getParameter("gender");
		String pageNumStr=request.getParameter("pageNum");
		int gender = Constant.DEFAULT_GENDER;
		if(genderStr!=null && !"".equals(genderStr.trim())){
			gender = Integer.parseInt(genderStr);
		}
		if(pageNumStr !=null && !StringUtil.isNum(pageNumStr)){
			request.setAttribute("errorMsg", "参数传输错误");
//			request.getRequestDispatcher("/WEB-INF/jsp/sublistStudent.jsp").forward(request, response);
			return "sublistStudent";
		} 
		int currentPage = Constant.DEFAULT_PAGE_NUM; //显示第几页数据
		if(pageNumStr!=null && !"".equals(pageNumStr.trim())){
			currentPage = Integer.parseInt(pageNumStr);
		}
		
		int pageSize = Constant.DEFAULT_PAGE_SIZE;  // 每页显示多少条记录
		String pageSizeStr = request.getParameter("pageSize");
		if(pageSizeStr!=null && !"".equals(pageSizeStr.trim())){
			pageSize = Integer.parseInt(pageSizeStr);
		}
		// 组装查询条件
		Student searchModel=new Student();
		searchModel.setStuName(stuName);
		searchModel.setGender(gender);	
		//调用service 获取查询结果
//		studentService=new SublistStudentServiceImpl();
		Page<Student> result=new Page<Student>();
		result = studentService.findStudent(searchModel,currentPage,pageSize);
		// 返回结果到页面
		request.setAttribute("result", result);
		request.setAttribute("stuName", stuName);
		request.setAttribute("gender", gender);
//		request.getRequestDispatcher("/WEB-INF/jsp/sublistStudent.jsp").forward(request, response);
		logger.debug("TEST");
		return "sublistStudent";
		
	}
	
}



