<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>CampusOfCircle-个人设置</title> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="css/common/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link type="text/css" rel="stylesheet" href="css/index_common.css">
    <link type="text/css" rel="stylesheet" href="css/index_modal.css">
    <link type="text/css" rel="stylesheet" href="css/index_body.css">
    <link type="text/css" rel="stylesheet" href="css/userseting.css">
  </head>
  
<body>
<!--头部导航栏设置start-->
<nav class="navbar navbar-default navbar-fixed-top" role="navigation" id="menu-nav">
    <div class="container">
    	<!--小屏幕状态隐藏导航栏-->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#head_mycollapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="jsp/userIndex.jsp" style="font-weight: 1000;"><i class="logo"></i></a>
        </div>
        <div class="navbar-collapse collapse" id="head_mycollapse">
            <ul class="nav navbar-nav" id="head_mycollapse_ul">
                <li class=" one"><i class="ui-center"></i><a href="/CampusOfCircle/jsp/userSingle.jsp">个人圈</a></li>
                <li class="two"><i class="ui-home"></i><a href="/CampusOfCircle/userIndexTo">校园圈</a></li>
                <li class="three"><i class="ui-friends"></i><a href="/CampusOfCircle/jsp/userSingle.jsp">消息</a></li>
                <li class="five"><i class="ui-dress"></i><a href="#setTheme_modal" data-toggle="modal">主题</a></li>
                <li class="six"><i class="ui-music"></i><a href="#" class="music-active"></a></li>
                <li class="seven"> <input type="text" class="form-control" placeholder="搜索用户/动态/校园"><span class="search"></span></li>
                <li id="li_user_dropdown" class="eight">
                	<img src="<c:out value="${user.userImage}"/>" alt="" style="width:32px;height:32px">
                	<a id="li_a_dropdown" ><c:out value="${user.userNickName}"/>&nbsp;<span class="caret"></span></a>
                	<p id="userId_navbar" style="display:none"><c:out value="${user.userId}"/></p>
                	<ul class="dropdown-menu pull-right">
                		<li><a href="jsp/userSetting.jsp">账号设置</a></li>
                		<li class="divider"></li>
                		<li><a href="#setTheme_modal" data-toggle="modal">模板设置</a></li>
                		<li class="divider"></li>
                		<li><a href="">退出登录</a></li>
                	</ul>
                </li>
               	 <!--信息推送-->
                <li id='head_li_news' class='hidden'>
                    <i class='icon icon-news'></i>
                    <ul>
                        <li class='news_comment hidden'><a href=""></a></li>
                        <li class='news_letter hidden'><a href=""></a></li>
                        <li class='news_atme hidden'><a href=""></a></li>
                    </ul>
                </li>
                <!--信息推送-->
            </ul>
        </div>
    </div>
</nav>
<!--头部导航栏设置end-->

<!--==============================================主体左/中/右设计部分===============================================================================-->
<div class="main">
	<!--=====左侧栏=====-->
	<div id="left" class='fleft' style="opacity: 0.6;margin-top: -20px;">
       <div id="left_nav_a" class=' list-group'>
            <a href="/CampusOfCircle/userIndexTo" class="list-group-item active" ><i class='icon icon-home'></i>&nbsp;&nbsp;首页</a>
            <c:if test="${user.userAdviceNum.sumNum>0}"><a href="" class="list-group-item" ><i class='icon icon-comment messageLeftList'></i>&nbsp;&nbsp;消息<span class="badge" style="color: red;background-color: #C9EBF4;"><c:out value="${user.userAdviceNum.sumNum}"/></span></a></c:if>
<<<<<<< HEAD
            <c:if test="${user.userAdviceNum.sumNum==0}"><a href="" class="list-group-item" ><i class='icon icon-comment messageLeftList'></i>&nbsp;&nbsp;消息</a></c:if>          
            <a href="" class="list-group-item" ><i class='icon icon-keep'></i>&nbsp;&nbsp;收藏</a>
=======
            <c:if test="${user.userAdviceNum.sumNum==0}"><a href="" class="list-group-item" ><i class='icon icon-comment messageLeftList'></i>&nbsp;&nbsp;消息</a></c:if>
            <a href="" class="list-group-item collectionLeftList" ><i class='icon icon-keep'></i>&nbsp;&nbsp;收藏</a>
