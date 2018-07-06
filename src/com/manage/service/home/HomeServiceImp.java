package com.manage.service.home;
import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import java.util.List;
import com.manage.dao.home.HomeMapper;
import com.manage.pojo.Comment;
import com.manage.pojo.Movie;
import com.manage.pojo.MovieAction;
import com.manage.pojo.Person;
@Service
public class HomeServiceImp implements HomeService{
	/*
	 * 实例化DAO层对象
	 */
	@Resource
	private HomeMapper hm;
	
	//用户登录
	@Override
	public Person userLogin(String user, String pass) {
		Person person=hm.userLogin(user, pass);
		return person;
	}
	
	//获取电影的列表
	@Override
	public List<Movie> getMovieInfo() {
		List<Movie> movieList=null;
		movieList=hm.getMovieInfo();
		return movieList;
	}
	
	//根据电影的ID获取电影的信息
	@Override
	public Movie getMovieInfoById(Integer id) {
		Movie movie=hm.getMovieInfoById(id);
		return movie;
	}
	
	//获取影评的列表
	@Override
	public List<Comment> getCommentByMId(Integer id) {
		List<Comment> commentList=null;
		commentList=hm.getCommentByMId(id);
		return commentList;
	}
	
	//获取排片的列表
	@Override
	public List<MovieAction> getMovieActionByMId(Integer id){
		List<MovieAction> mvaList=null;
		mvaList=hm.getMovieActionByMId(id);
		return mvaList;
	}
	
	public Person checkPhone(String user){
		Person person=hm.checkPhone(user);
		return person;
	}
	
	@Override
	public boolean register(Person p){
		// TODO Auto-generated method stub
		boolean flag = false;
		if(hm.register(p)){
			flag=true;
		}
		return flag;
	}
}
