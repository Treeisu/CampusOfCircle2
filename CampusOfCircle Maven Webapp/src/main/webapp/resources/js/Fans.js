$(function(){
	/**
	 * ============以下是关注和粉丝页面js===========
	 */
	/**
	 * 重新分组
	 */	
		$('.media').find('.media-body').find('.resetGroup2').click(function(){
			var userId=$('#userId_navbar').text();
			var fanId=$(this).parents('.media-body').find('.fanId').text();
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
			$('#attention_modal').find('.modal-footer input').attr('value','修改分组')
			$('#attention_modal').modal("toggle");
			//改变关注的分组
			$('#attention_modal').find('.btn-success').click(function(){
				//分组Id
				var groupId=$(this).parents('#attention_modal').find('select option:selected').attr('class');
				$.ajax({
					type : 'post',
					url : "attention/changeAttention2",
					dataType : "json",
					data : {"groupId" : groupId,"fanId":fanId},
					success :function (data){
						window.location.href='/CampusOfCircle/userFansTo';				
					}		
				});	
			});						
		});
		$('.media').find('.media-body').find('.delattention2').click(function(){
			var fanId=$(this).parents('.media-body').find('.fanId').text();
			var toUserName=$(this).parents('.media-body').find('.toUserName').text();
			$('#delete_modal').find('.modal-header h4').html('确定取消对['+toUserName+']的关注？');
			$('#delete_modal').find('.modal-footer').find('.btn-danger').html('取消关注');
			$('#delete_modal').modal('toggle');
			$('#delete_modal').find('.modal-footer').find('.btn-danger').click(function(){
				$.ajax({
					type : 'post',
					url : "attention/delAttention2",
					dataType : "json",
					data : {"fanId":fanId},
					success :function (data){
						window.location.href='/CampusOfCircle/userFansTo';				
					}		
				});	
			});
		});
		/**
		 * 移除粉丝
		 */
		$('.media').find('.media-body').find('.delfans2').click(function(){
			var fanId=$(this).parents('.media-body').find('.fanId').text();
			var fanUserId=$(this).parents('.media-body').find('.fanUserId').text();
			$.ajax({
				type : 'post',
				url : "attention/delFan2",
				dataType : "json",
				data : {"fanId":fanId,"attentionUserId":fanUserId},
				success :function (data){
					var Obj=eval(data);
					window.location.href='/CampusOfCircle/userFansTo';				
				}		
			});
	
		});
		/**
		 * 加关注
		 */
		$('.media').find('.media-body').find('.addATT').click(function(){
			var toUserId=$(this).parents('.media-body').find('.fanUserId').text();
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
		
		
		
		
	
});