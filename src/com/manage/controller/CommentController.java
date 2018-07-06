package com.manage.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.manage.pojo.Comment;
import com.manage.pojo.Person;
import com.manage.service.comment.CommentService;

@Controller
@RequestMapping("/Comment")
public class CommentController {
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(CommentController.class);
	
	@Resource
	private CommentService cs;
	
	/**
	 * [insertComment ����Ӱ��]
	 * @param  v [description]
	 * @return   [description]
	 */
	@RequestMapping(value="/insertComment",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject insertComment(Comment pa, HttpSession session){
		JSONObject json = new JSONObject();
		try{
			Person p = (Person)session.getAttribute("user");
			if(p!= null){
				Integer user_id = p.getId();
				pa.setUser_id(user_id);
				boolean flag = cs.insertComment(pa);
				if(flag){
					json.put("msg", "����Ӱ���ɹ�");
					json.put("success", "1");
					// return true;
				}else{
					// return false;
					json.put("msg", "����Ӱ��ʧ��");
					json.put("success", "0");
				}
			}else{
				json.put("msg", "������¼֮���ٷ���Ӱ��!");
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
	 * [updateComment ����Ӱ��]
	 * @param  a [description]
	 * @return   [description]
	 * 
	 */
	@RequestMapping(value="/updateComment",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject updateComment(Comment pa){
		JSONObject json = new JSONObject();
		try{
			boolean flag = cs.updateComment(pa);
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
	 * [deleteCommentById ����idɾ��Ӱ��]
	 * @param  id [description]
	 * @return    [description]
	 */
	@RequestMapping(value = "/deleteCommentById",method=RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteCommentById(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		try{
			boolean flag = cs.deleteCommentById(id);
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
	 * [getCommentInfo ��ȡӰ�����б���Ϣ]
	 * @param  model [description]
	 * @return       [description]
	 */
	@RequestMapping(value = "/getCommentInfo",method=RequestMethod.GET)
	@ResponseBody
	public JSONObject getCommentInfo(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		JSONObject json = new JSONObject();
		List<Comment> v = null;
		
		// model.addAttribute(v);
		try{
			int startRow=0;
			
			if (page!=1) {
				startRow=(page-1)*limit;            
			}
			v = cs.getCommentInfo(startRow, 9999);
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
