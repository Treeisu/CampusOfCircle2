
$(function(){
		$('.replycommentThis').click(function(){
			var DIV=$(this).parents('.commentDIV');
			var commentIdThis=$(this).parents('.commentDIV').find('.commentIdThis').text();
			var wbId=$(this).parents('.commentDIV').find('.messageWbId').text();
			var name=$(this).parents('.commentDIV').find('.messageFromUserName').text();
			
			$('#commentModal').find('.modal-body').find('input').val("@"+name);
			$('#commentModal').modal("toggle");
			/**
			 * 回复评论
			 */
			$('#commentModal').find('.modal-footer').find('.btn-success').click(function(){
				var commentContent=$(this).parents('#commentModal').find('.modal-body').find('input').val();
				$.ajax({
					type : 'post',
					url : "blog/pushComment2",
					dataType : "json",
					data : {"userId" :$('#userId_navbar').text(),"wbId":wbId,"fromcommentId":commentIdThis,"commentContent":commentContent},
					success :function (data){
						$('#commentModal').modal("hide");
					}
				});
			});
			
		});
		$('.delcommentThis').click(function(){
			var DIV=$(this).parents('.commentDIV');
			var commentIdThis=$(this).parents('.commentDIV').find('.commentIdThis').text();
			var wbId=$(this).parents('.commentDIV').find('.messageWbId').text();
			var content=$(this).parents('.commentDIV').find('.commentContentThis').text();
			$('#deleteComment_modal').find('.modal-body').find('p').html(content);
			$('#deleteComment_modal').modal("toggle");
			/**
			 * 删除评论
			 */
			$('#deleteComment_modal').find('.modal-footer').find('.btn-danger').click(function(){
				$.ajax({
					type : 'post',
					url : "blog/delComment",
					dataType : "json",
					data : {"wbId":wbId,"commentId":commentIdThis},
					success :function (data){
						DIV.remove();
					}
				});
			});
			
			
		});
		
		
		
		
		
});


/**
 * 格式化时间
 */
function timeStampString(time){
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


