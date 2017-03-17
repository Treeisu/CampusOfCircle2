<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>CampusOfCircle</title> 
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<link href="css/common/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link href="css/common/mycommon.css" rel="stylesheet" type="text/css"/>
	<link href="css/login.css" rel="stylesheet" type="text/css" />
  </head>
  
  <body>
<h1>校园圈子COC<sup>V2017</sup></h1>

<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div class="switch" id="switch">
        	<a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">快速登录</a>
			<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">快速注册</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    
  
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 235px;">    

            <!--登录-->
            <div class="web_login" id="web_login">
               
               
               <div class="login-box">
       
			<div class="login_form">
				<form action="user/log"  id="login_form" name="loginform" accept-charset="utf-8" class="loginForm" method="post"><input type="hidden" name="did" value="0"/>
               <div id="log_msg_div" class="text-center"style="color: red">
               		<c:if test="${msg!=null}"><c:out value="${msg}"></c:out></c:if>
                </div>
               <input type="hidden" name="to" value="log"/>
                <div class="uinArea" id="uinArea">
                <label class="input-tips" for="u">帐号：</label>
                <div class="inputOuter" id="uArea">   
                    <input type="text" id="u" name="loguserPhone" class="inputstyle" placeholder="请输入手机号用于登录"/>
                </div>
                </div>
                <div class="pwdArea" id="pwdArea">
               <label class="input-tips" for="p">密码：</label> 
               <div class="inputOuter" id="pArea"> 
                    <input  type="password" id="p" name="logpassworld" class="inputstyle" placeholder="输入密码"/>
                </div>
                </div>
               
                <div style="padding-left:50px;margin-top:20px;"><input type="submit" value="登 录" style="width:150px;" class="button_blue"/></div>
              </form>
           </div>
           
            	</div>
               
            </div>
            <!--登录end-->
  </div>

  <!--注册-->
    <div class="qlogin" id="qlogin" style="display: none; ">
   
    <div class="web_login"><form name="form2" id="reg_form" accept-charset="utf-8"  action="" method="post">
	      <input type="hidden" name="to" value="reg"/>
		      		       <input type="hidden" name="did" value="0"/>
        <ul class="reg_form" id="reg-ul">
        		<div id="userCue" class="cue">快速注册请注意格式</div>
                <li>
                	
                    <label for="user"  class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text"  id="user" name="userNickName" maxlength="16" class="inputstyle2" placeholder="请输入昵称：4-16位字符"/>
                        <div id="userinfo"></div>
                    </div>
                    
                </li>
                
                <li>
                <label for="passwd" class="input-tips2">密码：</label>
                    <div class="inputOuter2">
                        <input type="password"  id="passwd"  name="password" maxlength="16" class="inputstyle2" placeholder="输入密码"/>
                        <div id="pwdinfo"></div>
                    </div>
                    
                </li>
                <li>
                <label for="passwd2" class="input-tips2 "style="font-size:15px ;">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password"  id="passwd2" name="password2" maxlength="16" class="inputstyle2" placeholder="确认输入"/>
                    	<div id="pwdinfo2"></div>
                    </div>
                </li>
                
                <li>
                 <label for="qq" class="input-tips2">手机号：</label>
                    <div class="inputOuter2">
                        <input type="text" id="qq" title="" name="userPhone" maxlength="11" class="inputstyle2" placeholder="请输入11位手机号码"/>
                    	<div id="phoneinfo"></div>
                    </div>
                   
                </li>                
                <li>
                    <div class="inputArea">
                        <input type="button" id="reg" style="margin-top:10px;margin-left:85px;" class="button_blue" value="同意协议并注册"/> <a href="#" class="zcxy" target="_blank">注册协议</a>
                    </div>
                    
                </li><div class="cl"></div>
            </ul></form>
           
    
    </div>
   
    
    </div>
    <!--注册end-->
</div>
<div class="welcome">*欢迎加入校园圈子*</div>

	<script type="text/javascript" src="js/common/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="js/common/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/login.js"></script>
</body>
</html>
