<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/public/Ali.ico">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/js/layui/css/layui.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/layui/layui.all.js"></script>
    <script src="${pageContext.request.contextPath}/js/index.js"></script>
    <title>Ali⊙Movie●Manage</title>
</head>
<body>
	<div id="main">
		<div id="left-body">
			<div id="sys-name">
				<span style="color:red">Ali</span>⊙Movie<span style="color:red">●</span>Manage
			</div>
        <!--
			<div id="admin-info">
				<div class="head-img">
                    <img src="../public/Ali.jpg" alt="">
                </div>
                <div class="user-name">
                    <span>admin</span>
                    <span>管理员</span>
                </div>
                <div class="other-info">
					<i class="fa fa-sign-out" aria-hidden="true"></i>
                </div>
			</div>
        -->
			<div id="home-button">
				<div>Home</div>
			</div>
			<div id="menu">
				<div class="menu-nav">
                    <div class="menu-dir" >
                        <i class="fa fa-user" aria-hidden="true"></i>
                        &nbsp;会员管理
                    </div>    
                    <div class="menu-folder">
                    	<span data-index="1">管理信息</span>
                		<span data-index="2">会员管理</span>
                		<span data-index="3">购票管理</span>
                    </div>
                </div>
                <div class="menu-nav">
                    <div class="menu-dir">
                        <i class="fa fa-film" aria-hidden="true"></i>
                        &nbsp;影片管理
                        
                    </div>
                    <div class="menu-folder">
                    	<span data-index="4">影片产地</span>
	                    <span data-index="5">影片类型</span>
	                    <span data-index="6">影片信息</span>
	                    <span data-index="7">影评管理</span>
                    </div>
                </div>
                <div class="menu-nav">
                    <div class="menu-dir">
                        <i class="fa fa-calendar-check-o" aria-hidden="true"></i>
                        &nbsp;排片管理
                    </div>
                    <div class="menu-folder">
                    	<span data-index="8">影院管理</span>
                    	<span data-index="9">影厅管理</span>
                    	<span data-index="10">排片管理</span>
                    </div>
                </div>
                <div class="menu-nav">
                    <div class="menu-dir">
                        <i class="fa fa-comments" aria-hidden="true"></i>
                        &nbsp;留言管理
                    </div>
                    <div class="menu-folder">
                    	<span data-index="11">留言管理</span>
                    </div>
                </div>
            </div>
		</div>
		<div id="right-body">
			<div id="opa-nav">
                <ul class="layui-nav">
                    <li class="layui-nav-item">
                        <a href="javascript:;">控制台<span class="layui-badge">9</span></a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;">个人中心<span class="layui-badge-dot"></span></a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;"><img src="../public/Ali.jpg" class="layui-nav-img">管理员</a>
                    </li>
                    <li class="layui-nav-item">
                        <a href="javascript:;" class="other-info">
                            <button class="layui-btn layui-btn-xs layui-btn-danger">
                                <i class="fa fa-sign-out" aria-hidden="true"></i>
                            </button>
                        </a>
                    </li>
                </ul>
			</div>
			<div id="tab-nav">
				<div class="tab-li tab-onselect" data-index="0">
					管理首页
					<i class="fa fa-align-justify" aria-hidden="true"></i>
				</div>
			</div>
			<div id="contents">
				<div class="panel-div " data-index="0">
					<iframe src ="../other/MainPage.html" frameborder="0" width="100%" height="100%" id="content-ifa"></iframe>
				</div>
			</div>
		</div>
	</div>


    <!-- 管理界面表单 -->
    <div id="manage" style="display:none;margin:20px;" class="layui-row">
        <form class="layui-form layui-form-pane">
            <div class="layui-inline">
              <label class="layui-form-label">用户名</label>
              <div class="layui-input-inline">
                <input type="hidden" name="id" >
                <input type="tel" name="user" lay-verify="required|adminUser" autocomplete="on" class="layui-input">
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">密码</label>
              <div class="layui-input-inline">
                <input type="password" name="pass" lay-verify="required|pass" autocomplete="off" placeholder="请填写6到12位密码" class="layui-input">
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">用户昵称</label>
              <div class="layui-input-inline">
                <input type="text" name="username" lay-verify="adminName|required" autocomplete="off" class="layui-input">
              </div>
            </div>
            <div style="display:none">
                <button class="layui-btn" lay-submit="" lay-filter="submit_1">立即提交</button>
            </div>
        </form>
    </div>
    <!-- 会员界面表单 -->
    <div id="vip" style="display:none;margin:20px;" class="layui-row">
        <form class="layui-form layui-form-pane">
            <div class="layui-inline">
              <label class="layui-form-label">手机号</label>
              <div class="layui-input-inline">
                <input type="hidden" name="id" > 
                <input type="tel" name="user" lay-verify="required|phone" autocomplete="off" class="layui-input">
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">用户昵称</label>
              <div class="layui-input-inline">
                <input type="text" name="username" lay-verify="" autocomplete="off" class="layui-input">
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">密码</label>
              <div class="layui-input-inline">
                <input type="password" name="pass" lay-verify="required|pass" autocomplete="off" placeholder="请填写6到12位密码" class="layui-input">
              </div>
            </div>
            <div class="layui-inline" pane>
                 <label class="layui-form-label">性别</label>
                 <div class="layui-input-block">
			      <input type="radio" name="sex" value="男" title="男">
			      <input type="radio" name="sex" value="女" title="女" >
			    </div>
			</div>
			<div class="layui-inline">
                 <label class="layui-form-label">会员类型</label>
                 <div class="layui-input-inline">
                   <select name="vip_id" lay-search="">
                       <option value="">直接选择或搜索选择</option>
                       <option value="1">钻石会员</option>
                       <option value="2">黄金会员</option>
                       <option value="3">青铜会员</option>
                   </select>
                 </div>
            </div>
			<div class="layui-inline">
                 <label class="layui-form-label">续费时长</label>
                 <div class="layui-input-inline">
                   <select name="dead_line" lay-search="">
                       <option value="">直接选择或搜索选择</option>
                       <option value="30">一个月</option>
                       <option value="90">三个月</option>
                       <option value="180">半年</option>
                       <option value="365">一年</option>
                   </select>
                 </div>
               </div>
            <div style="display:none">
                <button class="layui-btn" lay-submit="" lay-filter="submit_2">立即提交</button>
            </div>
        </form>
    </div>

    <!-- 购票管理界面表单 -->
    <div id="ticket" style="display:none;margin:20px;" class="layui-row"></div>

    <!-- 影片产地界面表单 -->
    <div id="movie_area" style="display:none;margin:20px;" class="layui-row">
        <form class="layui-form layui-form-pane">
            <div class="layui-inline">
              <label class="layui-form-label">发布地区</label>
              <div class="layui-input-inline">
                <input type="hidden" name="id" >
                <input type="text" name="area" placeholder="请填写影片发布地区" lay-verify="required" class="layui-input">
              </div>
            </div>
            <div style="display:none">
                <button class="layui-btn" lay-submit="" lay-filter="submit_4">立即提交</button>
            </div>
        </form>
    </div>

    <!-- 影片类型界面表单 -->
    <div id="movie_type" style="display:none;margin:20px;" class="layui-row">
        <form class="layui-form layui-form-pane" action="" >
            <div class="layui-inline">
              <label class="layui-form-label">影片类型</label>
              <div class="layui-input-inline">
                <input type="hidden" name="id" >
                <input type="text" name="type" placeholder="请填写影片类型" lay-verify="required" class="layui-input">
              </div>
            </div>
            <div style="display:none">
                <button class="layui-btn" lay-submit="" lay-filter="submit_5">立即提交</button>
            </div>
        </form>
    </div>
    
    <!-- 影片管理界面表单 -->
    <div id="movie" style="display:none;margin:20px;" class="layui-row">
        <form class="layui-form layui-form-pane" action="" >
            <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">影片名称</label>
                  <div class="layui-input-inline">
                    <input type="hidden" name="id" >
                    <input type="text" name="name" placeholder="请填写影片名称" lay-verify="required" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">影片地区</label>
                  <div class="layui-input-inline">
                    <select name="area_id" lay-verify="required" lay-search="">
                    </select>
                  </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">影片时长</label>
                  <div class="layui-input-inline">
                    <input type="text" name="long_time" placeholder="请填写影片时长" lay-verify="required" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">影片类型</label>
                  <div class="layui-input-inline">
                    <select name="type_id" lay-verify="required" lay-search="">
                    </select>
                  </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">电影票价</label>
                    <div class="layui-input-inline" >
                        <input type="text" name="ticket_price" placeholder="￥" autocomplete="off" lay-verify="required|float" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">上映时间</label>
                    <div class="layui-input-inline" >
                        <input type="text" name="publish_time" autocomplete="off" lay-verify="required|date" id="publish_date" placeholder="YYYY-MM-DD" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-upload">
                <span type="button" class="layui-btn" id="movie_upload"><i class="layui-icon">&#xe67c;</i>上传影视图片</span>
                <blockquote class="layui-elem-quote" style="margin-top: 10px;">
                    <span style="font-size: 14px;">预览图：</span>
                    <img class="layui-upload-img" id="movie_img" style="width:150px;">
                    <input type="hidden" name="img" class="layui-input">
                </blockquote>
            </div>
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">影视信息</label>
                <div class="layui-input-block">
                  <textarea class="layui-textarea layui-hide" name="info" lay-verify="content" id="movie_info"></textarea>
                </div>
            </div>
            <div style="display:none">
                <button class="layui-btn" lay-submit="" lay-filter="submit_6">立即提交</button>
            </div>
        </form>
    </div>

    <!-- 影评管理界面表单 -->
    <div id="movie_content" style="display:none;margin:20px;" class="layui-row"></div>

    <!-- 影院管理界面表单 -->
    <div id="cinema" style="display:none;margin:20px;" class="layui-row">
        <form class="layui-form layui-form-pane" action="" >
            <div class="layui-inline">
              <label class="layui-form-label">影院名称</label>
              <div class="layui-input-inline">
                <input type="hidden" name="id" >
                <input type="text" name="cinema_name" placeholder="请填写影院名称" lay-verify="required" class="layui-input">
              </div>
            </div>
            <div class="layui-inline">
              <label class="layui-form-label">影院地址</label>
              <div class="layui-input-inline">
                <input type="text" name="address" placeholder="请填写影院地址" lay-verify="required" class="layui-input">
              </div>
            </div>
            <div style="display:none">
                <button class="layui-btn" lay-submit="" lay-filter="submit_8">立即提交</button>
            </div>
        </form>
    </div>

    <!-- 影厅管理界面表单 -->
    <div id="hall" style="display:none;margin:20px;" class="layui-row">
        <form class="layui-form layui-form-pane" action="" >
            <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">影厅名称</label>
                  <div class="layui-input-inline">
                    <input type="hidden" name="id" >
                    <input type="text" name="hall_name" placeholder="请填写影厅名称" lay-verify="required" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">所属影院</label>
                  <div class="layui-input-inline">
                    <select name="cinema_id" lay-verify="required" lay-search="">
                    </select>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">影厅地址</label>
                  <div class="layui-input-inline">
                    <input type="text" name="address" placeholder="请填写影厅地址" lay-verify="required" class="layui-input">
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">座位数</label>
                  <div class="layui-input-inline">
                    <input type="text" name="site_num" placeholder="请填写影厅座位数" lay-verify="required|number" class="layui-input">
                  </div>
                </div>
                <div style="display:none">
                    <button class="layui-btn" lay-submit="" lay-filter="submit_9">立即提交</button>
                </div>
            </div>
        </form>
    </div>

    <!-- 排片管理界面表单 -->
    <div id="movie_manage" style="display:none;margin:20px;" class="layui-row">
        <form class="layui-form layui-form-pane" action="" >
            <div class="layui-form-item">
                <div class="layui-inline">
                  <label class="layui-form-label">选择影片</label>
                  <div class="layui-input-inline">
                    <input type="hidden" name="id" >
                    <select name="movie_id" lay-verify="required" lay-search="">
                    </select>
                  </div>
                </div>
                <div class="layui-inline">
                  <label class="layui-form-label">选择影厅</label>
                  <div class="layui-input-inline">
                    <select name="hall_id" lay-verify="required" lay-search="">
                    </select>
                  </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">放映时间</label>
                    <div class="layui-input-inline">
                        <input type="text" name="actionTime" id="action_time" lay-verify="required|datetime" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div style="display:none">
                    <button class="layui-btn" lay-submit="" lay-filter="submit_10">立即提交</button>
                </div>
            </div>
        </form>
    </div>

    <!-- 留言界面表单 -->
    <div id="comment" style="display:none;margin:20px;" class="layui-row"></div>
