package com.manage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.manage.pojo.MovieAction;
import com.manage.service.movieaction.MovieActionService;

@Controller
@RequestMapping("/MovieAction")
public class MovieActionController {
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(MovieActionController.class);
	
	/*
	 * 实例化Service层方法
	 */
	@Resource
	private MovieActionService mas;
	
	/**
	 * [getMovieActionInfo 分页查询排片信息]
	 * @param  currentPage [description]
	 * @param  model       [description]
	 * @return             [description]
	 */
	@RequestMapping(value="/getMovieActionInfo", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getMovieActionInfo(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		JSONObject json = new JSONObject();
		List<MovieAction> m = null;
		try{
			int startRow=0;
			
			if (page!=1) {
				startRow=(page-1)*limit;            
			}
//			m=ms.getMovieInfo(startRow, limit);
			m=mas.getMovieActionInfo(startRow, 9999);
			if(m!=null){
				json.put("data", m);
				json.put("code", 0);
				json.put("count", m.size());
				json.put("msg", "获取数据成功");
				// return true;
			}else{
				// return false;
				json.put("code", "200");
				json.put("msg", "暂无数据");
				json.put("data", m);
			}
		}catch(Exception e){
			json.put("code", "500");
			json.put("msg", "获取数据服务失败");
			e.printStackTrace();
		}
        return json;
    }

    /**
     * [insertMovieAction 插入信息]
     * @param  p [电影信息]
     * @return   [是否插入成功]
     */
    @RequestMapping(value = "/insertMovieAction",method = RequestMethod.POST)
    @ResponseBody
	public JSONObject insertMovieAction(MovieAction p){
    	JSONObject json = new JSONObject();
		try{
			boolean flag = mas.insertMovieAction(p);
			if(flag){
				json.put("msg", "添加排片信息成功");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "添加排片信息失败");
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
	 * [updateMovieAction 修改信息]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/updateMovieAction",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updateTicket(MovieAction a){
		JSONObject json = new JSONObject();
		try{
			boolean flag = mas.updateMovieAction(a);
			if(flag){
				json.put("msg", "修改排片信息成功");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "修改排片信息失败");
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
	 * [deleteMovieActionById ]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/deleteMovieActionById",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteMovieActionById(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		try{
			boolean flag = mas.deleteMovieActionById(id);
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
