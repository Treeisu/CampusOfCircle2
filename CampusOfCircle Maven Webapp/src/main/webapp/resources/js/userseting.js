$(function(){
	//修改资料选项卡
	$('#sel-edit li').click( function () {
		var index = $(this).index();
		$(this).addClass('edit-cur').siblings().removeClass('edit-cur');
		$('.form').hide().eq(index).show();
	});
	//城市联动
	var province = '';
	
	$.each(city, function (i, k) {
		province += '<option value="' + k.name + '" index="' + i + '">' + k.name + '</option>';
	});
	$('select[name=province]').append(province).change(function () {
		var option = '';
		if ($(this).val() == '') {
			option += '<option value="">请选择</option>';
		} else {
			var index = $(':selected', this).attr('index');
			var data = city[index].child;
			for (var i = 0; i < data.length; i++) {
				option += '<option value="' + data[i] + '">' + data[i] + '</option>';
			}
		}
		
		$('select[name=city]').html(option);
	});

	//所在地默认选项(根据user的地址来选择，address就是user的地址)
	var adds=$('#userAdd').text();
	var address= new Array(); 
	address = adds.split(" ");
	$('select[name=province]').val(address[0]);
	$.each(city, function (i, k) {
		if (k.name == address[0]) {
			var str = '';
			for (var j in k.child) {
				str += '<option value="' + k.child[j] + '" ';
				if (k.child[j] == address[1]) {
					str += 'selected="selected"';
				}
				str += '>' + k.child[j] + '</option>';
			}
			$('select[name=city]').html(str);
		}
	});
	//性别默认设置
	var sex_p=$('#usersex_p').text();
	if(sex_p==1){
		$('#usersex_p').next().next().find('input:eq(0)').attr('checked', 'checked');
		$('#usersex_p').next().next().find('input:eq(0)').parent().addClass('active');
	}else{
		$('#usersex_p').next().next().find('input:eq(1)').attr('checked', 'checked');
		$('#usersex_p').next().next().find('input:eq(1)').parent().addClass('active');
	}
	
	
		//头像上传预览
		$('#faceupload').on('change',function(){
			var f1 = document.getElementById('faceupload').files[0];
			var pic_src = window.URL.createObjectURL(f1);
			$(this).parents('.edit-face').find('#face-img').attr('src',pic_src);	
		});
		//密码修改
		$('#changepwd').on('click',function(){
			if($("#pwd2").val()!=$("#pwd3").val()){
				var divs="<div class='alert alert-danger' role='alert'> <button class='close' type='button' data-dismiss='alert'>&times;</button>两次密码不一致！</div>";
				$('#changepwd').parent().parent().parent().find('form').before(divs);
			}else{
				$.ajax({
					type:"POST",
					url:"user/pwdChange",
					dataType:"json",
					data:{"pwd1":$("#pwd1").val(),"pwd3":$("#pwd3").val()},
					success:function(data){
						if(data==0){
							var divs1="<div class='alert alert-danger' role='alert'> <button class='close' type='button' data-dismiss='alert'>&times;</button>原密码错误！</div>";
							$('#changepwd').parent().parent().parent().find('form').before(divs1);
						}else{
							var divs2="<div class='alert alert-success' role='alert'> <button class='close' type='button' data-dismiss='alert'>&times;</button>密码修改成功!</div>";
							$('#changepwd').parent().parent().parent().find('form').before(divs2);
							$('#pwdform').find('input[type=password]').val("");
						}
						
					}
				});
			}
		});

	
	
	
});