</body>
<script>
    $(function(){
        layui.laydate.render({
            elem: '#publish_date',
            theme: 'molv'
        });
        layui.laydate.render({
            elem: '#action_time',
            type: 'datetime',
            theme: 'molv'
        });
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
            pass: [/(.+){6,12}$/, '密码必须6到12位'],
            float: [/^[0-9]+.?[0-9]*$/, '请输入浮点数'],
            number: [/^[1-9]+[0-9]*]*$/, '请输入正整数'],
        });
        var editIndex = layui.layedit.build('movie_info');

        var uploadInst = layui.upload.render({
            elem: '#movie_upload',
            url: '/Manager/Movie/MovieImg',
            before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#movie_img').attr('src', result); //图片链接（base64）
                });
            },
            done: function(res){
                if(typeof res != 'object'){
                	res = eval('('+res+')');
                }
                $("input[name='img']").val(res.img);
              	layer.msg(res.msg);
                
            },
            error: function(){
                //演示失败状态，并实现重传
                layer.tips('上传失败', '#movie_upload');
                // var demoText = $('#demoText');
                // demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                // demoText.find('.demo-reload').on('click', function(){
                //     uploadInst.upload();
                // });
            }
        });
        layui.form.render();
    })
</script>

<script type="text/html" id="barDemo">
    <div class="layui-btn-group">
        <button class="layui-btn layui-btn-xs" lay-event="edit" data-index="">
            <i class="layui-icon">&#xe642;</i>编辑
        </button>
        <button class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">
            <i class="layui-icon">&#xe640;</i>删除
        </button>
    </div>
</script>
<script type="text/html" id="switchTpl">
  <input type="checkbox" name="sex" value="{{d.sex}}" lay-skin="switch" lay-text="女|男" lay-filter="sexDemo" {{ d.sex == '女' ? 'checked' :''}} disabled>
</script>
</html>