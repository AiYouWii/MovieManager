package com.manage.service.movieaction;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.MovieAction;

public interface MovieActionService {
	public List<MovieAction> getMovieActionInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//插入信息
	public boolean insertMovieAction(MovieAction p);
	
	//修改信息
	public boolean updateMovieAction(MovieAction p);

	//根据id删除
	public boolean deleteMovieActionById(Integer id);
}
