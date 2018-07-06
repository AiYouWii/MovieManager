package com.manage.service.movie;

import com.manage.pojo.Movie;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MovieService {
	
	//按id来查询电影信息
	public Movie getMovieInfoById(String id);

	public Integer selectMovieCount();

	public List<Movie> getMovieInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//插入用户信息
	public boolean insertMovie(Movie p);
	
	//修改电影信息
	public boolean updateMovie(Movie p);

	//根据电影id删除电影
	public boolean deleteMovieById(Integer id);
}
