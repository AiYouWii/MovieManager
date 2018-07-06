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
	 * [insertMovieType ����Ӱ��]
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
				json.put("msg", "���Ӱ���ɹ�");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "���Ӱ��ʧ��");
				json.put("success", "0");
			}
		}catch(Exception e){
			json.put("success", "500");
			json.put("msg", "��ȡ���ݷ���ʧ��");
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * [updateHall ����Ӱ��]
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
				json.put("msg", "�޸�Ӱ���ɹ�");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "�޸�Ӱ��ʧ��");
				json.put("success", "0");
			}
		}catch(Exception e){
			json.put("success", "500");
			json.put("msg", "��ȡ���ݷ���ʧ��");
			e.printStackTrace();
		}
		return json;
	}

	/**
	 * [deleteHallById ����idɾ��Ӱ��]
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
				json.put("msg", "ɾ�����ݳɹ�");
			}else{
				json.put("success", "0");
				json.put("msg", "ɾ������ʧ��");
			}
		}catch(Exception e){
			json.put("success", "0");
			json.put("msg", "��ȡ���ݷ���ʧ��");
			e.printStackTrace();
		}
		return json;
	}


	/**
	 * [getPublishAreaInfo ��ȡ��Ӱ���͵��б���Ϣ]
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
				json.put("msg", "��ȡ���ݳɹ�");
				// return true;
			}else{
				// return false;
				json.put("code", "200");
				json.put("msg", "��������");
				json.put("data", v);
			}
		}catch(Exception e){
			json.put("code", "500");
			json.put("msg", "��ȡ���ݷ���ʧ��");
			e.printStackTrace();
		}
		return json;
	}
}
