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
    <title>CampusOfCircle-个人首页</title>
	<link href="css/common/bootstrap.min.css" rel="stylesheet" type="text/css" />
	<link type="text/css" rel="stylesheet" href="css/index_common.css">
    <link type="text/css" rel="stylesheet" href="css/index_modal.css">
    <link type="text/css" rel="stylesheet" href="css/index_body.css">
    <embed hidden=true autostart=true loop=true src="music/first.mp3" > </embed>
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
                <li class="three"><i class="ui-friends"></i><a href="/CampusOfCircle/jsp/message.jsp">消息</a></li>
                <li class="five"><i class="ui-dress"></i><a href="#setTheme_modal" data-toggle="modal">主题</a></li>
                <li class="six"><i class="ui-music"></i><a href="#" class="music-active"></a></li>
                <li class="seven"> <input type="text" class="form-control" placeholder="搜索用户/动态/校园"><span class="search"></span></li>
                <li id="li_user_dropdown" class="eight">
                	<img src="<c:out value="${user.userImage}"/>" alt="" style="width:36px;height:36px">
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
            <c:if test="${user.userAdviceNum.sumNum>0}"><a href="" class="list-group-item messageLeftList" ><i class='icon icon-comment'></i>&nbsp;&nbsp;消息<span class="badge" style="color: red;background-color: #C9EBF4;"><c:out value="${user.userAdviceNum.sumNum}"/></span></a></c:if>
<<<<<<< HEAD
            <c:if test="${user.userAdviceNum.sumNum==0}"><a href="" class="list-group-item messageLeftList" ><i class='icon icon-comment'></i>&nbsp;&nbsp;消息</a></c:if>          
            <a href="" class="list-group-item" ><i class='icon icon-keep'></i>&nbsp;&nbsp;收藏</a>
