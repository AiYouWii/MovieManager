/**
 * Created by Johnny on 2017/7/18.
 */
$(function(){
    var menu_folder = $('.menu-folder');
    menu_folder.hide();
    /**
     * 菜单点击事件
     * @type {any}
     */
    var menu = $('#menu');
    var nav = menu.find('.menu-nav');
    nav.each(function(){
        var ithis = $(this);
        $(this).find('.menu-dir').toggle(function(){
            var folder = ithis.find('.menu-folder');
            folder.each(function(){
                $(this).show(150);
            })
        },function () {
            var folder = ithis.find('.menu-folder');
            folder.each(function(){
                $(this).hide(150);
            })
        })
    })
    /**
     * [clean_tab_show 重置切换tab标签页的样式]
     * @return {[type]} [description]
     */
    function clean_tab_show(_this){
        $('#tab-nav').find('.tab-li').each(function(){
            $(this).removeClass('tab-onselect').addClass('tab-noselect');
        })
        if(_this){
            _this.removeClass('tab-noselect').addClass('tab-onselect')
        }
    }

    /**
     * [content_show 内容页显示]
     * @param  {[type]} data_index [需要显示的内容编号]
     * @return {[type]}            [description]
     */
    function content_show(data_index){
        // $('#content-ifa').removeClass('div-noactive').addClass('div-noactive');
        $('#contents').find('.panel-div').each(function(){
            var panel_index = $(this).attr('data-index');
            var div_show = panel_index==data_index?'':'div-noactive';
            $(this).removeClass('div-noactive').addClass(div_show);
        })
    }
    
    /**
     * [标签页点击事件]
     * @param  {[type]} )
     * @return {[type]}     [description]
     */
    $('#tab-nav').on('click', '.tab-li', function(){
        var data_index = $(this).attr('data-index');
        clean_tab_show($(this));
        content_show(data_index);
    })

    /**
     * 获取已激活的标签页的data-index属性
     * [get_tab_dataIndex description]
     * @return {[type]} [description]
     */
    function get_tab_dataIndex(){
        var tab_indexs = new Array();
        $('#tab-nav').find('.tab-li').each(function(){
            var data_index = $(this).attr('data-index');
            tab_indexs.push(data_index);
        })
        return tab_indexs;
    }


    function getContentsHtml(data_index){
        /**
         * [html 组装页面的内容]
         * @type {String}
         */
        var html ='<div class="panel-div " data-index="'+data_index+'">'+
                    '<div class="content-panel">'+
                        '<div class="content-panel-body" >'+
                            '<blockquote class="layui-elem-quote table_opa" style="margin-bottom:0;">'+
                            '<button class="layui-btn layui-btn-sm" onclick="add('+data_index+')">'+
                                '<i class="layui-icon">&#xe654;</i>新增'+
                            '</button>'+
                            '<button class="layui-btn layui-btn-danger layui-btn-sm" data-type="delete('+data_index+')">'+
                                '<i class="layui-icon">&#xe640;</i>删除'+
                            '</button>'+
                            '<button class="layui-btn layui-btn layui-btn-warm layui-btn-sm" data-type="reload('+ data_index +')">'+
                                '<i class="layui-icon">&#x1002;</i>刷新'+
                            '</button>'+
                            '</blockquote>'+
                            '<table id="table_'+ data_index +'" lay-filter="table_'+ data_index +'"></table>'+

                        '</div>'+
                    '</div>'+
                '</div>';
        return html;
    }

    function click_tab_by_index(index){
        $('#tab-nav').find('.tab-li').each(function(){
            var tab_index = $(this).attr('data-index');
            var _this = $(this);
            if(tab_index == index){
                console.log(index);
                _this.click();
                console.log(_this.click())
            }
        })
    }
    
    //获取数据列表的url
    var data_urls = {
    	//管理信息
		1: '/Manager/admin/getAdminList',
		//会员管理
		2: '/Manager/Person/getUserInfo',
		//购票管理
		3: '/Manager/Ticket/getTicketInfo',
		//影片产地
		4: '/Manager/PublishArea/getPublishAreaInfo',
		//影片类型
		5: '/Manager/MovieType/getMovieTypeInfo',
		//影片信息
		6: '/Manager/Movie/getMovieInfo',
		//影评管理
		7: '/Manager/Comment/getCommentInfo',
		//影院管理
		8: '/Manager/Cinema/getCinemaInfo',
		//影厅管理
		9: '/Manager/Hall/getHallInfo',
		//排片管理
		10: '/Manager/MovieAction/getMovieActionInfo',
		//留言管理
		11: '/Manager/LeaveWord/getLeaveWordInfo'
    }
    
    //获取数据删除的url
    var data_del_urls = {
		//管理信息
		1: '/Manager/admin/deleteAdminById',
		//会员管理
		2: '/Manager/Person/deletePersonById',
		//购票管理
		3: '/Manager/Ticket/deleteTicketById',
		//影片产地
		4: '/Manager/PublishArea/deletePublishAreaById',
		//影片类型
		5: '/Manager/MovieType/deleteMovieTypeById',
		//影片信息
		6: '/Manager/Movie/deleteMovieById',
		//影评管理
		7: '/Manager/Comment/deleteCommentById',
		//影院管理
		8: '/Manager/Cinema/deleteCinemaById',
		//影厅管理
		9: '/Manager/Hall/deleteHallById',
		//排片管理
		10: '/Manager/MovieAction/deleteMovieActionById',
		//留言管理
		11: '/Manager/LeaveWord/deleteLeaveWordInfoById'
    }
    
    //获取数据添加数据的url
    var data_add_urls = {
		//管理信息
		1: '/Manager/admin/insertAdmin',
		//会员管理
		2: '/Manager/Person/insertPerson',
		//购票管理
		3: '/Manager/Ticket/insertTicket',
		//影片产地
		4: '/Manager/PublishArea/insertPublishArea',
		//影片类型
		5: '/Manager/MovieType/insertMovieType',
		//影片信息
		6: '/Manager/Movie/insertMovie',
		//影评管理
		7: '/Manager/Comment/insertComment',
		//影院管理
		8: '/Manager/Cinema/insertCinema',
		//影厅管理
		9: '/Manager/Hall/insertHall',
		//排片管理
		10: '/Manager/MovieAction/insertMovieAction',
		//留言管理
		11: '/Manager/LeaveWord/insertLeaveWordInfo'
    }
    
    //获取数据修改数据的url
    var data_update_urls = {
		//管理信息
		1: '/Manager/admin/updateAdmin',
		//会员管理
		2: '/Manager/Person/updatePerson',
		//购票管理
		3: '/Manager/Ticket/updateTicket',
		//影片产地
		4: '/Manager/PublishArea/updatePublishArea',
		//影片类型
		5: '/Manager/MovieType/updateMovieType',
		//影片信息
		6: '/Manager/Movie/updateMovie',
		//影评管理
		7: '/Manager/Comment/updateComment',
		//影院管理
		8: '/Manager/Cinema/updateCinema',
		//影厅管理
		9: '/Manager/Hall/updateHall',
		//排片管理
		10: '/Manager/MovieAction/updateMovieAction',
		//留言管理
		11: '/Manager/LeaveWord/updateLeaveWordInfo'
    }
    $('#menu').on('click', '.menu-folder span', function(){
        /**
         * 菜单页按钮点击事件
         * [folder_index description]
         * @type {[type]}
         */
        var folder_index = $(this).attr('data-index');
        var folder_text = $(this).text();
        if($.inArray(folder_index, get_tab_dataIndex()) == -1){
            var tab_html_str = '<div class="tab-li tab-noselect" data-index="'+ folder_index +'">'+ folder_text +'<i class="fa fa-times tab-del" aria-hidden="true"></i></div>';
            $('#tab-nav').append(tab_html_str);
            $('#contents').append(getContentsHtml(folder_index));
            var data_url = data_urls[folder_index];
            create_table(folder_index, data_url);
        }
        click_tab_by_index(folder_index);
    })

    $('#tab-nav').on('click', '.tab-del', function(){
        click_tab_by_index(0);
        var tab_li = $(this).parent('.tab-li');
        var data_index = tab_li.attr('data-index');
        tab_li.remove();
        $('#contents').find('.panel-div').each(function(){
            var pan_index = $(this).attr('data-index');
            if(pan_index == data_index){
                $(this).remove();
            }
        });
    })

    /**
     * [table_col 每个表的表头]
     * @type {Object}
     */
    var table_col = {
        //管理信息
        1: [[
            {type: 'numbers', fixed: 'left'},
            {type: 'checkbox'},
            {field: 'id', title: 'ID', sort: true,  LAY_CHECKED: true, },
            {field: 'username', title: '姓名',},
            {field: 'user', title: '用户名', unresize: true,},
            {field: 'createTime', title: '创建时间', unresize: true,},
            {field: 'updateTime', title: '更新时间', unresize: true,},
            {fixed: 'right', align:'center', toolbar: '#barDemo', title: '操作',},
        ]], 
        //会员信息
        2: [[
            {type: 'numbers', fixed: 'left', },
            {type: 'checkbox'},
            {field: 'id', title: 'ID', sort: true,  LAY_CHECKED: true, },
            {field: 'user', title: '手机号', sort: true},
            {field: 'username', title: '用户昵称', },
            {field: 'sex', title: '性别', templet: '#switchTpl', unresize: true, },
            {field: 'level', title: '会员等级', sort: true},
            {field: 'discount', title: '会员折扣', sort: true},
            {field: 'cost', title: '会员费用', sort: true},
            {field: 'vip_died_line', title: '到期日', sort: true},
            {field: 'createTime', title: '创建时间', unresize: true,},
            {field: 'updateTime', title: '更新时间', unresize: true,},
            {fixed: 'right', align:'center', toolbar: '#barDemo', title: '操作'},
        ]],
        //购票管理
        3: [[
            {type: 'numbers', fixed: 'left', },
            {type: 'checkbox'},
            {field: 'id', title: 'ID', sort: true,  LAY_CHECKED: true, },
            {field: 'orderNum', title: '订单编号', sort: true},
            {field: 'user', title: '手机号', },
            {field: 'username', title: '用户昵称', },
            {field: 'name', title: '电影名称', },
            {field: 'hall_name', title: '影厅名称', },
            {field: 'actionTime', title: '放映时间', sort: true},
            {field: 'ticket_price', title: '影票单价 ', sort: true},
            {field: 'number', title: '购票数', sort: true},
            {field: 'createTime', title: '创建时间', unresize: true,},
            {field: 'updateTime', title: '更新时间', unresize: true,},
            {field: 'status', title: '订单状态', sort: true},
            {fixed: 'right', align:'center', toolbar: '#barDemo', title: '操作'},
        ]],
        //影片产地
        4: [[
            {type: 'numbers', fixed: 'left', },
            {type: 'checkbox'},
            {field: 'id', title: 'ID', sort: true,  LAY_CHECKED: true,},
            {field: 'area', title: '发行地区', },
            {field: 'createTime', title: '创建时间', unresize: true,},
            {field: 'updateTime', title: '更新时间', unresize: true,},
            {fixed: 'right', align:'center', toolbar: '#barDemo', title: '操作'},
        ]],
        //影片类型
        5: [[
			{type: 'numbers', fixed: 'left', },
			{type: 'checkbox'},
			{field: 'id', title: 'ID', sort: true,  LAY_CHECKED: true,},
			{field: 'type', title: '影片类型', },
			{field: 'createTime', title: '创建时间', unresize: true,},
            {field: 'updateTime', title: '更新时间', unresize: true,},
			{fixed: 'right', align:'center', toolbar: '#barDemo', title: '操作'},
        ]],
        //影片信息
        6: [[
            {type: 'numbers', fixed: 'left', },
            {type: 'checkbox'},
            {field: 'id', title: 'ID', sort: true,  LAY_CHECKED: true,},
            {field: 'name', title: '影片名称', },
            {field: 'publish_time', title: '发布时间', sort: true},
            {field: 'long_time', title: '时长', sort: true},
            {field: 'area', title: '发行地区', sort: true},
            {field: 'type', title: '影片类型', sort: true},
            {field: 'img', title: '宣传图片', },
            {field: 'info', title: '影片简介', },
            {field: 'ticket_price', title: '影片票价', },
            {field: 'createTime', title: '创建时间', unresize: true,},
            {field: 'updateTime', title: '更新时间', unresize: true,},
            {fixed: 'right', align:'center', toolbar: '#barDemo', title: '操作'},
        ]],
        //影评管理
        7: [[
            {type: 'numbers', fixed: 'left', },
            {type: 'checkbox'},
            {field: 'id', title: 'ID', sort: true,  LAY_CHECKED: true,},
            {field: 'user', title: '手机号', },
            {field: 'username', title: '用户昵称', },
            {field: 'name', title: '电影名称', },
            {field: 'content', title: '影评内容', },
            {field: 'createTime', title: '创建时间', unresize: true,},
            {field: 'updateTime', title: '更新时间', unresize: true,},
            {fixed: 'right', align:'center', toolbar: '#barDemo', title: '操作'},
        ]],
        //影院管理
        8: [[
            {type: 'numbers', fixed: 'left', },
            {type: 'checkbox'},
            {field: 'id', title: 'ID', sort: true,  LAY_CHECKED: true,},
            {field: 'cinema_name', title: '影院名称', },
            {field: 'address', title: '影院地址', },
            {field: 'createTime', title: '创建时间', unresize: true,},
            {field: 'updateTime', title: '更新时间', unresize: true,},
            {fixed: 'right', align:'center', toolbar: '#barDemo', title: '操作'},
        ]],
        //影厅管理
        9: [[
            {type: 'numbers', fixed: 'left', },
            {type: 'checkbox'},
            {field: 'id', title: 'ID', sort: true,  LAY_CHECKED: true,},
            {field: 'hall_name', title: '影厅名称', },
            {field: 'site_num', title: '座位数', },
            {field: 'cinema_name', title: '所属影院', },
            {field: 'createTime', title: '创建时间', unresize: true,},
            {field: 'updateTime', title: '更新时间', unresize: true,},
            {fixed: 'right', align:'center', toolbar: '#barDemo', title: '操作'},
        ]],
        //排片管理
        10: [[
            {type: 'numbers', fixed: 'left', },
            {type: 'checkbox'},
            {field: 'id', title: 'ID', sort: true,  LAY_CHECKED: true,},
            {field: 'name', title: '影片名称', },
            {field: 'hall_name', title: '影厅名称', },
            {field: 'cinema_name', title: '所属影院', },
            {field: 'actionTime', title: '放映时间', sort: true},
            {field: 'createTime', title: '创建时间', unresize: true,},
            {field: 'updateTime', title: '更新时间', unresize: true,},
            {fixed: 'right', align:'center', toolbar: '#barDemo', title: '操作'},
        ]],
        //留言管理
        11: [[
            {type: 'numbers', fixed: 'left', },
            {type: 'checkbox'},
            {field: 'id', title: 'ID', sort: true,  LAY_CHECKED: true,},
            {field: 'user_name', title: '用户昵称', },
            {field: 'content', title: '留言内容', },
            {field: 'createTime', title: '创建时间', unresize: true,},
            {field: 'updateTime', title: '更新时间', unresize: true,},
            {fixed: 'right', align:'center', toolbar: '#barDemo', title: '操作'},
        ]],
    }

    function create_table_data(table_index, data_url){
    	var data = [];
    	$.ajax({
    		url: data_url,
    		type: 'GET',
    		data: {page:1, limit: 9999},
    		async:false,
    		success: function(res){
    			console.log(res)
    			if(typeof res != 'object'){
    				res = eval('('+res+')');
    			}
    			if(res.code == 0){
        			if(table_index == 2){
        				//会员信息
        				$.each(res.data, function(k, v){
        					var row = v;
        					row['level'] = v.vip.level;
        					row['discount'] = v.vip.discount;
        					row['cost'] = v.vip.cost;
        					data.push(row);
        				})
        			}else if(table_index == 3){
        				//购票管理
        				$.each(res.data, function(k, v){
        					var row = v;
        					row['user'] = v.person.user;
        					row['username'] = v.person.username;
        					row['name'] = v.movieaction.movie.name;
        					row['ticket_price'] = v.movieaction.movie.ticket_price;
        					row['hall_name'] = v.movieaction.hall.hall_name;
        					row['actionTime'] = v.movieaction.actionTime;
        					data.push(row);
        				});
        			}else if(table_index == 6){
        				//影片信息
        				$.each(res.data, function(k, v){
        					var row = v;
        					row['area'] = v.publishArea.area;
        					row['type'] = v.movieType.type;
        					data.push(row);
        				});
        			}else if(table_index == 7){
        				//影评信息
        				$.each(res.data, function(k, v){
        					var row = v;
        					row['name'] = v.movie.name;
        					row['user'] = v.person.user;
        					row['username'] = v.person.username;
        					data.push(row);
        				});
        			}else if(table_index == 9){
        				//影厅信息
        				$.each(res.data, function(k, v){
        					var row = v;
        					row['cinema_name'] = v.cinema.cinema_name;
        					data.push(row);
        				});
        			}else if(table_index == 10){
        				//排片信息
        				$.each(res.data, function(k, v){
        					var row = v;
        					row['hall_name'] = v.hall.hall_name;
        					row['name'] = v.movie.name;
        					row['cinema_name'] = v.hall.cinema.cinema_name;
        					data.push(row);
        				});
        			}else{
        				data = res.data;
        			}
    			}
    			return data;
    		},
    		error:function(){
    			return [];
    		}
    	})
    	return data;
    }
    
    function create_table(table_index, data_url){
        var dom = '#table_' + table_index;
        var tab_col = table_col[table_index];
        var tab_data = create_table_data(table_index, data_url);
        console.log(tab_data);
        layui.table.render({
            elem: dom,
            height: 'full-165',
            cellMinWidth: 80,
            //url: data_url, //数据接口
            data: tab_data,
            page: true, //开启分页
            cols: tab_col,
            skin: 'nob',
            even: true,
        });
    }
    var form_dom_info = {
        1: $('#manage'), 2: $('#vip'), 3: $('#ticket'), 4: $('#movie_area'), 5: $('#movie_type'), 6: $('#movie'),
        7: $('#movie_content'), 8: $('#cinema'), 9: $('#hall'), 10: $('#movie_manage'), 11: $('#comment'),
    }
    /**
     * [bind_table_tool 绑定数据表格的tool事件]
     * @param  {[type]} data_index [description]
     * @return {[type]}            [description]
     */
    function bind_table_tool(data_index){
        var dom = 'tool(table_' + data_index+')';
        
        var form_dom = form_dom_info[data_index];
        var data_del_url = data_del_urls[data_index];
        layui.table.on(dom, function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
            var tr = obj.tr; //获得当前行 tr 的DOM对象

            if(layEvent === 'del'){ //删除
                layer.confirm('真的删除该行数据么?', {skin: 'layui-layer-molv'}, function(index){
                	//向服务端发送删除指令
                	$.ajax({
                		url: data_del_url,
                		type: "POST",
                		data: {id: data.id},
                		success:function(resu){
                			if(typeof resu != 'object'){
                				resu = eval('('+ resu +')');
                			}
                			if(resu.success == 1){
                				obj.del(); //删除对应行（tr）的DOM结构，并更新缓存
                			}
                			layer.msg(resu.msg);
                		},
                		error: function(){
                			layer.msg("连接数据服务失败");
                		}
                	});
                    layer.close(index);  
                });
            }else if(layEvent === 'edit'){ //编辑
                //do something
                create_form(data_index, data);

                //同步更新缓存对应的值
                
            }
        });
    }

    /**
     * [add 新增页面]
     * @param {[type]} index [description]
     */
    window.add=function(index){
        create_form(index, '');
    }

    function create_select_opation(data_url, dom, dfield){
        $.ajax({
                url: data_url,
                type: 'get',
                data: {page: 1, limit: 999},
                success: function(res){
                    if(typeof res != 'object'){
                        res = eval('('+ res +')');
                    }
                    if(res.code == 0){
                    	$("select[name='"+ dom +"']").html('');
                        $("select[name='"+ dom +"']").append('<option value="">直接选择或搜索选择</option>');
                        $.each(res.data, function(key, value){
                            console.log(value);
                            $("select[name='"+ dom +"']").append('<option value="'+value.id+'">'+value[dfield]+'</option>');
                            layui.form.render();
                        })
                    }
                }
            })
    }

    function load_form_select(data_index){
    	//影厅管理
    	if(data_index == 9){
            //影院信息的下拉框
            create_select_opation('/Manager/Cinema/getCinemaInfo', 'cinema_id', 'cinema_name');
    	}else if(data_index == 6){
            //影片管理
            //发布地区的下拉框
            create_select_opation('/Manager/PublishArea/getPublishAreaInfo', 'area_id', 'area');
            //影片类型的下拉框
            create_select_opation('/Manager/MovieType/getMovieTypeInfo', 'type_id', 'type');
        }else if(data_index == 10){
            //排片管理
            //影片信息的下拉框
            create_select_opation('/Manager/Movie/getMovieInfo', 'movie_id', 'name');
            //获取影厅的下拉框信息
            create_select_opation('/Manager/Hall/getHallInfo', 'hall_id', 'hall_name');
        }
    }
    
    
    
    /**
     * [create_form 创建相关表的表单]
     * @param  {[type]}
     *  panel_title [description]
     * @param  {[type]} form_dom    [description]
     * @return {[type]}             [description]
     */
    function create_form(data_index, table_data){
        console.log(table_data);
        var form_dom = form_dom_info[data_index];
        var bar_str = table_data?'编辑':'新增';
        var panel_title = page_info[data_index] + bar_str;
        var sub_btn = 'submit(submit_'+data_index+')';
        var area_info = data_index==6?['800px']:['400px'];
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
        var data_url = table_data? data_update_urls[data_index]:data_add_urls[data_index];
        //动态加载选择框的选择项
        load_form_select(data_index);
        
        // 购票管理, 影评管理, 留言管理 不支持后台新增和编辑
        if(data_index == 3 || data_index == 7 || data_index == 11 ){
            layer.msg('该页面不可' + bar_str);
        }else{
            layer.open({
                title: panel_title,
                type: 1,    //0（信息框，默认）1（页面层）2（iframe层）3（加载层）4（tips层）  弹窗类型
                content: form_dom,
                btn: ['确认', '取消'],
                shade: 0.9,  //遮罩层透明度
                shadeClose: false, //取消点击遮罩层关闭
                area: area_info,
                anim: 1,
                maxmin: true,
                fixed: true,
                yes: function(index, layero){
                    layui.form.on(sub_btn, function(data){
                    	if(data.field.id == ''){
                    		data.field.createTime = now;
                    	}
                    	data.field.updateTime = now;
                    	if(data_index == 6){
                    		var info = $('#LAY_layedit_1').contents().find('body').html();
                    		data.field.info = info;
                    	}
                    	console.log(data.field);
                    	$.ajax({
                    		url: data_url,
                    		type: 'POST',
                    		data: data.field,
                    		success: function(res){
                    			if(typeof res != 'object'){
                    				res = eval('('+ res +')');
                    			}
                    			if(res.success == 1){
                    				layer.close(index);
                    				var table_dom = 'table_' + data_index;
                    				layui.table.reload(table_dom);
                    			}
                    			layer.alert(res.msg, {
                                    title: '温馨提示'
                                })
                    		},
                    		error: function(){
                    			layer.alert('连接服务器失败!', {
                                    title: '温馨提示'
                                })
                    		}
                    	})
                        
                        return false;
                    });
                    form_dom.find('button').click();
                },
                btn2: function(index, layero){
                    // form_dom.find('form')[0].reset();
                    layer.close(index);
                },
                end: function(){
                    form_dom.find('form')[0].reset();
                    form_dom.find('input[name=id]').val('');
                    form_dom.find('img').attr('src', '');
                    form_dom.hide();
                }
            });

            if(table_data){
                $.each(table_data, function(key, value){
                	form_dom.find('input[name="'+key+'"]').val(value);
                	if(key == 'sex'){
                		form_dom.find('input[name="sex"][value='+value+']').attr("checked", true);
                	}else if(key == 'info'){
                		if(data_index == 6){
                    		var info = $('#LAY_layedit_1').contents().find('body').html(value);
                    	}
                	}else if(key == 'img'){
                		if(data_index == 6){
                			var img_url = '/Manager/images/'+value;
                			$('#movie_img').attr('src', img_url);
                		}
                	}
                    
                })
            }
        }
        
    }

    var page_info = {
        1: '管理信息', 2: '会员管理', 3: '购票管理', 4: '影片产地', 5: '影片类型', 6: '影片信息', 7: '影评管理',
        8: '影院管理', 9: '影厅管理', 10: '排片管理', 11: '留言管理',
    }
    $.each(page_info, function(i, val){
        bind_table_tool(i);
        // 表单提交事件
    })
    var lay_out = $('.other-info .fa-sign-out');
    lay_out.on('click', function(){
        window.location.href = '/Manager/admin/adminLogin.jsp'
    })
});