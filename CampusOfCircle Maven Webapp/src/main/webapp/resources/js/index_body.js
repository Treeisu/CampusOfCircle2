
$(function(){
//	 var timer1=setInterval(messageMum,5000);
//	 var timer1=setInterval(messageMum,1000);
	/**
	 * 返回顶部
	 */
		//首先将#back-to-top隐藏
		$("#totop").hide();
		//当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
		$(function(){
			$(window).scroll(function(){
				if ($(window).scrollTop()>100){
					$("#totop").fadeIn();
				}else{
					$("#totop").fadeOut();
				}
			});		
			//当点击跳转链接后，回到页面顶部位置
			$("#totop").click(function(){
				$('body,html').animate({scrollTop:0},500);
				return false;
			});		
		});

		/**
		 * 用户退出
		 */
		$('#li_user_dropdown').find('ul').hover(function(){
			var a_exit=$(this).children(':last').find('a');
			a_exit.attr('href','user/exit');
		});
		/**
		 * 用户个人首页
		 */
		$('#right').find('.num_list').find('.noborder').click(function(){
			window.location.href='/CampusOfCircle/jsp/userSingle.jsp';
		});
		
		/**
		 * 查看消息通知
		 */
		
		$('#left').find('.messageLeftList').click(function(){
			$.ajax({
				type : 'post',
				url : "message/getMessage",
				dataType : "json",
				data : {"userId" :$('#userId_navbar').text()},
				success :function (data){
					window.location.href='/CampusOfCircle/jsp/message.jsp';
				}
			});
		});
		
		/**
		 *创建分组ajax
		 */
		$('#creat_group_modal').find('.btn-success').click(function(){
			var userId=$('#userId_navbar').text();
			var groupName=$(this).parents('#creat_group_modal').find('.modal-body input').val();
			var createbutton=$('.group').find('#left_nav_b').find('#create_group');
			$.ajax({
				type : 'post',
				url : "group/saveGroup",
				dataType : "json",
				data : {"userId" : userId,"groupName":groupName},
				success :function (data){
					var Arrs=eval(data);
					$.each(Arrs,function(i,arr){
						createbutton.before("<a href='' class='list-group-item'><span style='display: none;'>"+arr.groupId+"</span><i class='icon icon-group'></i>&nbsp;&nbsp;"+arr.groupName+"</a>");
					});	
					window.location.href='/CampusOfCircle/userIndexTo';
				}		
			});	
		});
		/**
		 * 删除时加载分组信息
		 */
		$('#delete_group').click(function(){
			if($('.group').find('#left_nav_b').find('a').length==4){
				$('#delete_group_modal').find('.modal-body').empty();
				$('#delete_group_modal').find('.modal-body').html("<h5>您还没有任何分组</h5>");
				$('#delete_group_modal').find('.modal-footer').empty();
				$('#delete_group_modal').modal("toggle");
			}else{
				var userId=$('#userId_navbar').text();
				var selectTHIS=$('#delete_group_modal').find('.modal-body select');
				selectTHIS.empty();
				$.ajax({
					type : 'post',
					url : "group/getGroup",
					dataType : "json",
					data : {"userId" : userId},
					success :function (data){
						var Arrs=eval(data);
						$.each(Arrs,function(i,arr){
							//设置弹框的信息
							selectTHIS.append("<option class='"+arr.groupId+"'>"+arr.groupName+"</option>");						
						});							
					}		
				});
				$('#delete_group_modal').modal("toggle");				
			}
									
		});		
		/**
		 * 删除分组
		 */
		$('#delete_group_modal').find('.btn-danger').click(function(){		
			var createbutton=$('.group').find('#left_nav_b').find('#create_group');
			var groupId=$(this).parents('#delete_group_modal').find('select option:selected').attr('class');	
			$.ajax({
				type : 'post',
				url : "group/delGroup",
				dataType : "json",
				data : {"groupId" : groupId},
				success :function (data){
					var Arrs=eval(data);
					$.each(Arrs,function(i,arr){
						createbutton.before("<a href='' class='list-group-item'><span style='display: none;'>"+arr.groupId+"</span><i class='icon icon-group'></i>&nbsp;&nbsp;"+arr.groupName+"</a>");
					});	
					window.location.href='/CampusOfCircle/userIndexTo';
				}		
			});								
		});
		/**
		 * 加关注加载分组信息
		 */
		$('.addToUser').click(function(){
			var toUserId=$(this).parents('li').find('dd:first').find('a').attr('class');
			var userId=$('#userId_navbar').text();
			var selectTHIS=$('#attention_modal').find('.modal-body select');
			selectTHIS.empty();
			$.ajax({
				type : 'post',
				url : "group/getGroup",
				dataType : "json",
				data : {"userId" : userId},
				success :function (data){
					var Arrs=eval(data);
					if(data.length<=0){
						selectTHIS.append("<option class='0'>默认分组</option>");
					}else{
						selectTHIS.append("<option class='0'>默认分组</option>");
						$.each(Arrs,function(i,arr){
							//设置弹框的信息
							selectTHIS.append("<option class='"+arr.groupId+"'>"+arr.groupName+"</option>");						
						});	
					}
				}		
			});
			$('#attention_modal').modal("toggle");
			//进行关注
			$('#attention_modal').find('.btn-success').click(function(){
				//分组Id
				var groupId=$(this).parents('#attention_modal').find('select option:selected').attr('class');
				$.ajax({
					type : 'post',
					url : "attention/saveAttention",
					dataType : "json",
					data : {"groupId" : groupId,"toUserId":toUserId,"userId":userId},
					success :function (data){
						window.location.href='/CampusOfCircle/userIndexTo';				
					}		
				});	
			});						
		});	
		
		/**
		 * 设置分组查看信息
		 */
		$('.group').find('.list-group-item').click(function(){
			var groupId=$(this).find('span').text();
			$.ajax({
				type : 'post',
				url : "blog/getGroupBlogs",
				dataType : "json",
				data : {"groupId":groupId},
				success :function (data){
					var Obj=eval(data);
					if(Obj==0){
						window.location.href='/CampusOfCircle/userIndexTo';
					}else{
						window.location.href='/CampusOfCircle/userIndexTo2';
					}								
				}		
			});	
		});
		/**
		 * 查看关注的人
		 */
		$('#right').find('.num_list').find('li:eq(0)').find('a').click(function(){
			var userId=$('#userId_navbar').text();
			$.ajax({
				type : 'post',
				url : "attention/getAttentions",
				dataType : "json",
				data : {"userId":userId},
				success :function (data){
					var Obj=eval(data);
					if(Obj==0){
						window.location.href='/CampusOfCircle/userAttentionTo';
					}								
				}		
			});
		});
		/**
		 * 查看粉丝详情
		 */
		$('#right').find('.num_list').children(':first').next().find('a').click(function(){
			var userId=$('#userId_navbar').text();
			$.ajax({
				type : 'post',
				url : "attention/getFans",
				dataType : "json",
				data : {"userId":userId},
				success :function (data){
					var Obj=eval(data);
					if(Obj==0){
						window.location.href='/CampusOfCircle/userFansTo';
					}								
				}		
			});
		});
		/**
		 * 查看收藏的微博
		 */
		$('#left').find('.collectionLeftList').click(function(){
			var userId=$('#userId_navbar').text();
			$.ajax({
				type : 'post',
				url : "blog/getCollectionBlog",
				dataType : "json",
				data : {"userId":userId},
				success :function (data){
					var Obj=eval(data);
					if(Obj==1){
						window.location.href='/CampusOfCircle/userIndexTo2';
					}								
				}		
			});
		});
		
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * 左边列表状态选中
		 */
		$('#left_nav_a > a').click(function(e){
		  	e.preventDefault();
		    $('div > a').removeClass('active');
			$(this).addClass('active');
		});
		$('#left_nav_b  a').click(function(e){
		  	e.preventDefault();
		    $('div  a').removeClass('active');
			$(this).addClass('active');
		});
		/**
		 * 发布框字数提示变化
		 */
		$('#sendshuoshuo_textarea').focusin(function(){
			//获取焦点时改变边框背景
			$('.ta_right').css('backgroundPosition', '0 -50px');
			//转入文字时
			$("#sendshuoshuo_textarea").css('borderColor', '#FFB941').keyup(function () {
				var content = $('#sendshuoshuo_textarea').val();
				//调用check函数取得当前字数
				var lengths = check(content);
				if (lengths[0] > 0) {//当前有输入内容时改变发布按钮背景
					$('.send_btn').css('backgroundPosition', '-133px -50px');
				} else {//内容为空时发布按钮背景归位
					$('.send_btn').css('backgroundPosition', '-50px -50px');
				};
				//最大允许输入140字个
				if (lengths[0] >= 140) {
					$(this).val(content.substring(0, Math.ceil(lengths[1])));
				}
				var num = 140 - Math.ceil(lengths[0]);
				var msg = num < 0 ? 0 : num;
				//当前字数同步到显示提示
				$('#send_num').html(msg);
			});
		//失去焦点时边框背景归位
		}).focusout(function () {
			$('#sendshuoshuo_textarea').css('borderColor', '#CCCCCC');
			$('.ta_right').css('backgroundPosition', '0 -69px');
		});
		//内容提交时处理
		$('#send_wb_textarea').submit(function () {
			var cons = $('textarea', this);
			if (cons.val() == '') {//内容为空时闪烁输入框
				var timeOut = 0;
				var glint = setInterval(function () {
					if (timeOut % 2 == 0) {
						cons.css('background','#FFA0C2');
					} else {
						cons.css('background','#fff');
					}
					timeOut++;
					if (timeOut > 7) {
						clearInterval(glint);
						cons.focus();
					}
				}, 100);
				return false;
			}
		});
		
	/**
     * 表情处理
     * 以原生JS添加点击事件，不走jQuery队列事件机制
     */
	  	var phiz = $('.phiz');
	  	for (var i = 0; i < phiz.length; i++) {
	  		phiz[i].onclick = function () {
	  			//定位表情框到对应位置
				$('#phiz_modal').toggle().css({
					'left' : $(this).offset().left,
					'top' : $(this).offset().top + $(this).height() + 5
	    		});
	    		//为每个表情图片添加事件
	            var phizImg = $("#phiz_modal img");
	            var sign = this.getAttribute('sign');
	            for (var i = 0; i < phizImg.length; i++){
	            	phizImg[i].onclick = function () {
					var content = $('textarea[sign = '+sign+']');
					content.val(content.val() + '[' + $(this).attr('title') + ']');
					$('#phiz_modal').hide();
	            	}
	            }
	  		}
	  	}
	  	//评论表情点击
	  	var phizcom = $('.phiz_com');
	  	for (var i = 0; i < phizcom.length; i++) {
	  		phizcom[i].onclick = function () {
	  			//定位表情框到对应位置
				$('#phiz_modal').toggle().css({
					'left' : $(this).offset().left,
					'top' : $(this).offset().top + $(this).height() + 5
	    		});
	    		//为每个表情图片添加事件
	            var phizImg = $("#phiz_modal img");
	            var sign = this.getAttribute('sign');
	            for (var i = 0; i < phizImg.length; i++){
	            	phizImg[i].onclick = function () {
					var content = $('textarea[sign = '+sign+']');
					content.val(content.val() + '[' + $(this).attr('title') + ']');
					$('#phiz_modal').hide();
	            	}
	            }
	  		}
	  	}
	  	//关闭表情框
		$('.close_phiz').hover(function () {
			$(this).css('backgroundPosition', '-100px -200px');
		}, function () {
			$(this).css('backgroundPosition', '-75px -200px');
		}).click(function () {
			$(this).parent().parent().hide();
			$('#phiz_modal').hide();
			if ($('#turn').css('display') == 'none') {
				$('#opacity_bg').remove();
			};
		});
		
		//图片上传框
		$('#picture_up_li').click(function () {
			$('#phiz_modal').hide();
			$('#upload_img').toggle();
		});
		//不想发图片时，删除图片
		$('#cancel_picture').click(function(){
			$('#picture_show').empty();
			$('#picture_show').append("<label id='upload-btn-p' class='text-center' style='margin-top:40px;margin-left:60px;'>请重新选择图片</label>");
		});
		//关闭图片预览框
		$('#close_picture').hover(function () {
			$(this).css('backgroundPosition', '-100px -200px');
		}, function () {
			$(this).css('backgroundPosition', '-75px -200px');
		}).click(function () {
			$(this).parent().parent().hide();
		});
		

		//选择图片，并进行预览
		$('#select_picture').on('change',function(){
			var f1 = document.getElementById('select_picture').files[0];
			var pic_src = window.URL.createObjectURL(f1);
			$('#picture_show').empty();
			$('#picture_show').append("<img src='' alt='' class='' style='width: 300px;margin-top: 2px;'/>");
			$('#picture_show img').attr('src',pic_src);
		});
		/**
		 * 微博区
		 */
		//图片放大操作
		$('.mini_img').click(function () {
			$(this).hide().next().show();
		});
		$('.img_info img').click(function () {
			$(this).parents('.img_tool').hide().prev().show();
		});
		$('.packup').click(function () {
			$(this).parent().parent().parent().hide().prev().show();
		});
		$('.turn_mini_img').click(function () {
			$(this).hide().next().show();
		});
		$('.turn_img_info img').click(function () {
			$(this).parents('.turn_img_tool').hide().prev().show();
		});
				
		//点赞操作
		$('.li_praise').click(function(){
			var praise_sup_this=$(this).find('sup');
			var praise_span_this=$(this).find('span');
			var stateClass=$(this).find('span').attr("class");
			var wbId=$(this).parents('.weibo').find('#wbId_p_init').text();
			var numText=$(this).find('sup').html();
			if(stateClass=="iconII iconII-praise"){
				//点赞保存ajax
				$.ajax({
					type : 'post',
					url : "blog/savePraise",
					dataType : "json",
					data : {"wbId" : wbId},
					success :function (data){
						var Obj=eval(data);
						 if(Obj==1){
							 praise_span_this.attr('class','iconII iconII-praise2');
							//设置数量+1
					    	var NumOld = /\d+(?:\.\d+)?/.exec(numText);
					    	var Num =Number(NumOld)+1;
					    	praise_sup_this.html("("+Num+")");
					    	//我觉得很赞显现
							praise_sup_this.parents('.weibo').find('.thinking_praiseDIV').show();
						 }
					}		
				})				
			}else{
				//点赞删除ajax
				$.ajax({
					type : 'post',
					url : "blog/cancelPraise",
					dataType : "json",
					data : {"wbId" : wbId},
					success :function (data){
						var Obj=eval(data);
						 if(Obj==1){
							 praise_span_this.attr('class','iconII iconII-praise');
							//设置数量-1	
						    var NumOld = /\d+(?:\.\d+)?/.exec(numText);
						    var Num =Number(NumOld)-1;
						    praise_sup_this.html("("+Num+")");
						    //我觉得很赞消失
						    praise_sup_this.parents('.weibo').find('.thinking_praiseDIV').hide();
						 }
						
					}		
				});						
			}			
		});
		

		
		//收藏操作
		$('.li_collection').click(function(){
			var collection_span_this=$(this).find('span');
			var stateClass=$(this).find('span').attr("class");
			var wbId=$(this).parents('.weibo').find('#wbId_p_init').text();
			var numText=$(this).find('sup').html();
			if(stateClass=="iconII iconII-collection"){
				
				$.ajax({
					type : 'post',
					url : "blog/saveCollection",
					dataType : "json",
					data : {"wbId" : wbId},
					success :function (data){
						var Obj=eval(data);
						 if(Obj==1){
							 collection_span_this.attr('class','iconII iconII-collection2');							
					    	//警示框
					    	$('#collection_modal').find('h4').html('已成功收藏！');
							$('#collection_modal').find('.alert').removeClass('alert-warning');
							$('#collection_modal').find('.alert').addClass('alert-success');
							$('#collection_modal').modal('show');
							setTimeout(function(){$('#collection_modal').modal('hide');},650);
						 }
					}		
				})				
			}else{				
				$.ajax({
					type : 'post',
					url : "blog/cancelCollection",
					dataType : "json",
					data : {"wbId" : wbId},
					success :function (data){
						var Obj=eval(data);
						 if(Obj==1){
							 collection_span_this.attr('class','iconII iconII-collection');							
						    //警示框
						    $('#collection_modal').find('h4').html('已取消收藏！');
							$('#collection_modal').find('.alert').removeClass('alert-success');
							$('#collection_modal').find('.alert').addClass('alert-warning');
							$('#collection_modal').modal('show');
							setTimeout(function(){$('#collection_modal').modal('hide');},650);
						 }
						
					}		
				});						
			}			
		});
		
		
		
		//删除按钮显现
		$('.weibo').hover(function () {
				var blogUserId=$(this).find('#userId_p_init').text();
				var uid=$('#head_mycollapse').find('#userId_navbar').text();
				if(blogUserId==uid){
					$(this).find('.del-li').show();
				}	
			}, function () {
				$(this).find('.del-li').hide();
			});
			$('.del-li').click(function () {
				var weiboDiv=$(this).parents('.weibo');
				var wid=weiboDiv.find('#wbId_p_init').text();
				var content =$(this).parents('.weibo').find('.content p').html();
				var name=$(this).parents('.weibo').find('.author a').html();
				$('#delete_modal').find('.modal-body p').html(content);
				$('#delete_modal').find('.modal-body .username').html(name+':');
				$('#delete_modal').modal().toggle();
				//删除节点，并且发送请求从数据库删除数据
				$('#delete_modal').find('.modal-footer .btn-danger').click(function(){
					$.ajax({
						type:"POST",
						url:"blog/del",
						dataType:"json",
						data:{"wbId":wid},
						success:function(data){
							if(data==1){
								weiboDiv.remove();		
							}												
						}
					});
					
					
				});
			});		
		/**
		 * 评论区
		 */	
			//评论字数变化
			$('.comment_list textarea').focus(function () {
				$(this).css('borderColor', '#FF9B00');
			}).blur(function () {
				$(this).css('borderColor', '#CCCCCC');
			}).keyup(function () {
				var content = $(this).val();
				var lengths = check(content);  //调用check函数取得当前字数
				//最大允许输入140个字
				if (lengths[0] >= 140) {
					$(this).val(content.substring(0, Math.ceil(lengths[1])));
				}
				var num = 140 - Math.ceil(lengths[0]);
				var msg = num < 0 ? 0 : num;
				//当前字数同步到显示提示
				$(this).next().children("span").html(msg+"/140");
				
			});
		//评论操作，弹出评论框
		$('.li_showcomment_list').click(function(){			
			//获取评论内容
			//提取当前评论按钮对应微博的ID号
			var weiboDiv=$(this).parents('.weibo');
			var wid=weiboDiv.find('#wbId_p_init').text();
			weiboDiv.find('.comment_loading').show();//发送前先显示加载div
			weiboDiv.find('.comment_modal').toggle();//发送前先评论输入div
			//判断评论列表div是否隐藏，隐藏的话则让它显示
			if(weiboDiv.find('.showcommentList').css('display')=="none"){				
				weiboDiv.find('.showcommentList').show();//显示评论列表div				
				//加载评论数据，异步提取评论内容
				$.ajax({
					type : 'post',
					url : "blog/getComments",
					dataType : "json",
					data : {"wbId" : wid},					
					success : function (data) {
						var Arrs=eval(data);
						if(Arrs.length==0){//评论返回的列表不为空的时候
							weiboDiv.find('.showcommentList').empty();
							weiboDiv.find('.showcommentList').append('<p style="text-align:center;margin-top:20px;">此条圈子动态暂无评论</p>');							
						}else{
							weiboDiv.find('.showcommentList').empty();
					    	$.each(Arrs,function(i,arr){
					    		//对返回的数组进行遍历
					    		var commentdiv1="<div class='comment_all' style='width:490px; margin-top: 5px;overflow: hidden;'><p id='commentId_p_init' style='display:none'>";
								var commentId=arr.commentId;
								var commentdiv2="</p><div style='width: 30px; float: left;'><a class='comment_img'><img src='";
								var commentImg=arr.commentUser.userImage;
						    	var commentdiv3="' width='28' height='28'/></a></div><div class='commen_content_div' style='width: 460px;float: right;'><p id='commentuserId_p_init' style='display:none'>";
						    	var commentUserId=arr.userId;
					    		var commentdiv4="</p><p id='formUserId_p_init' style='display:none'>";
					    		var commentCommentId=arr.fromCommentId;
					    		var commentdiv5="</p><a class='commentname' style='text-decoration: none;float: left;'>";
					    		var commentUserNickName=arr.commentUser.userNickName;
					    		var commentdiv6=":</a><p>";
					    		var commentContent=arr.commentContent;
					    		var commentdiv7=" </p><p class='comment_time'>";
					    		var commentTime=timeStamp2String(arr.commentDate);
					    		var commentdiv8="<a class='reply_comment' style='text-decoration: none; cursor: pointer; float: right;margin-right: 25px; display: none;'>回复</a><a class='delete_comment' style='text-decoration: none; cursor: pointer; float: right;margin-right: 30px;display: none;'>删除</a></p></div>	</div>";
					    		var commentDIV=commentdiv1+commentId+commentdiv2+commentImg+commentdiv3+commentUserId+commentdiv4+commentCommentId+commentdiv5+commentUserNickName+commentdiv6+commentContent+commentdiv7+commentTime+commentdiv8;					    		
					    		weiboDiv.find('.showcommentList').append(commentDIV);  		
					    		weiboDiv.find('.comment_loading').hide();//隐藏加载div
					    	});				    		
						}												
					},
					error:function(){
						weiboDiv.find('.showcommentList').empty();
						weiboDiv.find('.showcommentList').append('<p style="text-align:center;margin-top:20px;">此条圈子动态暂无评论</p>');
						}
				});
				
			}else{
				weiboDiv.find('.comment_loading').hide();//隐藏加载div
				weiboDiv.find('.showcommentList').hide();//评论列表div
			}
	
	});
			
			//提交评论
			$('.comment_modal ul').find('#sendcomment_btn').click(function(){
				var comlistDiv=$(this).parents('.weibo').find('.showcommentList');
				var wbId=$(this).parents('.weibo').find('#wbId_p_init').text();
				var commentContent=$(this).parents('.comment_modal').find('textarea').val();
				var byTurn=$(this).parents('.comment_modal').find('input[type=checkbox]').is(':checked');
				$.ajax({
					type : 'post',
					url : "blog/pushComment",
					dataType : "json",
					data : {"wbId" : wbId,"commentContent" : commentContent,"byTurn" : byTurn},					
					success : function (data) {
						comlistDiv.empty();
						var Arrs=eval(data);
					    	$.each(Arrs,function(i,arr){
					    		//对返回的数组进行遍历
					    		var commentdiv1="<div class='comment_all' style='width:490px; margin-top: 5px;overflow: hidden;'><p id='commentId_p_init' style='display:none'>";
								var commentId=arr.commentId;
								var commentdiv2="</p><div style='width: 30px; float: left;'><a class='comment_img'><img src='";
								var commentImg=arr.commentUser.userImage;
						    	var commentdiv3="' width='28' height='28'/></a></div><div class='commen_content_div' style='width: 460px;float: right;'><p id='commentuserId_p_init' style='display:none'>";
						    	var commentUserId=arr.userId;
					    		var commentdiv4="</p><p id='formUserId_p_init' style='display:none'>";
					    		var commentCommentId=arr.fromCommentId;
					    		var commentdiv5="</p><a class='commentname' style='text-decoration: none;float: left;'>";
					    		var commentUserNickName=arr.commentUser.userNickName;
					    		var commentdiv6=":</a><p>";
					    		var commentContent=arr.commentContent;
					    		var commentdiv7=" </p><p class='comment_time'>";
					    		var commentTime=timeStamp2String(arr.commentDate);
					    		var commentdiv8="<a class='reply_comment' style='text-decoration: none; cursor: pointer; float: right;margin-right: 25px; display: none;'>回复</a><a class='delete_comment' style='text-decoration: none; cursor: pointer; float: right;margin-right: 30px;display: none;'>删除</a></p></div>	</div>";
					    		var commentDIV=commentdiv1+commentId+commentdiv2+commentImg+commentdiv3+commentUserId+commentdiv4+commentCommentId+commentdiv5+commentUserNickName+commentdiv6+commentContent+commentdiv7+commentTime+commentdiv8;					    		
					    		comlistDiv.append(commentDIV);					    		
					    	});
					    	//设置数量+1				    		
				    		var commentNumdtext=comlistDiv.parents('.weibo').find('.wb_tool').find('.li_showcomment_list sup').html();
				    		var commentNumOld = /\d+(?:\.\d+)?/.exec(commentNumdtext);
				    		var commentNum =Number(commentNumOld)+1;
				    		comlistDiv.parents('.weibo').find('.wb_tool').find('.li_showcomment_list sup').html("("+commentNum+")");
				    }
				});					
			});
			//评论列表回复和删除功能显现
			$('.weibo').find('.showcommentList').on('mouseenter','.comment_all',function(){
				var uid=$(this).find('#commentuserId_p_init').text();//获得此评论作者的ID
				var userId=$('#head_mycollapse').find('#userId_navbar').text();//此时登录的用户ID
				if(uid==userId){
					$(this).find('.delete_comment').show();
				}
				$(this).find('.reply_comment').show();
				
			});
			//回复和删除消失
			$('.weibo').find('.showcommentList').on('mouseleave','.comment_all',function(){
				$(this).find('.delete_comment').hide();
				$(this).find('.reply_comment').hide();
			});
			//评论删除操作
			$('.weibo').find('.showcommentList').on('click','.delete_comment',function(){
				var weiboDiv_this=$(this).parents('.weibo');
				var comment_allDIV_this=$(this).parents('.comment_all');
				var commId=$(this).parents('.comment_all').find('#commentId_p_init').text();//此条评论的Id
				var uid=$(this).parents('.comment_all').find('#commentuserId_p_init').text();//此条评论作者Id
				var wbId=$(this).parents('.weibo').find('#wbId_p_init').text();
				var content=$(this).parent().prev().text();
				$('#deleteComment_modal').find('.modal-body p').html(content);
				$('#deleteComment_modal').modal("toggle");
				$('#deleteComment_modal').find('.modal-footer .btn-danger').click(function(){
					$.ajax({
						type : 'post',
						url : "blog/delComment",
						dataType : "json",
						data : {"commentId" : commId,"uid":uid,"wbId":wbId},
						success :function (data){
							var Obj=eval(data);
							comment_allDIV_this.remove();								 							 
							//设置数量更新
						    weiboDiv_this.find('.wb_tool').find('.li_showcomment_list').find('sup').html("("+Obj+")");
						}						
					});
				});		
			});
			//评论回复插入输入框
			$('.weibo').find('.showcommentList').on('click','.reply_comment',function(){
				var comment_allDIV_this=$(this).parents('.comment_all');
				var staterep=$(this).parents('.commen_content_div').children('div').attr("class");
				if(staterep=="replay_input"){
					$(this).parents('.commen_content_div').children('div').remove();
				}else{
					$(this).parents('.commen_content_div').append("<div class='replay_input'><textarea name='' sign='replyComment' style='outline: none;overflow-y:visible'></textarea><ul style='list-style: none;'><li class='phiz fleft' sign=''></li><span style='margin-left: 160px;'><span id='comment1_num'>140</span>/140</span><li class='comment_btn fright' wid='' uid='' id='sendcomment_btn'>评论</li></ul></div>");
				}
			});
			//回复表情功能
			$('.weibo').find('.showcommentList').on('click','.phiz',function(){
				var appedDIV_reply=$(this).parents('.replay_input');
				var textareaCon=appedDIV_reply.find('textarea');
				//定位表情框到对应位置
				$('#phiz_modal').toggle().css({'left' : $(this).offset().left,'top' : $(this).offset().top + $(this).height() + 5});
				//为每个表情图片添加事件
				var phizImg = $("#phiz_modal img");
				var sign = appedDIV_reply.find('textarea').attr('sign');
				for (var i = 0; i < phizImg.length; i++){
					phizImg[i].onclick=function(){
						textareaCon.val(textareaCon.val() + '[' + $(this).attr('title') + ']');
						$('#phiz_modal').hide();
					}
				}				
			});	
			//回复框字数统计	
			$('.weibo').find('.showcommentList').on('focus','textarea',function(){
				$(this).css('borderColor', '#FF9B00');
			});
			$('.weibo').find('.showcommentList').on('blur','textarea',function(){
				$(this).css('borderColor', '#CCCCCC');
			});
			$('.weibo').find('.showcommentList').on('keyup','textarea',function(){
				var content = $(this).val();
				var lengths = check(content);  //调用check函数取得当前字数
				//最大允许输入140个字
				if (lengths[0] >= 140) {
					$(this).val(content.substring(0, Math.ceil(lengths[1])));
				}
				var num = 140 - Math.ceil(lengths[0]);
				var msg = num < 0 ? 0 : num;
				//当前字数同步到显示提示
				$(this).next().children("span").html(msg+"/140");
			});
			//回复ajax
			$('.weibo').find('.showcommentList').on('click','#sendcomment_btn',function(){
				var userImage=$('#right').find('.user_face').children('dt').find('img').attr('src');
				var userNickName=$('#right').find('.user_face').children('dd').text();
				var showcommentListDIV_this=$(this).parents('.showcommentList');
				var commen_contentDIV_this=$(this).parents('.commen_content_div');
				var fromcommId=$(this).parents('.comment_all').find('#commentId_p_init').text();
				var wbId=$(this).parents('.weibo').find('#wbId_p_init').text();
				var objuser=commen_contentDIV_this.find('.commentname').text();
				var commentContent="@"+objuser+"//"+$(this).parents('.comment_all').find('textarea').val();
				$.ajax({
					type : 'post',
					url : "blog/pushComment2",
					dataType : "json",
					data : {"fromcommentId" : fromcommId,"wbId" : wbId,"commentContent" : commentContent},
					success :function (data){
						var Obj=eval(data);
						 if(Obj !=null){
							 	var commentdiv1="<div class='comment_all' style='width:490px; margin-top: 5px;overflow: hidden;'><p id='commentId_p_init' style='display:none'>";
								var commentId=Obj.commentId;
								var commentdiv2="</p><div style='width: 30px; float: left;'><a class='comment_img'><img src='";
								var commentImg=userImage;
						    	var commentdiv3="' width='28' height='28'/></a></div><div class='commen_content_div' style='width: 460px;float: right;'><p id='commentuserId_p_init' style='display:none'>";
						    	var commentUserId=Obj.userId;
					    		var commentdiv4="</p><p id='formUserId_p_init' style='display:none'>";
					    		var commentCommentId=Obj.fromCommentId;
					    		var commentdiv5="</p><a class='commentname' style='text-decoration: none;float: left;'>";
					    		var commentUserNickName=userNickName;
					    		var commentdiv6=":</a><p>";
					    		var commentContent=Obj.commentContent;
					    		var commentdiv7=" </p><p class='comment_time'>";
					    		var commentTime=timeStamp2String(Obj.commentDate);
					    		var commentdiv8="<a class='reply_comment' style='text-decoration: none; cursor: pointer; float: right;margin-right: 25px; display: none;'>回复</a><a class='delete_comment' style='text-decoration: none; cursor: pointer; float: right;margin-right: 30px;display: none;'>删除</a></p></div>	</div>";
					    		var commentDIV=commentdiv1+commentId+commentdiv2+commentImg+commentdiv3+commentUserId+commentdiv4+commentCommentId+commentdiv5+commentUserNickName+commentdiv6+commentContent+commentdiv7+commentTime+commentdiv8;					    		
					    		showcommentListDIV_this.prepend(commentDIV);
					    		commen_contentDIV_this.find('div').remove();
						 }
						//设置数量+1				    		
					    var commentNumdtext=showcommentListDIV_this.parents('.weibo').find('.wb_tool').find('.li_showcomment_list sup').html();
					    var commentNumOld = /\d+(?:\.\d+)?/.exec(commentNumdtext);
					    var commentNum =Number(commentNumOld)+1;
					    showcommentListDIV_this.parents('.weibo').find('.wb_tool').find('.li_showcomment_list sup').html("("+commentNum+")");
						 
					}
				});	
			});

			//转发操作
			$('.li_showturn').click(function(){
				//获取原微内容并添加到转发框
			 	var WbObj = $(this).parents('.wb_tool').prev();//dl节点
			 	var authorObj =$.trim(WbObj.find('.author').html());//获得去掉空格后的原微博userName的a链接
			 	var content = WbObj.find('.content p').html();//获得内容
			 	var cons = '';
			 	//获得author微博Id
			 	var turnid=$(this).parents('.weibo').find('#authorwbId_p_init').text();
			 	if(turnid!=0){
			 		authorObj = WbObj.find('.author a').html();
			 		cons = replace_weibo(' // @' + authorObj + ' : ' + content);
			 		authorObj = $.trim(WbObj.find('.turn_name').html());
			 		content = WbObj.find('.turn_cons p').html();
			 		$('#turnModal').toggle();
			 	}
			 	$('.turn_main p').html(authorObj + ' : ' + content);//把原微博内容添加到转发框的预览信息里面
			 	$('.turn-cname').html($.trim(WbObj.find('.author').html()));//附上需要同事评论的人
			 	$('form[name=turn] textarea').val(cons);//多重转发时把此微博内容添加到转发输入框内
			 	//提取原微博ID
			 	var authorWbId=$(this).parents('.weibo').find('#wbId_p_init').text();
			 	$('form[name=turn] input[name=authorWbId]').val(authorWbId);
			 	//隐藏表情框
			 	$('#phiz_modal').hide();
			 	//点击转发创建透明背景层
			 	createBg('opacity_bg');
			 	//定位转发框居中
			 	var turnLeft = ($(window).width() - $('#turnModal').width()) / 2;
			 	var turnTop = $(document).scrollTop() + ($(window).height() - $('#turnModal').height()) / 2;
			 	
			 	$('#turnModal').css({
			 		'left' : turnLeft,
			 		'top' : turnTop
			 	}).fadeIn().find('textarea').focus(function () {
			 		$(this).css('borderColor', '#FF9B00').keyup(function () {
						var content = $(this).val();
						var lengths = check(content);  //调用check函数取得当前字数
						//最大允许输入140个字
						if (lengths[0] >= 140) {
							$(this).val(content.substring(0, Math.ceil(lengths[1])));
						}
						var num = 140 - Math.ceil(lengths[0]);
						var msg = num < 0 ? 0 : num;
						//当前字数同步到显示提示
						$('#turn_num').html(msg);
					});
			 	}).focus().blur(function () {
			 		$(this).css('borderColor', '#CCCCCC');	//失去焦点时还原边框颜色
			 	});
			});
			//关闭转发框
			$('.close_turn').hover(function () {
				$(this).css('backgroundPosition', '-100px -200px');
			}, function () {
				$(this).css('backgroundPosition', '-75px -200px');
			}).click(function () {
				$(this).parents('#turnModal').hide();
				$('#opacity_bg').remove();
			});
			//拖拽转发框
			drag($('#turnModal'), $('.turn_text'));








			/**
			 * 获得通知数量函数
			 */
			function messageMum () {
				$.ajax({
					type : 'post',
					url : "user/getMessageNum",
					dataType : "json",
					data : {"userId" :$('#userId_navbar').text()},
					success :function (data){
						var Obj=eval(data);
						 var spanThis=$('#left').find('.messageLeftList').find('span');
						 if(spanThis.length>0){
							 var NumNew=Obj.userAdviceNum.sumNum;
							 $('#left').find('.messageLeftList').find('span').html(NumNew);
						 }else{
							 if(Obj.userAdviceNum.sumNum>0){
								 $('#left').find('.messageLeftList').append("<span class='badge' style='color: red;background-color: #C9EBF4;'>"+Obj.userAdviceNum.sumNum+"</span>");
							 }						
						 }
					},
					error:function(){
						//关掉timer1
						clearInterval(timer1);
					}
				});
			}




			
});
/**
 * 统计字数
 * @param  字符串
 * @return 数组[当前字数, 最大字数]
 */
