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
	 * [insertComment 新增影评]
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
					json.put("msg", "发表影评成功");
					json.put("success", "1");
					// return true;
				}else{
					// return false;
					json.put("msg", "发表影评失败");
					json.put("success", "0");
				}
			}else{
				json.put("msg", "请您登录之后再发表影评!");
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
	 * [updateComment 更新影评]
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
				json.put("msg", "修改影评成功");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "修改影评失败");
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
	 * [deleteCommentById 根据id删除影评]
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
	 * [getCommentInfo 获取影评的列表信息]
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
