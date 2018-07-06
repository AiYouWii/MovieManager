$(function(){
	var basePath = '127.0.0.1'
	var login_btn = $('.login-btn');
	function check_user(){
		//获取登陆用户的用户名和密码
		var status = false;
		var user = $("input[name='user']").val();
		var pass = $("input[name='pass']").val();
		//var myreg=/^[1][3,4,5,7,8][0-9]{9}$/;  
		if (!user){
			layer.msg('请输入管理员账号'); 
			layer.tips('请输入管理员账号', $("input[name='user']"), {
				tipsMore: true
			});
		}else if((!pass) || pass.length < 6 ){
			layer.msg('请输入正确的密码'); 
			layer.tips('请输入正确的密码', $("input[name='pass']"), {
				tipsMore: true
			});
		}else{
			status = true;
		}
		return status;
	}

	login_btn.on('click', function(){
		var status = check_user();
		if(status){
//			layer.msg('正在为您跳转哦', function(){
//				window.location.href = 'index.html';
//			});	

			 var user = $("input[name='user']").val();
			 var pass = $("input[name='pass']").val();
			 $.ajax({
			 	url: '/Manager/admin/AdminLogin',
			 	type: 'POST',
			 	data: {
			 		user: user,
			 		pass: pass
			 	},
			 	success: function(data){
			 		if(typeof data != 'object'){
			 			data = eval('('+data+')');
			 		}
			 		if(data.status == '1'){
			 			layer.msg('正在为您跳转哦', function(){
			 				window.location.href = '/Manager/admin/index.jsp';
			 			});	
			 		}else{
			 			layer.msg('登陆失败,请确认登陆信息'); 
			 		}
			 	}
			 })
		}
		
	})
})