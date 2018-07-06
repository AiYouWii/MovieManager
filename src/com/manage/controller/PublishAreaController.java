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
import com.manage.pojo.PublishArea;
import com.manage.service.publish.PublishAreaService;

@Controller
@RequestMapping("/PublishArea")
public class PublishAreaController {
	
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(PublishAreaController.class);
	
	@Resource
	private PublishAreaService ps;
	
	/**
	 * [insertPublishArea ������������]
	 * @param  v [description]
	 * @return   [description]
	 */
	@RequestMapping(value="/insertPublishArea",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject insertPublishArea(PublishArea pa){
		JSONObject json = new JSONObject();
		try{
			boolean flag = ps.insertPublishArea(pa);
			if(flag){
				json.put("msg", "��ӷ��������ɹ�");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "��ӷ�������ʧ��");
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
	 * [updatePublishArea ���·�������]
	 * @param  a [description]
	 * @return   [description]
	 * 
	 */
	@RequestMapping(value="/updatePublishArea",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject updatePublishArea(PublishArea pa){
		JSONObject json = new JSONObject();
		try{
			boolean flag = ps.updatePublishArea(pa);
			if(flag){
				json.put("msg", "�޸ķ��������ɹ�");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "�޸ķ�������ʧ��");
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
	 * [deletePublishAreaById ����idɾ����������]
	 * @param  id [description]
	 * @return    [description]
	 */
	@RequestMapping(value = "/deletePublishAreaById",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject deletePublishAreaById(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		try{
			boolean flag = ps.deletePublishAreaById(id);
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
	 * [getPublishAreaInfo ��ȡ�����������б���Ϣ]
	 * @param  model [description]
	 * @return       [description]
	 */
	@RequestMapping(value = "/getPublishAreaInfo",method=RequestMethod.GET)
	@ResponseBody
	public JSONObject getPublishAreaInfo(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		JSONObject json = new JSONObject();
		List<PublishArea> v = null;
		
		try{
			int startRow=0;
			
			if (page!=1) {
				startRow=(page-1)*limit;            
			}
			v = ps.getPublishAreaInfo(startRow, 9999);
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
