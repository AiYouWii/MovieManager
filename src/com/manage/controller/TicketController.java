package com.manage.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.manage.pojo.Person;
import com.manage.pojo.Ticket;
import com.manage.service.ticket.TicketService;

@Controller
@RequestMapping("/Ticket")
public class TicketController {
	
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(TicketController.class);
	
	/*
	 * ʵ����Service�㷽��
	 */
	@Resource
	private TicketService ts;


	/**
	 * [getTicketInfo ��ҳ��ѯ������Ϣ]
	 * @param  currentPage [description]
	 * @param  model       [description]
	 * @return             [description]
	 */
	@RequestMapping(value="/getTicketInfo", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getTicketInfo(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		JSONObject json = new JSONObject();
		List<Ticket> m = null;
		try{
			int startRow=0;
			
			if (page!=1) {
				startRow=(page-1)*limit;            
			}
//			m=ms.getMovieInfo(startRow, limit);
			m=ts.getTicketInfo(startRow, 9999);
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
     * [insertTicket �����Ӱ��Ϣ]
     * @param  p [��Ӱ��Ϣ]
     * @return   [�Ƿ����ɹ�]
     */
    @RequestMapping(value = "/insertTicket",method = RequestMethod.POST)
    @ResponseBody
	public JSONObject insertTicket(Ticket p, HttpSession session){
    	JSONObject json = new JSONObject();
		try{
			Person per = (Person)session.getAttribute("user");
			if(per!= null){
				Integer user_id = per.getId();
				p.setUser_id(user_id);
				boolean flag = ts.insertTicket(p);
				if(flag){
					json.put("msg", "��Ӷ�����Ϣ�ɹ�");
					json.put("success", "1");
					// return true;
				}else{
					// return false;
					json.put("msg", "��Ӷ�����Ϣʧ��");
					json.put("success", "0");
				}
			}else{
				json.put("msg", "������¼֮���ٹ�Ʊ!");
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
	 * [updateTicket �޸ĵ�Ӱ��Ϣ]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/updateTicket",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updateTicket(Ticket a){
		JSONObject json = new JSONObject();
		try{
			boolean flag = ts.updateTicket(a);
			if(flag){
				json.put("msg", "�޸Ķ�����Ϣ�ɹ�");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "�޸Ķ�����Ϣʧ��");
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
	 * [deleteTicketById ]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/deleteTicketById",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteTicketById(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		try{
			boolean flag = ts.deleteTicketById(id);
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
	
	@RequestMapping(value="/getTicketInfoByUid", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject getTicketInfoByUid(@RequestParam("user_id")Integer user_id){
		JSONObject json = new JSONObject();
		List<Ticket> m = null;
		try{
			m=ts.getTicketInfoByUid(user_id);
			if(m!=null){
				json.put("data", m);
				json.put("success", 1);
				json.put("msg", "��ȡ���ݳɹ�");
				// return true;
			}else{
				// return false;
				json.put("success", 0);
				json.put("msg", "��������");
				json.put("data", m);
			}
		}catch(Exception e){
			json.put("success", "500");
			json.put("msg", "��ȡ���ݷ���ʧ��");
			e.printStackTrace();
		}
        return json;
    }
}
