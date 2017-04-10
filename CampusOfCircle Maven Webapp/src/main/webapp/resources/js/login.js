$(function(){
	
	$('#switch_qlogin').click(function(){
		$('#switch_login').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_qlogin').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_bottom').animate({left:'0px',width:'70px'});
		$('#qlogin').css('display','none');
		$('#web_qr_login').css('display','block');
		
	});
	$('#switch_login').click(function(){
		
		$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
		$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
		$('#switch_bottom').animate({left:'154px',width:'70px'});
		
		$('#qlogin').css('display','block');
		$('#web_qr_login').css('display','none');
	});
		if(getParam("a")=='0')
		{
			$('#switch_login').trigger('click');
		}
		
		
		
		
//判断部分******************************************		
		//login模块提示信息消失
		$('#u').click(function(){
			$('#log_msg_div').hide();
		});
		
		
			//用户名进行判断
			$('#user').blur(function(){
				//用户名不能为空
				if ($('#user').val() == "") {
					$('#user').css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$('#userinfo').html("<font color='red'><b>×用户名不能为空</b></font>");
					return false;
				}
				//用户名长度为4-16位
				if ($('#user').val().length < 4 || $('#user').val().length > 16) {

					$('#user').css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$('#userinfo').html("<font color='red'><b>×用户名位4-16字符</b></font>");
					return false;
				}
				else{
					$('#userinfo').html("");
					$('#user').css({
						border: "1px solid blue",
						boxShadow: "0 0 2px blue"

					});
				}
			});
			//密码进行判断
			$('#passwd').blur(function(){
				var pwdnum=6;
				//对注册时输入的密码进行判断
				if ($('#passwd').val().length < pwdnum) {
					$('#passwd').css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$('#pwdinfo').html("<font color='red'><b>×密码不能小于" + pwdnum + "位</b></font>");
					return false;
				}
				else{
					$('#pwdinfo').html("");
					$('#passwd').css({
						border: "1px solid blue",
						boxShadow: "0 0 2px blue"

					});
				}
			});
			//密码二次进行判断
			$('#passwd2').blur(function(){
				//确认密码的判断
				if (($('#passwd2').val() != $('#passwd').val())||$('#passwd2').val()=="") {
					$('#passwd2').css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$('#pwdinfo2').html("<font color='red'><b>×两次密码不一致！</b></font>");
					return false;
				}
				else{
					$('#pwdinfo2').html("");
					$('#passwd2').css({
						border: "1px solid blue",
						boxShadow: "0 0 2px blue"

					});
				}
			});
			//手机号进行判断
			$('#qq').blur(function(){
				var reg = /^1[3|4|5|7|8][0-9]{9}$/; //验证规则
				var phoneNum =$('#qq').val();//手机号码
				var flag = reg.test(phoneNum);
				if(flag){
					$('#phoneinfo').html("");
					$('#qq').focusout(function(){
						$.ajax({
							type:"POST",
							url:"user/phone",
							dataType:"json",
							data:{"userPhone":$("#qq").val()},
							success:function(data){
//								console.log(data[0].userNickName);
								var Arrs=eval(data);
								if(Arrs[0]==null){
									$('#qq').css({
										border: "1px solid blue",
										boxShadow: "0 0 2px blue"	
									});
									$('#userCue').html("<font color='blue'><b>√可注册</b></font>");
								}else{
									$('#qq').css({
										border: "1px solid red",
										boxShadow: "0 0 2px red"
									});
									$('#phoneinfo').html("<font color='red'><b>×该手机号"+Arrs[0].userPhone+"已经注册</b></font>");
								}
							}
						});
					});
					
				}else{
					$('#qq').css({
						border: "1px solid red",
						boxShadow: "0 0 2px red"
					});
					$('#phoneinfo').html("<font color='red'><b>×手机号码格式不正确</b></font>");
					return false;
				}
				
		});	
				
		
		
		//注册按钮改变url******************************************	
		$('#reg').click(function(){
			var infonull=$('#phoneinfo').html()==""&&$('#pwdinfo2').html()==""&&$('#pwdinfo').html()==""&&$('#userinfo').html()=="";
			var inputnoutnull=$('#qq').val()==""||$('#passwd2').val()==""||$('#passwd').val()==""||$('#user').val()=="";
			if(inputnoutnull){
				$("#reg_form").attr("action","");//设置form的action为新的请求
				$('#userCue').html("<font color='red'><b>您还未填写注册信息</b></font>");
			}else{
				if(infonull){
					
						
					$("#reg_form").attr("action","user/reg");//设置form的action为新的请求
					$("#reg_form").submit();
						
				}else{
					$("#reg_form").attr("action","");//设置form的action为新的请求
					$('#userCue').html("<font color='red'><b>请填正确写注册信息</b></font>");
				}
			}
			
			
				
		});



		
		
		
		
});




function logintab(){
	scrollTo(0);
	$('#switch_qlogin').removeClass("switch_btn_focus").addClass('switch_btn');
	$('#switch_login').removeClass("switch_btn").addClass('switch_btn_focus');
	$('#switch_bottom').animate({left:'154px',width:'96px'});
	$('#qlogin').css('display','none');
	$('#web_qr_login').css('display','block');
	
}
//根据参数名获得该参数 pname等于想要的参数名 
function getParam(pname) { 
    var params = location.search.substr(1); // 获取参数 平且去掉？ 
    var ArrParam = params.split('&'); 
    if (ArrParam.length == 1) { 
        //只有一个参数的情况 
        return params.split('=')[1]; 
    } 
    else { 
         //多个参数参数的情况 
        for (var i = 0; i < ArrParam.length; i++) { 
            if (ArrParam[i].split('=')[0] == pname) { 
                return ArrParam[i].split('=')[1]; 
            } 
        } 
    } 
}  