=======
            <c:if test="${user.userAdviceNum.sumNum==0}"><a href="" class="list-group-item messageLeftList" ><i class='icon icon-comment'></i>&nbsp;&nbsp;消息</a></c:if>
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
	
	<!--=====中间栏=====-->
		<div id="middle" class='fleft'>
			<!--动态发布框-->
            <div class='send_wrap'>
                <div class='send_title fleft'></div>
                <div class='send_prompt fright'><span>你还可以输入<span id='send_num'>140</span>个字</span></div>
                <div class='send_write' id='send_text'>
                    <form action='blog/push' method='post' name='weibo' id="send_wb_textarea" enctype="multipart/form-data">
                        <textarea sign='shuoshuo' name='content' id='sendshuoshuo_textarea' style=" outline: none;overflow-y:visible"></textarea>
                        <span class='ta_right' id='ta_right_span'></span>
                        <div class='send_tool'>
                            <ul class='fleft'>
                                <li title='表情'><i id="" class='icon icon-phiz phiz' sign='shuoshuo'></i></li>
                                <li title='图片'><i id="picture_up_li" class='icon icon-picture'></i>
                                <!--图片上传框-->
                                    <div id="upload_img" class='' style="display: none;">
                                        <div class='upload-title'>
                                        	<label class="btn btn-default" style="width: 50px; height: 22px; font-size: x-small;" id="">选择<input type="file" name='picture' id='select_picture'style="opacity: 0;"/></label>
                                        	<label class="btn btn-default" style="width: 50px; height: 22px; font-size: x-small;" id="cancel_picture">删除</label>
                                        	<label class='btn btn-default'style="width: 48px; height: 22px; font-size: x-small; margin-left: 40px;" id="close_picture">关闭</label>
                                        </div>
                                        <div class='pic_show' id="picture_show"></div><!--图片预览框-->
                                    </div>
                                <!--图片上传框-->
                                </li>
                            </ul>
                            <input type='submit' value='' class='btn send_btn fright' title='发布微博按钮'/>
                        </div>
                    </form>
                </div>
            </div>
        <!--动态发布框end-->
          <div class='view_line' style="margin-top:10px">
                <strong ><small>圈子</small></strong>
            </div>
            
		<!--显示微博样式-->	
			<!--首先做个判断，有就去遍历微博，没有就提示没有微博-->
	<c:if test="${blogs.size()>0}">
		<c:forEach var="blog" items="${blogs}">
			<c:if test="${blog.wbAuthorId==0}">
				<div class="weibo">
					<p id="userId_p_init" style="display:none"><c:out value="${blog.user.userId}"/></p>
					<p id="wbId_p_init" style="display:none"><c:out value="${blog.wbId}"/></p>
					<p id="authorwbId_p_init" style="display:none"><c:out value="${blog.initPushInfo.wbId}"/></p>
					<div class="face">
						<a href="">
	                        <img src="<c:out value="${blog.user.userImage}"/>" width='50' height='50'/>
	                    </a>
					</div>
					<div class="wb_cons">
						<dl>
							<!--用户名-->
	                        <dt class='author' style="">
	                            <a href=""><c:out value="${blog.user.userNickName}"/></a>
	                        </dt>
	                    	<!--发布内容-->
	                        <dd class='content'>
	                            <p><c:out value="${blog.wbTextContent}"/></p>
	                        </dd>
							<!--需要做判断有没有图片-->
							<c:if test="${!empty blog.wbImage}">
							<dd>
								<div id="wb_img_div" class="wb_img">
									<!--小图显示-->
									<img src="<c:out value="${blog.wbImage}"/>" class='mini_img' style="width: 200px;height: 150px;"/>
									<!--隐藏框用于图片大小显示-->
									<div class="img_tool" id="img_getbig" style="display: none;">
	                                    <ul style="list-style: none;">
	                                        <li>
	                                            <i class='icon icon-packup'></i>
	                                            <span class='packup'>&nbsp;收起</span>
	                                        </li>
	                                        <li>|</li>
	                                        <li>
	                                            <i class='icon icon-bigpic'></i>
	                                            <!--注意：这里需要填写上传图片后的存储地址-->
	                                            <a href="<c:out value="${blog.wbImage}"/>" target='_blank'>&nbsp;查看大图</a>
	                                        </li>
	                                    </ul>
	                               		<!--中图显示-->
	                                    <div class="img_info"><img src="<c:out value="${blog.wbImage}"/>"/></div>
	                               </div> 
								</div>
							</dd>
							</c:if>
							<!--需要做判断有没有图片end-->
						</dl>
						<!--微博操作-->
						<div class="wb_tool">
							 <!--发布时间-->
	                        <span class="send_time"><fmt:formatDate value="${blog.wbPushDate}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
							<ul style="list-style: none;">
								<li class='del-li ' style="display: none;"><span class='del-weibo iconII iconII-delete' wid='<c:out value="${blog.wbId}"/>'></span></li>
	                        	<c:if test="${blog.praiseState==0}"><li class="li_praise"><span class='iconII iconII-praise' id='' ></span><sup>(<c:out value="${blog.praiseNum}"/>)</sup></li></c:if>
	                            <c:if test="${blog.praiseState==1}"><li class="li_praise"><span class='iconII iconII-praise2' id='' ></span><sup>(<c:out value="${blog.praiseNum}"/>)</sup></li></c:if>
	                            <li class="li_showturn"><span class='iconII iconII-turn' id='' turnid=""></span><sup>(<c:out value="${blog.turnNum}"/>)</sup></li>
	                            <li class="li_showcomment_list"><span class='comment iconII iconII-comment' id=''></span><sup>(<c:out value="${blog.commentNum}"/>)</sup></li>
	                            <c:if test="${blog.collectionState==0}"><li class='li_collection'> <span class='iconII iconII-collection' wid=''></span></li></c:if>
	                            <c:if test="${blog.collectionState==1}"><li class='li_collection'> <span class='iconII iconII-collection2' wid=''></span></li></c:if>
							</ul>
						</div>
						<c:if test="${blog.praiseState==1}"><div class='thinking_praiseDIV' id='' style="background-color: #DFF0D8;line-height: 23px;"><span class="iconII iconII-praise2" style="font-size: 13px;color: #444;font:12px/1.125 Arial,Helvetica,sans-serif;_font-family:"SimSun";"></span><span>&nbsp;&nbsp;我觉得很赞</span></div></c:if>
						<c:if test="${blog.praiseState==0}"><div class='thinking_praiseDIV' id='' style="background-color: #DFF0D8;line-height: 23px;display:none;"><span class="iconII iconII-praise2" style="font-size: 13px;color: #444;font:12px/1.125 Arial,Helvetica,sans-serif;_font-family:"SimSun";"></span><span>&nbsp;&nbsp;我觉得很赞</span></div></c:if>
						 <!--=====回复框=====-->
						    <div class='comment_loading comment_load ' id='' style="display: none;"><img src="img/loading.gif">评论加载中，请稍候...</div>
						    <div class='comment_modal comment_list ' id="" style="display: none;">
						        <textarea name="commentTextarea" sign='comment' style="outline: none;overflow-y:visible"></textarea>
						        <ul style="list-style: none;">
						            <li class='phiz phiz_com fleft' sign='comment'></li>
						            <li class='comment_turn fleft'>
							            <label >
							            	<input type="checkbox" name='commentbyTurn' value="1"/>同时转发到我的圈子
							            </label>
						            </li>
						            <span style="margin-left: 160px;"><span id='comment1_num'>140</span>/140</span>
						            <li class='comment_btn fright' wid='' uid='' id="sendcomment_btn">评论</li>  
						        </ul>
						    </div>
						    <!--=====回复框=====-->
						    <!--=====回复列表=====-->
						    <div class="showcommentList" style="margin-top: 5px; display: none;"></div> 
						<!--=====回复框结束=====-->
					</div>
				</div>
			</c:if>
			<!--===================转发的显示样式==================-->
			<c:if test="${blog.wbAuthorId!=0}">
				<div class="weibo">
					<!--藏值-->
					<p id="userId_p_init" style="display:none"><c:out value="${blog.user.userId}"/></p>
					<p id="wbId_p_init" style="display:none"><c:out value="${blog.wbId}"/></p>
					<p id="authorwbId_p_init" style="display:none"><c:out value="${blog.initPushInfo.wbId}"/></p>
					<!--头像-->
                	<div class="face"><a href=""><img src="<c:out value="${blog.user.userImage}"/>" width='50' height='50'/></a></div>
					<div class="wb_cons">
						<dl>
							<!--用户名-->
                        	<dt class='author'><a href=""><c:out value="${blog.user.userNickName}"/></a></dt>
                        	<!--发布内容-->
                        	<dd class='content'><p><c:out value="${blog.wbTextContent}"/></p></dd>
                        	<!--转发的原动态内容-->
                        	<c:if test="${empty blog.initPushInfo}">
                        		<dd class="wb_turn" >该圈子动态已被主人删除</dd>                        	
                        	</c:if>
                        	<c:if test="${!empty blog.initPushInfo}">
                        	<dd>
                        		<div class="wb_turn">
                        			<dl>
                        				<!--原作者-->
                                    	<dt class='turn_name'><a href="">@<c:out value="${blog.initPushInfo.userNickName}"/></a></dt>
                                    	<!--原微博内容-->
                                    	<dd class='turn_cons'><p><c:out value="${blog.initPushInfo.wbTextContent}"/></p></dd>
                                    	<!--原微博图片-->
                                    	<c:if test="${!empty blog.initPushInfo.wbImage}">
                                    	<dd>
                                    	 	<div class="turn_img">
                                    	 		<!--小图显示-->
												<img src="<c:out value="${blog.initPushInfo.wbImage}"/>" class='mini_img' style="width: 200px;height: 150px;"/>
                                    	 		<div class="img_tool" id="img_getbig" style="display: none;">
                                    	 			<ul style="list-style: none;">
			                                        	<li><i class='icon icon-packup'></i><span class='packup'>&nbsp;收起</span></li>
			                                        	<li >|</li>
			                                        	<li><i class='icon icon-bigpic'></i><a href="<c:out value="${blog.initPushInfo.wbImage}"/>" target='_blank'>&nbsp;查看大图</a></li>
			                                    	</ul>
			                                    	<div class="img_info"><img src="<c:out value="${blog.initPushInfo.wbImage}"/>"/></div>
                                    	 		</div>
                                    	 	</div>                                   	 	                                  	 	
                                    	 </dd>
                                    	 </c:if>                                    
                        			</dl>
                        			<!--转发微博操作-->
                        			<div class="turn_tool">
                                    	<span class="send_time"><fmt:formatDate value="${blog.initPushInfo.wbPushDate}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
                                    	<ul style="list-style: none;">
			                            	<li class=""><a href="" style="text-decoration: none;"><span class='iconII iconII-turn' id=''></span><sup>(<c:out value="${blog.initPushInfo.turnNum}"/>)</sup></a></li>
			                           	 	<li class=""><a href="" style="text-decoration: none;"><span class='comment iconII iconII-comment' id=''></span><sup>(<c:out value="${blog.initPushInfo.commentNum}"/>)</sup></a></li>
										</ul>
                                	</div>                        			
                        		</div>	
                        	</dd>
                        	</c:if>	
						</dl>
						<!--此微博操作-->
						<div class="wb_tool">
							<span class="send_time"><fmt:formatDate value="${blog.wbPushDate}" pattern="yyyy-MM-dd HH:mm:ss"/></span>
							<ul style="list-style: none;">
								<li class='del-li ' style="display: none;"><span class='del-weibo iconII iconII-delete' wid='<c:out value="${blog.wbId}"/>'></span></li>
	                        	<c:if test="${blog.praiseState==0}"><li class="li_praise"><span class='iconII iconII-praise' id='' ></span><sup>(<c:out value="${blog.praiseNum}"/>)</sup></li></c:if>
	                            <c:if test="${blog.praiseState==1}"><li class="li_praise"><span class='iconII iconII-praise2' id='' ></span><sup>(<c:out value="${blog.praiseNum}"/>)</sup></li></c:if>
	                            <li class="li_showturn"><span class='iconII iconII-turn' id='' turnid=""></span><sup>(<c:out value="${blog.turnNum}"/>)</sup></li>
	                            <li class="li_showcomment_list"><span class='comment iconII iconII-comment' id=''></span><sup>(<c:out value="${blog.commentNum}"/>)</sup></li>
	                            <c:if test="${blog.collectionState==0}"><li class='li_collection'> <span class='iconII iconII-collection' wid=''></span></li></c:if>
	                            <c:if test="${blog.collectionState==1}"><li class='li_collection'> <span class='iconII iconII-collection2' wid=''></span></li></c:if>
							</ul>
						</div>
						<c:if test="${blog.praiseState==1}"><div class='thinking_praiseDIV' id='' style="background-color: #DFF0D8;line-height: 23px;"><span class="iconII iconII-praise2" style="font-size: 13px;color: #444;font:12px/1.125 Arial,Helvetica,sans-serif;_font-family:"SimSun";"></span><span>&nbsp;&nbsp;我觉得很赞</span></div></c:if>
						<c:if test="${blog.praiseState==0}"><div class='thinking_praiseDIV' id='' style="background-color: #DFF0D8;line-height: 23px;display:none;"><span class="iconII iconII-praise2" style="font-size: 13px;color: #444;font:12px/1.125 Arial,Helvetica,sans-serif;_font-family:"SimSun";"></span><span>&nbsp;&nbsp;我觉得很赞</span></div></c:if>
						<!--=====回复框=====-->
						    <div class='comment_loading comment_load ' id='' style="display: none;"><img src="img/loading.gif">评论加载中，请稍候...</div>
						    <div class='comment_modal comment_list ' id="" style="display: none;">
						        <textarea name="commentTextarea" sign='comment' style="outline: none;overflow-y:visible"></textarea>
						        <ul style="list-style: none;">
						            <li class='phiz phiz_com fleft' sign='comment'></li>
						            <li class='comment_turn fleft'>
							            <label >
							            	<input type="checkbox" name='commentbyTurn' value="1"/>同时转发到我的圈子
							            </label>
						            </li>
						            <span style="margin-left: 160px;"><span id='comment1_num'>140</span>/140</span>
						            <li class='comment_btn fright' wid='' uid='' id="sendcomment_btn">评论</li>  
						        </ul>
						    </div>
						    <!--=====回复框=====-->
						    <!--=====回复列表=====-->
						    <div class="showcommentList" style="margin-top: 5px; display: none;"></div> 
						<!--=====回复框结束=====-->
					</div>			
				</div>
			</c:if>
		</c:forEach>	
	</c:if>
	<c:if test="${blogs.size()==0}">
		<div class="weibo" style="text-align: center;">暂无校园圈子动态</div>
	</c:if>
			<div id='page'>1</div>
