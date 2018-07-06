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
	 * 实例化Service层方法
	 */
	@Resource
	private TicketService ts;


	/**
	 * [getTicketInfo 分页查询订单信息]
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
     * [insertTicket 插入电影信息]
     * @param  p [电影信息]
     * @return   [是否插入成功]
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
					json.put("msg", "添加订单信息成功");
					json.put("success", "1");
					// return true;
				}else{
					// return false;
					json.put("msg", "添加订单信息失败");
					json.put("success", "0");
				}
			}else{
				json.put("msg", "请您登录之后再购票!");
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
	 * [updateTicket 修改电影信息]
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
				json.put("msg", "修改订单信息成功");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "修改订单信息失败");
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
				json.put("msg", "获取数据成功");
				// return true;
			}else{
				// return false;
				json.put("success", 0);
				json.put("msg", "暂无数据");
				json.put("data", m);
			}
		}catch(Exception e){
			json.put("success", "500");
			json.put("msg", "获取数据服务失败");
			e.printStackTrace();
		}
        return json;
    }
}