>>>>>>> branch 'master' of https://github.com/Treeisu/CampusOfCircle.git
        </div>
        <div class="group">
            <fieldset><legend style="color: #8B8B85; font-weight: 300;text-align: center;">我的分组</legend></fieldset>
            <div id="left_nav_b" class="list-group">
                <a href="" class="list-group-item "><span style="display: none;">-1</span><i class='icon icon-group'></i>&nbsp;&nbsp;我的</a>
                <c:if test="${groups.size()>0}">
                		<a href="" class="list-group-item list_group_a"><span style="display: none;">0</span><i class='icon icon-group'></i>&nbsp;&nbsp;默认分组</a>
                		<c:forEach var="group" items="${groups}">
                        <a href="" class="list-group-item list_group_a"><span style="display: none;"><c:out value="${group.groupId}"/></span><i class='icon icon-group'></i>&nbsp;&nbsp;<c:out value="${group.groupName}"/></a>
                		</c:forEach>
                </c:if>
                <c:if test="${groups.size()==0}">                
                        <a href="" class="list-group-item list_group_a"><span style="display: none;">0</span><i class='icon icon-group'></i>&nbsp;&nbsp;默认分组</a>
                </c:if>
                <a id='create_group' class="btn btn-group" href="#creat_group_modal"  data-toggle="modal">创建新分组</a>
                <a id='delete_group' class="btn btn-group">删除分组</a>
            </div>
            
        </div>
    </div>
	<!--=====左侧栏=====-->
	
	<!--=====右边+中间=====-->
	<div id="rightUser">
		<ul id='sel-edit' >
    		<li class='edit-cur'>基本信息</li>
    		<li class="imgupload">修改头像</li>
    		<li>修改密码</li>
    	</ul>
		<!--基本信息修改-->
		<div class='form'>
			<form action="user/basicChange" method='post' >
				<div>
    				<label for=""><span>*</span>昵称：</label>
    				<input type="text" name='nickname' value='<c:out value="${user.userNickName}"/>' class='input'/>
    			</div>
    			<div>
    				<label for=""><span>*</span>邮箱：</label>
    				<input type="text" name='email' value='<c:out value="${user.userEmail}"/>' class='input'/>
    			</div>
    			<div id="sex_div">
    				<p id="usersex_p" style="display:none"><c:out value="${user.userSex}"/></p>
	    			<label for="">性别：</label>
	    			<div class="btn-group btn-group-xs" data-toggle="buttons">
		    			<label class="btn btn-info"><input type="radio" name='sex' value='1' />&nbsp;男</label>
		    			<label class="btn btn-danger"><input type="radio" name='sex' value='2' />&nbsp;女</label>
		    		</div>
    			</div>
    			<div>
    				<p id="userAdd" style="display:none"><c:out value="${user.userAddress}"/></p>
    				<label for=""><span >*</span>所在地：</label>
    				<select name="province" id="">
    					<option value="">请选择</option>
    				</select>&nbsp;&nbsp;&nbsp;&nbsp;
                    <select name="city">
                        <option value="">请选择</option>
                    </select>
    			</div>
    			<div>
    				<label for=""><span>*</span>学校：</label>
    				<input type="text" name='school' value='<c:out value="${user.userSchool}"/>' class='input'/>
    				<br />
    				<label for="">专业：</label>
    				<input type="text" name='major' value='<c:out value="${user.userMajor}"/>' class='input'/>
    				<br />
    				<label for="">班级：</label>
    				<input type="text" name='uclass' value='<c:out value="${user.userClass}"/>' class='input'/>
    			</div>
    			<div>
    				<label for="" class='intro'>介绍自己：</label>
    				<textarea name="intro" ><c:out value="${user.userDescription}"/></textarea>
    			</div>
    			<div>
    				<input type="submit" value='保存修改' class='edit-sub btn btn-success'/>
    			</div>
			</form>
		</div>
		<!--基本信息修改-->
		<!--头像修改-->
		<div class='form' style="display: none;">
			<form action="user/faceChange" method="post" enctype="multipart/form-data">
				<div class='edit-face'>
	    				<img src="<c:out value="${user.userImage}"/>" width='180' height='180' id='face-img'/>
	    				<div>
	    					<label class="btn btn-warning" style="width: 80px; height: 30px;" id="">本地上传<input type="file" name='face' id='faceupload' style="opacity: 0;"/></label>
	    				</div>
	    				<div>
    						<input type="submit" value='保存修改' class='edit-sub btn btn-success' style="margin-left: 0px;"/>
    					</div>
	    			</div>
			</form>
		</div>
		<!--头像修改-->
		<!--密码修改-->
		<div class='form' style="display: none;">
			<form action="" method='post' name='editPwd' id='pwdform'>
				<div class='account'>登录手机：<span>15576768878</span></div>
				<div>
    				<label for=""><span class='red'>*</span>旧密码：</label>
    				<input type="password" name='pwd1' class='input' id="pwd1" value=''/>
    			</div>
    			<div>
    				<label for=""><span class='red'>*</span>新密码：</label>
    				<input type="password" name='pwd2' class='input' id='pwd2' value=''/>
    			</div>
    			<div>
    				<label for=""><span class='red'>*</span>确认密码：</label>
    				<input type="password" name='pwd3' class='input' id="pwd3" value=''/>
    			</div>
    			<div>
    				<input type="button" value='保存修改' class='edit-sub btn btn-success' id="changepwd"/>
    			</div>
			</form>
		</div>
		<!--密码修改-->	
	</div>
	<!--=====右中=====-->
	
	
	


