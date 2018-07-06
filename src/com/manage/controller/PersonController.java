package com.manage.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.manage.pojo.Person;
import com.manage.service.person.PersonService;
@Controller
@RequestMapping("/Person")
public class PersonController {
	
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(PersonController.class);
	
	/*
	 * 实例化Service层方法
	 */
	@Resource
	private PersonService as;
	
	/*
	 * 会员登录操作
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public boolean VipLogin(@RequestParam("user")String user,@RequestParam("pass")String pass,HttpSession session){
		Person a=new Person();	
		a=as.VipLogin(user, pass);
		if(a!=null){
			session.setAttribute("vip", a);
			return true;
		}else{
			return false;
		}
	}
	
	/*
	 * 异步查询用户是否存在操作
	 */
	@RequestMapping(value="/checkUserIsExist",method = RequestMethod.POST)
	public boolean checkUserIsExist(@RequestParam String user,HttpServletResponse response){
		//获取页面的参数
		response.setContentType("text/html;charset=utf-8");
		//调用服务层方法
		boolean flag=as.checkUserIsExist(user);
		return flag;
	}
	
	/**
	 * [getUserInfoById 通过用户id获取用户信息]
	 * @param  id       [description]
	 * @param  response [description]
	 * @return          [description]
	 */
	@RequestMapping(value="/getUserInfoById")
	public Person getUserInfoById(@RequestParam("id") String id, HttpServletResponse response){
		Person a=new Person();	
		a=as.getUserInfoById(id);
		if(a!=null){
//			session.setAttribute("vip", a);
			return a;
		}else{
			return null;
		}
	}

	/*
	 * 管理员退出
	 */
	@RequestMapping(value="/PersonOut")
	public String PersonOut(HttpSession session) {
		if(session!=null){
			session.invalidate();
		}
		return "redirect:/personLogin.jsp";
	}

	/**
	 * [getUserInfo 分页查询用户信息]
	 * @param  currentPage [description]
	 * @param  model       [description]
	 * @return             [description]
	 */
	@RequestMapping(value="/getUserInfo",method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getUserInfo(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		JSONObject json = new JSONObject();
		List<Person> pageBean = null;
		try{
			int startRow=0;
			
			if (page!=1) {
				startRow=(page-1)*limit;            
			}
			pageBean=as.getUserInfo(startRow, 9999);
			if(pageBean!=null){
				json.put("data", pageBean);
				json.put("code", 0);
				json.put("count", pageBean.size());
				json.put("msg", "获取数据成功");
				// return true;
			}else{
				// return false;
				json.put("code", "200");
				json.put("msg", "暂无数据");
				json.put("data", pageBean);
			}
		}catch(Exception e){
			json.put("code", "500");
			json.put("msg", "获取数据服务失败");
			e.printStackTrace();
		}
		return json;
    }

    /**
     * [insertPerson 插入用户]
     * @param  p [用户信息]
     * @return   [是否插入成功]
     */
    @RequestMapping(value = "/insertPerson",method = RequestMethod.POST)
    @ResponseBody
	public JSONObject insertPerson(Person p){
    	JSONObject json = new JSONObject();
		try{
			boolean flag = as.insertPerson(p);
			if(flag){
				json.put("msg", "添加会员成功");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "添加会员失败");
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
	 * [updatePerson 修改管理员]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/updatePerson",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updatePerson(Person a){
		JSONObject json = new JSONObject();
		try{
			boolean flag = as.updatePerson(a);
			if(flag){
				json.put("msg", "修改会员信息成功");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "修改会员信息失败");
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
	 * [deletePersonById 根据管理员的id删除管理员]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/deletePersonById",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deletePersonById(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		try{
			boolean flag = as.deletePersonById(id);
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
}
