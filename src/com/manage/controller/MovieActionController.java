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
	 * ʵ����Service�㷽��
	 */
	@Resource
	private MovieActionService mas;
	
	/**
	 * [getMovieActionInfo ��ҳ��ѯ��Ƭ��Ϣ]
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
				json.put("msg", "��ȡ���ݳɹ�");
				// return true;
			}else{
				// return false;
				json.put("code", "200");
				json.put("msg", "��������");
				json.put("data", m);
			}
		}catch(Exception e){
			json.put("code", "500");
			json.put("msg", "��ȡ���ݷ���ʧ��");
			e.printStackTrace();
		}
        return json;
    }

    /**
     * [insertMovieAction ������Ϣ]
     * @param  p [��Ӱ��Ϣ]
     * @return   [�Ƿ����ɹ�]
     */
    @RequestMapping(value = "/insertMovieAction",method = RequestMethod.POST)
    @ResponseBody
	public JSONObject insertMovieAction(MovieAction p){
    	JSONObject json = new JSONObject();
		try{
			boolean flag = mas.insertMovieAction(p);
			if(flag){
				json.put("msg", "�����Ƭ��Ϣ�ɹ�");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "�����Ƭ��Ϣʧ��");
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
	 * [updateMovieAction �޸���Ϣ]
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
				json.put("msg", "�޸���Ƭ��Ϣ�ɹ�");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "�޸���Ƭ��Ϣʧ��");
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
}
