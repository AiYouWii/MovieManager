package com.manage.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.manage.pojo.Vip;
import com.manage.service.vip.VipService;

@Controller
@RequestMapping("/vip")
public class VipController {
	
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(VipController.class);
	
	@Resource
	private VipService VipService;
	
	/**
	 * [insertVip ����vip����]
	 * @param  v [description]
	 * @return   [description]
	 */
	@RequestMapping(value="/insertVip",method=RequestMethod.POST)
	public boolean insertVip(Vip v){
		boolean flag = VipService.insertVip(v);
		return flag;
	}
	
	/**
	 * [updateVip ����vip����]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value="/updateVip",method=RequestMethod.POST)
	public boolean updateVip(Vip a){
		boolean flag = VipService.updateVip(a);
		return flag;
	}

	/**
	 * [deleteVipById ����idɾ��vip����]
	 * @param  id [description]
	 * @return    [description]
	 */
	@RequestMapping(value = "/deleteVipById",method=RequestMethod.POST)
	public boolean deleteVipById(@RequestParam("id")Integer id){
		boolean flag = VipService.deleteVipById(id);
		return flag;
	}

	/**
	 * [getVipInfoById ����id��ȡ��Ա��Ϣ]
	 * @param  id [description]
	 * @return    [description]
	 */
	@RequestMapping(value = "/getVipInfoById",method=RequestMethod.POST)
	public Vip getVipInfoById(@RequestParam("id")Integer id){
		Vip v = new Vip();
		v = VipService.getVipInfoById(id);
		return v;
	}

	/**
	 * [getVipInfo ��ȡ��Ա���б���Ϣ]
	 * @param  model [description]
	 * @return       [description]
	 */
	@RequestMapping(value = "/getVipInfo",method=RequestMethod.GET)
	public JSONObject getVipInfo(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		JSONObject json = new JSONObject();
		List<Vip> v = null;
		
		try{
			int startRow=0;
			
			if (page!=1) {
				startRow=(page-1)*limit;            
			}
			v = VipService.getVipInfo(startRow, limit);
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
