package com.manage.controller;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.manage.pojo.Admin;
import com.manage.service.admin.AdminService;
@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(AdminController.class);
	
	/*
	 * 实例化Service层方法
	 */
	@Resource
	private AdminService as;
	
	/*
	 * 管理员登录操作
	 */
	@RequestMapping(value="/AdminLogin",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject adminLogin(@RequestParam("user")String user,@RequestParam("pass")String pass,HttpSession session){
		JSONObject json = new JSONObject();
		Admin a=new Admin();
		try{
			a=as.adminLogin(user, pass);
			if(a!=null){
				session.setAttribute("admin", a);
				json.put("status", "1");
				// return true;
			}else{
				// return false;
				json.put("status", "0");
			}
		}catch(Exception e){
			json.put("status", "0");
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * [getAdminList 获取所有的管理员]
	 * @param  model [description]
	 * @return       [返回管理员信息列表]
	 */
	@RequestMapping(value = "/getAdminList",method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getAdminList(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		JSONObject json = new JSONObject();
		List<Admin> admin = null;
		try{
			int startRow=0;
	        
	        if (page!=1) {
	        	startRow=(page-1)*limit;            
	        }
			admin=as.getAdminList(startRow, 9999);
			if(admin!=null){
				json.put("data", admin);
				json.put("code", 0);
				json.put("count", admin.size());
				json.put("msg", "获取数据成功");
				// return true;
			}else{
				// return false;
				json.put("code", "200");
				json.put("msg", "暂无数据");
				json.put("data", admin);
			}
		}catch(Exception e){
			json.put("code", "500");
			json.put("msg", "获取数据服务失败");
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * [insertAdmin 插入管理员]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/insertAdmin",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject insertAdmin(Admin a){
		JSONObject json = new JSONObject();
		try{
			boolean flag = as.insertAdmin(a);
			if(flag){
				json.put("msg", "添加管理员成功");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "添加管理员失败");
				json.put("success", "0");
			}
		}catch(Exception e){
			json.put("success", "500");
			json.put("msg", "获取数据服务失败");
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * [updateAdmin 修改管理员]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/updateAdmin",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updateAdmin(Admin a){
		
		JSONObject json = new JSONObject();
		try{
			boolean flag = as.updateAdmin(a);
			if(flag){
				json.put("msg", "修改管理员成功");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "修改管理员失败");
				json.put("success", "0");
			}
		}catch(Exception e){
			json.put("success", "500");
			json.put("msg", "获取数据服务失败");
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * [deleteAdminById 根据管理员的id删除管理员]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/deleteAdminById",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteAdminById(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		try{
			boolean flag = as.deleteAdminById(id);
			if(flag){
				json.put("success", "1");
				json.put("msg", "删除数据成功");
			}else{
				json.put("success", "0");
				json.put("msg", "删除数据失败");
			}
		}catch(Exception e){
			json.put("success", "0");
			json.put("msg", "获取数据服务失败");
			e.printStackTrace();
		}
		return json;
	}

	@RequestMapping(value = "/getAdminInfoById",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getAdminInfoById(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		Admin ad = new Admin();
		try{
			ad=as.getAdminInfoById(id);
			if(ad!=null){
				json.put("success", "1");
				json.put("data", ad);
				json.put("msg", "查询数据成功");
			}else{
				json.put("success", "0");
				json.put("msg", "查询数据失败");
			}
		}catch(Exception e){
			json.put("success", "500");
			json.put("msg", e);
			e.printStackTrace();
		}
		return json;
	}
}
