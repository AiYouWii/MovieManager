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
import com.manage.pojo.Hall;
import com.manage.service.hall.HallService;

@Controller
@RequestMapping("/Hall")
public class HallController {
	
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(HallController.class);
	
	@Resource
	private HallService cs;
	
	/**
	 * [insertMovieType 新增影厅]
	 * @param  v [description]
	 * @return   [description]
	 */
	@RequestMapping(value="/insertHall",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject insertHall(Hall pa){
		JSONObject json = new JSONObject();
		try{
			boolean flag = cs.insertHall(pa);
			if(flag){
				json.put("msg", "添加影厅成功");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "添加影厅失败");
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
	 * [updateHall 更新影厅]
	 * @param  a [description]
	 * @return   [description]
	 * 
	 */
	@RequestMapping(value="/updateHall",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject updateHall(Hall pa){
		JSONObject json = new JSONObject();
		try{
			boolean flag = cs.updateHall(pa);
			if(flag){
				json.put("msg", "修改影厅成功");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "修改影厅失败");
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
	 * [deleteHallById 根据id删除影厅]
	 * @param  id [description]
	 * @return    [description]
	 */
	@RequestMapping(value = "/deleteHallById",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteHallById(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		try{
			boolean flag = cs.deleteHallById(id);
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
	@RequestMapping(value = "/getHallInfo",method=RequestMethod.GET)
	@ResponseBody
	public JSONObject getHallInfo(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		JSONObject json = new JSONObject();
		List<Hall> v = null;
		
		// model.addAttribute(v);
		try{
			int startRow=0;
			
			if (page!=1) {
				startRow=(page-1)*limit;            
			}
			v = cs.getHallInfo(startRow, 9999);
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
