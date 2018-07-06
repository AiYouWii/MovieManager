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
import com.manage.pojo.MovieType;
import com.manage.service.movietype.MovieTypeService;

@Controller
@RequestMapping("/MovieType")
public class MovieTypeController {
	
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(MovieTypeController.class);
	
	@Resource
	private MovieTypeService ms;
	
	/**
	 * [insertMovieType 新增电影类型]
	 * @param  v [description]
	 * @return   [description]
	 */
	@RequestMapping(value="/insertMovieType",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject insertMovieType(MovieType pa){
		JSONObject json = new JSONObject();
		try{
			boolean flag = ms.insertMovieType(pa);
			if(flag){
				json.put("msg", "添加电影类型成功");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "添加电影类型失败");
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
	 * [updatePublishArea 更新电影类型]
	 * @param  a [description]
	 * @return   [description]
	 * 
	 */
	@RequestMapping(value="/updateMovieType",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject updateMovieType(MovieType pa){
		JSONObject json = new JSONObject();
		try{
			boolean flag = ms.updateMovieType(pa);
			if(flag){
				json.put("msg", "修改电影类型成功");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "修改电影类型失败");
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
	 * [deletePublishAreaById 根据id删除电影类型]
	 * @param  id [description]
	 * @return    [description]
	 */
	@RequestMapping(value = "/deleteMovieTypeById",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteMovieTypeById(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		try{
			boolean flag = ms.deleteMovieTypeById(id);
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


	/**
	 * [getPublishAreaInfo 获取电影类型的列表信息]
	 * @param  model [description]
	 * @return       [description]
	 */
	@RequestMapping(value = "/getMovieTypeInfo",method=RequestMethod.GET)
	@ResponseBody
	public JSONObject getMovieTypeInfo(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		JSONObject json = new JSONObject();
		List<MovieType> v = null;
		try{
			int startRow=0;
			
			if (page!=1) {
				startRow=(page-1)*limit;            
			}
			v = ms.getMovieTypeInfo(startRow, 9999);
			if(v!=null){
				json.put("data", v);
				json.put("code", 0);
				json.put("count", v.size());
				json.put("msg", "获取数据成功");
				// return true;
			}else{
				// return false;
				json.put("code", "200");
				json.put("msg", "暂无数据");
				json.put("data", v);
			}
		}catch(Exception e){
			json.put("code", "500");
			json.put("msg", "获取数据服务失败");
			e.printStackTrace();
		}
		return json;
	}
}
