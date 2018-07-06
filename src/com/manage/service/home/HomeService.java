package com.manage.service.home;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.*;
public interface HomeService {
	
	public Person userLogin(@Param("user")String user, @Param("pass")String pass);
	
	//查看所有电影信息
	public List<Movie> getMovieInfo();
	
	//根据电影ID查询电影相关的数据
	public Movie getMovieInfoById(@Param("id")Integer id);
	
	//根据电影id查询影评内容
	public List<Comment> getCommentByMId(@Param("id")Integer id);
	
	//根据电影id查询排片内容
	public List<MovieAction> getMovieActionByMId(@Param("id")Integer id);
	
	public Person checkPhone(@Param("user")String user);
	
	public boolean register(Person p);
	
}
