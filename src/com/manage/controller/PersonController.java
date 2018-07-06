package com.manage.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.manage.pojo.Person;
import com.manage.service.person.PersonService;
@Controller
@RequestMapping("/Person")
public class PersonController {
	
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(PersonController.class);
	
	/*
	 * ʵ����Service�㷽��
	 */
	@Resource
	private PersonService as;
	
	/*
	 * ��Ա��¼����
	 */
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public boolean VipLogin(@RequestParam("user")String user,@RequestParam("pass")String pass,HttpSession session){
		Person a=new Person();	
		a=as.VipLogin(user, pass);
		if(a!=null){
			session.setAttribute("vip", a);
			return true;
		}else{
			return false;
		}
	}
	
	/*
	 * �첽��ѯ�û��Ƿ���ڲ���
	 */
	@RequestMapping(value="/checkUserIsExist",method = RequestMethod.POST)
	public boolean checkUserIsExist(@RequestParam String user,HttpServletResponse response){
		//��ȡҳ��Ĳ���
		response.setContentType("text/html;charset=utf-8");
		//���÷���㷽��
		boolean flag=as.checkUserIsExist(user);
		return flag;
	}
	
	/**
	 * [getUserInfoById ͨ���û�id��ȡ�û���Ϣ]
	 * @param  id       [description]
	 * @param  response [description]
	 * @return          [description]
	 */
	@RequestMapping(value="/getUserInfoById")
	public Person getUserInfoById(@RequestParam("id") String id, HttpServletResponse response){
		Person a=new Person();	
		a=as.getUserInfoById(id);
		if(a!=null){
//			session.setAttribute("vip", a);
			return a;
		}else{
			return null;
		}
	}

	/*
	 * ����Ա�˳�
	 */
	@RequestMapping(value="/PersonOut")
	public String PersonOut(HttpSession session) {
		if(session!=null){
			session.invalidate();
		}
		return "redirect:/personLogin.jsp";
	}

	/**
	 * [getUserInfo ��ҳ��ѯ�û���Ϣ]
	 * @param  currentPage [description]
	 * @param  model       [description]
	 * @return             [description]
	 */
	@RequestMapping(value="/getUserInfo",method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getUserInfo(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		JSONObject json = new JSONObject();
		List<Person> pageBean = null;
		try{
			int startRow=0;
			
			if (page!=1) {
				startRow=(page-1)*limit;            
			}
			pageBean=as.getUserInfo(startRow, 9999);
			if(pageBean!=null){
				json.put("data", pageBean);
				json.put("code", 0);
				json.put("count", pageBean.size());
				json.put("msg", "��ȡ���ݳɹ�");
				// return true;
			}else{
				// return false;
				json.put("code", "200");
				json.put("msg", "��������");
				json.put("data", pageBean);
			}
		}catch(Exception e){
			json.put("code", "500");
			json.put("msg", "��ȡ���ݷ���ʧ��");
			e.printStackTrace();
		}
		return json;
    }

    /**
     * [insertPerson �����û�]
     * @param  p [�û���Ϣ]
     * @return   [�Ƿ����ɹ�]
     */
    @RequestMapping(value = "/insertPerson",method = RequestMethod.POST)
    @ResponseBody
	public JSONObject insertPerson(Person p){
    	JSONObject json = new JSONObject();
		try{
			boolean flag = as.insertPerson(p);
			if(flag){
				json.put("msg", "��ӻ�Ա�ɹ�");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "��ӻ�Աʧ��");
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
	 * [updatePerson �޸Ĺ���Ա]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/updatePerson",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updatePerson(Person a){
		JSONObject json = new JSONObject();
		try{
			boolean flag = as.updatePerson(a);
			if(flag){
				json.put("msg", "�޸Ļ�Ա��Ϣ�ɹ�");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "�޸Ļ�Ա��Ϣʧ��");
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
	 * [deletePersonById ���ݹ���Ա��idɾ������Ա]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/deletePersonById",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deletePersonById(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		try{
			boolean flag = as.deletePersonById(id);
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