</div>
	<!--=====中间栏end=====-->


<!--==========右侧==========-->
<div id="right">
	<div class="edit_tpl"><a class='set_model' href="#setTheme_modal"  data-toggle="modal"></a></div> 
	<dl class="user_face">
        <dt><a href=""><img src="<c:out value="${user.userImage}"/>" width='80' height='80' alt="" /></a></dt>
        <dd><a href=""><c:out value="${user.userNickName}"/></a></dd>
    </dl>
	<ul class='num_list'>
        <li><a ><strong><c:out value="${user.userAdviceNum.attentionNum}"/></strong><span>关注</span></a></li>
        <li><a ><strong><c:out value="${user.userAdviceNum.fansNum}"/></strong><span>粉丝</span></a></li>
        <li class='noborder'><a ><strong><c:out value="${user.userAdviceNum.wbNum}"/></strong><span>圈动态</span></a></li>
    </ul>
	<div class="maybe">
        <fieldset>
            <legend style="font-size: 13px;">可能感兴趣的人</legend>
            <ul>
            <c:if test="${pushUsers.size()>0}">
            <c:forEach var="pushUser" items="${pushUsers}">
                <li>
                    <dl>
                        <dt><a href=""><img src="<c:out value="${pushUser.userImage}"/>" width='30' height='30'/></a></dt>
                        <dd><a href="" class="<c:out value="${pushUser.userId}"/>"><c:out value="${pushUser.userNickName}"/></a></dd>
                        <dd>查看圈子资料</dd>
                    </dl>
                    <dl class=' heed_btn add-fl addToUser' id=""><strong>+&nbsp;</strong>关注</dl>
               </li>
            </c:forEach>
            </c:if>               
            </ul>
        </fieldset>
    </div>
	
	<div class="post">
        <div class='post_line'>
            <span>公告栏</span>
        </div>
        <ul>
            <li><a href="">校园圈子热门动态</a></li>
            <li><a href="">校园圈子视频动态</a></li>
            <li><a href="">校园圈子搞笑动态</a></li>
        </ul>
    </div>
	
	<div id="share" >
		<a id="totop" title="返回顶部">返回顶部</a>
		<a href="/CampusOfCircle/userIndexTo" target="_blank" class="sina">关注校园圈子</a>
	</div>