</div>








<!--==========加关注弹出框===已完成=======-->
    <div class="modal fade" id="attention_modal" >
		<div class="modal-dialog ">
			<form >
			<div class="modal-content" style="background-color: #f2f7f8;">
				 <div class="modal-header">
				 	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only close"></span></button>
				 	<h4 class="modal-title">关注圈子好友</h4>
				 </div>
				 <div class="modal-body form-inline">
				 	<span style="font-weight: 300;"><b>好友分组：</b></span>
				 	<select class="form-control" style="width: 200px;"></select>
				 </div>
			   	 <div class="modal-footer">
			   	 	<input type="submit" class="btn btn-success" value="关注"/>
			   	 	<button class="btn btn-default" data-dismiss="modal">取消</button>
			   	 </div>
			</div>
			</form>
		</div>
	</div>
<!--==========加关注弹出框====已完成======-->
<!--==========主题设置弹框==========-->
    <div class="modal fade" id="setTheme_modal" >
		<div class="modal-dialog ">
			<form >
			<div class="modal-content" style="background-color: #f2f7f8;">
				 <div class="modal-header">
				 	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only close"></span></button>
				 	<h5 class="modal-title">个性化主题设置</h4>
				 </div>
				 <div class="modal-body">
				 	<div class="">
				 		<img src="img/pictureStyle/CoCBackground2.jpg" style="width: 120px;height: 70px;"></img>
				 		<img src="img/pictureStyle/CoCBackground3.jpg" style="width: 120px;height: 70px;"></img>
				 	</div>
				 </div>
			   	 <div class="modal-footer">
			   	 	<input type="submit" class="btn btn-success" value="关注"/>
			   	 	<button class="btn btn-default" data-dismiss="modal">取消</button>
			   	 </div>
			</div>
			</form>
		</div>
	</div>
<!--==========主题设置弹框==========-->
<!--==========创建分组弹框=====已完成=====-->
<div class="modal fade" id="creat_group_modal" >
		<div class="modal-dialog ">
			<form>
			<div class="modal-content"style="background-color: #E9F4F6;">
				 <div class="modal-header">
				 	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only close"></span></button>
				 	<h4 class="modal-title">创建分组</h4>
				 </div>
				 <div class="modal-body form-inline">
				 	<span style="font-weight: 400;"><b>分组名称：</b></span>
				 	<input type="text" name='name' id='gp-name' class="form-control" style="width: 280px;"/>
				 	<span>例如：老师、同学、校友</span>
				 </div>
			   	 <div class="modal-footer">
			   	 	<input type="submit" class="btn btn-success" value="创建"/>
			   	 	<button class="btn btn-default" data-dismiss="modal">取消</button>
			   	 </div>
			</div>
			</form>
		</div>
</div>
 <!--==========创建分组弹框====已完成======-->

 <!--==========删除分组弹框=====已完成=====-->
<div class="modal fade" id="delete_group_modal">
		<div class="modal-dialog ">
			<form>
			<div class="modal-content"style="background-color:#f2f7f8;">
				 <div class="modal-header">
				 	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only close"></span></button>
				 	<h5 class="modal-title text-center text-danger" >请选择需要删除的分组</h4>
				 </div>
				 <div class="modal-body form-inline">
				 	<span style="font-weight: 300;"><b>好友分组：</b></span>
				 	<select class="form-control" style="width: 200px;"></select>
				 </div>
			   	 <div class="modal-footer">
			   	 	<input type="submit" class="btn btn-danger" value="删除"/>
			   	 	<button class="btn btn-default" data-dismiss="modal">取消</button>
			   	 </div>
			</div>
			</form>
		</div>
