package com.manage.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.manage.pojo.Movie;
import com.manage.service.movie.MovieService;

@Controller
@RequestMapping("/Movie")
public class MovieController {
	
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(MovieController.class);
	
	/*
	 * ʵ����Service�㷽��
	 */
	@Resource
	private MovieService ms;
	
	/**
	 * [getMovieInfoById ͨ����Ӱid��ȡ��Ӱ��Ϣ]
	 * @param  id       [description]
	 * @param  response [description]
	 * @return          [description]
	 */
	@RequestMapping(value="/getMovieInfoById")
	public Movie getMovieInfoById(@RequestParam String id, HttpServletResponse response){
		Movie a=new Movie();	
		a=ms.getMovieInfoById(id);
		if(a!=null){
			// session.setAttribute("vip", a);
			return a;
		}else{
			return null;
		}
	}


	/**
	 * [getMovieInfo ��ҳ��ѯ��Ӱ��Ϣ]
	 * @param  currentPage [description]
	 * @param  model       [description]
	 * @return             [description]
	 */
	@RequestMapping(value="/getMovieInfo", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject getMovieInfo(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit){
		JSONObject json = new JSONObject();
		List<Movie> m = null;
		try{
			int startRow=0;
			
			if (page!=1) {
				startRow=(page-1)*limit;            
			}
//			m=ms.getMovieInfo(startRow, limit);
			m=ms.getMovieInfo(startRow, 9999);
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
     * [insertMovie �����Ӱ��Ϣ]
     * @param  p [��Ӱ��Ϣ]
     * @return   [�Ƿ����ɹ�]
     */
    @RequestMapping(value = "/insertMovie",method = RequestMethod.POST)
    @ResponseBody
	public JSONObject insertMovie(Movie p){
    	JSONObject json = new JSONObject();
		try{
			boolean flag = ms.insertMovie(p);
			if(flag){
				json.put("msg", "��ӵ�Ӱ��Ϣ�ɹ�");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "��ӵ�Ӱ��Ϣʧ��");
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
	 * [updateMovie �޸ĵ�Ӱ��Ϣ]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/updateMovie",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject updateMovie(Movie a){
		JSONObject json = new JSONObject();
		try{
			boolean flag = ms.updateMovie(a);
			if(flag){
				json.put("msg", "�޸ĵ�Ӱ��Ϣ�ɹ�");
				json.put("success", "1");
				// return true;
			}else{
				// return false;
				json.put("msg", "�޸ĵ�Ӱ��Ϣʧ��");
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
	 * [deleteMovieById ]
	 * @param  a [description]
	 * @return   [description]
	 */
	@RequestMapping(value = "/deleteMovieById",method = RequestMethod.POST)
	@ResponseBody
	public JSONObject deleteMovieById(@RequestParam("id")Integer id){
		JSONObject json = new JSONObject();
		try{
			boolean flag = ms.deleteMovieById(id);
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
	
	@RequestMapping(value = "/MovieImg", method = RequestMethod.POST)  
    @ResponseBody  
    public JSONObject test(MultipartFile file,HttpServletRequest request) throws IOException{  
		JSONObject json = new JSONObject();
        System.out.println("comming!");  
        try{
        	String path = request.getSession().getServletContext().getRealPath("/images");  
            System.out.println("path>>"+path);  
            long currentTime=System.currentTimeMillis();
            String fileName = currentTime + file.getOriginalFilename();
            System.out.println("fileName>>"+fileName);  
              
            File dir = new File(path, fileName);  
            System.out.println("dir.exists()>>"+dir.exists());  
            if(!dir.exists()){  
                dir.mkdirs();  
            }  
            System.out.println("dir.exists()>>"+dir.exists());  
//          MultipartFile�Դ��Ľ�������  
            file.transferTo(dir);  
        	json.put("success", 1);
        	json.put("img", fileName);
        	json.put("msg", "�ϴ��ɹ�!");
        	
        }catch(Exception e){
        	json.put("success", 0);
        	json.put("img", "");
        	json.put("msg", "�ϴ�ʧ��!");
        }
        
        return json;  
    }  
}
