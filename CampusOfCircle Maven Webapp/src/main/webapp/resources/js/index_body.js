
$(function(){
		/**
		 * 用户退出
		 */
		$('#li_user_dropdown').find('ul').hover(function(){
			var a_exit=$(this).children(':last').find('a');
			a_exit.attr('href','user/exit');
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
		
		//收藏操作
		$('.li_collection').click(function(){
			var stateClass=$(this).find('span').attr("class");
			
			if(stateClass=="iconII iconII-collection"){
				$(this).find('span').removeClass('iconII-collection');
				$(this).find('span').addClass('iconII-collection2');
				$('#collection_modal').find('h4').html('已成功收藏！');
				$('#collection_modal').find('.alert').removeClass('alert-warning');
				$('#collection_modal').find('.alert').addClass('alert-success');
				$('#collection_modal').modal('show');
				setTimeout(function(){$('#collection_modal').modal('hide');},650);
			}else{
				$(this).find('span').removeClass('iconII-collection2');
				$(this).find('span').addClass('iconII-collection');
				$('#collection_modal').find('h4').html('已取消收藏！');
				$('#collection_modal').find('.alert').removeClass('alert-success');
				$('#collection_modal').find('.alert').addClass('alert-warning');
				$('#collection_modal').modal('show');
				setTimeout(function(){$('#collection_modal').modal('hide');},650);
			}	
		});
		//点赞操作
		$('.li_praise').click(function(){
		
			var stateClass=$(this).find('span').attr("class");
			
			if(stateClass=="iconII iconII-praise"){
				$(this).find('span').removeClass('iconII-praise');
				$(this).find('span').addClass('iconII-praise2');
				//我觉得很赞显现
				$(this).parent().parent().next().show();
			}else{
				$(this).find('span').removeClass('iconII-praise2');
				$(this).find('span').addClass('iconII-praise');
				//我觉得很赞消失
				$(this).parent().parent().next().hide();
			}
			
		});
		//删除按钮显现
		$('.weibo').hover(function () {
				var blogUserId=$(this).find('#userId_p_init').text();
				var uid=$('#head_mycollapse').find('#userId_navbar').text();
				if(blogUserId=uid){
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
		//评论操作，弹出评论框
		$('.li_showcomment_list').click(function(){			
			//获取评论内容
			//提取当前评论按钮对应微博的ID号
			var weiboDiv=$(this).parents('.weibo');
			var wid=weiboDiv.find('#wbId_p_init').text();
			weiboDiv.find('.comment_loading').show();//发送前先显示加载div
			weiboDiv.find('.comment_modal').toggle();//发送前先评论输入div
			//判断评论列表div是否隐藏，隐藏的话则让它显示
			if(weiboDiv.find('.showcommentList').style.display=="none"){
				weiboDiv.find('.comment_loading').hide();//隐藏加载div
				weiboDiv.find('.showcommentList').show();//显示评论列表div				
				//加载评论数据，异步提取评论内容
				$.ajax({
					type : 'post',
					url : "blog/getComments",
					dataType : "json",
					data : {"wbId" : wid},					
					success : function (data) {
						if(data.lengt==0){//评论返回的列表不为空的时候
							weiboDiv.find('.showcommentList').empty();
							weiboDiv.find('.showcommentList').append('<p style="text-align:center;margin-top:20px;">此条圈子动态暂无评论</p>');							
						}else{			    		
					    	$.each(data,function(i,value){
					    		//对返回的数组进行遍历
					    		var commentdiv1="<div class='comment_all' style='width:490px; margin-top: 5px;overflow: hidden;'><p id='commentId_p_init' style='display:none'>";
								var commentId=value.commentId;
								var commentdiv2="</p><div style='width: 30px; float: left;'><a class='comment_img'><img src='";
								var commentImg=value.commentUser.userImage;
						    	var commentdiv3="' width='28' height='28'/></a></div><div class='commen_content_div' style='width: 460px;float: right;'><p id='commentuserId_p_init' style='display:none'>";
						    	var commentUserId=value.userId;
					    		var commentdiv4="</p><p id='formUserId_p_init' style='display:none'>";
					    		var commentCommentId=value.fromCommentId;
					    		var commentdiv5="</p><a class='commentname' style='text-decoration: none;float: left;'>";
					    		var commentUserNickName=value.commentUser.userNickName;
					    		var commentdiv6=":</a><p>";
					    		var commentContent=value.commentContent;
					    		var commentdiv7=" </p><p class='comment_time'><fmt:formatDate value='";
					    		var commentTime=value.commentDate;
					    		var commentdiv8="' pattern='yyyy-MM-dd HH:mm:ss'/><a class='reply_comment' style='text-decoration: none; cursor: pointer; float: right;margin-right: 10px; display: none;'>回复</a><a class='delete_comment' style='text-decoration: none; cursor: pointer; float: right;margin-right: 20px;display: none;'>删除</a></p></div>	</div>";
					    		var commentDIV=commentdiv1+commentId+commentdiv2+commentImg+commentdiv3+commentUserId+commentdiv4+commentCommentId+commentdiv5+commentUserNickName+commentdiv6+commentContent+commentdiv7+commentTime+commentdiv8;					    		
					    		weiboDiv.find('.showcommentList').ppend(commentDIV);  		
					    	});
				    		
						}												
					}
				});
				
			}else{
				weiboDiv.find('.comment_loading').hide();//隐藏加载div
				weiboDiv.find('.showcommentList').hide();//评论列表div
			}
				
		}
	});
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
			//提交评论
			$('.comment_modal ul').find('#sendcomment_btn').click(function(){
				var wbId=$(this).parents('.weibo').find('#wbId_p_init').text();
				var commentContent=$(this).parents('.comment_modal').find('textarea').val();
				var byTurn=$(this).parents('.comment_modal').find('input[type=checkbox]').val();
				$.ajax({
					type : 'post',
					url : "blog/pushComment",
					dataType : "json",
					data : {"wbId" : wid,"commentContent" : commentContent,"byTurn" : byTurn},					
					success : function (data) {	
						if(data != null){//发表评论成功的时候
							var commentdiv1="<div class='comment_all' style='width:490px; margin-top: 5px;overflow: hidden;'><p id='commentId_p_init' style='display:none'>";
							var commentId=data.commentId;
							var commentdiv2="</p><div style='width: 30px; float: left;'><a class='comment_img'><img src='";
							var commentImg=data.commentUser.userImage;
					    	var commentdiv3="' width='28' height='28'/></a></div><div class='commen_content_div' style='width: 460px;float: right;'><p id='commentuserId_p_init' style='display:none'>";
					    	var commentUserId=data.userId;
				    		var commentdiv4="</p><p id='formUserId_p_init' style='display:none'>";
				    		var commentCommentId=data.fromCommentId;
				    		var commentdiv5="</p><a class='commentname' style='text-decoration: none;float: left;'>";
				    		var commentUserNickName=data.commentUser.userNickName;
				    		var commentdiv6=":</a><p>";
				    		var commentContent=data.commentContent;
				    		var commentdiv7=" </p><p class='comment_time'><fmt:formatDate value='";
				    		var commentTime=data.commentDate;
				    		var commentdiv8="' pattern='yyyy-MM-dd HH:mm:ss'/><a class='reply_comment' style='text-decoration: none; cursor: pointer; float: right;margin-right: 10px; display: none;'>回复</a><a class='delete_comment' style='text-decoration: none; cursor: pointer; float: right;margin-right: 20px;display: none;'>删除</a></p></div>	</div>";
				    		
				    		var commentDIV=commentdiv1+commentId+commentdiv2+commentImg+commentdiv3+commentUserId+commentdiv4+commentCommentId+commentdiv5+commentUserNickName+commentdiv6+commentContent+commentdiv7+commentTime+commentdiv8;				    		
					    	$(this).parents('.weibo').find('.showcommentList').ppend(commentDIV);							
						}												
					}
				});
				
				
			});
			
			
			//评论列表回复链接
			$('.comment_all').hover(function(){
				//回复链接
				$(this).children(':first').next().children(':first').next().next().children(':first').toggle();
				//删除链接
				$(this).children(':first').next().children(':first').next().next().children(':first').next().toggle();
			});
				//点击回复链接
				$('.reply_comment').click(function(){
					var staterep=$(this).parent().parent().children('div').attr("class");

					if(staterep=="undefined"){
						$(this).parent().parent().append("<div class='replay_input'><textarea name='' sign='replyComment' style='outline: none;overflow-y:visible'></textarea><ul style='list-style: none;'><li class='phiz fleft' sign=''></li><span style='margin-left: 160px;'><span id='comment1_num'>140</span>/140</span><li class='comment_btn fright' wid='' uid='' id='sendcomment_btn'>评论</li></ul></div>");
					}else if(staterep=="replay_input"){
						$(this).parent().parent().children('div').remove();
					}else{
						$(this).parent().parent().append("<div class='replay_input'><textarea name='' sign='replyComment' style='outline: none;overflow-y:visible'></textarea><ul style='list-style: none;'><li class='phiz fleft' sign=''></li><span style='margin-left: 160px;'><span id='comment1_num'>140</span>/140</span><li class='comment_btn fright' wid='' uid='' id='sendcomment_btn'>评论</li></ul></div>");
					}
					
				});
				//回复评论的表情功能
				$('.commen_content_div').on('click','div ul .phiz',function(){
		  			var textareaCon=$(this).parents('.comment_all').find('textarea');
//		  			alert(textareaCon.attr('class'));
		  			//定位表情框到对应位置
					$('#phiz_modal').toggle().css({
						'left' : $(this).offset().left,
						'top' : $(this).offset().top + $(this).height() + 5
		    		});
		    		//为每个表情图片添加事件
		            var phizImg = $("#phiz_modal img");	
		            var sign = $(this).children(':first').attr('sign');
		            for (var i = 0; i < phizImg.length; i++){
		            	phizImg[i].onclick = function () {
						textareaCon.val(textareaCon.val() + '[' + $(this).attr('title') + ']');
						$('#phiz_modal').hide();
		            	}
		            }
				});
				 //回复评论框字数变化
		        $('.commen_content_div').on('focus','textarea',function(){
		            $(this).css('borderColor', '#FF9B00');
		        });$('.commen_content_div').on('blur','textarea',function(){
		            $(this).css('borderColor', '#CCCCCC');
		        });$('.commen_content_div').on('keyup','textarea',function(){		            
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
			//转发操作
			$('.li_showturn').click(function(){
				//获取原微内容并添加到转发框
			 	var WbObj = $(this).parents('.wb_tool').prev();//dl节点
			 	var authorObj =$.trim(WbObj.find('.author').html());//获得去掉空格后的原微博userName的a链接
			 	var content = WbObj.find('.content p').html();//获得内容
			 	var turnid = $(this).find('span').attr('turnid') ? $(this).find('span').attr('turnid') : 0;
			 	var cons = '';
			 	//turnid为1，表示为多重转发时
			 	if(turnid){
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
			 	$('form[name=turn] input[name=id]').val($(this).attr('id'));
			 	$('form[name=turn] input[name=tid]').val(turnid);
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

