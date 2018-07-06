package com.manage.dao.movie;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.Movie;

public interface MovieMapper {
	
	//按id来查询电影信息
	public Movie getMovieInfoById(@Param("id")String id);

	/**
     * 分页操作，调用getUserInfo limit分页方法
     * @param map
     * @return
     */
	public List<Movie> getMovieInfo(@Param("start")Integer start, @Param("size")Integer size);

	/**
	 * [selectUserCount 查询电影总数]
	 * @return [description]
	 */
	public Integer selectMovieCount();

	//插入电影信息
	public boolean insertMovie(Movie p);
	
	//修改电影信息
	public boolean updateMovie(Movie p);

	//根据电影id删除电影
	public boolean deleteMovieById(@Param("id")Integer id);
}