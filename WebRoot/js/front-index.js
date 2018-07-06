$(function(){
	// 主页菜单
	var login_regist_index = '';
	var user_info_index = '';
	var vip_leval = {
		"1":  "水晶会员",
		"2":  "钻石会员",
		"3":  "黄金会员",
		"4":  "白银会员",
		"5":  "青铜会员",
	}
	layui.util.fixbar({
		bar1: '&#xe68e;',
		bar2: '&#xe857;',
		bar3: '&#xe6ed;',
		bar4: '&#xe62e;',
		bar5: '&#xe634;',
		css: {left: 4, top: 70, right: 9000, bottom: 9000},
		// bgcolor: '#393D49;font-size:45px;width:105px;height:85px;line-height:85px;',
		style: 'background-color:#393D49;font-size:45px;width:105px;height:85px;line-height:85px;color:white;font-weight: bolder;border-bottom:1px solid #555;',
		hover: 'orange',
		bgcolor: '#393D49',
		click: function(type){
			if(type === 'bar1'){
				//显示主页
				$('.content').css('display', '');
				$('.content-list').css('display', 'none');
			}else if(type === 'bar2') {
				//显示影片列表页
				$('.content').css('display', 'none');
				$('.content-list').css('display', '');
			}else if(type === 'bar3'){
				//显示自己购买过的影票信息
				var user_id = '';
				var status = false;
				$.ajax({
					url: '/Manager/home/checkLogin',
					type: 'POST',
					data: {},
					async:false,
					success:function(res){
						if(typeof res !='object'){
							res = eval('('+res+')');
						}
						if(res.success==1){
							user_id = res.data.id;
							discount = res.data.vip.discount?res.data.vip.discount:100;
							status = true;
						}else{
							layer.msg(res.msg);
						}
					}
				})
				if(status){
					var content = '<div style="padding: 20px;">你还没有购买过电影票哦!!</div>';
					$.ajax({
						url: '/Manager/Ticket/getTicketInfoByUid',
						type: 'POST', 
						data: {user_id: user_id},
						async:false,
						success: function(res){
							if(typeof res !='object'){
								res = eval('('+res+')');
							}
							console.log(res.data);
							if(res.data.length>0){
								content = '<div style="padding: 20px;margin:20px;"><ul class="layui-timeline">';
								$.each(res.data, function(k, val){
									content += '<li class="layui-timeline-item">'+
									    '<i class="layui-icon layui-timeline-axis">&#xe63f;</i>'+
									    '<div class="layui-timeline-content layui-text">'+
									      '<h3 class="layui-timeline-title">'+val.createTime+'</h3>'+
									      '<p>订单编号:'+ val.orderNum+'<br>电影名称:'+ val.movieaction.movie.name+'<br>观影时间: '+val.movieaction.actionTime+'<br>影厅:'+ val.movieaction.hall.hall_name+'<br></p>'+
									      '<p>购票张数:'+val.number+'<br>影片票价: ￥'+ val.movieaction.movie.ticket_price+'/张</p>'+
								        '</div>'+
									  '</li>';
								})
								content += '</ul></div>';
							}
							return content;
						}
					})
					layer.open({
						type: 1,
						title: '购票历史',
						closeBtn: 2,
						area: ['900px'],
//						shadeClose: true,
						// skin: 'layui-layer-nobg',
						content: content,
					});
					
				}
			}else if(type === 'bar4'){
				$.ajax({
					url: '/Manager/home/checkLogin',
					type: 'POST',
					data: {},
					success: function(res){
						if(typeof res != 'object'){
							res = eval('('+res+')');
							if(res.success == 1){
								console.log(res.data);
								user_info_index = layer.open({
									type: 1,
									title: '个人信息',
									area: ['550px'],
									content: '<div id="user-info">'+
										'<div style="display: flex;justify-content:space-between;line-height:120px; ">'+
									'<div class="layui-inline">'+
									  '<img src="../public/Ali.jpg" class="layui-circle" style="width:80px;height:80px;border: 2px solid #aaa;margin-left: 15px;">'+
									  '<div class="layui-inline">'+
									  	'<span style="font-size: 16px;clolor: #333;margin:0 5px 0 25px;font-weight: 600;">'+res.data.username+'</span>'+
									  	'<span style="font-size: 12px;clolor: #aaa;">'+res.data.user+'</span>'+
									  '</div>'+
									'</div>'+
									'<div class="layui-inline" style="margin-right: 50px;">'+
										'<button class="layui-btn layui-btn-danger layui-btn-sm" id="sign-out">退出<i class="fa fa-sign-out fa-fw"></i></button>'+
									'</div>'+
								'</div>'+
								'<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">'+
								  '<ul class="layui-tab-title">'+
								   ' <li class="layui-this">个人资料 <i class="fa fa-address-card fa-fw"></i></li>'+
								   ' <li>修改密码 <i class="fa fa-file-text fa-fw"></i></li>'+
								  '</ul>'+
								  '<div class="layui-tab-content">'+
								   ' <div class="layui-tab-item layui-show">'+
								    	'<ul class="layui-timeline" style="margin:10px 100px;">'+
										 ' <li class="layui-timeline-item">'+
										  	'<i class="fa fa-users fa-fw layui-timeline-axis"></i>'+
										    '<div class="layui-timeline-content layui-text">'+
										      '<h3 class="layui-timeline-title">性别</h3>'+
										      '<p>'+
										      res.data.sex+
										      '</p>'+
										    '</div>'+
										 ' </li>'+
										 ' <li class="layui-timeline-item">'+
										   ' <i class="fa fa-star fa-fw layui-timeline-axis"></i>'+
										    '<div class="layui-timeline-content layui-text">'+
										      '<h3 class="layui-timeline-title">会员等级</h3>'+
										     ' <p>'+vip_leval[res.data.vip.level]+'于'+ res.data.vip_died_line+ ' 日到期</p>'+
										    '</div>'+
										 ' </li>'+
										  '<li class="layui-timeline-item">'+
										   ' <i class="fa fa-address-book fa-fw layui-timeline-axis"></i>'+
										    '<div class="layui-timeline-content layui-text">'+
										     ' <h3 class="layui-timeline-title">会员特权</h3>'+
										     ' <p>'+
										       ' 可享受购票百分之'+res.data.vip.discount+'的优惠'+
										     ' </p>'+
										    '</div>'+
										  '</li>'+
										 ' <li class="layui-timeline-item">'+
										    '<i class="fa fa-mortar-board fa-fw layui-timeline-axis"></i>'+
										    '<div class="layui-timeline-content layui-text">'+
										      '<div class="layui-timeline-title">'+res.data.createTime+'加入我们</div>'+
										    '</div>'+
										  '</li>'+
										'</ul>'+
								    '</div>'+
								    '<div class="layui-tab-item">'+
								    	'<div class="layui-form" style="margin:10px 100px;">'+
								    		'<div class="layui-form-item" >'+
											    '<label class="layui-form-label">旧密码</label>'+
											   ' <div class="layui-input-inline">'+
											      '<input type="password" name="oldpass" required lay-verify="required|pass" placeholder="请输入旧密码" autocomplete="off" class="layui-input">'+
											    '</div>'+
											'</div>'+
											'<div class="layui-form-item">'+
											    '<label class="layui-form-label">新密码</label>'+
											    '<div class="layui-input-inline">'+
											      '<input type="password" name="pass" required lay-verify="required|pass" placeholder="请输入新密码" autocomplete="off" class="layui-input">'+
											    '</div>'+
											'</div>'+
											'<div class="layui-form-item">'+
											    '<label class="layui-form-label">再确认</label>'+
											    '<div class="layui-input-inline">'+
											      '<input type="password" name="checkPass" required lay-verify="required|checkPass" placeholder="请重新确认新密码" autocomplete="off" class="layui-input">'+
											    '</div>'+
											'</div>'+
											'<div class="layui-form-item">'+
											    '<div class="layui-input-block">'+
											     ' <button class="layui-btn" lay-submit lay-filter="updatePass">立即提交</button>'+
											    '</div>'+
											  '</div>'+
								    	'</div>'+
								    '</div>'+
								  '</div>'+
								'</div> '+
								'</div>',
								});
							}else{
								layer.msg(res.msg, {
									btn: ['登录', '算了'],
									yes:function(){
										login_regist_index = layer.open({
											type: 1,
											title: false,
											area: ['500px', '400px'],
											offset: '100px',
											content: '<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">'+
												  	'<ul class="layui-tab-title">'+
												  	'<li class="layui-this">登录</li>'+
												  	'<li>注册</li>'+
												  	'</ul>'+
												  	'<div class="layui-tab-content">'+
												  	'<div class="layui-tab-item layui-show" >'+
												  	'<div class="layui-form layui-form-pane" style="width:350px;margin:80px;">'+
													'<div class="layui-form-item ">'+
												    '<label class="layui-form-label"><i class="fa fa-user fa-fw"></i></label>'+
												    '<div class="layui-input-inline">'+
												    '<input type="text" name="user" lay-verify="phone" autocomplete="off" placeholder="请输入手机号" class="layui-input">'+
												    '</div>'+
												    '</div>'+
												  	'<div class="layui-form-item">'+
												    '<label class="layui-form-label"><i class="fa fa-unlock-alt fa-fw"></i></label>'+
												    '<div class="layui-input-inline">'+
											        '<input type="password" name="pass" placeholder="请输入密码" lay-verify="pass" autocomplete="off" class="layui-input">'+
												    '</div>'+
												    '</div>'+
												  	'<div class="layui-form-item">'+
												  	'<div class="layui-input-inline">'+
											  		'<button class="layui-btn layui-btn-fluid" style="width:300px;"  id="homeLogin" lay-submit lay-filter="homeLogin">立    即   登  录</button>'+
												  	'</div>'+
												  	'</div>'+
												  	'</div>'+
												  	'</div>'+
												  	'<div class="layui-tab-item">'+
												  	'<div class="layui-form layui-form-pane" style="width:350px;margin:15px 80px;">'+
													'<div class="layui-form-item ">'+
												    '<label class="layui-form-label"><i class="fa fa-user fa-fw"></i></label>'+
												    '<div class="layui-input-inline">'+
												      '<input id="checkPhone" type="text" name="user" lay-verify="phone" autocomplete="off" placeholder="请输入手机号" class="layui-input">'+
												    '</div>'+
												    '</div>'+
												    '<div class="layui-form-item">'+
												    '<label class="layui-form-label"><i class="fa fa-user-secret fa-fw"></i></label>'+
												    '<div class="layui-input-inline">'+
												      '<input type="text" name="username" placeholder="请输入用户昵称" autocomplete="off" lay-verify="adminName" class="layui-input">'+
												    '</div>'+
												    '</div>'+
												    '<div class="layui-form-item">'+
												    '<label class="layui-form-label"><i class="fa fa-unlock-alt fa-fw"></i></label>'+
												    '<div class="layui-input-inline">'+
												     ' <input type="password" name="pass" placeholder="请输入密码" autocomplete="off" lay-verify="pass" class="layui-input">'+
												   ' </div>'+
												   '</div>'+
												   '<div class="layui-form-item pane">'+
												    '<label class="layui-form-label"><i class="fa fa-venus-mars fa-fw"></i></label>'+
												    '<div class="layui-input-inline">'+
												      '<input type="radio" name="sex" value="男" title="男">'+
												      '<input type="radio" name="sex" value="女" title="女" checked>'+
												    '</div>'+
												    '</div>'+
												    '<div class="layui-form-item">'+
												  	'<div class="layui-input-inline">'+
												  		'<button class="layui-btn layui-btn-fluid" lay-submit lay-filter="register" style="width:300px;">立即注册</button>'+
												  	'</div>'+
												  	'</div>'+
												  	'<script>'+
													'$(function(){'+
													 ' layui.form.render();'+
													'})'+
													'</script>	'+
												  	'</div>'+
												  	'</div>'+
												  	'</div>'+
												  	'</div>',
										})
									},
									btn2:function(){
										layer.msg("残忍拒绝");
									}
								});
							}
						}
					},
					error: function(){
						layer.msg("连接服务器失败");
					}
				})
			}else if(type === 'bar5'){
				//发表留言
				var user_id = '';
				var user_name = '';
				var status = false;
				$.ajax({
					url: '/Manager/home/checkLogin',
					type: 'POST',
					data: {},
					async:false,
					success:function(res){
						if(typeof res !='object'){
							res = eval('('+res+')');
						}
						if(res.success==1){
							user_id = res.data.id;
							user_name = res.data.username;
							status = true;
						}else{
							layer.msg(res.msg);
						}
					}
				})
				if(status){
					layer.prompt({
						'title': '请填写留言',
					}, function(val, index){
						function p(s) {
				    	    return s < 10 ? '0' + s: s;
				    	}
				    	var myDate = new Date();
				    	//获取当前年
				    	var year=myDate.getFullYear();
				    	//获取当前月
				    	var month=myDate.getMonth()+1;
				    	//获取当前日
				    	var date=myDate.getDate(); 
				    	var h=myDate.getHours();       //获取当前小时数(0-23)
				    	var m=myDate.getMinutes();     //获取当前分钟数(0-59)
				    	var s=myDate.getSeconds();  

				    	var now=year+'-'+p(month)+"-"+p(date)+" "+p(h)+':'+p(m)+":"+p(s);
					  $.ajax({
						  url: '/Manager/LeaveWord/insertLeaveWord',
						  type: 'POST',
						  data: {
							  user_id: user_id,
							  user_name: user_name,
							  content: val,
							  createTime: now,
							  updateTime: now
						  },
						  success: function(res){
							  if(typeof res!='object'){
								  res = eval('('+res+')');
							  }
							  layer.msg(res.msg);
						  }
					  })
					  layer.close(index);
					});
				}
			}

		}
	});
	//退出操作
	$('body').on('click', '#sign-out', function(){
		$.ajax({
			url: '/Manager/home/PersonOut',
			type: 'POST',
			data: {},
			success: function(res){
				if(typeof res != 'object'){
					res = eval('('+res+')');
				}
				layer.msg(res.msg);
				layer.close(user_info_index);
			},
			error: function(){
				layer.msg("连接服务器失败!!!");
			}
		})
	})
	
    layui.form.render();
	//注册时验证用户手机号是否被注册
	$("body").on('blur', '#checkPhone', function(){
		var value = $('#checkPhone').val();
		console.log('value'+value+'value');
		if(value != '' | value != null){
			$.ajax({
	    		url: '/Manager/home/checkPhone',
	    		type: 'POST',
	    		data: {user: value},
	    		success: function(res){
	    			if(typeof res !='object'){
	    				res = eval('('+res+')');
	    			}
	    			if(res.status == 1){
	    				layer.msg(res.msg);
	    				$("#checkPhone").focus();
	    			}
	    		}
	    	})
		}
		
	})
  //自定义验证规则
    layui.form.verify({
        adminUser: function(value){
          if(value.length < 5){
            return '用户名至少5个字符啊';
          }
        },
        adminName: function(value){
          if(value.length > 6){
            return '用户昵称最多6个字符啊';
          }
          if(value.length < 0){
            return '用户昵称不能为空啊';
          }
        },
        phone: [/^1[3|4|5|7|8][0-9]{9}$/, '请输入正确的手机号'],
        pass: [/(.+){6,12}$/, '密码必须6到12位'],
        float: [/^[0-9]+.?[0-9]*$/, '请输入浮点数'],
        number: [/^[1-9]+[0-9]*]*$/, '请输入正整数'],
        
    });
    //登录的确认操作
    layui.form.on('submit(homeLogin)', function(data){
    	$.ajax({
    		url: '/Manager/home/userLogin',
    		type: 'POST',
    		data: data.field,
    		success: function(res){
    			if(typeof res != 'object'){
    				res = eval('('+res+')');
    			}
    			layer.msg(res.msg);
    			if(res.status == 1){
    				layer.close(login_regist_index);
    			}
    		}
    	})
        return false;
    });
    
    //注册的确认操作
    layui.form.on('submit(register)', function(data){
    	function p(s) {
    	    return s < 10 ? '0' + s: s;
    	}
    	var myDate = new Date();
    	//获取当前年
    	var year=myDate.getFullYear();
    	//获取当前月
    	var month=myDate.getMonth()+1;
    	//获取当前日
    	var date=myDate.getDate(); 
    	var h=myDate.getHours();       //获取当前小时数(0-23)
    	var m=myDate.getMinutes();     //获取当前分钟数(0-59)
    	var s=myDate.getSeconds();  

    	var now=year+'-'+p(month)+"-"+p(date)+" "+p(h)+':'+p(m)+":"+p(s);
    	data.field.createTime = now;
    	data.field.updateTime = now;
        $.ajax({
        	url: '/Manager/home/register',
        	type: 'POST',
        	data: data.field,
        	success: function(res){
        		if(typeof res !='object'){
        			res = eval('('+res+')');
        		}
        		layer.msg(res.msg);
        		if(res.success == 1){
        			layer.close(login_regist_index);
        		}
        	}
        })
    });
	
	//首页轮播图
	$("#flexiselDemo1").flexisel({
		visibleItems: 6,
		animationSpeed: 1000,
		autoPlay: true,
		autoPlaySpeed: 3000,    		
		pauseOnHover: false,
		enableResponsiveBreakpoints: true,
		responsiveBreakpoints: { 
			portrait: { 
				changePoint:480,
				visibleItems: 2
			}, 
			landscape: { 
				changePoint:640,
				visibleItems: 3
			},
			tablet: { 
				changePoint:768,
				visibleItems: 4
			}
		}
	});

	/**
	 * 列表页元素点击事件,显示为详情信息
	 */
	$('.content-list').on('click', '.content-imgs', function(){
		var data_index = $(this).attr('data-index');
		var content = create_movie_info(data_index);
		layer.open({
			type: 1,
			title: false,
			closeBtn: 2,
			area: ['1200px', '900px'],
			shadeClose: true,
			// skin: 'layui-layer-nobg',
			content: content,
		});
		
	})

	/**
	 * 组织影片详情的内容
	 */
	function create_movie_info(id){
		var content = '';   
		/**
		 * [success 异步请求获取影片信息的数据并组装返回]
		 * @param  {String} data){				content [description]
		 * @param  {String} error:             function(){				content [description]
		 * @return {[type]}                    [description]
		 */
		$.ajax({
			type:'POST',
			data: {id: id},
			url: '/Manager/home/getMovieInfoById',
			async:false,
			success:function(res){
				if(typeof res !='object'){
					res = eval('('+res+')');
				}
				console.log(res);
				if(res.success == 1){
					content = '<div class="conten-info">'+
		            '<div class="movie-info-head">'+
		                '<div class="movie-img">'+
		                    '<img src="/Manager/images/'+res.movie.img+'" alt="">'+
		                '</div>'+
		                '<div class="movie-info-title">'+
		                    '<h1>'+res.movie.name+'</h1>'+
		                    '<p>类型: '+res.movie.movieType.type+'</p>'+
		                    '<p>发布地区: '+res.movie.publishArea.area+' </p>'+
		                    '<p>上映时间: '+res.movie.publish_time+'</p>'+
		                    '<p>影片票价: ￥'+res.movie.ticket_price+'</p>'+
		                    '<div class="movie-buy" data-index="'+id+'"><button class="layui-btn layui-btn-fluid layui-btn-danger" >购 票 详 情</button></div>'+
		                '</div>'+
		            '</div>'+
		            '<div class="movie-info-des">'+
		            	'<div class="layui-elem-quote">影片简介</div>'+
		                '<blockquote class="layui-elem-quote layui-quote-nm">'+
		                    res.movie.info+
		                '</blockquote>'+
		            '</div>'+
		            '<div class="remark-info">' +
		            	'<div class="layui-elem-quote">留下足迹  <button class="layui-btn  layui-btn-normal layui-btn-sm comment" data-index="'+res.movie.id+'">提交评论</button></div>'+
		                '<blockquote class="layui-elem-quote layui-quote-nm">'+
		                    '<textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="editor_"></textarea>'+                    
		                '</blockquote>'+
		                '<blockquote class="layui-elem-quote layui-quote-nm">';
						if(res.Comment==null || res.Comment.length==0){
							content+= '<p>暂无影评</p>';
						}else{
							content+='<ul class="layui-timeline">';
						    $.each(res.Comment, function(k,v){
						    	content += '<li class="layui-timeline-item">'+
							    '<i class="layui-icon layui-timeline-axis"></i>'+
							    '<div class="layui-timeline-content layui-text">'+
							      '<h3 class="layui-timeline-title">'+v.person.username+" - "+ v.person.user + '<span style="font-size:10px;margin-left:10px;">发布于:'+v.createTime+'</span></h3>'+
							      '<p>'+
							      v.content+
							      '</p>'+
							    '</div>'+
							  '</li>';
						    	return content;
						    });
							content +='</ul>';
						}
						content+='</blockquote>'+
									'</div>'+
									'<script>var editIndex = layui.layedit.build("editor_");</script>'+
									'</div>';
				}else{
					content = '暂未获取到该影片的详细信息!';
				}
				return content;
			},
			error: function(){
				content = '暂未获取到该影片的详细信息!';
				return content;
			}
		})
		return content;
	}

	function create_movie_order_info(data_index){
		var content = '<div id="movie-order-list"><blockquote class="layui-elem-quote">影视上映信息</blockquote><blockquote class="layui-elem-quote layui-quote-nm">';
		$.ajax({
			url: '/Manager/home/getMovieActionByMId',
			type: 'POST',
			async:false,
			data: {id: data_index},
			success: function(res){
				if(typeof res !='object'){
					res = eval('('+res+')');
				}
				console.log(res)
				if(res.movieAction==null || res.movieAction.length == 0){
					content += '管理员还未发布购票信息!'; 
				}else{
					content += '<ul class="layui-timeline">';
				    $.each(res.movieAction, function(k,v){
				    	content += '<li class="layui-timeline-item">'+
					    '<i class="layui-icon layui-timeline-axis"></i>'+
					    '<div class="layui-timeline-content layui-text">'+
					      '<h3 class="layui-timeline-title">'+v.hall.cinema.cinema_name+" "+v.hall.hall_name+'</h3>'+
					      '<div style="display:flex;flex-direction: row;justify-content: flex-end;"><div style="width: 90%;"><p>放映时间: '+v.actionTime+'</p>'+
					      '<p>票价: '+v.movie.ticket_price+'</p></div><div><input name="number" placeholder="购买张数" class="layui-input"></div>'+
					      '<div data-index="'+v.id+'" data="'+v.movie.ticket_price+'" class="layui-btn buy-ticket" style="margin-left: 25px;" >立即购买</div></div>'+
					    '</div>'+
					  '</li>';
				    });
					content +='</ul>';
				}
			},
			error: function(){
				layer.msg("连接服务器失败")
			}
		})
		content += '</blockquote></div>';
		return content;
	}
	//影评点击事件
	$('body').on('click', '.comment', function(){
		var user_id = '';
		var status = false;
		var movie_id = $(this).attr('data-index');
		var info = $('#LAY_layedit_1').contents().find('body').html();
		if(info==''|info==null|info=='undfiend'){
			layer.msg('请填写影评信息!!');
		}else{
			$.ajax({
				url: '/Manager/home/checkLogin',
				type: 'POST',
				data: {},
				async:false,
				success:function(res){
					if(typeof res !='object'){
						res = eval('('+res+')');
					}
					if(res.success==1){
						user_id = res.data.id;
						layer.msg(user_id);
						status = true;
					}else{
						layer.msg(res.msg);
					}
				}
			})
		}
		if(status){
			function p(s) {
	    	    return s < 10 ? '0' + s: s;
	    	}
	    	var myDate = new Date();
	    	//获取当前年
	    	var year=myDate.getFullYear();
	    	//获取当前月
	    	var month=myDate.getMonth()+1;
	    	//获取当前日
	    	var date=myDate.getDate(); 
	    	var h=myDate.getHours();       //获取当前小时数(0-23)
	    	var m=myDate.getMinutes();     //获取当前分钟数(0-59)
	    	var s=myDate.getSeconds();  

	    	var now=year+'-'+p(month)+"-"+p(date)+" "+p(h)+':'+p(m)+":"+p(s);
	    	$.ajax({
 			   url: '/Manager/Comment/insertComment',
 			   type: 'POST',
 			   data: {
 				   user_id: user_id,
 				   movie_id: movie_id,
 				   content: info,
 				   createTime: now,
 				   updateTime: now
 			   },
 			   success: function(res){
 				   if(typeof res != 'object'){
 					   res = eval('('+res+')');
 				   }
 				   layer.msg(res.msg);
 			   }
 		   })
		}
		
	})
	
	/**
	 * 影票详情的点击事件
	 */
	$('body').on('click', '.movie-buy', function(){
		var data_index = $(this).attr('data-index');
		var content = create_movie_order_info(data_index);
		layer.open({
			type: 1,
			title: false,
			closeBtn: 2,
			area: ['1200px', '900px'],
			shadeClose: true,
			// skin: 'layui-layer-nobg',
			content: content,
		});
	})
	
	//购票按钮的点击事件
	$("body").on('click', '.buy-ticket', function(){
		function p(s) {
    	    return s < 10 ? '0' + s: s;
    	}
    	var myDate = new Date();
    	//获取当前年
    	var year=myDate.getFullYear();
    	//获取当前月
    	var month=myDate.getMonth()+1;
    	//获取当前日
    	var date=myDate.getDate(); 
    	var h=myDate.getHours();       //获取当前小时数(0-23)
    	var m=myDate.getMinutes();     //获取当前分钟数(0-59)
    	var s=myDate.getSeconds();  

    	var now=year+'-'+p(month)+"-"+p(date)+" "+p(h)+':'+p(m)+":"+p(s);
    	var number_now=year+p(month)+p(date)+p(h)+p(m)+p(s);
    	//订单编号
		var orderNum = 'ORDER'+number_now;
		//排片编号
		var movieAction_id = $(this).attr('data-index');
		//用户ID
		var user_id = '';
		//优惠折扣
		var discount = 100;
		//票价
		var price = $(this).attr('data');
		//购买张数
		var number = $(this).parents('.layui-text').find('input[name=number]').val();
		var ticket_status = '待出票';
		var status = false;
		var te= /^[1-9]+[0-9]*]*$/;
	    if(!te.test(number)){  
	    	layer.msg("购买影票张数请填写数字");
	    }else{
	    	$.ajax({
				url: '/Manager/home/checkLogin',
				type: 'POST',
				data: {},
				async:false,
				success:function(res){
					if(typeof res !='object'){
						res = eval('('+res+')');
					}
					if(res.success==1){
						user_id = res.data.id;
						discount = res.data.vip.discount?res.data.vip.discount:100;
						status = true;
					}else{
						layer.msg(res.msg);
					}
				}
			})
	    }
	    if(status){
	    	var count = price * number * discount /100;
	    	var alert_str = '请您确认订单哦!<br>购买张数:'+ number+'<br>票价: '+price+'<br>会员折扣: '+discount+'%<br>总票价:'+count;
	    	layer.confirm(alert_str, {
	    		  btn: ['确认','取消'] //按钮
    		}, function(){
    		   $.ajax({
    			   url: '/Manager/Ticket/insertTicket',
    			   type: 'POST',
    			   data: {
    				   orderNum: orderNum,
    				   mv_action_id: movieAction_id,
    				   user_id: user_id,
    				   number: number,
    				   status: ticket_status,
    				   createTime: now,
    				   updateTime: now
    			   },
    			   success: function(res){
    				   if(typeof res != 'object'){
    					   res = eval('('+res+')');
    				   }
    				   layer.msg(res.msg);
    			   }
    		   })
    		}, function(){
    		  layer.msg('您取消了订单', {
    		    time: 20000, //20s后自动关闭
    		  });
    		});
	    }
		console.log(user_id + ' ' +number+' '+discount);
	})
})