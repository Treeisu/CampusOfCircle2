$(function(){
	/**
	 * ============以下是关注和粉丝页面js===========
	 */
	/**
	 * 重新分组
	 */	
		$('.media').find('.media-body').find('.resetGroup').click(function(){
			var userId=$('#userId_navbar').text();
			var attentionId=$(this).parents('.media-body').find('.attentionId').text();
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
					url : "attention/changeAttention",
					dataType : "json",
					data : {"groupId" : groupId,"attentionId":attentionId},
					success :function (data){
						window.location.href='/CampusOfCircle/userAttentionTo';				
					}		
				});	
			});						
		});
		/**
		 * 取消关注
		 */
		$('.media').find('.media-body').find('.delattention').click(function(){
			var attentionId=$(this).parents('.media-body').find('.attentionId').text();
			var toUserName=$(this).parents('.media-body').find('.toUserName').text();
			$('#delete_modal').find('.modal-header h4').html('确定取消对['+toUserName+']的关注？');
			$('#delete_modal').find('.modal-footer').find('.btn-danger').html('取消关注');
			$('#delete_modal').modal('toggle');
			$('#delete_modal').find('.modal-footer').find('.btn-danger').click(function(){
				$.ajax({
					type : 'post',
					url : "attention/delAttention",
					dataType : "json",
					data : {"attentionId":attentionId},
					success :function (data){
						window.location.href='/CampusOfCircle/userAttentionTo';				
					}		
				});	
			});
		});
		$('.media').find('.media-body').find('.delattention2').click(function(){
			var fanId=$(this).parents('.media-body').find('.attentionId').text();
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
						window.location.href='/CampusOfCircle/userAttentionTo';				
					}		
				});	
			});
		});
		/**
		 * 移除粉丝
		 */
		$('.media').find('.media-body').find('.delfans').click(function(){
			var attentionId=$(this).parents('.media-body').find('.attentionId').text();
			var attentionUserId=$(this).parents('.media-body').find('.attentionUserId').text();
			$.ajax({
				type : 'post',
				url : "attention/delFan",
				dataType : "json",
				data : {"attentionId":attentionId,"attentionUserId":attentionUserId},
				success :function (data){
					var Obj=eval(data);
					window.location.href='/CampusOfCircle/userAttentionTo';				
				}		
			});
	
		});
		
		
		
		
		
		
	
});