</div>
 <!--==========删除分组弹框====已完成======-->
<!--==========删除弹框=====已完成=====-->
<div class="modal fade" id="delete_modal" >
		<div class="modal-dialog ">
			
			<div class="modal-content"style="background-color: lightgray;">
				 <div class="modal-header">
				 	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only close"></span></button>
				 	<h4 class="modal-title text-center">确定删除此动态？</h4>
				 </div>
				 <div class="modal-body">
				 	<h5 class="username text-left"></h5>
				 	<p ></p>
				 </div>
			   	 <div class="modal-footer">
			   	 	<button class="btn btn-danger" data-dismiss="modal">删除</button>
			   	 	<button class="btn btn-default" data-dismiss="modal">取消</button>
			   	 </div>
			</div>
			
		</div>
</div>
 <!--==========删除弹框====已完成======-->
 <!--==========删除评论弹框=====已完成=====-->
<div class="modal fade" id="deleteComment_modal" >
		<div class="modal-dialog ">
			
			<div class="modal-content"style="background-color: lightgray;">
				 <div class="modal-header">
				 	<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only close"></span></button>
				 	<h4 class="modal-title text-center">确定删除此评论？</h4>
				 </div>
				 <div class="modal-body">
				 	<h5 class="username text-left"></h5>
				 	<p ></p>
				 </div>
			   	 <div class="modal-footer">
			   	 	<button class="btn btn-danger" data-dismiss="modal">删除</button>
			   	 	<button class="btn btn-default" data-dismiss="modal">取消</button>
			   	 </div>
			</div>
			
		</div>
</div>
 <!--==========删除评论弹框====已完成======-->
 <!--==========收藏弹框=====已完成=====-->
<div class="modal fade" id="collection_modal" >
		<div class="modal-dialog ">
			<div class=" alert alert-success">
				 <h4 class="text-center"></h4>
			</div>
		</div>
</div>
 <!--==========收藏弹框====已完成======-->

 <!--==========转发输入框已完成==========-->
    <div id='turnModal' style="display: none;">
        <div class="turn_head">
            <span class='turn_text fleft'>转发圈子动态</span>
            <span class="close close_turn fright"></span>
        </div>
        <div class="turn_main">
            <form action='blog/push2' method='post' name='turn'>
                <p></p>
                <div class='turn_prompt' style="margin-top: 5px;margin-bottom: 5px;margin-right: 0px;">你还可以输入<span id='turn_num'>140</span>个字</span></div>
                <textarea onfocus="setCaretPosition(this,0)" id="turnModal_textarea" name='content' sign='turn' style="outline: none;overflow-y:visible;min-height: 90px;"></textarea>
                <ul>
                    <li class='phiz fleft' sign='turn'></li>
                    <li class='turn_comment fleft'>
                        <label>
                            <input type="checkbox" name='becomment'/>同时评论给<span class='turn-cname'></span>
                        </label>
                    </li>
                    <li class='turn_btn fright'>
                        <input type="hidden" name='authorWbId' value=''/>
                        <input type="submit" value='转发' class='turn_btn'/>
                    </li>
                </ul>
            </form>
        </div>
    </div>
<!--==========转发输入框已完成==========-->
<!--==============================================主体左/中/右设计部分===============================================================================-->




<!--页面底部信息-->
<footer>
    <div class="container">
        <div class="row up">
            <ul class="list-inline text-center">
                <li>校园圈子</li>
                <li>校园官网</li>
                <li>校园服务</li>
                <li>校园博客</li>
                <li>校园圈子服务协议</li>
                <li>华东交通大学</li>
                <li>华东交通大学学生会</li>
                <li>日新网</li>
                <li>交大教务处</li>
            </ul>
        </div>
        <div class="row mid">
            <ul class="list-inline text-center">
                <li>Copyright © 2017 - 2025 CampusOfCircle All Rights Reserved</li>
            </ul>
        </div>
        <div class="row down">
            <ul class="list-inline text-center">
                <li>
                    <a href="#">京ICP备11008151号</a>

                </li>
                <li>京公网安备11010802014853</li>
            </ul>
        </div>
    </div>
</footer>	
</body>
	<script type="text/javascript" src="js/common/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="js/common/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index_body.js"></script>
	<script type="text/javascript" src="js/nav.js"></script>
	<script type="text/javascript" src="js/userseting.js"></script>
	<script type="text/javascript" src="js/common/city.js"></script>
<script type="text/javascript">
 		
</script>
</html>
