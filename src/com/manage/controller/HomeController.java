package com.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.manage.service.home.HomeService;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSONObject;
import com.manage.pojo.Comment;
import com.manage.pojo.Movie;
import com.manage.pojo.MovieAction;
import com.manage.pojo.Person;

import org.apache.log4j.Logger;
@Controller
@RequestMapping("/home")
public class HomeController {
	
	private Logger logger = Logger.getLogger(HomeController.class);
	
	/*
	 * 实例化Service层方法
	 */
	@Resource
	private HomeService ms;
	
	@RequestMapping(value = "/index",method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView mav = new ModelAndView();
		logger.debug("--------------------->>");
		List<Movie> movieList = null;
		movieList=ms.getMovieInfo();
		logger.debug(movieList);
		mav.setViewName("/frontend/index");
		mav.addObject("movieList",movieList);
		return mav;
	}
	
	@RequestMapping(value="/userLogin",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject adminLogin(@RequestParam("user")String user,@RequestParam("pass")String pass,HttpSession session){
		JSONObject json = new JSONObject();
		Person p=new Person();
		try{
			p=ms.userLogin(user, pass);
			if(p!=null){
				session.setAttribute("user", p);
				json.put("status", "1");
				json.put("msg", "登录成功哦!");
			}else{
				json.put("status", "0");
				json.put("msg", "唔,您的账号密码错误!");
			}
		}catch(Exception e){
			json.put("status", "0");
			json.put("msg", "哦呦,服务器连接失败了!");
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value="/checkLogin",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject checkLogin(HttpSession session){
		JSONObject json = new JSONObject();
		Person p = (Person)session.getAttribute("user");
		logger.debug("--------------------->>" + p);
		if(p==null){
			json.put("success", 0);
			json.put("msg", "请您先登录系统哦!");
		}else{
			json.put("success", 1);
			json.put("data", p);
		}
		return json;
	}
	
	@RequestMapping(value = "/getMovieInfoById",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getMovieInfoById(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		Movie mv = null;
		List<Comment> cmList = null;
		// model.addAttribute(v);
		try{
			mv = ms.getMovieInfoById(id);
			cmList = ms.getCommentByMId(id);
			if(mv!=null){
				json.put("movie", mv);
				json.put("Comment", cmList);
				json.put("success", 1);
				json.put("msg", "查询成功!");
				// return true;
			}else{
				// return false;
				json.put("success", 0);
				json.put("msg", "暂无数据");
			}
		}catch(Exception e){
			json.put("success", "500");
			json.put("msg", "连接服务器失败");
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value = "/getMovieActionByMId",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject getMovieActionByMId(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		List<MovieAction> mvList = null;
		try{
			mvList = ms.getMovieActionByMId(id);
			if(mvList!=null){
				json.put("movieAction", mvList);
				json.put("success", 1);
				json.put("msg", "查询成功!");
				// return true;
			}else{
				// return false;
				json.put("success", 0);
				json.put("msg", "暂无数据");
			}
		}catch(Exception e){
			json.put("success", "500");
			json.put("msg", "连接服务器失败");
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value="/PersonOut", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject PersonOut(HttpSession session) {
		JSONObject json = new JSONObject();
		Person p = (Person)session.getAttribute("user");
		if(p!=null){
			session.setAttribute("user", null);
		}
		
		json.put("status", 1);
		json.put("msg", "退出成功!!");
		
		return json;
	}
	
	@RequestMapping(value="/checkPhone", method=RequestMethod.POST)
	@ResponseBody
	public JSONObject checkPhone(@RequestParam("user")String user) {
		JSONObject json = new JSONObject();
		Person p=new Person();
		try{
			p=ms.checkPhone(user);
			if(p!=null){
				json.put("status", "1");
				json.put("msg", "该手机号已被注册!");
			}else{
				json.put("status", "0");
				json.put("msg", "可以注册");
			}
		}catch(Exception e){
			json.put("status", "1");
			json.put("msg", "哦呦,服务器连接失败了!");
			e.printStackTrace();
		}
		return json;
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
	public JSONObject register(Person p){
    	JSONObject json = new JSONObject();
		try{
			boolean flag = ms.register(p);
			if(flag){
				json.put("msg", "注册成功!!");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "注册失败");
				json.put("success", "0");
			}
		}catch(Exception e){
			json.put("success", "500");
			json.put("msg", "连接服务器失败");
			e.printStackTrace();
		}
		return json;
	}
}