function check (str) {
	var num = [0, 140];
	for (var i=0; i<str.length; i++) {
		//字符串不是中文时
		if (str.charCodeAt(i) >= 0 && str.charCodeAt(i) <= 255){
			num[0] = num[0] + 0.5;//当前字数增加0.5个
			num[1] = num[1] + 0.5;//最大输入字数增加0.5个
		} else {//字符串是中文时
			num[0]++;//当前字数增加1个
		}
	}
	return num;
}
/**
 * 替换微博内容，去除 <a> 链接与表情图片
 */
function replace_weibo (content) {
	content = content.replace(/<img.*?title=['"](.*?)['"].*?\/?>/ig, '[$1]');
	content = content.replace(/<a.*?>(.*?)<\/a>/ig, '$1');
	return content.replace(/<span.*?>\&nbsp;(\/\/)\&nbsp;<\/span>/ig, '$1');
}
/**
 * 格式化时间
 */
function timeStamp2String(time){
    var datetime = new Date();
    datetime.setTime(time);
    var year = datetime.getFullYear();
    var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
    var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
    var hour = datetime.getHours()< 10 ? "0" + datetime.getHours() : datetime.getHours();
    var minute = datetime.getMinutes()< 10 ? "0" + datetime.getMinutes() : datetime.getMinutes();
    var second = datetime.getSeconds()< 10 ? "0" + datetime.getSeconds() : datetime.getSeconds();
    return year + "-" + month + "-" + date+" "+hour+":"+minute+":"+second;
}