</div>
<!--==========右侧end==========-->

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
<!--==========表情选择框==========-->
    <div id="phiz_modal" class="" style="display: none;">
        <div>
            <p>常用表情</p>
            <span class='close_phiz close fright' id=""></span>
        </div>
        <ul class="list-group list-inline">
            <li><img src="./img/phiz/hehe.gif" alt="呵呵" title="呵呵" /></li>
            <li><img src="./img/phiz/xixi.gif" alt="嘻嘻" title="嘻嘻" /></li>
            <li><img src="./img/phiz/haha.gif" alt="哈哈" title="哈哈" /></li>
            <li><img src="./img/phiz/keai.gif" alt="可爱" title="可爱" /></li>
            <li><img src="./img/phiz/kelian.gif" alt="可怜" title="可怜" /></li>
            <li><img src="./img/phiz/wabisi.gif" alt="挖鼻屎" title="挖鼻屎" /></li>
            <li><img src="./img/phiz/chijing.gif" alt="吃惊" title="吃惊" /></li>
            <li><img src="./img/phiz/haixiu.gif" alt="害羞" title="害羞" /></li>
            <li><img src="./img/phiz/jiyan.gif" alt="挤眼" title="挤眼" /></li>
            <li><img src="./img/phiz/bizui.gif" alt="闭嘴" title="闭嘴" /></li>
            <li><img src="./img/phiz/bishi.gif" alt="鄙视" title="鄙视" /></li>
            <li><img src="./img/phiz/aini.gif" alt="爱你" title="爱你" /></li>
            <li><img src="./img/phiz/lei.gif" alt="泪" title="泪" /></li>
            <li><img src="./img/phiz/touxiao.gif" alt="偷笑" title="偷笑" /></li>
            <li><img src="./img/phiz/qinqin.gif" alt="亲亲" title="亲亲" /></li>
            <li><img src="./img/phiz/shengbin.gif" alt="生病" title="生病" /></li>
            <li><img src="./img/phiz/taikaixin.gif" alt="太开心" title="太开心" /></li>
            <li><img src="./img/phiz/ldln.gif" alt="懒得理你" title="懒得理你" /></li>
            <li><img src="./img/phiz/youhenhen.gif" alt="右哼哼" title="右哼哼" /></li>
            <li><img src="./img/phiz/zuohenhen.gif" alt="左哼哼" title="左哼哼" /></li>
            <li><img src="./img/phiz/xiu.gif" alt="嘘" title="嘘" /></li>
            <li><img src="./img/phiz/shuai.gif" alt="衰" title="衰" /></li>
            <li><img src="./img/phiz/weiqu.gif" alt="委屈" title="委屈" /></li>
            <li><img src="./img/phiz/tu.gif" alt="吐" title="吐" /></li>
            <li><img src="./img/phiz/dahaqian.gif" alt="打哈欠" title="打哈欠" /></li>
            <li><img src="./img/phiz/baobao.gif" alt="抱抱" title="抱抱" /></li>
            <li><img src="./img/phiz/nu.gif" alt="怒" title="怒" /></li>
            <li><img src="./img/phiz/yiwen.gif" alt="疑问" title="疑问" /></li>
            <li><img src="./img/phiz/canzui.gif" alt="馋嘴" title="馋嘴" /></li>
            <li><img src="./img/phiz/baibai.gif" alt="拜拜" title="拜拜" /></li>
            <li><img src="./img/phiz/sikao.gif" alt="思考" title="思考" /></li>
            <li><img src="./img/phiz/han.gif" alt="汗" title="汗" /></li>
            <li><img src="./img/phiz/kun.gif" alt="困" title="困" /></li>
            <li><img src="./img/phiz/shuijiao.gif" alt="睡觉" title="睡觉" /></li>
            <li><img src="./img/phiz/qian.gif" alt="钱" title="钱" /></li>
            <li><img src="./img/phiz/shiwang.gif" alt="失望" title="失望" /></li>
            <li><img src="./img/phiz/ku.gif" alt="酷" title="酷" /></li>
            <li><img src="./img/phiz/huaxin.gif" alt="花心" title="花心" /></li>
            <li><img src="./img/phiz/heng.gif" alt="哼" title="哼" /></li>
            <li><img src="./img/phiz/guzhang.gif" alt="鼓掌" title="鼓掌" /></li>
            <li><img src="./img/phiz/yun.gif" alt="晕" title="晕" /></li>
            <li><img src="./img/phiz/beishuang.gif" alt="悲伤" title="悲伤" /></li>
            <li><img src="./img/phiz/zuakuang.gif" alt="抓狂" title="抓狂" /></li>
            <li><img src="./img/phiz/heixian.gif" alt="黑线" title="黑线" /></li>
            <li><img src="./img/phiz/yinxian.gif" alt="阴险" title="阴险" /></li>
            <li><img src="./img/phiz/numa.gif" alt="怒骂" title="怒骂" /></li>
            <li><img src="./img/phiz/xin.gif" alt="心" title="心" /></li>
            <li><img src="./img/phiz/shuangxin.gif" alt="伤心" title="伤心" /></li>
        </ul>
    </div>
<!--==========表情==========-->
</body>
	<script type="text/javascript" src="js/common/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="js/common/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/index_body.js"></script>
	<script type="text/javascript" src="js/nav.js"></script>
<script type="text/javascript">
function setCaretPosition(ctrl, pos){
    if(ctrl.setSelectionRange)
    {
        ctrl.focus();
        ctrl.setSelectionRange(pos,pos);
    }
    else if (ctrl.createTextRange) {
        var range = ctrl.createTextRange();
        range.collapse(true);
        range.moveEnd('character', pos);
        range.moveStart('character', pos);
        range.select();
    }
}
</script>
</html>
