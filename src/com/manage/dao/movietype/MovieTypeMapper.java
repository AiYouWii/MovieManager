package com.manage.dao.movietype;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.manage.pojo.MovieType;

public interface MovieTypeMapper {
	
	public List<MovieType> getMovieTypeInfo(@Param("start")Integer start, @Param("size")Integer size);
	
	//插入电影类型信息
	public boolean insertMovieType(MovieType p);
	
	//修改电影类型信息
	public boolean updateMovieType(MovieType p);

	//根据电影类型id删除电影类型
	public boolean deleteMovieTypeById(@Param("id")Integer id);

}
