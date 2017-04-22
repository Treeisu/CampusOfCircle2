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
	<link type="text/css" rel="stylesheet" href="css/indexSingle.css">
  </head>
  
<body>
<template>
    <article><i></i>
        <span class="nular">{{lunar}}</span><b class="secDate">{{date}}</b>
        <p class="content">"{{content}}"</p>{{img}}
        <a href="#" title="赞" class="like">（{{like}}人）已赞</a>
        <a href="#" title="评论" class="comment">（{{comment}}）人已评论</a>
        <p class="verylike">{{veryLike}}人觉得很赞</p>
    </article>
</template>
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
                <li class="three"><i class="ui-friends"></i><a href="#">消息</a></li>
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
<main>
    <div class="container">
        <aside></aside>
        <img src='<c:out value="${user.userImage}"/>' style='width: 60px;height:60px;position: absolute;margin-left:0px;'></img>
        <section></section>
    </div>

</main>
<!--==============================================主体左/中/右设计部分===============================================================================-->
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
	<script type="text/javascript" src="js/nav.js"></script>	
	<script type="text/javascript" src="js/timeAxis/GetLunarDay.js"></script>
	<script type="text/javascript" src="js/timeAxis/data.js"></script>	
<script type="text/javascript">
 		
</script>
</html>
